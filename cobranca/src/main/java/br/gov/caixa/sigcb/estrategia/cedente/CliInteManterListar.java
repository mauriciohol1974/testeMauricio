package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
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
public class CliInteManterListar extends CliInteEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);
        ClienteInternetBean clienteInternetBean = iniciarProcessRequest(request,
                FILTRO_BEAN);

        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute("usuarioLdap");
        clienteInternetBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
       // MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        BeanList beanListaCedentes;
        if (clienteInternetBean.getTipoPesquisa().equals(new Long(1))
            || clienteInternetBean.getTipoPesquisa().equals(new Long(2))) {// cpfcnpj
            // e
            // cedente
            // Chama a Transacao BGFA
             usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_LISTAR_CEDENTE + usuarioBean.getCodigoUsuario().toUpperCase();
            beanListaCedentes = (BeanList) handler.executeSimpleTransactionQuery(clienteInternetBean,
            		transUser);
            if (clienteInternetBean.getTipoPesquisa().equals(new Long(1))) {// consulta
                // por
                // 1 -
                // CPF/CNPJ
                prepararListaRequest(request, beanListaCedentes);

                return PAGE_MANTER_LISTAR_CPFCNPJ;
            } else {// consulta por 2 - CODIGO CEDENTE
                request.getSession().setAttribute("cedente",
                        clienteInternetBean.getCodigoCedente());
                ClienteInternetBean clienteInternetBean2 = (ClienteInternetBean) beanListaCedentes.get(0);
                clienteInternetBean.setNome(clienteInternetBean2.getNome());
                clienteInternetBean.setCpfUsuario(clienteInternetBean2.getCpfUsuario());
                clienteInternetBean.setNomeUsuario(clienteInternetBean2.getNomeUsuario());
                request.getSession().setAttribute(FILTRO_BEAN,
                        clienteInternetBean);

                return PAGE_MANTER_LISTAR_CED;
            }
        } else { // 3 - cpf usuario
             usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_LISTAR_CEDENTE_USU + usuarioBean.getCodigoUsuario().toUpperCase();
            List list = (List) handler.executeFixDataRecordsetTransaction(clienteInternetBean,
            		transUser);
            beanListaCedentes = (BeanList) list.get(1);
            prepararListaRequest(request, beanListaCedentes);
            // parte fixa
            ClienteInternetBean clienteInternetBean2 = (ClienteInternetBean) (((BeanList) list.get(0)).get(0));
            clienteInternetBean.setNomeUsuario(clienteInternetBean2.getNomeUsuario());
            request.getSession().setAttribute(FILTRO_BEAN, clienteInternetBean);

            return PAGE_MANTER_LISTAR_CPFUSU;
        }
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_MANTER_FILTRO);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}