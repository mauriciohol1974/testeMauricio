package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.util.PageHolder;
import br.com.politec.sao.util.Pageable;
import br.gov.caixa.sigcb.bean.BancoSacadoBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Banco de Sacados >>
 * Consultar >> Iniciar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>05/10/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BcoSacaConsultarIniciar extends BancoSacadoEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configuracoes gerais
        configMsgSucessoErro(request);
        String fluxo = getFluxo(request);

        // Obtem informacoes do Banco de sacados que foi selecionado na tela de
        // Listagem
        BancoSacadoBean bancoSacadoBean = new BancoSacadoBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
            bancoSacadoBean = (BancoSacadoBean) bancoSacadoBean.getRequestBean(request);

            if (!bancoSacadoBean.getNavegacao().equals(NAVEGACAO_FILTRO_BANCO)) {
                // Obtem o titulo selecionado em "Listar",
                // a partir da lista de bancos obtidos anteriormente na chamada
                // ao mainframe
                // A tela "Listar" deve enviar o atributo "Registro" com o
                // numero do registro na lista
                Long codCedente = bancoSacadoBean.getCodigoCedente();

                PageHolder paginacao = (PageHolder) request.getSession()
                        .getAttribute(PAGINACAO_LIST);
                Pageable registroList = paginacao.getPageable();
                bancoSacadoBean = (BancoSacadoBean) registroList.get(bancoSacadoBean.getRegistro()
                        .intValue());
                bancoSacadoBean.setNavegacao(NAVEGACAO_FILTRO);
                bancoSacadoBean.setCodigoCedente(codCedente);
            }
        } else {
            bancoSacadoBean = (BancoSacadoBean) bancoSacadoBean.getSessionBean(request,
                    DATA_BEAN);
            if (!bancoSacadoBean.getNavegacao().equals(NAVEGACAO_FILTRO_BANCO)) {
                // Obtendo o registro atual
                bancoSacadoBean.setRegistro(new Long(request.getParameter("registro")));
            }
        }

        if (!bancoSacadoBean.getNavegacao().equals(NAVEGACAO_FILTRO_BANCO)) {
            // Obtem o banco selecionado em "Listar",
            // a partir da lista de bancos obtidos anteriormente na chamada ao
            // mainframe
            // A tela "Listar" deve enviar o atributo "Registro" com o numero do
            // registro na lista
            PageHolder paginacao = (PageHolder) request.getSession()
                    .getAttribute(PAGINACAO_LIST);
            Pageable registroList = paginacao.getPageable();
            bancoSacadoBean = (BancoSacadoBean) registroList.get(bancoSacadoBean.getRegistro()
                    .intValue());
        }
        // Reter o bean
        request.getSession().setAttribute(DATA_BEAN, bancoSacadoBean);
        // ATENCAO: Os Beans a seguir devem existir:
        // 1. cabecalho do Cedente: cedCabBean
        // 2. banco: bancoSacadoBean

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_CONSULTAR;

    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_FILTRO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_CONSULTAR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}