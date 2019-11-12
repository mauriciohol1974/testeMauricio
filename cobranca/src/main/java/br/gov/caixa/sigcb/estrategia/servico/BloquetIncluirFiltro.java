package br.gov.caixa.sigcb.estrategia.servico;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.BloquetoBean;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade PvCobrador
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>14/10/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class BloquetIncluirFiltro extends BloquetEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);

        String fluxo = getFluxo(request);
        BloquetoBean bloquetoBean = new BloquetoBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
            bloquetoBean = (BloquetoBean) bloquetoBean.getRequestBean(request);
        } else {
            bloquetoBean = (BloquetoBean) bloquetoBean.getSessionBean(request,
                    FILTRO_BEAN);
        }
        request.getSession().setAttribute("cedente",
                bloquetoBean.getCodigoCedente());
        request.getSession().setAttribute(FILTRO_BEAN, bloquetoBean);

        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();
        request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, cedCabBean);

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        // Definindo atributos para executar a transação BGM0 para obter o
        // cabeçalho
        cedCabBean.setTipoConsulta(new Long(1));
        cedCabBean.setOrigemConsulta(new Long(1));
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute("usuarioLdap");
        cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
        cedCabBean.setCodigoCedente(bloquetoBean.getCodigoCedente());
        // Validar Cedente e obter dados cabeçalho.
         usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_VALIDAR_CEDENTE + usuarioBean.getCodigoUsuario().toUpperCase();
        /* BGM0 */BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
        		transUser);
        cedCabBean = (CedenteCabecaBean) cedCabBeanList.get(0);
        cedCabBean.setCodigoCedente(bloquetoBean.getCodigoCedente());
        request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, cedCabBean);

        bloquetoBean.setTipoAcao("V");
        bloquetoBean.setDataMovimento(new Date());
        // Validar Inclusão Solicitação
         transUser = TRANSACAO_VALIDAR_EXCLUIR + usuarioBean.getCodigoUsuario().toUpperCase();
        /* BGFW */handler.executeSimpleTransactionVoid(bloquetoBean,
                TRANSACAO_VALIDAR_EXCLUIR);

        return PAGE_INCLUIR;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) { /*
                                                                         * rever
                                                                         * dados
                                                                         * do
                                                                         * bean
                                                                         * de
                                                                         * Erro
                                                                         * Sucesso
                                                                         */
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INCLUIR_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_INCLUIR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
