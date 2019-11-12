package br.gov.caixa.sigcb.util.jsp;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import br.com.politec.sao.jsp.controlTags.Form;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.Paths;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Especializa��o da classe/tag
 * 
 * @see br.com.politec.sao.jsp.controlTags.Form; para tratar estrat�gias,
 *      returns para processos/funcionalidades iniciais e assunto do saibamais
 *      (CEF) (Adaptada do projeto SITCS)
 * @author Glauber Micheloni Gallego ggallego@sao.politec.com.br
 * @version release 1.0
 */
public class FormStrategy extends Form {

    /**
     * Vari�vel que armazena o nome da estrat�gia.
     */
    public String estrategia = "";

    /**
     * Vari�vel que armazena o tipo de fluxo da pagina: normal ou voltar.
     * Atrav�s deste parametro, a estrategia identifica se deve inicializar
     * parametros ou obter dados do ambiente.
     */
    public String fluxo = "";

    /**
     * Vari�vel que armazena o nome do assunto/link para o recurso Saiba Mais da
     * CEF.
     */
    public String saibamais = "";

    /**
     * Construtor default ( sem par�metros ).
     */
    public FormStrategy() {
        super();
    }

    /**
     * Renderiza a por��o inicial da Tag, correspondente � estrutura de tabela e
     * ao menu do sistema.
     * 
     * @return int
     */
    public int doStartTag() {
        try {
            if (this.getSaibamais().equals("")) {
                String jspPage = ((HttpServletRequest) pageContext.getRequest()).getServletPath();
                if (jspPage.endsWith(".jsp"))
                    jspPage = jspPage.substring(1, jspPage.lastIndexOf(".jsp"))
                              + ".html";
                this.setSaibamais(jspPage);
            }

            if (!super.getAction().startsWith(Paths.getRootForDynamicContent())
                && !super.getAction().equals("j_security_check"))
                super.setAction(Paths.getRootForDynamicContent()
                                + "/"
                                + super.getAction());

            super.setMethod("POST");
            super.doStartTag();
            StringBuffer form = new StringBuffer();
            form.append("<input type='hidden' name='estrategia' value='"
                        + this.getEstrategia()
                        + "'>\n");
            form.append("<input type='hidden' name='fluxo' value='"
                        + this.getFluxo()
                        + "'>\n");
            form.append("<input type='hidden' name='saibamais' value='"
                        + this.getSaibamais()
                        + "'>\n");
            this.pageContext.getOut().println(form.toString());
        } catch (IOException ioe) {
            LogUtilSigcb.fatal("FormStrategy doStartTag IOException caught while rendering tag",
                    ioe);
        } catch (Exception e) {
            LogUtilSigcb.fatal("FormStrategy doStartTag() Exception capturada:"
                               + e.toString(), e);
        }
        return EVAL_BODY_INCLUDE;
    }

    /**
     * M�todo getEstrategia. Obtem o atributo <i>estrategia</i> do form HTML
     * sendo renderizado.
     * 
     * @return String
     */
    public String getEstrategia() {
        return estrategia;
    }

    /**
     * M�todo setEstrategia. Define o atributo <i>estrategia</i> do form HTML
     * sendo renderizado.
     * 
     * @param estrategia -
     *            estrategia do Form HTML.
     */
    public void setEstrategia(String string) {
        estrategia = string;
    }

    /**
     * M�todo getFluxo. Obtem o atributo <i>fluxo</i> do form HTML sendo
     * renderizado.
     * 
     * @return String
     */
    public String getFluxo() {
        return fluxo;
    }

    /**
     * M�todo setFluxo. Define o atributo <i>fluxo</i> do form HTML sendo
     * renderizado.
     * 
     * @param fluxo -
     *            fluxo do Form HTML.
     */
    public void setFluxo(String string) {
        if (string.equals(SigcbEstrategia.FLUXO_NORMAL)
            || string.equals(SigcbEstrategia.FLUXO_VOLTAR)) {
            fluxo = string;
        } else {
            fluxo = SigcbEstrategia.FLUXO_NORMAL;
            LogUtilSigcb.info("FormStrategy setFluxo Fluxo aceita apenas :normal: ou :voltar:. Sera adotado normal.",
                    null);
        }
    }

    /**
     * M�todo getSaibaMais. Obtem o atributo <i>saibamais</i> do form HTML
     * sendo renderizado.
     * 
     * @return String
     */
    public String getSaibamais() {
        return saibamais;
    }

    /**
     * M�todo setSaibaMais. Define o atributo <i>saibamais</i> do form HTML
     * sendo renderizado.
     * 
     * @param saibamais -
     *            SaibaMais do Form HTML.
     */
    public void setSaibamais(String string) {
        saibamais = string;
    }
}
