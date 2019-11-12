package br.gov.caixa.sigcb.estrategia.dda;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.SacEletronicoBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB - DDA</B><BR>
 * Componente responsável pelo controle da funcionalidade Sacado Eletronico
 * 
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/09/2009</DD>
 * </DL>
 * baseado no CedBcoSManterFiltro
 * @author Alexandre Lima - alexandre.lima@probank.com.br
 */

public class SacEletronicoConsultarListar extends SacEletronicoEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);

        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);

        // Recupera o bean
        SacEletronicoBean sacBean = new SacEletronicoBean();
        //CedCentBean cedCentBean = new CedCentBean();
        if (fluxo.equals(FLUXO_NORMAL)) {            
            sacBean = (SacEletronicoBean) sacBean.getRequestBean(request);
        } else {            
            sacBean = (SacEletronicoBean) sacBean.getSessionBean(request,
        			FILTRO_BEAN);//estava DATA_BEAN
        }

        //request.getSession().setAttribute(CEDENTE_ATUAL,
        //        cedCentBean.getCodigoCedente());

        // Cria e Define cabecalho cedente
        //CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        //cedCabBean = (CedenteCabecaBean) cedCabBean.getSessionBean(request,
        //        CEDENTE_CABECALHO_BEAN);

        // Reter o bean antes de acessar o mainframe
        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(FILTRO_BEAN, sacBean);
        

        // Instancia o EJB que acessa o mainframe
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        //MainFrameTransactionsSigcb handler = SacEletronicoEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        // Definindo atributos para executar a transação BGM0 para obter o
        // cabeçalho
        //cedCabBean.setTipoConsulta(new Long(1));
        //cedCabBean.setOrigemConsulta(new Long(1));
        //InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
        //        .getAttribute(USUARIOLDAP_BEAN);
        //cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
        //cedCabBean.setCodigoCedente(cedCentBean.getCodigoCedente());

        // Chamada ao Mainframe para cabecalho cedente
        //BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
        //        TRANSACAO_CEDENTE_CABECALHO);
        //cedCabBean = (CedenteCabecaBean) cedCabBeanList.get(0);

        //cedCabBean.setCodigoCedente(cedCentBean.getCodigoCedente());
        //cedCentBean.setUsuario(usuarioBean.getCodigoUsuario());

        // Guarda informacoes de cabecalho
        //request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, cedCabBean);

        // Chamada ao Mainframe
        
        List sacEletronicoListBean = handler.executeFixDataRecordsetTransaction(sacBean,
        		TRANSACAO_CONSULTAR_LISTAR);
        
        //BeanList sacEletronicoListBean = handler.executeSimpleTransactionQuery(sacBean,
        //		TRANSACAO_CONSULTAR_LISTAR);
        
        //pega parte fixa dos dados
        SacEletronicoBean sacEletronFixoBean = (SacEletronicoBean) ((BeanList) sacEletronicoListBean.get(0)).get(0);
        sacEletronFixoBean.setCpfCnpj(sacBean.getCpfCnpj());
        //sacEletronFixoBean.setCodigoUnidadePV(sacBean.getCpfCnpj());
        
        //pega a lista de beans parte variavel
        BeanList sacEletronicoListaBean = (BeanList) sacEletronicoListBean.get(1);

        // converte a lista em um array de beans
        ArrayList sacEletronicoArrayList = convertDataStructure(sacEletronicoListaBean.iterator());

        // Retem beans de dados fixos e array
        sacBean.setCodRetorno(sacEletronFixoBean.getCodRetorno());
        request.getSession().setAttribute(FILTRO_BEAN, sacBean);
        request.getSession().setAttribute(DATA_BEAN, sacEletronFixoBean);
        request.getSession().setAttribute(PAGINACAO_LIST,
                getPageHolder(sacEletronicoArrayList));
        request.setAttribute(PAGINACAO_PAGE, "0");
        //request.getSession().setAttribute(PAGINACAO_LIST,
        //        getPageHolder(sacEletronicoArrayList));
        //request.setAttribute(PAGINACAO_PAGE, "0");

        return PAGE_LISTAR;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_FILTRO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_CONSULTAR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
