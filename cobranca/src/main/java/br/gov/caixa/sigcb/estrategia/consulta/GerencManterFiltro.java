package br.gov.caixa.sigcb.estrategia.consulta;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.WrappingException;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.GerencBloquetoBean;
import br.gov.caixa.sigcb.bean.GerencCedCnabBean;
import br.gov.caixa.sigcb.bean.GerencCedMeioEntradaBean;
import br.gov.caixa.sigcb.bean.GerencCedMovimentoBean;
import br.gov.caixa.sigcb.bean.GerencCedSituacaoBean;
import br.gov.caixa.sigcb.bean.GerencFiltroBean;
import br.gov.caixa.sigcb.bean.GerencPrecoBean;
import br.gov.caixa.sigcb.bean.GerencTituloBean;
import br.gov.caixa.sigcb.bean.GerencTotalTarifaBean;
import br.gov.caixa.sigcb.bean.GerencValTarifaBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.SigcbBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.ejb.session.MainframeException;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.ObjectProperty;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;
import br.gov.caixa.sigcb.util.SigcbException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerenciais >>
 * Manter Filtro
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>16/11/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */

public class GerencManterFiltro extends GerencEstrategia {

    private String[] transacoes = null;

    private String[] paginasRetorno = null;

    private SigcbBean[] beans = null;

    public GerencManterFiltro() throws Exception {
        initEstrategia();
    }

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        /* PROG COMUM */

        configMsgSucessoErro(request);

        String retorno = "";
        String fluxo = getFluxo(request);

        GerencFiltroBean filtroBean = new GerencFiltroBean();

        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(USUARIOLDAP_BEAN);

        if (fluxo.equals(FLUXO_NORMAL)) {
            filtroBean = (GerencFiltroBean) filtroBean.getRequestBean(request);
            PilhaVoltarControle.push(request, filtroBean);
        } else {
            filtroBean = (GerencFiltroBean) PilhaVoltarControle.pop(request);
            if (filtroBean == null) {
                return (new GerencManterIniciar()).processRequest(request,
                        response);
            }
        }

        request.getSession().setAttribute(BEAN_FILTRO, filtroBean);

        // Cedente Padrão
        if (filtroBean.getCodigoCedente() != null
            && !filtroBean.getCodigoCedente().equals(new Long(0))) {
            request.getSession().setAttribute(CEDENTE_ATUAL,
                    filtroBean.getCodigoCedente());
        }

