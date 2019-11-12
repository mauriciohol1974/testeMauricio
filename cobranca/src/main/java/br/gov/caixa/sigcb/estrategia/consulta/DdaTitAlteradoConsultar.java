package br.gov.caixa.sigcb.estrategia.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.DdaTituloBean;
import br.gov.caixa.sigcb.bean.DdaTituloDiaBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;

/**
 * <B>Projeto: SIGCB - DDA</B><BR>
 * Componente responsável pelo controle da funcionalidade Consulta >> DDA
 * 
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/09/2009</DD>
 * </DL>
 * 
 * @author Alexandre Lima - alexandre.lima@probank.com.br
 */
public class DdaTitAlteradoConsultar extends DdaTitIncluidoEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        try {
            configMsgSucessoErro(request);

            String fluxo = getFluxo(request);

            DdaTituloDiaBean ddaFiltroTitBean = new DdaTituloDiaBean();
            DdaTituloBean ddaTitBean = new DdaTituloBean();

           // MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            if (fluxo.equals(FLUXO_NORMAL)) {
            	ddaFiltroTitBean = (DdaTituloDiaBean) ddaFiltroTitBean.getRequestBean(request);
                //  23/08
                PilhaVoltarControle.push(request, ddaFiltroTitBean);
            } else {
            	ddaFiltroTitBean = (DdaTituloDiaBean) ddaFiltroTitBean.getSessionBean(request,
                        FILTRO_BEAN);
            }

            ddaTitBean.setTipoConsulta(new Long(3));
            ddaTitBean.setCodigoCedente(ddaFiltroTitBean.getCodigoCedente());
            ddaTitBean.setNossoNumero(ddaFiltroTitBean.getNossoNumero());
            ddaTitBean.setDataPagamento(ddaFiltroTitBean.getDataPagamento());
            ddaTitBean.setSequencialDia(ddaFiltroTitBean.getSequencialDia());
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANS_CONSULTAR_DETALHES + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList titBeanList = handler.executeSimpleTransactionQuery(ddaTitBean,
            		transUser);
            DdaTituloBean bean = (DdaTituloBean) titBeanList.get(0);

            bean.setDataPagamento(ddaFiltroTitBean.getDataPagamento());
            bean.setNossoNumero(ddaFiltroTitBean.getNossoNumero());
            request.getSession().setAttribute(TITLIQ_BEAN, bean);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return PAGE_DDA_CONSULTAR_A;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();

        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INICIAR_A);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);

        request.getSession().setAttribute(MSG_BEAN, msgBean);

    }
}
