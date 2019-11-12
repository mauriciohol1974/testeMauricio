package br.gov.caixa.sigcb.regras.historicoGuias;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.LogCedenteGuiasBean;
import br.gov.caixa.sigcb.bean.SigcbBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.ejb.session.MainframeException;
import br.gov.caixa.sigcb.regras.historicoGuias.defazer.DesfazerCedenteGuias;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * @author p561913 - David L. M. Torneiros
 * @created 23/02/2007 Classe abstrata, baseada no pattern "Template Method"
 *          para criacao do Log de alteracao do dados de uma Guia (Geral, Float,
 *          Tarifas etc) de um Cedente. Suas classes filhas, devem representar
 *          uma determinada Guia e têm a responsabilidade de saber montar o bean
 *          <code>LogCedenteGuiasBean</code> afim de ser usado pelo "Template
 *          Method". Classe responsavel pela chamada da transacao
 */
public abstract class HistoricoGuia {

    public static final long GUIA_GERAL = 1;

    public static final long GUIA_CONTAS = 2;

    public static final long GUIA_CEDENTE_ELETRONICO = 3;

    public static final long GUIA_CEDENTE_ELETRONICO_AGRUP = 4;

    public static final long GUIA_BLOQUETOS = 5;

    public static final long GUIA_TARIFA = 6;
    
    public static final long GUIA_PARAMETRO = 11;
    
    public static final long GUIA_PERMISSAO = 12;

    public static final long GUIA_FLOAT = 7;

    public static final long GUIA_MSG_BLOQUETOS = 8;

    private long opcao;

    /**
     * Template Method responsavel por gerar o log das alteracoes das guias do
     * cedente (BGI0), bem como requisitar o procedimento de "Desfazer"
     * (transacao BGH7) caso algum erro ocorra.
     * 
     * @param bean -
     *            Bean proveniente da Guia a ser realizado o Log e que sera
     *            passado para o Metodo abstrato "montarBean" (implementado nas
     *            classes filhas) afim de se obter uma instancia de
     *            <code>LogCedenteGuiasBean</code> com os dados necessarios
     *            para a operacao.
     * @param handler -
     *            o Handler para a chamada das transacoes.
     * @param transaction -
     *            Uma String contendo o nome da Transacao a ser utilizada na
     *            criacao do log das Guias.
     * @param numeroPendencia -
     *            O numero de Pendencia caso ocorra uma "excepcionacao" e que
     *            sera usado na operacao de desfazer "BGH7", caso algum problema
     *            ocorra.
     * @return -Um <code>BeanList</code> contendo o retorno da transacao
     *         executada.
     * @throws Exception
     */
    public final BeanList logDadosGuia(SigcbBean bean,
            MainFrameTransactionsSigcbEjb handler,
            String transaction,
            Long numeroPendencia) throws Exception {
        LogCedenteGuiasBean logCedenteGuiasBean = this.montarBean(bean);
        LogUtilSigcb.info("Executando o logDadosGuia em ==> " + this.getClass());
        LogUtilSigcb.info("LogCedenteGuiasBean ==>" + logCedenteGuiasBean);
        // LogUtilSigcb.info(" opcao ==>" + logCedenteGuiasBean.getOpcao());
        // LogUtilSigcb.info(" codigoCedente ==>" +
        // logCedenteGuiasBean.getCodigoCedente());
        // LogUtilSigcb.info(" codigoUsuario ==>" +
        // logCedenteGuiasBean.getCodigoUsuario());
        // LogUtilSigcb.info(" nsuTransacao ==>" +
        // logCedenteGuiasBean.getNsuTransacao());
        BeanList beanList = null;

        // this.opcao = logCedenteGuiasBean.getOpcao();
        try {
            beanList = handler.executeSimpleTransactionQuery(logCedenteGuiasBean,
                    transaction);
            if (beanList != null) {
                LogUtilSigcb.info("==== Retorno BGI0 ====");
                LogUtilSigcb.info("Tamanho = " + beanList.size());
                LogUtilSigcb.info("campo apelido ==> "
                                  + (beanList.size() > 0
                                          ? ((LogCedenteGuiasBean) beanList.get(0)).getApelido()
                                          : ""));
                LogUtilSigcb.info("==== Fim Retorno BGI0 ===");
            } else
                LogUtilSigcb.info("==== Retorno BGI0 === > O BeanList é NULO");
        } catch (MainframeException e) {
            LogUtilSigcb.error(">>>Erro ao atualizar Dados da Guia<<<");
            LogUtilSigcb.error(e.getMessage());
            LogUtilSigcb.error(">>>Desfazendo as Alteracoes<<<");
            DesfazerCedenteGuias desfazerCedenteGuias = new DesfazerCedenteGuias(logCedenteGuiasBean.getNsuTransacao(),
                    logCedenteGuiasBean.getCodigoUsuario(),
                    numeroPendencia,
                    DesfazerCedenteGuias.OPCAO_DESFAZER_BGI0);
            desfazerCedenteGuias.desfazer(handler);
            throw e;
        }

        return beanList;
    }

    /**
     * Método abstrato que deve ser implementado pelas classes filhas,
     * responsavel por montar o bean <code>LogCedenteGuiasBean</code> de
     * acordo com bean particular de cada Guia.
     * 
     * @param bean -
     *            O bean particular de uma guia e que contem os dados
     *            necessarios para montar corretamente um
     *            <code>LogCedenteGuiasBean</code>
     * @return - Um <code>LogCedenteGuiasBean</code> a ser usado no processo
     *         de criacao do Log.
     * @throws Exception
     */
    protected abstract LogCedenteGuiasBean montarBean(SigcbBean bean)
            throws Exception;

    public long getOpcao() {
        return this.opcao;
    }

    public void setOpcao(long opcao) {
        this.opcao = opcao;
    }
}
