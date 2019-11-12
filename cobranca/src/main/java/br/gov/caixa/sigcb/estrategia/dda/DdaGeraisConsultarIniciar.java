package br.gov.caixa.sigcb.estrategia.dda;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.DdaGeraisBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;

/**
 * Projeto: SIGCB
 * Componente responsável pelo controle da funcionalidade CONSULTAS GERAIS DO DDA
 * Criada em: 01/10/2009
 * @author Glauber Gallego - glauber.gallego@probank.com.br
 */
public class DdaGeraisConsultarIniciar extends DdaGeraisEstrategia {

	public String processRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		configMsgSucessoErro(request);

		DdaGeraisBean ddaGeraisBean = new DdaGeraisBean();

		PilhaVoltarControle.init(request);

		if (getFluxo(request).equals(FLUXO_NORMAL)) {
			ddaGeraisBean = (DdaGeraisBean) ddaGeraisBean
					.newBean();
		} else {
			ddaGeraisBean = (DdaGeraisBean) ddaGeraisBean
					.getSessionBean(request, BEAN_FILTRO);
		}

		request.getSession().setAttribute(BEAN_FILTRO, ddaGeraisBean);
		request.getSession().setAttribute(BEAN_LISTAR, ddaGeraisBean);
		request.getSession().setAttribute(BEAN_TITULO, ddaGeraisBean);
		request.getSession().setAttribute(BEAN_TITULO_DESCONTOS, ddaGeraisBean);

		return PAGE_FILTRO;
	}

	// Configurações para Mensagens e Telas de Erro e Sucesso
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
