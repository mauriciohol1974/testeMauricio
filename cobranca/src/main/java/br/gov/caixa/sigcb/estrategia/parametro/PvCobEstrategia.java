package br.gov.caixa.sigcb.estrategia.parametro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.PvCobradorBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.Formatador;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade PvCobrador
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>28/08/2004</DD>
 * </DL>
 * 
 * @author JE
 */

public abstract class PvCobEstrategia extends SigcbEstrategia {

    public static final String STRATEGY_INCLUIR_FILTRO = "parametro.PvCobIncluirIniciar";

    public static final String STRATEGY_INCLUIR = "parametro.PvCobIncluirFiltro";

    public static final String STRATEGY_INCLUIR_FINALIZAR = "parametro.PvCobIncluirFinalizar";

    public static final String STRATEGY_MANTER_FILTRO = "parametro.PvCobManterIniciar";

    public static final String STRATEGY_MANTER_LISTAR = "parametro.PvCobManterFiltro";

    public static final String STRATEGY_ALTERAR = "parametro.PvCobAlterarIniciar";

    public static final String STRATEGY_ALTERAR_FINALIZAR = "parametro.PvCobAlterarFinalizar";

    public static final String STRATEGY_EXCLUIR = "parametro.PvCobExcluirFinalizar";

    public static final String STRATEGY_CONSULTAR = "parametro.PvCobConsultarIniciar";// EAM
                                                                                        // 13/10

    public static final String PAGE_TITLE_INCLUIR = "Incluir PV Cobrador";

    public static final String PAGE_TITLE_MANTER = "Manter PV Cobrador";

    public static final String PAGE_TITLE_CONSULTAR = "Manter PV Cobrador >> Consultar";// EAM
                                                                                        // 13/10

    public static final String SUCESSO_INCLUIR = "PV Cobrador Incluído com Sucesso";

    public static final String SUCESSO_ALTERAR = "PV Cobrador Alterado com Sucesso";

    public static final String SUCESSO_EXCLUIR = "PV Cobrador Excluído com Sucesso";

    public static final String PAGE_MANTER_FILTRO = "/parametro/pvcob_manter_filtro";

    public static final String PAGE_MANTER_LISTAR = "/parametro/pvcob_manter_listar";

    public static final String PAGE_ALTERAR = "/parametro/pvcob_alterar";

    public static final String PAGE_INCLUIR = "/parametro/pvcob_incluir";

    public static final String PAGE_INCLUIR_FILTRO = "/parametro/pvcob_incluir_filtro";

    public static final String PAGE_SUCESSO = "/parametro/pvcob_sucesso";

    public static final String PAGE_ERRO = "/parametro/pvcob_erro";

    public static final String PAGE_CONSULTAR = "/parametro/pvcob_consultar"; // EAM
                                                                                // 13/10

    public static final String TRANSACAO_LISTAR = "BGK6";

    public static final String TRANSACAO_CONSULTAR_PVCOB = "BGK8";

    public static final String TRANSACAO_LISTAR_CEP = "BGK7";

    public static final String TRANSACAO_INCLUIR_ALTERAR = "BGK9";

    public static final String TRANSACAO_VALIDAR_EXCLUIR = "BGL0";

    public static final String TRANSACAO_CONS_UNIDADE = "BGM1";

    public static final String MSG_BEAN = "msgBean";

    public static final String FILTRO_BEAN = "filtroPvBean";

    public static final String DATA_BEAN = "pvBean";

    public static final String PAGINACAO_FIXO = "bean";

    public static final String PAGINACAO_LIST = "paginacao";

    public static final String PAGINACAO_PAGE = "paginaAtual";

    public static final String PAGINACAO_PAGEANTERIOR = "paginaAnterior";

    // Define tela customizada de erro
    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

