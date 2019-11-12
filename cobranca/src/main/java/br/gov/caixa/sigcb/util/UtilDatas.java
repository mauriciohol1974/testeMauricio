package br.gov.caixa.sigcb.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

//import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Classe que agrupa metodos uteis diversos.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>20/09/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */
public class UtilDatas {

    /**
     * Metodo que retorna se uma data é maior, menor ou igual a outra data
     * 
     * @param data1
     * @param data2
     * @return 1 (data1 maior que data2), 0(data1 igual a data2) e -1 (data1
     *         menor que data2
     */
    public static int comparaDatas(Date data1, Date data2) {

        int retorno = 0, dt1 = 0, dt2 = 0;

        GregorianCalendar cal1 = new GregorianCalendar();
        GregorianCalendar cal2 = new GregorianCalendar();

        cal1.setTime(data1);
        cal2.setTime(data2);

        String ano1 = "" + cal1.get(Calendar.YEAR);
        String mes1 = "" + cal1.get(Calendar.MONTH);
        String dia1 = "" + cal1.get(Calendar.DAY_OF_MONTH);

        if (mes1.length() == 1) {
            mes1 = "0" + mes1;
        }
        if (dia1.length() == 1) {
            dia1 = "0" + dia1;
        }

        String ano2 = "" + cal2.get(Calendar.YEAR);
        String mes2 = "" + cal2.get(Calendar.MONTH);
        String dia2 = "" + cal2.get(Calendar.DAY_OF_MONTH);

        if (mes2.length() == 1) {
            mes2 = "0" + mes2;
        }
        if (dia2.length() == 1) {
            dia2 = "0" + dia2;
        }

        dt1 = Integer.parseInt(ano1 + mes1 + dia1);
        dt2 = Integer.parseInt(ano2 + mes2 + dia2);

        if (dt1 > dt2) {
            retorno = 1;
        } else if (dt1 < dt2) {
            retorno = -1;
        } else if (dt1 == dt2) {
            retorno = 0;
        }

        return retorno;
    }

    /**
     * Metodo que retorna a data do dia
     * 
     * @return String today
     */
    public static String getToday() {
        String today = "";

        Date data = Calendar.getInstance().getTime();
        // GregorianCalendar data = new GregorianCalendar();

        // today = data.get(Calendar.DAY_OF_MONTH) + "/" +
        // data.get(Calendar.MONTH) + "/" +
        // data.get(Calendar.YEAR);
        today = Formatador.formatarData(data);
        return today;
    }
}
