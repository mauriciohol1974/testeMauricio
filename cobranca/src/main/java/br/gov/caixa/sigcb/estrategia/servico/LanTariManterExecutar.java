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

public class LanTariManterExecutar extends LancamentoTarifaEstrategia {

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
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);

            // Instancia o EJB que acessa o mainframe
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            
            lancamentoTarifaFiltroBean.setCoUsuario(usuarioBean.getCodigoUsuario());
            
             usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_EXECUTAR_2 + usuarioBean.getCodigoUsuario().toUpperCase();
            handler.executeSimpleTransactionVoid(lancamentoTarifaFiltroBean,  transUser);
            

        } catch (Exception e) {
            throw e;
        }
        return PAGE_SUCESSO_INCLUIR;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}
