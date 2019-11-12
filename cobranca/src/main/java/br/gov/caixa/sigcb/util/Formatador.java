package br.gov.caixa.sigcb.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.politec.sao.util.Utils;

public class Formatador {

    protected static DecimalFormat valor;

    protected static SimpleDateFormat formatoPeriodo = new SimpleDateFormat("MM/yyyy");

    protected static SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

    protected static SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");

    protected static SimpleDateFormat formatoDataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    protected static SimpleDateFormat formatoDataHoraSQL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    protected static SimpleDateFormat formatoDataSQL = new SimpleDateFormat("yyyy-MM-dd");

    protected static SimpleDateFormat formatoHoraSQL = new SimpleDateFormat("HH:mm:ss");

    protected static DecimalFormatSymbols simbolos = new DecimalFormatSymbols();

    protected static SimpleDateFormat formatoDataHoraSegundoMili = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS");

    static {
        simbolos.setDecimalSeparator(',');
        simbolos.setGroupingSeparator('.');
        valor = new DecimalFormat("#,##0.00", simbolos);
    }

    public static String adicionarMascara(String mascara, String texto) {
        if (texto == null) {
            texto = "";
        } else if (texto.length() > mascara.length()) {
            texto = texto.substring(texto.length() - mascara.length());
        }
        StringBuffer result = new StringBuffer();

        int textPos = texto.length() - 1;

        for (int pos = mascara.length() - 1; pos >= 0; pos--) {
            if (mascara.charAt(pos) == '0') {
                if (textPos >= 0) {
                    result.insert(0, texto.charAt(textPos--));
                } else {
                    result.insert(0, mascara.charAt(pos));
                }
            } else if (mascara.charAt(pos) == '#') {
                if (textPos >= 0) {
                    result.insert(0, texto.charAt(textPos--));
                }
            } else {
                result.insert(0, mascara.charAt(pos));
            }
        }
        return result.toString();
    }

    public static String removerMascara(String mascara, String texto) {
        if (texto == null || texto.length() != mascara.length()) {
            return "";
        }
        StringBuffer ret = new StringBuffer();

        for (int pos = mascara.length() - 1; pos >= 0; pos--) {
            if (mascara.charAt(pos) == '0') {
                ret.insert(0, texto.charAt(pos));
            }
        }
        return ret.toString();
    }

    public static String formatarCep(int num) {
        return formatarCep(String.valueOf(num));
    }

    public static String formatarCC(String contaCorrente) {
        return adicionarMascara("000000000000-0", contaCorrente);
    }

    public static String formatarCodOper(String operador) {
        return adicionarMascara("00000", operador);
    }

    public static String formatarCep(String cep) {
        return adicionarMascara("00000-000", cep);
    }

    public static String formatarCpf(String cpf) {
        return adicionarMascara("000.000.000-00", cpf);
    }

    public static String formatarCnpj(String cnpj) {
        return adicionarMascara("00.000.000/0000-00", cnpj);
    }

    // EAM - Início - Formatação codigoCedente/nossoNumero/unidade

    // Cedente com 6 posições
    public static String formatarCodigoCedente(Long codigoCedente) {
        if (codigoCedente == null || codigoCedente.equals(new Long(0))) {
            return "";
        } else {
            return adicionarMascara("0000000", codigoCedente.toString());
        }

    }

    // EAM - Início - Formatação codigoCedente/nossoNumero/unidade

    // Cedente com 6 posições
    public static String formatarCodigoSince(Long codigoSince) {
        if (codigoSince == null || codigoSince.equals(new Long(0))) {
            return "";
        } else {
            return adicionarMascara("000000000", codigoSince.toString());
        }

    }
    // nossoNumero com 17 posições
    // EAM - 12/09 - Alterado para utilizar o método formatarNossoNumero(Long
    // nossoNumero,int digitos)
    
    public static String formatarNossoNumero18(Long nossoNumero) {
        return formatarNossoNumero(nossoNumero, 18);
    }
    
    public static String formatarNossoNumero(Long nossoNumero) {
        return formatarNossoNumero(nossoNumero, 17);
    }

