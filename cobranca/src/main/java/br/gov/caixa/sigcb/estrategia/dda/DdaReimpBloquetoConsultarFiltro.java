package br.gov.caixa.sigcb.estrategia.dda;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.WrappingException;
import br.gov.caixa.sigcb.bean.DdaReimpBloquetoBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.SigcbBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.ejb.session.MainframeException;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.SigcbException;

/**
 * Projeto: SIGCB Componente responsável pelo controle da funcionalidade
 * REIMPRESSAO DE BLOQUETOS DDA Criada em: 15/01/2010
 * 
 * @author Glauber Gallego - glauber.gallego@probank.com.br
 */
public class DdaReimpBloquetoConsultarFiltro extends DdaReimpBloquetoEstrategia {

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

		request.getSession().setAttribute(BEAN_FILTRO, ddaReimplBloquetoBean);
		request.getSession().setAttribute(BEAN_LISTAR, ddaReimplBloquetoBean);
		request.getSession().setAttribute(BEAN_TITULO, ddaReimplBloquetoBean);
		request.getSession().setAttribute(BEAN_TITULO_DESCONTOS, ddaReimplBloquetoBean);
		request.getSession().setAttribute(BEAN_TITULO_INSTRUCOES, ddaReimplBloquetoBean);

		SigcbBean entradaBean = new DdaReimpBloquetoBean().newBean();
		String transacao = TRANSACAO_LISTAR;
		entradaBean.copyBean(ddaReimplBloquetoBean);
		this.executaTransacao(request, entradaBean, transacao);

		return PAGE_LISTAR;
	}

	protected void executaTransacao(HttpServletRequest request, SigcbBean bean,
			String transacao) throws MainframeException, SigcbException,
			RemoteException, WrappingException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {

		//MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
		List respostaList = handler.executeFixDataRecordsetTransaction(bean,
				transacao);

		SigcbBean respostaBean = (SigcbBean) ((BeanList) respostaList.get(0))
				.get(0);
		BeanList respostaBeanList = (BeanList) respostaList.get(1);

		ArrayList respostaArrayList = convertDataStructure(respostaBeanList
				.iterator());

		request.getSession().setAttribute(BEAN_LISTAR, respostaBean);

		request.getSession().setAttribute(PAGINACAO_LIST,
				getPageHolder(respostaArrayList));
		request.setAttribute(PAGINACAO_PAGE, "0");
	}

	protected void configMsgSucessoErro(HttpServletRequest request) {
		MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
		msgBean.setMsgError("");
		msgBean.setMsgSucess("");
		msgBean.setStrategyErrorReturn(STRATEGY_INICIAR);
		msgBean.setStrategySucessReturn("");
		msgBean.setTitlePage(PAGE_TITLE_FILTRO);

		request.getSession().setAttribute(MSG_BEAN, msgBean);
	}

}
