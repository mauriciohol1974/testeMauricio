package br.gov.caixa.sigcb.util;

import br.com.politec.sao.util.Money;
import br.com.politec.sao.util.Percentual;
import br.com.politec.sao.util.Utils;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Nome da funcionalidade
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>23/09/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class Util {

    private static final char[] charForDigit = {
                                                '0',
                                                '1',
                                                '2',
                                                '3',
                                                '4',
                                                '5',
                                                '6',
                                                '7',
                                                '8',
                                                '9' };

    /*
     * public static void main(String[] args) { }
     */

    public static String zerosEsquerda(Long valor, int digitosNecessarios) {

        String strNumeroZ = "";
        long numero = 0;

        if (valor != null) {
            numero = valor.longValue();
        } else {
            return "";
        }

        if (digitosNecessarios > 0) {
            final int digitos = Utils.digits(numero);
            if (digitosNecessarios < digitos) {
                final int fator = (int) Math.pow(10, digitosNecessarios);
                numero %= fator;
            } else if (digitosNecessarios > digitos) {
                for (int i = digitosNecessarios - digitos; i > 0; i--) {
                    strNumeroZ += charForDigit[0];
                }
            }
            strNumeroZ += numero;
        }
        return strNumeroZ;
    }

    public static String completaEspacos(String texto, int caracteresNecessarios) {
        String str = "";

        if (caracteresNecessarios > 0) {
            final int caracteres = texto.length();
            if (caracteresNecessarios < caracteres) {
                str += texto.substring(0, caracteresNecessarios);
            } else if (caracteresNecessarios > caracteres) {
                str += texto;
                for (int i = caracteresNecessarios - caracteres; i > 0; i--) {
                    str += " ";
                }
            } else {
                str += texto;
            }
        }

        return str;
    }

    /**
     * método que subistitui um caracter dentro de uma string por outro qualquer
     * e retorna uma string.
     * 
     * @param antigoCaracter
     * @param novoCaracter
     * @param texto
     * @return resultado
     */
    public static String trocaCaracter(char antigoCaracter,
            char novoCaracter,
            String texto) {

        String resultado = "";

        char[] c = texto.toCharArray();

        for (int i = 0; i < c.length; i++) {
            if (c[i] == antigoCaracter) {
                c[i] = novoCaracter;
            }
            resultado += c[i];
        }

        return resultado;
    }

    /**
     * Se eh diferente de null e de 0 volta o numero no formato String senao
     * volta String vazia
     */
    public static String toStr(Long numero) {
        return Util.toStr(numero, "");
    }

    /**
     * Se eh diferente de null e de 0 volta o numero no formato String senao
     * volta String padrao
     */
    public static String toStr(Long numero, String padrao) {
        if (numero != null && numero.intValue() != 0) {
            return numero.toString();
        }
        return padrao;
    }

    /**
     * Se eh diferente de null e de 0 volta o precentual no formato String senao
     * volta String vazia
     */
    public static String toStr(Percentual perc) {
        return Util.toStr(perc, "");
    }

    /**
     * Se eh diferente de null e de 0 volta o precentual no formato String senao
     * volta String padrao
     */
    public static String toStr(Percentual perc, String padrao) {
        if (perc != null && perc.toDoubleValue() != 0) {
            return perc.toString();
        }
        return padrao;
    }

    /**
     * Se eh diferente de null e de 0 volta o money no formato String senao
     * volta String vazia
     */
    public static String toStr(Money money) {
        return Util.toStr(money, "");
    }

    /**
     * Se eh diferente de null e de 0 volta o money no formato String senao
     * volta String padrao
     */
    public static String toStr(Money money, String padrao) {
        if (money != null
            && (money.getDecimalAmount() != 0 || money.getIntegerAmount() != 0)) {
            return money.toString();
        }
        return padrao;
    }

    /**
     * Se eh diferente de null volta a String senao volta String vazia
     */
    public static String toStr(String str) {
        return Util.toStr(str, "");
    }

    /**
     * Se eh diferente de null volta a String senao volta String padrao
     */
    public static String toStr(String str, String padrao) {
        if (str != null && !str.equals("")) {
            return str;
        }
        return padrao;
    }

}