package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.util.Currency;
import br.com.politec.sao.util.Money;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.TituloBean;
import br.gov.caixa.sigcb.util.Util;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Banco de Títulos
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>21/09/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */

public class BcoTituAlterarIniciar extends BcoTituEstrategia {

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

            // Obtem dados :
            tituloBean = (TituloBean) tituloBean.getSessionBean(request,   DATA_BEAN);
            
            String dt = tituloBean.getDtGarantia();
            String coUser = tituloBean.getCoUsuario();
            String icGar = tituloBean.getIcGarantia();
            String parcela = tituloBean.getParcela();
            String tpPessoaPrt = tituloBean.getTpPessoaPrt();
            String cpfCnpjPrt = tituloBean.getCpfCnpjPrt();
            
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
    		String coErroCIP = tituloBean.getCoErroCIP();
    		String dtCompetencia = tituloBean.getDtCompetencia();
            
            copyTituloDadosFiltroToTitulo(reqTituloBean, tituloBean);

            // Retem informacoes do bean antes do acesso ao mainframe
            request.getSession().setAttribute(DATA_BEAN, tituloBean);

            // Obtem bean com informacoes da guia "Dados Principais (BG60)"
            // tituloBean = getTituloDadosPrincipais (request, response,
            // tituloBean);
            // Obtem bean com informacoes da guia "Dados Complementares (BG65)"
            
       
            
            tituloBean = getTituloDadosComplementares(request,
                    response,
                    tituloBean);
            
            
            tituloBean.setDtGarantia(dt);
            tituloBean.setCoUsuario(coUser);
            if (icGar.equals("S") || icGar.equals("SIM")){
            	icGar="SIM";
            }else{
            	icGar="NÃO";
            }
            tituloBean.setIcGarantia(icGar);
            
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
            tituloBean.setParcela(parcela);
            tituloBean.setCoErroCIP(coErroCIP);
            tituloBean.setDtCompetencia(dtCompetencia);
            tituloBean.setTpPessoaPrt(tpPessoaPrt);
            tituloBean.setCpfCnpjPrt(cpfCnpjPrt);
            
            // Obtem bean com informacoes da guia "Dados Liquidacao (BG61)"
            // tituloBean = getTituloDadosLiquidacao(request, response,
            // tituloBean);
            // Obtem bean com informacoes da guia "Dados Encargos Abatimentos
            // (BG66)"
            // tituloBean = getTituloDadosEncargosAbatimentos(request, response,
            // tituloBean);

        } else {
            tituloBean = (TituloBean) tituloBean.getSessionBean(request,  DATA_BEAN);
            
            
            tituloBean = getTituloDadosPrincipais(request, response, tituloBean);
    		
    		
        }

        // Recupera/define informacoes de cabecalho do cedente
        BcoTituEstrategia.setCedenteCabecaBean(tituloBean, request);
        if (tituloBean.getValorJuros()==null){
        	Money valorJuros = new Money(Util.zerosEsquerda(new Long(0), 15), 2, Currency.real());
        	tituloBean.setValorJuros(valorJuros);
        }

        // Retem informacoes do bean depois do acesso ao mainframe
        request.getSession().setAttribute(DATA_BEAN, tituloBean);

        return PAGE_ALTERAR;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess(SUCESSO_ACAO);
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_FILTRO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_ALTERAR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
