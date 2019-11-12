package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.Currency;
import br.com.politec.sao.util.Formatacao;
import br.com.politec.sao.util.Money;
import br.gov.caixa.iso.ISOMsg;
import br.gov.caixa.sigcb.bean.CedConsultaPermissaoBean;
import br.gov.caixa.sigcb.bean.CedenteBloquetosBean;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.CedenteConclusaoBean;
import br.gov.caixa.sigcb.bean.CedenteContasBean;
import br.gov.caixa.sigcb.bean.CedenteEletronicoBean;
import br.gov.caixa.sigcb.bean.CedenteFloatBean;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.CedenteMensagensBean;
import br.gov.caixa.sigcb.bean.CedenteParametrosBean;
import br.gov.caixa.sigcb.bean.CedentePrincipalBean;
import br.gov.caixa.sigcb.bean.CedenteTarifasBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.ejb.session.MainframeException;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.sirot.transaction.MontaTransacao;
import br.gov.caixa.sigcb.sirot.transaction.SirotAdaptadorSIGCB;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.Util;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Incluir Cedente -
 * Controle de Guias
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>14/10/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteAlterarGuiaControle extends CedenteGuiaControle {

    /**
     * Quando uma inclusao de guia eh completada com sucesso, eh chamada esse
     * metodo para avanco da guia em cadastramento
     */
    public static void avancaGuiaEmCadastramento(HttpServletRequest request)
            throws Exception {
        CedentePrincipalBean principalBean = (CedentePrincipalBean) request.getSession()
                .getAttribute(CedenteEstrategia.CEDENTE_PRINCIPAL_BEAN);
        CedenteGeralBean beanFiltro = (CedenteGeralBean) request.getSession()
                .getAttribute(CedenteEstrategia.INCLUIR_FILTRO_BEAN);

        if (principalBean != null) {
            principalBean.setUltimaGuiaCadastrada(new Integer(principalBean.getUltimaGuiaCadastrada()
                    .intValue() + 1));
        } else {
            principalBean = new CedentePrincipalBean();

            // verificando guia em cadastramento pela transacao
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_SITUACAO_CADASTRO + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList respostaList = handler.executeSimpleTransactionQuery(beanFiltro,
            		transUser);
            CedenteGeralBean respostaBean = (CedenteGeralBean) respostaList.get(0);

            // criando bean de controle de guias
            principalBean.setUltimaGuiaCadastrada(respostaBean.getUltimaGuiaCadastrada());
        }

        // Verifica se pode cadastrar Cedente Eletronico
        // se nao puder, avanca a guia mais uma vez
        int guiaEmCadastramento = principalBean.getUltimaGuiaCadastrada()
                .intValue() + 1;

        if (guiaEmCadastramento == CedenteEstrategia.GUIA_CEDENTE_ELETRONICO
            && principalBean.naoPodeCedenteEletronico()) {
            principalBean.setUltimaGuiaCadastrada(new Integer(principalBean.getUltimaGuiaCadastrada()
                    .intValue() + 1));
        }

        request.getSession()
                .setAttribute(CedenteEstrategia.INCLUIR_FILTRO_BEAN, beanFiltro);
        request.getSession()
                .setAttribute(CedenteEstrategia.CEDENTE_PRINCIPAL_BEAN,
                        principalBean);

        // limpa descricoes criticas
        request.setAttribute(CedenteEstrategia.DESC_CRITICAS, null);
    }

    /**
     * Retorna a proxima guia baseado nas descCriticas passadas Se houver
     * criticas seta no request a critica e retorna a guia atual Senao retorna a
     * proximaGuia
     */
    public static String proximaGuia(HttpServletRequest request,
            String descCriticas,
            String guiaAtual,
            String proximaGuia) throws Exception {
        if (!descCriticas.trim().equals("")) {
            request.setAttribute(CedenteEstrategia.DESC_CRITICAS, descCriticas);
            return guiaAtual;
        }
        request.setAttribute(CedenteEstrategia.DESC_CRITICAS, "");

        // EAM - Informando a mensagem de alerta se o cedente foi alterado.
        setMensagemAlteracao(request, ALTERACAO_GUIA_MENSAGEM);

        return proximaGuia;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_ALTERAR_INICIAR);
        msgBean.setStrategySucessReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setTitlePage(PAGE_MANTER_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        if (request.getSession().getAttribute(SITUACAO_ELETRONICO) == null) {
            String situacaoEletronico = new String(request.getParameter("situacaoEletronico"));
            request.getSession().setAttribute(SITUACAO_ELETRONICO,
                    situacaoEletronico);

        }

        this.configMsgSucessoErro(request);

        CedentePrincipalBean principalBean = new CedentePrincipalBean();
        principalBean = (CedentePrincipalBean) principalBean.getRequestBean(request);

        int guia = CedenteAlterarGuiaControle.mudaGuiaAberta(principalBean,
                request);
        String returnPage = PAGE_ALTERAR_PRINCIPAL;

        switch (guia) {
        case GUIA_GERAL:
            this.guiaGeralIniciar(request);
            returnPage = PAGE_ALTERAR_GERAL;
            break;
        case GUIA_FLOAT:
            this.guiaFloatIniciar(request);
            returnPage = PAGE_ALTERAR_FLOAT;
            break;
        case GUIA_CONTAS:
            this.guiaContasIniciar(request);
            returnPage = PAGE_ALTERAR_CONTAS;
            break;
        case GUIA_CEDENTE_ELETRONICO:
            returnPage = this.guiaCedenteEletronicoIniciar(request);
            break;
        case GUIA_CEDENTE_ELETRONICO_CIATI:
            returnPage = this.guiaCedenteEletronicoIniciar(request);
            break;
        case GUIA_BLOQUETOS:
            this.guiaBloquetosIniciar(request);
            returnPage = PAGE_ALTERAR_BLOQUETOS;
            break;
        case GUIA_MENSAGENS:
            this.guiaMensagensIniciar(request);
            returnPage = PAGE_ALTERAR_MENSAGENS;
            break;
        case GUIA_TARIFAS:
            this.guiaTarifasIniciar(request);
            returnPage = PAGE_ALTERAR_TARIFAS;
            break;
        case GUIA_PARAMETROS:
        	this.guiaParametrosIniciar(request);
        	returnPage = PAGE_ALTERAR_PARAMETROS;
        	break;
        case GUIA_PERMISSAO:
        	this.guiaPermissaoIniciar(request);
        	returnPage = PAGE_ALTERAR_PERMISSAO;
        	break;        	
        case GUIA_CONCLUSAO:
            this.guiaConclusaoIniciar(request);
            returnPage = PAGE_ALTERAR_CONCLUSAO;
            break;
        }

        return returnPage;

    }

    /**
     * @param request
     */
    private void guiaConclusaoIniciar(HttpServletRequest request)
            throws Exception {
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
    	  MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        // Consulta a guia geral
        // Usado para saber o EN
        /*
         * CedenteGeralBean geralBean = (CedenteGeralBean)
         * request.getSession().getAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN);
         * if (geralBean == null) { geralBean = (CedenteGeralBean) (new
         * CedenteGeralBean()).getRequestBean(request); // Codigo COCLI e Codigo
         * Unidade PV vem da transacao geralBean.setTipoConsulta("A"); // A -
         * Alteracao BeanList beanListGeral =
         * handler.executeSimpleTransactionQuery(geralBean,
         * TRANSACAO_CONSULTAR_GERAL); geralBean = (CedenteGeralBean)
         * beanListGeral.get(0);
         * request.getSession().setAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN,
         * geralBean); }
         */

        // Consulta dados da conclusao
        CedenteConclusaoBean conclusaoBean = (CedenteConclusaoBean) (new CedenteConclusaoBean()).newBean();
        conclusaoBean = (CedenteConclusaoBean) conclusaoBean.getRequestBean(request);
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CONSULTAR_CONCLUSAO + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList beanListTarifas = handler.executeSimpleTransactionQuery(conclusaoBean,	transUser);
        conclusaoBean = (CedenteConclusaoBean) beanListTarifas.get(0);

        request.setAttribute(CedenteEstrategia.CEDENTE_CONCLUSAO_BEAN,
                conclusaoBean);
    }

    /**
     * @param request
     */
    private void guiaTarifasIniciar(HttpServletRequest request)
            throws Exception {
        CedenteTarifasBean tarifasBean = (CedenteTarifasBean) (new CedenteTarifasBean()).newBean();

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        tarifasBean = (CedenteTarifasBean) tarifasBean.getRequestBean(request);

        tarifasBean.setTipoConsulta("A"); // A - Alteracao
        
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CONSULTAR_TARIFAS + usuarioBean.getCodigoUsuario().toUpperCase();

        BeanList beanListTarifas = handler.executeSimpleTransactionQuery(tarifasBean,transUser);

        tarifasBean = (CedenteTarifasBean) beanListTarifas.get(0);

        request.setAttribute(CedenteEstrategia.CEDENTE_TARIFAS_BEAN,
                tarifasBean);
    }

    /**
     * @param request
     */
    private void guiaMensagensIniciar(HttpServletRequest request)
            throws Exception {

        Long[] locaisImpressao = {
                                  new Long(BLOQ_PADRAO_RECIBO_SACADO),
                                  new Long(BLOQ_PADRAO_VERSO_BLOQUETO),
                                  new Long(BLOQ_PADRAO_FICHA_COMP),
                                  new Long(BLOQ_PERSONALIZADO_RECIBO_SACADO),
                                  new Long(BLOQ_PERSONALIZADO_VERSO_BLOQUETO),
                                  new Long(BLOQ_PERSONALIZADO_FICHA_COMP),
                                  new Long(BLOQ_PERSONALIZADO_RECIBO_SACADO_A),
                                  new Long(BLOQ_PERSONALIZADO_RECIBO_SACADO_B),
                                  new Long(BLOQ_PRE_IMPRESSO_RECIBO_SACADO_LASER),
                                  new Long(BLOQ_PRE_IMPRESSO_FICHA_COMP_MATRIC),
                                  new Long(BLOQ_BANCO_CORRESPONDENTE),
                                  new Long(BLOQ_DDA_IMPRESSO)};

        CedenteMensagensBean mensagensBean = (CedenteMensagensBean) (new CedenteMensagensBean()).newBean();
        mensagensBean = (CedenteMensagensBean) mensagensBean.getRequestBean(request);
        mensagensBean.setTipoConsulta("A"); // A - Alteracao

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        // Chama transacao para cada local de impressao
        for (int i = 0; i < locaisImpressao.length; i++) {
            mensagensBean.setLocalImpressao(locaisImpressao[i]);
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CONSULTAR_MENSAGENS + usuarioBean.getCodigoUsuario().toUpperCase();

            BeanList beanListMensagens = handler.executeSimpleTransactionQuery(mensagensBean,transUser);

            // Obtendo as linhas da mensagem do beanList
            String[] linhasTextArea = new String[beanListMensagens.size()];
            for (int j = 0; j < beanListMensagens.size(); j++) {
                CedenteMensagensBean tempBean = (CedenteMensagensBean) beanListMensagens.get(j);
                linhasTextArea[tempBean.getNumeroLinhaMensagem().intValue() - 1] = tempBean.getMensagem();
            }

            // Junta as linhas numa string colocando \n
            String textArea = "";
            for (int j = 0; j < linhasTextArea.length; j++) {
                textArea += linhasTextArea[j] + "\\n";
            }

            // seta no atributo correto dependendo do local de impressao
            switch (locaisImpressao[i].intValue()) {
            case BLOQ_PADRAO_RECIBO_SACADO:
                mensagensBean.setTextAreaReciboSacadoBlqPadrao(textArea);
                break;
            case BLOQ_PADRAO_VERSO_BLOQUETO:
                mensagensBean.setTextAreaVersoBloquetoBlqPadrao(textArea);
                break;
            case BLOQ_PADRAO_FICHA_COMP:
                mensagensBean.setTextAreaFichaCompensacaoBlqPadrao(textArea);
                break;
            case BLOQ_PERSONALIZADO_RECIBO_SACADO:
                mensagensBean.setTextAreaReciboSacadoBlqPersonalizado(textArea);
                break;
            case BLOQ_PERSONALIZADO_VERSO_BLOQUETO:
                mensagensBean.setTextAreaVersoBloquetoBlqPersonalizado(textArea);
                break;
            case BLOQ_PERSONALIZADO_FICHA_COMP:
                mensagensBean.setTextAreaFichaCompensacaoBlqPersonalizado(textArea);
                break;
            case BLOQ_PERSONALIZADO_RECIBO_SACADO_A:
                mensagensBean.setTextAreaReciboSacadoABlqPersonalizado(textArea);
                break;
            case BLOQ_PERSONALIZADO_RECIBO_SACADO_B:
                mensagensBean.setTextAreaReciboSacadoBBlqPersonalizado(textArea);
                break;
            case BLOQ_PRE_IMPRESSO_RECIBO_SACADO_LASER:
                mensagensBean.setTextAreaReciboSacadoBlqPreImpresso(textArea);
                break;
            case BLOQ_PRE_IMPRESSO_FICHA_COMP_MATRIC:
                mensagensBean.setTextAreaFichaCompensacaoBlqPreImpresso(textArea);
                break;
            case BLOQ_BANCO_CORRESPONDENTE:
                mensagensBean.setTextAreaReciboSacadoBancoCorresp(textArea);
                break;
            case BLOQ_DDA_IMPRESSO:
            	mensagensBean.setTextAreaReciboDDAImpresso(textArea);
            	break;
            }

        }

        request.setAttribute(CedenteEstrategia.CEDENTE_MENSAGENS_BEAN,
                mensagensBean);
    }

    /**
     * @param request
     */
    private void guiaBloquetosIniciar(HttpServletRequest request)
            throws Exception {
        CedenteBloquetosBean bloqBean = (CedenteBloquetosBean) (new CedenteBloquetosBean()).newBean();

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        bloqBean = (CedenteBloquetosBean) bloqBean.getRequestBean(request);

        bloqBean.setTipoConsulta("A"); // A - Alteracao
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CONSULTAR_BLOQUETO + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList beanListBloq = handler.executeSimpleTransactionQuery(bloqBean,transUser);

        bloqBean = (CedenteBloquetosBean) beanListBloq.get(0);

        // se foi escolhido Envio do Aviso Sacado, entao Aviso Sacado eh Sim
        if (!new Long(99).equals(bloqBean.getEnvioAvisoSacado())) {
            bloqBean.setAvisoSacado("S");
        }

        request.setAttribute(CedenteEstrategia.CEDENTE_BLOQUETOS_BEAN, bloqBean);
    }

    /**
     * @param request
     */
    private String guiaCedenteEletronicoIniciar(HttpServletRequest request)
            throws Exception {

        CedenteEletronicoBean producaoBean = (CedenteEletronicoBean) (new CedenteEletronicoBean()).newBean();
        CedenteEletronicoBean testeBean = (CedenteEletronicoBean) (new CedenteEletronicoBean()).newBean();

        CedenteEletronicoBean eletronBean = (CedenteEletronicoBean) (new CedenteEletronicoBean()).getRequestBean(request);

        InformacoesUsuarioBean usuarioLDAP = (InformacoesUsuarioBean) request.getSession().getAttribute(CedenteEstrategia.USUARIOLDAP_BEAN);

        String situacaoProducao = "";
        String situacaoTeste = "";

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        // Obtendo dados da guia geral para saber tipo de Cobranca
        CedenteGeralBean geralBean = (CedenteGeralBean) (new CedenteGeralBean()).getRequestBean(request);
        geralBean.setTipoConsulta("A");
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CONSULTAR_GERAL + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList beanListGeral = handler.executeSimpleTransactionQuery(geralBean,  transUser);
        geralBean = (CedenteGeralBean) beanListGeral.get(0);
        if ((geralBean.getTipoCobranca().equals(CedenteEstrategia.COBRANCA_CONVENCIONAL)) || (geralBean.getTipoCobranca().equals(CedenteEstrategia.COBRANCA_ELEITORAL_CONVENCIONAL))) {
            return CedenteAlterarGuiaControle.proximaGuia(request,
                    "NAO E POSSIVEL ALTERAR CEDENTE ELETRONICO, TIPO DE COBRANCA CONVENCIONAL",
                    CedenteEstrategia.PAGE_ALTERAR_PRINCIPAL,
                    CedenteEstrategia.PAGE_ALTERAR_PRINCIPAL);
        }
        if (geralBean.getCodCedenteCentraliz() != null
            && !geralBean.getCodCedenteCentraliz().equals(new Long(0))) {
            return CedenteAlterarGuiaControle.proximaGuia(request,
                    "NAO E POSSIVEL ALTERAR CEDENTE ELETRONICO, CEDENTE CENTRALIZADO - NAO POSSUI DADOS DE ENDERECO ELETRONICO",
                    CedenteEstrategia.PAGE_ALTERAR_PRINCIPAL,
                    CedenteEstrategia.PAGE_ALTERAR_PRINCIPAL);
        }

        // Descobrindo situacao dos Cedente Eletronicos de Teste e Producao
        eletronBean.setTipoAcao("A"); // I - Tabela inclusao
        eletronBean.setSituacao(new Long(1)); // 1 - Teste
        situacaoTeste = this.isCedenteEletronicoCadastrado(eletronBean);

        eletronBean.setSituacao(new Long(2)); // 2 - Producao
        situacaoProducao = this.isCedenteEletronicoCadastrado(eletronBean);

        if (situacaoProducao.equals("S") || situacaoTeste.equals("S")) {
            eletronBean.setTipoConsulta("A"); // A - Alteracao
            
            transUser = TRANSACAO_CONSULTAR_CEDENTE_ELETRONICO + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList beanListEletron = handler.executeSimpleTransactionQuery(eletronBean,transUser);

            // beanListEletron.size());

            for (int i = 0; i < beanListEletron.size(); i++) {
                CedenteEletronicoBean respostaBean = (CedenteEletronicoBean) beanListEletron.get(i);
                if (new Long(1).equals(respostaBean.getSituacao())) { // 1-Teste
                    testeBean = respostaBean;
                    LogUtilSigcb.debug("TESTE:" + testeBean.getCodConnect());
                } else if (new Long(2).equals(respostaBean.getSituacao())) { // 2-Producao
                    producaoBean = respostaBean;
                    LogUtilSigcb.debug("Producao:" + producaoBean.getCodConnect());
                }
            }
        }



        testeBean.setCadastrado(situacaoTeste);
        producaoBean.setCadastrado(situacaoProducao);

        request.setAttribute(CedenteEstrategia.CEDENTE_ELETRONICO_TESTE_BEAN,
                testeBean);
        request.setAttribute(CedenteEstrategia.CEDENTE_ELETRONICO_PRODUCAO_BEAN,
                producaoBean);

        // Condição especial para usuários do CIATI
        // 28/02/2008
        if (usuarioLDAP.getNomeGrupo().equals("GCBATE")) {
            return CedenteEstrategia.PAGE_ALTERAR_CEDENTE_ELETRONICO_CIATI;
        } else {
            return CedenteEstrategia.PAGE_ALTERAR_CEDENTE_ELETRONICO;
        }
    }

    // Retorna "S" se cadastrado, "N" se nao
    private String isCedenteEletronicoCadastrado(CedenteEletronicoBean eletronBean)
            throws Exception {

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
    	  MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        BeanList blResposta = handler.executeSimpleTransactionQuery(eletronBean,   TRANSACAO_SITUACAO_CEDENTE_ELETRONICO);
        CedenteEletronicoBean respostaBean = (CedenteEletronicoBean) blResposta.get(0);

        return respostaBean.getCadastrado();
    }

    /**
     * @param request
     */
    private void guiaContasIniciar(HttpServletRequest request) throws Exception {
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
    	  MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        // Consulta a guia geral se nao estiver no ambiente as informacoes
        // Usado para saber a modalidade titulo
        CedenteGeralBean geralBean = (CedenteGeralBean) request.getSession()
                .getAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN);
        if (geralBean == null) {
            geralBean = (CedenteGeralBean) (new CedenteGeralBean()).getRequestBean(request);
            geralBean.setTipoConsulta("A"); // A - Alteracao
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CONSULTAR_GERAL + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList beanListGeral = handler.executeSimpleTransactionQuery(geralBean,transUser);
            geralBean = (CedenteGeralBean) beanListGeral.get(0);
            request.getSession()
                    .setAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN,
                            geralBean);
        }

        // Consulta as contas ja cadastradas
        CedenteContasBean contasBean = (CedenteContasBean) (new CedenteContasBean()).newBean();

        contasBean = (CedenteContasBean) contasBean.getRequestBean(request);

        contasBean.setTipoConsulta("A"); // A - alteracao
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CONSULTAR_CONTAS + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList beanListContas = handler.executeSimpleTransactionQuery(contasBean,transUser);

        ArrayList alContaRateioUnidade = new ArrayList();
        ArrayList alContaRateioOperacao = new ArrayList();
        ArrayList alContaRateioConta = new ArrayList();
        ArrayList alContaRateioDV = new ArrayList();
        ArrayList alTxtPercCredito = new ArrayList();
        ArrayList alTxtPercDebito = new ArrayList();
        ArrayList alValorRateio = new ArrayList();
        ArrayList alContaCpfCnpj = new ArrayList();
        ArrayList alContaTitular = new ArrayList();

        // Guarda os indice do ArrayList da conta da chave
        // A chave eh a unidade, operacao, conta e dv concatenados como String
        // Usado porque uma conta rateio que eh de credito e debito eh salva em
        // 2 registros,
        // mas mostrada em apenas uma linha na tela
        HashMap hmIndiceConta = new HashMap();

        // Inicializando os ArrayLists
        // Conta Principal Credito, Debito e Caucionada
        for (int j = 0; j < 3; j++) {
            alContaRateioUnidade.add("");
            alContaRateioOperacao.add("");
            alContaRateioConta.add("");
            alContaRateioDV.add("");
            alTxtPercCredito.add("");
            alTxtPercDebito.add("");
            alValorRateio.add("");
        }

        for (int i = 0; i < beanListContas.size(); i++) {
            CedenteContasBean bean = (CedenteContasBean) beanListContas.get(i);

            String contaUnidade = "" + bean.getContaRateioUnidade();
            String contaOperacao = "" + bean.getContaRateioOperacao();
            String conta = "" + bean.getContaRateioConta();
            String contaDV = "" + bean.getContaRateioDV();
            String percentual = Util.toStr(bean.getPercentualRateio());
            String valorRateio = Util.toStr(bean.getValorRateio());

            String chaveHs = contaUnidade + contaOperacao + conta + contaDV;

            // Guardam somente as contas rateio
            // As contas principais e de caucao ficam nos 3 primeiros indices do
            // array
            switch (bean.getTipoConta().intValue()) {
            case 1: // Conta Principal Credito
                alContaRateioUnidade.remove(0);
                alContaRateioOperacao.remove(0);
                alContaRateioConta.remove(0);
                alContaRateioDV.remove(0);
                alTxtPercCredito.remove(0);
                alTxtPercDebito.remove(0);
                alValorRateio.remove(0);

                alContaRateioUnidade.add(0, contaUnidade);
                alContaRateioOperacao.add(0, contaOperacao);
                alContaRateioConta.add(0, conta);
                alContaRateioDV.add(0, contaDV);
                alTxtPercCredito.add(0, percentual);
                alTxtPercDebito.add(0, "");
                alValorRateio.add(0, valorRateio);
                break;

            case 2: // Conta Principal Debito
                alContaRateioUnidade.remove(1);
                alContaRateioOperacao.remove(1);
                alContaRateioConta.remove(1);
                alContaRateioDV.remove(1);
                alTxtPercCredito.remove(1);
                alTxtPercDebito.remove(1);
                alValorRateio.remove(1);

                alContaRateioUnidade.add(1, contaUnidade);
                alContaRateioOperacao.add(1, contaOperacao);
                alContaRateioConta.add(1, conta);
                alContaRateioDV.add(1, contaDV);
                alTxtPercCredito.add(1, "");
                alTxtPercDebito.add(1, percentual);
                alValorRateio.add(1, valorRateio);
                break;

            case 4: // Conta Caucao
                alContaRateioUnidade.remove(2);
                alContaRateioOperacao.remove(2);
                alContaRateioConta.remove(2);
                alContaRateioDV.remove(2);
                alTxtPercCredito.remove(2);
                alTxtPercDebito.remove(2);
                alValorRateio.remove(2);

                alContaRateioUnidade.add(2, contaUnidade);
                alContaRateioOperacao.add(2, contaOperacao);
                alContaRateioConta.add(2, conta);
                alContaRateioDV.add(2, contaDV);
                alTxtPercCredito.add(2, "");
                alTxtPercDebito.add(2, "");
                alValorRateio.add(2, valorRateio);
                break;

            case 5: // Conta Rateio Credito
                // se conta nao foi criada ainda
                if (hmIndiceConta.get(chaveHs) == null) {
                    alContaRateioUnidade.add(contaUnidade);
                    alContaRateioOperacao.add(contaOperacao);
                    alContaRateioConta.add(conta);
                    alContaRateioDV.add(contaDV);
                    alTxtPercCredito.add(percentual);
                    alTxtPercDebito.add("");
                    alValorRateio.add(valorRateio);

                    String[] cpfTitular = this.descobreCpf(bean.getContaRateioUnidade(),
                            bean.getContaRateioOperacao(),
                            bean.getContaRateioConta(),
                            bean.getContaRateioDV(),
                            this.getCodigoUsuario(request));

                    alContaCpfCnpj.add(cpfTitular[0]);
                    alContaTitular.add(cpfTitular[1]);

                    hmIndiceConta.put(chaveHs,
                            new Integer(alContaRateioUnidade.size() - 1));
                } else {
                    // somente modifica a parte de credito
                    int indice = ((Integer) hmIndiceConta.get(chaveHs)).intValue();
                    alTxtPercCredito.remove(indice);
                    alValorRateio.remove(indice);
                    alTxtPercCredito.add(indice, percentual);
                    alValorRateio.add(valorRateio);
                }
                break;

            case 6: // Conta Rateio Debito
                // se conta nao foi criada ainda
                if (hmIndiceConta.get(chaveHs) == null) {
                    alContaRateioUnidade.add(contaUnidade);
                    alContaRateioOperacao.add(contaOperacao);
                    alContaRateioConta.add(conta);
                    alContaRateioDV.add(contaDV);
                    alTxtPercCredito.add("");
                    alTxtPercDebito.add(percentual);
                    alValorRateio.add(valorRateio);

                    String[] cpfTitular = this.descobreCpf(bean.getContaRateioUnidade(),
                            bean.getContaRateioOperacao(),
                            bean.getContaRateioConta(),
                            bean.getContaRateioDV(),
                            this.getCodigoUsuario(request));

                    alContaCpfCnpj.add(cpfTitular[0]);
                    alContaTitular.add(cpfTitular[1]);

                    hmIndiceConta.put(chaveHs,
                            new Integer(alContaRateioUnidade.size() - 1));
                } else {
                    // somente modifica a parte de debito
                    int indice = ((Integer) hmIndiceConta.get(chaveHs)).intValue();
                    alTxtPercDebito.remove(indice);
                    alTxtPercDebito.add(indice, percentual);
                }
                break;
            }
        }

        request.setAttribute("contaRateioUnidade",
                this.montaStrArray(alContaRateioUnidade));
        request.setAttribute("contaRateioOperacao",
                this.montaStrArray(alContaRateioOperacao));
        request.setAttribute("contaRateioConta",
                this.montaStrArray(alContaRateioConta));
        request.setAttribute("contaRateioDV",
                this.montaStrArray(alContaRateioDV));
        request.setAttribute("txtPercCredito",
                this.montaStrArray(alTxtPercCredito));
        request.setAttribute("txtPercDebito",
                this.montaStrArray(alTxtPercDebito));
        request.setAttribute("valorRateio", this.montaStrArray(alValorRateio));
        request.setAttribute("contaCpfCnpj", this.montaStrArray(alContaCpfCnpj));
        request.setAttribute("contaTitular", this.montaStrArray(alContaTitular));

        if (alContaRateioUnidade.size() > 3) {
            request.setAttribute("selectNumeroContas",
                    "" + (alContaRateioUnidade.size() - 3));
            request.setAttribute("selectContasRateio", "S");
        }
    }

    private String[] descobreCpf(Long contaRateioUnidade,
            Long contaRateioOperacao,
            Long contaRateioConta,
            Long contaRateioDV,
            String codigoUsuario) throws Exception {
        // 0 - Cpf
        // 1 - Titular
        String[] cpfTitular = new String[2];

        if (contaRateioUnidade == null
            || contaRateioUnidade.equals(new Long(0))) {
            cpfTitular[0] = "";
            cpfTitular[1] = "";
            return cpfTitular;
        }

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        CedenteContasBean contasBean = new CedenteContasBean();
        contasBean.setContaRateioUnidade(contaRateioUnidade);
        contasBean.setContaRateioOperacao(contaRateioOperacao);
        contasBean.setContaRateioConta(contaRateioConta);
        contasBean.setContaRateioDV(contaRateioDV);
        contasBean.setCodigoUsuario(codigoUsuario);
       
        BeanList respostaBean = handler.executeSimpleTransactionQuery(contasBean,
                TRANSACAO_CONSULTAR_CONTA_SICLI);
        contasBean = (CedenteContasBean) respostaBean.get(0);

        if (new Long(1).equals(contasBean.getTipoPessoa())) { // 1 - FISICA
            cpfTitular[0] = Formatacao.formataCPF(contasBean.getCpfCnpj()
                    .toString());
        } else {
            cpfTitular[0] = Formatacao.formataCNPJ(contasBean.getCpfCnpj()
                    .toString());
        }
        cpfTitular[1] = contasBean.getTitular();

        return cpfTitular;
    }

    //
    // Usado no CedenteIncluirFiltro para carregar no bean de Controle de Guias
    // (CedentePrincipalBean)
    // o tipo cobranca. Isso soh para saber se pode abrir a guia de Cedente
    // Eletronico ou nao...
    //
    public CedenteGeralBean guiaGeralIniciar(HttpServletRequest request)
            throws Exception {
        CedenteGeralBean geralBean = this.carregarCedenteGeralBean(request);

        request.getSession().setAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN,
                geralBean);

        return geralBean;
    }

    private CedenteGeralBean carregarCedenteGeralBean(HttpServletRequest request)
            throws Exception {
        CedenteGeralBean geralBean = new CedenteGeralBean();
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        // Carregando campos
        geralBean = (CedenteGeralBean) geralBean.getRequestBean(request);
        // Codigo COCLI e Codigo Unidade PV vem da transacao
        geralBean.setTipoConsulta("A"); // A - dados alteracao
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CONSULTAR_GERAL + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList beanListGeral = handler.executeSimpleTransactionQuery(geralBean,transUser);
        geralBean = (CedenteGeralBean) beanListGeral.get(0);
        //SISOL 308303 - Consistência entre os campos Conta Garantida da Guia Geral e Cadastrar Contas de Rateio da Guia Contas Déb e Créd.
        //Se o campo Conta Garantida == N, busca o campo selectContasRateio da Guia Contas e insere no request para validação.
        if ("N".equals(geralBean.getClienteSINCE())) {
        	guiaContasIniciar(request);
        }
        return geralBean;

    }

    private void guiaFloatIniciar(HttpServletRequest request) throws Exception {
        CedenteFloatBean floatBean = (CedenteFloatBean) (new CedenteFloatBean()).newBean();

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        // Lista Padrao
        floatBean.setTipoConsulta("D"); // D - dados default
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CONSULTAR_FLOAT + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList beanListFloatDefault = handler.executeSimpleTransactionQuery(floatBean,transUser);
        ArrayList listFloatDefault = convertDataStructure(beanListFloatDefault.iterator());
        request.getSession()
                .setAttribute(FLOAT_LISTA_DEFAULT, listFloatDefault);

        floatBean = (CedenteFloatBean) floatBean.getRequestBean(request);

        // Codigo COCLI e Codigo Unidade PV vem da transacao
        floatBean.setTipoConsulta("A"); // A - Alteracao

        BeanList beanListFloat = handler.executeSimpleTransactionQuery(floatBean,
                TRANSACAO_CONSULTAR_FLOAT);
        ArrayList listFloat = convertDataStructure(beanListFloat.iterator());
        request.getSession().setAttribute(FLOAT_LISTA, listFloat);
    }
    
    private void guiaParametrosIniciar(HttpServletRequest request)
            throws Exception {
        CedenteParametrosBean parametrosBean = (CedenteParametrosBean) (new CedenteParametrosBean()).newBean();
        CedenteCabecaBean cabecaBean =  (CedenteCabecaBean) (new CedenteCabecaBean()).getRequestBean(request);
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        parametrosBean = (CedenteParametrosBean) parametrosBean.getRequestBean(request);
        
        String nsu = request.getParameter("nsuTransacao");
        String codCedente = request.getParameter("codigoCedente");
        String boleto = request.getParameter("icboleto");
        String valor = request.getParameter("icvalor");
        String clienteExterno = request.getParameter("clienteExterno");
        
        String icFinalizacao = request.getParameter("icFinalizacao");
        String codigoContabil = request.getParameter("codigoContabil");
        String unidadeCredito = request.getParameter("unidadeCredito");
        
        LogUtilSigcb.debug("NSU:"+ nsu + "COD CEDENTE:"+ codCedente);
        parametrosBean.setTipoConsulta("A");
        parametrosBean.setNsuTransacao(nsu);
        parametrosBean.setCodigoCedente(Long.valueOf(codCedente));
        parametrosBean.setCodigoUnidadePVVinc(0l);
        parametrosBean.setClienteExterno(clienteExterno);
        parametrosBean.setIcFinalizacao(icFinalizacao);
        parametrosBean.setCodigoContabil(codigoContabil);
        parametrosBean.setUnidadeCredito(unidadeCredito);

        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CONSULTAR_PARAMETROS + usuarioBean.getCodigoUsuario().toUpperCase();
        
        BeanList beanListParametros = handler.executeSimpleTransactionQuery(parametrosBean,transUser);
        parametrosBean = (CedenteParametrosBean) beanListParametros.get(0);
      
        
        request.setAttribute(CedenteEstrategia.CEDENTE_PARAMETROS_BEAN,parametrosBean);
    }
    
    private void guiaPermissaoIniciar(HttpServletRequest request)
            throws Exception {
       
    	 InformacoesUsuarioBean usuarioLDAP = (InformacoesUsuarioBean) request.getSession()
                 .getAttribute(CedenteEstrategia.USUARIOLDAP_BEAN);
    	
			HttpSession session = request.getSession(false);
			CedenteCabecaBean cedenteCabecalhoBean = (session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN)==null
			          ? new CedenteCabecaBean()
			          : (CedenteCabecaBean) session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN));
			
	        CedenteGeralBean geralBeanTransacoesGuias = (CedenteGeralBean) (new CedenteGeralBean()).getSessionBean(request, CEDENTE_GERAL_BEAN_TRANSACOES_GUIAS);

			  
			SirotAdaptadorSIGCB acao = new br.gov.caixa.sigcb.sirot.transaction.SirotAdaptadorSIGCB();
			MontaTransacao isoMsg = new MontaTransacao();
			
			String subida = "A"+ 
					Util.zerosEsquerda(cedenteCabecalhoBean.getCodigoCedente(),7) +
					Util.zerosEsquerda(cedenteCabecalhoBean.getCodigoClienteCOCLI(), 13) +
					Util.completaEspacos(geralBeanTransacoesGuias.getNsuTransacao().toUpperCase(), 48) +
					Util.zerosEsquerda(geralBeanTransacoesGuias.getCodigoUnidadePVVinc(), 4) +
					Util.completaEspacos(cedenteCabecalhoBean.getTipoPessoaTexto().toUpperCase(), 1) +
					Util.zerosEsquerda(cedenteCabecalhoBean.getCpfCnpj(), 14) + 
					Util.completaEspacos( usuarioLDAP.getCodigoUsuario(), 8);
			
			InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
			ISOMsg mensagem = isoMsg.BGMT(subida, usuarioBean.getCodigoUsuario());		
			ISOMsg[] retorno = acao.executaSirot(mensagem);
			
			boolean erroSirot = false;
			///Tratamento do retorno da mensagem ISO
			// Verifica se deu erro no RETORNO
			if ( !(((String)retorno[1].getValue(120)).trim().equals("")) &&
				 !(((String)retorno[1].getValue(120)).substring(0,4).equalsIgnoreCase("0001")) &&
				 !(((String)retorno[1].getValue(120)).substring(0,4).equalsIgnoreCase("0002")) ) 
				{
				erroSirot = true;
				Exception campo = new Exception((String) retorno[1].getValue(120));
				throw new MainframeException(campo);
				
			}
			
			LogUtilSigcb.debug("Retorno:" + (String) retorno[1].getValue(62));
			

		CedConsultaPermissaoBean retBean = this.desmontaBGMT((String)retorno[1].getValue(62), (String)retorno[2].getValue(62));
			
		request.setAttribute(CedenteEstrategia.CEDENTE_PERMISSAO_BEAN,retBean);			
        
        
    }
    
    
  public CedConsultaPermissaoBean desmontaBGMT(String rajada, String historico){
    	
    	CedConsultaPermissaoBean retorno = new CedConsultaPermissaoBean();
    	
    	retorno.setDE_STCO_INTERNA(rajada.substring(0, 10));
    	retorno.setDT_STCO_INTERNA(rajada.substring(10, 20));
    	retorno.setHH_STCO_INTERNA(rajada.substring(20, 28));
    	retorno.setCO_USRO_INTERNA(rajada.substring(28, 36));
    	retorno.setDE_HIST_INTERNA(rajada.substring(36, 256));
    	retorno.setDE_STCO_CIP(rajada.substring(256, 266));
    	retorno.setDT_STCO_CIP(rajada.substring(266, 276));
    	retorno.setHH_STCO_CIP(rajada.substring(276, 284));
    	retorno.setDE_STCO_FINAL(rajada.substring(284, 294));
    	retorno.setDT_STCO_FINAL(rajada.substring(294, 304));
    	retorno.setHH_STCO_FINAL(rajada.substring(304, 312));
    	retorno.setCO_USRO_FINAL(rajada.substring(312,320));
    	retorno.setDE_HIST_FINAL(rajada.substring(320, 370));
    	retorno.setDE_ACAT_CIP(rajada.substring(370, 373));
    	retorno.setDT_ACAT_CIP(rajada.substring(373, 383));
    	retorno.setHH_ACAT_CIP(rajada.substring(383, 391));
    	retorno.setCO_USRO_CIP(rajada.substring(391, 399));
    	retorno.setDE_HIST_CIP(historico);
    	
    	return retorno;
    	
    }

}
