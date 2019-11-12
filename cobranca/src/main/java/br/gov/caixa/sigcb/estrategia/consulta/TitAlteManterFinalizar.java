package br.gov.caixa.sigcb.estrategia.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.ConGerTitulosAlteradosBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.TituloBean;
import br.gov.caixa.sigcb.estrategia.servico.BcoTituEstrategia;
import br.gov.caixa.sigcb.estrategia.servico.BcoTituManterIniciar;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Nome da funcionalidade
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>12/11/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class TitAlteManterFinalizar extends TitAlteEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);

        ConGerTitulosAlteradosBean titalteBean = new ConGerTitulosAlteradosBean();

        titalteBean = (ConGerTitulosAlteradosBean) titalteBean.getRequestBean(request);
        TituloBean tituloBean = new TituloBean();
        tituloBean = (TituloBean) tituloBean.newBean();

        tituloBean.setCodigoCedente(titalteBean.getCodigoCedente());
        tituloBean.setNossoNumero(titalteBean.getNossoNumero());

        request.getSession().setAttribute(BcoTituEstrategia.DATA_BEAN,
                tituloBean);

        return new BcoTituManterIniciar().processRequest(request, response);
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {

        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();

        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_FILTRO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(TITLE);

        request.getSession().setAttribute(BEAN_MSG, msgBean);

    }

}
