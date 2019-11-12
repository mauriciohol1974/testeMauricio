package br.gov.caixa.sigcb.estrategia.cedente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.DadosListaExcepciBean;
import br.gov.caixa.sigcb.bean.ExcepcionacaoBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Agrupamento >> Incluir >>
 * Iniciar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>28/06/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */
public class ExcepciManterIniciar extends ExcepciManterEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);

        PilhaVoltarControle.init(request);

        DadosListaExcepciBean filtroBean = new DadosListaExcepciBean();
        ExcepcionacaoBean excepciBean = new ExcepcionacaoBean();
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();

        // EAM 16/06/2005
        String fluxo = getFluxo(request);
        if (fluxo.equals(FLUXO_NORMAL)) {
            filtroBean = (DadosListaExcepciBean) filtroBean.newBean();
        } else {
            filtroBean = (DadosListaExcepciBean) filtroBean.getSessionBean(request,
                    FILTRO_BEAN);
        }

        // EAM Fim

        excepciBean = (ExcepcionacaoBean) excepciBean.newBean();
        cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();

        request.getSession().setAttribute(EXCEPCI_BEAN, excepciBean);
        request.getSession().setAttribute(FILTRO_BEAN, filtroBean);
        request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, cedCabBean);

        filtroBean.setEstrategiaVoltar(STRATEGY_FILTRO);

        return PAGE_FILTRO;
    }

    // Configuração para mensagens e telas de erro e sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();

        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_FILTRO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);

        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}