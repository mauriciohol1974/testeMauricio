package br.gov.caixa.sigcb.estrategia.parametro;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Agrupamento de
 * Servicos
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>28/08/2004</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */

public abstract class ConsultaCEPEstrategia extends SigcbEstrategia {

    public static final String STRATEGY_INICIAR = "parametro.ConsultaCEPIniciar";

    public static final String STRATEGY_CONSULTAR = "parametro.ConsultaCEPExecutar";

    public static final String MSG_BEAN = "msgBean";

    public static final String DATA_BEAN = "cepBean";

    public static final String FILTRO_BEAN = "filtroAgrupBean";

    public static final String PAGE_FILTRO = "parametro/cep_pesquisar";

    public static final String PAGE_EXIBECEP = "parametro/cep_exibir";

    public static final String PAGE_ERRO = "parametro/cep_erro";

    public static final String TRANSACAO_CONSULTAR = "BGCP";
    
    public static final String PAGE_TITLE = "Consulta de CEP ";

    

    // Define tela customizada de erro
    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }

}
