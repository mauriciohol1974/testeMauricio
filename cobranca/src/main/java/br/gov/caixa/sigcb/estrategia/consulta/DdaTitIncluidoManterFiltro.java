package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.DdaTituloDiaBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;
import br.gov.caixa.sigcb.util.jsp.PaginacaoTag;

/**
 * <B>Projeto: SIGCB - DDA</B><BR>
 * Componente responsável pelo controle da funcionalidade Consulta >> DDA
 * 
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/09/2009</DD>
 * </DL>
 * 
 * @author Alexandre Lima - alexandre.lima@probank.com.br
 */
public class DdaTitIncluidoManterFiltro extends DdaTitIncluidoEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String retorno = "";

        configMsgSucessoErro(request);

        String fluxo = getFluxo(request);

        DdaTituloDiaBean ddaFiltroTitBean = new DdaTituloDiaBean();
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        InformacoesUsuarioBean usuarioBean = new InformacoesUsuarioBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
        	ddaFiltroTitBean = (DdaTituloDiaBean) ddaFiltroTitBean.getRequestBean(request);
            cedCabBean = (CedenteCabecaBean) cedCabBean.getRequestBean(request);
            //  23/08
            PilhaVoltarControle.push(request, ddaFiltroTitBean);
        } else {
            //  22/08
        	ddaFiltroTitBean = (DdaTituloDiaBean) PilhaVoltarControle.pop(request);
            if (ddaFiltroTitBean == null) {
                return (new DdaTitIncluidoIniciar()).processRequest(request,
                        response);
            }
            cedCabBean = (CedenteCabecaBean) cedCabBean.getSessionBean(request,
                    CABECALHO_BEAN);
        }

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(USUARIOLDAP_BEAN);

        request.getSession().setAttribute(CEDENTE_ATUAL,
        		ddaFiltroTitBean.getCodigoCedente());// cedente padrao
        request.getSession().setAttribute(FILTRO_BEAN, ddaFiltroTitBean);

        switch (ddaFiltroTitBean.getTpConsulta().intValue()) {

        case 0: /* consulta por cedente */

            /* BGM0 */// - Obtem dados do Cedente
            cedCabBean.setTipoConsulta(new Long(1));
            cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
            cedCabBean.setCodigoCedente(ddaFiltroTitBean.getCodigoCedente());
            cedCabBean.setOrigemConsulta(new Long(1));
             usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANS_CEDENTE_CABECALHO + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList cedCabBeanList = (BeanList) handler.executeSimpleTransactionQuery(cedCabBean,
            		transUser);

            CedenteCabecaBean cabecalhoBean = (CedenteCabecaBean) cedCabBeanList.get(0);
            cabecalhoBean.setCodigoCedente(ddaFiltroTitBean.getCodigoCedente());

            request.getSession().setAttribute(CABECALHO_BEAN, cabecalhoBean);

            /* BGGB */// - Listar Títulos
            int paginaAtual = 1;
            try {
                paginaAtual = Integer.parseInt(request.getParameter("pagina"));
            } catch (Exception e) {
            }

            ddaFiltroTitBean.setPagina((long) paginaAtual);

            ddaFiltroTitBean.setTipoConsulta(new Long(1));
            ddaFiltroTitBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
             transUser = TRANS_LISTA_TITULOS + usuarioBean.getCodigoUsuario().toUpperCase();
            List titulosList = (List) handler.executeFixDataRecordsetTransaction(ddaFiltroTitBean,
            		transUser);           
            
            
            DdaTituloDiaBean fixoBean = (DdaTituloDiaBean) ((BeanList) titulosList.get(0)).get(0);

            BeanList titLiqBeanList = (BeanList) titulosList.get(1);
            ArrayList titPagArray = convertDataStructure(titLiqBeanList.iterator());

            ddaFiltroTitBean.setDataCredito(fixoBean.getDataCredito());

            request.getSession().setAttribute(PAGINACAO_LIST,
                    getPageHolder(titPagArray));
            request.setAttribute(PAGINACAO_PAGE, "0");

            request.setAttribute(PaginacaoTag.PAGINA_ATUAL, paginaAtual);
            request.setAttribute(PaginacaoTag.PAGINA_TOTAL,
                    (int) Math.ceil(fixoBean.getTotalRegistro() / 20.0));

            retorno = PAGE_LIQ_LISTA_CED;
            break;

        case 1: /* consulta por Unidade de Vinculacao */

            /* BGD3 */// - Lista cedentes por Unidade Vinculacao
        	ddaFiltroTitBean.setTipoConsulta(new Long(1));
        	ddaFiltroTitBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
        	transUser = TRANS_CEDENTE_POR_PV + usuarioBean.getCodigoUsuario().toUpperCase();
            List listaCedente = (List) handler.executeFixDataRecordsetTransaction(ddaFiltroTitBean,
            		transUser);

            DdaTituloDiaBean fixoCedBean = (DdaTituloDiaBean) ((BeanList) listaCedente.get(0)).get(0);
            ArrayList cedenteArray = convertDataStructure(((BeanList) listaCedente.get(1)).iterator());

            ddaFiltroTitBean.setNomeUnidade(fixoCedBean.getNomeUnidade());

            request.getSession().setAttribute(PAGINACAO_LIST,
                    getPageHolder(cedenteArray));

            request.setAttribute(PAGINACAO_PAGE, "0");

            retorno = PAGE_LIQ_LISTA_PV;
            break;
        }

        request.getSession().setAttribute(FILTRO_BEAN, ddaFiltroTitBean);

        return retorno;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();

        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);

        request.getSession().setAttribute(MSG_BEAN, msgBean);

    }

}
