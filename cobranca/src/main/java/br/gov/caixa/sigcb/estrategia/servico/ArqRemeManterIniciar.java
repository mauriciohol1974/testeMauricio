package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.ArquivoRemessaBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade PvCobrador >> Manter >>
 * Iniciar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>14/10/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class ArqRemeManterIniciar extends ArqRemeEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);
        String fluxo = getFluxo(request);
        ArquivoRemessaBean arquivoRemessaBean = new ArquivoRemessaBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
            arquivoRemessaBean = (ArquivoRemessaBean) arquivoRemessaBean.newBean();
            request.getSession().setAttribute(FILTRO_BEAN, arquivoRemessaBean);
        } else {
            arquivoRemessaBean = (ArquivoRemessaBean) request.getSession()
                    .getAttribute(FILTRO_BEAN);
            if (arquivoRemessaBean.getCodigoUnidadePV().longValue() > 0) {
                arquivoRemessaBean.setOpcaoConsulta("UNIDADE");
                arquivoRemessaBean.setCodigoCedente(new Long(0));
            }
            request.getSession().setAttribute(FILTRO_BEAN, arquivoRemessaBean);
        }
        return PAGE_MANTER_FILTRO;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn("");
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage("");
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
