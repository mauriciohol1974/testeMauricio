package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.WrappingException;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.ProtestoTituloBean;
import br.gov.caixa.sigcb.bean.TituloBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Protesto >> Envio ao Cartório - Lista
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>Jan/2009</DD>
 * </DL>
 * 
 * @author Cristian Souza - Probank/REDEASP02
 */

public class ProtestEnvioAoCartorioAcaoFiltro extends ProtestEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);
        
//      Recupera/define informacoes do titulo
        TituloBean tituloBean = new TituloBean();
        if (getFluxo(request).equals(FLUXO_NORMAL)) {

            tituloBean = (TituloBean) tituloBean.getRequestBean(request);
            tituloBean.setMeioEntrada(new Long(1));

            // Retem informacoes do bean antes do acesso ao mainframe
            request.getSession().setAttribute(DATA_BEAN, tituloBean);
            LogUtilSigcb.debug("REQUEST NORMAL");
        }
        
        else {
            tituloBean = (TituloBean) tituloBean.getSessionBean(request,
                    DATA_BEAN);
            LogUtilSigcb.debug("REQUEST NAO NORMAL");
        }
        LogUtilSigcb.debug("TITULO:" + tituloBean.getDataSolicitacao());
        if (tituloBean.getAcoesServicoTitulo() == 1) { // 1 - Consultar
        	
        	try {
        		InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(USUARIOLDAP_BEAN);

                // Instancia o EJB que acessa o mainframe
                //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        		  MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
                // Recupera os beans
                ProtestoTituloBean protestoTituloFiltroBean = new ProtestoTituloBean();
                protestoTituloFiltroBean.setOpcao(Long.valueOf("1")); // BGSC Campo Opcao - 1 Consulta Envio ao Cartório
                protestoTituloFiltroBean.setCodigoUnidadePv(tituloBean.getUnidadeCobradora());
                protestoTituloFiltroBean.setDataSolicitacao(tituloBean.getDataSolicitacao());
                protestoTituloFiltroBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
                protestoTituloFiltroBean.setFiltroSelecao(tituloBean.getFiltroSelecao());
                
                
                // faz chamada da transacao de consulta BGSC
                 usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
                String transUser = TRANSACAO_PROTESTO_CONSULTAR_TITULOS + usuarioBean.getCodigoUsuario().toUpperCase();
                List proTestList = handler.executeFixDataRecordsetTransaction(protestoTituloFiltroBean,
                		transUser);

                ProtestoTituloBean protestoTituloBean = (ProtestoTituloBean) ((BeanList) proTestList.get(0)).get(0);
                protestoTituloBean.setOpcao(protestoTituloFiltroBean.getOpcao()); // Consulta Primeira Tela
                protestoTituloBean.setCodigoUnidadePv(protestoTituloFiltroBean.getCodigoUnidadePv());
                protestoTituloBean.setDataSolicitacao(protestoTituloFiltroBean.getDataSolicitacao());
                protestoTituloBean.setCodigoUsuario(protestoTituloFiltroBean.getCodigoUsuario());
                protestoTituloBean.setFiltroSelecao(protestoTituloFiltroBean.getFiltroSelecao());



                // lança os beans de dados fixos e array
                request.getSession().setAttribute(PROTESTO_TITULO_DATA_BEAN, protestoTituloBean);

                // pega a lista de beans parte variavel
                BeanList proTestBeanList = (BeanList) proTestList.get(1);

                // converte a lista em um array de beans
                ArrayList proTestArrayList = convertDataStructure(proTestBeanList.iterator());

                // lança os beans de dados de paginação
                request.getSession().setAttribute(PAGINACAO_LIST,
                        getPageHolder(proTestArrayList));
                request.setAttribute(PAGINACAO_PAGE, "0");

            } catch (Exception e) {
                throw e;
            }
            return PAGE_CONSULTAR;
        	
        	
        }
        
        else if (tituloBean.getAcoesServicoTitulo() == 2) { //2 - Incluir

        	try {
        		InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(USUARIOLDAP_BEAN);

                // Instancia o EJB que acessa o mainframe
                //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        		  MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
                // Recupera os beans
                ProtestoTituloBean protestoTituloFiltroBean = new ProtestoTituloBean();
                protestoTituloFiltroBean.setOpcao(Long.valueOf("3")); // BGSC Campo Opcao - 3 Consulta Incluir Envio
                protestoTituloFiltroBean.setCodigoUnidadePv(tituloBean.getUnidadeCobradora());
                //protestoTituloFiltroBean.setDataSolicitacao(Calendar.getInstance().getTime());
                protestoTituloFiltroBean.setDataSolicitacao(tituloBean.getDataSolicitacao());
                protestoTituloFiltroBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
                protestoTituloFiltroBean.setFiltroSelecao(Long.valueOf(0));

                
                // faz chamada da transacao de consulta BGSC
                 usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
                String transUser = TRANSACAO_PROTESTO_CONSULTAR_TITULOS + usuarioBean.getCodigoUsuario().toUpperCase();
                List proTestList = handler.executeFixDataRecordsetTransaction(protestoTituloFiltroBean,	transUser);

                ProtestoTituloBean protestoTituloBean = (ProtestoTituloBean) ((BeanList) proTestList.get(0)).get(0);
                protestoTituloBean.setOpcao(protestoTituloFiltroBean.getOpcao()); 
                protestoTituloBean.setCodigoUnidadePv(protestoTituloFiltroBean.getCodigoUnidadePv());
                protestoTituloBean.setDataSolicitacao(protestoTituloFiltroBean.getDataSolicitacao());
                protestoTituloBean.setCodigoUsuario(protestoTituloFiltroBean.getCodigoUsuario());
                protestoTituloBean.setFiltroSelecao(protestoTituloFiltroBean.getFiltroSelecao()); 

                // lança os beans de dados fixos e array
                request.getSession().setAttribute(PROTESTO_TITULO_DATA_BEAN, protestoTituloBean);

                // pega a lista de beans parte variavel
                BeanList proTestBeanList = (BeanList) proTestList.get(1);

                // converte a lista em um array de beans
                ArrayList proTestArrayList = convertDataStructure(proTestBeanList.iterator());

                // lança os beans de dados de paginação
                request.getSession().setAttribute(PAGINACAO_LIST,
                        getPageHolder(proTestArrayList));
                request.setAttribute(PAGINACAO_PAGE, "0");

            } catch (Exception e) {
                throw e;
            }
            return PAGE_CONSULTAR_INCLUIR;

        
        }
        
        else {
        	throw new WrappingException(new Exception("Ação Inválida."));
        }

    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_ENVIO_AO_CARTORIO_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_ENVIO_AO_CARTORIO_INICIAR_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}