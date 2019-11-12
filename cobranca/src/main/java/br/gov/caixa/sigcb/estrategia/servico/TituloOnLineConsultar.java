package br.gov.caixa.sigcb.estrategia.servico;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.Currency;
import br.com.politec.sao.util.Money;
import br.gov.caixa.sigcb.bean.BorderoBean;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.LiquidacaoOnlineBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.TarifaManualBean;
import br.gov.caixa.sigcb.bean.TituloBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.Util;


/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade Bordero >> Incluir >>
 * Iniciar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>01/09/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 */
public class TituloOnLineConsultar extends TituloOnLineEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

    	
    	configMsgSucessoErro(request);

        // Recupera/define informacoes do titulo
    	
    	
    	 String fluxo = getFluxo(request);
         
         LiquidacaoOnlineBean liquidacaoBean = new LiquidacaoOnlineBean();
         if (fluxo.equals(FLUXO_NORMAL)) {
         	liquidacaoBean = (LiquidacaoOnlineBean) liquidacaoBean.newBean();
        	liquidacaoBean = (LiquidacaoOnlineBean) liquidacaoBean.getRequestBean(request);
         } else {
             // eh preciso forcar os zeros.
         	liquidacaoBean = (LiquidacaoOnlineBean) liquidacaoBean.getSessionBean(request,  FILTRO_BEAN);
         }        
    	
        LiquidacaoOnlineBean liquidacao = new LiquidacaoOnlineBean();
        
        String codCedente = (String) request.getParameter("codigoCedente");
        String meioPgto= (String) request.getParameter("meioPgto");
        String vrPagamento= (String) request.getParameter("vrPagamento");
        String nossoNumero= (String) request.getParameter("nossoNumero");
        String dataPagto= (String) request.getParameter("dataPagamento");
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date datePagto = (Date)formatter.parse(dataPagto);
        
        vrPagamento = vrPagamento.replace("R$", "");
        vrPagamento = vrPagamento.replace(" ", "");
        vrPagamento = vrPagamento.replace(".", "");
        vrPagamento = vrPagamento.replace(",", ".");
        
        double valor = Double.parseDouble(vrPagamento);
        
        valor = valor * 100;
        
        long vrPgto = (long) valor;
        
        Money mnvalorTitulo = new Money(Util.zerosEsquerda(vrPgto, 15), 2, Currency.real());
        
        liquidacao.setCodigoCedente(Long.valueOf(codCedente));
        liquidacao.setMeioEntrada(meioPgto);
        liquidacao.setCodMeioEntrada(meioPgto);
        liquidacao.setVrPagamento(mnvalorTitulo);
        liquidacao.setLiquiValorDocumento(mnvalorTitulo);
        liquidacao.setNossoNumero(Long.valueOf(nossoNumero));
        liquidacao.setNossoNumeroLiq(Long.valueOf(nossoNumero));
        liquidacao.setDataPagamento(datePagto);
        liquidacao.setLiquiDataPagamento(datePagto);
        
        TituloBean tituloBean = new TituloBean();
       
        tituloBean.setCodigoCedente(liquidacao.getCodigoCedente());
        tituloBean.setNossoNumeroLiq(liquidacao.getNossoNumeroLiq());
        tituloBean.setLiquiDataPagamento(liquidacao.getDataPagamento());
        tituloBean.setLiquiValorDocumento(liquidacao.getLiquiValorDocumento());
        tituloBean.setMeio(Long.valueOf(liquidacao.getCodMeioEntrada()));
        
        
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CONSULTAR + usuarioBean.getCodigoUsuario().toUpperCase();
        
        BeanList tituloListBean = handler.executeSimpleTransactionQuery(tituloBean, transUser);

        TituloBean tituloBeanRetornado = (TituloBean) tituloListBean.get(0);
        
        tituloBeanRetornado.setCodigoCedente(tituloBean.getCodigoCedente());
        tituloBeanRetornado.setNossoNumeroLiq(tituloBean.getNossoNumeroLiq());
        tituloBeanRetornado.setLiquiDataPagamento(tituloBean.getLiquiDataPagamento());
        tituloBeanRetornado.setLiquiValorLiquidoRecebido(tituloBean.getLiquiValorDocumento());
        tituloBeanRetornado.setMeio(tituloBean.getMeio());
        
        
        request.getSession().setAttribute(DATA_BEAN, tituloBeanRetornado);
        //request.getSession().setAttribute(FILTRO_BEAN, liquidacaoBean);
        
    return PAGE_MANTER_CONSULTAR;
}

    // Configura��es para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_LISTAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_MANTER_FILTRO);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
