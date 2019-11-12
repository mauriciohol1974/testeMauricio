package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.BorderoBean;
import br.gov.caixa.sigcb.bean.BorderoTituloBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Bordero >> Titulo >>
 * Incluir >> Iniciar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>18/09/2004</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class TituloIncluirIniciar extends TituloEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configuracoes gerais
        configMsgSucessoErro(request);
        String fluxo = getFluxo(request);

        // Obtem informacoes do titulo que foi selecionado na tela Manter
        // Titulos
        BorderoTituloBean borderoTituloBean = new BorderoTituloBean();
        BorderoTituloBean borderoInfoBean = new BorderoTituloBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
            borderoTituloBean = (BorderoTituloBean) borderoTituloBean.newBean();
            borderoInfoBean = (BorderoTituloBean) borderoInfoBean.getRequestBean(request);

            // Bean instanciado para navegação
            BorderoBean borderoBean = new BorderoBean();
            borderoBean = (BorderoBean) borderoBean.getRequestBean(request);
            request.getSession().setAttribute(BorderoEstrategia.DATA_BEAN,   borderoBean);

        } else {
            borderoTituloBean = (BorderoTituloBean) borderoTituloBean.getSessionBean(request, DATA_BEAN);
            borderoInfoBean = (BorderoTituloBean) borderoInfoBean.getSessionBean(request, BORDERO_INFO_BEAN);

        }

        request.getSession().setAttribute(FIXO_BEAN, borderoInfoBean);
        request.getSession().setAttribute(DATA_BEAN, borderoInfoBean);

        // Chamada ao Mainframe para obter as informações do borderô
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();// Instancia
                                                                                // o
                                                                                // EJB
                                                                                // que
                                                                                // acessa
                                                                                // o
                                                                                // mainframe
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_BORDERO_INFO + usuarioBean.getCodigoUsuario().toUpperCase();
        
        BeanList borderoTituloBeanList = handler.executeSimpleTransactionQuery(borderoInfoBean,    transUser); // Chama a Transacao

        BorderoTituloBean bean = new BorderoTituloBean();
        bean = (BorderoTituloBean) borderoTituloBeanList.get(0);
        bean.setCodigoBordero(borderoInfoBean.getCodigoBordero());
        bean.setCodigoCedente(borderoInfoBean.getCodigoCedente());

        if (borderoInfoBean.getSituacao().equals(new Long(2))) {// Reabrir
                                                                // Borderô
                                                                // finalizado
            borderoInfoBean.setTipoAcao("2");
            transUser =  BorderoEstrategia.TRANSACAO_FINALIZAR_REABRIR + usuarioBean.getCodigoUsuario().toUpperCase();
            handler.executeSimpleTransactionVoid(borderoInfoBean,transUser);
        }

        if (borderoTituloBean.getEmissaoBloqueto()==0){
        	borderoTituloBean.setEmissaoBloqueto(bean.getEmissaoBloqueto());
        }
        
        LogUtilSigcb.info(">>>>BORDERO INFORMACAO::::" + borderoTituloBean.getEmissaoBloqueto());
        LogUtilSigcb.info(">>>>BEAN:::"+ bean.getEmissaoBloqueto());
        LogUtilSigcb.info(">>>>SomenteProtesto:::"+ bean.getSomenteProtesto());
        
        
        // Reter o bean
        request.getSession().setAttribute(DATA_BEAN, borderoTituloBean);
        request.getSession().setAttribute(BORDERO_INFO_BEAN, bean);
        // ATENCAO: Os Beans a seguir devem existir:
        // 1. cabecalho do Cedente: cedCabBean
        // 2. bordero: borderoBean

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_INCLUIR;

    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_LISTAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_MANTER_LISTAR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}