package br.gov.caixa.sigcb.estrategia.cedente;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.ClienteInternetBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.SigcbException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Perfil Internet
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>10/11/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public abstract class CliInteEstrategia extends SigcbEstrategia {

    public static final String STRATEGY_INCLUIR_FILTRO = "cedente.CliInteIncluirFiltro";

    public static final String STRATEGY_INCLUIR_INICIAR = "cedente.CliInteIncluirIniciar";

    public static final String STRATEGY_INCLUIR_LISTAR = "cedente.CliInteIncluirListar";

    public static final String STRATEGY_INCLUIR_FINALIZAR = "cedente.CliInteIncluirFinalizar";

    public static final String STRATEGY_INCLUIR_REL_FINALIZAR = "cedente.CliInteIncluirRelFinalizar"; // GMG:27.11.2004

    public static final String STRATEGY_INCLUIR_RS_CED_FILTRO = "cedente.CliInteIncluirRSCedFiltro"; // GMG:27.11.2004

    public static final String STRATEGY_INCLUIR_RS_FINALIZAR = "cedente.CliInteIncluirRSCedFinalizar"; // GMG:27.11.2004

    public static final String STRATEGY_MANTER_INICIAR = "cedente.CliInteManterIniciar";

    public static final String STRATEGY_MANTER_LISTAR = "cedente.CliInteManterListar";

    public static final String STRATEGY_ALTERAR_USU_INICIAR = "cedente.CliInteAlterarUsuIniciar";

    public static final String STRATEGY_ALTERAR_USU_FINALIZAR = "cedente.CliInteAlterarUsuFinalizar";

    public static final String STRATEGY_ALTERAR_REL_INICIAR = "cedente.CliInteAlterarRelIniciar";

    public static final String STRATEGY_ALTERAR_REL_FINALIZAR = "cedente.CliInteAlterarRelFinalizar";

    public static final String STRATEGY_ALTERAR_SEN_INICIAR = "cedente.CliInteAlterarSenIniciar";

    public static final String STRATEGY_ALTERAR_SEN_FINALIZAR = "cedente.CliInteAlterarSenFinalizar";

    public static final String STRATEGY_EXCLUIR_REL_FINALIZAR = "cedente.CliInteExcluirRelFinalizar"; // GMG:27.11.2004

    public static final String STRATEGY_ALTINC_USU_FINALIZAR = "cedente.CliInteAltIncUsuFinalizar"; // GMG:13.12.2004

    public static final String PAGE_TITLE_INCLUIR_FILTRO = "Incluir Cliente Internet >> Filtro";

    public static final String PAGE_TITLE_INCLUIR = "Incluir Cliente Internet";

    public static final String PAGE_TITLE_INCLUIR_REL = "Incluir Cliente Internet (Relacionamento) >> Confirmar"; // GMG:27.11.2004

    public static final String PAGE_TITLE_INCLUIR_LISTAR = "Incluir Cliente Internet (CPF/CNPJ) >> Listar";

    public static final String PAGE_TITLE_MANTER_FILTRO = "Manter Cliente Internet >> Filtro";

    public static final String PAGE_TITLE_MANTER_FILTRO_CED = "Manter Cliente Internet (Cedente) >> Listar";

    public static final String PAGE_TITLE_MANTER_FILTRO_CPFCNPJ = "Manter Cliente Internet (CPF/CNPJ) >> Listar";

    public static final String PAGE_TITLE_MANTER_FILTRO_CPFUSU = "Manter Cliente Internet (CPF Usuário) >> Listar";

    public static final String PAGE_TITLE_ALTERAR_USU = "Manter Cliente Internet (Usuário) >> Alterar";

    public static final String PAGE_TITLE_ALTERAR_REL = "Manter Cliente Internet (Relacionamento) >> Alterar";

    public static final String PAGE_TITLE_ALTERAR_SEN = "Manter Cliente Internet (Senha) >> Alterar";

    public static final String PAGE_TITLE_EXCLUIR_REL = "Manter Cliente Internet (Relacionamento) >> Excluir";

    public static final String PAGE_TITLE_ALTINC_USU = "Manter Cliente Internet (Usuário) >> Incluir";

    public static final String SUCESSO_INCLUIR = "Cliente Internet Incluído com Sucesso";

    public static final String SUCESSO_INCLUIR_REL = "Cliente Internet (Relacionamento) Incluído com Sucesso"; // GMG:27.11.2004

    public static final String SUCESSO_ALTERAR_USU = "Cliente Internet (Usuário) Alterado com Sucesso";

    public static final String SUCESSO_ALTINC_USU = "Cliente Internet (Usuário) Incluído com Sucesso";

    public static final String SUCESSO_ALTERAR_REL = "Cliente Internet (Relacionamento) Alterado com Sucesso";

    public static final String SUCESSO_ALTERAR_SEN = "Cliente Internet (Senha) Alterado com Sucesso";

    public static final String SUCESSO_EXCLUIR_REL = "Cliente Internet (Relacionamento) Excluído com Sucesso"; // GMG:27.11.2004

    public static final String PAGE_INCLUIR_FILTRO = "/cedente/cliinte_incluir_filtro";

    public static final String PAGE_INCLUIR_REL = "/cedente/cliinte_incluir_rel"; // GMG:27.11.2004

    public static final String PAGE_INCLUIR = "/cedente/cliinte_incluir";

    public static final String PAGE_INCLUIR_RS_USU = "/cedente/cliinte_incluir_rs"; // GMG:13.12.2004

    public static final String PAGE_INCLUIR_LISTAR = "/cedente/cliinte_incluir_listar_cpfcnpj";

    public static final String PAGE_MANTER_LISTAR_FILTRO = "/cedente/cliinte_manter_filtro";

    public static final String PAGE_MANTER_LISTAR_CED = "/cedente/cliinte_manter_listar_ced";

    public static final String PAGE_MANTER_LISTAR_CPFCNPJ = "/cedente/cliinte_manter_listar_cpfcnpj";

    public static final String PAGE_MANTER_LISTAR_CPFUSU = "/cedente/cliinte_manter_listar_cpfusu";

    public static final String PAGE_ALTERAR_USU = "/cedente/cliinte_alterar";

    public static final String PAGE_ALTERAR_REL = "/cedente/cliinte_alterar_relacionamento";

    public static final String PAGE_ALTERAR_SEN = "/cedente/cliinte_alterar_senha";

    public static final String PAGE_ALTINC_USU = "/cedente/cliinte_altinc"; // GMG:13.12.2004

    public static final String PAGE_SUCESSO = "/cedente/cliinte_sucesso";

    public static final String PAGE_SUCESSO_RS = "/cedente/cliinte_sucesso_rs";

    public static final String PAGE_ERRO = "/cedente/cliinte_erro";

    public static final String PAGE_ERRO_RS = "/cedente/cliinte_erro_rs";

    public static final String TRANSACAO_VALIDAR_CEDENTE = "BGM0";

    public static final String TRANSACAO_LISTAR_CEDENTE = "BGFA";

    public static final String TRANSACAO_LISTAR_USUARIO = "BGFJ"; // GMG:30.11.2004

    public static final String TRANSACAO_LISTAR_CEDENTE_USU = "BGFB";

    public static final String TRANSACAO_CONSULTAR_DETALHE = "BGFC";

    public static final String TRANSACAO_INCLUIR_ALTERAR_CLI = "BGFD";

    public static final String TRANSACAO_INCLUIR_ALTERAR_REL = "BGFE";

    public static final String TRANSACAO_ALTERAR_SENHA = "BGFF";

    public static final String TRANSACAO_VALIDAR_USU = "BGFK"; // GMG:13.12.2004

    public static final String TRANSACAO_INCLUIR_RS_REL = "BGFL"; // GMG:16.12.2004

    public static final String PAGINACAO_FIXO = "bean";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    public static final String PAGINACAO_PAGEANTERIOR = "paginaAnterior";

    public static final String FILTRO_BEAN = "filtroCliInteBean";

    public static final String MSG_BEAN = "msgBean";

    public static final String DATA_BEAN = "dataCliInteBean";

    public static final String CEDENTE_CABECALHO_BEAN = "cedenteCabBean";

    // Define tela customizada de erro
    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

    protected void buscarCabecalho(HttpServletRequest request,
            ClienteInternetBean clienteInternetBean) throws Exception,
            SigcbException, RemoteException {

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
        cedCabBean.setCodigoCedente(clienteInternetBean.getCodigoCedente());
         usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
         String transUser = TRANSACAO_VALIDAR_CEDENTE + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
        		transUser);
        cedCabBean = (CedenteCabecaBean) cedCabBeanList.get(0);
        cedCabBean.setCodigoCedente(clienteInternetBean.getCodigoCedente());

        request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, (cedCabBean));

        clienteInternetBean.setCpfCnpjCedente(cedCabBean.getCpfCnpj()); // GMG:27.11.2004
        clienteInternetBean.setNome(cedCabBean.getNomeFantasia()); // GMG:27.11.2004

        return;
    }

    protected ClienteInternetBean iniciarProcessRequest(HttpServletRequest request,
            String sessionAttributeName) throws Exception {
        ClienteInternetBean clienteInternetBean = new ClienteInternetBean();
        if (getFluxo(request).equals(FLUXO_NORMAL)) {
            clienteInternetBean = (ClienteInternetBean) clienteInternetBean.getRequestBean(request);
        } else {
            clienteInternetBean = (ClienteInternetBean) clienteInternetBean.getSessionBean(request,
                    sessionAttributeName);
        }
        request.getSession().setAttribute(sessionAttributeName,
                clienteInternetBean);
        return clienteInternetBean;
    }

    protected void prepararListaRequest(HttpServletRequest request,
            BeanList respostaList) {
        ArrayList listaCedentes = convertDataStructure(respostaList.iterator());

        request.getSession().setAttribute(PAGINACAO_LIST,
                getPageHolder(listaCedentes));

        request.setAttribute(PAGINACAO_PAGE, "0");
        request.setAttribute(PAGINACAO_PAGEANTERIOR, "0");
    }

}
