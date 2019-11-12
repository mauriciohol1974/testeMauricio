package br.gov.caixa.sigcb.estrategia.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.SaldoCobrancaBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Saldo de Cobrança
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>09/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */

public class SalCobManterFiltro extends SaldoCobrancaEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {

            // Configurações para Mensagens e Telas de Erro e Sucesso
            configMsgSucessoErro(request);

            // Obtem informação para definir se o request veio de voltar ou se o
            // fluxo é normal
            String fluxo = getFluxo(request);

            // Recupera os beans
            SaldoCobrancaBean saldoCobrancaFiltroBean = new SaldoCobrancaBean();

            CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
            cedCabBean.newBean();

            if (fluxo.equals(FLUXO_NORMAL)) {
                saldoCobrancaFiltroBean = (SaldoCobrancaBean) saldoCobrancaFiltroBean.getRequestBean(request);
            } else {
                saldoCobrancaFiltroBean = (SaldoCobrancaBean) saldoCobrancaFiltroBean.getSessionBean(request,
                        FILTRO_BEAN);

            }
            request.getSession().setAttribute(CEDENTE_ATUAL,
                    saldoCobrancaFiltroBean.getCodigoCedente());
            request.getSession().setAttribute(FILTRO_BEAN,
                    saldoCobrancaFiltroBean);
            request.getSession().setAttribute(DATA_BEAN,
                    saldoCobrancaFiltroBean);
            request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,
                    cedCabBean);

            // pega informações do usuario
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                    .getAttribute(USUARIOLDAP_BEAN);

            // Instancia o EJB que acessa o mainframe
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            // Definindo atributos para executar a transação BGM0 para obter o
            // cabeçalho
            cedCabBean.setTipoConsulta(new Long(1));
            cedCabBean.setOrigemConsulta(new Long(1));
            cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
            cedCabBean.setCodigoCedente(saldoCobrancaFiltroBean.getCodigoCedente());

            // Chamada ao Mainframe para cabecalho cedente
            BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
                    TRANSACAO_CEDENTE_CABECALHO);
            cedCabBean = (CedenteCabecaBean) cedCabBeanList.get(0);

            cedCabBean.setCodigoCedente(saldoCobrancaFiltroBean.getCodigoCedente());

            // Guarda informacoes de cabecalho
            request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,
                    cedCabBean);

            // faz chamada da transacao de consulta BGA7

            BeanList salCobBeanList = handler.executeSimpleTransactionQuery(saldoCobrancaFiltroBean,
                    TRANSACAO_CONSULTAR);

            SaldoCobrancaBean saldoCobrancaBean = (SaldoCobrancaBean) salCobBeanList.get(0);
            saldoCobrancaBean.setCodigoCedente(saldoCobrancaFiltroBean.getCodigoCedente());

            // lança os beans de dados fixos e array
            request.getSession().setAttribute(DATA_BEAN, saldoCobrancaBean);

        } catch (Exception e) {
            throw e;
        }
        return PAGE_CONSULTAR;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}
