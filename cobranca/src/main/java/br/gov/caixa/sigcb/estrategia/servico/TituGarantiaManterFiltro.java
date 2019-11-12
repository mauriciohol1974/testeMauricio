package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.PageHolder;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.ClienteSINCEBean;
import br.gov.caixa.sigcb.bean.ContaCreditoBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.TituloBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.jsp.PaginacaoTag;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Banco de Títulos
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>30/08/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */

public class TituGarantiaManterFiltro extends TituGarantiaEstrategia {

    public String processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);

        // Define informacoes de acesso a proxima pagina.
        String pagina = PAGE_ERRO;

        // Recupera/define informacoes do titulo
        TituloBean tituloBean = new TituloBean();
        pagina = paginaPorSituacao(request, response, tituloBean);

        // EAM - SISOT 51H - Incluir o campo PV de Vinculação no cabeçalho
        setDadosPvVinculacao(request, tituloBean);

        // Recupera/define informacoes de cabecalho do cedente
        BcoTituEstrategia.setCedenteCabecaBean(tituloBean, request);

        return pagina;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

   

    private String paginaPorSituacao(HttpServletRequest request,
            HttpServletResponse response,
            TituloBean tituloBean) throws Exception {
        // Obtem bean com informacoes para lista consolidada.
    	
    	String nossoNumero = (String) request.getParameter("nossoNumero");
    	String nossoNumeroFim = (String) request.getParameter("nossoNumeroFim");
    	if (!nossoNumero.equalsIgnoreCase("")){
    		Long nossoNumeroLng = Long.valueOf(nossoNumero);
    		tituloBean.setNossoNumero(nossoNumeroLng);
    	}
    	if (!nossoNumeroFim.equalsIgnoreCase("")){
    		Long nossoNumeroFimLng = Long.valueOf(nossoNumeroFim);
    		tituloBean.setNossoNumeroFim(nossoNumeroFimLng);
    	}
    	
        ArrayList tituloList = (ArrayList) getTituloListarTitulo(request, response, tituloBean);

        // Retem informacoes do bean depois do acesso ao mainframe
        request.getSession().setAttribute(DATA_FIXO_LIST, tituloList.get(0));
        request.getSession().setAttribute(DATA_FIXO_LIST, tituloList.get(0));
        request.getSession().setAttribute(PAGINACAO_LIST, getPageHolder((List) tituloList.get(1)));
        request.setAttribute(PAGINACAO_PAGE, "0");

        return PAGE_FILTRO_LISTAR_TITULO;
    }

   

    // EAM - SISOT 51H - Incluir o campo PV de Vinculação no cabeçalho
    private void setDadosPvVinculacao(HttpServletRequest request,
            TituloBean tituloBean) throws Exception {
        CedenteGeralBean cedGeralBean = new CedenteGeralBean();
        cedGeralBean = (CedenteGeralBean) cedGeralBean.newBean();
        // Definindo atributos para executar a transação BG03 para obter
        // informações do cedente para setar campos
        cedGeralBean.setTipoConsulta("C");
        cedGeralBean.setCodigoCedente(tituloBean.getCodigoCedente());

        // Chamada ao Mainframe
       // MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        // Chama aS Transacões
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CEDENTE_GERAL + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList cedGeralBeanList = handler.executeSimpleTransactionQuery(cedGeralBean, transUser);
        CedenteGeralBean ceGeralBean = (CedenteGeralBean) cedGeralBeanList.get(0);
        request.getSession().setAttribute(CEDENTE_GERAL_BEAN, ceGeralBean);
    }

}