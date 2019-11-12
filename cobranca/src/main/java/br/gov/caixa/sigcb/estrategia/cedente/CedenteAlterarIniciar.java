package br.gov.caixa.sigcb.estrategia.cedente;

import java.rmi.RemoteException;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.WrappingException;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.CedenteConteudoListaBean;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.CedentePrincipalBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.PrivilegioUsuarioBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.ejb.session.MainframeException;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.regras.historicoGuias.HistoricoGuia;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Manter Cedente >>
 * Alterar
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>16/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteAlterarIniciar extends CedenteEstrategia {

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_FILTRO);
        msgBean.setStrategySucessReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setTitlePage(PAGE_MANTER_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);

        // Recupera o grupo que o usuário pertence.
        InformacoesUsuarioBean usuarioLDAP = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(CedenteEstrategia.USUARIOLDAP_BEAN);

        // Se fluxo normal chama transacoes
        // senao nao faz nada, os beans ja devem existir no ambiente
        if (fluxo.equals(FLUXO_NORMAL)) {
            // LogUtilSigcb.info("====> FLUXO NORMAL");

            String codigoUsuario = this.getCodigoUsuario(request);

            // Bean usado para pegar codigo do cedente
            CedenteConteudoListaBean beanFiltro = (CedenteConteudoListaBean) (new CedenteConteudoListaBean()).getRequestBean(request);

            // coloca o bean na pilha para o botao voltar
            PilhaVoltarControle.push(request, beanFiltro);

            // EAM - Informando a mensagem inicial de alerta se o cedente
            // foi alterado.
            setMensagemAlteracao(request, ALTERACAO_GUIA_MENSAGEM_INICIAL);

            // criando bean de controle de guias
            CedentePrincipalBean principalBean = (CedentePrincipalBean) (new CedentePrincipalBean()).newBean();
            request.getSession().setAttribute(CEDENTE_PRINCIPAL_BEAN,
                    principalBean);

            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

            // Obtendo dados de cabecalho
            CedenteCabecaBean cedenteCabecaBean = (CedenteCabecaBean) (new CedenteCabecaBean()).newBean();
            cedenteCabecaBean.setTipoConsulta(new Long(1)); // 1 - Consulta
            // Por Codigo
            // Cedente
            cedenteCabecaBean.setCodigoCedente(beanFiltro.getCodigoCedente());
            cedenteCabecaBean.setCodigoClienteCOCLI(new Long(0));
            cedenteCabecaBean.setCodigoUsuario(codigoUsuario);
            cedenteCabecaBean.setOrigemConsulta(new Long(1)); // 1 - Intranet
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CABECALHO + usuarioBean.getCodigoUsuario().toUpperCase();
            
            BeanList respostaList = handler.executeSimpleTransactionQuery(cedenteCabecaBean,transUser);
            cedenteCabecaBean = (CedenteCabecaBean) respostaList.get(0);

            // guardando o codigo do cedente no bean do cabecalho
            cedenteCabecaBean.setCodigoCedente(beanFiltro.getCodigoCedente());
            String ip = request.getRemoteAddr();
            // Se cedente Inativo, reativa
            if ("I".equals(beanFiltro.getSituacao())) {
                this.reativaCedente(beanFiltro.getCodigoCedente(),
                        codigoUsuario,
                        cedenteCabecaBean.getNomeFantasia(),
                        cedenteCabecaBean.getCodigoClienteCOCLI(),
                        this.descobrePV(request, handler),
                        cedenteCabecaBean.getIdEndereco(),
                        handler,
                        ip);
            }

            // Obtendo NsuTransacao
            String id = request.getSession().getId().toString();
            String timeStamp = String.valueOf(System.currentTimeMillis());
            String nsuTransacao = id + timeStamp;

            beanFiltro.setNsuTransacao(nsuTransacao);

            // Inicializando Alteracao
             usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
             transUser = TRANSACAO_CONTROLE_ALTERACAO + usuarioBean.getCodigoUsuario().toUpperCase();
            
            respostaList = handler.executeSimpleTransactionQuery(beanFiltro,transUser);
            beanFiltro.setSituacao(((CedenteConteudoListaBean) respostaList.get(0)).getSituacao());
            beanFiltro.setExcepPendente(((CedenteConteudoListaBean) respostaList.get(0)).getExcepPendente());

            CedenteGeralBean geralBeanTransacoesGuias = (CedenteGeralBean) (new CedenteGeralBean()).getRequestBean(request);
            geralBeanTransacoesGuias.setCodigoCedente(cedenteCabecaBean.getCodigoCedente());
            geralBeanTransacoesGuias.setCodigoUsuario(codigoUsuario);
            geralBeanTransacoesGuias.setNsuTransacao(nsuTransacao);

            request.getSession()
                    .setAttribute(CEDENTE_GERAL_BEAN_TRANSACOES_GUIAS,
                            geralBeanTransacoesGuias);

            request.getSession().setAttribute(LISTA_GUIAS_ALTERADAS,
                    new LinkedList<HistoricoGuia>());

            // descobre cargo e pv que o usuario eh vinculado
            this.setaPrivilegioUsuario(codigoUsuario, request, handler);

            // Setando beans no ambiente
            request.getSession().setAttribute(CEDENTE_CABECA_BEAN,
                    cedenteCabecaBean);
            request.getSession().setAttribute(ALTERAR_FILTRO_BEAN, beanFiltro);

        }
        // Condição especial para usuários do CIATI.
        // 28/02/2008
        if (usuarioLDAP.getNomeGrupo().equals("GCBATE")) {
            return CedenteEstrategia.PAGE_ALTERAR_PRINCIPAL_CIATI;
        } else {
            return PAGE_ALTERAR_PRINCIPAL;
        }
    }

    private Long descobrePV(HttpServletRequest request,
            MainFrameTransactionsSigcbEjb handler) throws Exception {
        // Chama BG03 para descobrir o PV
        CedenteGeralBean geralBean = (CedenteGeralBean) (new CedenteGeralBean()).getRequestBean(request);
        geralBean.setTipoConsulta("C");
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CONSULTAR_GERAL + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList blGeral = handler.executeSimpleTransactionQuery(geralBean,transUser);
        geralBean = (CedenteGeralBean) blGeral.get(0);
        return geralBean.getCodigoUnidadePVVinc();
    }

    private void setaPrivilegioUsuario(String codigoUsuario,
            HttpServletRequest request,
            MainFrameTransactionsSigcbEjb handler) throws RemoteException,
            MainframeException, WrappingException {
        PrivilegioUsuarioBean privilegio = new PrivilegioUsuarioBean();
        privilegio.setCodigoUsuario(codigoUsuario);
        
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_USUARIO + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList privilegioList = handler.executeSimpleTransactionQuery(privilegio,
        		transUser);
        privilegio = (PrivilegioUsuarioBean) privilegioList.get(0);
        request.getSession().setAttribute(PRIVILEGIO_BEAN, privilegio);
    }

    private void reativaCedente(Long codigoCedente,
            String codigoUsuario,
            String nomeFantasia,
            Long codigoClienteCOCLI,
            Long codigoUnidadePVVinc,
            Long idEndereco,
            MainFrameTransactionsSigcbEjb handler,
            String ip) throws Exception {
        // Chama BG27 para reativar
        CedenteCabecaBean excluirBean = (CedenteCabecaBean) (new CedenteCabecaBean()).newBean();
        excluirBean.setCodigoCedente(codigoCedente);
        excluirBean.setCodigoUsuario(codigoUsuario);
        excluirBean.setNomeFantasia(nomeFantasia);
        excluirBean.setCodigoClienteCOCLI(codigoClienteCOCLI);
        excluirBean.setCodigoUnidadePVVinc(codigoUnidadePVVinc);
        excluirBean.setIdEndereco(idEndereco);
        excluirBean.setTipoAcao("R"); // R - Reativar
        excluirBean.setIp(ip);
       
        handler.executeSimpleTransactionVoid(excluirBean,
                TRANSACAO_EXCLUIR_REATIVAR);
    }

}
