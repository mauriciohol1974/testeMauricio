package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.PageHolder;
import br.gov.caixa.sigcb.bean.CedenteTarifasBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Alterar Cedente - Guia
 * Tarifas (Informar Tarifas)
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>15/10/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteAlterarTarifasIniciar extends CedenteAlterarEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        this.configMsgSucessoErro(request);

        CedenteTarifasBean tarifasBean = (CedenteTarifasBean) (new CedenteTarifasBean()).getRequestBean(request);

        tarifasBean.setTipoConsulta("D");

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CONSULTAR_INFORME_TARIFAS + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList blDefault = handler.executeSimpleTransactionQuery(tarifasBean,transUser);

        ArrayList alTarifas = new ArrayList();

        tarifasBean.setTipoConsulta(ALTERACAO);
        transUser = TRANSACAO_CONSULTAR_INFORME_TARIFAS + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList blConsulta = handler.executeSimpleTransactionQuery(tarifasBean,transUser);
        alTarifas = this.montaArrayList(blDefault, blConsulta);

        PageHolder phTarifas = getPageHolder(alTarifas);
        phTarifas.setPageSize(TAMANHO_PAGINA_TARIFAS);
        request.getSession().setAttribute(PAGINACAO_LIST, phTarifas);
        request.setAttribute(PAGINACAO_PAGE, "0");
        request.setAttribute(PAGINACAO_PAGEANTERIOR, "0");

        request.setAttribute(CEDENTE_TARIFAS_INFORME_BEAN, tarifasBean);

        return PAGE_ALTERAR_TARIFAS_INFORME;
    }

    //
    // Merge dos defaults com os consultados
    //
    private ArrayList montaArrayList(BeanList blDefault, BeanList blConsulta) {
        // codigo servico como chave do bean de valores default
        TreeMap mapTarifas = new TreeMap();
        for (int i = 0; i < blDefault.size(); i++) {
            CedenteTarifasBean defaultBean = (CedenteTarifasBean) blDefault.get(i);
            mapTarifas.put(defaultBean.getCodigoServico(), defaultBean);
        }

        for (int i = 0; i < blConsulta.size(); i++) {
            CedenteTarifasBean consultaBean = (CedenteTarifasBean) blConsulta.get(i);
            CedenteTarifasBean defaultBean = (CedenteTarifasBean) mapTarifas.get(consultaBean.getCodigoServico());
            if (defaultBean != null) {
                consultaBean.setValorOriginal(defaultBean.getValorOriginal());
                consultaBean.setPercentualOriginal(defaultBean.getPercentualOriginal());
            }
            mapTarifas.put(consultaBean.getCodigoServico(), consultaBean);
        }

        // mapTarifas tem todos os defaults e consultados juntos, transforma num
        // arraylist
        ArrayList alTarifas = new ArrayList();
        Set keys = mapTarifas.keySet();
        Iterator itKeys = keys.iterator();
        while (itKeys.hasNext()) {
            alTarifas.add(mapTarifas.get(itKeys.next()));
        }

        return alTarifas;
    }

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO_SEM_MENU;
    }

}
