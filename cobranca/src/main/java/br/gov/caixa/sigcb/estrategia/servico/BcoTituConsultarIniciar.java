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

public class BcoTituConsultarIniciar extends BcoTituEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
        
        
        
        // Recupera/define informacoes do titulo
        TituloBean tituloBean = new TituloBean();
        if (getFluxo(request).equals(FLUXO_NORMAL)) {
            // Obtem dados do request:
            TituloBean reqTituloBean = new TituloBean();
            reqTituloBean = (TituloBean) reqTituloBean.getRequestBean(request);
            reqTituloBean.setMeioEntrada(new Long(1));

            // Obtem dados:
            tituloBean = (TituloBean) tituloBean.getSessionBean(request, DATA_BEAN);
            copyTituloDadosFiltroToTitulo(reqTituloBean, tituloBean);
            
            TituloBean tituloBeanConsulta = new TituloBean();
            tituloBeanConsulta = (TituloBean) tituloBeanConsulta.getRequestBean(request);
            tituloBeanConsulta.setMeioEntrada(new Long(1));
            
            if (tituloBeanConsulta.getCmbCarteira()==null){
            	tituloBeanConsulta.setCmbCarteira("");
            }
            
            if (tituloBeanConsulta.getCmbEmissao()==null){
            	tituloBeanConsulta.setCmbEmissao("");
            }
            
            if (tituloBeanConsulta.getNuBaixa()==null){
            	tituloBeanConsulta.setNuBaixa(0L);
            }
            if (tituloBeanConsulta.getNuRefereciaCIP()==null){
            	tituloBeanConsulta.setNuRefereciaCIP(0L);
            }
            if (tituloBeanConsulta.getNuIdentificaCIP()==null){
            	tituloBeanConsulta.setNuIdentificaCIP(0L);
            }
            
            //MainFrameTransactionsSigcb handler = BcoTituEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_DADOS_PRINCIPAIS + usuarioBean.getCodigoUsuario().toUpperCase();
            
            /* BG60 */BeanList tituloBeanList = (BeanList) handler.executeSimpleTransactionQuery(tituloBeanConsulta, transUser);
            TituloBean dadosBean = (TituloBean) tituloBeanList.get(0);

            
            String dt = dadosBean.getDtGarantia();
            String coUser = dadosBean.getCoUsuario();
            String icGar = dadosBean.getIcGarantia();
            String parcela = dadosBean.getParcela();
            Long NN = dadosBean.getNossoNumero();
            
            String icRegistroCIP  = dadosBean.getIcRegistroCIP();
            Long nuIdentificaCIP = dadosBean.getNuIdentificaCIP();
            Long nuRefereciaCIP= dadosBean.getNuRefereciaCIP();
            String sgIndexador= dadosBean.getSgIndexador();
            String icTipoPagamento= dadosBean.getIcTipoPagamento();
            Money vrMaximoPgto= dadosBean.getVrMaximoPgto();
            Money vrMinPgto= dadosBean.getVrMinPgto();
            String icAutPagto= dadosBean.getIcAutPagto();
            Long qtPgtoPossivel= dadosBean.getQtPgtoPossivel();
            Long qtPgtoEfetuado= dadosBean.getQtPgtoEfetuado();
			Money vrSaldoTitulo= dadosBean.getVrSaldoTitulo();
			String coErroCIP = dadosBean.getCoErroCIP();
			String dtCompetencia = dadosBean.getDtCompetencia();
			String tpPessoaPrt = tituloBean.getTpPessoaPrt();
		    String cpfCnpjPrt = tituloBean.getCpfCnpjPrt();
            /*
            
            Caso seja necessário os apresentar os dados do Rateio
            if (tituloBean.getIcRateio().equalsIgnoreCase("S")){
            	// Carregar os dados de rateio
                MainFrameTransactionsSigcb handler = BcoTituEstrategia.lookUpMFHandler();
                ContaCreditoBean contaCredito = new ContaCreditoBean();
                contaCredito.setCedente(tituloBean.getCodigoCedente());
                contaCredito.setNossoNumero(tituloBean.getNossoNumero());
                
                List listaConta = (List) handler.executeFixDataRecordsetTransaction(contaCredito,"XXXX");
                
                // Obtem Parte Variavel (recordset)
                ArrayList listContaCredito = convertDataStructure(((BeanList) listaConta.get(1)).iterator());

                request.getSession().setAttribute(PAGINACAO_LIST, getPageHolder(listContaCredito));
                
            }
            */

            // Retem informacoes do bean antes do acesso ao mainframe
			tituloBean.setNossoNumero(NN);
            request.getSession().setAttribute(DATA_BEAN, tituloBean);

            // Obtem bean com informacoes da guia "Dados Principais (BG60)"
            // tituloBean = getTituloDadosPrincipais (request, response,
            // tituloBean);
            // Obtem bean com informacoes da guia "Dados Complementares (BG65)"
            tituloBean = getTituloDadosComplementares(request,  response,  tituloBean);
            // Obtem bean com informacoes da guia "Dados Liquidacao (BG61)"
            tituloBean = getTituloDadosLiquidacao(request, response, tituloBean);
            // Obtem bean com informacoes da guia "Dados Encargos Abatimentos
            // (BG66)"
            // tituloBean = getTituloDadosEncargosAbatimentos(request, response,
            // tituloBean);
            
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
            tituloBean.setCoErroCIP(coErroCIP);
            tituloBean.setDtCompetencia(dtCompetencia);
            tituloBean.setTpPessoaPrt(tpPessoaPrt);
            tituloBean.setCpfCnpjPrt(cpfCnpjPrt);
			

        } else {
            tituloBean = (TituloBean) tituloBean.getSessionBean(request,
                    DATA_BEAN);
        }

        // Recupera/define informacoes de cabecalho do cedente
        BcoTituEstrategia.setCedenteCabecaBean(tituloBean, request);

        // Retem informacoes do bean depois do acesso ao mainframe
        request.getSession().setAttribute(DATA_BEAN, tituloBean);

        return PAGE_CONSULTAR;

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