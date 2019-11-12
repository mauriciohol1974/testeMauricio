package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.ProtestoTituloBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade de Consulta de Títulos
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>Fev / 2009</DD>
 * </DL>
 * 
 * @author Cristian Souza - Probank / REDEASP02
 */

public class ProtestConsultarFiltro extends ProtestEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {

            // Configurações para Mensagens e Telas de Erro e Sucesso
            configMsgSucessoErro(request);

            // Obtem informação para definir se o request veio de voltar ou se o
            // fluxo é normal
            String fluxo = getFluxo(request);

            // Recupera os beans
            ProtestoTituloBean protestoTituloFiltroBean = new ProtestoTituloBean();

            if (fluxo.equals(FLUXO_NORMAL)) {
                protestoTituloFiltroBean = (ProtestoTituloBean) protestoTituloFiltroBean.getRequestBean(request);
            } else {
                protestoTituloFiltroBean = (ProtestoTituloBean) protestoTituloFiltroBean.getSessionBean(request,
                        PROTESTO_TITULO_FILTRO_BEAN);

            }
            request.getSession().setAttribute(PROTESTO_TITULO_FILTRO_BEAN,
                    protestoTituloFiltroBean);
            request.getSession().setAttribute(PROTESTO_TITULO_DATA_BEAN,
                    protestoTituloFiltroBean);

            // Instancia o EJB que acessa o mainframe
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            // faz chamada da transacao de consulta BGSC
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_PROTESTO_CONSULTAR_TITULOS + usuarioBean.getCodigoUsuario().toUpperCase();
            List proTestList = handler.executeFixDataRecordsetTransaction(protestoTituloFiltroBean,
            		transUser);

            ProtestoTituloBean protestoTituloBean = (ProtestoTituloBean) ((BeanList) proTestList.get(0)).get(0);
            
            protestoTituloBean.setCodigoUnidadePv(protestoTituloFiltroBean.getCodigoUnidadePv());
            protestoTituloBean.setTipoConsulta(protestoTituloFiltroBean.getTipoConsulta());
            protestoTituloBean.setDiaProtesto(protestoTituloFiltroBean.getDiaProtesto());
            protestoTituloBean.setSelecaoRadio(protestoTituloFiltroBean.getSelecaoRadio());

            // lança os beans de dados fixos e array
            request.getSession().setAttribute(PROTESTO_TITULO_DATA_BEAN, protestoTituloBean);

            // pega a lista de beans parte variavel
            BeanList proTestBeanList = (BeanList) proTestList.get(1);

            // converte a lista em um array de beans
            ArrayList proTestArrayList = convertDataStructure(proTestBeanList.iterator());

            // lança os beans de dados de paginação
            request.getSession().setAttribute(PAGINACAO_LIST,
                    getPageHolder(proTestArrayList));
            request.setAttribute(PAGINACAO_PAGE, "0");

        } catch (Exception e) {
            throw e;
        }
        return PAGE_CONSULTAR;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_CONSULTAR_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_CONSULTAR_LISTAR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}
