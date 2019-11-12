package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.ConGerServicosSolicitadosBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade Consultas Gerais -
 * Servi�os solicitados - Solicita��es rejeitadas
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>01/11/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */
public class ServRejManterFiltro extends ServRejEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);

        String retorno = "";
        String fluxo = getFluxo(request);

        ConGerServicosSolicitadosBean filtroBean = new ConGerServicosSolicitadosBean();
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        ArrayList paginacao = new ArrayList();

        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(USUARIOLDAP_BEAN);

        //MainFrameTransactionsSigcb handler = lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        if (fluxo.equals(FLUXO_NORMAL)) {
            filtroBean = (ConGerServicosSolicitadosBean) filtroBean.getRequestBean(request);
            cedCabBean = (CedenteCabecaBean) cedCabBean.getRequestBean(request);
            // EAM 22/08
            PilhaVoltarControle.push(request, filtroBean);
        } else {
            // EAM 22/08
            filtroBean = (ConGerServicosSolicitadosBean) PilhaVoltarControle.pop(request);
            if (filtroBean == null) {
                return (new ServRejManterIniciar()).processRequest(request,
                        response);
            }

            cedCabBean = (CedenteCabecaBean) cedCabBean.getSessionBean(request,
                    BEAN_CABECALHO);
        }

        request.getSession().setAttribute(BEAN_FILTRO, filtroBean);

        // EAM 22/08
        if (!filtroBean.getCodigoCedente().equals(new Long(0))) {
            request.getSession().setAttribute(CEDENTE_ATUAL,
                    filtroBean.getCodigoCedente());
        }

        /* PV VINCULA��O */
        // caminho que passa pela p�gina da consulta de cedente por pv
        if (filtroBean.getTpFiltro().intValue() == 1) {

            /* BGE1 */// Listar Cedentes de uma unidade de Vincula��o
            filtroBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
            // Setando o tipo de Consulta para solicita��es rejeitadas
            filtroBean.setTpConsulta(new Long(899));

            List bge1List = handler.executeFixDataRecordsetTransaction(filtroBean,
                    TRANS_LISTA_PV);

            // obtendo dados coplementares do Filtro Bean (nome Pv Vincula��o)
            ConGerServicosSolicitadosBean bean = (ConGerServicosSolicitadosBean) ((BeanList) bge1List.get(0)).get(0);

            BeanList bge1BeanList = (BeanList) bge1List.get(1);
            paginacao = convertDataStructure(bge1BeanList.iterator());

            filtroBean.setNomePvVinculacao(bean.getNomePvVinculacao());

            request.getSession().setAttribute(BEAN_FILTRO, filtroBean);
            request.getSession().setAttribute(PAGINACAO_LIST,
                    getPageHolder(paginacao));
            request.setAttribute(PAGINACAO_PAGE, "0");

            /* nota */
            // ap�s a consulta ser efetuada o bean � 'setado' para n�o passar
            // novamente por esse
            // passo do programa. Para anavega��o do programa nao seja afetada.
            // EAM 22/08
            // filtroBean.setTpFiltro(new Long(0));
            retorno = PAGE_LISTA_PVVINC;

            /* CEDENTE */
            // caminho que nao passa pela pagina de cedentes por pv
        } else if (filtroBean.getTpFiltro().intValue() == 0) {

            /* BGM0 */// - Obtem dados do cabe�alho do Cedente no SICLI
            cedCabBean.setTipoConsulta(new Long(1));
            cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
            cedCabBean.setCodigoCedente(filtroBean.getCodigoCedente());
            cedCabBean.setOrigemConsulta(new Long(1));

            BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
                    TRANS_CABECALHO);
            cedCabBean = (CedenteCabecaBean) cedCabBeanList.get(0);
            cedCabBean.setCodigoCedente(filtroBean.getCodigoCedente());
            request.getSession().setAttribute(BEAN_CABECALHO, cedCabBean);

            /* BGD0 */// - Lista de solicita��es rejeitadas e motivos
            /* nota */
            // os valores para tpConsulta seguem um padr�o necess�rio ao
            // mainframe
            // esses valores ser�o utilizados da transa��o BGE1 para dizer ao
            // mainframe qual
            // o tipo de consulta(Relat�rio)o usu�rio est� requisitando
            /*
             * o valor 899 � equivalente a chamada de transa��o para
             * Solicita��es rejeitada
             */
            filtroBean.setTpConsulta(new Long(899));

            filtroBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());

            BeanList bgd0BeanList = handler.executeSimpleTransactionQuery(filtroBean,
                    TRANS_SOL_REJ);
            paginacao = convertDataStructure(bgd0BeanList.iterator());
            request.getSession().setAttribute(PAGINACAO_LIST,
                    getPageHolder(paginacao));
            request.setAttribute(PAGINACAO_PAGE, "0");

            retorno = PAGE_CONSULTAR;

        }
        return retorno;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {

        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();

        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(TITLE);

        request.getSession().setAttribute(BEAN_MSG, msgBean);
    }
}
