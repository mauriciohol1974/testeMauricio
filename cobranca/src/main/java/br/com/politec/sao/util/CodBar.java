package br.com.politec.sao.util;



import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
* @author Adriano
*
*/
public abstract class CodBar {

   public int ALTURA;
   public int LARGURA;

   public int MARGEM_SUPERIOR;
   public int MARGEM_INFERIOR;
   public int MARGEM_ESQUERDA;
   public int MARGEM_DIREITA;

   public Color COR_FUNDO;
   public Color COR_BARRAS;

   protected String codigo;

   public BufferedImage render() {

       BufferedImage bufferedImage = new BufferedImage(LARGURA,
               ALTURA, java.awt.image.BufferedImage.TYPE_INT_RGB);

       Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();

       validarCodigo();

       graphics.setPaint(COR_FUNDO);
       graphics.fillRect(0, 0, LARGURA, ALTURA);

       graphics.setColor(COR_BARRAS);
       int posicaoFinal = renderize(graphics);

       graphics.setPaint(COR_FUNDO);
       graphics.fillRect(posicaoFinal, 0, MARGEM_DIREITA, ALTURA);

       if (posicaoFinal > LARGURA) {
         System.err.println("Barras ultrapassam o tamanho da figura em "
                            + (posicaoFinal - LARGURA));
       }

       return bufferedImage;
   }

   protected abstract int renderize(Graphics2D graphics);
   protected abstract void validarCodigo();
}
