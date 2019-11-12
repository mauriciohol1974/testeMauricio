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
 * Alterar >> Iniciar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>05/10/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BcoSacaAlterarIniciar extends BancoSacadoEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);
        // Obtem o bean que representa a funcionalidade
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
            // Obtendo o registro atual
            if (!bancoSacadoBean.getNavegacao().equals(NAVEGACAO_FILTRO_BANCO)) {
                bancoSacadoBean.setRegistro(new Long(request.getParameter("registro")));
            }
        }

        // Reter o bean antes de acessar o mainframe
        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(DATA_BEAN, bancoSacadoBean);

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_ALTERAR;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_FILTRO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_ALTERAR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}