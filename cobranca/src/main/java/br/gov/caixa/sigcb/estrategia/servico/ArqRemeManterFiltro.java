package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.ArquivoRemessaBean;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.PvCobradorBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Listar Bloqueto
 * On-line
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>14/10/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class ArqRemeManterFiltro extends ArqRemeEstrategia {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8557976148424765480L;

	public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String page = "";
        String opcaoConsulta = "";
        configMsgSucessoErro(request);
        String fluxo = getFluxo(request);
        ArquivoRemessaBean arquivoRemessaBean = new ArquivoRemessaBean();
        

        if (fluxo.equals(FLUXO_NORMAL)) {
            // obter dados do filtro
            arquivoRemessaBean = (ArquivoRemessaBean) arquivoRemessaBean.getRequestBean(request);
            // Reter o bean antes de acessar o mainframe
            request.getSession().setAttribute(FILTRO_BEAN, arquivoRemessaBean);
            // para gerar informacoes para tela de erro
            if (!arquivoRemessaBean.getCodigoCedente().equals(new Long(0))) {
                request.getSession().setAttribute(CEDENTE_ATUAL,
                        arquivoRemessaBean.getCodigoCedente());
            }
            /*
             * if (arquivoRemessaBean.getCodigoCedente().longValue()==0 &&
             * arquivoRemessaBean.getApelidoCedente().equals("")) opcaoConsulta =
             * "UNIDADE"; else opcaoConsulta = "CEDENTE";
             */
            opcaoConsulta = arquivoRemessaBean.getOpcaoConsulta();
        } else {
            // obter filtro já armazenado
            arquivoRemessaBean = (ArquivoRemessaBean) arquivoRemessaBean.getSessionBean(request,
                    FILTRO_BEAN);
            String consultaUnidade = request.getParameter("consultaUnidade");
            if (consultaUnidade.equals("1"))
                opcaoConsulta = "UNIDADE";
            else
                opcaoConsulta = "CEDENTE";
        }
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(USUARIOLDAP_BEAN);
        arquivoRemessaBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());

        // Chamada ao Mainframe - Instancia o EJB que acessa o mainframe
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        BeanList arqBeanList = null;
        PvCobradorBean pvCobradorBean = new PvCobradorBean();
        // Obter os dados do cedente
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();
        cedCabBean.setTipoConsulta(new Long(1));
        cedCabBean.setOrigemConsulta(new Long(1));
        cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
        cedCabBean.setCodigoCedente(arquivoRemessaBean.getCodigoCedente());
        // armazenar para tela de erro
        request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, cedCabBean);
        // força o valor nesse campo, pois nessa funcionalidade este não é utilizado
        pvCobradorBean.setCodigoUnidadeCentral(arquivoRemessaBean.getCodigoUnidadeCentral());

        // Valida a opção "PV"
        if (opcaoConsulta.equals("UNIDADE")) {
            // consulta cedentes unidade
            pvCobradorBean.setCodigoUnidadePV(arquivoRemessaBean.getCodigoUnidadePV());
            //pvCobradorBean.setCodigoUnidadeCentral(arquivoRemessaBean.getCodigoUnidadeCentral());

            // Executa a transação BGM1
             usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CONS_UNIDADE + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList unidadeBeanList = (BeanList) handler.executeSimpleTransactionQuery(pvCobradorBean,
            		transUser);
            arquivoRemessaBean.setNomeUnidadePV(((PvCobradorBean) unidadeBeanList.get(0)).getNomeUnidadePV());
            request.getSession().setAttribute(DATA_BEAN, arquivoRemessaBean);

            // Executa a transação BG41
             transUser = TRANSACAO_LISTAR + usuarioBean.getCodigoUsuario().toUpperCase();
            arqBeanList = handler.executeSimpleTransactionQuery(arquivoRemessaBean,
            		transUser);
            page = PAGE_MANTER_LISTAR;
        } else {
            // Valida a opção "Cedente" ou "Apelido"
            /*
             * if (opcaoConsulta.equals("CEDENTE")) {
             * arquivoRemessaBean.setTipoConsulta(new Long(1)); }else {//APELIDO
             * arquivoRemessaBean.setTipoConsulta(new Long(2)); }
             */

            if (arquivoRemessaBean.getCodigoCedente().longValue() != 0) {
                arquivoRemessaBean.setTipoConsulta(new Long(1));
            } else if (!arquivoRemessaBean.getApelidoCedente().equals("")) {// APELIDO
                arquivoRemessaBean.setTipoConsulta(new Long(2));
            }

            List list = null;
            try {
                // BG42
                list = (List) handler.executeFixDataRecordsetTransaction(arquivoRemessaBean,
                        TRANSACAO_LISTAR_CED);
                arqBeanList = (BeanList) list.get(1);
                // parte fixa
                arquivoRemessaBean = (ArquivoRemessaBean) (((BeanList) list.get(0)).get(0));
                pvCobradorBean.setCodigoUnidadePV(arquivoRemessaBean.getCodigoUnidadePV());

                if (opcaoConsulta.equals("APELIDO")) {
                    cedCabBean.setCodigoCedente(arquivoRemessaBean.getCodigoCedente());
                }
                // BGM0
                 usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
                String transUser = TRANSACAO_VALIDAR_CEDENTE + usuarioBean.getCodigoUsuario().toUpperCase();
                BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
                		transUser);
                cedCabBean = (CedenteCabecaBean) cedCabBeanList.get(0);
                cedCabBean.setCodigoCedente(arquivoRemessaBean.getCodigoCedente());
                request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,
                        cedCabBean);

                page = PAGE_MANTER_LISTAR_CED;
            } catch (Exception e) {
                if (!opcaoConsulta.equals("APELIDO")) {
                    // BGM0
                	 usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
                     String transUser = TRANSACAO_VALIDAR_CEDENTE + usuarioBean.getCodigoUsuario().toUpperCase();
                     
                    BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
                    		transUser);
                    cedCabBean = (CedenteCabecaBean) cedCabBeanList.get(0);
                    cedCabBean.setCodigoCedente(arquivoRemessaBean.getCodigoCedente());
                    request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,
                            cedCabBean);
                    throw e;
                }
                throw e;
            }

            // BGM1
            String transUser = TRANSACAO_CONS_UNIDADE + usuarioBean.getCodigoUsuario().toUpperCase();
            
            BeanList unidadeBeanList = (BeanList) handler.executeSimpleTransactionQuery(pvCobradorBean,
            		transUser);
            arquivoRemessaBean.setNomeUnidadePV(((PvCobradorBean) unidadeBeanList.get(0)).getNomeUnidadePV());
            request.getSession().setAttribute(DATA_BEAN, arquivoRemessaBean);
        }

        ArrayList arqList = convertDataStructure(arqBeanList.iterator());
        request.getSession().setAttribute(PAGINACAO_LIST,
                getPageHolder(arqList));

        request.setAttribute(PAGINACAO_PAGE, "0");
        request.setAttribute(PAGINACAO_PAGEANTERIOR, "0");

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return page;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {

        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();

        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_MANTER_FILTRO);

        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}