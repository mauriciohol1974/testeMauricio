package br.gov.caixa.sigcb.estrategia.comum;

import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Procurar Cep
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>28/08/2004</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */

public abstract class ProcurarCepEstrategia extends SigcbEstrategia {

    public static final String STRATEGY_CONSULTAR = "comum.ProcurarCepIniciar";

    public static final String PAGE_TITLE_CONSULTAR = "Pesquisa de Cep";

    public static final String MSG_BEAN = "msgBean";

    public static final String DATA_BEAN = "cepBean";

    public static final String PAGE_CONSULTAR = "comum/procurar_cep";

    public static final String PAGE_ERRO = "comum/procurar_cep_erro";

    public static final String TRANSACAO_CONSULTAR = "BGM3";

    // Define tela customizada de erro
    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO;
    }
}
