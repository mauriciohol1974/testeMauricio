package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.types.MoneyType;
import br.com.politec.sao.business.types.PercentualType;
import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.util.Money;
import br.com.politec.sao.util.PageHolder;
import br.com.politec.sao.util.Pageable;
import br.com.politec.sao.util.Percentual;
import br.gov.caixa.sigcb.bean.CedenteTarifasBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.Util;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Incluir Cedente - Guia
 * Tarifas (Informar Tarifas)
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>30/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteIncluirTarifasFinalizar extends CedenteIncluirEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        this.configMsgSucessoErro(request);

        CedenteTarifasBean tarifasBean = (CedenteTarifasBean) (new CedenteTarifasBean()).getRequestBean(request);
        CedenteTarifasBean resposta = (CedenteTarifasBean) (new CedenteTarifasBean()).newBean();

        // Variaveis de paginacao
        request.setAttribute(PAGINACAO_PAGE, "0");
        request.setAttribute(PAGINACAO_PAGEANTERIOR, "0");

        // salva alteracoes feitas pelo usuario na pagina atual
        this.salvaPaginaAtual(request);

        // Monta os recordsets de subida
        PageHolder paginacao = (PageHolder) request.getSession()
                .getAttribute(CedenteEstrategia.PAGINACAO_LIST);
        ArrayList listaRecordsets = this.montaRecordsets(paginacao.getPageable());

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        tarifasBean.setNumeroTotalPacotes(new Long(listaRecordsets.size()));

        // Executa transacao para cada recordset
        for (int i = 0; i < listaRecordsets.size(); i++) {
            String strRecordset = (String) listaRecordsets.get(i);

            tarifasBean.setNumeroPacote(new Long(i + 1));
            tarifasBean.setStrRecordset(strRecordset);
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_INCLUIR_ALTERAR_INFORME_TARIFAS + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList blResposta = handler.executeSimpleTransactionQuery(tarifasBean,
            		transUser);

            // Se houver criticas, pára a inclusao e mostra as criticas
            if (blResposta.size() > 0) {
                resposta = (CedenteTarifasBean) blResposta.get(0);
                if (!resposta.getDescricaoCriticas().trim().equals("")) {
                    return CedenteIncluirGuiaControle.proximaGuia(request,
                            resposta.getDescricaoCriticas(),
                            PAGE_INCLUIR_TARIFAS_INFORME,
                            PAGE_INCLUIR_TARIFAS_INFORME);
                }
            }
        }

        // finaliza chamando transacao de controle de rajadas
        // para finalizar a janela de informe de tarifas
        tarifasBean.setTipoConclusao(new Long(3)); // 3 - Informe Tarifas
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CONCLUSAO_RAJADA + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList blResposta = handler.executeSimpleTransactionQuery(tarifasBean,
        		transUser);

        // Verifica criticas
        if (blResposta.size() > 0) {
            resposta = (CedenteTarifasBean) blResposta.get(0);
        }
        return CedenteIncluirGuiaControle.proximaGuia(request,
                resposta.getDescricaoCriticas(),
                PAGE_INCLUIR_TARIFAS_INFORME,
                PAGE_INCLUIR_TARIFAS_INFORME);
    }

    /**
     * Salva dados da pagina que foi submetida
     */
    private void salvaPaginaAtual(HttpServletRequest request) throws Exception {
        PageHolder paginacao = (PageHolder) request.getSession()
                .getAttribute(CedenteEstrategia.PAGINACAO_LIST);

        int paginaAnterior = 0;
        if (request.getParameter(CedenteEstrategia.PAGINACAO_PAGEANTERIOR) != null
            && !request.getParameter(CedenteEstrategia.PAGINACAO_PAGEANTERIOR)
                    .equals("")) {
            paginaAnterior = Integer.parseInt((String) request.getParameter(CedenteEstrategia.PAGINACAO_PAGEANTERIOR));
        } else {
            paginaAnterior = Integer.parseInt((String) request.getAttribute(CedenteEstrategia.PAGINACAO_PAGEANTERIOR));
        }
        List listaAnterior = paginacao.getPage(paginaAnterior);

        String[] arrayPercentualCalculado = null;
        String[] arrayValorCalculado = null;
        if (request.getParameterValues("arrayPercentualCalculado") != null
            && !request.getParameterValues("arrayPercentualCalculado")
                    .equals("")) {
            arrayPercentualCalculado = (String[]) request.getParameterValues("arrayPercentualCalculado");
        }
        if (request.getParameterValues("arrayValorCalculado") != null
            && !request.getParameterValues("arrayValorCalculado").equals("")) {
            arrayValorCalculado = (String[]) request.getParameterValues("arrayValorCalculado");
        }
        if (arrayPercentualCalculado != null) {
            for (int i = 0; i < arrayPercentualCalculado.length; i++) {
                CedenteTarifasBean bean = (CedenteTarifasBean) listaAnterior.get(i);
                String valorFormatado = arrayPercentualCalculado[i];
                String valor = valorFormatado.replace(".", "");
                bean.setPercentualCalculado((Percentual) PercentualType.create().newInstance(valor));
                
                if (i < arrayValorCalculado.length) {
                    bean.setValorCalculado((Money) MoneyType.create()
                            .newInstance(arrayValorCalculado[i]));
                }
            }
        }
    }

    /**
     * Monta os recordsets de acordo com a quantidade de registros que cabem
     * numa rajada
     * 
     * @param tarifasBeans
     *            Pageable que contem os dados a serem enviados para a transacao
     * @return ArrayList onde cada indice contem a String que representa o
     *         recordset
     */
    private ArrayList montaRecordsets(Pageable tarifasBeans) throws Exception {
        ArrayList listaRecordsets = new ArrayList();

        int registrosPorRajada = 11; // Quantidade de registros que cabem
        int registros = 0;

        // tamanho dos campos
        Layout tarifasLayout = (new CedenteTarifasBean()).getLayout();
        MainframeExtension tarifasExtension = ((MainframeExtension) tarifasLayout.getExtension("Mainframe"));

        int tamCodigoServico = tarifasExtension.get("codigoServico")
                .getLength();
        int tamDescricaoServico = tarifasExtension.get("descricaoServico")
                .getLength();
        int tamValorOriginal = tarifasExtension.get("valorOriginal")
                .getLength();
        int tamPercentualOriginal = tarifasExtension.get("percentualOriginal")
                .getLength();
        int tamValorCalculado = tarifasExtension.get("valorCalculado")
                .getLength();
        int tamPercentualCalculado = tarifasExtension.get("percentualCalculado")
                .getLength();

        String strRecordset = "";
        for (int i = 0; i < tarifasBeans.size(); i++) {
            registros++;

            CedenteTarifasBean bean = (CedenteTarifasBean) tarifasBeans.get(i);
            // LogUtilSigcb.debug("#$% Tarifas ::::::: " + i);
            // LogUtilSigcb.debug("#$% Bean :::::::::: " + bean);

            strRecordset += Util.zerosEsquerda(bean.getCodigoServico(),
                    tamCodigoServico);
            strRecordset += Util.completaEspacos(bean.getDescricaoServico(),
                    tamDescricaoServico);

            Money valorOriginal = bean.getValorOriginal();
            strRecordset += Util.zerosEsquerda(new Long(valorOriginal.getIntegerAmount()
                                                        * 100
                                                        + valorOriginal.getDecimalAmount()),
                    tamValorOriginal);

            Percentual percentualOriginal = bean.getPercentualOriginal();
            strRecordset += Util.zerosEsquerda(new Long(percentualOriginal.toValorSemPonto()),
                    tamPercentualOriginal);

            Money valorCalculado = bean.getValorCalculado();
            strRecordset += Util.zerosEsquerda(new Long(valorCalculado.getIntegerAmount()
                                                        * 100
                                                        + valorCalculado.getDecimalAmount()),
                    tamValorCalculado);

            Percentual percentualCalculado = bean.getPercentualCalculado();
            strRecordset += Util.zerosEsquerda(new Long(percentualCalculado.toValorSemPonto()),
                    tamPercentualCalculado);

            if (registros == registrosPorRajada) {
                listaRecordsets.add(strRecordset);
                strRecordset = "";
                registros = 0;
            }
        }

        // se houver registros ainda, adiciona o resto no arraylist
        if (registros > 0) {
            StringBuffer sb = new StringBuffer(strRecordset);
            while (sb.length() < 913) {
                sb.append(" ");
            }
            listaRecordsets.add(sb.toString());
        }

        return listaRecordsets;
    }

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO_SEM_MENU;
    }

}
