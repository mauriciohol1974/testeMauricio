package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.BancoSacadoBean;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Banco de Sacados >>
 * Manter >> Filtro.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>05/10/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BcoSacaManterFiltro extends BancoSacadoEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String strRetorno = "";
        try {

            // Configurações para Mensagens e Telas de Erro e Sucesso
            configMsgSucessoErro(request);
            // Obtem informação para definir se o request veio de voltar ou se o
            // fluxo é normal
            String fluxo = getFluxo(request);
            // Obtem o bean que representa a funcionalidade
            BancoSacadoBean bancoSacadoBean = new BancoSacadoBean();
            BancoSacadoBean bancoSacadoFiltroBean = new BancoSacadoBean();

            CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
            cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();

            if (fluxo.equals(FLUXO_NORMAL)) {
                bancoSacadoBean = (BancoSacadoBean) bancoSacadoBean.getRequestBean(request);
                bancoSacadoFiltroBean = (BancoSacadoBean) bancoSacadoBean.getRequestBean(request);

            } else {
                bancoSacadoBean = (BancoSacadoBean) bancoSacadoBean.getSessionBean(request,
                        DATA_BEAN);
                bancoSacadoFiltroBean = (BancoSacadoBean) bancoSacadoBean.getSessionBean(request,
                        FILTRO_BEAN);
            }

            // Definindo atributos para executar a transação BGM0 para obter o
            // cabeçalho
            cedCabBean.setTipoConsulta(new Long(1));
            cedCabBean.setOrigemConsulta(new Long(1));
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                    .getAttribute(USUARIOLDAP_BEAN);
            cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
            cedCabBean.setCodigoCedente(bancoSacadoBean.getCodigoCedente());

            // Reter o bean antes de acessar o mainframe
            // para gerar informacoes para tela de erro
            request.getSession().setAttribute(CEDENTE_ATUAL,
                    bancoSacadoBean.getCodigoCedente());
            request.getSession().setAttribute(DATA_BEAN, bancoSacadoBean);
            request.getSession().setAttribute(FILTRO_BEAN,
                    bancoSacadoFiltroBean);

            // Chamada ao Mainframe
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
           

            CedenteCabecaBean cedBean = new CedenteCabecaBean();

            // Chama as Transacões
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CEDENTE_CABECALHO + usuarioBean.getCodigoUsuario().toUpperCase();
            /* BGM0 */BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
            		transUser);
            try {
                usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
                 transUser = TRANSACAO_LISTAR_BANCO_SACADO + usuarioBean.getCodigoUsuario().toUpperCase();

                /* BG46 */BeanList bancoSacadoBeanList = handler.executeSimpleTransactionQuery(bancoSacadoFiltroBean,
                		transUser);
                if (bancoSacadoFiltroBean.getCodigoBancoSacado()
                        .equals(new Long(0))) {
                    // convert DataStructure
                    ArrayList bancoSacadoArrayList = new ArrayList();
                    Iterator it = bancoSacadoBeanList.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        BancoSacadoBean bean = (BancoSacadoBean) it.next();
                        bean.setRegistro(new Long(i++));
                        bancoSacadoArrayList.add(bean);
                    }
                    // Reter os dados depois da chamada ao mainframe
                    // para gerar informacoes para tela de sucesso
                    request.getSession().setAttribute(PAGINACAO_LIST,
                            getPageHolder(bancoSacadoArrayList));
                    strRetorno = PAGE_MANTER_LISTAR;
                } else {
                    BancoSacadoBean banco = new BancoSacadoBean();
                    banco = (BancoSacadoBean) bancoSacadoBeanList.get(0);
                    banco.setNavegacao(NAVEGACAO_FILTRO_BANCO);
                    banco.setCodigoCedente(cedCabBean.getCodigoCedente());
                    request.getSession().setAttribute(DATA_BEAN, banco);

                    strRetorno = PAGE_CONSULTAR;
                }
            } catch (Exception e) {
                cedBean = (CedenteCabecaBean) cedCabBeanList.get(0);
                cedBean.setCodigoCedente(cedCabBean.getCodigoCedente());
                request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,
                        cedBean);

                throw e;
            }

            // Reter os dados depois da chamada ao mainframe
            // para gerar informacoes para tela de sucesso
            cedBean = (CedenteCabecaBean) cedCabBeanList.get(0);
            cedBean.setCodigoCedente(cedCabBean.getCodigoCedente());
            request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN, cedBean);
            request.setAttribute(PAGINACAO_PAGE, "0");
        } catch (Exception e) {
            throw e;
        }

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return strRetorno;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_MANTER_FILTRO);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}