    // EAM - 12/09
    // nossoNumero com xx posições
    public static String formatarNossoNumero(Long nossoNumero, int digitos) {
        if (nossoNumero == null || nossoNumero.equals(new Long(0))) {
            return "";
        } else {
            StringBuffer mascara = new StringBuffer();
            while (digitos > 0) {
                mascara.append("0");
                digitos--;
            }
            return adicionarMascara(mascara.toString(), nossoNumero.toString());
        }
    }

    // unidade com 4 posições
    public static String formatarUnidade(Long unidade) {
        if (unidade == null || unidade.equals(new Long(0))) {
            return "";
        } else {
            return adicionarMascara("0000", unidade.toString());
        }

    }

    public static String formatarUnidade(String unidade) {
        try {
            if (unidade == null || unidade.trim().equals("")) {
                return "";
            } else if (Integer.parseInt(unidade) == 0) {
                return "";
            } else {
                return adicionarMascara("0000", unidade);
            }
        } catch (Exception e) {
            return "";
        }
    }

    // operacao com 3 posições
    public static String formatarOperacao(String operacao) {
        try {
            if (operacao == null || operacao.trim().equals("")) {
                return "";
            } else if (Integer.parseInt(operacao) == 0) {
                return "";
            } else {
                return adicionarMascara("000", operacao);
            }
        } catch (Exception e) {
            return "";
        }
    }

    // conta com 8 posições
    public static String formatarConta(String conta) {
        try {
            if (conta == null || conta.trim().equals("")) {
                return "";
            } else if (Integer.parseInt(conta) == 0) {
                return "";
            } else {
                return adicionarMascara("00000000", conta);
            }
        } catch (Exception e) {
            return "";
        }
    }

    // EAM - Fim - Formatação codigoCedente/nossoNumero/unidade

    public static String formatarCpfCnpj(String cpfCnpj) {
        if (cpfCnpj != null && cpfCnpj.length() >= 14) {
            return formatarCnpj(cpfCnpj);
        }
        return formatarCpf(cpfCnpj);
    }

    public static String formatarNumero(double valor, String mascara) {
        return new DecimalFormat(mascara, simbolos).format(valor);
    }

    public static String formatarValor(BigDecimal decimal) {
        if (decimal == null) {
            return "";
        }
        return valor.format(decimal.doubleValue());
    }

    public static BigDecimal desformatarValor(String s) throws Exception {
        try {
            if (s == null) {
                return null;
            }
            s = removerCaracteres(s, "0123456789,");
            return new BigDecimal(valor.parse(s.replace(',', '.'))
                    .doubleValue());
        } catch (ParseException e) {
            throw new Exception(e.getMessage());
        }
    }

    public static BigDecimal desformatarValorCobol(String s, int casasDecimais)
            throws Exception {
        if (s == null) {
            return null;
        }
        return new BigDecimal(new BigInteger(s), casasDecimais);
    }

    public static String formatarData(Date data) {
        if (data == null) {
            return "";
        }
        return formatoData.format(data);
    }

    public static Date desformatarData(String s) throws Exception {
        if (s == null) {
            return null;
        }
        try {
            return formatoData.parse(s);
        } catch (ParseException e) {
            throw new Exception(e.getMessage());
        }
    }

    public static String formatarPeriodo(String data) {
        if (data == null) {
            return "";
        }
        return formatoPeriodo.format(data);
    }

    public static String desformatarPeriodo(String s) throws Exception {
        if (s == null) {
            return null;
        }
        return removerMascara("00/0000", s);
    }

    public static String formatarHora(Date data) {
        if (data == null) {
            return "";
        }
        return formatoHora.format(data);
    }

    public static Date desformatarHora(String s) throws Exception {
        if (s == null) {
            return null;
        }
        try {
            return formatoHora.parse(s);
        } catch (ParseException e) {
            throw new Exception(e.getMessage());
        }
    }

    public static String formatarDataHora(Date data) {
        if (data == null) {
            return "";
        }
        return formatoDataHora.format(data);
    }

    public static Date desformatarDataHora(String s) throws Exception {
        if (s == null) {
            return null;
        }
        try {
            return formatoDataHora.parse(s);
        } catch (ParseException e) {
            throw new Exception(e.getMessage());
        }
    }

