package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.SacadoBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Sacados >> Incluir >>
 * Filtro.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>05/10/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class SacadoIncluirFiltro extends SacadoEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);
        // Obtem o bean que representa a funcionalidade
        SacadoBean sacadoBean = new SacadoBean();

        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
            sacadoBean = (SacadoBean) sacadoBean.getRequestBean(request);
        } else {
            sacadoBean = (SacadoBean) sacadoBean.getSessionBean(request,
                    DATA_BEAN);
        }

        // Definindo atributos para executar a transação BGM0 para obter o
        // cabeçalho
        cedCabBean.setTipoConsulta(new Long(1));
        cedCabBean.setOrigemConsulta(new Long(1));
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(USUARIOLDAP_BEAN);
        cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
        cedCabBean.setCodigoCedente(sacadoBean.getCodigoCedente());

        // Define manualmente atributos nao obtidos da jsp
        sacadoBean.setTipoAcao("V");

        // Reter o bean antes de acessar o mainframe
        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(CEDENTE_ATUAL,
                sacadoBean.getCodigoCedente());
        request.getSession().setAttribute(FILTRO_BEAN, sacadoBean);
        request.getSession().setAttribute(DATA_BEAN, sacadoBean);
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
        handler.executeSimpleTransactionVoid(sacadoBean,
        		transUser); // Chama a Transacao

        /* BGM0 */
         transUser = TRANSACAO_CEDENTE_CABECALHO + usuarioBean.getCodigoUsuario().toUpperCase(); 
        BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
        		transUser);

        try {
            /* BG46 */
        	 transUser = BancoSacadoEstrategia.TRANSACAO_LISTAR_BANCO_SACADO + usuarioBean.getCodigoUsuario().toUpperCase(); 
        	BeanList sacadoBeanList = handler.executeSimpleTransactionQuery(sacadoBean,	transUser);

            SacadoBean sacado = new SacadoBean();
            sacado = (SacadoBean) sacadoBeanList.get(0);
            sacadoBean.setNomeBancoSacado(sacado.getNomeBancoSacado());

            // Reter os dados depois da chamada ao mainframe
            // para gerar informacoes para tela de sucesso
            // request.getSession().setAttribute(FILTRO_BEAN, sacadoBean);
            request.getSession().setAttribute(DATA_BEAN, sacadoBean);
        } catch (Exception e) {
            request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,
                    (CedenteCabecaBean) cedCabBeanList.get(0));

            throw e;
        }

        // Valida os dados para o preenchimento do cabeçalho.
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
}