package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.BorderoBean;
import br.gov.caixa.sigcb.bean.BorderoTituloBean;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Bordero >> Manter >>
 * Filtro.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>02/09/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */
public class BorderoManterFiltro extends BorderoEstrategia {
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
            BorderoBean borderoBean = new BorderoBean();
            BorderoBean borderoFiltroBean = new BorderoBean();

            CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
            cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();

            if (fluxo.equals(FLUXO_NORMAL)) {
                borderoBean = (BorderoBean) borderoBean.getRequestBean(request);

                /*
                 * Inicio da implementação para a navegação. Para um correto
                 * funcionamento, é necessário que: Na estratégia *ManterIniciar
                 * o atributo navegacao seja atribuido com NAVEGACAO_FILTRO ou
                 * seja 0; Na página que possui botões que executam outra
                 * estratégia e que se deseje voltar depois, é necessário
                 * colocar na ação dos botões que chamem outra estratégia o
                 * atributo navegacao com valor NAVEGACAO_OUTRO ou seja 3.
                 * Exemplo: Na página listagem, na ação do Botão Alterar,
                 * atribui-se o valor 3 na navegação, para que ao voltar a
                 * página a ser exibida seja a lista de origem. Procurar nesta
                 * estratégia pela sequência de caracteres !@# nos comentários
                 * para saber se existe alguma implementação de navegação fora
                 * deste bloco de comentário. Obtenho o bean de filtro para
                 * saber o valor da navegação, e se for NAVEGACAO_FILTRO,
                 * obtenho o bean do request, e de acordo com os valores do
                 * filtro atribuio à navegação o valor de acordo a a lista a ser
                 * exibida e direciono para a página correta. Atentar para o
                 * detalhe de que existem dois beans, o filtroBean e o bean.
                 */
                borderoFiltroBean = (BorderoBean) borderoFiltroBean.getSessionBean(request,
                        FILTRO_BEAN);
                if (borderoFiltroBean.getNavegacao().equals(NAVEGACAO_FILTRO)) {
                    borderoFiltroBean = (BorderoBean) borderoFiltroBean.getRequestBean(request);
                    if (borderoFiltroBean.getCodigoBordero()
                            .equals(new Long(0))) {
                        borderoFiltroBean.setNavegacao(NAVEGACAO_LISTA_BORDERO);
                        borderoBean.setNavegacao(NAVEGACAO_LISTA_BORDERO);
                    } else {
                        borderoFiltroBean.setNavegacao(NAVEGACAO_LISTA_TITULO);
                        borderoBean.setNavegacao(NAVEGACAO_LISTA_TITULO);
                    }
                }

                // Ajuste para a volta da tela de sucesso
                BorderoBean beanSucesso = new BorderoBean();
                beanSucesso = (BorderoBean) beanSucesso.getSessionBean(request,
                        FILTRO_BEAN);
                if (beanSucesso.getNavegacao().equals(NAVEGACAO_LISTA_BORDERO)
                    && !borderoBean.getNavegacao()
                            .equals(NAVEGACAO_LISTA_TITULO)) {

                    borderoBean.setNavegacao(NAVEGACAO_LISTA_BORDERO);
                } else if (beanSucesso.getNavegacao()
                        .equals(NAVEGACAO_LISTA_TITULO)
                           && !borderoBean.getNavegacao()
                                   .equals(NAVEGACAO_LISTA_BORDERO)) {

                    borderoBean.setNavegacao(NAVEGACAO_LISTA_TITULO);
                }
            } else {
                borderoBean = (BorderoBean) borderoBean.getSessionBean(request,
                        DATA_BEAN);
                borderoFiltroBean = (BorderoBean) borderoFiltroBean.getSessionBean(request,
                        FILTRO_BEAN);

                // !@# Faço a verificação do valor da navegação para poder
                // identificar qual página
                // deve ser exibida caso o usuário esteja voltando.
                if (borderoBean.getNavegacao().equals(NAVEGACAO_LISTA_TITULO)) {
                    borderoBean.setNavegacao(NAVEGACAO_LISTA_BORDERO);
                } else if (borderoBean.getNavegacao()
                        .equals(NAVEGACAO_OUTRO_LISTA_BORDERO)) {
                    borderoBean.setNavegacao(NAVEGACAO_LISTA_BORDERO);
                } else if (borderoBean.getNavegacao()
                        .equals(NAVEGACAO_OUTRO_LISTA_TITULO)) {
                    borderoBean.setNavegacao(NAVEGACAO_LISTA_TITULO);
                } else {
                    if (borderoFiltroBean.getNavegacao()
                            .equals(NAVEGACAO_LISTA_BORDERO)) {
                        borderoBean.setNavegacao(NAVEGACAO_LISTA_BORDERO);
                    } else if (borderoFiltroBean.getNavegacao()
                            .equals(NAVEGACAO_LISTA_TITULO)) {
                        borderoBean.setNavegacao(NAVEGACAO_LISTA_TITULO);
                    }
                }
            }
            // Fim da implementação da navegação.

