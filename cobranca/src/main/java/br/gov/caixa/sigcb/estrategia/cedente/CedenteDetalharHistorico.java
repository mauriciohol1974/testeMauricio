package br.gov.caixa.sigcb.estrategia.cedente;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;


import br.gov.caixa.iso.ISOMsg;
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
import br.gov.caixa.sigcb.ejb.session.MainframeException;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.sirot.transaction.MontaTransacao;
import br.gov.caixa.sigcb.sirot.transaction.SirotAdaptadorSIGCB;
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
public class CedenteDetalharHistorico extends CedenteConsultarEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
    	//Consultar a BGMV 

    	
    	String codCedente =  request.getParameter("codCedente");
    	String data =  request.getParameter("data");
    	String hora = request.getParameter("hora");
    	String tpAlteracao = request.getParameter("tpAlteracao");
    	String icAtual= request.getParameter("icAtual");
    	String usuario= request.getParameter("usuario");
    	CedHistPermissaoBean cedHist = new CedHistPermissaoBean();
    	cedHist.setCodCedente(Long.valueOf(codCedente));
    	cedHist.setData(data);
    	cedHist.setHora(hora);
    	cedHist.setTpAlteracao(tpAlteracao);
    	cedHist.setIcAtual(icAtual);
    	cedHist.setUsuario(usuario);
    	
    	SirotAdaptadorSIGCB acao = new br.gov.caixa.sigcb.sirot.transaction.SirotAdaptadorSIGCB();
 		MontaTransacao isoMsg = new MontaTransacao();
 		
 		String subida =  Util.zerosEsquerda(cedHist.getCodCedente(),7) +
 				Util.completaEspacos(cedHist.getData(),10) +
 				Util.completaEspacos(cedHist.getHora(),8) +
 				Util.completaEspacos(cedHist.getTpAlteracao(),1) +
 				Util.completaEspacos(cedHist.getIcAtual(),1) ;
 		
 		InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
 		ISOMsg mensagem = isoMsg.BGMW(subida,usuarioBean.getCodigoUsuario());		
		ISOMsg[] retorno = acao.executaSirot(mensagem);
		
		boolean erroSirot = false;
		///Tratamento do retorno da mensagem ISO
		// Verifica se deu erro no RETORNO
		if ( !(((String)retorno[1].getValue(120)).trim().equals("")) &&
				 !(((String)retorno[1].getValue(120)).substring(0,4).equalsIgnoreCase("0001")) &&
				 !(((String)retorno[1].getValue(120)).substring(0,4).equalsIgnoreCase("0002")) ) 
			{
			erroSirot = true;
			
			String campo = ((String) retorno[1].getValue(120) );
			Exception exc = new Exception(campo);
			throw new MainframeException(exc);
			
		}
		
		LogUtilSigcb.debug("Retorno:" + (String) retorno[1].getValue(62));
		String erro = (String) retorno[1].getValue(62);
		
		CedHistPermissaoBean retBean = this.desmontaBGMW((String)retorno[1].getValue(62), (String)retorno[2].getValue(62));
        
    	request.setAttribute("HISTORICO", retBean);
    	
        return PAGE_DETALHAR_HISTORICO;
    }
    
    
    public CedHistPermissaoBean desmontaBGMW(String retorno, String retorno2){
    	CedHistPermissaoBean historico = new CedHistPermissaoBean();
    	
    	historico.setCodCedente(Long.valueOf(retorno.substring(0, 7)));
    	historico.setData(retorno.substring(7, 17));
    	historico.setHora(retorno.substring(17, 25));
    	historico.setTipoAlteracao(retorno.substring(25, 45));
    	historico.setUsuario(retorno.substring(45, 53));
    	historico.setSitAnterior(retorno.substring(53, 63));
    	historico.setSitAtual(retorno.substring(63, 73));
    	historico.setDescricao(retorno2);
    	
    	return historico;
    }
    
   

    
}
