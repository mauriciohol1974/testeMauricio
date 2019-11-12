package br.gov.caixa.sigcb.estrategia.dda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.DdaGeraisBean;
import br.gov.caixa.sigcb.bean.DdaReimpBloquetoBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.SigcbBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * Projeto: SIGCB Componente responsável pelo controle da funcionalidade
 * REIMPRESSAO DE BLOQUETOS DDA Criada em: 19/01/2010
 * 
 * @author Glauber Gallego - glauber.gallego@probank.com.br
 */
public class DdaReimpBloquetoConsultarListar extends DdaReimpBloquetoEstrategia {

	public String processRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		this.configMsgSucessoErro(request);

		DdaReimpBloquetoBean ddaReimplBloquetoBean = new DdaReimpBloquetoBean();

		if (getFluxo(request).equals(FLUXO_NORMAL)) {
			ddaReimplBloquetoBean = (DdaReimpBloquetoBean) ddaReimplBloquetoBean
					.getRequestBean(request);
		} else {
			ddaReimplBloquetoBean = (DdaReimpBloquetoBean) ddaReimplBloquetoBean
					.getSessionBean(request, BEAN_FILTRO);
		}

		request.getSession().setAttribute(BEAN_LISTAR, ddaReimplBloquetoBean);
		request.getSession().setAttribute(BEAN_TITULO, ddaReimplBloquetoBean);
		request.getSession().setAttribute(BEAN_TITULO_DESCONTOS,
				ddaReimplBloquetoBean);
		request.getSession().setAttribute(BEAN_TITULO_INSTRUCOES,
				ddaReimplBloquetoBean);

		//MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

		// BG9L
		List tituloBeanList = handler.executeFixDataRecordsetTransaction(
				ddaReimplBloquetoBean, TRANSACAO_TITULO);
		DdaReimpBloquetoBean tituloBean = (DdaReimpBloquetoBean) ((BeanList) tituloBeanList
				.get(0)).get(0);
		BeanList descontoBeanList = (BeanList) tituloBeanList.get(1);
		List descontoList = convertDataStructure(descontoBeanList.iterator());
		request.getSession().setAttribute(BEAN_TITULO, tituloBean);
		request.getSession().setAttribute(BEAN_TITULO_DESCONTOS, descontoList);

		// BG9M
		BeanList instrucoesBeanList = handler.executeSimpleTransactionQuery(
				ddaReimplBloquetoBean, TRANSACAO_TITULO_INSTRUCOES);
		List instrucoesList = convertDataStructure(instrucoesBeanList
				.iterator());
		request.getSession().setAttribute(BEAN_TITULO_INSTRUCOES,
				instrucoesList);

		return PAGE_SUCESSO;
	}

	protected void configMsgSucessoErro(HttpServletRequest request) {
		MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
		msgBean.setMsgError("");
		msgBean.setMsgSucess("Solicitação de 2. via de Bloqueto Realizada com sucesso");
		msgBean.setStrategyErrorReturn(STRATEGY_FILTRO);
		msgBean.setStrategySucessReturn(STRATEGY_INICIAR);
		msgBean.setTitlePage(PAGE_TITLE);
		request.getSession().setAttribute(MSG_BEAN, msgBean);
	}

}
