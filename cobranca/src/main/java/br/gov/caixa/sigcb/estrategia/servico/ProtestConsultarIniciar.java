package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.TituloBean;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;


/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Protesto >> SUSTA - Geração de Arquivo
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>Jan/2009</DD>
 * </DL>
 * 
 * @author Cristian Souza - Probank/REDEASP02
 */

public class ProtestConsultarIniciar extends ProtestEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
        
        // Obtem o bean que representa a funcionalidade
        TituloBean tituloBean = new TituloBean();
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        if (getFluxo(request).equals(FLUXO_NORMAL)) {
            tituloBean = (TituloBean) tituloBean.newBean();
            cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();

            Long cedente = new Long(0);
            if (request.getSession()
                    .getAttribute(SigcbEstrategia.CEDENTE_ATUAL) != null)
                cedente = (Long) request.getSession()
                        .getAttribute(SigcbEstrategia.CEDENTE_ATUAL);

            tituloBean.setCodigoCedente(cedente);
        } else {
            tituloBean = (TituloBean) tituloBean.getSessionBean(request,
                    DATA_BEAN);
            cedCabBean = (CedenteCabecaBean) cedCabBean.getSessionBean(request,
                    CEDENTE_CABECALHO_BEAN);
        }

        // Cria o bean que sera utilizado com informações vinda da pagina
        request.getSession().setAttribute(DATA_BEAN, tituloBean);
        request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, cedCabBean);


        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_SUSTA_GER_ARQUIVO_FILTRO_MANTER;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_SUSTA_GER_ARQUIVO_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_SUSTA_GER_ARQUIVO_INICIAR_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}
