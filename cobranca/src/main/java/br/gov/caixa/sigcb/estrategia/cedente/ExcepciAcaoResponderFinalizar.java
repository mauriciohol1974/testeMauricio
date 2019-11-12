package br.gov.caixa.sigcb.estrategia.cedente;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.util.PageHolder;
import br.com.politec.sao.util.Pageable;
import br.com.politec.sao.util.WrappingException;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.DadosListaExcepciBean;
import br.gov.caixa.sigcb.bean.ExcepcionacaoBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.Util;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Excepcionação >>
 * Responder Pendencia Finalizar
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>20/09/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class ExcepciAcaoResponderFinalizar extends ExcepciManterEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String strFakeRecordSet = "";

        configMsgSucessoErro(request);

        // Obtem o bean da funcionalidade
        ExcepcionacaoBean excepciBean = new ExcepcionacaoBean();
        ExcepcionacaoBean excepciRequestBean = new ExcepcionacaoBean();
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        DadosListaExcepciBean filtroBean = new DadosListaExcepciBean();
        InformacoesUsuarioBean usuarioBean = new InformacoesUsuarioBean();

        filtroBean = (DadosListaExcepciBean) filtroBean.getRequestBean(request);
        cedCabBean = (CedenteCabecaBean) cedCabBean.getRequestBean(request);

        // obtendo dados do request
        excepciRequestBean = (ExcepcionacaoBean) excepciBean.getRequestBean(request);

        // obtendo dados da session
        excepciBean = (ExcepcionacaoBean) excepciBean.getSessionBean(request,
                EXCEPCI_BEAN);

        /* nota */
        // colocando no session bean os dados obtidos da tela de resposta de
        // pendencia
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        if (excepciBean.getDatavigenciaINI().trim().length()>0){
	        Date dataIni = new Date(format.parse(excepciBean.getDatavigenciaINI()).getTime());
	        Date dataFim = new Date(format.parse(excepciBean.getDatavigenciaFIM()).getTime());
	        excepciBean.setDataVigenciaDe(dataIni);
	        excepciBean.setDataVigenciaAte(dataFim);
        }else{
        	excepciBean.setDataVigenciaDe(excepciRequestBean.getDataVigenciaDe());
            excepciBean.setDataVigenciaAte(excepciRequestBean.getDataVigenciaAte());
        }
        excepciBean.setResposta(excepciRequestBean.getResposta());

        // obtendo dados sobre o usuário logado
        usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute("usuarioLdap");

        // obtendo dados do recordset
        PageHolder phPareceres = (PageHolder) request.getSession()
                .getAttribute(PAGINACAO_LIST);
        Pageable pblParecer = phPareceres.getPageable();

        // obtendo os codigos pareceres
        int pagina = Integer.parseInt((String) request.getParameter(ExcepciManterEstrategia.PAGINACAO_PAGEANTERIOR));

        List lista = phPareceres.getPage(pagina);

        String[] pareceres = null;
        if (request.getParameterValues("pareceres") != null
            && !request.getParameterValues("pareceres").equals("")) {
            pareceres = (String[]) request.getParameterValues("pareceres");
        }
        if (pareceres != null) {
            for (int i = 0; i < pareceres.length; i++) {
                // carregando dados dos pareceres nos respectivos beans
                ExcepcionacaoBean bean = (ExcepcionacaoBean) lista.get(i);
                bean.setCodigoParecer(new Long(pareceres[i]));
            }
        }

        // preenchendo string do fake recordset
        for (int i = 0; i < pblParecer.size(); i++) {
            ExcepcionacaoBean bean = (ExcepcionacaoBean) pblParecer.get(i);
            strFakeRecordSet += Util.zerosEsquerda(bean.getCodigoItemExcep(), 4);
            strFakeRecordSet += bean.getCodigoParecer().toString();

        }

        // setando usuário
        excepciBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
        excepciBean.setCodigoCedente(filtroBean.getCodigoCedente());
        
        String ip = request.getRemoteAddr();
        excepciBean.setIp(ip);


        if (strFakeRecordSet.length() > 740) {
            throw new WrappingException(new Exception(" Excedido o Limite Maximo de itens para Excepcionações."));
        } else {
            excepciBean.setFakeRecordSet(strFakeRecordSet);
        }

        /* nota */
        // enviando novamente o bean para session para o caso do sistema de alta
        // plataforma
        // aponte algum erro por parte do usuário e para a persistência dos
        // dados digitados na
        // tela evitando assim um acumulo de campos hidden na jsp
        request.getSession().setAttribute(EXCEPCI_BEAN, excepciBean);

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        
         usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_RESP_PEND_FIM + usuarioBean.getCodigoUsuario().toUpperCase();
        handler.executeSimpleTransactionVoid(excepciBean,
        		transUser);

        return PAGE_SUCESSO;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("Excepcionação efetuada com Sucesso!");
        msgBean.setStrategyErrorReturn(STRATEGY_ACAO_RESP_INICIAR);
        msgBean.setStrategySucessReturn(STRATEGY_LISTA);
        msgBean.setTitlePage(PAGE_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}
