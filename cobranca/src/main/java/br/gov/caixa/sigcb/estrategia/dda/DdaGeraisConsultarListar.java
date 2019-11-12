package br.gov.caixa.sigcb.estrategia.dda;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.DdaGeraisBean;
import br.gov.caixa.sigcb.bean.DdaReimpBloquetoBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * Projeto: SIGCB Componente responsável pelo controle da funcionalidade
 * CONSULTAS GERAIS DO DDA Criada em: 01/10/2009
 *
 * @author Glauber Gallego - glauber.gallego@probank.com.br
 */
public class DdaGeraisConsultarListar extends DdaGeraisEstrategia {

	public String processRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		this.configMsgSucessoErro(request);

		DdaGeraisBean ddaGeraisBean = new DdaGeraisBean();

		if (getFluxo(request).equals(FLUXO_NORMAL)) {
			ddaGeraisBean = (DdaGeraisBean) ddaGeraisBean
					.getRequestBean(request);
		} else {
			ddaGeraisBean = (DdaGeraisBean) ddaGeraisBean.getSessionBean(
					request, BEAN_LISTAR);
		}

		request.getSession().setAttribute(BEAN_LISTAR, ddaGeraisBean);
		request.getSession().setAttribute(BEAN_TITULO, ddaGeraisBean);
		request.getSession().setAttribute(BEAN_TITULO_DESCONTOS, ddaGeraisBean);

		//MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
		List tituloBeanList = handler.executeFixDataRecordsetTransaction(
				ddaGeraisBean, TRANSACAO_TITULO_DETALHE);
		DdaGeraisBean tituloBean = (DdaGeraisBean) ((BeanList) tituloBeanList
				.get(0)).get(0);
		BeanList descontoBeanList = (BeanList) tituloBeanList.get(1);
		List descontoList = convertDataStructure(descontoBeanList.iterator());
		request.getSession().setAttribute(BEAN_TITULO, tituloBean);
		request.getSession().setAttribute(BEAN_TITULO_DESCONTOS, descontoList);
		
		return PAGE_TITULODDA_DETALHE;
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

}
