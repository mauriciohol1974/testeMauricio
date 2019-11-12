package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.BorderoTituloBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Bordero >> Titulo >>
 * Alterar >> Finalizar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>18/09/2004</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class TituloAlterarFinalizar extends TituloEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configuracoes gerais
        configMsgSucessoErro(request);
        String fluxo = getFluxo(request);

        // Obtem informacoes do titulo que foi selecionado na tela Manter
        // Titulos
        BorderoTituloBean tituloBean = new BorderoTituloBean();
        BorderoTituloBean tituloFixoBean = new BorderoTituloBean();
        tituloFixoBean = (BorderoTituloBean) tituloFixoBean.getSessionBean(request,
                FIXO_BEAN);
        if (fluxo.equals(FLUXO_NORMAL)) {
            tituloBean = (BorderoTituloBean) tituloBean.getRequestBean(request);
        } else {
            tituloBean = (BorderoTituloBean) tituloBean.getSessionBean(request,
                    DATA_BEAN);
        }

        tituloBean.setTipoAcao("A");
        tituloFixoBean.setNavegacao(NAVEGACAO_ALTERAR);
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(USUARIOLDAP_BEAN);
        tituloBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());

        // Reter o bean antes de acessar o mainframe
        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(DATA_BEAN, tituloBean);
        request.getSession().setAttribute(FIXO_BEAN, tituloFixoBean);

        // ATENCAO: Os Beans a seguir devem existir:
        // 1. cabecalho do Cedente: cedCabBean
        // 2. bordero: borderoBean
        // 3. o grupo de informacoes fixas do titulo (nao recordset):
        // tituloFixoBean

        // Chamada ao Mainframe
        
        if (tituloBean.getTipoPgto()==null || tituloBean.getTipoPgto().trim().length()==0 ){
        	tituloBean.setTipoPgto("3");
        }
        
        
        if (tituloBean.getIndRegCip().trim().length()==0){
        	tituloBean.setIndRegCip("S");
        }
        
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();// Instancia
                                                                                // o
                                                                                // EJB
                                                                                // que
                                                                                // acessa
                                                                                // o
                                                                                // mainframe
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_INCLUIR_ALTERAR + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList borderoTituloBeanList = handler.executeSimpleTransactionQuery(tituloBean,
        		transUser); // Chama a Transacao

        BorderoTituloBean bean = (BorderoTituloBean) borderoTituloBeanList.get(0);
        tituloFixoBean.setNossoNumero(bean.getNossoNumero());

        // Reter os dados depois da chamada ao mainframe
        // para gerar informacoes para tela de sucesso

        request.getSession().setAttribute(FIXO_BEAN, tituloFixoBean);

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_SUCESSO;

    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess(SUCESSO_ALTERAR);
        msgBean.setStrategyErrorReturn(STRATEGY_ALTERAR);
        msgBean.setStrategySucessReturn(STRATEGY_MANTER_LISTAR);
        msgBean.setTitlePage(PAGE_TITLE_MANTER_LISTAR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}