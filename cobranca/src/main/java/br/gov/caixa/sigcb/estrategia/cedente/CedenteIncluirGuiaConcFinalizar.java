package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.Currency;
import br.com.politec.sao.util.Formatacao;
import br.com.politec.sao.util.Money;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.CedenteConclusaoBean;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.Util;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Incluir Cedente - Guia
 * Conclusao
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>18/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteIncluirGuiaConcFinalizar extends CedenteIncluirEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        try {

            this.configMsgSucessoErro(request);
            request.setAttribute("bloqueio", "N");
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

            CedenteConclusaoBean conclusaoBean = (CedenteConclusaoBean) (new CedenteConclusaoBean()).getRequestBean(request);
            CedenteConclusaoBean resposta = (CedenteConclusaoBean) (new CedenteConclusaoBean()).newBean();

            // seta novamente o bean para caso aconteca algum problema os
            // dados nao se perderem
            request.setAttribute(CEDENTE_CABECA_BEAN, conclusaoBean);

            CedenteGeralBean beanFiltro = (CedenteGeralBean) request.getSession()
                    .getAttribute(CedenteEstrategia.INCLUIR_FILTRO_BEAN);
            beanFiltro.setCodigoCedente(conclusaoBean.getCodigoCedente());
            request.getSession()
                    .setAttribute(CedenteEstrategia.INCLUIR_FILTRO_BEAN,
                            beanFiltro);

            // Consulta Itens Excepcionados
            conclusaoBean.setTipoAcao("I");
            conclusaoBean.setCodigoUsuario(this.getCodigoUsuario(request));
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CONSULTAR_ITENS_EXCEPCIONADOS + usuarioBean.getCodigoUsuario().toUpperCase();
            List listExcep = handler.executeFixDataRecordsetTransaction(conclusaoBean,
            		transUser);
            LogUtilSigcb.info("RETORNO TRANSACAO BG22 => " + listExcep.size());
            CedenteConclusaoBean bExcep = (CedenteConclusaoBean) ((BeanList) listExcep.get(0)).get(0);
            LogUtilSigcb.info("BEAN CONCLUSAO => " + bExcep);
            BeanList blExcepcionacao = (BeanList) listExcep.get(1);
            LogUtilSigcb.info("BEAN EXCEPCIONACAO => " + blExcepcionacao);
            
            
            // se tem mesagem e lista de excepcionação 
            if (!"".equals(bExcep.getDescricaoCriticas()) && blExcepcionacao.size() > 0) {
            	
                request.setAttribute(CedenteEstrategia.DESC_CRITICAS, bExcep.getDescricaoCriticas());
                ArrayList alExcepcionacao = this.convertDataStructure(blExcepcionacao.iterator());

                request.getSession().setAttribute(PAGINACAO_LIST,
                        getPageHolder(alExcepcionacao));
                request.setAttribute(PAGINACAO_PAGE, "0");
                request.setAttribute(PAGINACAO_PAGEANTERIOR, "0");

                if (this.indicaItemSemAlcada(alExcepcionacao)) {
                    request.setAttribute(INDICA_ITEM_SEM_ALCADA,
                            new Boolean(true));
                }
                request.setAttribute("bloqueio", "S");
                return PAGE_INCLUIR_PENDENCIAS;
            }            
            

            // se ocorrer erro volta pra mesma pagina mostrando a mensagem
            if (!"".equals(bExcep.getDescricaoCriticas())) {
                request.setAttribute(CedenteEstrategia.DESC_CRITICAS,
                        bExcep.getDescricaoCriticas());
                return PAGE_INCLUIR_CONCLUSAO;
            }

            if (blExcepcionacao.size() > 0) {
                ArrayList alExcepcionacao = this.convertDataStructure(blExcepcionacao.iterator());

                request.getSession().setAttribute(PAGINACAO_LIST,
                        getPageHolder(alExcepcionacao));
                request.setAttribute(PAGINACAO_PAGE, "0");
                request.setAttribute(PAGINACAO_PAGEANTERIOR, "0");

                if (this.indicaItemSemAlcada(alExcepcionacao)) {
                    request.setAttribute(INDICA_ITEM_SEM_ALCADA,
                            new Boolean(true));
                }
                request.setAttribute("bloqueio", "N");
                return PAGE_INCLUIR_PENDENCIAS;
            }

            // Se nao houver excepcionacao Finaliza Inclusao
            conclusaoBean.setCodigoUsuario(this.getCodigoUsuario(request));
            conclusaoBean.setExcepcionacao("N"); // finaliza sem
            // excepcionacao

            CedenteCabecaBean cedenteCabecalhoBean = (CedenteCabecaBean) request.getSession()
                    .getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN);
            LogUtilSigcb.info("CABECALHOBEAN  => "
                              + cedenteCabecalhoBean.getNumero());

            conclusaoBean.setLogradouro(cedenteCabecalhoBean.getLogradouro());

            LogUtilSigcb.info("FINALIZANDO INCLUSAO DE CEDENTE. OBTENDO DADOS DO CABECALHO");
            LogUtilSigcb.info("NUMERO      => "
                              + cedenteCabecalhoBean.getNumero());
            LogUtilSigcb.info("COMPLEMENTO => "
                              + cedenteCabecalhoBean.getComplemento().trim());
            LogUtilSigcb.info("MUNICIPIO   => "
                              + cedenteCabecalhoBean.getMunicipio().trim());
            LogUtilSigcb.info("CEP         => " + cedenteCabecalhoBean.getCep());
            LogUtilSigcb.info("UF          => "
                              + cedenteCabecalhoBean.getUf().trim());
            conclusaoBean.setNumeroLogradouro(cedenteCabecalhoBean.getNumero() == null
                    ? ""
                    : cedenteCabecalhoBean.getNumero());
            conclusaoBean.setComplemento(cedenteCabecalhoBean.getComplemento()
                    .trim());
            conclusaoBean.setBairroLogradouro(cedenteCabecalhoBean.getBairro()
                    .trim());
            conclusaoBean.setMunicipio(cedenteCabecalhoBean.getMunicipio()
                    .trim());
            conclusaoBean.setCep(cedenteCabecalhoBean.getCep());
            conclusaoBean.setUf(cedenteCabecalhoBean.getUf().trim());
            
            String ip = request.getRemoteAddr();
            conclusaoBean.setIp(ip);
            
             usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
             transUser = TRANSACAO_FINALIZAR_INCLUSAO + usuarioBean.getCodigoUsuario().toUpperCase();

            BeanList blResposta = handler.executeSimpleTransactionQuery(conclusaoBean,transUser);

            // Verifica criticas
            if (blResposta.size() > 0) {
                resposta = (CedenteConclusaoBean) blResposta.get(0);

                // setando o codigo cedente no bean
                conclusaoBean.setCodigoCedente(resposta.getCodigoCedente());
                request.setAttribute(CEDENTE_CONCLUSAO_BEAN, conclusaoBean);

                // seta o Cedente Padrao
                this.setCedentePadrao(request, resposta.getCodigoCedente());

                if (resposta.getDescricaoCriticas() != null
                    && !resposta.getDescricaoCriticas().trim().equals("")) {
                    return CedenteIncluirGuiaControle.proximaGuia(request,
                            resposta.getDescricaoCriticas(),
                            PAGE_INCLUIR_CONCLUSAO,
                            PAGE_SUCESSO);
                }
            }

            // Chama inclusao do SICLI
            
            transUser = TRANSACAO_INCLUSAO_ALTERACAO_SICLI + usuarioBean.getCodigoUsuario().toUpperCase();
            handler.executeSimpleTransactionVoid(conclusaoBean,transUser);

            // se inclusao com sucesso avanca a guia em cadastramento
            // e nao houver criticas
            if (conclusaoBean.getTipoAcao().equals("I")
                && resposta.getDescricaoCriticas().trim().equals("")) {
                CedenteIncluirGuiaControle.avancaGuiaEmCadastramento(request);
            }

            return CedenteIncluirGuiaControle.proximaGuia(request,
                    resposta.getDescricaoCriticas(),
                    PAGE_INCLUIR_CONCLUSAO,
                    PAGE_SUCESSO);

        } catch (Exception ex) {
            LogUtilSigcb.debug("Excecao CedenteIncluirGuiaConcFinalizar ", ex);
            throw ex;
        }
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

}
