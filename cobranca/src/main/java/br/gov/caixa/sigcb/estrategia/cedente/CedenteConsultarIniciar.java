package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.Formatacao;
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
import br.gov.caixa.sigcb.bean.CedenteTarifasBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.sirot.transaction.MontaTransacao;
import br.gov.caixa.sigcb.sirot.transaction.SirotAdaptadorSIGCB;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;
import br.gov.caixa.sigcb.util.Util;
import br.gov.caixa.sigcb.util.jsp.ComboAtribuicaoVan;
import br.gov.caixa.sigcb.util.jsp.ComboCobracaSimNao;
import br.gov.caixa.sigcb.util.jsp.ComboFormaCalculo;
import br.gov.caixa.sigcb.util.jsp.ComboGiroCaixa;
import br.gov.caixa.sigcb.util.jsp.ComboModalidadeTitulo;
import br.gov.caixa.sigcb.util.jsp.ComboPadraoArquivo;
import br.gov.caixa.sigcb.util.jsp.ComboPerfilRejeicao;
import br.gov.caixa.sigcb.util.jsp.ComboSimNao;
import br.gov.caixa.sigcb.util.jsp.ComboTipoCobranca;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Manter Cedente >>
 * Consulta Detalhada
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>16/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteConsultarIniciar extends CedenteConsultarEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
    	
        if (FLUXO_NORMAL.equals(getFluxo(request))) {
            this.configMsgSucessoErro(request);

            // empilha um bean para o controle do Voltar
            PilhaVoltarControle.push(request, new CedenteConclusaoBean());

            // se nao foi inicializado o cabecalho ainda

            // EAM - Inicio
            // Retirada essa verificação pois em caso de uma segunda
            // consulta(por pv)
            // não recarregava o cabeçalho do cedente
            // if (request.getSession().getAttribute(CEDENTE_CABECA_BEAN) ==
            // null) {
            this.cabecalhoIniciar(request);
            // }
            // EAM - Fim

            String pagina = request.getParameter("pagina");
            if ((pagina == null) || ("".equals(pagina))) {
                pagina = "0";
            }
            
            if ("1".equals(pagina)) {
                this.guiaGeralIniciar(request);
            } else if ("2".equals(pagina)) {
                this.guiaFloatIniciar(request);
            } else if ("3".equals(pagina)) {
                this.guiaContasIniciar(request);
            } else if ("4".equals(pagina)) {
                this.guiaCedenteEletronicoIniciar(request);
            } else if ("5".equals(pagina)) {
                this.guiaBloquetosIniciar(request);
            } else if ("6".equals(pagina)) {
                this.guiaMensagensIniciar(request);
            } else if ("7".equals(pagina)) {
                this.guiaTarifasIniciar(request);
            } else if ("8".equals(pagina)) {
                this.guiaConclusaoIniciar(request);
            } else if ("9".equals(pagina)){
            	this.guiaParametrosIniciar(request);
            }else if ("10".equals(pagina)){
            	this.guiaPermissaoIniciar(request);
            }
        }else  if ("PERMISSAO".equals(getFluxo(request))) {
        	this.guiaPermissaoIniciar(request);
        }

        return PAGE_CONSULTAR_PRINCIPAL;
    }

    private void cabecalhoIniciar(HttpServletRequest request) throws Exception {
        CedenteCabecaBean cedenteCabecaBean = (CedenteCabecaBean) (new CedenteCabecaBean()).getRequestBean(request);
        cedenteCabecaBean.setTipoConsulta(new Long(1)); // 1 - Consulta Por
        // Codigo Cedente
        cedenteCabecaBean.setCodigoClienteCOCLI(new Long(0));
        cedenteCabecaBean.setCodigoUsuario(this.getCodigoUsuario(request));
        cedenteCabecaBean.setOrigemConsulta(new Long(1)); // 1 - Intranet

        // salvando o codigo do cedente antes da transacao
        Long codigoCedente = cedenteCabecaBean.getCodigoCedente();

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CABECALHO + usuarioBean.getCodigoUsuario().toUpperCase();
        
        BeanList respostaList = handler.executeSimpleTransactionQuery(cedenteCabecaBean,
        		transUser);
        cedenteCabecaBean = (CedenteCabecaBean) respostaList.get(0);

        cedenteCabecaBean.setCodigoCedente(codigoCedente);

        request.getSession().setAttribute(CEDENTE_CABECA_BEAN,
                cedenteCabecaBean);
    }

    private void guiaGeralIniciar(HttpServletRequest request) throws Exception {
        CedenteGeralBean geralBean = new CedenteGeralBean();
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        geralBean = (CedenteGeralBean) geralBean.getRequestBean(request);
        geralBean.setTipoConsulta("C"); // C - dados cadastrais
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CONSULTAR_GERAL + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList beanListGeral = handler.executeSimpleTransactionQuery(geralBean,transUser);
        geralBean = (CedenteGeralBean) beanListGeral.get(0);
        formataGeral(geralBean);
        request.setAttribute(CEDENTE_GERAL_BEAN, geralBean);
    }

    private void formataGeral(CedenteGeralBean geralBean) throws JspException {
        geralBean.setDescTipoCobranca(ComboTipoCobranca.getDescricao(geralBean.getTipoCobranca()));
        geralBean.setProtestoAutomatico(ComboSimNao.getDescricao(geralBean.getProtestoAutomatico()));
        geralBean.setExtratoMovTit(ComboSimNao.getDescricao(geralBean.getExtratoMovTit()));
        geralBean.setExtratoMovDebtCredt(ComboSimNao.getDescricao(geralBean.getExtratoMovDebtCredt()));
        geralBean.setInventarioMes(ComboSimNao.getDescricao(geralBean.getInventarioMes()));
        geralBean.setRecebimentoCheque(ComboSimNao.getDescricao(geralBean.getRecebimentoCheque()));
        geralBean.setClienteExterno(ComboSimNao.getDescricao(geralBean.getClienteExterno()));
        geralBean.setExclusaoAutomatica(ComboSimNao.getDescricao(geralBean.getExclusaoAutomatica()));
        geralBean.setDescModalidadeTitulo(ComboModalidadeTitulo.getDescricao(geralBean.getModalidadeTitulo()));
        geralBean.setCobrancaSemBloqueto(ComboCobracaSimNao.getDescricao(geralBean.getCobrancaSemBloqueto()));
        geralBean.setDescClienteGiroCaixa(ComboGiroCaixa.getDescricao(geralBean.getClienteGiroCaixa()));
        geralBean.setRetencaoIOF(ComboSimNao.getDescricao(geralBean.getRetencaoIOF()));
        geralBean.setEnvioSMS(ComboSimNao.getDescricao(geralBean.getEnvioSMS()));

    }

    private void guiaFloatIniciar(HttpServletRequest request) throws Exception {
        CedenteFloatBean floatBean = (CedenteFloatBean) (new CedenteFloatBean()).newBean();
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        // Lista Padrao
        floatBean.setTipoConsulta("D"); // D - dados default
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CONSULTAR_FLOAT + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList beanListFloatDefault = handler.executeSimpleTransactionQuery(floatBean, transUser);
        ArrayList listFloatDefault = convertDataStructure(beanListFloatDefault.iterator());
        request.setAttribute(FLOAT_LISTA_DEFAULT, listFloatDefault);

        floatBean = (CedenteFloatBean) floatBean.getRequestBean(request);
        floatBean.setTipoConsulta("C"); // C - consulta dados cadastrais
        transUser = TRANSACAO_CONSULTAR_FLOAT + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList beanListFloat = handler.executeSimpleTransactionQuery(floatBean,  transUser);
        ArrayList listFloat = convertDataStructure(beanListFloat.iterator());
        request.setAttribute(FLOAT_LISTA, listFloat);
    }

    private void guiaContasIniciar(HttpServletRequest request) throws Exception {
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
    	  MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        // Consulta as contas ja cadastradas
        CedenteContasBean contasBean = (CedenteContasBean) (new CedenteContasBean()).newBean();

        contasBean = (CedenteContasBean) contasBean.getRequestBean(request);

        contasBean.setTipoConsulta("C"); // C - consulta dados cadastrais
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
        String transUser = TRANSACAO_CONSULTAR_CONTA_SICLI + codigoUsuario.toUpperCase();
        BeanList respostaBean = handler.executeSimpleTransactionQuery(contasBean,transUser);
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

    private void guiaCedenteEletronicoIniciar(HttpServletRequest request)
            throws Exception {
        CedenteEletronicoBean producaoBean = (CedenteEletronicoBean) (new CedenteEletronicoBean()).newBean();
        CedenteEletronicoBean testeBean = (CedenteEletronicoBean) (new CedenteEletronicoBean()).newBean();

        CedenteEletronicoBean eletronBean = (CedenteEletronicoBean) (new CedenteEletronicoBean()).newBean();
        eletronBean.setCodigoCedente(new Long(request.getParameter("codigoCedente")));
        eletronBean.setTipoConsulta("C"); // C - consulta dados cadastrais

        // Descobrindo situacao dos Cedente Eletronicos de Teste e Producao
        eletronBean.setTipoAcao("C"); // C - consulta dados cadastrais
        eletronBean.setSituacao(new Long(1)); // 1 - Teste
        String situacaoTeste = this.isCedenteEletronicoCadastrado(eletronBean);

        eletronBean.setSituacao(new Long(2)); // 2 - Producao
        String situacaoProducao = this.isCedenteEletronicoCadastrado(eletronBean);

        // Carregando dados de Cedente Eletronico
        if (situacaoTeste.equals("S") || situacaoProducao.equals("S")) {
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        	  MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CONSULTAR_CEDENTE_ELETRONICO + usuarioBean.getCodigoUsuario().toUpperCase();

            BeanList beanListEletron = handler.executeSimpleTransactionQuery(eletronBean,
            		transUser);

            for (int i = 0; i < beanListEletron.size(); i++) {
                eletronBean = (CedenteEletronicoBean) beanListEletron.get(i);
                if (new Long(1).equals(eletronBean.getSituacao())) { // 1 -
                    // Teste
                    testeBean = eletronBean;
                    formataCedenteEletronico(testeBean);
                } else if (new Long(2).equals(eletronBean.getSituacao())) { // 2 -
                    // Producao
                    producaoBean = eletronBean;
                    formataCedenteEletronico(producaoBean);
                }
            }
        }

        testeBean.setCadastrado(situacaoTeste);
        producaoBean.setCadastrado(situacaoProducao);

        request.setAttribute(CedenteEstrategia.CEDENTE_ELETRONICO_TESTE_BEAN,
                testeBean);
        request.setAttribute(CedenteEstrategia.CEDENTE_ELETRONICO_PRODUCAO_BEAN,
                producaoBean);
    }

    // Retorna "S" se cadastrado, "N" se nao
    private String isCedenteEletronicoCadastrado(CedenteEletronicoBean eletronBean)
            throws Exception {
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
    	  MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        BeanList blResposta = handler.executeSimpleTransactionQuery(eletronBean,
                TRANSACAO_SITUACAO_CEDENTE_ELETRONICO);
        CedenteEletronicoBean respostaBean = (CedenteEletronicoBean) blResposta.get(0);

        return respostaBean.getCadastrado();
    }

    private void formataCedenteEletronico(CedenteEletronicoBean eletronBean)
            throws JspException {
        eletronBean.setPadraoArquivoDesc(ComboPadraoArquivo.getDescricao(eletronBean.getPadraoArquivo()));
        eletronBean.setAtribuicaoVanDesc(ComboAtribuicaoVan.getDescricao(eletronBean.getAtribuicaoVan()));
        eletronBean.setJuncaoArquivoRetorno(ComboSimNao.getDescricao(eletronBean.getJuncaoArquivoRetorno()));
        eletronBean.setPerfilRejeicaoDesc(ComboPerfilRejeicao.getDescricao(eletronBean.getPerfilRejeicao()));
        eletronBean.setPreCritica(ComboSimNao.getDescricao(eletronBean.getPreCritica()));
        eletronBean.setCopiaArquivoRetorno(ComboSimNao.getDescricao(eletronBean.getCopiaArquivoRetorno()));
    }

    private void guiaBloquetosIniciar(HttpServletRequest request)
            throws Exception {
        CedenteBloquetosBean bloqBean = (CedenteBloquetosBean) (new CedenteBloquetosBean()).newBean();
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        bloqBean = (CedenteBloquetosBean) bloqBean.getRequestBean(request);
        bloqBean.setTipoConsulta("C"); // C - dados cadastrais
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CONSULTAR_BLOQUETO + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList beanListBloq = handler.executeSimpleTransactionQuery(bloqBean,transUser);
        bloqBean = (CedenteBloquetosBean) beanListBloq.get(0);
        this.formataBloquetos(bloqBean);
        request.setAttribute(CedenteEstrategia.CEDENTE_BLOQUETOS_BEAN, bloqBean);
    }

    private void formataBloquetos(CedenteBloquetosBean bloqBean)
            throws JspException {
        if (bloqBean.getDescEnvioAvisoSacado().equals("")) {
            bloqBean.setAvisoSacado("NAO");
        } else {
            bloqBean.setAvisoSacado("SIM");
        }
        
        if (bloqBean.getImpBloqDDA().equals("N")) {
        	bloqBean.setImpBloqDDA("NAO");
        } else {
        	bloqBean.setImpBloqDDA("SIM");
        }
    }

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
        mensagensBean.setTipoConsulta("C"); // C - dados cadstrais

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
                textArea += linhasTextArea[j] + "\n";
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
            }
        }

        request.setAttribute(CEDENTE_MENSAGENS_BEAN, mensagensBean);
    }

    private void guiaTarifasIniciar(HttpServletRequest request)
            throws Exception {
        CedenteTarifasBean tarifasBean = (CedenteTarifasBean) (new CedenteTarifasBean()).newBean();
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        tarifasBean = (CedenteTarifasBean) tarifasBean.getRequestBean(request);
        tarifasBean.setTipoConsulta("C"); // I - dados temporarios p/ inclusao
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CONSULTAR_TARIFAS + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList beanListTarifas = handler.executeSimpleTransactionQuery(tarifasBean,transUser);
        tarifasBean = (CedenteTarifasBean) beanListTarifas.get(0);
        formataTarifas(tarifasBean);
        request.setAttribute(CedenteEstrategia.CEDENTE_TARIFAS_BEAN,
                tarifasBean);
    }

    private void formataTarifas(CedenteTarifasBean tarifasBean)
            throws JspException {
        tarifasBean.setDescFormaCalculo(ComboFormaCalculo.getDescricao(tarifasBean.getFormaCalculo()));
    }

    private void guiaParametrosIniciar(HttpServletRequest request)
            throws Exception {
        CedenteParametrosBean parametrosBean = (CedenteParametrosBean) (new CedenteParametrosBean()).newBean();
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        parametrosBean = (CedenteParametrosBean) parametrosBean.getRequestBean(request);
        parametrosBean.setTipoConsulta("C");
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CONSULTAR_PARAMETROS + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList beanListParametros = handler.executeSimpleTransactionQuery(parametrosBean,transUser);
        parametrosBean = (CedenteParametrosBean) beanListParametros.get(0);
        
        request.setAttribute(CedenteEstrategia.CEDENTE_PARAMETROS_BEAN,parametrosBean);
    }
    
    private void guiaConclusaoIniciar(HttpServletRequest request)
            throws Exception {
        CedenteConclusaoBean conclusaoBean = (CedenteConclusaoBean) (new CedenteConclusaoBean()).newBean();
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        conclusaoBean = (CedenteConclusaoBean) conclusaoBean.getRequestBean(request);
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CONSULTAR_CONCLUSAO + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList beanListTarifas = handler.executeSimpleTransactionQuery(conclusaoBean,transUser);
        conclusaoBean = (CedenteConclusaoBean) beanListTarifas.get(0);
        request.setAttribute(CedenteEstrategia.CEDENTE_CONCLUSAO_BEAN,
                conclusaoBean);
    }
    
    private void guiaPermissaoIniciar(HttpServletRequest request)
            throws Exception {
       
    	
    	
			HttpSession session = request.getSession(false);
			CedenteCabecaBean cedenteCabecalhoBean = (session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN)==null
			          ? new CedenteCabecaBean()
			          : (CedenteCabecaBean) session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN));
			
	        CedenteGeralBean geralBeanTransacoesGuias = (CedenteGeralBean) (new CedenteGeralBean()).getSessionBean(request, CEDENTE_GERAL_BEAN_TRANSACOES_GUIAS);

	        InformacoesUsuarioBean usuarioLDAP = (InformacoesUsuarioBean) request.getSession()
	                 .getAttribute(CedenteEstrategia.USUARIOLDAP_BEAN);
			SirotAdaptadorSIGCB acao = new br.gov.caixa.sigcb.sirot.transaction.SirotAdaptadorSIGCB();
			MontaTransacao isoMsg = new MontaTransacao();
			
			String subida = "C"+ 
					Util.zerosEsquerda(cedenteCabecalhoBean.getCodigoCedente(),7) +
					Util.zerosEsquerda(cedenteCabecalhoBean.getCodigoClienteCOCLI(), 13) +
					Util.completaEspacos("", 48) +
					Util.zerosEsquerda(0L, 4) +
					Util.completaEspacos(cedenteCabecalhoBean.getTipoPessoaTexto().toUpperCase(), 1) +
					Util.zerosEsquerda(cedenteCabecalhoBean.getCpfCnpj(), 14) +
					Util.completaEspacos(usuarioLDAP.getCodigoUsuario(), 8);
			InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
			ISOMsg mensagem = isoMsg.BGMT(subida, usuarioBean.getCodigoUsuario().toUpperCase());		
			ISOMsg[] retorno = acao.executaSirot(mensagem);
			
			boolean erroSirot = false;
			///Tratamento do retorno da mensagem ISO
			// Verifica se deu erro no RETORNO
			if ( !(((String)retorno[1].getValue(120)).trim().equals("")) &&
				 !(((String)retorno[1].getValue(120)).substring(0,4).equalsIgnoreCase("0001")) &&
				 !(((String)retorno[1].getValue(120)).substring(0,4).equalsIgnoreCase("0002")) ) 
				{
				erroSirot = true;
				String campo = ((String) retorno[1].getValue(120) );
				throw new Exception(campo);
				
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
