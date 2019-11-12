package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.Formatacao;
import br.com.politec.sao.util.PageHolder;
import br.com.politec.sao.util.WrappingException;
import br.gov.caixa.sigcb.bean.ClienteInternetBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.SigcbException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Cliente Internet
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>09/11/2004</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego
 */
public class CliInteIncluirRSCedFiltro extends CliInteEstrategia {

    private int NUM_MAX_ITENS = 164;

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);
        ClienteInternetBean clienteInternetBean = iniciarProcessRequest(request,
                FILTRO_BEAN);

        // Verifica se o novo cliente internet ja existe
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        clienteInternetBean.setTipoAcao("V");
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_VALIDAR_USU + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList validarList = handler.executeSimpleTransactionQuery(clienteInternetBean,
        		transUser);
        ClienteInternetBean clienteInternetVBean = (ClienteInternetBean) validarList.get(0);

        // Coloca informacoes
        if (getFluxo(request).equals(FLUXO_NORMAL)) {
            clienteInternetBean.setBit62(defineBit62(request));
            request.getSession().setAttribute(DATA_BEAN, clienteInternetBean);
        } else {
            clienteInternetBean = (ClienteInternetBean) clienteInternetBean.getSessionBean(request,
                    DATA_BEAN);
        }

        if (clienteInternetVBean.getUsuarioExistente().equals("N")) {
            // buscarCabecalho(request, clienteInternetBean);
            return PAGE_INCLUIR_RS_USU;
        }

        // Insere relacao cedente X clienteInternet.
        
         usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
         transUser = TRANSACAO_INCLUIR_RS_REL + usuarioBean.getCodigoUsuario().toUpperCase();
        handler.executeSimpleTransactionVoid(clienteInternetBean,
        		transUser);

        return PAGE_SUCESSO_RS;
    }

    private String defineBit62(HttpServletRequest request)
            throws SigcbException {
        StringBuffer bit62 = new StringBuffer();

        // Obtem lista de cedentes
        PageHolder paginacao = (PageHolder) request.getSession()
                .getAttribute(CliInteEstrategia.PAGINACAO_LIST);
        int paginaAnterior = 0;
        if (request.getParameter(CliInteEstrategia.PAGINACAO_PAGEANTERIOR) != null
            && !request.getParameter(CliInteEstrategia.PAGINACAO_PAGEANTERIOR)
                    .equals("")) {
            paginaAnterior = Integer.parseInt((String) request.getParameter(CliInteEstrategia.PAGINACAO_PAGEANTERIOR));
        } else {
            paginaAnterior = Integer.parseInt((String) request.getAttribute(CliInteEstrategia.PAGINACAO_PAGEANTERIOR));
        }
        List listaAnterior = paginacao.getPage(paginaAnterior);

        // Obtem ultima lista de check buttons para seta-los na lista de
        // cedentes
        String[] cedentes = null;
        if (request.getParameterValues("cedentes") != null
            && !request.getParameterValues("cedentes").equals("")) {
            cedentes = (String[]) request.getParameterValues("cedentes");
        }
        ClienteInternetBean occ = new ClienteInternetBean();
        for (int j = 0; j < listaAnterior.size(); j++) {
            occ = (ClienteInternetBean) listaAnterior.get(j);
            occ.setCedenteChecked(" ");
            if (cedentes != null) {
                for (int i = 1; i < cedentes.length; i++) {
                    if (occ.getCodigoCedente().toString().equals(cedentes[i])) {
                        occ.setCedenteChecked("1");
                    }
                }
            }
        }

        // carrega string com os cedentes selecionados
        int numItens = 0;
        paginacao.setPageSize(paginacao.getPageableSize());
        List listaTotal = paginacao.getPage(0);
        for (int i = 0; i < listaTotal.size(); i++) {
            occ = (ClienteInternetBean) listaTotal.get(i);
            if (occ.getCedenteChecked() != null) {
                if (occ.getCedenteChecked().equals("1")) {
                    bit62.append(Formatacao.formataNumerico(occ.getCodigoCedente()
                            .toString(),
                            6));
                    numItens++;
                }
            }
        }

        // Testa se o limite minimo foi atingido
        if (numItens > NUM_MAX_ITENS)
            throw new WrappingException(new Exception("EH PERMITIDO VINCULAR APENAS "
                                                      + NUM_MAX_ITENS
                                                      + " CEDENTES POR VEZ."));

        // Preenche o restante do bit62 com zeros.
        for (int i = 0; i < (NUM_MAX_ITENS - numItens); i++) {
            bit62.append(Formatacao.formataNumerico("0", 6));
        }

        return bit62.toString();
    }

    // Define tela customizada de erro
    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO_RS;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess(SUCESSO_INCLUIR_REL);
        msgBean.setStrategyErrorReturn(STRATEGY_INCLUIR_FILTRO);
        msgBean.setStrategySucessReturn(STRATEGY_INCLUIR_INICIAR);
        msgBean.setTitlePage(PAGE_TITLE_INCLUIR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}