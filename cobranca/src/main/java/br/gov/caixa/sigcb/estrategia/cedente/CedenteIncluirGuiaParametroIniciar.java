package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.PageHolder;
import br.gov.caixa.sigcb.bean.CedenteParametrosBean;
import br.gov.caixa.sigcb.bean.CedenteTarifasBean;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Incluir Cedente - Guia
 * Tarifas (Informar Tarifas)
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>30/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteIncluirGuiaParametroIniciar extends CedenteIncluirEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        this.configMsgSucessoErro(request);

        CedenteParametrosBean parametrosBean = new CedenteParametrosBean();
        request.setAttribute(PAGINACAO_PAGE, "0");
        request.setAttribute(PAGINACAO_PAGEANTERIOR, "0");

        request.setAttribute(CEDENTE_PARAMETROS_BEAN, parametrosBean);

        return PAGE_INCLUIR_PARAMETRO;
    }

   
}
