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
 * Componente respons�vel pelo controle da funcionalidade Bordero >> Manter >>
 * Filtro.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>02/09/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Mor�s - emoras@sao.politec.com.br
 */
public class BorderoManterFiltro extends BorderoEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String strRetorno = "";
        try {

            // Configura��es para Mensagens e Telas de Erro e Sucesso
            configMsgSucessoErro(request);
            // Obtem informa��o para definir se o request veio de voltar ou se o
            // fluxo � normal
            String fluxo = getFluxo(request);
            // Obtem o bean que representa a funcionalidade
            BorderoBean borderoBean = new BorderoBean();
            BorderoBean borderoFiltroBean = new BorderoBean();

            CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
            cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();

            if (fluxo.equals(FLUXO_NORMAL)) {
                borderoBean = (BorderoBean) borderoBean.getRequestBean(request);

                /*
                 * Inicio da implementa��o para a navega��o. Para um correto
                 * funcionamento, � necess�rio que: Na estrat�gia *ManterIniciar
                 * o atributo navegacao seja atribuido com NAVEGACAO_FILTRO ou
                 * seja 0; Na p�gina que possui bot�es que executam outra
                 * estrat�gia e que se deseje voltar depois, � necess�rio
                 * colocar na a��o dos bot�es que chamem outra estrat�gia o
                 * atributo navegacao com valor NAVEGACAO_OUTRO ou seja 3.
                 * Exemplo: Na p�gina listagem, na a��o do Bot�o Alterar,
                 * atribui-se o valor 3 na navega��o, para que ao voltar a
                 * p�gina a ser exibida seja a lista de origem. Procurar nesta
                 * estrat�gia pela sequ�ncia de caracteres !@# nos coment�rios
                 * para saber se existe alguma implementa��o de navega��o fora
                 * deste bloco de coment�rio. Obtenho o bean de filtro para
                 * saber o valor da navega��o, e se for NAVEGACAO_FILTRO,
                 * obtenho o bean do request, e de acordo com os valores do
                 * filtro atribuio � navega��o o valor de acordo a a lista a ser
                 * exibida e direciono para a p�gina correta. Atentar para o
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

                // !@# Fa�o a verifica��o do valor da navega��o para poder
                // identificar qual p�gina
                // deve ser exibida caso o usu�rio esteja voltando.
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
            // Fim da implementa��o da navega��o.

            // set necess�rio para corrigir erro de navega��o.
            borderoBean.setRegistro(new Long(0));

            // Define manualmente atributos nao obtidos da jsp

            // Definindo atributos para executar a transa��o BGM0 para obter o
            // cabe�alho
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

            // Chama as Transac�es
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

                    // !@# Atribuindo a navega��o para possibilitar a correta
                    // navega��o
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
                    // Verifica se existem titulos na lista caso n�o tenha vai pra tela de inclus�o
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
	
	                            // Bean instanciado para navega��o
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

    // Configura��es para Mensagens e Telas de Erro e Sucesso
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