        /* nota */
        // quando a propriedade do bean consolidado esta marcada com um 1
        // significa que
        // o usuário marcou sim no checkbox Consolidado ou o usuário selecionou
        // um relatório
        // por cedente no tipo de filtro, e o resultado será um relatório com
        // informação nao sumarizadas.
        if (filtroBean.getConsolidado().equals(CONSOLIDADO_SIM)) {
            int opcao = filtroBean.getTpFiltro().intValue();
            SigcbBean entradaBean = beans[opcao];
            String transacao = transacoes[opcao];
            // if(LogUtilSigcb.isDebugEnabled()){
            // LogUtilSigcb.debug("------>FILTRO : CONSOLIDADO SIM");
            // LogUtilSigcb.debug("------>tipofiltro : "+ opcao);
            // LogUtilSigcb.debug("------>transacao : "+ transacao);
            // LogUtilSigcb.debug("------>tipoTitulo : "+
            // filtroBean.getTipoTitulo());
            // }
            entradaBean.copyBean(filtroBean);

            executaTransacao(request, entradaBean, transacao);
            retorno = paginasRetorno[opcao];

            // if(LogUtilSigcb.isDebugEnabled()){
            // LogUtilSigcb.debug("------>PAGINA DE RETORNO : " + retorno);
            // }

        } else {
            // if(LogUtilSigcb.isDebugEnabled()){
            // LogUtilSigcb.debug("------>FILTRO : CONSOLIDADO NAO");
            // LogUtilSigcb.debug("------>FiltroBean.TipoConsulta : "+
            // filtroBean.getTipoConsulta().intValue());
            // }
            switch (filtroBean.getTipoConsulta().intValue()) {

            /* nota */
            // somente deverão entrar aqui as pesquisas NÃO CONSOLIDADAS
            // serão efetuadas as transações de lista.
            case 2:
                /* nota */
                // PV - BGF2
                // if(LogUtilSigcb.isDebugEnabled()){
                // LogUtilSigcb.debug("------>FiltroBean.TpFiltro : "+
                // filtroBean.getTpFiltro().intValue());
                // }
                switch (filtroBean.getTpFiltro().intValue()) { // GMG:
                // excecoes
                // ao modo
                // default...
                case 4: // TRANS_CED_CNAB
                case 6: // TRANS_CED_SIT_TESTE
                case 8: // TRANS_PRCOTAR_RECEB
                    int opcao = filtroBean.getTpFiltro().intValue();
                    SigcbBean entradaBean = beans[opcao];
                    String transacao = transacoes[opcao];
                    // if(LogUtilSigcb.isDebugEnabled()){
                    // LogUtilSigcb.debug("------>Transacao : "+
                    // transacao);
                    // }
                    entradaBean.copyBean(filtroBean);
                    executaTransacao(request, entradaBean, transacao);
                    retorno = paginasRetorno[opcao];

                    break;
                default:
                    filtroBean.setCodigoUsuario(usuarioBean.getCodigoUsuario()); // Atribuindo
                    // o
                    // codigo
                    // do
                    // usuário
                    // if(LogUtilSigcb.isDebugEnabled()){
                    // LogUtilSigcb.debug("------>FiltroBean.TpFiltro :
                    // DEFAULT");
                    // LogUtilSigcb.debug("------>FiltroBean.setCodigoUsuario
                    // : " + usuarioBean.getCodigoUsuario());
                    // LogUtilSigcb.debug("------>Transacao
                    // TRANS_LISTAR_CED: "+ TRANS_LISTAR_CED);
                    // }
                    executaTransacao(request, filtroBean, TRANS_LISTAR_CED);
                    retorno = PAGE_LISTAR;
                    break;
                }

                break;
            case 3:
                /* nota */
                // EN - BGF1
                // if(LogUtilSigcb.isDebugEnabled()){
                // LogUtilSigcb.debug("------>Transacao TRANS_LISTAR_PV : "+
                // TRANS_LISTAR_PV);
                // }
                executaTransacao(request, filtroBean, TRANS_LISTAR_PV);

                retorno = PAGE_LISTAR;
                break;
            case 4:
                /* nota */
                // CAIXA - BGF0
                //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
                MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
                // if(LogUtilSigcb.isDebugEnabled()){
                // LogUtilSigcb.debug("------>Transacao TRANS_LISTAR_EN : "+
                // TRANS_LISTAR_EN);
                // }
                 usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
                String transUser = TRANS_LISTAR_EN + usuarioBean.getCodigoUsuario().toUpperCase();
                BeanList gerencBeanList = handler.executeSimpleTransactionQuery(filtroBean,
                		transUser);

                ArrayList gerencArrayList = convertDataStructure(gerencBeanList.iterator());

                request.getSession().setAttribute(BEAN_FIXO, filtroBean);
                request.getSession().setAttribute(PAGINACAO_LIST,
                        getPageHolder(gerencArrayList));
                request.setAttribute(PAGINACAO_PAGE, "0");

                retorno = PAGE_LISTAR;
                break;
            }
        }

        if (filtroBean.getTipoConsulta().equals(TIPO_CONSULTA_CEDENTE)) {
            // if(LogUtilSigcb.isDebugEnabled()){
            // LogUtilSigcb.debug("------>O TIPO DE CONSULTA FOI POR CEDENTE -
            // OBTENDO O CABEÇALHO");
            // }
            this.obterCabecalhoCedente(request, usuarioBean, filtroBean);

            // if(LogUtilSigcb.isDebugEnabled()){
            // LogUtilSigcb.debug("------>FIM OBTENDO O CABEÇALHO");
            // }
        }

