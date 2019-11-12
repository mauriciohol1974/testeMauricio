package br.com.politec.sao.util;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * @author Adriano
 *  
 */
public class Interleaved2of5 extends CodBar {

    private static final int LARGURA_N = 1;
    private static final int LARGURA_W = 3;

    private static final char[] padraoInicial = 
                                  new char[] { 'n', 'n', 'n', 'n' };
    private static final char[] padraoFinal = 
                                  new char[] { 'w', 'n', 'n' };

    private static char[][] padrao = 
                   new char[][] { { 'n', 'n', 'w', 'w', 'n' },// 0
                                  { 'w', 'n', 'n', 'n', 'w' },// 1
                                  { 'n', 'w', 'n', 'n', 'w' },// 2
                                  { 'w', 'w', 'n', 'n', 'n' },// 3
                                  { 'n', 'n', 'w', 'n', 'w' },// 4
                                  { 'w', 'n', 'w', 'n', 'n' },// 5
                                  { 'n', 'w', 'w', 'n', 'n' },// 6
                                  { 'n', 'n', 'n', 'w', 'w' },// 7
                                  { 'w', 'n', 'n', 'w', 'n' },// 8
                                  { 'n', 'w', 'n', 'w', 'n' },// 9
    };

    public Interleaved2of5(String codigo) {
        super.codigo = codigo;
    }

    private String padrao() {

        StringBuffer buffer = new StringBuffer();
        buffer.append(padraoInicial);

        for (int i = 0; i < codigo.length(); i += 2) {

            String primeiro = codigo.substring(i, i + 1);
            String segundo = codigo.substring(i + 1, i + 2);

            char[] valorPrimeiro = padrao[Integer.parseInt(primeiro)];
            char[] valorSegundo = padrao[Integer.parseInt(segundo)];

            buffer.append(concatena(valorPrimeiro, valorSegundo));
        }

        buffer.append(padraoFinal);
        return buffer.toString();
    }

    private StringBuffer concatena(char[] valorPrimeiro, 
                                   char[] valorSegundo) {

        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < valorSegundo.length; i++) {
            buffer.append(valorPrimeiro[i]).append(valorSegundo[i]);
        }

        return buffer;
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.gadew.jbarcode.Barcode#validarCodigo()
     */
    protected void validarCodigo() {
      if (codigo == null) { 
        throw new IllegalArgumentException("Valor do código é null"); 
      }
      String somenteNumeros = codigo.replaceAll("\\D", "");
      if (somenteNumeros.length() % 2 != 0) { 
        throw new IllegalArgumentException("O tamanho do código deve " 
               + "consistir de tamanho par e somente números."); 
      }
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.gadew.jbarcode.Barcode#renderize(java.awt.Graphics2D)
     */
    protected int renderize(Graphics2D graphics) {

        int posicao = MARGEM_ESQUERDA;
        boolean imprimir = true;

        int alturaBarra = ALTURA - (MARGEM_SUPERIOR + MARGEM_INFERIOR);

        String modelo = padrao();

        for (int i = 0; i < modelo.length(); i++) {
            char tipo = modelo.charAt(i);
            posicao = imprimirQuadrado(tipo, 
                                       graphics, 
                                       posicao, 
                                       alturaBarra, 
                                       imprimir);
            imprimir = !imprimir;
        }

        return posicao;
    }

    /**
     * @param tipo
     * @param graphics
     * @param posicao
     * @param alturaBarra
     * @param imprimir
     * @return
     */
    private int imprimirQuadrado(char tipo, 
                                 Graphics2D graphics, 
                                 int posicao, 
                                 int alturaBarra, 
                                 boolean imprimir) {

        Rectangle quadrado = new Rectangle();
        quadrado.setLocation(posicao, MARGEM_SUPERIOR);
        switch (tipo) {
            case 'n':
                quadrado.setSize(LARGURA_N, alturaBarra);
                posicao += LARGURA_N;
                break;

            case 'w':
                quadrado.setSize(LARGURA_W, alturaBarra);
                posicao += LARGURA_W;
                break;
        }
        if (imprimir) {
            graphics.fill(quadrado);
        }
        return posicao;
    }
}
