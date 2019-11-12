package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.Currency;
import br.com.politec.sao.util.Money;
import br.gov.caixa.sigcb.bean.CedBcoSBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.RelatorioBean;
import br.gov.caixa.sigcb.bean.TituloListarBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.Util;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade Consultas Gerais -
 * Cedente Centralizador
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/09/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 */

public class ConsRelGeraArqCedente extends ConsRelatorioEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configura��es para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);

        // Obtem informa��o para definir se o request veio de voltar ou se o
        // fluxo � normal
        String fluxo = getFluxo(request);

        // Recupera o bean
        RelatorioBean relAuditBean = new RelatorioBean();

        relAuditBean = (RelatorioBean) relAuditBean.getSessionBean(request, FILTRO_BEAN);


        request.getSession().setAttribute(FILTRO_BEAN,    relAuditBean);
        
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_LISTAR_CEDENTE + usuarioBean.getCodigoUsuario().toUpperCase();
        
        BeanList relAuditList = (BeanList)handler.executeSimpleTransactionQuery(relAuditBean, transUser);
       
        // converte a lista em um array de beans
        ArrayList relListaArrayListaBean = convertDataStructure(relAuditList.iterator());

        ServletOutputStream out = response.getOutputStream();
    	
    	response.setHeader("Content-Disposition","attachment;filename=RelBeneficiario.csv");
    	response.setContentType("application/x-download");		
    	response.setHeader ("Pragma", "public");
    	response.setHeader("Cache-control", "must-revalidate");
			
    	String linhas[] = new String[relListaArrayListaBean.size()];
    	
    	String cabecalho[] = new String[3];
    	
    	
    	for (int x=0;x<relListaArrayListaBean.size();x++){
    		RelatorioBean relatorioBean = (RelatorioBean) relListaArrayListaBean.get(x);
    		
    		linhas[x] = "'"+ (relatorioBean.getProduto().toString().equals("1") ? "SIMPLES" : "") +
    				(relatorioBean.getProduto().toString().equals("2") ? "SEM REGISTRO" : "")+
    				(relatorioBean.getProduto().toString().equals("3") ? "CAUCIONADA" : "")+
    				(relatorioBean.getProduto().toString().equals("4") ? "TERCEIROS" : "") + ";" +  relatorioBean.getQtdeLiq() + ";" + relatorioBean.getValorLiq() ;
    	}
    	
    
	    cabecalho[0] = "Consulta Relat�rio por Benefici�rio >> Lista "+ relAuditBean.getCedente().toString()+"\r\n";;
	    cabecalho[1] = "========================================================================================================================================" + "\r\n";
	    cabecalho[2] = "Produto;Quantidade;Valor;\r\n";
    	
	        out.write(cabecalho[0].getBytes());
	        out.write(cabecalho[1].getBytes());
	        out.write(cabecalho[2].getBytes());
	      
    	
			for (int i=0;i < linhas.length  ;i++){
				String linha = linhas[i] + "\r\n";
				out.write(linha.getBytes());
			}
			
			 
			
			out.flush();
			out.close();

        return null;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INICIAR_CEDENTE);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_LISTAR_CEDENTE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
