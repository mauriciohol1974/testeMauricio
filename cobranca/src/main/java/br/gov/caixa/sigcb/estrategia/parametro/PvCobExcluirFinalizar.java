package br.gov.caixa.sigcb.estrategia.parametro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.PvCobradorBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade PV Cobrador >> Excluir >>
 * Finalizar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>21/06/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class PvCobExcluirFinalizar extends PvCobEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);
        // Obtem o bean que representa a funcionalidade
        PvCobradorBean pvCobBean = new PvCobradorBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
            pvCobBean = (PvCobradorBean) pvCobBean.getRequestBean(request);
        } else {
            pvCobBean = (PvCobradorBean) pvCobBean.getSessionBean(request,
                    DATA_BEAN);
        }

        // Define manualmente atributos nao obtidos da jsp
        pvCobBean.setTipoAcao("E");

        // Reter o bean antes de acessar o mainframe
        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(DATA_BEAN, pvCobBean);
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute("usuarioLdap");
        pvCobBean.setUsuario(usuarioBean.getCodigoUsuario());

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
        String transUser = TRANSACAO_VALIDAR_EXCLUIR + usuarioBean.getCodigoUsuario().toUpperCase();
        handler.executeSimpleTransactionVoid(pvCobBean,
        		transUser); // Chama a Transacao
        /* BGM1 */
         transUser = TRANSACAO_CONS_UNIDADE + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList unidadeBeanList = (BeanList) handler.executeSimpleTransactionQuery(pvCobBean,
        		transUser);
        pvCobBean.setCodigoVAN(new Long(1)); // incluindo no bean a VAN
                                                // "EMBRATEL"
        pvCobBean.setNomeUnidadePV(((PvCobradorBean) unidadeBeanList.get(0)).getNomeUnidadePV());
        pvCobBean.setEmailUnidadePV(((PvCobradorBean) unidadeBeanList.get(0)).getEmailUnidadePV());
        pvCobBean.setEndereco(((PvCobradorBean) unidadeBeanList.get(0)).getEndereco());

        // Reter os dados depois da chamada ao mainframe
        // para gerar informacoes para tela de sucesso
        request.getSession().setAttribute(FILTRO_BEAN, pvCobBean);
        request.getSession().setAttribute(DATA_BEAN, pvCobBean);

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_SUCESSO;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess(SUCESSO_EXCLUIR);
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_LISTAR);
        msgBean.setStrategySucessReturn(STRATEGY_MANTER_LISTAR);
        msgBean.setTitlePage(PAGE_TITLE_MANTER);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
