package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.Formatacao;
import br.gov.caixa.sigcb.bean.CedHistPermissaoBean;
import br.gov.caixa.sigcb.bean.CedenteBloquetosBean;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.CedenteConclusaoBean;
import br.gov.caixa.sigcb.bean.CedenteContasBean;
import br.gov.caixa.sigcb.bean.CedenteEletronicoBean;
import br.gov.caixa.sigcb.bean.CedenteFloatBean;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.CedenteMensagensBean;
import br.gov.caixa.sigcb.bean.CedenteParametrosBean;
import br.gov.caixa.sigcb.bean.CedenteTarifasBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;
import br.gov.caixa.sigcb.util.Util;
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
 * Componente responsável pelo controle da funcionalidade Manter Cedente >>
 * Consulta Detalhada
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>16/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteHistoricoSituacao extends CedenteConsultarEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
    	//Consultar a BGMV 
    	
    	String codCedente = request.getParameter("codigoCedente");
    	
    	CedHistPermissaoBean cedHistPermissao = new CedHistPermissaoBean();
    	cedHistPermissao.setCodCedente(Long.valueOf(codCedente));
    	//MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
    	  MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
    	
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = "BGMV" + usuarioBean.getCodigoUsuario().toUpperCase();
    	List historicoPermissao = handler.executeFixDataRecordsetTransaction(cedHistPermissao, transUser);
    	
    	CedHistPermissaoBean cedHist = new CedHistPermissaoBean();
    	
    	cedHist = (CedHistPermissaoBean) ((BeanList) historicoPermissao.get(0)).get(0);
    	
    	
    	cedHist.setCodCedente(cedHistPermissao.getCodCedente());
    	
    	BeanList histListBean = (BeanList) historicoPermissao.get(1);
    	
    	ArrayList histArrayListaBean = convertDataStructure(histListBean.iterator());
    	
    	request.getSession().setAttribute(PAGINACAO_LIST,  getPageHolder(histArrayListaBean));
        request.setAttribute(PAGINACAO_PAGE, "0");

        return PAGE_LISTAR_HISTORICO;
    }
    
    
    public ArrayList convertDataStructure(Iterator iterator) {
        ArrayList list = new ArrayList();
        while (iterator.hasNext())
            list.add(iterator.next());
        return list;
    }

    
}
