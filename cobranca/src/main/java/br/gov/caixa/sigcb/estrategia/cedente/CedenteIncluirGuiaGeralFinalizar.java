package br.gov.caixa.sigcb.estrategia.cedente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteEletronicoBean;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Incluir Cedente - Guia
 * Geral
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>18/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteIncluirGuiaGeralFinalizar extends CedenteIncluirEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        this.configMsgSucessoErro(request);

        CedenteGeralBean geralBean = (CedenteGeralBean) (new CedenteGeralBean()).getRequestBean(request);
        CedenteGeralBean resposta = (CedenteGeralBean) (new CedenteGeralBean()).newBean();

        // seta novamente o bean para caso aconteca algum problema os dados nao
        // se perderem
        request.getSession().setAttribute(CEDENTE_GERAL_BEAN, geralBean);

        // setando atributos que nao vem da tela
        geralBean.setCodigoUsuario(this.getCodigoUsuario(request));

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_INCLUIR_ALTERAR_GERAL + usuarioBean.getCodigoUsuario().toUpperCase();
        if (!usuarioBean.getNomeGrupo().equalsIgnoreCase("GCBADM")){
        	geralBean.setModalidadeTitulo(2L);
        }
        BeanList blResposta = handler.executeSimpleTransactionQuery(geralBean,	transUser);

        // seta no bean o tipo cobranca e o cedente centralizador para controle
        // da guia de Cedente Eletronico
        CedenteIncluirGuiaControle.setTipoCobranca(request,
                geralBean.getTipoCobranca());
        CedenteIncluirGuiaControle.setCedenteCentralizador(request,
                geralBean.getCodCedenteCentraliz());

        // Verifica criticas
        if (blResposta.size() > 0) {
            resposta = (CedenteGeralBean) blResposta.get(0);
        }

        // se inclusao com sucesso avanca a guia em cadastramento
        // e nao houver criticas
        if (geralBean.getTipoAcao().equals("I")
            && resposta.getDescricaoCriticas().trim().equals("")) {
            CedenteIncluirGuiaControle.avancaGuiaEmCadastramento(request);
        }

        // se foi alteracao e mudou para eletronico
        if (geralBean.getTipoAcao().equals("S")
            && geralBean.getTipoCobranca().equals(new Long(1))) { // Tipo
                                                                    // Cobranca
                                                                    // -
                                                                    // ELETRONICO
            this.verificaCedenteEletronico(request, geralBean);
        }

        // LogUtilSigcb.debug("#$% descricao criticas ::::::::: " +
        // resposta.getDescricaoCriticas());
        // LogUtilSigcb.debug("#$% bean :: >>>>> " + resposta);

        return CedenteIncluirGuiaControle.proximaGuia(request,
                resposta.getDescricaoCriticas(),
                PAGE_INCLUIR_GERAL,
                PAGE_INCLUIR_PRINCIPAL);
    }

    private void verificaCedenteEletronico(HttpServletRequest request,
            CedenteGeralBean geralBean) throws Exception {
        CedenteEletronicoBean eletronBean = (CedenteEletronicoBean) new CedenteEletronicoBean().newBean();
        eletronBean.setTipoAcao("I"); // I - Tabela inclusao
        eletronBean.setCodigoClienteCOCLI(geralBean.getCodigoClienteCOCLI());
        eletronBean.setCodigoUnidadePVVinc(geralBean.getCodigoUnidadePVVinc());
        eletronBean.setSituacao(new Long(1)); // 1 - Teste

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_SITUACAO_CEDENTE_ELETRONICO + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList blResposta = handler.executeSimpleTransactionQuery(eletronBean,
        		transUser);
        eletronBean = (CedenteEletronicoBean) blResposta.get(0);

        if ("S".equals(eletronBean.getCadastrado())) {
            CedenteIncluirGuiaControle.setCedenteEletronicoCadastrado(request,
                    true);
        } else {
            CedenteIncluirGuiaControle.setCedenteEletronicoCadastrado(request,
                    false);
        }

    }
}
