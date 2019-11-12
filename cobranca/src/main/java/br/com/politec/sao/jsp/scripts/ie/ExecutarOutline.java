package br.com.politec.sao.jsp.scripts.ie;

import java.util.StringTokenizer;

import br.com.politec.sao.jsp.scripts.Script;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Renderiza o javascript para executar recursos de outline (guias
 * expandiveis/retraiveis) para Browsers Internet Explorer.
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 * @version release 1.0
 */
public class ExecutarOutline extends Script {
    private String outlineType = "";

    private String imagePath = "";

    /**
     * Método getScript. Retorna um script que renderiza o javascript para
     * captura da tecla <i>Enter</i> para Browsers Internet Explorer.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Script da função validaEnter.
     */
    public String getScript() {
        StringBuffer scr = new StringBuffer();
        scr.append("var olType='" + outlineType + "';\n");

        // soh serve para desabilitar um outline por vez
        // se precisar de mais de um nao serve essa implementacao
        scr.append("var olDisabledOutline = new Array();\n");

        scr.append("\n");
        scr.append("function disableOutline(olName) {\n");
        scr.append("    olDisabledOutline[olName] = true;\n");
        scr.append("}\n");
        scr.append("function enableOutline(olName) {\n");
        scr.append("    olDisabledOutline[olName] = false;\n");
        scr.append("}\n");
        scr.append("function initOutlines() {\n");
        scr.append("	initIt();\n");
        scr.append("}\n");
        scr.append("function outlineType() {\n");
        scr.append("	return olType; //default\n");
        scr.append("}\n");
        scr.append("function getImageOutlineMinus() {\n");
        scr.append("	return ('" + imagePath + "/outlineminus.gif')\n");
        scr.append("}\n");
        scr.append("function getImageOutlinePlus() {\n");
        scr.append("	return ('" + imagePath + "/outlineplus.gif')\n");
        scr.append("}\n");
        scr.append("function getImageTwistDown() {\n");
        scr.append("	return ('" + imagePath + "/twist_dw.gif')\n");
        scr.append("}\n");
        scr.append("function getImageTwistRight() {\n");
        scr.append("	return ('" + imagePath + "/twist_rg.gif')\n");
        scr.append("}\n");
        scr.append("function initIt(){\n");
        scr.append("	//collapse DIV\n");
        scr.append("	if (document.all) {\n");
        scr.append("		tempColl = document.all.tags('DIV');\n");
        scr.append("		for (i=0; i<tempColl.length; i++) {\n");
        scr.append("			if (tempColl(i).id.indexOf('Child') != -1)\n");
        scr.append("				tempColl(i).style.display = 'none';\n");
        scr.append("		}\n");
        scr.append("	} else {\n");
        scr.append("		tmpLst = document.getElementsByTagName('DIV');\n");
        scr.append("		for (i=0; i<tmpLst.length; i++) {\n");
        scr.append("			tmpEl = tmpLst[i];\n");
        scr.append("			if (tmpEl.id.indexOf('Child') != -1)\n");
        scr.append("				tmpEl.style.display = 'none';\n");
        scr.append("		}\n");
        scr.append("	}\n");
        scr.append("	// set IMG to outlineplus icon\n");
        scr.append("	if (document.all) {\n");
        scr.append("		tempColl = document.all.tags('IMG');\n");
        scr.append("		for (i=0; i<tempColl.length; i++) {\n");
        scr.append("			if (tempColl(i).name == 'outline') {\n");
        scr.append("				tempColl(i).src = getImageOutlinePlus();\n");
        scr.append("			} else if (tempColl(i).name == 'twist') {\n");
        scr.append("				tempColl(i).src = getImageTwistRight();\n");
        scr.append("			}\n");
        scr.append("		}\n");
        scr.append("	} else {\n");
        scr.append("		tmpLst = document.getElementsByTagName('IMG');\n");
        scr.append("		for (i=0; i<tmpLst.length; i++) {\n");
        scr.append("			tmpEl = tmpLst[i];\n");
        scr.append("			if (tmpEl.name == 'outline') {\n");
        scr.append("				tmpEl.src = getImageOutlinePlus();\n");
        scr.append("			} else if (tmpEl.name == 'twist') {\n");
        scr.append("				tempColl(i).src = getImageTwistRight();\n");
        scr.append("			}\n");
        scr.append("		}\n");
        scr.append("	}\n");
        scr.append("}\n");
        scr.append("function getState(el) {\n");
        scr.append("	whichEl = eval(el + 'Child');\n");
        scr.append("	stateEl = whichEl.style.display;\n");
        scr.append("	return(stateEl);\n");
        scr.append("}\n");
        scr.append("function switchIt(el) {\n");
        scr.append("	whichEl = eval(el + 'Child');\n");
        scr.append("	if (whichEl.style.display == 'none') {\n");
        scr.append("		expandIt(el);\n");
        scr.append("	}\n");
        scr.append("	else {\n");
        scr.append("		collapseIt(el);\n");
        scr.append("	}\n");
        scr.append("}\n");
        scr.append("function switchJust(el) {\n");
        scr.append("	whichEl = eval(el + 'Child');\n");
        scr.append("	stateEl = whichEl.style.display;\n");
        scr.append("	collapseALL();\n");
        scr.append("	if (stateEl == 'none') {\n");
        scr.append("		expandIt(el);\n");
        scr.append("	}\n");
        scr.append("	else {\n");
        scr.append("		collapseIt(el);\n");
        scr.append("	}\n");
        scr.append("}\n");
        scr.append("function expandIt(el) {\n");
        scr.append("	whichEl = eval(el + 'Child');\n");
        scr.append("    if (olDisabledOutline[el] == true) {\n");
        scr.append("        return;\n");
        scr.append("    }\n");
        scr.append("	whichEl.style.display = 'block';\n");
        scr.append("	imgElement = event.srcElement;\n");
        scr.append("	if (outlineType() == 'outline') {\n");
        scr.append("		imgElement.src = getImageOutlineMinus();//outline\n");
        scr.append("	} else {\n");
        scr.append("		imgElement.src = getImageTwistDown();	//twist\n");
        scr.append("	}\n");
        scr.append("}\n");
        scr.append("function collapseIt(el) {\n");
        scr.append("	whichEl = eval(el + 'Child');\n");
        scr.append("	whichEl.style.display = 'none';\n");
        scr.append("	imgElement = event.srcElement;\n");
        scr.append("	if (outlineType() == 'outline') {\n");
        scr.append("		imgElement.src = getImageOutlinePlus();	//outline\n");
        scr.append("	} else {\n");
        scr.append("		imgElement.src = getImageTwistRight();	//twist\n");
        scr.append("	}\n");
        scr.append("}\n");
        scr.append("function collapseALL(){\n");
        scr.append("	initIt();\n");
        scr.append("}\n");
        scr.append("initOutlines();\n");
        return scr.toString();
    }

