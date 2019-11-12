package br.gov.caixa.sigcb.estrategia.dda;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.DdaReimpBloquetoBean;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;

/**
 * Projeto: SIGCB Componente responsável pelo controle da funcionalidade
 * REIMPRESSAO DE BLOQUETOS DDA Criada em: 15/01/2010
 * 
 * @author Glauber Gallego - glauber.gallego@probank.com.br
 */
public class DdaReimpBloquetoConsultarIniciar extends
		DdaReimpBloquetoEstrategia {

	public String processRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		configMsgSucessoErro(request);

		DdaReimpBloquetoBean ddaReimpBloquetoBean = new DdaReimpBloquetoBean();

		PilhaVoltarControle.init(request);

		if (getFluxo(request).equals(FLUXO_NORMAL)) {
			ddaReimpBloquetoBean = (DdaReimpBloquetoBean) ddaReimpBloquetoBean
					.newBean();
		} else {
			ddaReimpBloquetoBean = (DdaReimpBloquetoBean) ddaReimpBloquetoBean
					.getSessionBean(request, BEAN_FILTRO);
		}

		request.getSession().setAttribute(BEAN_FILTRO, ddaReimpBloquetoBean);
		request.getSession().setAttribute(BEAN_LISTAR, ddaReimpBloquetoBean);
		request.getSession().setAttribute(BEAN_TITULO, ddaReimpBloquetoBean);
		request.getSession().setAttribute(BEAN_TITULO_DESCONTOS, ddaReimpBloquetoBean);
		request.getSession().setAttribute(BEAN_TITULO_INSTRUCOES, ddaReimpBloquetoBean);

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
