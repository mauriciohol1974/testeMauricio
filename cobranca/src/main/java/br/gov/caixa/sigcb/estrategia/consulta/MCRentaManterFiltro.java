package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.ConGerCedenteRentabilidadeBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas gerais -
 * Movimento de Cobrança - Consultar cedentes por Rentabilidade
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>19/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class MCRentaManterFiltro extends MCRentaEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);

        String fluxo = getFluxo(request);

        ConGerCedenteRentabilidadeBean mcrentaBean = new ConGerCedenteRentabilidadeBean();
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(USUARIOLDAP_BEAN);

        if (fluxo.equals(FLUXO_NORMAL)) {
            mcrentaBean = (ConGerCedenteRentabilidadeBean) mcrentaBean.getRequestBean(request);
        } else {
            mcrentaBean = (ConGerCedenteRentabilidadeBean) mcrentaBean.getSessionBean(request,
                    BEAN_FILTRO);
        }

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        request.getSession().setAttribute(BEAN_FILTRO, mcrentaBean);

        /* BGA9 */// - obtem os dados de cedente por rentabilidade
        mcrentaBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
        BeanList bga9BeanList = handler.executeSimpleTransactionQuery(mcrentaBean,
                TRANSACAO_MCRENTA);
        ArrayList paginacao = convertDataStructure(bga9BeanList.iterator());

        request.getSession().setAttribute(PAGINACAO_LIST,
                getPageHolder(paginacao));
        request.setAttribute(PAGINACAO_PAGE, "0");

        return PAGE_CONSULTAR;
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
