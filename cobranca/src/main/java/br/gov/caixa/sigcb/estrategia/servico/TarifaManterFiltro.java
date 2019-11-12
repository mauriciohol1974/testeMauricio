package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.TarifaManualBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Tarifa Manual >>
 * Manter >> Filtro.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>12/10/2004</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class TarifaManterFiltro extends TarifaManterEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);

        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);

        // Obtem o bean que representa a funcionalidade
        TarifaManualBean tarifaBean = new TarifaManualBean();
        TarifaManualBean tarifaFiltroBean = new TarifaManualBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
            tarifaBean = (TarifaManualBean) tarifaBean.getRequestBean(request);
            tarifaFiltroBean = (TarifaManualBean) tarifaFiltroBean.getRequestBean(request);
        } else {
            tarifaBean = (TarifaManualBean) tarifaBean.getSessionBean(request,
                    DATA_BEAN);
            tarifaFiltroBean = (TarifaManualBean) tarifaFiltroBean.getSessionBean(request,
                    FILTRO_BEAN);
        }

        // Reter o bean antes de acessar o mainframe
        // para gerar informacoes para tela de erro
        request.getSession().setAttribute(FILTRO_BEAN, tarifaFiltroBean);
        request.getSession().setAttribute(DATA_BEAN, tarifaBean);
        // Retem o ultimo cedente informado
        request.getSession().setAttribute(CEDENTE_ATUAL,
                tarifaBean.getCodigoCedente());

        // Instancia o EJB que acessa o mainframe
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        // Cria e Define cabecalho cedente
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        cedCabBean = (CedenteCabecaBean) cedCabBean.getSessionBean(request,
                CEDENTE_CABECALHO_BEAN);

        if (cedCabBean.getCodigoCedente() == null
            | cedCabBean.getCodigoCedente().equals(new Long(0))) {
            // Definindo atributos para executar a transação BGM0 para obter o
            // cabeçalho
            cedCabBean.setTipoConsulta(new Long(1));
            cedCabBean.setOrigemConsulta(new Long(1));
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                    .getAttribute(USUARIOLDAP_BEAN);
            cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
            cedCabBean.setCodigoCedente(tarifaBean.getCodigoCedente());

            // Chamada ao Mainframe para cabecalho cedente
             usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CEDENTE_CABECALHO + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
            		transUser);
            cedCabBean = (CedenteCabecaBean) cedCabBeanList.get(0);

            cedCabBean.setCodigoCedente(tarifaBean.getCodigoCedente());

            // Guarda informacoes de cabecalho
            request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,
                    cedCabBean);
        }

        ArrayList tarifaList = new ArrayList();
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_LISTAR + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList tarifaBeanList = handler.executeSimpleTransactionQuery(tarifaFiltroBean,
        		transUser);
        tarifaList = this.convertDataStructure(tarifaBeanList.iterator(),
                tarifaBean.getCodigoCedente(), tarifaBean.getTipoTarifa());

        request.setAttribute(PAGINACAO_PAGE, "0");
        request.getSession().setAttribute(PAGINACAO_LIST,
                getPageHolder(tarifaList));

        return PAGE_MANTER_LISTAR;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_FILTRO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_MANTER);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

    //
    // Metodo sobrescrito para setar atributo registro e o codigo do cedente
    //
    public ArrayList convertDataStructure(Iterator iterator, Long codCedente, Long tipoTarifa) {
        ArrayList list = new ArrayList();
        int i = 0;
        while (iterator.hasNext()) {
            TarifaManualBean bean = (TarifaManualBean) iterator.next();
            bean.setRegistro(new Long(i));
            bean.setCodigoCedente(codCedente);
            bean.setTipoTarifa(tipoTarifa);
            list.add(bean);
            i++;
        }
        return list;
    }
}