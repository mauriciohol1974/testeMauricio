package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.Currency;
import br.com.politec.sao.util.Formatacao;
import br.com.politec.sao.util.Money;
import br.com.politec.sao.util.PageHolder;
import br.gov.caixa.sigcb.bean.CedenteConclusaoBean;
import br.gov.caixa.sigcb.bean.CedenteConteudoListaBean;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.LogCedenteGuiasBean;
import br.gov.caixa.sigcb.bean.ValidacaoReativacaoCedenteBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.regras.alteracao.guias.cedente.AlteracaoGuiasManager;
import br.gov.caixa.sigcb.regras.historicoGuias.HistoricoGuia;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.Util;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Alterar Cedente - Guia
 * Conclusao
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>15/10/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteAlterarGuiaConcFinalizar extends CedenteAlterarEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        try {
            this.configMsgSucessoErro(request);

            CedenteConclusaoBean conclusaoBean = (CedenteConclusaoBean) (new CedenteConclusaoBean()).getRequestBean(request);
            CedenteConclusaoBean resposta = (CedenteConclusaoBean) (new CedenteConclusaoBean()).newBean();

            // seta novamente o bean para caso aconteca algum problema os
            // dados nao se perderem
            request.setAttribute(CEDENTE_CONCLUSAO_BEAN, conclusaoBean);

            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

            // setando dados no bean que nao vem da tela
            conclusaoBean.setTipoAcao(ALTERACAO);
            conclusaoBean.setCodigoUsuario(this.getCodigoUsuario(request));

            CedenteConteudoListaBean beanFiltro = (CedenteConteudoListaBean) (new CedenteConteudoListaBean()).getSessionBean(request,
                    ALTERAR_FILTRO_BEAN);

            String situacaoEletronico = (String) (request.getSession().getAttribute(SITUACAO_ELETRONICO));

            LogUtilSigcb.info("SITUACAO =====>" + situacaoEletronico);

            if ("I".equals(situacaoEletronico)) {
                ValidacaoReativacaoCedenteBean validaBean = new ValidacaoReativacaoCedenteBean();
                validaBean.setCodigoUsuario(conclusaoBean.getCodigoUsuario());
                validaBean.setCpfCnpjCedente(conclusaoBean.getCpfCnpj());
                validaBean.setNsuTransacao(conclusaoBean.getNsuTransacao());
                InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
                String transUser = "BG68" + usuarioBean.getCodigoUsuario().toUpperCase();
                
                BeanList a = handler.executeSimpleTransactionQuery(validaBean,transUser);
                try {
                    ValidacaoReativacaoCedenteBean retorno = (ValidacaoReativacaoCedenteBean) a.get(0);
                    if (retorno.getDescricao() != null  && !retorno.getDescricao().equals("")) {
                        request.setAttribute(CedenteEstrategia.DESC_CRITICAS,  retorno.getDescricao().trim());
                        return PAGE_ALTERAR_CONCLUSAO;
                    }
                } catch (Exception exc) {
                }
            }

            // BG22
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CONSULTAR_ITENS_EXCEPCIONADOS + usuarioBean.getCodigoUsuario().toUpperCase();
            
            List listExcep = handler.executeFixDataRecordsetTransaction(conclusaoBean,	transUser);
            LogUtilSigcb.info(listExcep.toString());
            LogUtilSigcb.info(listExcep.get(0).toString());
            CedenteConclusaoBean bExcep = (CedenteConclusaoBean) ((BeanList) listExcep.get(0)).get(0);
            LogUtilSigcb.info(bExcep.toString());

            BeanList blExcepcionacao = (BeanList) listExcep.get(1);

            // se ocorrer erro volta pra mesma pagina mostrando a mensagem
            if (!"".equals(bExcep.getDescricaoCriticas())) {
                request.setAttribute(CedenteEstrategia.DESC_CRITICAS,
                        bExcep.getDescricaoCriticas());
                return PAGE_ALTERAR_CONCLUSAO;
            }

            if (blExcepcionacao.size() > 0) {
                // Itens Excepcionados
                ArrayList alExcepcionacao = this.convertDataStructure(blExcepcionacao.iterator());

                request.getSession().setAttribute(PAGINACAO_LIST,
                        getPageHolder(alExcepcionacao));
                request.setAttribute(PAGINACAO_PAGE, "0");
                request.setAttribute(PAGINACAO_PAGEANTERIOR, "0");

                if (this.indicaItemSemAlcada(alExcepcionacao)) {
                    request.setAttribute(INDICA_ITEM_SEM_ALCADA,
                            new Boolean(true));
                }

                // Excepcionacao Vigente -- BG28
                transUser = TRANSACAO_CONSULTAR_EXCEPCIONACAO_VIGENTE + usuarioBean.getCodigoUsuario().toUpperCase();
                List listExcepVigente = handler.executeFixDataRecordsetTransaction(conclusaoBean,     		transUser);

                BeanList blExcepVigente = (BeanList) listExcepVigente.get(1);
                if (blExcepVigente.size() > 0) {
                    // se tiver a lista pega os dados fixos
                    CedenteConclusaoBean beanExcepVigente = (CedenteConclusaoBean) ((BeanList) listExcepVigente.get(0)).get(0);
                    conclusaoBean.setNumeroPendenciaVigente(beanExcepVigente.getNumeroPendenciaVigente());
                    conclusaoBean.setNumeroReiteracaoVigente(beanExcepVigente.getNumeroReiteracaoVigente());

                    ArrayList alExcepVigente = new ArrayList();
                    // se veio não veio 0, existe excepcionacao vigente
                    if (!new Long(0).equals(beanExcepVigente.getNumeroPendenciaVigente())) {
                        alExcepVigente = this.convertDataStructure(blExcepVigente.iterator());
                    }

                    PageHolder phExcepVigente = getPageHolder(alExcepVigente);
                    phExcepVigente.setPageSize(5);

                    request.getSession().setAttribute(PAGINACAO_EXCVIG_LIST,
                            phExcepVigente);
                    request.setAttribute(CEDENTE_CONCLUSAO_BEAN, conclusaoBean);
                }

                return PAGE_ALTERAR_PENDENCIAS;
            }

            // BGI0
            LogCedenteGuiasBean logCedenteGuiasBean = this.executaTransacoesGuias(request, handler,  conclusaoBean.getNumeroPendencia());

            // BGH8

            // TODO Não tirar mais. Está sendo Resolvido no MF
            if (logCedenteGuiasBean != null)
                logCedenteGuiasBean.setApelido("");

            String ip = request.getRemoteAddr();
            this.executaTransacoesDeFinalizacao(logCedenteGuiasBean,
                    conclusaoBean,
                    handler,ip);

            request.setAttribute(CEDENTE_CONCLUSAO_BEAN, conclusaoBean);

            return CedenteAlterarGuiaControle.proximaGuia(request,
                    resposta.getDescricaoCriticas(),
                    PAGE_ALTERAR_CONCLUSAO,
                    PAGE_SUCESSO);
        } catch (Exception ex) {
            LogUtilSigcb.debug("Excecao alterar conclusao", ex);
            throw ex;
        }
    }

    // Tratando o BeanList para setar valores de excepcionacao corretamente
    public ArrayList convertDataStructure(Iterator iterator) {
        ArrayList list = new ArrayList();
        while (iterator.hasNext()) {
            CedenteConclusaoBean bean = (CedenteConclusaoBean) iterator.next();

            // seta atributo correto dependendo do tipo recebido
            switch (bean.getTipo().intValue()) {
            case 1: // Valor
            case 2: // Valor com Percentual (Percentual ja setado
                // automaticamente)
                // transforma o numero nao formatado para Money
                Money tempMoneyOrig = new Money(Util.zerosEsquerda(bean.getNumeroOriginal(),
                        15),
                        2,
                        Currency.real());
                Money tempMoneyExcp = new Money(Util.zerosEsquerda(bean.getNumeroExcepcionado(),
                        15),
                        2,
                        Currency.real());
                bean.setValorOriginal(tempMoneyOrig);
                bean.setValorExcepcionado(tempMoneyExcp);
                break;

            case 3: // Alfa
                break;

            case 4: // Conta
                bean.setContaOriginal(this.formataConta(bean.getTextoOriginal()));
                bean.setContaExcepcionado(this.formataConta(bean.getTextoExcepcionado()));
                break;

            case 5: // Cpf / Cnpj
                String cpfCnpjOriginal = bean.getTextoOriginal();
                String cpfCnpjExcepcionado = bean.getTextoExcepcionado();

                if (cpfCnpjOriginal.charAt(0) == '1') { // Pessoa Fisica -
                    // Cpf
                    bean.setTextoOriginal(Formatacao.formataCPF(cpfCnpjOriginal.substring(1)));
                } else {
                    bean.setTextoOriginal(Formatacao.formataCNPJ(cpfCnpjOriginal.substring(1)));
                }

                if (cpfCnpjExcepcionado.charAt(0) == '1') { // Pessoa Fisica
                    // - Cpf
                    bean.setTextoExcepcionado(Formatacao.formataCPF(cpfCnpjExcepcionado.substring(1)));
                } else {
                    bean.setTextoExcepcionado(Formatacao.formataCNPJ(cpfCnpjExcepcionado.substring(1)));
                }

                break;

            default:
                break;
            }

            list.add(bean);
        }
        return list;
    }

    // Retorna true se houver alguma excepcionacao que o usuario nao tem
    // alcada
    private boolean indicaItemSemAlcada(ArrayList alExcepcionacao) {
        for (int i = 0; i < alExcepcionacao.size(); i++) {
            CedenteConclusaoBean conclusaoBean = (CedenteConclusaoBean) alExcepcionacao.get(i);
            if ("S".equals(conclusaoBean.getItemSemAlcada())) {
                return true;
            }
        }

        return false;
    }

    private LogCedenteGuiasBean executaTransacoesGuias(HttpServletRequest request,
            MainFrameTransactionsSigcbEjb handler,
            Long numeroPendencia) throws Exception {
        LogUtilSigcb.debug("Entrando em executaTransacoesGuias");
        CedenteGeralBean geralBeanTransacoesGuias = (CedenteGeralBean) (new CedenteGeralBean()).getSessionBean(request,
                CEDENTE_GERAL_BEAN_TRANSACOES_GUIAS);
        LinkedList<HistoricoGuia> listaGuiasAlteradas = (LinkedList<HistoricoGuia>) request.getSession()
                .getAttribute(LISTA_GUIAS_ALTERADAS);
        AlteracaoGuiasManager alteracaoGuiasManager = new AlteracaoGuiasManager();
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_FINALIZAR_ALTERACAO_PARTE_2 + usuarioBean.getCodigoUsuario().toUpperCase();
        
        LogCedenteGuiasBean logCedenteGuiasBean = alteracaoGuiasManager.executarLogGuiasAlteradas(listaGuiasAlteradas,
                geralBeanTransacoesGuias,
                handler,
                transUser,
                numeroPendencia);
        LogUtilSigcb.debug("Saindo de executaTransacoesGuias -> logCedenteGuiasBean = "
                           + logCedenteGuiasBean);
        return logCedenteGuiasBean;
    }

    private BeanList executaTransacoesDeFinalizacao(LogCedenteGuiasBean logCedenteGuiasBean,
            CedenteConclusaoBean conclusaoBean,
            MainFrameTransactionsSigcbEjb handler, String ip) throws Exception {
    	 AlteracaoGuiasManager alteracaoGuiasManager = new AlteracaoGuiasManager();
    	 return alteracaoGuiasManager.executaTransacoesDeFinalizacao(logCedenteGuiasBean, conclusaoBean,  handler, ip);
    }
}