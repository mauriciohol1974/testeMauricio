package br.gov.caixa.sigcb.estrategia.servico;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteBloquetosBean;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.SolicitacaoAgendamentoBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade
 * Solicitação/Agendamento >> Incluir >> Filtro.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>11/10/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class SoAgTitIncluirFiltro extends SolicitacaoAgendamentoEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);
        // Obtem o bean que representa a funcionalidade
        SolicitacaoAgendamentoBean solicitacaoBean = new SolicitacaoAgendamentoBean();

        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
            solicitacaoBean = (SolicitacaoAgendamentoBean) solicitacaoBean.getRequestBean(request);
            solicitacaoBean.setTipoJuroDia(new Long(-999)); // Set necessário
                                                            // pois a transação
                                                            // retorna registro
                                                            // com codigo 0
        } else {
            solicitacaoBean = (SolicitacaoAgendamentoBean) solicitacaoBean.getSessionBean(request,
                    DATA_BEAN);
        }

        // Definindo atributos para executar a transação BGM0 para obter o
        // cabeçalho
        cedCabBean.setTipoConsulta(new Long(1));
        cedCabBean.setOrigemConsulta(new Long(1));
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(USUARIOLDAP_BEAN);
        cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
        cedCabBean.setCodigoCedente(solicitacaoBean.getCodigoCedente());

        // Define manualmente atributos nao obtidos da jsp
        solicitacaoBean.setTipoAcao("V");
        solicitacaoBean.setDataSolicitacao(Calendar.getInstance().getTime());

        // Reter o bean antes de acessar o mainframe
        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(CEDENTE_ATUAL,
                solicitacaoBean.getCodigoCedente());
        request.getSession().setAttribute(FILTRO_BEAN, solicitacaoBean);
        request.getSession().setAttribute(DATA_BEAN, solicitacaoBean);
        request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, cedCabBean);

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
        String transUser = TRANSACAO_EXCLUIR_VALIDAR + usuarioBean.getCodigoUsuario().toUpperCase();
        handler.executeSimpleTransactionVoid(solicitacaoBean,
        		transUser); // Chama a Transacao

        // Valida os dados para poder preencher o cabeçalho.
        /* BGM0 */BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
                TRANSACAO_CEDENTE_CABECALHO);

        SolicitacaoAgendamentoBean sacado = new SolicitacaoAgendamentoBean();

        try {
            /* BG46 */BeanList solicitacaoBeanList = handler.executeSimpleTransactionQuery(solicitacaoBean,
                    BancoSacadoEstrategia.TRANSACAO_LISTAR_BANCO_SACADO);

            sacado = (SolicitacaoAgendamentoBean) solicitacaoBeanList.get(0);
            solicitacaoBean.setNomeBancoSacado(sacado.getNomeBancoSacado());

            // Obtendo os dados das guias geral e bloquetos
            getDadosGuiaGeral(request, solicitacaoBean);
            getDadosGuiaBloqueto(request, solicitacaoBean);
        } catch (Exception e) {
            request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,
                    (CedenteCabecaBean) cedCabBeanList.get(0));

            throw e;
        }

        // Reter os dados depois da chamada ao mainframe
        // para gerar informacoes para tela de sucesso
        // request.getSession().setAttribute(FILTRO_BEAN, solicitacaoBean);
        request.getSession().setAttribute(DATA_BEAN, solicitacaoBean);
        request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,
                (CedenteCabecaBean) cedCabBeanList.get(0));

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_INCLUIR;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INCLUIR_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_INCLUIR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

    private void getDadosGuiaGeral(HttpServletRequest request,
            SolicitacaoAgendamentoBean solicitacaoBean) throws Exception {
        CedenteGeralBean cedGeralBean = new CedenteGeralBean();
        cedGeralBean.newBean();
        cedGeralBean.setTipoConsulta("C");
        cedGeralBean.setCodigoCedente(solicitacaoBean.getCodigoCedente());

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        // BG03
        BeanList cedGeralBeanList = handler.executeSimpleTransactionQuery(cedGeralBean,
                TRANSACAO_CEDENTE_GERAL);

        cedGeralBean = (CedenteGeralBean) cedGeralBeanList.get(0);

        request.getSession().setAttribute(CEDENTE_GERAL_BEAN, cedGeralBean);
    }

    private void getDadosGuiaBloqueto(HttpServletRequest request,
            SolicitacaoAgendamentoBean solicitacaoBean) throws Exception {
        CedenteBloquetosBean cedBloqBean = new CedenteBloquetosBean();
        cedBloqBean.newBean();
        cedBloqBean.setTipoConsulta("C");
        cedBloqBean.setCodigoCedente(solicitacaoBean.getCodigoCedente());

       // MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        // BG11
        BeanList cedBloqBeanList = handler.executeSimpleTransactionQuery(cedBloqBean,
                TRANSACAO_CEDENTE_BLOQUETOS);

        cedBloqBean = (CedenteBloquetosBean) cedBloqBeanList.get(0);

        request.getSession().setAttribute(CEDENTE_BLOQUETO_BEAN, cedBloqBean);
    }

}