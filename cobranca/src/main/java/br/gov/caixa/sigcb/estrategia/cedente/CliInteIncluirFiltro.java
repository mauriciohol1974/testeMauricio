package br.gov.caixa.sigcb.estrategia.cedente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.WrappingException;
import br.gov.caixa.sigcb.bean.ClienteInternetBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Perfil Internet
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>09/11/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class CliInteIncluirFiltro extends CliInteEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String page = "";

        configMsgSucessoErro(request);
        ClienteInternetBean clienteInternetBean = iniciarProcessRequest(request,
                FILTRO_BEAN);

        // EAM 05/09/05
        if (!clienteInternetBean.getCodigoCedente().equals(new Long(0))
            && clienteInternetBean.getCodigoCedente() != null) {
            request.getSession().setAttribute(CEDENTE_ATUAL,
                    clienteInternetBean.getCodigoCedente());
        }

        // Instancia o EJB que acessa o mainframe
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        if (clienteInternetBean.getTipoPesquisa().equals(new Long(1))) {
            // bean utilizado na transacao listar por cpf/cnpj
            ClienteInternetBean beanBuscaPorCpf = (ClienteInternetBean) (new ClienteInternetBean()).newBean();

            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                    .getAttribute(USUARIOLDAP_BEAN);

            beanBuscaPorCpf.setTipoPessoaCedente(clienteInternetBean.getTipoPessoaCedente());
            beanBuscaPorCpf.setCpfCnpjCedente(clienteInternetBean.getCpfCnpjCedente());
            beanBuscaPorCpf.setCpfUsuario(clienteInternetBean.getCpfUsuario());
            beanBuscaPorCpf.setCodigoUsuario(usuarioBean.getCodigoUsuario());
            // Chama a Transacao BGFJ
            BeanList beanListaCedentes = null;
            try {
                 usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
                String transUser = TRANSACAO_LISTAR_USUARIO + usuarioBean.getCodigoUsuario().toUpperCase();
                beanListaCedentes = (BeanList) handler.executeSimpleTransactionQuery(beanBuscaPorCpf,
                		 transUser);
            } catch (Exception e) {
                request.getSession()
                        .removeAttribute(CliInteEstrategia.CEDENTE_CABECALHO_BEAN);
                throw e;
            }

            prepararListaRequest(request, beanListaCedentes);

            page = PAGE_INCLUIR_LISTAR;
        } else {
            buscarCabecalho(request, clienteInternetBean);
            // verificar se já incluído BGFE
            ClienteInternetBean clienteInternetBean2 = new ClienteInternetBean();
            clienteInternetBean2.setCpfUsuario(clienteInternetBean.getCpfUsuario());
            clienteInternetBean2.setCodigoCedente(clienteInternetBean.getCodigoCedente());
            clienteInternetBean2.setTipoAcao("V");
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_INCLUIR_ALTERAR_REL + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList detalheList = handler.executeSimpleTransactionQuery(clienteInternetBean2,
            		transUser);
            ClienteInternetBean clienteInternetAtual = (ClienteInternetBean) detalheList.get(0);
            if (clienteInternetAtual.getUsuarioExistente().equals("S")) {
                if (clienteInternetAtual.getCpfUsuario()
                        .equals(clienteInternetBean.getCpfUsuario()))
                    // GMG:27.11.2004: Mensagem Alterada segundo solicitação
                    // do Sergio REDEA nesta data
                    throw new WrappingException(new Exception("USUARIO JA ESTA CADASTRADO PARA ESTE CLIENTE INTERNET."));

                request.getSession().setAttribute("cpfUsuarioNovo",
                        clienteInternetBean.getCpfUsuario());
                // cpfusuario atual (se houver)

                // GMG:27.11.2004, ini:
                // Incluida funcionalidade para confirmar inclusao de
                // relacionamento para cedentes sem relacionamento com usuario
                // Retirada funcionalidade para alterar relacionamento qdo
                // cedente ja possui relacionamento com algum usuario
                // em lugar da funcionalidade apresentar exception.
                if (clienteInternetAtual.getCpfUsuario().equals(new Long(0))) {
                    clienteInternetAtual.setCpfUsuario(clienteInternetBean.getCpfUsuario());
                     usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
                     transUser = TRANSACAO_CONSULTAR_DETALHE + usuarioBean.getCodigoUsuario().toUpperCase();
                    BeanList clienteInternetBeanList = handler.executeSimpleTransactionQuery(clienteInternetAtual,
                    		transUser);
                    clienteInternetBean2 = (ClienteInternetBean) clienteInternetBeanList.get(0);
                    clienteInternetBean2.setCodigoCedente(clienteInternetBean.getCodigoCedente());
                    clienteInternetBean2.setNomeUsuario(clienteInternetBean2.getNome());// GMB
                    clienteInternetBean2.setNome(clienteInternetBean.getNome());
                    clienteInternetBean2.setCpfUsuario(clienteInternetAtual.getCpfUsuario());
                    clienteInternetBean2.setCpfCnpjCedente(clienteInternetBean.getCpfCnpjCedente()); 
                    // GMG:27.11.2004: Incluido para tela de erro

                    request.getSession().setAttribute(DATA_BEAN,
                            clienteInternetBean2);

                    page = PAGE_INCLUIR_REL;
                } else {
                    throw new WrappingException(new Exception("CEDENTE JA POSSUI RELACIONAMENTO COM OUTRO USUARIO SUPER MASTER."));
                }
                // GMG:27.11.2004, fim

            } else {
                page = PAGE_INCLUIR;
            }
        }

        return page;
    }

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