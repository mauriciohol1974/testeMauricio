package br.gov.caixa.sigcb.estrategia.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.ConGerTitulosLiquidadosBean;
import br.gov.caixa.sigcb.bean.ConGerTitulosLiquidadosIOFBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas - Títulos
 * liquidados com retenção IOF
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>07/12/2010</DD>
 * </DL>
 * 
 * @author Adelaine Rondon - adelaine.rondon@probank.com.br
 */


/*public class TitLiqIOFConsultarDetIniciar extends TitLiqIOFManterEstrategia {
   public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        try {
            configMsgSucessoErro(request);

            String fluxo = getFluxo(request);

            ConGerTitulosLiquidadosIOFBean filtroBean = new ConGerTitulosLiquidadosIOFBean();
            ConGerTitulosLiquidadosBean titliqBean = new ConGerTitulosLiquidadosBean();

            MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();

            if (fluxo.equals(FLUXO_NORMAL)) {
                filtroBean = (ConGerTitulosLiquidadosIOFBean) filtroBean.getRequestBean(request);
                // EAM - 23/08
                PilhaVoltarControle.push(request, filtroBean);
            } else {
                filtroBean = (ConGerTitulosLiquidadosIOFBean) filtroBean.getSessionBean(request,
                        FILTRO_BEAN);
            }

            titliqBean.setTipoConsulta(new Long(1));
            titliqBean.setCodigoCedente(filtroBean.getCodigoCedente());
            titliqBean.setNossoNumero(filtroBean.getNossoNumero());
            titliqBean.setDataPagamento(filtroBean.getDataPagamento());
            titliqBean.setSequencialDia(filtroBean.getSequencialDia());

            BeanList titBeanList = handler.executeSimpleTransactionQuery(titliqBean,
                    TRANS_CONSULTAR_DETALHES);
            ConGerTitulosLiquidadosIOFBean bean = (ConGerTitulosLiquidadosIOFBean) titBeanList.get(0);

            bean.setDataPagamento(filtroBean.getDataPagamento());

            request.getSession().setAttribute(TITLIQ_BEAN, bean);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return PAGE_LIQ_CONSULTAR;
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
}
*/
