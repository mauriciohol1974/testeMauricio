package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.WrappingException;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MenuBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.SegundaViaExtratoBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.Formatador;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultar Bloqueto
 * On-line
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>20/10/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class SolExtrManterFiltro extends SolExtrEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);
        String fluxo = getFluxo(request);
        SegundaViaExtratoBean segundaViaExtratoBean = new SegundaViaExtratoBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
            segundaViaExtratoBean = (SegundaViaExtratoBean) segundaViaExtratoBean.getRequestBean(request);
        } else {
            segundaViaExtratoBean = (SegundaViaExtratoBean) segundaViaExtratoBean.getSessionBean(request,
                    FILTRO_BEAN);
        }
        request.getSession().setAttribute(SigcbEstrategia.CEDENTE_ATUAL,
                segundaViaExtratoBean.getCodigoCedente());
        request.getSession().setAttribute(FILTRO_BEAN, segundaViaExtratoBean);
        // Obter os dados do cedente
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();
        request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, cedCabBean);
        // Chamada ao Mainframe
       // MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        // Definindo atributos para executar a transação BGM0 para obter o
        // cabeçalho
        cedCabBean.setTipoConsulta(new Long(1));
        cedCabBean.setOrigemConsulta(new Long(1));
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute("usuarioLdap");
        cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
        cedCabBean.setCodigoCedente(segundaViaExtratoBean.getCodigoCedente());
        // Validar Cedente e obter dados cabeçalho.
         usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_VALIDAR_CEDENTE + usuarioBean.getCodigoUsuario().toUpperCase();
        /* BGM0 */BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
        		transUser);
        cedCabBean = (CedenteCabecaBean) cedCabBeanList.get(0);
        cedCabBean.setCodigoCedente(segundaViaExtratoBean.getCodigoCedente());
        request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, cedCabBean);

        // Determinar Se consulta ou inclusão.
        BeanList segundaViaExtratoBeanList;
         transUser = TRANSACAO_CONSULTAR + usuarioBean.getCodigoUsuario().toUpperCase();
        /* BG86 */segundaViaExtratoBeanList = handler.executeSimpleTransactionQuery(segundaViaExtratoBean,
        		transUser);
        segundaViaExtratoBean = (SegundaViaExtratoBean) segundaViaExtratoBeanList.get(0);
        request.getSession().setAttribute(DATA_BEAN, segundaViaExtratoBean);
        if (Formatador.formatarData(segundaViaExtratoBean.getDataInicio())
                .equals("01/01/0001")) {

            MenuBean menuBean = MenuBean.getInstance();

            if (menuBean.hasUserAcessByInternalAction("servico.segundaviaextrato.alterar",
                    usuarioBean.getNomeGrupo())) {
                return PAGE_INCLUIR;
            } else {
                throw new WrappingException(new Exception("Não há Solicitação de 2a. via cadastrada"));
            }
        }

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_CONSULTAR;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_CONSULTAR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}