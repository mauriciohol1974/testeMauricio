package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.SacadoBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Sacados >> Manter >>
 * Filtro.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>05/10/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class SacadoManterFiltro extends SacadoEstrategia {

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
            SacadoBean sacadoBean = new SacadoBean();
            SacadoBean sacadoFiltroBean = new SacadoBean();

            CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
            cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();

            if (fluxo.equals(FLUXO_NORMAL)) {
                sacadoBean = (SacadoBean) sacadoBean.getRequestBean(request);

                // Inicio da implementação para a navegação.

                sacadoFiltroBean = (SacadoBean) sacadoFiltroBean.getSessionBean(request,
                        FILTRO_BEAN);

                if (sacadoFiltroBean.getNavegacao().equals(NAVEGACAO_NORMAL)) {
                    sacadoFiltroBean = (SacadoBean) sacadoFiltroBean.getRequestBean(request);
                    if (sacadoFiltroBean.getCodigoBancoSacado()
                            .equals(new Long(0))) {
                        sacadoFiltroBean.setNavegacao(NAVEGACAO_FILTRO_CEDENTE);
                        sacadoBean.setNavegacao(NAVEGACAO_FILTRO_CEDENTE);
                    } else if (sacadoFiltroBean.getCodigoSacado()
                            .trim()
                            .equals("")) {
                        sacadoFiltroBean.setNavegacao(NAVEGACAO_FILTRO_NUMERO);
                        sacadoBean.setNavegacao(NAVEGACAO_FILTRO_NUMERO);
                    } else {
                        sacadoFiltroBean.setNavegacao(NAVEGACAO_FILTRO_TUDO);
                        sacadoBean.setNavegacao(NAVEGACAO_FILTRO_TUDO);
                    }
                }
            } else {
                sacadoBean = (SacadoBean) sacadoBean.getSessionBean(request,
                        DATA_BEAN);
                sacadoFiltroBean = (SacadoBean) sacadoFiltroBean.getSessionBean(request,
                        FILTRO_BEAN);

                // !@# Faço a verificação do valor da navegação para poder
                // identificar qual página
                // deve ser exibida caso o usuário esteja voltando.
                if (sacadoBean.getNavegacao().equals(NAVEGACAO_FILTRO_NUMERO)) {
                    sacadoBean.setNavegacao(NAVEGACAO_FILTRO_CEDENTE);
                } else {
                    sacadoBean.setNavegacao(NAVEGACAO_FILTRO_NUMERO);
                }
            }
            // Fim da implementação da navegação.

            // Definindo atributos para executar a transação BGM0 para obter o
            // cabeçalho
            cedCabBean.setTipoConsulta(new Long(1));
            cedCabBean.setOrigemConsulta(new Long(1));
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                    .getAttribute(USUARIOLDAP_BEAN);
            cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
            cedCabBean.setCodigoCedente(sacadoBean.getCodigoCedente());

            // Reter o bean antes de acessar o mainframe
            // para gerar informacoes para tela de erro
            request.getSession().setAttribute(CEDENTE_ATUAL,
                    sacadoBean.getCodigoCedente());
            request.getSession().setAttribute(DATA_BEAN, sacadoBean);
            request.getSession().setAttribute(FILTRO_BEAN, sacadoFiltroBean);

            // Chamada ao Mainframe
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

            CedenteCabecaBean cedBean = new CedenteCabecaBean();

            // Chama as Transacões
            usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CEDENTE_CABECALHO + usuarioBean.getCodigoUsuario().toUpperCase();
            /* BGM0 */BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,transUser);

            // condição para quando é preenchido apenas o codigo do cedente no
            // filtro
            // Ira exibir nesta condição a lista com os bancos de sacados.
            if (sacadoBean.getNavegacao().equals(NAVEGACAO_FILTRO_CEDENTE)) {
                try {
                    /* BG46 */
                	 transUser =  BancoSacadoEstrategia.TRANSACAO_LISTAR_BANCO_SACADO + usuarioBean.getCodigoUsuario().toUpperCase();
                	BeanList sacadoBeanList = handler.executeSimpleTransactionQuery(sacadoFiltroBean,	transUser);
                    ArrayList sacadoArrayList = convertDataStructure(sacadoBeanList.iterator());
                    request.getSession().setAttribute(PAGINACAO_LIST,
                            getPageHolder(sacadoArrayList));

                    // !@# Atribuindo a navegação para possibilitar a correta
                    // navegação
                    sacadoBean.setNavegacao(NAVEGACAO_FILTRO_NUMERO);

                    request.getSession().setAttribute(DATA_BEAN, sacadoBean);

                    strRetorno = PAGE_MANTER_LISTAR_BCO;
                } catch (Exception e) {
                    cedBean = (CedenteCabecaBean) cedCabBeanList.get(0);
                    cedBean.setCodigoCedente(cedCabBean.getCodigoCedente());
                    request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,
                            cedBean);

                    throw e;
                }
            }
            // condição para quando é preenchido o codigo do cedente, numero do
            // banco de sacados
            // e cpf/cnpj no filtro
            // Irá exibir nesta condição a lista com os sacados que atendam as
            // condições do filtro.
            else if (sacadoBean.getNavegacao().equals(NAVEGACAO_FILTRO_NUMERO)) {
                // !@# Set para passar corretamente da lista de bco saca para a
                // lista de sacados.
                SacadoBean sacado = new SacadoBean();
                if (sacadoFiltroBean.getNavegacao()
                        .equals(NAVEGACAO_FILTRO_CEDENTE)
                    && fluxo.equals(FLUXO_NORMAL)) {
                    sacado = (SacadoBean) sacadoBean.clone();
                } else if (sacadoFiltroBean.getNavegacao()
                        .equals(NAVEGACAO_FILTRO_CEDENTE)
                           && fluxo.equals(FLUXO_VOLTAR)) {
                    sacado = (SacadoBean) sacadoFiltroBean.clone();
                    sacado.setCodigoBancoSacado(sacadoBean.getCodigoBancoSacado());
                } else {
                    sacado = (SacadoBean) sacadoFiltroBean.clone();
                }

                try {
                	   usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
                       transUser = TRANSACAO_LISTAR_SACADO + usuarioBean.getCodigoUsuario().toUpperCase();
                    /* BG49 */List sacadoList = (List) handler.executeFixDataRecordsetTransaction(sacado,transUser);

                    // Obtendo o nome do banco de sacados e atribuindo ao Bean
                    sacado = (SacadoBean) ((BeanList) sacadoList.get(0)).get(0);
                    sacadoBean.setNomeBancoSacado(sacado.getNomeBancoSacado());

                    // obtendo a lista de sacados
                    BeanList sacadoBeanList = (BeanList) sacadoList.get(1);
                    ArrayList sacadoArrayList = convertDataStructure(sacadoBeanList.iterator());

                    request.getSession().setAttribute(PAGINACAO_LIST,
                            getPageHolder(sacadoArrayList));
                    request.getSession().setAttribute(DATA_BEAN, sacadoBean);

                    request.getSession().setAttribute(DATA_BEAN, sacadoBean);
                    strRetorno = PAGE_MANTER_LISTAR_SAC;
                } catch (Exception e) {
                    cedBean = (CedenteCabecaBean) cedCabBeanList.get(0);
                    cedBean.setCodigoCedente(cedCabBean.getCodigoCedente());
                    request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,
                            cedBean);

                    throw e;
                }
            }
            // condição para quando todos os dados foram preenchidos no filtro
            else if (sacadoFiltroBean.getNavegacao()
                    .equals(NAVEGACAO_FILTRO_TUDO)) {
                try {
                    // Obtendo a descricao do banco de sacados
                	
                    /* BG46 */
                	usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
                    transUser = BancoSacadoEstrategia.TRANSACAO_LISTAR_BANCO_SACADO + usuarioBean.getCodigoUsuario().toUpperCase();
                	BeanList bancoSacadoBeanList = handler.executeSimpleTransactionQuery(sacadoFiltroBean,transUser);
                    SacadoBean sacado = new SacadoBean();
                    sacado = (SacadoBean) bancoSacadoBeanList.get(0);

                    // Obtendo os dados do sacado
                    /* BG50 */
                    usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
                    transUser =TRANSACAO_CONSULTAR_SACADO + usuarioBean.getCodigoUsuario().toUpperCase();
                    BeanList sacadoBeanList = handler.executeSimpleTransactionQuery(sacadoFiltroBean,transUser);
                    sacadoBean = (SacadoBean) sacadoBeanList.get(0);

                    // Atribuindo ao bean os valores não obtidos na transação
                    sacadoBean.setCodigoCedente(sacadoFiltroBean.getCodigoCedente());
                    sacadoBean.setCodigoBancoSacado(sacadoFiltroBean.getCodigoBancoSacado());
                    sacadoBean.setNomeBancoSacado(sacado.getNomeBancoSacado());
                    sacadoBean.setTipoPessoaSacado(sacadoFiltroBean.getTipoPessoaSacado());
                    sacadoBean.setCpfCnpjSacado(sacadoFiltroBean.getCpfCnpjSacado());
                    sacadoBean.setCodigoSacado(sacadoFiltroBean.getCodigoSacado());

                    // Atribuindo a navegação para possibilitar a volta para a
                    // página correta
                    sacadoBean.setNavegacao(NAVEGACAO_FILTRO_TUDO);
                    request.getSession().setAttribute(DATA_BEAN, sacadoBean);

                    strRetorno = PAGE_CONSULTAR;
                } catch (Exception e) {
                    cedBean = (CedenteCabecaBean) cedCabBeanList.get(0);
                    cedBean.setCodigoCedente(cedCabBean.getCodigoCedente());
                    request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,
                            cedBean);

                    throw e;
                }
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
        msgBean.setTitlePage(PAGE_TITLE_MANTER_LISTAR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}