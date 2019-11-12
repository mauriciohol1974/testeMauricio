package br.com.politec.sao.util;

import java.text.DecimalFormat;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Esse objeto � um utilit�rio para formatar strings. Possui m�todos que pegam
 * uma string dada e a formatam de modo � preencher espa�os em branco caso ela
 * tenha tamanho menor que o definido pelo seu formato. � baseada nas defini��es
 * do padr�o de pacotes ISO 8583.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class Formatacao {

    public static void main(String arg[]) {
        /*
         * AL - 30/04/2007 Solicita��o SIT em 12/04/2007 - Evitar
         * System.(out|err).print, � recomendado utilizar o sistema de Log.
         */
        // System.out.println(Formatacao.formataPadraoBrasileiro(0.45));
    }

    /**
     * Impede que a classe seja instanciada. Como ela apenas possui m�todos
     * est�ticos, deve-se chamar o m�todo pelo nome da classe.
     */
    private Formatacao() {
    }

    /**
     * Formata uma string passada com o padr�o para strings alfanum�ricas.
     * 
     * @param valor
     *            a string a ser formatada
     * @param tamanho
     *            o tamanho que a string formatada deve ter
     * @return a string formatada
     */
    public static String formataAlfanumerico(String valor, int tamanho) {
        valor = valor.trim();
        valor = valor.toUpperCase();
        if (valor.length() < tamanho) {
            char[] espacos = new char[tamanho - valor.length()];
            for (int i = 0; i < espacos.length; i++) {
                espacos[i] = ' ';
            }
            valor = valor + (new String(espacos));
        } else if (valor.length() > tamanho) {
            valor = valor.substring(0, tamanho);
        }
        return valor;
    }

    /**
     * Formata uma string passada com o padr�o para strings num�ricas.
     * 
     * @param valor
     *            a string a ser formatada
     * @param tamanho
     *            o tamanho que a string formatada deve ter
     * @return a string formatada
     */
    public static String formataNumerico(String valor, int tamanho) {
        valor = valor.trim();
        if (valor.length() < tamanho) {
            char[] zeros = new char[tamanho - valor.length()];
            for (int i = 0; i < zeros.length; i++) {
                zeros[i] = '0';
            }
            valor = (new String(zeros)) + valor;
        } else if (valor.length() > tamanho) {
            valor = valor.substring(valor.length() - tamanho, valor.length());
        }
        return valor;
    }

    /**
     * Apenas remove as barras de uma data passada. N�o faz quaisquer valida��es
     * a respeito do conte�do. Ele assume que a data ter� 10 posi��es com duas
     * barras nas posi��es 2 e 5. Se o par�metro passado estiver errado ocorrer�
     * uma <CODE>Exception</CODE> qualquer.
     * 
     * @param data
     *            uma data no formato <I>dd/mm/aaaa</I>
     * @return uma data no formato <I>ddmmaaaa<I>
     */
    public static String removeBarrasData(String data) {
        return data.substring(0, 2)
               + data.substring(3, 5)
               + data.substring(6, 10);
    }

    /**
     * Apenas coloca as barras em uma data passada. N�o faz quaisquer valida��es
     * a respeito do conte�do. Ele assume que a data ter� 8 posi��es sem barras.
     * Se o par�metro passado estiver errado ocorrer� uma <CODE>Exception</CODE>
     * qualquer.
     * 
     * @param data
     *            uma data no formato <I>ddmmaaaa<I>
     * @return uma data no formato <I>dd/mm/aaaa</I>
     */
    public static String colocaBarrasData(String data) {
        return data.substring(0, 2)
               + "/"
               + data.substring(2, 4)
               + "/"
               + data.substring(4, 8);
    }

    /**
     * Apenas remove os dois pontos de uma hora passada. N�o faz quaisquer
     * valida��es a respeito do conte�do. Ele assume que a hora ter� 8 posi��es
     * com dois dos pontos nas posi��es 2 e 5. Se o par�metro passado estiver
     * errado ocorrer� uma <CODE>Exception</CODE> qualquer.
     * 
     * @param hora
     *            uma hora no formato <I>hh:mm:ss</I>
     * @return uma hora no formato <I>hhmmss<I>
     */
    public static String removePontosHora(String hora) {
        return hora.substring(0, 2)
               + hora.substring(3, 5)
               + hora.substring(6, 8);
    }

    /**
     * Apenas coloca os dois pontos em uma data passada. N�o faz quaisquer
     * valida��es a respeito do conte�do. Ele assume que a hora ter� 6 posi��es
     * sem os dois pontos. Se o par�metro passado estiver errado ocorrer� uma
     * <CODE>Exception</CODE> qualquer.
     * 
     * @param hora
     *            uma hora no formato <I>hhmmss</I>
     * @return uma hora no formato <I>hh:mm:ss<I>
     */
    public static String colocaPontosHora(String hora) {
        return hora.substring(0, 2)
               + ":"
               + hora.substring(2, 4)
               + ":"
               + hora.substring(4, 6);
    }

    /**
     * Apenas remove a v�rgula de um n�mero com decimal. N�o faz quaisquer
     * valida��es a respeito do conte�do.
     * 
     * @param numero
     *            um n�mero com decimais e v�rgula antes delas
     * @param virgula
     *            o caractere utilizado como separador de decimais
     * @return o n�mero sem a v�rgula
     */
    public static String removeVirgula(String numero, char virgula) {
        // modificado por javier para corrigir problema
        // remo��o de mais de um caracter decimal.
        int posicaoVirgula = numero.indexOf(virgula);
        ;
        do {
            posicaoVirgula = numero.indexOf(virgula);
            if (posicaoVirgula == -1) {
            } else if (posicaoVirgula == numero.length()) {
                numero = numero.substring(0, posicaoVirgula);
            } else {
                numero = numero.substring(0, posicaoVirgula)
                         + numero.substring(posicaoVirgula + 1);
            }
            posicaoVirgula = numero.indexOf(virgula);
        } while (posicaoVirgula != -1);
        return numero;
    }

    /**
     * Apenas coloca a v�rgula de um n�mero com decimal. N�o faz quaisquer
     * valida��es a respeito do conte�do. Assume que a v�rgula dever� ser
     * colocada antes dos caracteres decimais, que o n�mero est� vindo sem
     * espa�os a mais, alinhado � direita e que possui d�gitos suficientes antes
     * da v�rgula para que o processo de acrescentar a v�rgula n�o pegue
     * posi��es inv�lidas do n�mero. Quaisquer incorre��es nesse padr�o resultam
     * numa exce��o que n�o � tratada pelo m�todo.
     * 
     * @param numero
     *            um n�mero com decimais
     * @param virgula
     *            o caractere utilizado como separador de decimais
     * @param decimais
     *            a quantidade de decimais que o n�mero possui
     * @return o n�mero com decimais e v�rgula antes delas
     */
    public static String colocaVirgula(String numero, char virgula, int decimais) {
        return numero.substring(0, numero.length() - decimais)
               + virgula
               + numero.substring(numero.length() - decimais);
    }

    /**
     * Checa um n�mero passado de acordo com a quantidade de caracteres decimais
     * que ele pode possuir, acrescenta quantos zeros forem necess�rios � parte
     * decimal do n�mero e remove a v�rgula.
     * 
     * @param numero
     *            um n�mero com decimais
     * @param virgula
     *            o caractere utilizado como separador de decimais
     * @param decimais
     *            a quantidade de decimais que o n�mero possui
     * @return o n�mero sema v�rgula
     */
    public static String formataVirgula(String numero,
            char virgula,
            int decimais) {
        int posicaoVirgula = numero.indexOf(virgula);
        String parteInteira = "";
        String parteDecimal = "";
        if (posicaoVirgula == -1) {
            parteInteira = numero.trim();
        } else if (posicaoVirgula == numero.length()) {
            parteInteira = numero.substring(0, posicaoVirgula).trim();
        } else {
            parteInteira = numero.substring(0, posicaoVirgula).trim();
            parteDecimal = numero.substring(posicaoVirgula + 1).trim();
            int zerosNecessarios = decimais - parteDecimal.length();
            if (zerosNecessarios > 0) {
                char zeros[] = new char[zerosNecessarios];
                for (int i = 0; i < zeros.length; i++) {
                    zeros[i] = '0';
                }
                parteDecimal = parteDecimal + new String(zeros);
                if (parteDecimal.length() > decimais) {
                    parteDecimal = parteDecimal.substring(0, decimais);
                }
            } else if (decimais == 0) {
                parteDecimal = "";
            } else {
                parteDecimal = parteDecimal.substring(0, decimais);
            }
        }
        return parteInteira + parteDecimal;
    }

    /**
     * Formata uma string com numeros para o padrao de CNPJ
     * (000.000.000/0000-00)
     * 
     * @param numero
     *            a ser formatado
     * @return a string formatada
     */
    public static String formataCNPJ(String numero) {
        if (numero.length() < 7) {
            return numero;
        }
        String cnpj = "/"
                      + numero.substring(numero.length() - 6,
                              numero.length() - 2)
                      + "-"
                      + numero.substring(numero.length() - 2, numero.length());
        numero = numero.substring(0, numero.length() - 6);
        while (numero.length() > 3) {
            cnpj = "."
                   + numero.substring(numero.length() - 3, numero.length())
                   + cnpj;
            numero = numero.substring(0, numero.length() - 3);
        }
        return numero + cnpj;
    }

    /**
     * Formata uma string com numeros para o padrao de CPF (000.000.000-00)
     * 
     * @param numero
     *            a ser formatado
     * @return a string formatada
     */
    public static String formataCPF(String numero) {
        if (numero.length() < 6) {
            return numero;
        }
        if (numero.length() > 11) {
            numero = numero.substring(numero.length() - 11, numero.length());
        }
        String cpf = "-"
                     + numero.substring(numero.length() - 2, numero.length());
        numero = numero.substring(0, numero.length() - 2);
        while (numero.length() > 3) {
            cpf = "."
                  + numero.substring(numero.length() - 3, numero.length())
                  + cpf;
            numero = numero.substring(0, numero.length() - 3);
        }
        return numero + cpf;
    }

    public static boolean validaCPF(String numero) {
        if (numero.length() != 11) {
            return false;
        }
        // Verifica��o do primeiro digito
        int soma = 0;
        for (int i = 1; i <= 9; i++) {
            soma += (i + 1)
                    * Integer.parseInt(numero.substring(9 - i, 9 - i + 1));
        }
        int digito = (soma % 11);
        if (digito != 0) {
            digito = 11 - digito;
            if (digito == 10) {
                digito = 0;
            }
        }
        if (Integer.parseInt(numero.substring(9, 10)) != digito) {
            return false;
        }
        // Verificacao do segundo digito
        soma = 0;
        for (int i = 1; i < 10; i++) {
            soma += (i + 1)
                    * Integer.parseInt(numero.substring(10 - i, 10 - i + 1));
        }
        digito = (soma % 11);
        if (digito != 0) {
            digito = 11 - digito;
            if (digito == 10) {
                digito = 0;
            }
        }
        if (Integer.parseInt(numero.substring(10, 11)) != digito) {
            return false;
        }
        return true;
    }

    /**
     * Formata uma string para padrao de CPF ou CNPJ, de acordo com o conteudo
     * 
     * @param numero
     *            a ser formatado
     * @return a string formatada
     */
    public static String formataCPFCNPJ(String numero) {
        if (numero.length() == 15 && numero.substring(0, 4).equals("0000")) {
            if (validaCPF(numero.substring(4, 15))) {
                return formataCPF(numero.substring(4, 15));
            }
        }
        return validaCPF(numero) ? formataCPF(numero) : formataCNPJ(numero);
    }

    /**
     * Formata Long em String no formato CEP
     * 
     * @param long
     *            com m�ximo 8 d�gitos
     * @return String com CEP formatado
     */
    public static String formataCep(Long value) {
        String cepFormatado = zerosEsquerda(value, 8);
        cepFormatado = cepFormatado.toString().substring(0, 5)
                       + "-"
                       + cepFormatado.toString().substring(5, 8);

        return cepFormatado;
    }

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

    public static String formataData(String value) {

        if ((value != null) && (value.trim().length() == 10)) {
            return value.substring(0, 2)
                   + "/"
                   + value.substring(3, 5)
                   + "/"
                   + value.substring(6, 10);

        } else {
            return value;
        }
    }

    public static String desformataData(String value) {

        if ((value != null) && (value.trim().length() == 10)) {
            return value.substring(0, 2)
                   + "."
                   + value.substring(3, 5)
                   + "."
                   + value.substring(6, 10);

        } else {
            return value;
        }
    }

    public static String formataPadraoBrasileiro(Double value) {
        DecimalFormat decimalFormat = new DecimalFormat("##,##0.00");
        return decimalFormat.format(value);
    }

}