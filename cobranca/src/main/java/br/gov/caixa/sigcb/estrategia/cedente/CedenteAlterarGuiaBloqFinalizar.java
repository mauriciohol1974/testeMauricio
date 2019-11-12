package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.Currency;
import br.com.politec.sao.util.Money;
import br.gov.caixa.sigcb.bean.CedenteBloquetosBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.regras.historicoGuias.HistoricoGuia;
import br.gov.caixa.sigcb.regras.historicoGuias.HistoricoGuiaSimpleFactory;
import br.gov.caixa.sigcb.util.Util;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Alterar Cedente - Guia
 * Bloquetos
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>15/10/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteAlterarGuiaBloqFinalizar extends CedenteAlterarEstrategia {

    private HistoricoGuia historicoGuiaBloquetos = HistoricoGuiaSimpleFactory.createHistoricoGuiaLogger(HistoricoGuia.GUIA_BLOQUETOS);

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        this.configMsgSucessoErro(request);

        CedenteBloquetosBean bloqBean = (CedenteBloquetosBean) (new CedenteBloquetosBean()).getRequestBean(request);
        CedenteBloquetosBean resposta = (CedenteBloquetosBean) (new CedenteBloquetosBean()).newBean();

        // seta novamente o bean para caso aconteca algum problema os dados nao
        // se perderem
        request.setAttribute(CEDENTE_BLOQUETOS_BEAN, bloqBean);

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        if (bloqBean.getFormasAvisoProtesto() == null
            || bloqBean.getFormasAvisoProtesto().trim().equals("")) {
            bloqBean.setFormasAvisoProtesto("N");
        }
        if (bloqBean.getFormasAvisoVencido() == null
            || bloqBean.getFormasAvisoVencido().trim().equals("")) {
            bloqBean.setFormasAvisoVencido("N");
        }
        
        

        bloqBean.setTipoAcao(ALTERACAO);
        //bloqBean.setEnvioSMS("N"); // Fixo N enquanto não estiver o envio de SMS
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        
        if (!usuarioBean.getNomeGrupo().equalsIgnoreCase("GCBADM")){
        	
        	CedenteBloquetosBean bloqBeanConsulta = (CedenteBloquetosBean) (new CedenteBloquetosBean()).newBean();
            
        	bloqBeanConsulta = (CedenteBloquetosBean) bloqBeanConsulta.getRequestBean(request);
        	bloqBeanConsulta.setTipoConsulta("C"); // C - dados cadastrais
            String transUser = TRANSACAO_CONSULTAR_BLOQUETO + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList beanListBloq = handler.executeSimpleTransactionQuery(bloqBeanConsulta,transUser);
            bloqBeanConsulta = (CedenteBloquetosBean) beanListBloq.get(0);
            
        	bloqBean.setQtdeBolMes(bloqBeanConsulta.getQtdeBolMes());
        	
        	bloqBean.setValorMinULCCA(bloqBeanConsulta.getValorMinULCCA());
        	bloqBean.setValorMaxULCCA(bloqBeanConsulta.getValorMaxULCCA());
        }
        
        
        String transUser = TRANSACAO_INCLUIR_ALTERAR_BLOQUETO + usuarioBean.getCodigoUsuario().toUpperCase();
        
        BeanList blResposta = handler.executeSimpleTransactionQuery(bloqBean,    transUser);

        // Verifica criticas
        if (blResposta.size() > 0) {
            resposta = (CedenteBloquetosBean) blResposta.get(0);
        } else {
            // Obtendo dados da guia geral para saber tipo de Cobranca
            // CedenteGeralBean geralBeanTransacoesGuias = (CedenteGeralBean)
            // (new
            // CedenteGeralBean()).getSessionBean(request,CEDENTE_GERAL_BEAN_TRANSACOES_GUIAS
            // );
            // this.historicoGuiaBloquetos.logDadosGuia(geralBeanTransacoesGuias,
            // handler, TRANSACAO_FINALIZAR_ALTERACAO_PARTE_2);
            LinkedList<HistoricoGuia> listaGuiasAlteradas = (LinkedList<HistoricoGuia>) request.getSession()
                    .getAttribute(LISTA_GUIAS_ALTERADAS);
            listaGuiasAlteradas.add(this.historicoGuiaBloquetos);
        }

        return CedenteAlterarGuiaControle.proximaGuia(request,
                resposta.getDescricaoCriticas(),
                PAGE_ALTERAR_BLOQUETOS,
                PAGE_ALTERAR_PRINCIPAL);
    }

}
