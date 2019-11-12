package br.gov.caixa.sigcb.estrategia.cedente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Manter Cedente
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>16/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteExcluirFinalizar extends CedenteEstrategia {

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess(SUCESSO_EXCLUSAO);
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setTitlePage(PAGE_EXCLUIR_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        this.configMsgSucessoErro(request);

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        // Chama BGM0 para descobrir idEndereco e COCLI
        CedenteCabecaBean cabecaBean = (CedenteCabecaBean) (new CedenteCabecaBean()).getRequestBean(request);
        cabecaBean.setTipoConsulta(new Long(1)); // 1 - por codigo cedente
        cabecaBean.setCodigoUsuario(this.getCodigoUsuario(request));
        cabecaBean.setOrigemConsulta(new Long(1)); // 1 - Intranet
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CABECALHO + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList blCabecalho = handler.executeSimpleTransactionQuery(cabecaBean,transUser);
        cabecaBean = (CedenteCabecaBean) blCabecalho.get(0);

        // Chama BG03 para descobrir o PV
        CedenteGeralBean geralBean = (CedenteGeralBean) (new CedenteGeralBean()).getRequestBean(request);
        geralBean.setTipoConsulta("C");
        
        usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
         transUser = TRANSACAO_CONSULTAR_GERAL + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList blGeral = handler.executeSimpleTransactionQuery(geralBean,transUser);
        geralBean = (CedenteGeralBean) blGeral.get(0);

        // Chama BG27 para exclusao
        CedenteCabecaBean excluirBean = (CedenteCabecaBean) (new CedenteCabecaBean()).getRequestBean(request);
        excluirBean.setCodigoUsuario(this.getCodigoUsuario(request));
        excluirBean.setNomeFantasia(cabecaBean.getNomeFantasia());
        excluirBean.setCodigoClienteCOCLI(cabecaBean.getCodigoClienteCOCLI());
        excluirBean.setCodigoUnidadePVVinc(geralBean.getCodigoUnidadePVVinc());
        excluirBean.setIdEndereco(cabecaBean.getIdEndereco());
        excluirBean.setTipoAcao("E"); // E - Exclusao
        String ip = request.getRemoteAddr();
        excluirBean.setIp(ip);
        usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        transUser = TRANSACAO_EXCLUIR_REATIVAR + usuarioBean.getCodigoUsuario().toUpperCase();
        handler.executeSimpleTransactionVoid(excluirBean,transUser);

        return PAGE_SUCESSO;
    }

}
