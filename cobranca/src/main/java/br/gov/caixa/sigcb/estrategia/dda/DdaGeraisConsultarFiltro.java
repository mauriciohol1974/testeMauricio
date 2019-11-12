package br.gov.caixa.sigcb.estrategia.dda;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.WrappingException;
import br.gov.caixa.sigcb.bean.DdaGeraisBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.SigcbBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.ejb.session.MainframeException;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.SigcbException;

/**
 * Projeto: SIGCB Componente responsável pelo controle da funcionalidade
 * CONSULTAS GERAIS DO DDA Criada em: 01/10/2009
 *
 * @author Glauber Gallego - glauber.gallego@probank.com.br
 */
public class DdaGeraisConsultarFiltro extends DdaGeraisEstrategia {

	private static final String[] transacoes = new String[] {
			TRANSACAO_TITULOSENVIADOS_LISTAR,      // 0
			TRANSACAO_TITULOSPAGOS_LISTAR,         // 1
			TRANSACAO_ACEITEALEGACAO_LISTAR,       // 2
			TRANSACAO_TITULOSVENCIDOS_LISTAR,      // 3
			TRANSACAO_QUARENTENA_LISTAR,           // 4
			TRANSACAO_TITULOSSACADOEXCLUIDO_LISTAR // 5
	};

	private static final String[] paginas = new String[] {
			PAGE_TITULOSENVIADOS_LISTAR,      // 0
			PAGE_TITULOSPAGOS_LISTAR,         // 1
			PAGE_ACEITEALEGACAO_LISTAR,       // 2
			PAGE_TITULOSVENCIDOS_LISTAR,      // 3
			PAGE_QUARENTENA_LISTAR,           // 4
			PAGE_TITULOSSACADOEXCLUIDO_LISTAR // 5
	};

	private SigcbBean[] beans = null;

	public DdaGeraisConsultarFiltro() throws Exception {
		beans = new SigcbBean[] { new DdaGeraisBean().newBean(), // 0
				new DdaGeraisBean().newBean(), // 1
				new DdaGeraisBean().newBean(), // 2
				new DdaGeraisBean().newBean(), // 3
				new DdaGeraisBean().newBean(), // 4
				new DdaGeraisBean().newBean()  // 5
		};
	}

	public String processRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		this.configMsgSucessoErro(request);

		DdaGeraisBean ddaGeraisBean = new DdaGeraisBean();

		if (getFluxo(request).equals(FLUXO_NORMAL)) {
			ddaGeraisBean = (DdaGeraisBean) ddaGeraisBean
					.getRequestBean(request);
		} else {
			ddaGeraisBean = (DdaGeraisBean) ddaGeraisBean
					.getSessionBean(request, BEAN_FILTRO);
		}

		request.getSession().setAttribute(BEAN_FILTRO, ddaGeraisBean);
		request.getSession().setAttribute(BEAN_LISTAR, ddaGeraisBean);
		request.getSession().setAttribute(BEAN_TITULO, ddaGeraisBean);
		request.getSession().setAttribute(BEAN_TITULO_DESCONTOS, ddaGeraisBean);

		int opcao = ddaGeraisBean.getTipoConsulta().intValue();
		SigcbBean entradaBean = beans[opcao];
		String transacao = transacoes[opcao];
		entradaBean.copyBean(ddaGeraisBean);
		this.executaTransacao(request, entradaBean, transacao);

		return paginas[opcao];
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

		// if para tratar transacao BG9H (Aceite/alegacao) que nao trata tipo de
		// consulta
		if (respostaBean instanceof DdaGeraisBean) {
			DdaGeraisBean ddaGeraisBean = (DdaGeraisBean) respostaBean;
			if (ddaGeraisBean.getTipoConsulta() == null) {
				ddaGeraisBean.setTipoConsulta(2L);
			}
		}

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
