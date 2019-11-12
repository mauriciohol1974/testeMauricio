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
public class LiqStrConsultar extends LiqStrManterEstrategia {

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

            String banco = filtroBean.getBanco();
            String dtRecebimento = filtroBean.getDataRecebimento();
            String hrRecebimento = filtroBean.getHoraRecebimento();
            String sequencial= filtroBean.getSequencial();
            Long bancoOrigem = filtroBean.getBancoOrigem();
            Long ISPBOrigem = filtroBean.getISPBOrigem();
            Long agenciaOrigem = filtroBean.getAgenciaOrigem();
            
            String bancoFiltro = (String)request.getParameter("bancoFiltro");
            String ISPBFiltro = (String)request.getParameter("ISPBFiltro");
            String agenciaFiltro = (String)request.getParameter("agenciaFiltro");
            
            request.setAttribute("bancoFiltro", bancoFiltro);
            request.setAttribute("ISPBFiltro", ISPBFiltro);
            request.setAttribute("agenciaFiltro", agenciaFiltro);
            
            // Reter o bean antes de acessar o mainframe
            // para gerar informacoes para tela de erro
            String pagina = String.valueOf(filtroBean.getPagina());
            // Chamada ao Mainframe
            String acaoExecutar = filtroBean.getAcaoExecutar();
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();// Instancia
                                                                                    // o
                                                                                    // EJB
                                                                                    // que
                                                                                    // acessa
                                                                                    // o
                                                                                    // mainframe
            
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            BeanList fixoBeanList;
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CONSULTAR + usuarioBean.getCodigoUsuario().toUpperCase();
            fixoBeanList = handler.executeSimpleTransactionQuery(filtroBean,  transUser);
            
            filtroBean = (LiquidacoesSTRBean) fixoBeanList.get(0);
            
            filtroBean.setAcaoExecutar(acaoExecutar);
            /*
            filtroBean.setAgencia("0312");
            filtroBean.setAgenciaOrigem(312L);
            filtroBean.setBanco("104");
            filtroBean.setBancoOrigem(104L);
            filtroBean.setCdSituacaoAnterior("01");
            filtroBean.setCdSituacaoAtual("01");
            filtroBean.setCedente("312000");
            filtroBean.setCedenteCorrigido("052100");
            filtroBean.setCedenteOrigem(36598L);
            filtroBean.setCodBarras("654654654654654654321321321654654");
            filtroBean.setCodCanal("01");
            filtroBean.setCodDevolucao("01");
            filtroBean.setCodErro("123");
            filtroBean.setCodFormaRecebimento("01");
            filtroBean.setCodMensagem("02");
            filtroBean.setCpfCnpjCedente("01234567890123");
            filtroBean.setCpfCnpjSacado("01234567890123");
            filtroBean.setDataMovimento("99/99/9999");
            filtroBean.setDataRecebimento("99/99/9999");
            filtroBean.setDescCanal("CANAL");
            filtroBean.setDescErro("ERRO XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            filtroBean.setDescOpcao("DESC OPCAO");
            filtroBean.setDescricaoErro("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            filtroBean.setDthrBACEN("99/99/9999");
            filtroBean.setDthrSituacaoAnterior("99/99/9999");
            filtroBean.setDthrSituacaoAtual("99/99/9999");
            filtroBean.setHoraRecebimento("99:99:99");
            filtroBean.setIcTransfere("INDICADOR");
            filtroBean.setNomeCedente("NOME CEDENTE");
            filtroBean.setNossoNumero("123456789012345678");
            filtroBean.setNossoNumeroCorrigido("1234567890123456678");
            filtroBean.setNsuBACEN("123456");
            filtroBean.setNsuSIGCB("123456");
            filtroBean.setNsuSITRC("1234566");
            filtroBean.setPagina(1L);
            filtroBean.setOpcao(1L);
            filtroBean.setSequencial("123456");
            filtroBean.setTipoPessoaCedente("F");
            filtroBean.setTipoPessoaSacado("F");
            filtroBean.setTpBarras("1");

			filtroBean.setValorAcrescimo(filtroBean.getValorRecebido() );
			filtroBean.setValorDescAbatimento(filtroBean.getValorRecebido() );
			filtroBean.setValorDocumento(filtroBean.getValorRecebido() );
			filtroBean.setValorJuros(filtroBean.getValorRecebido() );
			filtroBean.setValorMulta(filtroBean.getValorRecebido() );
			filtroBean.setValorRecebido(filtroBean.getValorRecebido() );
            
            */


            request.getSession().setAttribute("pagina",pagina );
            request.getSession().setAttribute(LiqStrManterEstrategia.PAGINACAO_PAGE,pagina );
            request.getSession().setAttribute(FILTRO_BEAN,filtroBean );
            request.getSession().setAttribute(DATA_BEAN,filtroBean );
            
        } catch (Exception ex) {
            // ex.printStackTrace();
            throw ex;
        }

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_CONSULTAR;
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
