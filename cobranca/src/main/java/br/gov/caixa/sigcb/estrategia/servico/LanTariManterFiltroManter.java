package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.LancamentoTarifaBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Lancamento de Tarifa
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>08/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */

public class LanTariManterFiltroManter extends LancamentoTarifaEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {

            // Configurações para Mensagens e Telas de Erro e Sucesso
            configMsgSucessoErro(request);

            // Obtem informação para definir se o request veio de voltar ou se o
            // fluxo é normal
            String fluxo = getFluxo(request);

            // Recupera os beans
            LancamentoTarifaBean lancamentoTarifaFiltroBean = new LancamentoTarifaBean();

            CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
            cedCabBean.newBean();

            if (fluxo.equals(FLUXO_NORMAL)) {
                lancamentoTarifaFiltroBean = (LancamentoTarifaBean) lancamentoTarifaFiltroBean.getRequestBean(request);
            } else {
                lancamentoTarifaFiltroBean = (LancamentoTarifaBean) lancamentoTarifaFiltroBean.getSessionBean(request,
                        FILTRO_BEAN);

            }
            request.getSession().setAttribute(CEDENTE_ATUAL,
                    lancamentoTarifaFiltroBean.getCodigoCedente());
            request.getSession().setAttribute(FILTRO_BEAN,
                    lancamentoTarifaFiltroBean);
            request.getSession().setAttribute(DATA_BEAN,
                    lancamentoTarifaFiltroBean);
            request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,
                    cedCabBean);

            // pega informações do usuario
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                    .getAttribute(USUARIOLDAP_BEAN);

            // Instancia o EJB que acessa o mainframe
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            // Definindo atributos para executar a transação BGM0 para obter o
            // cabeçalho
            cedCabBean.setTipoConsulta(new Long(1));
            cedCabBean.setOrigemConsulta(new Long(1));
            cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
            cedCabBean.setCodigoCedente(lancamentoTarifaFiltroBean.getCodigoCedente());

            // Chamada ao Mainframe para cabecalho cedente
             usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CEDENTE_CABECALHO + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
            		transUser);
            cedCabBean = (CedenteCabecaBean) cedCabBeanList.get(0);

            cedCabBean.setCodigoCedente(lancamentoTarifaFiltroBean.getCodigoCedente());

            // Guarda informacoes de cabecalho
            request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,
                    cedCabBean);

            // faz chamada da transacao de consulta BGA7
            
            lancamentoTarifaFiltroBean.setTpConsulta("C");
             transUser = TRANSACAO_EXECUTAR_MANTER + usuarioBean.getCodigoUsuario().toUpperCase();
            
            BeanList lanTariBeanList = handler.executeSimpleTransactionQuery(lancamentoTarifaFiltroBean,  transUser);

            ArrayList lanTariArrayList = convertDataStructure(lanTariBeanList.iterator());
            
            LancamentoTarifaBean lancamento= (LancamentoTarifaBean )lanTariArrayList.get(0);
            
            lancamentoTarifaFiltroBean.setCodigoCedente(lancamento.getCodigoCedente());
            lancamentoTarifaFiltroBean.setDtComando(lancamento.getDtComando());
            lancamentoTarifaFiltroBean.setCoUsuario(lancamento.getCoUsuario());
            lancamentoTarifaFiltroBean.setValorTotal(lancamento.getValorTotal());

            // lança os beans de dados fixos e array
            request.getSession().setAttribute(FILTRO_BEAN,  lancamentoTarifaFiltroBean);
            request.setAttribute("usuario", usuarioBean.getCodigoUsuario());

            request.getSession().setAttribute(PAGINACAO_LIST,     getPageHolder(lanTariArrayList));
            request.setAttribute(PAGINACAO_PAGE, "0");

        } catch (Exception e) {
            throw e;
        }
        return PAGE_EXECUTAR_MANTER;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_COMANDO_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_MANTER);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}
