package br.gov.caixa.sigcb.estrategia.consulta;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.DdaTituloDiaBean;
import br.gov.caixa.sigcb.bean.FiltroPesquisa;
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
public class ConsultaLiqStrManterFiltroRecebidas extends ConsultaLiqStrManterEstrategia {

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
            
            FiltroPesquisa filtroPesquisa = new FiltroPesquisa();
            filtroPesquisa.setDataIni((String)request.getParameter("dataIniFiltro"));		
            filtroPesquisa.setDataFim((String)request.getParameter("dataFimFiltro"));
            filtroPesquisa.setCedente((String)request.getParameter("cedenteFiltro"));
            filtroPesquisa.setBanco((String)request.getParameter("bancoFiltro"));
            filtroPesquisa.setIspb((String) request.getParameter("ispbFiltro"));
            filtroPesquisa.setAgencia((String)request.getParameter("agenciaFiltro"));
            filtroPesquisa.setPagina((String)request.getParameter("paginaFiltro"));
            filtroPesquisa.setProcessar((String)request.getParameter("processarFiltro"));

            
            if (filtroPesquisa.getProcessar()==null){
            	filtroPesquisa.setProcessar("N");
            }
            
            if (filtroPesquisa.getProcessar().equalsIgnoreCase("S")){
            	
    		    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    	        Date dataINI = (java.util.Date)formatter.parse(filtroPesquisa.getDataIni());	    
    	        Date dataFIM = (java.util.Date)formatter.parse(filtroPesquisa.getDataFim());
            	
            	filtroBean.setDataPesq(dataINI);
            	filtroBean.setDataPesqFinal(dataFIM);
            	if (filtroPesquisa.getBanco().length()==0){
            		filtroPesquisa.setBanco("0");
            	}
            	filtroBean.setBancoOrigem(Long.valueOf(filtroPesquisa.getBanco()));
            	
            	if (filtroPesquisa.getIspb().length()==0){
            		filtroPesquisa.setIspb("0");
            	}
            	filtroBean.setISPBOrigem(Long.valueOf(filtroPesquisa.getIspb()));
            	
            	
            	if (filtroPesquisa.getCedente().length()==0){
            		filtroPesquisa.setCedente("0");
            	}
            	filtroBean.setCedenteOrigem(Long.valueOf(filtroPesquisa.getCedente()));
            	if (filtroPesquisa.getAgencia().length()==0){
            		filtroPesquisa.setAgencia("0");
            	}
            	filtroBean.setAgenciaOrigem(Long.valueOf(filtroPesquisa.getAgencia()));
            	if (filtroPesquisa.getPagina().length()==0){
            		filtroPesquisa.setPagina("1");
            	}
            	filtroBean.setPagina(Long.valueOf(filtroPesquisa.getPagina()));
            	paginaAtual = Integer.parseInt(filtroPesquisa.getPagina());
            	filtroBean.setPagina((long)paginaAtual);
            }
            
            
            // Chamada ao Mainframe
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_LISTAR_RECEBIDAS + usuarioBean.getCodigoUsuario().toUpperCase();
            List liqSTRList = (List) handler.executeFixDataRecordsetTransaction(filtroBean,  transUser);
          
            
            
            LiquidacoesSTRBean fixoBean = (LiquidacoesSTRBean) ((BeanList) liqSTRList.get(0)).get(0);
            
            BeanList liqSTR = (BeanList) liqSTRList.get(1);
            ArrayList titliqPagina = convertDataStructure(liqSTR.iterator());
            
            request.getSession().setAttribute(FILTRO_BEAN,fixoBean );
            
            request.getSession().setAttribute(PAGINACAO_LIST, getPageHolder(titliqPagina));
            request.setAttribute(PAGINACAO_PAGE, "0");
            
            request.setAttribute(PaginacaoTag.PAGINA_ATUAL, paginaAtual);
            request.setAttribute("PAGFILTRO", String.valueOf(paginaAtual));
            request.setAttribute(PaginacaoTag.PAGINA_TOTAL, (int) Math.ceil(fixoBean.getQtdeTitulos() / 20.0));


            // System.out.println("#$% fim " + this.getClass().getName());
        } catch (Exception ex) {
            // ex.printStackTrace();
            throw ex;
        }

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_LISTAR_RECEBIDAS;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INICIAR_RECEBIDAS);
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
