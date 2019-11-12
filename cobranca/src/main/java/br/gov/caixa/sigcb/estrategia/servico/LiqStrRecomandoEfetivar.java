package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.DdaTituloDiaBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.LiquidacoesRejeitadaBean;
import br.gov.caixa.sigcb.bean.LiquidacoesSTRBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.Formatador;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.jsp.ComboTipoMeioLiquidacao;
import br.gov.caixa.sigcb.util.jsp.PaginacaoTag;


/**
 * <B>Projeto: SIGCB</B><BR>
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>Abril/2013</DD>
 * </DL>
 * 
 * @author Maurício Assis de Holanda
 */

public class LiqStrRecomandoEfetivar extends LiqStrManterEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	LiquidacoesSTRBean filtroBeanEnviado = new LiquidacoesSTRBean();
        try {
            // System.out.println("#$% comeco " + this.getClass().getName());

            // Configurações para Mensagens e Telas de Erro e Sucesso
            configMsgSucessoErro(request);
            // Obtem informação para definir se o request veio de voltar ou se o
            // fluxo é normal
            String fluxo = getFluxo(request);
            // Obtem o bean da funcionalidade
            LiquidacoesSTRBean filtroBean = new LiquidacoesSTRBean();
            
            if (fluxo.equals(FLUXO_NORMAL)) {
                filtroBean = (LiquidacoesSTRBean) filtroBean.getRequestBean(request);
            } else {
                filtroBean = (LiquidacoesSTRBean) filtroBean.getSessionBean(request, FILTRO_BEAN);
            }

            if (filtroBean.getNossoNumeroCorrigido().trim().length()==0){
            	filtroBean.setNossoNumeroCorrigido("0");
            }
            if (filtroBean.getCedenteCorrigido().trim().length()==0){
            	filtroBean.setCedenteCorrigido("0");
            }
            if (filtroBean.getCodDevolucao().trim().length()==0){
            	filtroBean.setCodDevolucao("0");
            }
            filtroBean.setNnEnvio(Long.valueOf(filtroBean.getNossoNumeroCorrigido()));
            filtroBean.setCedenteCorrigido(Formatador.formatarCodigoCedente(Long.valueOf(filtroBean.getCedenteCorrigido())));
            filtroBean.setCodDevolucaoEnvio(Long.valueOf(filtroBean.getCodDevolucao()));
            
            request.getSession().setAttribute(FILTRO_BEAN,filtroBean );
            request.getSession().setAttribute(DATA_BEAN,filtroBean );
            
            String bancoFiltro = (String)request.getParameter("bancoFiltro");
            String ISPBFiltro = (String)request.getParameter("ISPBFiltro");
            String agenciaFiltro = (String)request.getParameter("agenciaFiltro");
            
            request.setAttribute("bancoFiltro", bancoFiltro);
            request.setAttribute("ISPBFiltro", ISPBFiltro);
            request.setAttribute("agenciaFiltro", agenciaFiltro);
            
            // Chamada ao Mainframe
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();// Instancia
                                                                                    // o
                                                                                    // EJB
                                                                                    // que
                                                                                    // acessa
                                                                                    // o
                                                                                    // mainframe
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            BeanList fixoBeanList;
            
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_EXECUTAR_ACAO + usuarioBean.getCodigoUsuario().toUpperCase();
            fixoBeanList = handler.executeSimpleTransactionQuery(filtroBean,  transUser);
            
            filtroBean = (LiquidacoesSTRBean) fixoBeanList.get(0);
            
            request.getSession().setAttribute(FILTRO_BEAN,filtroBean );
            request.getSession().setAttribute(DATA_BEAN,filtroBean );
            
        } catch (Exception ex) {
            // ex.printStackTrace();
        	
        	//filtroBeanEnviado.setCodDevolucao(String.valueOf(filtroBeanEnviado.getCodDevolucaoEnvio()));
        	//request.getSession().setAttribute(FILTRO_BEAN, filtroBeanEnviado);
            throw ex;
        }

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_SUCESSO;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_RECOMANDO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

    //
    // Metodo sobrescrito para setar atributo registro
    //
    public ArrayList convertDataStructure(Iterator iterator) {
        ArrayList list = new ArrayList();
        while (iterator.hasNext())
            list.add(iterator.next());
        return list;
    }
}
