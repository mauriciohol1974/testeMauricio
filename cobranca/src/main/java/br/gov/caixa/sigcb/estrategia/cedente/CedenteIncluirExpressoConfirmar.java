package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.Percentual;
import br.gov.caixa.sigcb.bean.CedenteBloquetosBean;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.CedenteEletronicoBean;
import br.gov.caixa.sigcb.bean.CedenteExpressoBean;
import br.gov.caixa.sigcb.bean.CedenteFloatBean;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.CedenteParametrosBean;
import br.gov.caixa.sigcb.bean.CedentePrincipalBean;
import br.gov.caixa.sigcb.bean.CedenteTarifasBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.jsp.ComboAtribuicaoVan;
import br.gov.caixa.sigcb.util.jsp.ComboCobracaSimNao;
import br.gov.caixa.sigcb.util.jsp.ComboFormaCalculo;
import br.gov.caixa.sigcb.util.jsp.ComboGiroCaixa;
import br.gov.caixa.sigcb.util.jsp.ComboModalidadeTitulo;
import br.gov.caixa.sigcb.util.jsp.ComboPadraoArquivo;
import br.gov.caixa.sigcb.util.jsp.ComboPerfilRejeicao;
import br.gov.caixa.sigcb.util.jsp.ComboSimNao;
import br.gov.caixa.sigcb.util.jsp.ComboTipoCobranca;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Incluir Cedente >>
 * Filtro
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>11/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteIncluirExpressoConfirmar extends CedenteEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        this.configMsgSucessoErro(request);
        
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();

        InformacoesUsuarioBean usuarioBean = new InformacoesUsuarioBean();
        usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute("usuarioLdap");

        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);
        
        String ip = request.getRemoteAddr();

        CedenteExpressoBean cedenteExpresso = new CedenteExpressoBean();
        
        cedenteExpresso = (CedenteExpressoBean) request.getSession().getAttribute("INCLUIR_EXPRESSO_CONFIRMA");
        
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        
        // Obtendo dados de cabecalho
        CedenteCabecaBean cedenteCabecaBean = (CedenteCabecaBean) (new CedenteCabecaBean()).newBean();
        cedenteCabecaBean.setTipoConsulta(new Long(2)); // POR COCLI
        cedenteCabecaBean.setCodigoClienteCOCLI(cedenteExpresso.getNuCOCLI());
        cedenteCabecaBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
        cedenteCabecaBean.setOrigemConsulta(new Long(1)); // 1 - Intranet

        BeanList respostaList = handler.executeSimpleTransactionQuery(cedenteCabecaBean,TRANSACAO_CABECALHO);
        cedenteCabecaBean = (CedenteCabecaBean) respostaList.get(0);

        request.getSession().setAttribute(CEDENTE_CABECA_BEAN,  cedenteCabecaBean);
        
        cedenteExpresso.setTipoAcao("C");
        cedenteExpresso.setNoCedente(cedenteCabecaBean.getNomeFantasia());
        cedenteExpresso.setNoRazaoSocial(cedenteCabecaBean.getRazaoSocial());
        cedenteExpresso.setIdEndereco(cedenteCabecaBean.getIdEndereco());
        cedenteExpresso.setNoLogradouro(cedenteCabecaBean.getLogradouro());
        cedenteExpresso.setNuLocal(cedenteCabecaBean.getNumero());
        cedenteExpresso.setNoComplemento(cedenteCabecaBean.getComplemento());
        cedenteExpresso.setNoBairro(cedenteCabecaBean.getBairro());
        cedenteExpresso.setNoMunicipio(cedenteCabecaBean.getMunicipio());
        cedenteExpresso.setNuCep(cedenteCabecaBean.getCep());
        cedenteExpresso.setSgUF(cedenteCabecaBean.getUf());
        
        BeanList blExpresso = handler.executeSimpleTransactionQuery(cedenteExpresso,  TRANSACAO_EXPRESSO_VALIDAR);
        
        CedenteExpressoBean cedenteExpressoRet = new CedenteExpressoBean();
        
        cedenteExpressoRet = (CedenteExpressoBean) blExpresso.get(0);
       
        request.setAttribute(CedenteEstrategia.INCLUIR_EXPRESSO_BEAN_CONFIRMA, cedenteExpressoRet);
        
        return PAGE_INCLUIR_EXPRESSO_SUCESSO;
    }

  

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INCLUIR_INICIAR);
        msgBean.setStrategySucessReturn("cedente.CedenteIncluirIniciar");
        msgBean.setTitlePage(PAGE_INCLUIR_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
    
  
}
