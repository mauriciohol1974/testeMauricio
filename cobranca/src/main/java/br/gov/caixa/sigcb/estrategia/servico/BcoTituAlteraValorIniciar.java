package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.Money;
import br.gov.caixa.sigcb.bean.ContaCreditoBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.TituloBean;
import br.gov.caixa.sigcb.bean.TituloListarBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.util.jsp.PaginacaoTag;

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

public class BcoTituAlteraValorIniciar extends BcoTituEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
        //MainFrameTransactionsSigcb handler = BcoTituEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        // Recupera/define informacoes do titulo
        TituloBean tituloBean = new TituloBean();
        
            // Obtem dados do request:
           
            tituloBean = (TituloBean) tituloBean.getRequestBean(request);
            tituloBean.setMeioEntrada(new Long(1));
            
            if (tituloBean.getCmbCarteira()==null){
            	tituloBean.setCmbCarteira("");
            }
            
            if (tituloBean.getCmbEmissao()==null){
            	tituloBean.setCmbEmissao("");
            }
            
            if (tituloBean.getNuBaixa()==null){
            	tituloBean.setNuBaixa(0L);
            }
            if (tituloBean.getNuRefereciaCIP()==null){
            	tituloBean.setNuRefereciaCIP(0L);
            }
            if (tituloBean.getNuIdentificaCIP()==null){
            	tituloBean.setNuIdentificaCIP(0L);
            }
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_DADOS_PRINCIPAIS + usuarioBean.getCodigoUsuario().toUpperCase();
            /* BG60 */BeanList tituloBeanList = (BeanList) handler.executeSimpleTransactionQuery(tituloBean, transUser);
            TituloBean newTituloBean = (TituloBean) tituloBeanList.get(0);
            
             transUser = TRANSACAO_DADOS_COMPLEMENTARES + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList tituloBeanComplementarList = (BeanList) handler.executeSimpleTransactionQuery(tituloBean,  transUser);
            TituloBean newComplementarTituloBean = (TituloBean) tituloBeanComplementarList.get(0);

            String dt = newTituloBean.getDtGarantia();
            String coUser = newTituloBean.getCoUsuario();
            String icGar = newTituloBean.getIcGarantia();
            String parcela = newTituloBean.getParcela();
            Long NN = newTituloBean.getNossoNumero();
            
            String icRegistroCIP  = newTituloBean.getIcRegistroCIP();
            Long nuIdentificaCIP = newTituloBean.getNuIdentificaCIP();
            Long nuRefereciaCIP= newTituloBean.getNuRefereciaCIP();
            String sgIndexador= newTituloBean.getSgIndexador();
            String icTipoPagamento= newTituloBean.getIcTipoPagamento();
            Money vrMaximoPgto= newTituloBean.getVrMaximoPgto();
            Money vrMinPgto= newTituloBean.getVrMinPgto();
            String icAutPagto= newTituloBean.getIcAutPagto();
            Long qtPgtoPossivel= newTituloBean.getQtPgtoPossivel();
            Long qtPgtoEfetuado= newTituloBean.getQtPgtoEfetuado();
			Money vrSaldoTitulo= newTituloBean.getVrSaldoTitulo();

            // Reseta informacoes do titulo
            copyTituloDadosFiltroToTitulo(tituloBean, newTituloBean);
            copyTituloDadosComplementaresToTitulo(newComplementarTituloBean, newTituloBean);
            copyTituloDadosLiquidacaoToTitulo(tituloBean, newTituloBean);
            copyTituloDadosEncargosAbatimentosToTitulo(tituloBean,newTituloBean);
            copyTituloDadosImpressaoBloquetoToTitulo(tituloBean, newTituloBean);
            newTituloBean.setDtGarantia(dt);
            newTituloBean.setCoUsuario(coUser);
            if (icGar.equals("S")){
            	icGar="SIM";
            }else{
            	icGar="NÃO";
            }
            newTituloBean.setIcGarantia(icGar);
            newTituloBean.setParcela(parcela);
            
            newTituloBean.setIcRegistroCIP(icRegistroCIP);
            newTituloBean.setNuIdentificaCIP(nuIdentificaCIP);
            newTituloBean.setNuRefereciaCIP(nuRefereciaCIP);
            newTituloBean.setSgIndexador(sgIndexador);
            newTituloBean.setIcTipoPagamento(icTipoPagamento);
            newTituloBean.setVrMaximoPgto(vrMaximoPgto);
            newTituloBean.setVrMinPgto(vrMinPgto);
            newTituloBean.setIcAutPagto(icAutPagto);
            newTituloBean.setQtPgtoPossivel(qtPgtoPossivel);
            newTituloBean.setQtPgtoEfetuado(qtPgtoEfetuado);
			newTituloBean.setVrSaldoTitulo(vrSaldoTitulo);
			newTituloBean.setNossoNumero(NN);
			
			
            
        

        // Recupera/define informacoes de cabecalho do cedente
        BcoTituEstrategia.setCedenteCabecaBean(newTituloBean, request);

        // Retem informacoes do bean depois do acesso ao mainframe
        request.getSession().setAttribute(DATA_BEAN, newTituloBean);

        return PAGE_ALTERAR_VALOR;

    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess(SUCESSO_ACAO);
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_FILTRO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}