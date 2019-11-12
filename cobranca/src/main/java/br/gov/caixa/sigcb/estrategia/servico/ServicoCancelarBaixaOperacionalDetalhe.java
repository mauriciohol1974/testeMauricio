package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.WrappingException;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MenuBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.SegundaViaExtratoBean;
import br.gov.caixa.sigcb.bean.ServicoBaixaBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.Formatador;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultar Bloqueto
 * On-line
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>20/10/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class ServicoCancelarBaixaOperacionalDetalhe extends ServicoCancelarBaixaOperacionalEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);
        String fluxo = getFluxo(request);
        ServicoBaixaBean servicoBaixa = new ServicoBaixaBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
        	servicoBaixa = (ServicoBaixaBean) servicoBaixa.getSessionBean(request,  DATA_BEAN);
        } else {
        	servicoBaixa = (ServicoBaixaBean) servicoBaixa.getRequestBean(request);
        }
        servicoBaixa.setPasso(2L);
        
        
        request.getSession().setAttribute(FILTRO_BEAN, servicoBaixa);
       
        // Chamada ao Mainframe
       // MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        BeanList servicoBaixaBeanList;
        
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CONSULTAR + usuarioBean.getCodigoUsuario().toUpperCase();
        
        servicoBaixaBeanList = handler.executeSimpleTransactionQuery(servicoBaixa, transUser);
        
        ServicoBaixaBean servicoBaixaRet = new ServicoBaixaBean();
        
        servicoBaixaRet = (ServicoBaixaBean) servicoBaixaBeanList.get(0);
        
        request.getSession().setAttribute(DATA_BEAN, servicoBaixaRet);
        
        return PAGE_SUCESSO;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_LISTAR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}