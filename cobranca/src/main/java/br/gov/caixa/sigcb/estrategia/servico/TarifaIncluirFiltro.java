package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.TarifaManualBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Tarifa Manual >>
 * Incluir >> Filtro.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>12/10/2004</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 * @author Cristian Souza - Probank/REDEASP02
 */
public class TarifaIncluirFiltro extends TarifaEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);

        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);

        // Obtem o bean da funcionalidade
        TarifaManualBean tarifaBean = new TarifaManualBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
            tarifaBean = (TarifaManualBean) tarifaBean.getRequestBean(request);
        } else {
            tarifaBean = (TarifaManualBean) tarifaBean.getSessionBean(request,
                    DATA_BEAN);
        }

        // Cria objeto cabecalho_cedente
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();

        // Retem o bean antes de acessar o mainframe
        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(FILTRO_BEAN, tarifaBean);
        request.getSession().setAttribute(DATA_BEAN, tarifaBean);
        request.getSession().setAttribute(CEDENTE_ATUAL,
                tarifaBean.getCodigoCedente());
        
        //      Instancia o EJB que acessa o mainframe
       // MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        // Chamada ao Mainframe para cabecalho cedente
        if (fluxo.equals(FLUXO_NORMAL)) {
            // Definindo atributos para executar a transação BGM0 para obter o
            // cabeçalho
            cedCabBean.setTipoConsulta(new Long(1));
            cedCabBean.setOrigemConsulta(new Long(1));
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                    .getAttribute(USUARIOLDAP_BEAN);
            cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
            cedCabBean.setCodigoCedente(tarifaBean.getCodigoCedente());
            handler = new MainFrameTransactionsSigcbEjb();
           // handler = SigcbEstrategia.lookUpMFHandler();
             usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CEDENTE_CABECALHO + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
            		transUser);

            cedCabBean = (CedenteCabecaBean) cedCabBeanList.get(0);
        } else {
            cedCabBean = (CedenteCabecaBean) cedCabBean.getSessionBean(request,
                    CEDENTE_CABECALHO_BEAN);
        }
        
        //  Faz chamada da transação de consulta BG94
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CONSULTAR + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList tarifaManualListBean = handler.executeSimpleTransactionQuery(tarifaBean,
        		transUser);

        TarifaManualBean tarifaBeanRetorno = (TarifaManualBean) tarifaManualListBean.get(0);
        tarifaBean.setValorTarifa(tarifaBeanRetorno.getValorTarifa());

        // Reter os dados depois da chamada ao mainframe
        // para gerar informacoes para tela de sucesso
        request.getSession().setAttribute(FILTRO_BEAN, tarifaBean);
        request.getSession().setAttribute(DATA_BEAN, tarifaBean);
        request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, cedCabBean);
        request.getSession().setAttribute(CEDENTE_ATUAL,
                tarifaBean.getCodigoCedente());

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_INCLUIR;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INCLUIR_FILTRO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_INCLUIR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}