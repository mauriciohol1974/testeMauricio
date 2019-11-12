package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.BorderoBean;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.TarifaManualBean;
import br.gov.caixa.sigcb.bean.TituloBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.ejb.session.MainframeException;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.Util;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Bordero >> Incluir >>
 * Iniciar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>01/09/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class TituloOnLineIncluirExecutar extends TituloOnLineEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

    	
    	configMsgSucessoErro(request);

        // Recupera/define informacoes do titulo
        TituloBean tituloBean = new TituloBean();
        if (getFluxo(request).equals(FLUXO_NORMAL)) {
            // Obtem dados do request:
            TituloBean reqTituloBean = new TituloBean();
            reqTituloBean = (TituloBean) reqTituloBean.getRequestBean(request);
          

            // Obtem dados:
            tituloBean = (TituloBean) tituloBean.getRequestBean(request);

            // Recupera informacoes do usuario
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN);
            tituloBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());

            // Retem informacoes do bean antes do acesso ao mainframe
            request.getSession().setAttribute(DATA_BEAN, tituloBean);

        } else {
            tituloBean = (TituloBean) tituloBean.getSessionBean(request, DATA_BEAN);
        }
        
       
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        
        ArrayList listDescricoes = new ArrayList();

        listDescricoes.add("MOEDA INVALIDA");
        listDescricoes.add("DIVERGENCIA NO VALOR RECEBIDO");
        listDescricoes.add("RECEBIMENTO EFETUADO FORA DO PRAZO");
        listDescricoes.add("APRESENTACAO INDEVIDA");
        listDescricoes.add("REGISTRO INCONSITENTE");
        listDescricoes.add("DEVOLUCAO DE CHEQUE PELA COMPENSACAO");
        listDescricoes.add("DUPLICIDADE DE MOVIMENTO");
        listDescricoes.add("ERRO OPERACIONAL");
        listDescricoes.add("ESTORNO INDEVIDO");
        listDescricoes.add("OUTROS");

        int intMotivo = Integer.valueOf(tituloBean.getMotivo()) -1;
        
        tituloBean.setMotivo((String) listDescricoes.get(intMotivo));
        
        tituloBean.setTipoAcao("I");
        String observStr = tituloBean.getObservacoes().replace("\r\n", " ");
        observStr = observStr.replace("\n", " ");
        observStr = observStr.replace("\r", " ");
        tituloBean.setObservacoes(observStr);
      
        
        if (tituloBean.getCodBarras1().trim().length()==0){
        	tituloBean.setCodBarras1("0");
        }
        if (tituloBean.getCodBarras2().trim().length()==0){
        	tituloBean.setCodBarras2("0");
        }
        if (tituloBean.getCodBarras3().trim().length()==0){
        	tituloBean.setCodBarras3("0");
        }
        if (tituloBean.getCodBarras4().trim().length()==0){
        	tituloBean.setCodBarras4("0");
        }
        if (tituloBean.getCodBarras5().trim().length()==0){
        	tituloBean.setCodBarras5("0");
        }
        if (!isNumeric(tituloBean.getCodBarras1())){
        		throw new MainframeException(new Exception("Código de barras não numérico!"));
        }
        if (!isNumeric(tituloBean.getCodBarras2())){
        	throw new MainframeException(new Exception("Código de barras não numérico!"));
        }
        if (!isNumeric(tituloBean.getCodBarras3())){
        	throw new MainframeException(new Exception("Código de barras não numérico!"));
        }
        if (!isNumeric(tituloBean.getCodBarras4())){
        	throw new MainframeException(new Exception("Código de barras não numérico!"));
        }
        if (!isNumeric(tituloBean.getCodBarras5())){
        	throw new MainframeException(new Exception("Código de barras não numérico!"));
        }
        

        String codbarras1 = Util.zerosEsquerda(Long.valueOf(tituloBean.getCodBarras1()), 10);
        String codbarras2 = Util.zerosEsquerda(Long.valueOf(tituloBean.getCodBarras2()), 11);
        String codbarras3 = Util.zerosEsquerda(Long.valueOf(tituloBean.getCodBarras3()), 11);
        String codbarras4 = tituloBean.getCodBarras4();
        String codbarras5 = Util.zerosEsquerda(Long.valueOf(tituloBean.getCodBarras5()), 14);
        
        tituloBean.setCodBarras1(codbarras1);
        tituloBean.setCodBarras2(codbarras2);
        tituloBean.setCodBarras3(codbarras3);
        tituloBean.setCodBarras4(codbarras4);
        tituloBean.setCodBarras5(codbarras5);
        
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_INCLUIR_ACAO1 + usuarioBean.getCodigoUsuario().toUpperCase();
        
        
        BeanList tituloListBean = handler.executeSimpleTransactionQuery(tituloBean, transUser);

        TituloBean tituloBeanRetornado = (TituloBean) tituloListBean.get(0);
        tituloBean.setTipoAcao("N");
        
        tituloBean.setNossoNumeroLiq(tituloBeanRetornado.getNossoNumeroLiq());
        tituloBean.setCodBarras1(tituloBeanRetornado.getCodBarras1());
        tituloBean.setCodBarras2(tituloBeanRetornado.getCodBarras2());
        tituloBean.setCodBarras3(tituloBeanRetornado.getCodBarras3());
        tituloBean.setCodBarras4(tituloBeanRetornado.getCodBarras4());
        tituloBean.setCodBarras5(tituloBeanRetornado.getCodBarras5());
        tituloBean.setCodigoCedente(tituloBeanRetornado.getCodigoCedente());
        tituloBean.setPrinciDataVencimento(tituloBeanRetornado.getPrinciDataVencimento());
        tituloBean.setFatorVencimento(tituloBeanRetornado.getFatorVencimento());
        tituloBean.setLiquiValorDocumento(tituloBeanRetornado.getLiquiValorDocumento());
      
        request.getSession().setAttribute(DATA_BEAN, tituloBean);
       
        
    return PAGE_INCLUIR_CONFIRMA;
}

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_INCLUIR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
    
    
    public static boolean isNumeric (String s) {
        try {
            Long.parseLong (s); 
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
