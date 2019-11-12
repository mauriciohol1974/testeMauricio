package br.gov.caixa.sigcb.estrategia.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.ConGerCedenteRentabilidadeBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Movimento de cobrança -
 * Rentabilidade do cedente
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>20/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */
public class MCRenCeManterIniciar extends MCRenCeEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);

        ConGerCedenteRentabilidadeBean mcrenceBean = new ConGerCedenteRentabilidadeBean();
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();

        cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();

        // EAM2907
        String fluxo = getFluxo(request);

        if (fluxo.equals(FLUXO_NORMAL)) {
            mcrenceBean = (ConGerCedenteRentabilidadeBean) mcrenceBean.newBean();
        } else {
            mcrenceBean = (ConGerCedenteRentabilidadeBean) mcrenceBean.getSessionBean(request,
                    BEAN_FILTRO);
        }

        request.getSession().setAttribute(BEAN_FILTRO, mcrenceBean);
        request.getSession().setAttribute(BEAN_FIXO, mcrenceBean);
        request.getSession().setAttribute(BEAN_CABECALHO, cedCabBean);

        return PAGE_FILTRO;
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
