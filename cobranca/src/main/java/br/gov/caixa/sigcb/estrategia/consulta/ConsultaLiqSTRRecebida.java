package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.DdaTituloDiaBean;
import br.gov.caixa.sigcb.bean.FiltroPesquisa;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.LiquidacoesRejeitadaBean;
import br.gov.caixa.sigcb.bean.LiquidacoesSTRBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.jsp.ComboTipoMeioLiquidacao;
import br.gov.caixa.sigcb.util.jsp.PaginacaoTag;


/**
 * <B>Projeto: SIGCB</B><BR>
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>Abril/2013</DD>
 * </DL>
 * 
 * @author Maurício Assis de Holanda
 */
public class ConsultaLiqSTRRecebida extends ConsultaLiqStrManterEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            // System.out.println("#$% comeco " + this.getClass().getName());

            // Configurações para Mensagens e Telas de Erro e Sucesso
            configMsgSucessoErro(request);
            // Obtem informação para definir se o request veio de voltar ou se o
            // fluxo é normal
            String fluxo = getFluxo(request);
            // Obtem o bean da funcionalidade
            LiquidacoesSTRBean filtroBean = new LiquidacoesSTRBean();
            if (fluxo.equals(FLUXO_NORMAL)) {
                filtroBean = (LiquidacoesSTRBean) filtroBean.getRequestBean(request);
            } else {
                filtroBean = (LiquidacoesSTRBean) filtroBean.getSessionBean(request, FILTRO_BEAN);
            }

            FiltroPesquisa filtroPesquisa = new FiltroPesquisa();
            filtroPesquisa.setDataIni((String)request.getParameter("dataIniFiltro"));		
            filtroPesquisa.setDataFim((String)request.getParameter("dataFimFiltro"));
            filtroPesquisa.setCedente((String)request.getParameter("cedenteFiltro"));
            filtroPesquisa.setBanco((String)request.getParameter("bancoFiltro"));
            filtroPesquisa.setIspb((String)request.getParameter("ispbFiltro"));
            filtroPesquisa.setAgencia((String)request.getParameter("agenciaFiltro"));
            filtroPesquisa.setPagina((String)request.getParameter("paginaFiltro"));
            
            
            String banco = filtroBean.getBanco();
            String dtRecebimento = filtroBean.getDataRecebimento();
            String hrRecebimento = filtroBean.getHoraRecebimento();
            String sequencial= filtroBean.getSequencial();
            Long bancoOrigem = filtroBean.getBancoOrigem();
            Long ispbOrigem = filtroBean.getISPBOrigem();
            Long agenciaOrigem = filtroBean.getAgenciaOrigem();
            
            Date dataPesq = filtroBean.getDataPesq();
            Date dataPesqFinal = filtroBean.getDataPesqFinal();
            
            String pagina = String.valueOf(filtroBean.getPagina());
            
            
            // Chamada ao Mainframe
            String acaoExecutar = filtroBean.getAcaoExecutar();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            BeanList fixoBeanList;
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CONSULTAR_RECEBIDAS + usuarioBean.getCodigoUsuario().toUpperCase();
            fixoBeanList = handler.executeSimpleTransactionQuery(filtroBean,  transUser);
            
            filtroBean = (LiquidacoesSTRBean) fixoBeanList.get(0);
            
            filtroBean.setBanco(banco);
            filtroBean.setDataRecebimento(dtRecebimento);
            filtroBean.setHoraRecebimento(hrRecebimento);
            filtroBean.setSequencial(sequencial);
            filtroBean.setDataPesq(dataPesq);
            filtroBean.setDataPesqFinal(dataPesqFinal);
            
            
            
            request.getSession().setAttribute("pagina", pagina);
            request.getSession().setAttribute(FILTRO_BEAN,filtroBean );
            request.getSession().setAttribute(DATA_BEAN,filtroBean );
            request.getSession().setAttribute("FILTRO_PESQUISA", filtroPesquisa);
            
        } catch (Exception ex) {
            // ex.printStackTrace();
            throw ex;
        }

        // Nome da JSP a ser chamada (nao possui o .jsp)
        return PAGE_CONSULTAR_RECEBIDAS;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INICIAR_RECEBIDAS);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

    //
    // Metodo sobrescrito para setar atributo registro
    //
    public ArrayList convertDataStructure(Iterator iterator) {
        ArrayList list = new ArrayList();
        while (iterator.hasNext())
            list.add(iterator.next());
        return list;
    }
}