            // set necessário para corrigir erro de navegação.
            borderoBean.setRegistro(new Long(0));

            // Define manualmente atributos nao obtidos da jsp

            // Definindo atributos para executar a transação BGM0 para obter o
            // cabeçalho
            cedCabBean.setTipoConsulta(new Long(1));
            cedCabBean.setOrigemConsulta(new Long(1));
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                    .getAttribute(USUARIOLDAP_BEAN);
            cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
            cedCabBean.setCodigoCedente(borderoBean.getCodigoCedente());

            // Reter o bean antes de acessar o mainframe
            // para gerar informacoes para tela de erro
            request.getSession().setAttribute(CEDENTE_ATUAL,
                    borderoBean.getCodigoCedente());
            request.getSession().setAttribute(DATA_BEAN, borderoBean);
            request.getSession().setAttribute(FILTRO_BEAN, borderoFiltroBean);

            // Chamada ao Mainframe
            
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

            // Chama as Transacões
             usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CEDENTE_CABECALHO + usuarioBean.getCodigoUsuario().toUpperCase();
            /* BGM0 */BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,  transUser);

            try {
                if (borderoBean.getNavegacao().equals(NAVEGACAO_LISTA_BORDERO)) {
                	 transUser = TRANSACAO_LISTAR + usuarioBean.getCodigoUsuario().toUpperCase();
                    BeanList borderoBeanList = handler.executeSimpleTransactionQuery(borderoBean,
                    		transUser);

                    // convert DataStructure
                    ArrayList borderoArrayList = new ArrayList();
                    Iterator it = borderoBeanList.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        BorderoBean bean = (BorderoBean) it.next();
                        bean.setRegistro(new Long(i++));
                        borderoArrayList.add(bean);
                    }

                    // !@# Atribuindo a navegação para possibilitar a correta
                    // navegação
                    borderoBean.setNavegacao(NAVEGACAO_LISTA_TITULO);

                    // Reter os dados depois da chamada ao mainframe
                    // para gerar informacoes para tela de sucesso
                    request.getSession().setAttribute(PAGINACAO_LIST,
                            getPageHolder(borderoArrayList));
                    request.getSession().setAttribute(DATA_BEAN, borderoBean);

                    strRetorno = PAGE_MANTER_LISTAR;

                } else {
                    BorderoTituloBean borderoTituloBean = new BorderoTituloBean();
                    borderoTituloBean.setCodigoCedente(borderoBean.getCodigoCedente());
                    borderoTituloBean.setCodigoBordero(borderoBean.getCodigoBordero());
                    transUser = TRANSACAO_LISTAR_TITULO + usuarioBean.getCodigoUsuario().toUpperCase();
                    List tituloList = (List) handler.executeFixDataRecordsetTransaction(borderoTituloBean,  transUser);

                    borderoTituloBean = (BorderoTituloBean) ((BeanList) tituloList.get(0)).get(0);
                    BeanList borderoTituloBeanList = (BeanList) tituloList.get(1);

                    // convert DataStructure
                    ArrayList tituloArrayList = new ArrayList();
                    Iterator it = borderoTituloBeanList.iterator();
                    Long codCedente = borderoBean.getCodigoCedente();
                    Long codBordero = borderoBean.getCodigoBordero();

                    int i = 0;
                    while (it.hasNext()) {
                        BorderoTituloBean bean = (BorderoTituloBean) it.next();
                        bean.setRegistro(new Long(i++));
                        bean.setCodigoCedente(codCedente);
                        bean.setCodigoBordero(codBordero);
                        tituloArrayList.add(bean);
                    }

                    borderoBean.setSituacao(borderoTituloBean.getSituacao());
                    // Verifica se existem titulos na lista caso não tenha vai pra tela de inclusão
                    if (tituloArrayList.size()>0){
                        request.getSession().setAttribute(TituloEstrategia.BORDERO_BEAN, borderoBean);
                        request.getSession().setAttribute(TituloEstrategia.FIXO_BEAN,borderoTituloBean);
                        request.getSession().setAttribute(PAGINACAO_LIST, getPageHolder(tituloArrayList));
                        strRetorno = PAGE_TITULO_MANTER_LISTAR;
                    	
                    } else {
                    	
	                    	 // Obtem informacoes do titulo que foi selecionado na tela Manter
	                        // Titulos
	                        BorderoTituloBean borderoTitBean = new BorderoTituloBean();
	                        BorderoTituloBean borderoInfoBean = new BorderoTituloBean();
	
	                        if (fluxo.equals(FLUXO_NORMAL)) {
	                            borderoTitBean = (BorderoTituloBean) borderoTitBean.newBean();
	                            borderoInfoBean = (BorderoTituloBean) borderoInfoBean.getRequestBean(request);
	
	                            // Bean instanciado para navegação
	                            BorderoBean bordBean = new BorderoBean();
	                            bordBean = (BorderoBean) bordBean.getRequestBean(request);
	                            request.getSession().setAttribute(BorderoEstrategia.DATA_BEAN,   bordBean);
	
	                        } else {
	                            borderoTitBean = (BorderoTituloBean) borderoTitBean.getSessionBean(request, DATA_BEAN);
	                            borderoInfoBean = (BorderoTituloBean) borderoInfoBean.getSessionBean(request, BORDERO_INFO_BEAN);
	
	                        }
	
	                        request.getSession().setAttribute("tituloFixoBean", borderoInfoBean);
	                        request.getSession().setAttribute("tituloBean", borderoInfoBean);
                    	
                    	
                    	 	BorderoTituloBean borderoInfBean = new BorderoTituloBean();
                    	 	borderoInfBean.setCodigoCedente(codCedente);
                    	 	borderoInfBean.setCodigoBordero(codBordero);
                    	 	transUser = TRANSACAO_BORDERO_INFO + usuarioBean.getCodigoUsuario().toUpperCase();
                        	BeanList borderoTituloBeanRet = handler.executeSimpleTransactionQuery(borderoInfBean,    transUser); // Chama a Transacao
							
							BorderoTituloBean bean = new BorderoTituloBean();
							bean = (BorderoTituloBean) borderoTituloBeanRet.get(0);
							bean.setCodigoBordero(borderoInfBean.getCodigoBordero());
							bean.setCodigoCedente(borderoInfBean.getCodigoCedente());
							
							
							 if (borderoTituloBean.getEmissaoBloqueto()==0){
						        	borderoTituloBean.setEmissaoBloqueto(bean.getEmissaoBloqueto());
						        }
						        
						        LogUtilSigcb.info(">>>>BORDERO INFORMACAO::::" + borderoTituloBean.getEmissaoBloqueto());
						        LogUtilSigcb.info(">>>>BEAN:::"+ bean.getEmissaoBloqueto());
						        LogUtilSigcb.info(">>>>SomenteProtesto:::"+ bean.getSomenteProtesto());
						        
						        
						        // Reter o bean
						        
						        request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,   (CedenteCabecaBean) cedCabBeanList.get(0));
						        request.getSession().setAttribute("tituloBean", borderoTitBean);
						        request.getSession().setAttribute("borderoInfoBean", bean);
						        
						        // ATENCAO: Os Beans a seguir devem existir:
						        // 1. cabecalho do Cedente: cedCabBean
						        // 2. bordero: borderoBean

						        // Nome da JSP a ser chamada (nao possui o .jsp)
						        strRetorno =  PAGE_INCLUIR_TITULO;
                    	
                    }
                    
                    
                    
                    
                    
                }
            } catch (Exception e) {
                request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,   (CedenteCabecaBean) cedCabBeanList.get(0));

                throw e;
            }

            // Reter os dados depois da chamada ao mainframe
            // para gerar informacoes para tela de sucesso
            request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,
                    (CedenteCabecaBean) cedCabBeanList.get(0));
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
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_FILTRO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_MANTER);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}