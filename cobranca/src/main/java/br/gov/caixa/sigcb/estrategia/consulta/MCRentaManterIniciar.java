package br.gov.caixa.sigcb.estrategia.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.ConGerCedenteRentabilidadeBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

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
public class MCRentaManterIniciar extends MCRentaEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);

        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);

        ConGerCedenteRentabilidadeBean mcrentaBean = new ConGerCedenteRentabilidadeBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
            mcrentaBean = (ConGerCedenteRentabilidadeBean) mcrentaBean.newBean();
        } else {
            mcrentaBean = (ConGerCedenteRentabilidadeBean) mcrentaBean.getSessionBean(request,
                    BEAN_FILTRO);
        }

        request.getSession().setAttribute(BEAN_FILTRO, mcrentaBean);

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
