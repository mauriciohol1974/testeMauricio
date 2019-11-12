package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.Money;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.TituloBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Banco de Títulos
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>17/09/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */

public class BcoTituAlterarValorFinalizar extends BcoTituEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	//MainFrameTransactionsSigcb handler = BcoTituEstrategia.lookUpMFHandler();
    	MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
        
        TituloBean reqTituloBean = new TituloBean();
        TituloBean tituloBean = new TituloBean();
        
        reqTituloBean = (TituloBean) reqTituloBean.getRequestBean(request);
        reqTituloBean.setMeioEntrada(new Long(1));

        // Obtem dados:
        tituloBean = (TituloBean) tituloBean.getSessionBean(request, DATA_BEAN);
        
        String dt = tituloBean.getDtGarantia();
        String coUser = tituloBean.getCoUsuario();
        String icGar = tituloBean.getIcGarantia();
        String parcela = tituloBean.getParcela();
        Long NN = tituloBean.getNossoNumero();
        
        String icRegistroCIP  = tituloBean.getIcRegistroCIP();
        Long nuIdentificaCIP = tituloBean.getNuIdentificaCIP();
        Long nuRefereciaCIP= tituloBean.getNuRefereciaCIP();
        String sgIndexador= tituloBean.getSgIndexador();
        String icTipoPagamento= tituloBean.getIcTipoPagamento();
        Money vrMaximoPgto= tituloBean.getVrMaximoPgto();
        Money vrMinPgto= tituloBean.getVrMinPgto();
        String icAutPagto= tituloBean.getIcAutPagto();
        Long qtPgtoPossivel= tituloBean.getQtPgtoPossivel();
        Long qtPgtoEfetuado= tituloBean.getQtPgtoEfetuado();
		Money vrSaldoTitulo= tituloBean.getVrSaldoTitulo();
		  InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
          String transUser = TRANSACAO_DADOS_COMPLEMENTARES + usuarioBean.getCodigoUsuario().toUpperCase();
        
		BeanList tituloBeanComplementarList = (BeanList) handler.executeSimpleTransactionQuery(tituloBean,  transUser);
        TituloBean newComplementarTituloBean = (TituloBean) tituloBeanComplementarList.get(0);
         
        copyTituloDadosFiltroToTitulo(reqTituloBean, tituloBean);
        copyTituloDadosComplementaresToTitulo(newComplementarTituloBean, tituloBean);
        
        tituloBean.setDtGarantia(dt);
        tituloBean.setCoUsuario(coUser);
        if (icGar.equals("S")){
        	icGar="SIM";
        }else{
        	icGar="NÃO";
        }
        tituloBean.setIcGarantia(icGar);
        tituloBean.setParcela(parcela);
        
        tituloBean.setIcRegistroCIP(icRegistroCIP);
        tituloBean.setNuIdentificaCIP(nuIdentificaCIP);
        tituloBean.setNuRefereciaCIP(nuRefereciaCIP);
        tituloBean.setSgIndexador(sgIndexador);
        tituloBean.setIcTipoPagamento(icTipoPagamento);
        tituloBean.setVrMaximoPgto(vrMaximoPgto);
        tituloBean.setVrMinPgto(vrMinPgto);
        tituloBean.setIcAutPagto(icAutPagto);
        tituloBean.setQtPgtoPossivel(qtPgtoPossivel);
        tituloBean.setQtPgtoEfetuado(qtPgtoEfetuado);
		tituloBean.setVrSaldoTitulo(vrSaldoTitulo);
		tituloBean.setNossoNumero(NN);
		
        tituloBean.setPrinciDataVencimento(reqTituloBean.getPrinciDataVencimento());
        tituloBean.setPrinciValorTitulo(reqTituloBean.getPrinciValorTitulo());
        // Retem informacoes do bean antes do acesso ao mainframe
        request.getSession().setAttribute(DATA_BEAN, tituloBean);

        // Recupera/define informacoes de cabecalho do cedente
        BcoTituEstrategia.setCedenteCabecaBean(tituloBean, request);

        // Executa transacao
        if (tituloBean.getIcAutPagto().trim().length()==0){
        	tituloBean.setIcAutPagto("S");
        }
        
        if (tituloBean.getIcTipoPagamento()==null || tituloBean.getIcTipoPagamento().trim().length()==0 ){
        	tituloBean.setIcTipoPagamento("3");
        }
         usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN);
        tituloBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
        tituloBean.setComunicacaoSacado("N");
        tituloBean.setCobrarTarifa("N");
         transUser = TRANSACAO_ALTERAR + usuarioBean.getCodigoUsuario().toUpperCase();
        handler.executeSimpleTransactionVoid(tituloBean, transUser);

        return PAGE_SUCESSO;

    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess(SUCESSO_ALTERAR);
        msgBean.setStrategyErrorReturn(STRATEGY_ALTERAR_VALOR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}