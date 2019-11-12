package br.gov.caixa.sigcb.estrategia.servico;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Cedente
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>09/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public abstract class ServicoEstrategia extends SigcbEstrategia {
	 private static final long serialVersionUID = -7420915036218966789L;
	
	 public static final String STRATEGY_MANTER_INICIAR ="servico.SimuladorNegocialManterIniciar";
	 
	 public static final String STRATEGY_MANTER_FILTRO ="servico.SimuladorNegocialManterFiltro";

	 public static final String PAGE_SIMULAR_FILTRO = "servico/simular_tarifa_filtro";
	 
	 public static final String PAGE_SIMULAR_DETALHE = "servico/servico_importarSISNG_tarifas";
	 
	 public static final String PAGE_BENEFICIARIO_DETALHE = "servico/servico_beneficiario_tarifa";
	 
	 public static final String PAGE_SUCESSO="servico/cedente_importarSISNG_sucesso";
	 
	 public static final String PAGE_ERRO="servico/simuladorErro";
	 
	 public static final String  PAGE_ERRO_FILTRO="servico/simuladorErroFiltro";
	 
	 public static final String PAGE_SIMULAR_TARIFAS = "";
	 
	 public static final String CEDENTE_CABECA_BEAN = "cedenteCabecBean";
	 
	 public static final String FILTRO_BEAN = "simulacaoFiltroBean";
	 
	 public static final String MSG_BEAN = "msgBean";
	 
	 public static final String DESC_CRITICAS="decsricaoCriticas";
	 
	
	 public String getCustomizedHTMLMessagePageName() {
	        return PAGE_ERRO;
	 }
	 
  
}
