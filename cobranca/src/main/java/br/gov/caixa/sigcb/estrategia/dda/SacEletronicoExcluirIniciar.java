package br.gov.caixa.sigcb.estrategia.dda;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.SacEletronicoBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

/**
 * <B>Projeto: SIGCB - DDA </B><BR>
 * Componente respons�vel pelo controle da funcionalidade DDA >> Sacado Eletr�nico >> Incluir Agregado >>
 * 
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/09/2009</DD>
 * </DL>
 * 
 * @author Alexandre Lima - alexandre.lima@probank.com.br
 */
public class SacEletronicoExcluirIniciar extends SacEletronicoEstrategia {
	public String processRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//Configura��es para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
        // Obtem informa��o para definir se o request veio de voltar ou se o
        // fluxo � normal
        String fluxo = getFluxo(request);
        // Obtem o bean que representa a funcionalidade
        // Para funcionalidade Iniciar , deve-ser inicializar os atributos do
        // bean que aparecem na tela
        SacEletronicoBean sacBean = new SacEletronicoBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
        	sacBean = (SacEletronicoBean) sacBean.newBean();
        } else {
        	sacBean = (SacEletronicoBean) sacBean.getSessionBean(request, 
        			FILTRO_BEAN);
        }
        //Reter o bean antes de acessar o mainframe
        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(FILTRO_BEAN, sacBean);
        request.getSession().setAttribute(DATA_BEAN, sacBean);
        //Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_EXCLUIR_FILTRO;
	}
//	Configura��es para Mensagens e Telas de Erro e Sucesso
	protected void configMsgSucessoErro(HttpServletRequest request) {
	    MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
	    msgBean.setMsgError("");
	    msgBean.setMsgSucess("");
	    msgBean.setStrategyErrorReturn("");
	    msgBean.setStrategySucessReturn("");
	    msgBean.setTitlePage("");
	    request.getSession().setAttribute(MSG_BEAN, msgBean);
	}
}
