package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.iso.MainframeExtension;
import br.gov.caixa.sigcb.bean.CedenteMensagensBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.regras.historicoGuias.HistoricoGuia;
import br.gov.caixa.sigcb.regras.historicoGuias.HistoricoGuiaSimpleFactory;
import br.gov.caixa.sigcb.util.Util;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Alterar Cedente - Guia
 * Mensagens Bloqueto
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>15/10/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteAlterarGuiaMsgBloqFinalizar extends
        CedenteAlterarEstrategia {

    private HistoricoGuia historicoGuiaMensagemBloquetos = HistoricoGuiaSimpleFactory.createHistoricoGuiaLogger(HistoricoGuia.GUIA_MSG_BLOQUETOS);

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        this.configMsgSucessoErro(request);

        CedenteMensagensBean mensagensBean = (CedenteMensagensBean) (new CedenteMensagensBean()).getRequestBean(request);
        CedenteMensagensBean resposta = (CedenteMensagensBean) (new CedenteMensagensBean()).newBean();

        // seta novamente o bean para caso aconteca algum problema os dados nao
        // se perderem
        request.setAttribute(CEDENTE_MENSAGENS_BEAN, mensagensBean);

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

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

        // Para cada local de impressao, monta as rajadas e chama a transacao
        int numeroTotalPacotes = 0;
        int numeroPacote = 0;

        // arraylist com recordsets(arraylist) para todos os locais de impressao
        ArrayList alRecordsetsPorLocalImpressao = new ArrayList();

        for (int i = 0; i < locaisImpressao.length; i++) {
            ArrayList alRecordsets = this.montaRecordSets(this.obtemLinhas(locaisImpressao[i],
                    request));
            numeroTotalPacotes += alRecordsets.size();
            alRecordsetsPorLocalImpressao.add(alRecordsets);
        }

        for (int i = 0; i < locaisImpressao.length; i++) {
            ArrayList alRecordsets = (ArrayList) alRecordsetsPorLocalImpressao.get(i);

            for (int j = 0; j < alRecordsets.size(); j++) {
                numeroPacote++;

                String strRecordset = (String) alRecordsets.get(j);

                // setando dados no bean
                mensagensBean.setTipoAcao(ALTERACAO);
                mensagensBean.setLocalImpressao(locaisImpressao[i]);
                mensagensBean.setNumeroTotalPacotes(new Long(numeroTotalPacotes));
                mensagensBean.setNumeroPacote(new Long(numeroPacote));
                mensagensBean.setStrRecordset(strRecordset);
                InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
                String transUser = TRANSACAO_INCLUIR_ALTERAR_MENSAGENS + usuarioBean.getCodigoUsuario().toUpperCase();
                BeanList blResposta = handler.executeSimpleTransactionQuery(mensagensBean,transUser);

                // LogUtilSigcb.debug("#$% :::::::: numeroPacote: " +
                // numeroPacote + ", numeroTotalPacotes: " +
                // numeroTotalPacotes);

                // Se houver criticas, pára a inclusao e mostra as criticas
                if (blResposta.size() > 0) {
                    resposta = (CedenteMensagensBean) blResposta.get(0);
                    if (!resposta.getDescricaoCriticas().trim().equals("")) {
                        return CedenteAlterarGuiaControle.proximaGuia(request,
                                resposta.getDescricaoCriticas(),
                                PAGE_ALTERAR_MENSAGENS,
                                PAGE_ALTERAR_PRINCIPAL);
                    }
                }

            }
        }

        // finaliza chamando transacao de controle de rajadas
        mensagensBean.setTipoConclusao(new Long(2)); // 2 - Guia Mensagem
        BeanList blResposta = handler.executeSimpleTransactionQuery(mensagensBean,
                TRANSACAO_CONCLUSAO_RAJADA);

        // Verifica criticas
        if (blResposta.size() > 0) {
            resposta = (CedenteMensagensBean) blResposta.get(0);
        } else {
            // Obtendo dados da guia geral para saber tipo de Cobranca
            // CedenteGeralBean geralBeanTransacoesGuias = (CedenteGeralBean)
            // (new
            // CedenteGeralBean()).getSessionBean(request,CEDENTE_GERAL_BEAN_TRANSACOES_GUIAS
            // );
            // this.historicoGuiaMensagemBloquetos.logDadosGuia(geralBeanTransacoesGuias,
            // handler, TRANSACAO_FINALIZAR_ALTERACAO_PARTE_2);
            LinkedList<HistoricoGuia> listaGuiasAlteradas = (LinkedList<HistoricoGuia>) request.getSession().getAttribute(LISTA_GUIAS_ALTERADAS);
            listaGuiasAlteradas.add(this.historicoGuiaMensagemBloquetos);
        }

        return CedenteAlterarGuiaControle.proximaGuia(request,
                resposta.getDescricaoCriticas(),
                PAGE_ALTERAR_MENSAGENS,
                PAGE_ALTERAR_PRINCIPAL);
    }

    //
    // Cria recordsets de subida, cada item do arraylist de retorno eh uma
    // rajada
    // Recebe: ArrayList com Strings onde cada elemento eh uma linha do texto
    // Retorna: ArrayList com Strings onde cada elemento eh uma rajada de subida
    //
    private ArrayList montaRecordSets(ArrayList linhas) {
        ArrayList listaRecordsets = new ArrayList();

        int registrosPorRajada = 11; // Quantidade de registros que cabem
        // numa rajada
        int registros = 0;

        // tamanho dos campos
        Layout mensagensLayout = (new CedenteMensagensBean()).getLayout();
        MainframeExtension mensagensExtension = ((MainframeExtension) mensagensLayout.getExtension("Mainframe"));

        int tamNumeroLinhaMensagem = mensagensExtension.get("numeroLinhaMensagem")
                .getLength();
        int tamMensagem = mensagensExtension.get("mensagem").getLength();

        String strRecordset = "";
        for (int i = 0; i < linhas.size(); i++) {
            registros++;

            strRecordset += Util.zerosEsquerda(new Long(i + 1),
                    tamNumeroLinhaMensagem);
            strRecordset += Util.completaEspacos((String) linhas.get(i),
                    tamMensagem);

            if (registros == registrosPorRajada) {
                listaRecordsets.add(strRecordset);
                strRecordset = "";
                registros = 0;
            }
        }

        // se houver registros ainda, adiciona o resto no arraylist
        if (registros > 0) {
            StringBuffer sb = new StringBuffer(strRecordset);
            while (sb.length() < 902) {
                sb.append(" ");
            }
            listaRecordsets.add(sb.toString());
        }

        return listaRecordsets;
    }

    //
    // Separa as linhas da mensagem desejada num ArrayList
    // O get foi feito pelo request porque o toUpperCase feito no bean estava
    // tirando os \n
    // Recebe: Bean com os textAreas preenchidos
    // Long localDeImpressao a ser quebrado o texto
    // Retorna: ArrayList onde cada elemento eh uma String representando uma
    // linha do texto
    //
    private ArrayList obtemLinhas(Long localImpressao,
            HttpServletRequest request) {
        String texto = "";

        switch (localImpressao.intValue()) {
        case BLOQ_PADRAO_RECIBO_SACADO:
            texto = request.getParameter("textAreaReciboSacadoBlqPadrao");
            break;
        case BLOQ_PADRAO_VERSO_BLOQUETO:
            texto = request.getParameter("textAreaVersoBloquetoBlqPadrao");
            break;
        case BLOQ_PADRAO_FICHA_COMP:
            texto = request.getParameter("textAreaFichaCompensacaoBlqPadrao");
            break;
        case BLOQ_PERSONALIZADO_RECIBO_SACADO:
            texto = request.getParameter("textAreaReciboSacadoBlqPersonalizado");
            break;
        case BLOQ_PERSONALIZADO_VERSO_BLOQUETO:
            texto = request.getParameter("textAreaVersoBloquetoBlqPersonalizado");
            break;
        case BLOQ_PERSONALIZADO_FICHA_COMP:
            texto = request.getParameter("textAreaFichaCompensacaoBlqPersonalizado");
            break;
        case BLOQ_PERSONALIZADO_RECIBO_SACADO_A:
            texto = request.getParameter("textAreaReciboSacadoABlqPersonalizado");
            break;
        case BLOQ_PERSONALIZADO_RECIBO_SACADO_B:
            texto = request.getParameter("textAreaReciboSacadoBBlqPersonalizado");
            break;
        case BLOQ_PRE_IMPRESSO_RECIBO_SACADO_LASER:
            texto = request.getParameter("textAreaReciboSacadoBlqPreImpresso");
            break;
        case BLOQ_PRE_IMPRESSO_FICHA_COMP_MATRIC:
            texto = request.getParameter("textAreaFichaCompensacaoBlqPreImpresso");
            break;
        case BLOQ_BANCO_CORRESPONDENTE:
            texto = request.getParameter("textAreaReciboSacadoBancoCorresp");
            break;
        case BLOQ_DDA_IMPRESSO:
        	texto = request.getParameter("textAreaReciboDDAImpresso");
        	break;
        }

        ArrayList linhas = this.quebraLinhas(texto);
        return linhas;
    }

    //
    // Recebe um texto e o separa num ArrayList de acordo com os \n
    //
    private ArrayList quebraLinhas(String texto) {
        ArrayList alLinhas = new ArrayList();

        String temp = "";
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) != '\r' && texto.charAt(i) != '\n') {
                temp += texto.charAt(i);
            } else {
                if (texto.charAt(i) == '\r') {
                    i++; // pula o \n caso encontre o \r
                }

                alLinhas.add(temp.toUpperCase());
                temp = "";
            }
        }

        return alLinhas;
    }

    public static void main(String[] args) {
        /*
         * CedenteAlterarGuiaMsgBloqFinalizar teste = new
         * CedenteAlterarGuiaMsgBloqFinalizar(); ArrayList a =
         * teste.quebraLinhas("a\n\n\n\n\n\n\n\n\n");
         * System.out.println(a.size()); for (int i = 0; i < a.size(); i++) {
         * System.out.print("!"+a.get(i)+"!"); }
         */
        System.out.println(Util.completaEspacos("", 80).length());
    }
}
