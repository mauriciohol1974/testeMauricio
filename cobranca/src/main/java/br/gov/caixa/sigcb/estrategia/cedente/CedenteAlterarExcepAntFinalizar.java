package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.sun.java_cup.internal.internal_error;
//import com.sun.java_cup.internal.parse_action;

import br.com.politec.sao.util.PageHolder;
import br.com.politec.sao.util.Pageable;
import br.gov.caixa.sigcb.bean.CedenteConclusaoBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Alterar Cedente -
 * Excepcionacao Vigente
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>20/10/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteAlterarExcepAntFinalizar extends CedenteAlterarEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String acao = request.getParameter("acao");
        PageHolder phExc = (PageHolder) request.getSession()
                .getAttribute(PAGINACAO_LIST);
        PageHolder phExcVig = (PageHolder) request.getSession()
                .getAttribute(PAGINACAO_EXCVIG_LIST);

        if ("cancelar".equals(acao)) {
            this.cancelarAgregacao(request, phExc, phExcVig);
        } else {

            // Seta nos beans os checkboxes da pagina atual
            this.trataPaginaAtual(request, phExcVig);

            // Pega os beans que foram escolhidos na tela de Excepcionacoes
            // Vigentes
            ArrayList alExcEscolhidas = this.separaExcEscolhidas(phExcVig);

            // Adiciona na paginacao da tela de Itens Excepcionados
            ArrayList alExc = this.adicionaExcEscolhidas(alExcEscolhidas, phExc);

            request.getSession().setAttribute(PAGINACAO_LIST,
                    getPageHolder(alExc));
        }

        // Indica que pode fechar a janela
        request.setAttribute(FECHAR_JANELA_EXCVIG, "true");

        request.setAttribute(PAGINACAO_PAGE, "0");
        request.setAttribute(PAGINACAO_PAGEANTERIOR, "0");

        return PAGE_ALTERAR_PENDENCIAS;
    }

    private void cancelarAgregacao(HttpServletRequest request,
            PageHolder phExc,
            PageHolder phExcVig) {
        ArrayList alExc = this.removeExcepcionacaoAgregada(phExc);

        ArrayList alExcVig = this.desmarcaExcepcionacaoVigente(phExcVig);
        PageHolder phExcepVigente = getPageHolder(alExcVig);
        phExcepVigente.setPageSize(5);

        request.getSession().setAttribute(PAGINACAO_LIST, getPageHolder(alExc));
        request.getSession()
                .setAttribute(PAGINACAO_EXCVIG_LIST, phExcepVigente);
    }

    /**
     * Trata os checkboxes selecionados na pagina atual
     */
    private void trataPaginaAtual(HttpServletRequest request,
            PageHolder phExcVig) throws Exception {
        String[] itensAgregar = request.getParameterValues("checkAgregarExcecao");

        int paginaAtual = Integer.parseInt(request.getParameter(CedenteEstrategia.PAGINACAO_PAGE));
        List listExcVig = phExcVig.getPage(paginaAtual);

        // resetando status da pagina atual
        for (int i = 0; i < listExcVig.size(); i++) {
            CedenteConclusaoBean bean = (CedenteConclusaoBean) listExcVig.get(i);
            bean.setAgregado(false);
        }

        if (itensAgregar != null) {
            for (int i = 0; i < itensAgregar.length; i++) {
                CedenteConclusaoBean bean = (CedenteConclusaoBean) listExcVig.get(Integer.parseInt(itensAgregar[i]));
                bean.setAgregado(true);
            }
        }
    }

    /**
     * Volta um arraylist somente com os beans escolhidos
     */
    private ArrayList separaExcEscolhidas(PageHolder phExcVig) {
        ArrayList alBeansAgregar = new ArrayList();

        Pageable pbExcVig = phExcVig.getPageable();

        for (int i = 0; i < pbExcVig.size(); i++) {
            CedenteConclusaoBean bean = (CedenteConclusaoBean) pbExcVig.get(i);

            if (bean.isAgregado()) {
                alBeansAgregar.add(bean);
            }
        }

        return alBeansAgregar;
    }

    /**
     * Adiciona os beans do arraylist passado com os beans do Pageholder e
     * retorna num Arraylist
     */
    private ArrayList adicionaExcEscolhidas(ArrayList alExcEscolhidas,
            PageHolder phExc) {
        ArrayList alExcepcionacoes = new ArrayList();

        Pageable pbExc = phExc.getPageable();
        for (int i = 0; i < pbExc.size(); i++) {
            CedenteConclusaoBean bean = (CedenteConclusaoBean) pbExc.get(i);
            if (!bean.isAgregado()) {
                alExcepcionacoes.add(bean);
            }
        }

        for (int i = 0; i < alExcEscolhidas.size(); i++) {
            CedenteConclusaoBean beanExcVig = (CedenteConclusaoBean) alExcEscolhidas.get(i);

            if (!this.contemExcepcionacaoVigente(alExcepcionacoes, beanExcVig)) {
                alExcepcionacoes.add(beanExcVig);
            }

        }

        return alExcepcionacoes;
    }

    /**
     * verifica se excepcionacao existe no arraylist alExcepcionacoes
     */
    private boolean contemExcepcionacaoVigente(ArrayList alExcepcionacoes,
            CedenteConclusaoBean beanExcVig) {
    	
        for (int j = 0; j < alExcepcionacoes.size(); j++) {
            CedenteConclusaoBean beanExc = (CedenteConclusaoBean) alExcepcionacoes.get(j);

          Integer  beanExcCodigoItem = Integer.parseInt(beanExc.getCodigoItem());
          Integer  beanExcVigCodigoItem = Integer.parseInt(beanExcVig.getCodigoItem());
          if (beanExcCodigoItem.equals(beanExcVigCodigoItem)  && beanExc.getTipo().equals(beanExcVig.getTipo())) {
        	  return true;
          }
            
        }
        return false;
    }

    /**
     * Remove as excepcionacoes agregadas da lista de excepcionacoes
     */
    private ArrayList removeExcepcionacaoAgregada(PageHolder phExcepcionacoes) {
        Pageable pbExc = phExcepcionacoes.getPageable();
        ArrayList alExc = new ArrayList();

        for (int i = 0; i < pbExc.size(); i++) {
            CedenteConclusaoBean bean = (CedenteConclusaoBean) pbExc.get(i);

            // se o bean nao estiver agregado junta na lista que sera retornada
            if (!bean.isAgregado()) {
                alExc.add(bean);
            }
        }
        return alExc;
    }

    /**
     * Desmarca todas as Excepcionacoes da lista de Excepcionacoes Vigente
     */
    private ArrayList desmarcaExcepcionacaoVigente(PageHolder phExcVig) {
        Pageable pbExcVig = phExcVig.getPageable();
        ArrayList alExcVig = new ArrayList();

        for (int i = 0; i < pbExcVig.size(); i++) {
            CedenteConclusaoBean bean = (CedenteConclusaoBean) pbExcVig.get(i);
            bean.setAgregado(false);
            alExcVig.add(bean);
        }
        return alExcVig;
    }

    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO_SEM_MENU;
    }

}
