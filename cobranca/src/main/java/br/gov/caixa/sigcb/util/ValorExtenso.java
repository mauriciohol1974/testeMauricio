package br.gov.caixa.sigcb.util;

import java.math.BigDecimal;

import br.com.politec.sao.util.Money;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Classe utilizada para se obter a descrição de valor por extenso de um numero.
 * Politec Ltda.
 * 
 * @author ggallego - Glauber M. Gallego
 * @author Abetencourt - Andrew Betencourt
 * @created 14 Julho de 2003
 * @since 16 de Fevereiro de 2004
 */

public class ValorExtenso {

    /** Description of the Field */
    private BigDecimal numero;// The number that is going to be converted

    /** Description of the Field */
    private String extenso; // The String that is going to be returned

    /** Construtor padrão para o objeto ValorExtenso */
    public ValorExtenso() {
        this(new BigDecimal(0));
    }

    /**
     * Construtor para o objeto Extenso
     * 
     * @param num_
     *            Description of the Parameter
     */
    public ValorExtenso(BigDecimal numero) {
        setNumero(numero);
    }

    /**
     * Construtor para o objeto Extenso
     * 
     * @param num_
     *            Description of the Parameter
     */
    public ValorExtenso(double numero) {
        this(new BigDecimal(numero));
    }

    /**
     * Construtor para o objeto Extenso
     * 
     * @param num_
     *            Description of the Parameter
     */
    public ValorExtenso(Money numero) {
        this(numero.toBigDecimal());
    }

    /**
     * Construtor para o objeto Extenso
     * 
     * @param num_
     *            Description of the Parameter
     */
    public ValorExtenso(String numero) {
        this(new BigDecimal(numero));
    }

    /**
     * To set the number to be converted
     * 
     * @param num_
     *            Description of the Parameter
     */
    public void setNumero(BigDecimal numero) {
        this.extenso = new String();
        this.numero = numero;
        if (numero.scale() > 2) {
            extenso = "ERRO: PRECISÃO > QUE 2 DÍGITOS ";
        } else {
            extenso = getNumeroExtenso(numero);
        }
    }

    /** The function that makes the convertion */
    private String getNumeroExtenso(BigDecimal numero) {
        String extenso_do_numero = new String();

        if (numero.equals(new BigDecimal(0))) {
            return ("zero");
        }

        extenso_do_numero += formataNumeroInteiro(numero, 5);
        extenso_do_numero += formataNumeroInteiro(numero, 4);
        extenso_do_numero += formataNumeroInteiro(numero, 3);
        extenso_do_numero += formataNumeroInteiro(numero, 2);
        extenso_do_numero += formataNumeroInteiro(numero, 1);
        extenso_do_numero += formataNumeroInteiro(numero, 0);

        if (numero.longValue() == 1) {
            extenso_do_numero += " real";
        } else if (numero.longValue() != 0) {
            extenso_do_numero += " reais";
        }

        extenso_do_numero += formataNumeroCentavos(numero);

        return extenso_do_numero;
    }

    /**
     * formata o conj de milhar correspondente a posicao informada
     * 
     * @param n
     *            Description of the Parameter
     * @return o
     */
    private String formataNumeroInteiro(BigDecimal numero, int pos) {
        String extenso_do_numero = "";

        String nome[] = { "", "", // pos = 0
                         "mil", " mil", // pos = 1
                         "um milhão", " milhões", // pos = 2
                         "um bilhão", " bilhões", // pos = 3
                         "um trilhão", " trilhões", // pos = 4
                         "um quatrilhão", " quatrilhões" };// pos = 5

        long milheiros[] = { 0, 0, 0, 0, 0, 0 };

        long numeroLong = numero.longValue();
        int conector = 0;

        // quatrilhoes
        milheiros[5] = (numeroLong - (numeroLong % (long) Math.pow(1000, 5)))
                       / (long) Math.pow(1000, 5);
        numeroLong -= milheiros[5] * (long) Math.pow(1000, 5);
        // trilhoes
        milheiros[4] = (numeroLong - (numeroLong % (long) Math.pow(1000, 4)))
                       / (long) Math.pow(1000, 4);
        numeroLong -= milheiros[4] * (long) Math.pow(1000, 4);
        // bilhoes
        milheiros[3] = (numeroLong - (numeroLong % (long) Math.pow(1000, 3)))
                       / (long) Math.pow(1000, 3);
        numeroLong -= milheiros[3] * (long) Math.pow(1000, 3);
        // milhoes
        milheiros[2] = (numeroLong - (numeroLong % (long) Math.pow(1000, 2)))
                       / (long) Math.pow(1000, 2);
        numeroLong -= milheiros[2] * (long) Math.pow(1000, 2);
        // milhares
        milheiros[1] = (numeroLong - (numeroLong % (long) Math.pow(1000, 1)))
                       / (long) Math.pow(1000, 1);
        numeroLong -= milheiros[1] * (long) Math.pow(1000, 1);
        // unidade
        milheiros[0] = numeroLong;

        for (int i = 0; i <= pos; i++) {
            if (milheiros[i] > 999)
                return ("ERRO: NUMERO > QUE QUATRILHÃO ");
            conector += (milheiros[i] > 0) ? 1 : 0;
        }

        switch (pos) {
        case 0:
            extenso_do_numero += converteNumeroSimples(milheiros[pos]);
            break;
        case 1:
            if (milheiros[pos] > 0) {
                if (milheiros[pos] == 1 && conector == 1) {
                    extenso_do_numero += nome[pos * 2];
                } else {
                    extenso_do_numero += converteNumeroSimples(milheiros[pos]);
                    extenso_do_numero += nome[pos * 2 + 1];
                }
                if (milheiros[0] > 0) {
                    if ((milheiros[1] > 100) && (milheiros[0] > 100)) {
                        extenso_do_numero += ", ";
                    } else if (((milheiros[0] % 100) != 0)
                               || ((milheiros[0] % 100 == 0) && (milheiros[1] < 10))) {
                        extenso_do_numero += " e ";
                    } else {
                        extenso_do_numero += " ";
                    }
                }
            }
            break;
        case 2:
        case 3:
        case 4:
        case 5:
            if (milheiros[pos] > 0) {
                if (milheiros[pos] == 1) {
                    extenso_do_numero += nome[pos * 2];
                } else {
                    extenso_do_numero += converteNumeroSimples(milheiros[pos]);
                    extenso_do_numero += nome[pos * 2 + 1];
                }
                if (conector == 1)
                    extenso_do_numero += " de";
                else if (conector == 2)
                    extenso_do_numero += " e ";
                else if (conector > 2)
                    extenso_do_numero += ", ";
            }
            break;
        default:
            extenso_do_numero += "ERRO: NÚMERO > QUE QUATRILHÃO ";
        }

        return (extenso_do_numero);
    }

