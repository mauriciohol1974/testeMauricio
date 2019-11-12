package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.TituloBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
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
public class ProtestSustaGeracaoArquivoAcaoFinalizar extends ProtestEstrategia {

    private String custom_SUCESSO_ACAO = "";

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);

        // Recupera/define informacoes do titulo
        TituloBean tituloBean = new TituloBean();
        if (getFluxo(request).equals(FLUXO_NORMAL)) {
            // Obtem dados do request:
            TituloBean reqTituloBean = new TituloBean();
            reqTituloBean = (TituloBean) reqTituloBean.getRequestBean(request);

            // Obtem dados:
            tituloBean = (TituloBean) tituloBean.getSessionBean(request,
                    DATA_BEAN);
            copyTituloDadosFiltroToTitulo(reqTituloBean, tituloBean);

            // Recupera informacoes do usuario
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                    .getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN);
            tituloBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
            tituloBean.setNomeGrupo(usuarioBean.getNomeGrupo());

            // Retem informacoes do bean antes do acesso ao mainframe
            request.getSession().setAttribute(DATA_BEAN, tituloBean);

        } else {
            tituloBean = (TituloBean) tituloBean.getSessionBean(request,
                    DATA_BEAN);
        }

        // Recupera/define informacoes de cabecalho do cedente
        BcoTituEstrategia.setCedenteCabecaBean(tituloBean, request);

        // Executa transacao de Acoes
        //MainFrameTransactionsSigcb handler = BcoTituEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_PROTESTO_SUSTA_INCLUIR + usuarioBean.getCodigoUsuario().toUpperCase();
        handler.executeSimpleTransactionVoid(tituloBean,
        		transUser);

        // Executa transacao de Impressao
        List tituloMsgBlqList = new ArrayList();
        switch (tituloBean.getAcoesServicoTitulo().intValue()) {

        case 5: // Impressão 2 via ordem de protesto
            // Obtem bean com informacoes da guia "Dados Principais (BG60)"
            // tituloBean = getTituloDadosPrincipais (request, response,
            // tituloBean);
            // Obtem bean com informacoes da guia "Dados Complementares (BG65)"
            tituloBean = getTituloDadosComplementares(request,
                    response,
                    tituloBean);

            // Seta informacoes do bean depois do acesso ao mainframe
            request.getSession().setAttribute(DATA_BEAN, tituloBean);
            request.getSession().setAttribute(DATA_MSG_BLQ_LIST,
                    tituloMsgBlqList);
        }

        // RE-Configurações para Mensagens e Telas de Erro e Sucesso
        this.custom_SUCESSO_ACAO = tituloBean.getAcoesServicoTituloTexto();
        configMsgSucessoErro(request);

        return PAGE_SUCESSO;

    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("Ação " + this.custom_SUCESSO_ACAO + SUCESSO_ACAO);
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_SUSTA_GER_ARQUIVO_INICIAR);
        msgBean.setStrategySucessReturn(STRATEGY_MANTER_SUSTA_GER_ARQUIVO_INICIAR);
        msgBean.setTitlePage(PAGE_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}