    // EAM 13/10/2005 - 100% do código do método extraído da Classe
    // PvCobAlterarIniciar
    // Método para obter todos os dados a serem utilizados nas telas se
    // consultar e alterar.
    protected void getDadosPvCob(PvCobradorBean pvBean,
            HttpServletRequest request) throws Exception {
        // Chamada ao Mainframe
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();// Instancia
                                                                                // o
                                                                                // EJB
                                                                                // que
                                                                                // acessa
                                                                                // o
                                                                                // mainframe
    	  MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        PvCobradorBean pvCobBean = new PvCobradorBean();
        pvCobBean.setCodigoUnidadePV(pvBean.getCodigoUnidadePV());
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CONSULTAR_PVCOB + usuarioBean.getCodigoUsuario().toUpperCase();
        /* BGK8 */List list = (List) handler.executeFixDataRecordsetTransaction(pvCobBean,
        		transUser);
        // parte fixa
        pvCobBean = (PvCobradorBean) (((BeanList) list.get(0)).get(0));
        pvCobBean.setCodigoUnidadePV(pvBean.getCodigoUnidadePV());
        
        pvCobBean.setCodigoUnidadeCentral(pvBean.getCodigoUnidadeCentral());
        // dados para recuperar filtros
        pvCobBean.setCodUnidPVInicial(pvBean.getCodUnidPVInicial());
        pvCobBean.setCodUnidPVFinal(pvBean.getCodUnidPVFinal());
        pvCobBean.setNumeroCEPde(pvBean.getNumeroCEPde());
        pvCobBean.setNumeroCEPate(pvBean.getNumeroCEPate());
        pvCobBean.setAcao(pvBean.getAcao());
        // parte dos CEPs
        BeanList pvCobBeanList = (BeanList) list.get(1);
        ArrayList cepList = convertDataStructure(pvCobBeanList.iterator());
        Iterator a = cepList.iterator();
        int faixa = 0;
        for (int i = 0; i < 20; i++) {
            pvCobBean.setPropertyValue("numeroCEPde" + faixa,
                    (Object) new Long(0));
            pvCobBean.setPropertyValue("numeroCEPate" + faixa,
                    (Object) new Long(0));
            faixa++;
        }
        faixa = 0;
        while (a.hasNext()) {
            PvCobradorBean cep = (PvCobradorBean) a.next();
            pvCobBean.setPropertyValue("numeroCEPde" + faixa,
                    (Object) cep.getNumeroCEPde());
            pvCobBean.setPropertyValue("numeroCEPate" + faixa,
                    (Object) cep.getNumeroCEPate());
            faixa++;
        }

        //handler = SigcbEstrategia.lookUpMFHandler();// Instancia o EJB que
                                                    // acessa o mainframe
        handler = new MainFrameTransactionsSigcbEjb();
        // consultar dados SIICO para agencia (nome/email/endereço)
         usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
         transUser = TRANSACAO_CONS_UNIDADE + usuarioBean.getCodigoUsuario().toUpperCase();
        /* BGM1 */pvCobBeanList = (BeanList) handler.executeSimpleTransactionQuery(pvBean,
        		transUser);
        pvCobBean.setCodigoVAN(new Long(1)); // incluindo no bean a VAN
                                                // "EMBRATEL"
        pvCobBean.setNomeUnidadePV(((PvCobradorBean) pvCobBeanList.get(0)).getNomeUnidadePV());
        pvCobBean.setEmailUnidadePV(((PvCobradorBean) pvCobBeanList.get(0)).getEmailUnidadePV());
        pvCobBean.setEndereco(((PvCobradorBean) pvCobBeanList.get(0)).getEndereco());
        
        //pvCobBean.setCodigoUnidadeCentral(((PvCobradorBean) pvCobBeanList.get(0)).getCodigoUnidadeCentral());
        pvCobBean.setNomeUnidadeCentral(((PvCobradorBean) pvCobBeanList.get(0)).getNomeUnidadeCentral());
        pvCobBean.setEmailUnidadeCentral(((PvCobradorBean) pvCobBeanList.get(0)).getEmailUnidadeCentral());
        pvCobBean.setEnderecoCentral(((PvCobradorBean) pvCobBeanList.get(0)).getEnderecoCentral());

        request.getSession().setAttribute(DATA_BEAN, pvCobBean);
    }

}