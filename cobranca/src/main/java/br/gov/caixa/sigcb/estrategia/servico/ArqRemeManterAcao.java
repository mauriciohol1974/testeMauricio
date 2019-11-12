package br.gov.caixa.sigcb.estrategia.servico;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.util.PageHolder;
import br.gov.caixa.sigcb.bean.ArquivoRemessaBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Agrupamento >> Excluir >>
 * Finalizar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>21/06/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class ArqRemeManterAcao extends ArqRemeEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);
        ArquivoRemessaBean arquivoRemessaBean = new ArquivoRemessaBean();
        arquivoRemessaBean = (ArquivoRemessaBean) arquivoRemessaBean.getRequestBean(request);

        PageHolder paginacao = (PageHolder) request.getSession()
                .getAttribute(ArqRemeEstrategia.PAGINACAO_LIST);
        String page = request.getParameter(ArqRemeEstrategia.PAGINACAO_PAGEANTERIOR);
        String escolha = request.getParameter("escolha");
        List list = (List) paginacao.getPage(Integer.parseInt(page));
        ArquivoRemessaBean arquivoRemessaBean2 = (ArquivoRemessaBean) list.get(Integer.parseInt(escolha));
        arquivoRemessaBean.setDataArquivo(arquivoRemessaBean2.getDataArquivo());
        arquivoRemessaBean.setHoraArquivo(arquivoRemessaBean2.getHoraArquivo());
        arquivoRemessaBean.setTipoArquivo(arquivoRemessaBean2.getTipoArquivo());
        arquivoRemessaBean.setPadrao(arquivoRemessaBean2.getPadrao());
        arquivoRemessaBean.setNumRemessaRetorno(arquivoRemessaBean2.getNumRemessaRetorno());
        arquivoRemessaBean.setQuantidadeRegistros(arquivoRemessaBean2.getQuantidadeRegistros());
        arquivoRemessaBean.setObservacao(arquivoRemessaBean2.getObservacao());

        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute("usuarioLdap");
        arquivoRemessaBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
        // Chamada ao Mainframe
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();// Instancia
                                                                                // o
                                                                                // EJB
                                                                                // que
                                                                                // acessa
                                                                                // o
                                                                                // mainframe
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        /* BGL0 */
         usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_ACAO_REMESSA + usuarioBean.getCodigoUsuario().toUpperCase();
        handler.executeSimpleTransactionVoid(arquivoRemessaBean,
        		transUser); // Chama a Transacao
        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_SUCESSO;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess(SUCESSO_SOLICITAR);
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_FILTRO);
        msgBean.setStrategySucessReturn(STRATEGY_MANTER_FILTRO);
        msgBean.setTitlePage(PAGE_TITLE_MANTER_ACAO);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