    private String formataNumeroCentavos(BigDecimal numero) {
        String extenso_do_numero = "";

        if (numero.scale() == 0) {
            return extenso_do_numero;
        }

        String centavoStr = numero.toString().substring(numero.toString()
                .indexOf(".") + 1);
        if (centavoStr.length() == 1) {
            centavoStr += "0";
        }

        long centavos = Long.parseLong(centavoStr);

        if (centavos != 0) {
            if (numero.longValue() != 0) {
                extenso_do_numero += " e ";
            }
            extenso_do_numero += converteNumeroSimples(centavos);
            extenso_do_numero += (centavos == 1) ? " centavo" : " centavos";
        }

        return (extenso_do_numero);
    }

    /**
     * Return the numbers between 0-999 in written form
     * 
     * @param n
     *            Description of the Parameter
     * @return ...
     */
    private String converteNumeroSimples(long n) {
        String extenso_do_numero = new String();
        String u[] = {
                      "",
                      "um",
                      "dois",
                      "três",
                      "quatro",
                      "cinco",
                      "seis",
                      "sete",
                      "oito",
                      "nove",
                      "dez",
                      "onze",
                      "doze",
                      "treze",
                      "quatorze",
                      "quinze",
                      "dezesseis",
                      "dezessete",
                      "dezoito",
                      "dezenove" };
        String d[] = {
                      "",
                      "",
                      "vinte",
                      "trinta",
                      "quarenta",
                      "cinquenta",
                      "sessenta",
                      "setenta",
                      "oitenta",
                      "noventa" };
        String c[] = {
                      "",
                      "cento",
                      "duzentos",
                      "trezentos",
                      "quatrocentos",
                      "quinhentos",
                      "seiscentos",
                      "setecentos",
                      "oitocentos",
                      "novecentos" };

        if ((n < 1000) && (n != 0)) {
            if (n == 100) {
                extenso_do_numero = "cem";
            } else {
                if (n > 99) {
                    extenso_do_numero += c[(int) (n / 100)];
                    if (n % 100 > 0) {
                        extenso_do_numero += " e ";
                    }
                }
                if (n % 100 < 20) {
                    extenso_do_numero += u[(int) n % 100];
                } else {
                    extenso_do_numero += d[((int) n % 100) / 10];
                    if ((n % 10 > 0) && (n > 10)) {
                        extenso_do_numero += " e ";
                        extenso_do_numero += u[(int) n % 10];
                    }
                }
            }
        } else if (n > 999) {
            extenso_do_numero = "ERRO: NÚMERO > 999 ";
        }
        return extenso_do_numero;
    }

    /**
     * Return the written form of the number
     * 
     * @return ...
     */
    public String getResult() {
        if (extenso == null) {
            return "Number is not set!";
        }
        String temp = extenso;
        extenso = null;
        return temp;
    }

    public static String getValorExtenso(String number) {
        StringBuffer sb = new StringBuffer();
        ValorExtenso ex = new ValorExtenso(number);

        sb.append(ex.getResult());

        return sb.toString();
    }

    public static String getValorExtenso(Money number) {
        StringBuffer sb = new StringBuffer();
        ValorExtenso ex = new ValorExtenso(number);

        sb.append(ex.getResult());

        return sb.toString();
    }

    public static void main(String[] args) {
        BigDecimal nn = new BigDecimal("9999999999999999999.99");
        if (args.length > 0) {
            try {
                nn = new BigDecimal(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Use java Extenso [número com '.' decimal]");
                System.exit(1);
            }
        }

        StringBuffer sb = new StringBuffer();
        ValorExtenso ex = new ValorExtenso(nn);
        sb.append(ex.getResult());

        System.out.println(sb);
    }
}