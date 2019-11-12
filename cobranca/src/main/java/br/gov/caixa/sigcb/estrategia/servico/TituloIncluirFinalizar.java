package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.BorderoTituloBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Bordero >> Titulo >>
 * Incluir >> Finalizar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>18/09/2004</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class TituloIncluirFinalizar extends TituloEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            // Configuracoes gerais
            configMsgSucessoErro(request);
            String fluxo = getFluxo(request);

            // Obtem informacoes do titulo que foi selecionado na tela Manter
            // Titulos
            BorderoTituloBean borderoTituloBean = new BorderoTituloBean();
            BorderoTituloBean tituloFixoBean = new BorderoTituloBean();
            tituloFixoBean = (BorderoTituloBean) tituloFixoBean.getSessionBean(request,
                    BORDERO_INFO_BEAN);
            if (fluxo.equals(FLUXO_NORMAL)) {
                borderoTituloBean = (BorderoTituloBean) borderoTituloBean.getRequestBean(request);
            } else {
                borderoTituloBean = (BorderoTituloBean) borderoTituloBean.getSessionBean(request,
                        DATA_BEAN);
            }

            tituloFixoBean.setNavegacao(NAVEGACAO_INCLUIR);
            tituloFixoBean.setTitulosIncluidos(new Long(tituloFixoBean.getTitulosIncluidos()
                    .longValue() + 1));

            // Reter o bean antes de acessar o mainframe
            // para gerar informacoes para tela de erro
            request.getSession().setAttribute(FIXO_BEAN, tituloFixoBean);
            request.getSession().setAttribute(DATA_BEAN, borderoTituloBean);
            // ATENCAO: Os Beans a seguir devem existir:
            // 1. cabecalho do Cedente: cedCabBean
            // 2. bordero: borderoBean
            // 3. o grupo de informacoes fixas do titulo (nao recordset):
            // tituloFixoBean

            borderoTituloBean.setTipoAcao("I");
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                    .getAttribute(USUARIOLDAP_BEAN);
            borderoTituloBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
            
            if (borderoTituloBean.getTipoPgto()==null || borderoTituloBean.getTipoPgto().trim().length()==0 ){
            	borderoTituloBean.setTipoPgto("3");
            }
            
            if (borderoTituloBean.getIndRegCip().trim().length()==0){
            	borderoTituloBean.setIndRegCip("S");
            }


            // Chamada ao Mainframe
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
            BeanList borderoTituloBeanList = handler.executeSimpleTransactionQuery(borderoTituloBean,
            		transUser); // Chama a Transacao

            BorderoTituloBean bean = (BorderoTituloBean) borderoTituloBeanList.get(0);
            tituloFixoBean.setNossoNumero(bean.getNossoNumero());

            LogUtilSigcb.debug("BorderoTituloBean bean DEPOIS = "
                               + bean.toString());

            // Reter os dados depois da chamada ao mainframe
            // para gerar informacoes para tela de sucesso

            request.getSession().setAttribute(FIXO_BEAN, tituloFixoBean);
            request.getSession().setAttribute(DATA_BEAN, borderoTituloBean);

            // Nome da JSP a ser chamada (nao possui o .jsp)

        } catch (Exception e) {
            throw e;

        }
        return PAGE_SUCESSO;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess(SUCESSO_INCLUIR);
        msgBean.setStrategyErrorReturn(STRATEGY_INCLUIR);
        msgBean.setStrategySucessReturn(STRATEGY_MANTER_LISTAR);
        msgBean.setTitlePage(PAGE_TITLE_MANTER_LISTAR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}