package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;

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
 * Componente responsável pelo controle da funcionalidade Listar Bloqueto
 * On-line
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>14/10/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class BloquetManterFiltro extends BloquetEstrategia {
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

        // Reter o bean antes de acessar o mainframe
        // para gerar informacoes para tela de erro
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
        String transUser = TRANSACAO_VALIDAR_CEDENTE + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
        		transUser);
        cedCabBean = (CedenteCabecaBean) cedCabBeanList.get(0);
        cedCabBean.setCodigoCedente(bloquetoBean.getCodigoCedente());
        request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, (cedCabBean));

        // Chamada ao Mainframe
        handler = new MainFrameTransactionsSigcbEjb();
        // Determinar tipo de consulta
        BeanList bloquetoBeanList;
         transUser = TRANSACAO_LISTAR + usuarioBean.getCodigoUsuario().toUpperCase();
        bloquetoBeanList = handler.executeSimpleTransactionQuery(bloquetoBean,
        		transUser); // Chama a Transacao BGK6
        ArrayList bloquetoList = convertDataStructure(bloquetoBeanList.iterator());

        // Reter os dados depois da chamada ao mainframe
        // para gerar informacoes para tela de sucesso
        request.getSession().setAttribute(PAGINACAO_LIST,
                getPageHolder(bloquetoList));
        request.setAttribute(PAGINACAO_PAGE, "0");
        request.setAttribute(PAGINACAO_PAGEANTERIOR, "0");

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_MANTER_LISTAR;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_MANTER);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}