package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.types.MoneyType;
import br.com.politec.sao.business.types.PercentualType;
import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.util.Formatacao;
import br.com.politec.sao.util.Money;
import br.com.politec.sao.util.Percentual;
import br.gov.caixa.sigcb.bean.CedenteContasBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.Util;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Incluir Cedente - Guia
 * Contas
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>18/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteIncluirGuiaContasFinalizar extends CedenteIncluirEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        this.configMsgSucessoErro(request);

        CedenteContasBean contasBean = (CedenteContasBean) (new CedenteContasBean()).getRequestBean(request);
        CedenteContasBean resposta = (CedenteContasBean) (new CedenteContasBean()).newBean();

        String[] contaRateioUnidade = request.getParameterValues("contaRateioUnidade");
        String[] contaRateioOperacao = request.getParameterValues("contaRateioOperacao");
        String[] contaRateioConta = request.getParameterValues("contaRateioConta");
        String[] contaRateioDV = request.getParameterValues("contaRateioDV");
        String[] percentualRateio = request.getParameterValues("percentualRateio");
        String[] txtPercCredito = request.getParameterValues("txtPercCredito");
        String[] txtPercDebito = request.getParameterValues("txtPercDebito");
        String[] valorRateio = request.getParameterValues("valorRateio");
        String[] contaCpfCnpj = request.getParameterValues("contaCpfCnpj");
        String[] contaTitular = request.getParameterValues("contaTitular");

        // seta no request novamente para nao perder caso aconteca algum erro
        request.setAttribute("contaRateioUnidade", contaRateioUnidade);
        request.setAttribute("contaRateioOperacao", contaRateioOperacao);
        request.setAttribute("contaRateioConta", contaRateioConta);
        request.setAttribute("contaRateioDV", contaRateioDV);
        request.setAttribute("percentualRateio", percentualRateio);
        request.setAttribute("txtPercCredito", txtPercCredito);
        request.setAttribute("txtPercDebito", txtPercDebito);
        request.setAttribute("valorRateio", valorRateio);
        request.setAttribute("contaCpfCnpj", contaCpfCnpj);
        request.setAttribute("contaTitular", contaTitular);

        if ("G".equals(contasBean.getTipoAcao())) { // G - atualizar Guia
            // ATUALIZAR GUIA
            ArrayList alCpfCnpj = new ArrayList();
            ArrayList alTitular = new ArrayList();

            for (int i = 3; i < contaRateioUnidade.length; i++) {
                if (contaRateioUnidade[i] == null
                    || contaRateioUnidade[i].trim().equals("")
                    || contaRateioOperacao[i] == null
                    || contaRateioOperacao[i].trim().equals("")
                    || contaRateioConta[i] == null
                    || contaRateioOperacao[i].trim().equals("")
                    || contaRateioDV[i] == null
                    || contaRateioDV[i].trim().equals("")) {
                    alCpfCnpj.add("");
                    alTitular.add("");
                    continue;
                }

                //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
                MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

                contasBean = new CedenteContasBean();
                contasBean.setContaRateioUnidade(new Long(contaRateioUnidade[i]));
                contasBean.setContaRateioOperacao(new Long(contaRateioOperacao[i]));
                contasBean.setContaRateioConta(new Long(contaRateioConta[i]));
                contasBean.setContaRateioDV(new Long(contaRateioDV[i]));
                contasBean.setCodigoUsuario(this.getCodigoUsuario(request));
                
                InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
                String transUser = TRANSACAO_CONSULTAR_CONTA_SICLI + usuarioBean.getCodigoUsuario().toUpperCase();

                BeanList respostaBean = handler.executeSimpleTransactionQuery(contasBean,
                		transUser);
                contasBean = (CedenteContasBean) respostaBean.get(0);

                if (!contasBean.getDescricaoCriticas().equals("")) {
                    return CedenteIncluirGuiaControle.proximaGuia(request,
                            contasBean.getDescricaoCriticas(),
                            PAGE_INCLUIR_CONTAS,
                            PAGE_INCLUIR_CONTAS);
                }

                if (new Long(1).equals(contasBean.getTipoPessoa())) { // 1 -

                    alCpfCnpj.add(Formatacao.formataCPF(contasBean.getCpfCnpj()
                            .toString()));
                } else {
                    alCpfCnpj.add(Formatacao.formataCNPJ(contasBean.getCpfCnpj()
                            .toString()));
                }
                alTitular.add(i - 3, contasBean.getTitular());
            }

            contaCpfCnpj = new String[alCpfCnpj.size()];
            for (int i = 0; i < alCpfCnpj.size(); i++) {
                contaCpfCnpj[i] = (String) alCpfCnpj.get(i);
            }

            contaTitular = new String[alTitular.size()];
            for (int i = 0; i < alTitular.size(); i++) {
                contaTitular[i] = (String) alTitular.get(i);
            }

            request.setAttribute("contaCpfCnpj", contaCpfCnpj);
            request.setAttribute("contaTitular", contaTitular);

            return PAGE_INCLUIR_CONTAS;

        } else {
            // CONFIRMAR

            ArrayList recordsets = this.montaRecordsets(contaRateioUnidade,
                    contaRateioOperacao,
                    contaRateioConta,
                    contaRateioDV,
                    txtPercCredito,
                    txtPercDebito,
                    valorRateio);

            contasBean.setCodigoUsuario(this.getCodigoUsuario(request));
            contasBean.setNumeroTotalPacotes(new Long(recordsets.size()));

            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

            for (int i = 0; i < recordsets.size(); i++) {
                String strRecordset = (String) recordsets.get(i);

                contasBean.setNumeroPacote(new Long(i + 1)); // comeca no 1
                contasBean.setStrRecordset(strRecordset);
                InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
                String transUser = TRANSACAO_INCLUIR_ALTERAR_CONTAS + usuarioBean.getCodigoUsuario().toUpperCase();
                BeanList blResposta = handler.executeSimpleTransactionQuery(contasBean,transUser);

                // Se houver criticas, pára a inclusao e mostra as criticas
                if (blResposta.size() > 0) {
                    resposta = (CedenteContasBean) blResposta.get(0);
                    if (!resposta.getDescricaoCriticas().trim().equals("")) {
                        return CedenteIncluirGuiaControle.proximaGuia(request,
                                resposta.getDescricaoCriticas(),
                                PAGE_INCLUIR_CONTAS,
                                PAGE_INCLUIR_PRINCIPAL);
                    }
                }

            }

            // finaliza chamando transacao de controle de rajadas
            contasBean.setTipoConclusao(new Long(1)); // 1 - Guia Contas
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CONCLUSAO_RAJADA + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList blResposta = handler.executeSimpleTransactionQuery(contasBean,
            		transUser);

            // Se houver criticas, adiciona no arraylist
            if (blResposta.size() > 0) {
                resposta = (CedenteContasBean) blResposta.get(0);
            }

        }

        // se inclusao com sucesso avanca a guia em cadastramento
        // e nao houver criticas
        if (contasBean.getTipoAcao().equals("I")
            && resposta.getDescricaoCriticas().trim().equals("")) {
            CedenteIncluirGuiaControle.avancaGuiaEmCadastramento(request);
        }

        return CedenteIncluirGuiaControle.proximaGuia(request,
                resposta.getDescricaoCriticas(),
                PAGE_INCLUIR_CONTAS,
                PAGE_INCLUIR_PRINCIPAL);

    }

    // Volta um ArrayList, cada elemento eh o recordset para um pacote da
    // transacao
    private ArrayList montaRecordsets(String[] contaRateioUnidade,
            String[] contaRateioOperacao,
            String[] contaRateioConta,
            String[] contaRateioDV,
            String[] txtPercCredito,
            String[] txtPercDebito,
            String[] valorRateio) {

        Layout contasLayout = (new CedenteContasBean()).getLayout();
        MainframeExtension contasExtension = ((MainframeExtension) contasLayout.getExtension("Mainframe"));

        // tamanho dos campos
        int tamTipoConta = contasExtension.get("tipoConta").getLength();
        int tamContaRateioUnidade = contasExtension.get("contaRateioUnidade")
                .getLength();
        int tamContaRateioOperacao = contasExtension.get("contaRateioOperacao")
                .getLength();
        int tamContaRateioConta = contasExtension.get("contaRateioConta")
                .getLength();
        int tamContaRateioDV = contasExtension.get("contaRateioDV").getLength();
        int tamPercentualRateio = contasExtension.get("percentualRateio")
                .getLength();
        int tamValorRateio = contasExtension.get("valorRateio").getLength();

        // montando recordsets
        ArrayList recordsets = new ArrayList();
        String strRecordset = "";
        int registrosPorRajada = 24; // Quantidade de registros que cabem
        int registros = 0;
        for (int i = 0; i < contaRateioUnidade.length; i++) {
            if (!contaRateioUnidade[i].trim().equals("")
                && !contaRateioUnidade[i].equals("0")) {
                int tipoConta = this.descobreTipoConta(i,
                        txtPercCredito[i],
                        valorRateio[i],
                        txtPercDebito[i]);
                Long unidade = new Long(contaRateioUnidade[i]);
                Long operacao = new Long(contaRateioOperacao[i]);
                Long conta = new Long(contaRateioConta[i]);
                Long dv = new Long(contaRateioDV[i]);
                Money mValorRateio = this.converteValorRateio(valorRateio[i]);
                Percentual percentual = null;

                // Se eh uma conta rateio de credito e debito deve-se subir dois
                // registros
                // um pra de credito e outra pra de debito
                if (tipoConta == 56) {
                    // conta rateio credito, tipo 5
                    percentual = this.descobrePercentual(5,
                            txtPercCredito[i],
                            txtPercDebito[i]);
                    strRecordset += criaStringConta(new Long(5),
                            tamTipoConta,
                            unidade,
                            tamContaRateioUnidade,
                            operacao,
                            tamContaRateioOperacao,
                            conta,
                            tamContaRateioConta,
                            dv,
                            tamContaRateioDV,
                            percentual,
                            tamPercentualRateio,
                            mValorRateio,
                            tamValorRateio);
                    registros++;

                    // conta rateio debito, tipo 6
                    // nao possui valor rateio
                    percentual = this.descobrePercentual(6,
                            txtPercCredito[i],
                            txtPercDebito[i]);
                    strRecordset += criaStringConta(new Long(6),
                            tamTipoConta,
                            unidade,
                            tamContaRateioUnidade,
                            operacao,
                            tamContaRateioOperacao,
                            conta,
                            tamContaRateioConta,
                            dv,
                            tamContaRateioDV,
                            percentual,
                            tamPercentualRateio,
                            Money.reais(0),
                            tamValorRateio);
                    registros++;

                } else {
                    percentual = this.descobrePercentual(tipoConta,
                            txtPercCredito[i],
                            txtPercDebito[i]);
                    strRecordset += criaStringConta(new Long(tipoConta),
                            tamTipoConta,
                            unidade,
                            tamContaRateioUnidade,
                            operacao,
                            tamContaRateioOperacao,
                            conta,
                            tamContaRateioConta,
                            dv,
                            tamContaRateioDV,
                            percentual,
                            tamPercentualRateio,
                            mValorRateio,
                            tamValorRateio);
                    registros++;
                }

                // ao completar uma rajada adiciona no arraylist e zera
                // variaveis de controle
                if (registros == registrosPorRajada) {
                    recordsets.add(strRecordset);
                    strRecordset = "";
                    registros = 0;
                }
            }
        }

        // se houver registros ainda, adiciona o resto no arraylist
        if (registros > 0) {
            StringBuffer sb = new StringBuffer(strRecordset);
            while (sb.length() < 888) {
                sb.append(" ");
            }
            recordsets.add(sb.toString());
        }

        return recordsets;
    }

    private String criaStringConta(Long tipoConta,
            int tamTipoConta,
            Long contaRateioUnidade,
            int tamContaRateioUnidade,
            Long contaRateioOperacao,
            int tamContaRateioOperacao,
            Long contaRateioConta,
            int tamContaRateioConta,
            Long contaRateioDV,
            int tamContaRateioDV,
            Percentual percentual,
            int tamPercentualRateio,
            Money valorRateio,
            int tamValorRateio) {

        String strTipoConta = Util.zerosEsquerda(tipoConta, tamTipoConta);
        String strContaUnidade = Util.zerosEsquerda(contaRateioUnidade,
                tamContaRateioUnidade);
        String strContaOperacao = Util.zerosEsquerda(contaRateioOperacao,
                tamContaRateioOperacao);
        String strConta = Util.zerosEsquerda(contaRateioConta,
                tamContaRateioConta);
        String strContaDV = Util.zerosEsquerda(contaRateioDV, tamContaRateioDV);
        String strPercentual = Util.zerosEsquerda(new Long(percentual.toValorSemPonto()),
                tamPercentualRateio);
        String strValor = Util.zerosEsquerda(new Long(valorRateio.getIntegerAmount()
                                                      * 100
                                                      + valorRateio.getDecimalAmount()),
                tamValorRateio);

        return strTipoConta
               + strContaUnidade
               + strContaOperacao
               + strConta
               + strContaDV
               + strPercentual
               + strValor;
    }

    private int descobreTipoConta(int indiceArray,
            String percCredito,
            String valorRateio,
            String percDebito) {
        if (indiceArray == 0) {
            return 1; // 1 - Conta Principal Credito
        } else if (indiceArray == 1) {
            return 2; // 2 - Conta Principal Debito
        } else if (indiceArray == 2) {
            return 4; // 4 - Conta Caucao
        } else {
            if ((!percCredito.trim().equals("") || !valorRateio.trim()
                    .equals(""))
                && !percDebito.trim().equals("")) {
                return 56; // 56 - Uso soh na estrategia, nao vai para o banco.
                // Indica conta de debito e credito
            } else if (!percCredito.trim().equals("")
                       || !valorRateio.trim().equals("")) {
                return 5; // 5 - Conta Rateio Credito
            } else {
                return 6; // 6 - ContaRateio Debito
            }
        }
    }

    private boolean isContaCredito(int tipoConta) {
        if (tipoConta == 1 || tipoConta == 5) {
            return true;
        } else {
            return false;
        }
    }

    private Percentual descobrePercentual(int tipoConta,
            String txtPercCredito,
            String txtPercDebito) {
        // descobre o percentual usado (credito ou debito)
        String percentual = "";
        if (this.isContaCredito(tipoConta)) {
            percentual = txtPercCredito;
        } else {
            percentual = txtPercDebito;
        }
        if (percentual.trim().equals("")) {
            percentual = "0,00 %";
        }
        return (Percentual) PercentualType.create().newInstance(percentual);
    }

    private Money converteValorRateio(String valorRateio) {
        String valor = "R$ 0,00";
        if (!valorRateio.trim().equals("")) {
            valor = valorRateio;
        }
        return (Money) MoneyType.create().newInstance(valor);
    }
}
