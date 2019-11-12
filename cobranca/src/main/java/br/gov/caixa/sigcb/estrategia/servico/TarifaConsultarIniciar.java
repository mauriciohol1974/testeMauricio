package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.util.PageHolder;
import br.com.politec.sao.util.Pageable;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.TarifaManualBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Tarifa Manual >>
 * Consultar >> Iniciar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>27/10/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class TarifaConsultarIniciar extends TarifaEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configuracoes gerais
        configMsgSucessoErro(request);
        String fluxo = getFluxo(request);

        // Obtem informacoes da tarifa que foi selecionada na tela Manter
        // Lançamento de Tarifa Manual
        TarifaManualBean tarifaBean = new TarifaManualBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
            tarifaBean = (TarifaManualBean) tarifaBean.getRequestBean(request);
        } else {
            tarifaBean = (TarifaManualBean) tarifaBean.getSessionBean(request,
                    DATA_BEAN);

            // Obtendo o registro atual
            tarifaBean.setRegistro(new Long(request.getParameter("registro")));
        }

        // Obtem o titulo selecionado em "Manter Titulos",
        // a partir da lista de titulos obtidos anteriormente na chamada ao
        // mainframe
        // A tela "Manter Lançamento de Tarifa Manual" deve enviar o atributo
        // "Registro" com o numero do registro na lista
        PageHolder paginacao = (PageHolder) request.getSession()
                .getAttribute(PAGINACAO_LIST);
        Pageable registroList = paginacao.getPageable();
        tarifaBean = (TarifaManualBean) registroList.get(tarifaBean.getRegistro()
                .intValue());

        // Reter o bean
        request.getSession().setAttribute(DATA_BEAN, tarifaBean);

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
        msgBean.setTitlePage(PAGE_TITLE_CONSULTAR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}