        return retorno;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_FILTRO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);

        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

    protected void executaTransacao(HttpServletRequest request,
            SigcbBean bean,
            String transacao) throws MainframeException, SigcbException,
            RemoteException, WrappingException, IllegalAccessException,
            InvocationTargetException, NoSuchMethodException {
        LogUtilSigcb.info(">>>>EXECUTANDO TRANSACAO =" + transacao + "<<<<");
        List respostaList = this.executaTransacao(bean, transacao);

        SigcbBean respostaBean = (SigcbBean) ((BeanList) respostaList.get(0)).get(0);
        BeanList respostaBeanList = (BeanList) respostaList.get(1);

        ArrayList respostaArrayList = convertDataStructure(respostaBeanList.iterator());

        LogUtilSigcb.info(">>>>TRANSACAO EXECUTADA - OBJETO DE RETORNO = "
                          + respostaList.get(0).getClass()
                          + "QTDE = "
                          + respostaList.size()
                          + "<<<<");
        LogUtilSigcb.info(">>>>RespostaBean - "
                          + (SigcbBean) ((BeanList) respostaList.get(0)).get(0)
                          + "<<<<");
        LogUtilSigcb.info(">>>>RespostaBeanList - "
                          + ((BeanList) respostaList.get(1)).size()
                          + "<<<<");
        LogUtilSigcb.info(">>>>RespostaArrayList - "
                          + respostaArrayList.size()
                          + "<<<<");
        for (int i = 0; i < respostaArrayList.size(); i++) {
            LogUtilSigcb.info(">>>>RespostaArrayList - pos "
                              + i
                              + " - Class : "
                              + respostaArrayList.get(i).getClass()
                              + " "
                              + respostaArrayList.get(i)
                              + "<<<<");
        }

        this.setaNomeUnidade(request, respostaBean);
        request.getSession().setAttribute(BEAN_FIXO, respostaBean);
        request.getSession().setAttribute(PAGINACAO_LIST,
                getPageHolder(respostaArrayList));
        request.setAttribute(PAGINACAO_PAGE, "0");

        // if(LogUtilSigcb.isDebugEnabled()){
        // LogUtilSigcb.debug(">>>>FIM TRANSACAO<<<<");
        // }

    }

    protected List executaTransacao(SigcbBean bean, String transacao)
            throws MainframeException, SigcbException, RemoteException,
            WrappingException {
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        return handler.executeFixDataRecordsetTransaction(bean, transacao);
    }

    private void obterCabecalhoCedente(HttpServletRequest request,
            InformacoesUsuarioBean usuarioBean,
            GerencFiltroBean filtroBean) throws Exception {
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        cedCabBean.newBean();

        // Definindo atributos para executar a transação BGM0 para obter o
        // cabeçalho
        cedCabBean.setTipoConsulta(new Long(1));
        cedCabBean.setOrigemConsulta(new Long(1));
        cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
        cedCabBean.setCodigoCedente(filtroBean.getCodigoCedente());

        request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, cedCabBean);

        // Chamada ao Mainframe para cabecalho cedente
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
         usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CEDENTE_CABECALHO + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
        		transUser);
        cedCabBean = (CedenteCabecaBean) cedCabBeanList.get(0);

        cedCabBean.setCodigoCedente(filtroBean.getCodigoCedente());

        // Guarda informacoes de cabecalho
        request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, cedCabBean);
    }

    // *******************ATENÇÃO**********************************************************************
    // Se for incluído um novo valor nos array's, é necessário incluir na
    // mesma posição
    // no array que contém as descrições no filtroBean e na página
    // gerenc_consultar_qttitinc.jsp no
    // campo hidden tpFiltro na function consultarDetalhe de acordo com a
    // posição da tela de detalhe
    // do título.
    // ************************************************************************************************
    protected void initEstrategia() throws Exception {
        transacoes = new String[] { TRANS_BLOQ_LASER, // 0
                                   TRANS_BLOQ_PRE_IMP, // 1
                                   TRANS_BLOQ_CARNE, // 2
                                   TRANS_BLOQ_PERSONALIZADOS, // 3
                                   TRANS_CED_CNAB, // 4
                                   TRANS_CED_MEIO_ENT, // 5
                                   TRANS_CED_SIT_TESTE, // 6
                                   TRANS_MOV_COB_TP_VAN, // 7
                                   TRANS_PRCOTAR_RECEB, // 8
                                   TRANS_PRCOTAR_VINC, // 9
                                   TRANS_MOVTIT, // 10
                                   TRANS_MOVTIT_TAR_FLT, // 11
                                   TRANS_POSTIT_SERVICOS, // 12
                                   TRANS_TITINC, // 13
                                   TRANS_TITINC_TP_COBR, // 14
                                   TRANS_TITLIQ_FLT_ZERO, // 15
                                   TRANS_TITLIQ_SERVICO, // 16
                                   TRANS_TITLIQ_IOF, //17
                                   TRANS_EMIPOS_EXTRATO, // 18
                                   TRANS_TARLIQ_SERVICO, // 19
                                   TRANS_PROT_TIT, // 20
                                   TRANS_SERVICOS_DIV, // 21
                                   TRANS_TOTAL_TARIFAS, // 22
                                   TRANS_TITINC_DET, // 23
        };

        beans = new SigcbBean[] { new GerencBloquetoBean().newBean(), // 0
                                 new GerencBloquetoBean().newBean(), // 1
                                 new GerencBloquetoBean().newBean(), // 2
                                 new GerencBloquetoBean().newBean(), // 3
                                 new GerencCedCnabBean().newBean(), // 4
                                 new GerencCedMeioEntradaBean().newBean(), // 5
                                 new GerencCedSituacaoBean().newBean(), // 6
                                 new GerencCedMovimentoBean().newBean(), // 7
                                 new GerencPrecoBean().newBean(), // 8
                                 new GerencPrecoBean().newBean(), // 9
                                 new GerencTituloBean().newBean(), // 10
                                 new GerencTituloBean().newBean(), // 11
                                 new GerencTituloBean().newBean(), // 12
                                 new GerencTituloBean().newBean(), // 13
                                 new GerencTituloBean().newBean(), // 14
                                 new GerencTituloBean().newBean(), // 15
                                 new GerencTituloBean().newBean(), // 16
                                 new GerencTituloBean().newBean(), // 17
                                 new GerencValTarifaBean().newBean(), // 18
                                 new GerencValTarifaBean().newBean(), // 19
                                 new GerencValTarifaBean().newBean(), // 20
                                 new GerencValTarifaBean().newBean(), // 21
                                 new GerencTotalTarifaBean().newBean(), // 22
                                 new GerencTituloBean().newBean(), // 23
        };

        paginasRetorno = new String[] { PAGE_BLOQUETOS_LASER_PADRAO, // 0
                                       PAGE_BLOQUETOS_PRE_IMPRESSOS, // 1
                                       PAGE_BLOQUETOS_CARNES_LASER, // 2
                                       PAGE_BLOQUETOS_PERSONALIZADOS, // 3
                                       PAGE_CEDENTES_PADRAO_CNAB, // 4
                                       PAGE_CEDENTES_MEIO_ENTRADA, // 5
                                       PAGE_CEDENTES_SIT_TESTE_PROD, // 6
                                       PAGE_MOVIMENTO_TP_VAN, // 7
                                       PAGE_POSICAO_PV_EN_RECEBEDOR, // 8
                                       PAGE_POSICAO_PV_EN_VINCULACAO, // 9
                                       PAGE_MOV_TITULOS, // 10
                                       PAGE_MOV_TITULOS_TARIFA_FLOAT, // 11
                                       PAGE_POSICAO_TIT_CART_SERVICO, // 12
                                       PAGE_TITULOS_INCLUIDOS, // 13
                                       PAGE_TITULOS_INCLUIDOS_LIQ, // 14
                                       PAGE_TITULOS_LIQ_FLOAT_ZERO, // 15
                                       PAGE_TITULOS_LIQ_SERVICOS_MEIO_LIQ, //16
                                       PAGE_TITULOS_LIQ_IOF, // 17
                                       PAGE_EMISSAO_POST_BLOQ_EXTRATO, // 18
                                       PAGE_LIQ_SERVICOS_MEIO_LIQ, // 19
                                       PAGE_PROTESTO_TITULOS, // 20
                                       PAGE_SERVICOS_DIVERSOS, // 21
                                       PAGE_TOTAL_TARIFAS, // 22
                                       PAGE_TITULOS_INCLUIDOS_DET, // 23
        };
    }

    /**
     * Seta o nome da unidade do bean passado no bean de filtro
     */
    protected void setaNomeUnidade(HttpServletRequest request, SigcbBean bean)
            throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {
        String nomeUnidade = (String) ObjectProperty.getSimpleProperty(bean,
                "nomeUnidade");
        GerencFiltroBean filtroBean = (GerencFiltroBean) request.getSession()
                .getAttribute(GerencEstrategia.BEAN_FILTRO);
        filtroBean.setNomeUnidade(nomeUnidade);
        request.getSession().setAttribute(GerencEstrategia.BEAN_FILTRO,
                filtroBean);
    }

}