    public static String formatarDataSQL(Date data) {
        if (data == null) {
            return "null";
        }
        return "'" + formatoDataSQL.format(data) + "'";
    }

    public static String formatarStringSQL(String s) {
        if (s == null) {
            return "null";
        }
        return "'" + s + "'";
    }

    public static String formatarHoraSQL(Date data) {
        if (data == null) {
            return "null";
        }
        return "'" + formatoHoraSQL.format(data) + "'";
    }

    public static String formatarDataHoraSQL(Date data) {
        if (data == null) {
            return "null";
        }
        return "'" + formatoDataHoraSQL.format(data) + "'";
    }

    public static String removerCaracteres(String texto, String charsValidos) {
        if (texto == null) {
            return "";
        }
        StringBuffer ret = new StringBuffer();

        for (int n = 0; n < texto.length(); n++) {
            if (charsValidos.indexOf(texto.charAt(n)) != -1) {
                ret.append(texto.charAt(n));
            }
        }
        return ret.toString();
    }

    /**
     * Apenas coloca as barras em uma data passada. Não faz quaisquer validações
     * a respeito do conteúdo. Ele assume que a data terá 8 posições sem barras.
     * Se o parâmetro passado estiver errado ocorrerá uma <CODE>Exception</CODE>
     * qualquer.
     * 
     * @param data
     *            uma data no formato <I>ddmmaaaa<I>
     * @return uma data no formato <I>dd/mm/aaaa</I>
     */
    public static String colocaPontosData(String data) {
        return data.substring(0, 2)
               + "."
               + data.substring(2, 4)
               + "."
               + data.substring(4, 8);
    }

    public static String formatarTextoComBarraEne(String texto, int numColunas) {
        texto = formatarTextoSemBarraEne(texto, numColunas);
        String textoTemp = "";
        int ini = 0;
        if ((ini + numColunas < texto.length()) && (texto.indexOf('\n') == -1)) {
            while (ini + numColunas < texto.length()) {
                textoTemp += Utils.rtrim(texto.substring(ini, ini + numColunas)) + '\n';
                ini += numColunas;
            }
            textoTemp += Utils.rtrim(texto.substring(ini));
            texto = textoTemp + "\n";
        }
        return texto;
    }

    public static String formatarTextoSemBarraEne(String texto, int numColunas) {
        String textoTemp = "";
        String txtLinha = "";
        int colunaAtual = 0;
        if (texto.indexOf('\n') != -1) {
            for (int i = 0; i < texto.length(); i++) {
                if (texto.charAt(i) != '\r' && texto.charAt(i) != '\n') {
                    txtLinha += texto.charAt(i);
                } else {
                    if (texto.charAt(i) == '\r')
                        i++;
                    if (colunaAtual < numColunas)
                        for (int j = 0; j <= ((numColunas - 1) - colunaAtual); j++)
                            txtLinha += " ";
                    colunaAtual = -1;
                    textoTemp += txtLinha;
                    txtLinha = "";
                }
                colunaAtual++;
            }
        } else {
            textoTemp = texto;
        }
        return textoTemp;
    }

    public static String formatarSN(String texto) {
        if (texto.equals("S"))
            return "SIM";
        else if (texto.equals("N"))
            return "NAO";
        return "";
    }

    public static String formatarTipoPessoa(Long texto) {
        if (texto.equals(new Long(1)))
            return "FISICA";
        else if (texto.equals(new Long(2)))
            return "JURIDICA";
        return "";
    }

    public static String formataInteiroPadraoBrasileiro(Long valor) {
        DecimalFormat df = new DecimalFormat("##,##0");
        return df.format(valor);
    }

    /**
     * Formata a data especificada com o padrão
     * <code>dd/MM/yyyy HH:mm:ss:SSS</code> (dia/mês/ano
     * hora:minuto:segundo:milis)
     * 
     * @param data
     *            a data a ser formatada.
     * @return Uma <code>String</code> contendo a data formatada no padrão
     *         <code>dd/MM/yyyy HH:mm:ss:SSS</code>
     */
    public static String formatarDataHoraMinSegMili(Date data) {
        return formatoDataHoraSegundoMili.format(data);
    }
}
