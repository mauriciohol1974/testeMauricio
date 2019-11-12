package br.gov.caixa.sigcb.estrategia.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.DdaTituloBean;
import br.gov.caixa.sigcb.bean.DdaTituloDiaBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.RelatorioBean;
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
public class ConsCedenteIniciar extends ConsRelatorioEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);

        RelatorioBean relBean = new RelatorioBean();

        String fluxo = getFluxo(request);
        PilhaVoltarControle.init(request);

        if (fluxo.equals(FLUXO_NORMAL)) {
        	relBean = (RelatorioBean) relBean.newBean();
          
        } else {
        	relBean = (RelatorioBean) relBean.getSessionBean(request, BEAN_FILTRO);
        }


        request.getSession().setAttribute(BEAN_FILTRO, relBean);

        return PAGE_FILTRO_CEDENTE;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();

        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INICIAR_CEDENTE);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_FILTRO_CEDENTE);

        request.getSession().setAttribute(MSG_BEAN, msgBean);

    }

}
