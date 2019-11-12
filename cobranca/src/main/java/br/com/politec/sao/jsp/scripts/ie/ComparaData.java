package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Esta classe tem por objetivo implementar para as tags um script responsável
 * por validar a integridade do conteúdo dos campos do tipo data e comparar as
 * datas, pois a data do primeiro parâmetro não pode ser maior que a data do
 * segundo parâmetro.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class ComparaData extends Script {
    /**
     * Método getScript. Retorna um script que valida a integridade do conteúdo
     * dos campos do tipo data e compara as datas, pois a data do primeiro
     * parâmetro não pode ser maior que a data do segundo parâmetro.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Script da função comparaDatas.
     */
    public String getScript() {
        return "function comparaDatas(data1, data2) {"
               + "	var dia1=0;"
               + "var dia2=0;"
               + "var mes1=0;"
               + "var mes2=0;"
               + "var ano1=0;"
               + "var ano2=0;"
               + "sepDia1 = sepMes1 = sepDia2 = sepMes2 = 0;"
               + "sepDia1 = data1.indexOf('/');"
               + "sepDia2 = data2.indexOf('/');"
               + "sepMes1 = data1.indexOf('/', sepDia1 + 1);"
               + "sepMes2 = data2.indexOf('/', sepDia2 + 1);"
               + "if(sepDia1 <= 0 || sepMes1 <= 0 || sepDia2 <= 0 || sepMes2 <= 0)"
               + "return false;"
               + "dia1 = new Number( data1.substr(0, sepDia1) );"
               + "mes1 = new Number( data1.substr(sepDia1 + 1, sepMes1 - (sepDia1 + 1)) );"
               + "ano1 = new Number( data1.substr(sepMes1 + 1) );"
               + "dia2 = new Number( data2.substr(0, sepDia2) );"
               + "mes2 = new Number( data2.substr(sepDia2 + 1, sepMes2 - (sepDia2 + 1)) );"
               + "ano2 = new Number( data2.substr(sepMes2 + 1, data2.length - sepMes2) );"
               + "dia1 = dia1.valueOf();"
               + "dia2 = dia2.valueOf();"
               + "mes1 = mes1.valueOf();"
               + "mes2 = mes2.valueOf();"
               + "ano1 = ano1.valueOf();"
               + "ano2 = ano2.valueOf();"
               + "if(	dia1 < 1  || dia1 > 31 || dia2 < 1  || dia2 > 31 ||"
               + "mes1 < 1  || mes1 > 12 || mes2 < 1  || mes2 > 12 ||"
               + "ano1 == 0  || ano2 == 0)"
               + "return false;"
               + "if (ano1 < ano2){"
               + "return true;"
               + "}"
               + "else{"
               + "if (ano1 == ano2){"
               + "if (mes1 < mes2){"
               + "return true;"
               + "}"
               + "else{"
               + "if (mes1 == mes2){"
               + "if (dia1 < dia2 || dia1 == dia2){"
               + "return true;"
               + "}"
               + "else{"
               + "if (dia1 > dia2){"
               + "return false;"
               + "}"
               + "}"
               + "}"
               + "else{"
               + "if (mes1 > mes2){"
               + "return false;"
               + "}"
               + "}"
               + "}"
               + "}"
               + "else{"
               + "if (ano1 > ano2){"
               + "return false;"
               + "}"
               + "}"
               + "}"
               + "}";
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
     * Método setControlName. Atribui à instância o nome de seu controle. Sem
     * implementação para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#setControlName(java.lang.String)
     * @param controlName
     */
    public void setControlName(String controlName) {
    }
}
