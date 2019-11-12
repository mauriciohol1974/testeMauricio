package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.util.PageHolder;
import br.com.politec.sao.util.Pageable;
import br.gov.caixa.sigcb.bean.BorderoBean;
import br.gov.caixa.sigcb.bean.BorderoTituloBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Bordero >> Titulo >>
 * Consultar >> Iniciar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>18/09/2004</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class TituloConsultarIniciar extends TituloEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configuracoes gerais
        configMsgSucessoErro(request);
        String fluxo = getFluxo(request);

        // Obtem informacoes do titulo que foi selecionado na tela Manter
        // Titulos
        BorderoTituloBean tituloBean = new BorderoTituloBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
            tituloBean = (BorderoTituloBean) tituloBean.getRequestBean(request);

            // Bean instanciado para navegação
            BorderoBean borderoBean = new BorderoBean();
            borderoBean = (BorderoBean) borderoBean.getRequestBean(request);
            request.getSession().setAttribute(BorderoEstrategia.DATA_BEAN,
                    borderoBean);
        } else {
            tituloBean = (BorderoTituloBean) tituloBean.getSessionBean(request,
                    DATA_BEAN);

            // Obtendo o registro atual
            tituloBean.setRegistro(new Long(request.getParameter("registro")));
        }

        // Obtem o titulo selecionado em "Manter Titulos",
        // a partir da lista de titulos obtidos anteriormente na chamada ao
        // mainframe
        // A tela "Manter Titulos" deve enviar o atributo "Registro" com o
        // numero do registro na lista
        PageHolder paginacao = (PageHolder) request.getSession()
                .getAttribute(PAGINACAO_LIST);
        Pageable registroList = paginacao.getPageable();
        tituloBean = (BorderoTituloBean) registroList.get(tituloBean.getRegistro()
                .intValue());

        // Reter o bean
        request.getSession().setAttribute(DATA_BEAN, tituloBean);
        // ATENCAO: Os Beans a seguir devem existir:
        // 1. cabecalho do Cedente: cedCabBean
        // 2. bordero: borderoBean
        // 3. o grupo de informacoes fixas do titulo (nao recordset):
        // tituloFixoBean

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_CONSULTAR;

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