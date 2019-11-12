package br.gov.caixa.sigcb.regras.alteracao.guias.cedente;

import java.util.List;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteConclusaoBean;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.FinalizarAlteracaoCedenteConclusaoBean;
import br.gov.caixa.sigcb.bean.LogCedenteGuiasBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.ejb.session.MainframeException;
import br.gov.caixa.sigcb.regras.historicoGuias.HistoricoGuia;
import br.gov.caixa.sigcb.regras.historicoGuias.defazer.DesfazerCedenteGuias;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * @author p561913 - David L. M. Torneiros
 * @created 21/02/2007 Classe que atua como um "Facade", encapsulando os
 *          processos de Atualizacao de cada Guia e bem como o de conclusao.
 */
public class AlteracaoGuiasManager {

    /**
     * Realiza do processo de criacao do Log somente da Guias que foram abertas
     * pelo usuario e tiveram seu dados Confirmados em suas respectivas telas.
     * As Guias que se encaixam nesta situacao, terão seus respctivos objetos
     * <code>HistoricoGuia</code> presentes na lista de alteracoes.
     * 
     * @param listaGuiasAlteradas -
     *            Uma lista contendo somente os <code>HisotricoGuia</code> das
     *            Guias que foram abertas e seus dados confirmados. Estas
     *            sofrerao processo de atualizacao.
     * @param geralBeanTransacoesGuias -
     *            Bean contendo os dados necessarios para executar a transacao
     *            de criacao de Log.
     * @param handler -
     *            O Handler, executor das trasacoes.
     * @param transaction -
     *            Uma String contendo o nome da Transacao responsavel pelo Log
     *            das Guias.
     * @param numeroPendencia -
     *            O Numero
     * @return Um <code>LogCedenteGuiasBean</code> contendo os dados de
     *         retorno da transacao.
     * @throws Exception
     */
    public LogCedenteGuiasBean executarLogGuiasAlteradas(List<HistoricoGuia> listaGuiasAlteradas,
            CedenteGeralBean geralBeanTransacoesGuias,
            MainFrameTransactionsSigcbEjb handler,
            String transaction,
            Long numeroPendencia) throws Exception {
        LogCedenteGuiasBean logCedenteGuiasBean = null;
        
        String listaEnvio[] = new String[13];
        
        for (HistoricoGuia historicoGuia : listaGuiasAlteradas) {
        	if (listaEnvio[Integer.parseInt(String.valueOf(historicoGuia.getOpcao()))]!="S"){
                if (historicoGuia.getOpcao() == HistoricoGuia.GUIA_CEDENTE_ELETRONICO) {
                    // if (historicoGuia instanceof HistoricoGuiaCedenteEletronico)
                    // {
                    // A ser usado na BGH8 - Finalizazao Guia Conclusao
                    logCedenteGuiasBean = (LogCedenteGuiasBean) historicoGuia.logDadosGuia(geralBeanTransacoesGuias,
                            handler,
                            transaction,
                            numeroPendencia)
                            .get(0);
                } else {
                    historicoGuia.logDadosGuia(geralBeanTransacoesGuias,
                            handler,
                            transaction,
                            numeroPendencia);
                }
                listaEnvio[Integer.parseInt(String.valueOf(historicoGuia.getOpcao()))]="S";

        	}
            
           
            

        }

        return logCedenteGuiasBean;
    }

    /**
     * Metodo responsavel pela execucao dos passos de finalizacao das alteracoes
     * realizadas nas Guias.
     * 
     * @param logCedenteGuiasBean -
     *            Contem o campo <blockquote>apelido</blockquote> a ser usado
     *            na transacao BGH8, e obtido ao modificar a Guia de Cedente
     *            Eletronico.
     * @param conclusaoBean -
     *            Bean que contem os demais dados para a realizacao da tarefa.
     * @param handler -
     *            Um handler para execucao da transacao.
     * @return - Um <code>BeanList</code> contendo o retorno da transacao.
     * @throws Exception
     */
    public BeanList executaTransacoesDeFinalizacao(LogCedenteGuiasBean logCedenteGuiasBean,
            CedenteConclusaoBean conclusaoBean,
            MainFrameTransactionsSigcbEjb handler, String ip) throws Exception {

        FinalizarAlteracaoCedenteConclusaoBean finalizarAlteracaoCedenteConclusaoBean = (FinalizarAlteracaoCedenteConclusaoBean) (new FinalizarAlteracaoCedenteConclusaoBean()).newBean();
        finalizarAlteracaoCedenteConclusaoBean.setNsuTransacao(conclusaoBean.getNsuTransacao());
        finalizarAlteracaoCedenteConclusaoBean.setCodigoUsuario(conclusaoBean.getCodigoUsuario());
        finalizarAlteracaoCedenteConclusaoBean.setCpfCnpj(conclusaoBean.getCpfCnpj());
        finalizarAlteracaoCedenteConclusaoBean.setNomeCedente(conclusaoBean.getNomeCedente());
        finalizarAlteracaoCedenteConclusaoBean.setIdEndereco(conclusaoBean.getIdEndereco());
        finalizarAlteracaoCedenteConclusaoBean.setNumeroPendencia(conclusaoBean.getNumeroPendencia());
        finalizarAlteracaoCedenteConclusaoBean.setApelido(logCedenteGuiasBean == null
                ? "      "
                : logCedenteGuiasBean.getApelido());
        finalizarAlteracaoCedenteConclusaoBean.setIp(ip);
        BeanList beanList;
        DesfazerCedenteGuias desfazerCedenteGuias;
        try {
        	String transUser =  br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia.TRANSACAO_FINALIZAR_ALTERACAO_PARTE_3 + conclusaoBean.getCodigoUsuario().toUpperCase();
            beanList = handler.executeSimpleTransactionQuery(finalizarAlteracaoCedenteConclusaoBean,transUser);

        } catch (MainframeException e) {
            LogUtilSigcb.error(">>>Erro durante o Processo de finalizacao das alteracoes da Guias<<<");
            LogUtilSigcb.error("Mensagem de erro : " + e.getMessage());
            LogUtilSigcb.error(">>>Desfazendo as Alteracoes<<<");
            desfazerCedenteGuias = new DesfazerCedenteGuias(conclusaoBean.getNsuTransacao(),
                    conclusaoBean.getCodigoUsuario(),
                    conclusaoBean.getNumeroPendencia(),
                    DesfazerCedenteGuias.OPCAO_DESFAZER_BGH8);
            desfazerCedenteGuias.desfazer(handler);
            throw e;

        }

        return beanList;
    }
}