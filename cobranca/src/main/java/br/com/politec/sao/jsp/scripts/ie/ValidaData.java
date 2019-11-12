package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Implementa para as tags um script responsável por validar a integridade do
 * conteúdo de um valor do tipo data.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @author Eduardo A. Moras - emoras@sao.politec.com.br Alterada a opção de foco
 *         do campo, não atribuindo foco em um campo desabilitado. * *
 * @version release 1.4
 */
public class ValidaData extends Script {
    /**
     * Método getScript. Retorna um script que valida a integridade do conteúdo
     * de um valor do tipo data.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Scripts das funções isValidDataChar e validaData.
     */
    public String getScript() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("function isValidDataChar (c) {");
        buffer.append("  return ((c >= '0') && (c <= '9') || c == '/')");
        buffer.append("}");
        buffer.append("function validaData(obj) {");
        buffer.append("  var s1 = obj.value;");
        buffer.append("  var s2='';");
        buffer.append("  var sdata = '';");
        buffer.append("  if (s1.length!=10) {");
        buffer.append("    try{ if(!obj.disabled) {");
        buffer.append("    obj.focus();}}catch(exp){}");
        buffer.append("    return false;");
        buffer.append("  } else if(s1.charAt(2)!='/' || s1.charAt(5)!='/') {");
        buffer.append("    try{ if(!obj.disabled) {");
        buffer.append("    obj.focus();}}catch(exp){}");
        buffer.append("    return false;");
        buffer.append("  }");
        buffer.append("  var d1 = new Date();");
        buffer.append("  var dia = d1.getDate();");
        buffer.append("  var mes = eval(d1.getMonth()+1);");
        buffer.append("  var ano = d1.getYear();");
        buffer.append("  dia = (parseInt(dia)<10) ? '0' + dia : dia;");
        buffer.append("  mes = (parseInt(mes)<10) ? '0' + mes : mes;");
        buffer.append("  var d2 = ano + '' + mes + '' + dia;");
        buffer.append("  for (i = 0; i < s1.length; i++) {");
        buffer.append("    if (!isValidDataChar(s1.charAt(i))) {");
        buffer.append("      try{ if(!obj.disabled) {");
        buffer.append("        obj.focus();}}catch(exp){}");
        buffer.append("        return false;");
        buffer.append("      } else if (i!=2 && i!=5) {");
        buffer.append("      s2+=s1.charAt(i);");
        buffer.append("    }");
        buffer.append("  }");
        buffer.append("  sdata = s2.substring(4,9) + '' + s2.substring(2,4) + '' + s2.substring(0,2);");
        buffer.append("  var sdia = s1.substring(0,2);");
        buffer.append("  var smes = s1.substring(3,5);");
        buffer.append("  var sano = s1.substring(6,10);");
        buffer.append("  var idia = parseFloat(sdia);");
        buffer.append("  var imes = parseFloat(smes);");
        buffer.append("  var iano = parseFloat(sano);");
        buffer.append("  if ((imes==1 || imes==3 || imes==5 || imes==7 || imes==8 || imes==10 || imes==12) && idia>31) {");
        buffer.append("    try{ if(!obj.disabled) {");
        buffer.append("    obj.focus();}}catch(exp){}");
        buffer.append("    return false;");
        buffer.append("    } else if ((imes==4 || imes==6 || imes==9 || imes==11) && idia>30) {");
        buffer.append("      try{ if(!obj.disabled) {");
        buffer.append("      obj.focus();}}catch(exp){}");
        buffer.append("      return false;");
        buffer.append("    } else if (imes==2) {");
        buffer.append("      if ((iano%4 != 0) && (idia>28)) {");
        buffer.append("        try{ if(!obj.disabled) {");
        buffer.append("        obj.focus();}}catch(exp){}");
        buffer.append("      return false;");
        buffer.append("    } else if ((iano%4 == 0) && (idia>29)) {");
        buffer.append("      try{ if(!obj.disabled) {");
        buffer.append("        obj.focus();}}catch(exp){}");
        buffer.append("        return false;");
        buffer.append("      }");
        buffer.append("    }");
        buffer.append("    if (idia==0) {");
        buffer.append("      try{ if(!obj.disabled) {");
        buffer.append("      obj.focus();}}catch(exp){}");
        buffer.append("      return false;");
        buffer.append("    }");
        buffer.append("    if (imes>12 || imes==0) {");
        buffer.append("      try{ if(!obj.disabled) {");
        buffer.append("      obj.focus();}}catch(exp){}");
        buffer.append("      return false;");
        buffer.append("    }");
        buffer.append("    if (iano<1900) {");
        buffer.append("      try{ if(!obj.disabled) {");
        buffer.append("      obj.focus();}}catch(exp){}");
        buffer.append("      return false;");
        buffer.append("    }");
        buffer.append("    return true;");
        buffer.append("  }");
        return buffer.toString();
    }

    /**
     * Método getOnKeyPress. Retorna o código a ser renderizado para o evento
     * HTML <i>onKeyPress</i>. Sem implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnKeyPress()
     * @return String
     */
    public String getOnKeyPress() {
        return "";
    }

    /**
     * Método getOnBlur. Retorna o código a ser renderizado para o evento HTML
     * <i>onBlur</i>. Sem implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnBlur()
     * @return String
     */
    public String getOnBlur() {
        return "";
    }

    /**
     * Método getOnFocus. Retorna o código a ser renderizado para o evento HTML
     * <i>onFocus</i>. Sem implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnFocus()
     * @return String
     */
    public String getOnFocus() {
        return "";
    }

    /**
     * Método setControlName. Atribui à instância o nome de seu controle. Sem
     * implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#setControlName(java.lang.String)
     * @param controlName
     */
    public void setControlName(String controlName) {
    }
}
