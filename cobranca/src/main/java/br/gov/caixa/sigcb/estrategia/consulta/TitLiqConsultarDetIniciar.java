package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.ConGerTitulosLiquidadosBean;
import br.gov.caixa.sigcb.bean.ConGerTitulosLiquidadosDiaBean;
import br.gov.caixa.sigcb.bean.ContaCreditoBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.estrategia.servico.BcoTituEstrategia;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;
import br.gov.caixa.sigcb.util.jsp.PaginacaoTag;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade consultas gerais -
 * Consulta detalhada de títulos liquidados
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>08/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class TitLiqConsultarDetIniciar extends TitLiqManterEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        try {
            configMsgSucessoErro(request);

            String fluxo = getFluxo(request);

            ConGerTitulosLiquidadosDiaBean filtroBean = new ConGerTitulosLiquidadosDiaBean();
            ConGerTitulosLiquidadosBean titliqBean = new ConGerTitulosLiquidadosBean();

            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            if (fluxo.equals(FLUXO_NORMAL)) {
                filtroBean = (ConGerTitulosLiquidadosDiaBean) filtroBean.getRequestBean(request);
                // EAM - 23/08
                PilhaVoltarControle.push(request, filtroBean);
            } else {
                filtroBean = (ConGerTitulosLiquidadosDiaBean) filtroBean.getSessionBean(request,
                        FILTRO_BEAN);
            }

            //titliqBean.setTipoConsulta(new Long(1));
            titliqBean.setTipoConsulta(filtroBean.getTipoConsulta());
            titliqBean.setCodigoCedente(filtroBean.getCodigoCedente());
            titliqBean.setNossoNumero(filtroBean.getNossoNumero());
            titliqBean.setDataPagamento(filtroBean.getDataPagamentoLista());
            titliqBean.setSequencialDia(filtroBean.getSequencialDia());
            titliqBean.setPagina(filtroBean.getPagina());
            Long codCedenteFiltro = filtroBean.getCodigoCedente();
            Long nossoNumeroFiltro = filtroBean.getNossoNumero();

            BeanList titBeanList = handler.executeSimpleTransactionQuery(titliqBean, TRANS_CONSULTAR_DETALHES);
            ConGerTitulosLiquidadosBean bean = (ConGerTitulosLiquidadosBean) titBeanList.get(0);
           
            bean.setDataPagamento(titliqBean.getDataPagamento());
            
            
            ///Colar aqui
            //bean.setIcRateio("S");
            
            if (bean.getIcRateio().equalsIgnoreCase("S")){
            	// Carregar os dados de rateio
            	
               
                ContaCreditoBean contaCredito = new ContaCreditoBean();
                contaCredito.setCedente(codCedenteFiltro);
                contaCredito.setNossoNumero(nossoNumeroFiltro);
                List list = null;
    		  
    		    
                BeanList contaCreditoList = handler.executeSimpleTransactionQuery(contaCredito, "BGZP");
                ArrayList contaCreditoArrayList = convertDataStructure(contaCreditoList.iterator());
                
    	        request.getSession().setAttribute("listaContaCredito", contaCreditoArrayList);
    	
                
            }else{
            	request.getSession().removeAttribute("listaContaCredito");
            }

            request.getSession().setAttribute(TITLIQ_BEAN, bean);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return PAGE_LIQ_CONSULTAR;
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
}
