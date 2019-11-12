package br.gov.caixa.sigcb.util.jsp;

import br.com.politec.sao.jsp.Control;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Mostra o numero de inputs passado como parametro para serem utilizados para
 * entrada de mensagens, cada input eh uma linha da mensagem
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/10/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class InputMensagem extends Control {

    int linhas = 0;

    int colunas = 40;

    String name = "";

    public int doStartTag() {
        try {
            StringBuffer inputMensagem = new StringBuffer();

            inputMensagem.append("  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n");

            for (int i = 0; i < this.getLinhas(); i++) {
                inputMensagem.append("    <tr>\n");
                inputMensagem.append("      <td class=\"textoValor\" align=\"left\">\n");
                inputMensagem.append("          &nbsp;" + (i + 1) + "&nbsp;\n");
                inputMensagem.append("      </td>\n");
                inputMensagem.append("      <td>\n");
                inputMensagem.append("           <input type=\"text\" name=\""
                                     + this.getName()
                                     + "\" size=\""
                                     + this.getColunas()
                                     + "\" maxlength=\""
                                     + this.getColunas()
                                     + "\" class=\"inputtextcourier\" onKeyPress=\""
                                     + getOnKeyPress()
                                     + "\">\n");
                inputMensagem.append("      </td>\n");
                inputMensagem.append("    </tr>\n");
            }

            inputMensagem.append("  </table>\n");

            this.pageContext.getOut().println(inputMensagem.toString());

            super.getScriptGenerator().addScript("ValidaDigitacaoAlfanumerico",
                    this.getPath());

        } catch (Exception ex) {
            LogUtilSigcb.fatal("InputMensagem doStartTag() Exception capturada:"
                               + ex.toString(),
                    ex);
        }

        return SKIP_BODY;
    }

    public int getLinhas() {
        return linhas;
    }

    public void setLinhas(int i) {
        linhas = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String string) {
        name = string;
    }

    public int getColunas() {
        return colunas;
    }

    public void setColunas(int i) {
        colunas = i;
    }

    public String getOnKeyPress() {
        return super.getScriptGenerator()
                .getOnKeyPress("ValidaDigitacaoAlfanumerico", this.getPath());
    }

}
