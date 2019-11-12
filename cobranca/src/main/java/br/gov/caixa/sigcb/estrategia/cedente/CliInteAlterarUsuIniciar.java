package br.gov.caixa.sigcb.estrategia.cedente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.ClienteInternetBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Alterar Bloqueto
 * On-line
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>14/10/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class CliInteAlterarUsuIniciar extends CliInteEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        configMsgSucessoErro(request);
        ClienteInternetBean clienteInternetBean = iniciarProcessRequest(request,
                DATA_BEAN);

        buscarCabecalho(request, clienteInternetBean);

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CONSULTAR_DETALHE + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList clienteInternetBeanList = handler.executeSimpleTransactionQuery(clienteInternetBean,
        		transUser); // Chama a Transacao BGFC
        ClienteInternetBean clienteInternetBean2 = (ClienteInternetBean) clienteInternetBeanList.get(0);
        clienteInternetBean2.setCodigoCedente(clienteInternetBean.getCodigoCedente());
        clienteInternetBean2.setCpfUsuario(clienteInternetBean.getCpfUsuario());
        request.getSession().setAttribute(DATA_BEAN, clienteInternetBean2);

        return PAGE_ALTERAR_USU;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_LISTAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_ALTERAR_USU);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}