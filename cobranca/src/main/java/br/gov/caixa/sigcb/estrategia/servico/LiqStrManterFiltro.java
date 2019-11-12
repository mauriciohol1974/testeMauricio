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
public class LiqStrManterFiltro extends LiqStrManterEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
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

            // Reter o bean antes de acessar o mainframe
            // para gerar informacoes para tela de erro
            request.getSession().setAttribute(FILTRO_BEAN, filtroBean);

            int paginaAtual = 1;
            try {
                paginaAtual = Integer.parseInt(request.getParameter("pagina"));
            } catch (Exception e) {
            }
  
            filtroBean.setPagina((long)paginaAtual);
            
            String bancoFiltro = filtroBean.getBancoOrigem().toString();
            String ISPBFiltro = filtroBean.getISPBOrigem().toString();
            String agenciaFiltro = filtroBean.getAgenciaOrigem().toString();
            
            if ((String)request.getParameter("bancoFiltro")!= null){
            	bancoFiltro = (String)request.getParameter("bancoFiltro");
            	if (bancoFiltro.equalsIgnoreCase("null")){
            		bancoFiltro = "0";
            		filtroBean.setBancoOrigem(0L);		
            	}else{
            		filtroBean.setBancoOrigem(Long.valueOf(bancoFiltro));
            	}
            }
            if ((String)request.getParameter("ISPBFiltro")!= null){
            	ISPBFiltro = (String)request.getParameter("ISPBFiltro");
            	if (ISPBFiltro.equalsIgnoreCase("null")){
            		ISPBFiltro = "0";
            		filtroBean.setISPBOrigem(0L);
            	}else{
            		filtroBean.setISPBOrigem(Long.valueOf(ISPBFiltro));
            	}
            }
            if ((String)request.getParameter("agenciaFiltro")!= null){
            	agenciaFiltro = (String)request.getParameter("agenciaFiltro");
            	if (agenciaFiltro.equalsIgnoreCase("null")){
            		agenciaFiltro = "0";
            		filtroBean.setAgenciaOrigem(0L);
            	}else{
            		filtroBean.setAgenciaOrigem(Long.valueOf(agenciaFiltro));
            	}
            }
            
            
            bancoFiltro = filtroBean.getBancoOrigem().toString();
            ISPBFiltro = filtroBean.getISPBOrigem().toString();
            agenciaFiltro = filtroBean.getAgenciaOrigem().toString();
            
            // Chamada ao Mainframe
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();// Instancia
                                                                                    // o
                                                                                    // EJB
                                                                                    // que
                                                                                    // acessa
                                                                                    // o
                                                                                    // mainframe
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            //BeanList liqSTRBeanList = handler.executeSimpleTransactionQuery(filtroBean, filtroBean); // Chama a Transacao
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_LISTAR + usuarioBean.getCodigoUsuario().toUpperCase();
            List liqSTRList = (List) handler.executeFixDataRecordsetTransaction(filtroBean,  transUser);
          
            
            
            LiquidacoesSTRBean fixoBean = (LiquidacoesSTRBean) ((BeanList) liqSTRList.get(0)).get(0);
            
            BeanList liqSTR = (BeanList) liqSTRList.get(1);
            ArrayList titliqPagina = convertDataStructure(liqSTR.iterator());
            
            request.getSession().setAttribute(FILTRO_BEAN,fixoBean );
            
            request.setAttribute("bancoFiltro", bancoFiltro);
            request.setAttribute("ISPBFiltro", ISPBFiltro);
            request.setAttribute("agenciaFiltro", agenciaFiltro);
            
            request.getSession().setAttribute(PAGINACAO_LIST, getPageHolder(titliqPagina));
            request.setAttribute(PAGINACAO_PAGE, "0");
            request.setAttribute("pagina", String.valueOf(paginaAtual));
            request.setAttribute(PaginacaoTag.PAGINA_TOTAL, (int) Math.ceil(fixoBean.getQtdeTitulos() / 20.0));


            // System.out.println("#$% fim " + this.getClass().getName());
        } catch (Exception ex) {
            // ex.printStackTrace();
            throw ex;
        }

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_LISTAR;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INICIAR);
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
