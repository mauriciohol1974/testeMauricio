package br.com.politec.sao.jsp.scripts.ie;

import br.com.politec.sao.jsp.scripts.Script;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Esta classe tem por objetivo implementar para as tags um script respons�vel
 * por validar a integridade do conte�do dos campos do tipo data e comparar as
 * datas, pois a data do primeiro par�metro n�o pode ser maior que a data do
 * segundo par�metro.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @version release 1.3
 */
public class ComparaData extends Script {
    /**
     * M�todo getScript. Retorna um script que valida a integridade do conte�do
     * dos campos do tipo data e compara as datas, pois a data do primeiro
     * par�metro n�o pode ser maior que a data do segundo par�metro.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getScript()
     * @return String - Script da fun��o comparaDatas.
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
     * M�todo getOnKeyPress. Retorna o c�digo a ser renderizado para o evento
     * HTML <i>onKeyPress</i>. Sem implementa��o para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnKeyPress()
     * @return String - null.
     */
    public String getOnKeyPress() {
        return null;
    }

    /**
     * M�todo getOnBlur. Retorna o c�digo a ser renderizado para o evento HTML
     * <i>onBlur</i>. Sem implementa��o para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnBlur()
     * @return String - null.
     */
    public String getOnBlur() {
        return null;
    }

    /**
     * M�todo getOnFocus. Retorna o c�digo a ser renderizado para o evento HTML
     * <i>onFocus</i>. Sem implementa��o para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#getOnFocus()
     * @return String - null.
     */
    public String getOnFocus() {
        return null;
    }

    /**
     * M�todo setControlName. Atribui � inst�ncia o nome de seu controle. Sem
     * implementa��o para esta classe.
     * 
     * @see br.com.politec.sao.jsp.scripts.Script#setControlName(java.lang.String)
     * @param controlName
     */
    public void setControlName(String controlName) {
    }
}
