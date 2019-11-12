package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.DadosListaExcepciBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Cedente >>
 * Excepcionação.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>28/06/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */

public class ExcepciManterFiltro extends ExcepciManterEstrategia {

    private String strEstrategiaRet = STRATEGY_FILTRO;

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String strRetorno = "";

        String fluxo = getFluxo(request);   // Obtem informações para definir se
                                            // o request veio de voltar ou se o
                                            // fluxo é normal

        DadosListaExcepciBean filtroExcepciBean = new DadosListaExcepciBean();
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();

        InformacoesUsuarioBean usuarioBean = new InformacoesUsuarioBean();
        usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute("usuarioLdap");

        BeanList cedCabBeanList;
        ArrayList listaCedentesArrayList;

        if (fluxo.equals(FLUXO_NORMAL)) {
            filtroExcepciBean = (DadosListaExcepciBean) filtroExcepciBean.getRequestBean(request);
            PilhaVoltarControle.push(request, filtroExcepciBean);

        } else {
            filtroExcepciBean = (DadosListaExcepciBean) PilhaVoltarControle.pop(request);

            if (filtroExcepciBean == null) {
                return (new ExcepciManterIniciar()).processRequest(request,
                        response);
            }

        }

        filtroExcepciBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());

        // Instancia o EJB que acessa o mainframe
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        switch (filtroExcepciBean.getTpConsultaEstrategia().intValue()) {

        case 0:

            /*
             * estratégia customizada para efetuar a busca de pendencias por
             * codigoCedente - Transac. BG33, tipoConsulta 1 o Retorno deverá
             * ser uma página de lista contendo as pendencias do cedente
             * solicitado
             */

            // Configuração para mensagens e telas de erro e sucesso
            configMsgSucessoErro(request);

            // Reter o bean antes de acessar o mainframe
            request.getSession().setAttribute(FILTRO_BEAN, filtroExcepciBean);

            if (fluxo.equals(FLUXO_NORMAL)) {
                // Transação BGM0

                cedCabBean.setTipoConsulta(new Long(1));
                cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
                cedCabBean.setCodigoCedente(filtroExcepciBean.getCodigoCedente());
                cedCabBean.setOrigemConsulta(new Long(1));
                 usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
                String transUser = TRANSACAO_CABECALHO_CEDENTE + usuarioBean.getCodigoUsuario().toUpperCase();
                cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
                		transUser);

                CedenteCabecaBean cedBean = (CedenteCabecaBean) cedCabBeanList.get(0);
                cedBean.setCodigoCedente(filtroExcepciBean.getCodigoCedente());

                request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,
                        cedBean);
            }
            // Transação BG33
            request.getSession().setAttribute(CEDENTE_ATUAL,
                    filtroExcepciBean.getCodigoCedente());

            filtroExcepciBean.setTipoConsulta(new Long(1));
            
            usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_LISTAR_CEDENTE_NUMPED + usuarioBean.getCodigoUsuario().toUpperCase();

            List pendCedList = (List) handler.executeFixDataRecordsetTransaction(filtroExcepciBean,
            		transUser);

            DadosListaExcepciBean codCedenteBean = (DadosListaExcepciBean) ((BeanList) pendCedList.get(0)).get(0);
            BeanList PendCedBeanlist = (BeanList) pendCedList.get(1);
            ArrayList pendCedArrayList = convertDataStructure(PendCedBeanlist.iterator());

            // enviando Beans

            request.getSession().setAttribute(FIXO_BEAN, codCedenteBean);
            request.getSession().setAttribute(PAGINACAO_LIST,
                    getPageHolder(pendCedArrayList));

            request.setAttribute(PAGINACAO_PAGE, "0");

            strRetorno = PAGE_LISTAR_CEDENTE_NUMPED;

            break;

        case 1:

            /*
             * estratégia customizada para efetuar a busca de cedentes por
             * cpfCnpj - Transac. BG32, tipoConsulta 1 o retorno deverá ser uma
             * página contendo uma lista de Cedentes do CPF ou CNPJ solicitado
             */
            configMsgSucessoErro(request);// Configuração para mensagens e
                                            // telas de erro e sucesso

            filtroExcepciBean.setTipoConsulta(new Long(1));
            usuarioBean = (InformacoesUsuarioBean) request.getSession()
                    .getAttribute(USUARIO_LDAP);
            // filtroExcepciBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());

            // Colocar o bean na session antes de acessar o mainframe
            request.getSession().setAttribute(FILTRO_BEAN, filtroExcepciBean);
             usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
             transUser = TRANSACAO_LISTAR_CPFCNPJ_PV + usuarioBean.getCodigoUsuario().toUpperCase();
            List cedentesCPFCNPJlist = (List) handler.executeFixDataRecordsetTransaction(filtroExcepciBean,
            		transUser);

            DadosListaExcepciBean cedentesCPFCNPJFixoBean = (DadosListaExcepciBean) ((BeanList) cedentesCPFCNPJlist.get(0)).get(0);
            BeanList cedentesCPFCNPJBeanList = (BeanList) cedentesCPFCNPJlist.get(1);

            ArrayList cedentesCPFCNPJArrayList = convertDataStructure(cedentesCPFCNPJBeanList.iterator());

            request.getSession().setAttribute(FIXO_BEAN,
                    cedentesCPFCNPJFixoBean);
            request.getSession().setAttribute(PAGINACAO_LIST,
                    getPageHolder(cedentesCPFCNPJArrayList));

            request.setAttribute(PAGINACAO_PAGE, "0");

            strRetorno = PAGE_LISTAR_CPFCNPJ;

            break;

        case 2:
            /*
             * estratégia customizada para efetuar a busca de pendencias por
             * numeroPendencia - Transac. BG33, tipoConsulta 2 o Retorno deverá
             * ser uma página de lista contendo a pendencias solicitada
             */
            configMsgSucessoErro(request);// Configuração para mensagens e
                                            // telas de erro e sucesso

            // Ajustando parametros de busca para os dados das pendencias do
            // Cedente - BG33
            filtroExcepciBean.setTipoConsulta(new Long(2));

            // Reter o bean antes de acessar o mainframe
            request.getSession().setAttribute(FILTRO_BEAN, filtroExcepciBean);

            // Transação BG33
             usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
             transUser = TRANSACAO_LISTAR_CEDENTE_NUMPED + usuarioBean.getCodigoUsuario().toUpperCase();
            
            List pendenciaList = (List) handler.executeFixDataRecordsetTransaction(filtroExcepciBean,
            		transUser);

            DadosListaExcepciBean pendCedenteBean = (DadosListaExcepciBean) ((BeanList) pendenciaList.get(0)).get(0);
            BeanList PendenciaBeanlist = (BeanList) pendenciaList.get(1);
            ArrayList pendenciaArrayList = convertDataStructure(PendenciaBeanlist.iterator());

            // Transação BGM0
            cedCabBean.setTipoConsulta(new Long(1));
            usuarioBean = (InformacoesUsuarioBean) request.getSession()
                    .getAttribute("usuarioLdap");
            cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
            cedCabBean.setCodigoCedente(pendCedenteBean.getCodigoCedente());
            cedCabBean.setOrigemConsulta(new Long(1));
            transUser = TRANSACAO_CABECALHO_CEDENTE + usuarioBean.getCodigoUsuario().toUpperCase();
            cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
            		transUser);

            request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,
                    (CedenteCabecaBean) cedCabBeanList.get(0));

            request.getSession().setAttribute(FIXO_BEAN, pendCedenteBean);
            request.getSession().setAttribute(PAGINACAO_LIST,
                    getPageHolder(pendenciaArrayList));

            request.setAttribute(PAGINACAO_PAGE, "0");

            strRetorno = PAGE_LISTAR_CEDENTE_NUMPED;

            break;

        case 3:
            /*
             * (busca por EN) devolverá uma lista de PV - Transac. BG31,
             */

            configMsgSucessoErro(request);// Configuração para mensagens e
                                            // telas de erro e sucesso

            // setando estratégia de volta
            filtroExcepciBean.setEstrategiaVoltar(STRATEGY_LISTA);

            // Reter o bean antes de acessar o mainframe
            request.getSession().setAttribute(FILTRO_BEAN, filtroExcepciBean);
            transUser = TRANSACAO_LISTAR_EN + usuarioBean.getCodigoUsuario().toUpperCase();
            List listaPvList = (List) handler.executeFixDataRecordsetTransaction(filtroExcepciBean,
            		transUser);

            DadosListaExcepciBean listaPvFixoBean = (DadosListaExcepciBean) ((BeanList) listaPvList.get(0)).get(0);
            BeanList listaPvBeanlist = (BeanList) listaPvList.get(1);

            ArrayList listaPvArrayList = convertDataStructure(listaPvBeanlist.iterator());

            // Reter os dados depois da chamada ao mainframe
            // para gerar informacoes para tela de sucesso
            request.getSession().setAttribute(FIXO_BEAN, listaPvFixoBean);
            request.getSession().setAttribute(PAGINACAO_LIST,
                    getPageHolder(listaPvArrayList));

            request.setAttribute(PAGINACAO_PAGE, "0");

            strRetorno = PAGE_LISTAR_EN;

            break;

        case 4:
            /*
             * (busca por PV) devolverá uma lista de Cedentes - Transac BG32,
             * tipoConsulta 2
             */

            configMsgSucessoErro(request);// Configuração para mensagens e
                                            // telas de erro e sucesso

            filtroExcepciBean.setTipoConsulta(new Long(2));

            // obtendo user ID do LDAP
            usuarioBean = (InformacoesUsuarioBean) request.getSession()
                    .getAttribute(USUARIO_LDAP);
            filtroExcepciBean.setCodigoUsuario(usuarioBean.getUid());

            request.getSession().setAttribute(FILTRO_BEAN, filtroExcepciBean);
             usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
             transUser = TRANSACAO_LISTAR_CPFCNPJ_PV + usuarioBean.getCodigoUsuario().toUpperCase();
            List cedentesPVList = handler.executeFixDataRecordsetTransaction(filtroExcepciBean,
            		transUser);

            DadosListaExcepciBean cedentesPVFixoBean = (DadosListaExcepciBean) ((BeanList) cedentesPVList.get(0)).get(0);
            BeanList cedentesPVBeanList = (BeanList) cedentesPVList.get(1);

            listaCedentesArrayList = convertDataStructure(cedentesPVBeanList.iterator());

            request.getSession().setAttribute(FIXO_BEAN, cedentesPVFixoBean);
            request.getSession().setAttribute(PAGINACAO_LIST,
                    getPageHolder(listaCedentesArrayList));

            request.setAttribute(PAGINACAO_PAGE, "0");

            strRetorno = PAGE_LISTAR_PV;

            break;
        }

        return strRetorno;
    }

    // Configuração para mensagens e telas de erro e sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(strEstrategiaRet);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}