    /**
     * Método getOnKeyPress. Retorna o código a ser renderizado para o evento
     * HTML <i>onKeyPress</i>. Sem implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnKeyPress()
     * @return String - null.
     */
    public String getOnKeyPress() {
        return null;
    }

    /**
     * Método getOnBlur. Retorna o código a ser renderizado para o evento HTML
     * <i>onBlur</i>. Sem implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnBlur()
     * @return String - null.
     */
    public String getOnBlur() {
        return null;
    }

    /**
     * Método getOnFocus. Retorna o código a ser renderizado para o evento HTML
     * <i>onFocus</i>. Sem implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnFocus()
     * @return String - null.
     */
    public String getOnFocus() {
        return null;
    }

    /**
     * Método setControlName. Atribui à instância o nome de seus controles
     * separados por ";". O primeiro é o tipo de Outline e o segundo é o path
     * para obter as imagens. Sem implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#setControlName(java.lang.String)
     * @param controlName
     */
    public void setControlName(String controlName) {
        StringTokenizer tokenizer = new StringTokenizer(controlName, ";");

        switch (tokenizer.countTokens()) {
        case 2:
            this.outlineType = tokenizer.nextToken();
            this.imagePath = tokenizer.nextToken();
            break;
        case 1:
            this.outlineType = tokenizer.nextToken();
            LogUtilSigcb.warn("ExecutarOutline: falta parametro de controle imagePath");
            break;
        case 0:
            LogUtilSigcb.warn("ExecutarOutline: faltam parametros de controle outlineType e imagePath");
        }
    }
}
