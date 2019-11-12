package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.Formatacao;
import br.gov.caixa.sigcb.bean.CedCentBean;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.CedentePECBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.LiquidacoesSTRBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.jsp.PaginacaoTag;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Cedente Centralizador
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/09/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */

public class CedenteMasterPECManterFiltro extends CedenteMasterPECEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);

        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);

        // Recupera o bean
        CedentePECBean cedentePEC = new CedentePECBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
        	cedentePEC = (CedentePECBean) cedentePEC.getRequestBean(request);
        } else {
        	cedentePEC = (CedentePECBean) cedentePEC.getSessionBean(request, FILTRO_BEAN);
        }
        String voltar = request.getParameter("voltar");
        cedentePEC.setVoltar(voltar);
        request.getSession().setAttribute(CEDENTE_ATUAL, cedentePEC.getCodigoCedente());

        // Cria e Define cabecalho cedente
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        cedCabBean = (CedenteCabecaBean) cedCabBean.getSessionBean(request, CEDENTE_CABECALHO_BEAN);

        // Reter o bean antes de acessar o mainframe
        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(FILTRO_BEAN, cedentePEC);

        // Instancia o EJB que acessa o mainframe
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        // Definindo atributos para executar a transação BGM0 para obter o
        // cabeçalho
        if (cedentePEC.getCodigoCedente()>0){
        	cedentePEC.setTipoConsulta("2");
        }else{
        	cedentePEC.setTipoConsulta("1");
        }
        

        
        int paginaAtual = 1;
        try {
            paginaAtual = Integer.parseInt(request.getParameter("pagina"));
        } catch (Exception e) {
        }
        if (paginaAtual==0){
        	paginaAtual= 1;
        }

        
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        
        cedCabBean.setCodigoUsuario(Formatacao.formataNumerico(usuarioBean.getCodigoUsuario(),6));
        cedCabBean.setCodigoCedente(cedentePEC.getCodigoCedente());

        // Chamada ao Mainframe
        cedentePEC.setUsuario(usuarioBean.getCodigoUsuario());
         usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CEDENTE_MASTERPEC + usuarioBean.getCodigoUsuario().toUpperCase();
        List cedentePECLst = handler.executeFixDataRecordsetTransaction(cedentePEC,  transUser);
       
        CedentePECBean fixoBean = (CedentePECBean) ((BeanList) cedentePECLst.get(0)).get(0);
        BeanList cedentePecLista = (BeanList) cedentePECLst.get(1);
        
        ArrayList cedentePECPagina = convertDataStructure(cedentePecLista.iterator());
        request.getSession().setAttribute(FIXO_BEAN,  fixoBean);
        request.getSession().setAttribute(PAGINACAO_LIST, getPageHolder(cedentePECPagina));
        request.setAttribute(PAGINACAO_PAGE, "0");
        request.setAttribute("PAGFILTRO", String.valueOf(paginaAtual));
        request.setAttribute(PaginacaoTag.PAGINA_ATUAL, 1);
        request.setAttribute(PaginacaoTag.PAGINA_TOTAL, (int) Math.ceil(cedentePecLista.size() / 20.0));


        return PAGE_JSP_CONSULTAR;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_CONSULTA);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
