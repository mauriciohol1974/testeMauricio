package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
//import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.ConGerTitulosLiquidadosIOFBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas - Títulos
 * liquidados com retenção IOF
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>07/12/2010</DD>
 * </DL>
 * 
 * @author Adelaine Rondon - adelaine.rondon@probank.com.br
 */


public class TitLiqIOFManterFiltro extends TitLiqIOFManterEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

    	String retorno = PAGE_LIQIOF_CONSULTAR;

        configMsgSucessoErro(request);

        String fluxo = getFluxo(request);

        ConGerTitulosLiquidadosIOFBean filtroTitIOFBean = new ConGerTitulosLiquidadosIOFBean();
        InformacoesUsuarioBean usuarioBean = new InformacoesUsuarioBean();

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(USUARIOLDAP_BEAN);

        if (fluxo.equals(FLUXO_NORMAL)) {
        	filtroTitIOFBean = (ConGerTitulosLiquidadosIOFBean) filtroTitIOFBean.getRequestBean(request);

        } else {
        	filtroTitIOFBean = (ConGerTitulosLiquidadosIOFBean) filtroTitIOFBean.getSessionBean(request,
                    FILTRO_BEAN);
        }

        if (filtroTitIOFBean.getInformacao() != null && filtroTitIOFBean.getInformacao().intValue() != 0) {
            request.getSession().setAttribute(INFORMACAO_ATUAL, filtroTitIOFBean.getInformacao());
        }
        request.getSession().setAttribute(FILTRO_BEAN, filtroTitIOFBean);

        /* BGEC */
        List titulosList = (List) handler.executeFixDataRecordsetTransaction(filtroTitIOFBean,
                TRANS_LISTA_TITULOS);
        
        ConGerTitulosLiquidadosIOFBean fixoBean = (ConGerTitulosLiquidadosIOFBean) ((BeanList) titulosList.get(0)).get(0);

        BeanList titLiqBeanList = (BeanList) titulosList.get(1);
        ArrayList titPagArray = convertDataStructure(titLiqBeanList.iterator());

        List decendios = separarDecendios(titPagArray, fixoBean);
        
        // pega da parte fixa o nome do cedente
        filtroTitIOFBean.setNome(fixoBean.getNome());
        
        request.getSession().setAttribute(LISTA_DECENDIOS, decendios);
        request.getSession().setAttribute(FILTRO_BEAN, filtroTitIOFBean);

        return retorno;
    }

    private List separarDecendios(ArrayList titPagArray, ConGerTitulosLiquidadosIOFBean fixoBean) {
		List<List> decendios = new ArrayList<List>();
		List<ConGerTitulosLiquidadosIOFBean> decendio = null;
		ConGerTitulosLiquidadosIOFBean bean;
		int decendioAtual = -1;
		
		for (Iterator iter = titPagArray.iterator(); iter.hasNext();) {
			bean = (ConGerTitulosLiquidadosIOFBean) iter.next();
			
			if (bean.getDecendio().intValue() != decendioAtual) {
				decendio = new ArrayList<ConGerTitulosLiquidadosIOFBean>();
				decendios.add(decendio);
				decendioAtual = bean.getDecendio().intValue();
			}
			decendio.add(bean);
		}
		
		// cria os beans dos totais
		if (decendios.size() >= 1) {
			decendio = decendios.get(0);
			bean = new ConGerTitulosLiquidadosIOFBean();
			bean.setQuantidadeTitulos(fixoBean.getDecendio1TotalQuantidade());
			bean.setValorTitulo(fixoBean.getDecendio1TotalValorTitulos());
			bean.setValorCreditado(fixoBean.getDecendio1TotalValorCreditado());
			bean.setValorIOF(fixoBean.getDecendio1TotalValorIOF());
			// adiciona no final da lista do decendio
			decendio.add(bean);
		}
		
		if (decendios.size() >= 2) {
			decendio = decendios.get(1);
			bean = new ConGerTitulosLiquidadosIOFBean();
			bean.setQuantidadeTitulos(fixoBean.getDecendio2TotalQuantidade());
			bean.setValorTitulo(fixoBean.getDecendio2TotalValorTitulos());
			bean.setValorCreditado(fixoBean.getDecendio2TotalValorCreditado());
			bean.setValorIOF(fixoBean.getDecendio2TotalValorIOF());
			// adiciona no final da lista do decendio
			decendio.add(bean);
		}
		
		if (decendios.size() >= 3) {
			decendio = decendios.get(2);
			bean = new ConGerTitulosLiquidadosIOFBean();
			bean.setQuantidadeTitulos(fixoBean.getDecendio3TotalQuantidade());
			bean.setValorTitulo(fixoBean.getDecendio3TotalValorTitulos());
			bean.setValorCreditado(fixoBean.getDecendio3TotalValorCreditado());
			bean.setValorIOF(fixoBean.getDecendio3TotalValorIOF());
			// adiciona no final da lista do decendio
			decendio.add(bean);
		}
		
		return decendios;
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


