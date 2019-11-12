package br.gov.caixa.sigcb.estrategia.servico;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.util.WrappingException;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.TituloBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Protesto
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>26/09/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 */

public class ProtestAcaoFiltro extends ProtestEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);

        // Recupera/define informacoes do titulo
        TituloBean tituloBean = new TituloBean();
        if (getFluxo(request).equals(FLUXO_NORMAL)) {

            tituloBean = (TituloBean) tituloBean.getRequestBean(request);
            tituloBean.setMeioEntrada(new Long(1));

            // Retem informacoes do bean antes do acesso ao mainframe
            request.getSession().setAttribute(DATA_BEAN, tituloBean);

            // Obtem bean com informacoes da guia "Dados Principais (BG60)"
            tituloBean = getTituloDadosPrincipais(request, response, tituloBean);
            // Obtem bean com informacoes da guia "Dados Encargos Abatimentos
            // (BG66)"
            tituloBean = getTituloDadosEncargosAbatimentos(request,
                    response,
                    tituloBean);
            
            //ade - teste 20100707
           // tituloBean = getTituloDadosComplementares(request,
           //         response,
           //         tituloBean);
            

        } else {
            tituloBean = (TituloBean) tituloBean.getSessionBean(request,
                    DATA_BEAN);
        }

        // Recupera/define informacoes de cabecalho do cedente
        BcoTituEstrategia.setCedenteCabecaBean(tituloBean, request);

        if (tituloBean.getAcoesServicoTitulo().equals(new Long(16))) { // Acao:
                                                                        // ESTORNO
                                                                        // DE
                                                                        // SUSTACAO
            tituloBean.setAcoesServicoTitulo(new Long(3)); // Acao: Estorno
                                                            // Envio/Sustação
        }

        // Seta informacoes do bean depois do acesso ao mainframe
        request.getSession().setAttribute(DATA_BEAN, tituloBean);

        if (!permiteAcaoProtesto(tituloBean)) {
            switch (mensagem_especial_protesto(tituloBean)) {
            case 1: // protesto = nao
                throw new WrappingException(new Exception(" Titulo não pode ser protestado (Indicador de protesto = NAO)."));
            case 2: // data envio cartorio vencida
                throw new WrappingException(new Exception(" Titulo com Data de Envio a Cartorio nao vencido, não pode sofrer a ação de "
                                                          + tituloBean.getAcoesServicoTituloTexto()
                                                                  .trim()));
            default:
                throw new WrappingException(new Exception(" Titulo "
                                                          + tituloBean.getPrinciDescricaoSituacao()
                                                                  .trim()
                                                          + " não pode sofrer a ação de "
                                                          + tituloBean.getAcoesServicoTituloTexto()
                                                                  .trim()));
            }
        }

        return PAGE_FILTRO_ACAO;
    }

    private int mensagem_especial_protesto(TituloBean tituloBean) {

        if (tituloBean.getPrinciSituacao().equals(new Long(1))) { // Situacao:
                                                                    // Em
                                                                    // Aberto,

            if (tituloBean.getPrinciIndicadorProt().equals("S")) { // Possui
                                                                    // protesto

                if (tituloBean.getAcoesServicoTitulo().equals(new Long(5))) { // Acao:
                                                                                // Impressão
                                                                                // de
                                                                                // 2a.
                                                                                // via
                                                                                // Ordem
                                                                                // de
                                                                                // Protesto
                    SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
                    String dataHoje = formato.format(Calendar.getInstance()
                            .getTime());
                    String dataPrevisaoProtDev = formato.format(tituloBean.getAbatiDataPrevisaoProtDev());
                    // EAM0308 - Alterada esta condição pq a data de protesto
                    // está sendo enviada acrescida de 1 dia na BG66
                    // if (Long.parseLong(dataPrevisaoProtDev) >=
                    // Long.parseLong(dataHoje)) { //---> Data Envio Vencida?
                    if (Long.parseLong(dataPrevisaoProtDev) > Long.parseLong(dataHoje)) { // --->
                                                                                            // Data
                                                                                            // Envio
                                                                                            // Vencida?
                        return 2;
                    }
                }

            } else {
                return 1;
            }
        }
        return 0;
    }

    private boolean permiteAcaoProtesto(TituloBean tituloBean) {

        if (tituloBean.getPrinciSituacao().equals(new Long(1))) { // Situacao:
                                                                    // Em
                                                                    // Aberto,
            if (tituloBean.getPrinciIndicadorProt().equals("S")) { // --->
                                                                    // Possui
                                                                    // protesto
                if (tituloBean.getAcoesServicoTitulo().equals(new Long(1)) || // Acao:
                                                                                // Envio
                                                                                // ao
                                                                                // Cartório
                    tituloBean.getAcoesServicoTitulo().equals(new Long(6)) || // Acao:
                                                                                // Suspender
                                                                                // Envio
                                                                                // ao
                                                                                // Cartório
                    tituloBean.getAcoesServicoTitulo().equals(new Long(7))) { // Acao:
                                                                                // Incluir
                                                                                // Título
                                                                                // na
                                                                                // Remessa
                    return true;
                } else if (tituloBean.getAcoesServicoTitulo()
                        .equals(new Long(5))) {// Acao: Impressão de 2a. via
                                                // Ordem de Protesto
                    SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
                    String dataHoje = formato.format(Calendar.getInstance()
                            .getTime());
                    String dataPrevisaoProtDev = formato.format(tituloBean.getAbatiDataPrevisaoProtDev());
                    // EAM0308 - Alterada esta condição pq a data de protesto
                    // está sendo enviada acrescida de 1 dia na BG66
                    // if (Long.parseLong(dataPrevisaoProtDev) <
                    // Long.parseLong(dataHoje)) { //---> Data Envio Vencida?
                    if (Long.parseLong(dataPrevisaoProtDev) <= Long.parseLong(dataHoje)) { // --->
                                                                                            // Data
                                                                                            // Envio
                                                                                            // Vencida?
                        return true;
                    }
                }
            }
        }

        // EAM 04/08 - Incluída Situacao 7
        if (tituloBean.getPrinciSituacao().equals(new Long(7))) { // Situacao:
                                                                    // ENVIADO A
                                                                    // CARTORIO
            if (tituloBean.getAcoesServicoTitulo().equals(new Long(2)) || // Acao:
                                                                            // Sustação
                                                                            // de
                                                                            // Protesto
                tituloBean.getAcoesServicoTitulo().equals(new Long(3)) || // Acao:
                                                                            // Estorno
                                                                            // Envio/Sustação
                tituloBean.getAcoesServicoTitulo().equals(new Long(4)) || // Acao:
                                                                            // Débito
                                                                            // Custas
                                                                            // Cartorárias
                tituloBean.getAcoesServicoTitulo().equals(new Long(5)) || // Acao:
                                                                            // Impressão
                                                                            // de
                                                                            // 2a.
                                                                            // via
                                                                            // Ordem
                                                                            // de
                                                                            // Protesto
                tituloBean.getAcoesServicoTitulo().equals(new Long(7)) || // Acao:
                                                                            // Incluir
                                                                            // Título
                                                                            // na
                                                                            // Remessa
                tituloBean.getAcoesServicoTitulo().equals(new Long(8)) || // Acao:
                                                                            // Baixa
                                                                            // por
                                                                            // Protesto
                tituloBean.getAcoesServicoTitulo().equals(new Long(9)) || // Acao:
                                                                            // Liquidado
                                                                            // em
                                                                            // Cartório
                tituloBean.getAcoesServicoTitulo().equals(new Long(10)) || // Acao:
                                                                            // Liquidado
                                                                            // em
                                                                            // Cartório
                                                                            // Condicional
            	tituloBean.getAcoesServicoTitulo().equals(new Long(19))) { 	// Acao:
																			// Débito
																			// Custas/Despesas
																			// Cartorárias
																			// Protesto Centralizado

                return true;
            }
        }
        // EAM 22/04 - SISOT 35: Incluído Situacao 1 e 7
        if (tituloBean.getPrinciSituacao().equals(new Long(8))) { // Situacao:
                                                                    // SUSTADO
                                                                    // CARTORIO
            if (tituloBean.getAcoesServicoTitulo().equals(new Long(1)) || // Acao:
                                                                            // Envio
                                                                            // ao
                                                                            // Cartório
                tituloBean.getAcoesServicoTitulo().equals(new Long(3)) || // Acao:
                                                                            // Estorno
                                                                            // Envio/Sustação
                tituloBean.getAcoesServicoTitulo().equals(new Long(4)) || // Acao:
                                                                            // Débito
                                                                            // Custas
                                                                            // Cartorárias
                tituloBean.getAcoesServicoTitulo().equals(new Long(5)) || // Acao:
                                                                            // Impressão
                                                                            // de
                                                                            // 2a.
                                                                            // via
                                                                            // Ordem
                                                                            // de
                                                                            // Protesto
                tituloBean.getAcoesServicoTitulo().equals(new Long(7)) || // Acao:
                                                                            // Incluir
                                                                            // Título
                                                                            // na
                                                                            // Remessa
            	tituloBean.getAcoesServicoTitulo().equals(new Long(19))) { 	// Acao:
																			// Débito
																			// Custas/Despesas
																			// Cartorárias
																			// Protesto Centralizado

                return true;
            }
        }
        return false;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}