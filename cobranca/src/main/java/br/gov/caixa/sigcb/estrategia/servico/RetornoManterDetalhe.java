package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.PageHolder;
import br.gov.caixa.sigcb.bean.ArquivoRemessaBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultar Bloqueto
 * On-line
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>14/10/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class RetornoManterDetalhe extends ArqRemeEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);
        ArquivoRemessaBean arquivoRemessaBean = new ArquivoRemessaBean();
        arquivoRemessaBean = (ArquivoRemessaBean) arquivoRemessaBean.getSessionBean(request,
                DATA_BEAN);

        PageHolder paginacao = (PageHolder) request.getSession()
                .getAttribute(ArqRemeEstrategia.PAGINACAO_LIST);
        String page = request.getParameter(ArqRemeEstrategia.PAGINACAO_PAGEANTERIOR);
        String escolha = request.getParameter("escolha");
        List list = (List) paginacao.getPage(Integer.parseInt(page));
        ArquivoRemessaBean arquivoRemessaBean2 = (ArquivoRemessaBean) list.get(Integer.parseInt(escolha));

        arquivoRemessaBean.setDataArquivo(arquivoRemessaBean2.getDataArquivo());
        arquivoRemessaBean.setHoraArquivo(arquivoRemessaBean2.getHoraArquivo());
        arquivoRemessaBean.setTipoArquivo(arquivoRemessaBean2.getTipoArquivo());
        arquivoRemessaBean.setPadrao(arquivoRemessaBean2.getPadrao());
        arquivoRemessaBean.setNumRemessaRetorno(arquivoRemessaBean2.getNumRemessaRetorno());
        arquivoRemessaBean.setQuantidadeRegistros(arquivoRemessaBean2.getQuantidadeRegistros());
        arquivoRemessaBean.setObservacao(arquivoRemessaBean2.getObservacao());
        arquivoRemessaBean.setCpfCnpj(arquivoRemessaBean2.getCpfCnpj());
        arquivoRemessaBean.setDescricaoVAN(arquivoRemessaBean2.getDescricaoVAN());

        // arquivoRemessaBean2 = (ArquivoRemessaBean)
        // arquivoRemessaBean2.getSessionBean(request, FILTRO_BEAN);
        // arquivoRemessaBean.setTipoAcao(arquivoRemessaBean2.getTipoAcao());
        // arquivoRemessaBean.setDataInicial(arquivoRemessaBean2.getDataInicial());
        // arquivoRemessaBean.setDataFinal(arquivoRemessaBean2.getDataFinal());

        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute("usuarioLdap");
        arquivoRemessaBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
        request.getSession().setAttribute(DATA_BEAN, arquivoRemessaBean);
        // Chamada ao Mainframe
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();// Instancia
                                                                                // o
                                                                                // EJB
                                                                                // que
                                                                                // acessa
                                                                                // o
                                                                                // mainframe
        /* BG43 */
        
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CONSULTAR_DETALHE + usuarioBean.getCodigoUsuario().toUpperCase();
        
        BeanList arqBeanList = (BeanList) handler.executeSimpleTransactionQuery(arquivoRemessaBean,
        		transUser);
        ArrayList arqList = convertDataStructure(arqBeanList.iterator());
        // Reter os dados depois da chamada ao mainframe
        // para gerar informacoes para tela de sucesso
        request.getSession().setAttribute(PAGINACAO_LIST + "1",
                getPageHolder(arqList));
        request.setAttribute(PAGINACAO_PAGE, "0");
        request.setAttribute(PAGINACAO_PAGEANTERIOR, "0");
        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_MANTER_CONSULTAR;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess(SUCESSO_SOLICITAR);
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_FILTRO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_MANTER_DETALHE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}