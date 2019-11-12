package br.gov.caixa.sigcb.estrategia.cedente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Alterar Cedente -
 * Excepcionacoes Vigentes
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>18/10/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteAlterarExcepAntIniciar extends CedenteAlterarEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        request.setAttribute(PAGINACAO_PAGE, "0");
        request.setAttribute(PAGINACAO_PAGEANTERIOR, "0");

        return PAGE_ALTERAR_EXCEPANTERIOR;
    }

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO_SEM_MENU;
    }

}
