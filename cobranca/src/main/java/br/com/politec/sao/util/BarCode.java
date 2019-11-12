package br.com.politec.sao.util;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;
import org.apache.log4j.Logger;
/**
 * <B>Projeto: SIGCB</B><BR>
 *
 * Tag Lib utilizada para a geracao de codigo de barras
 * Baseada na versao javascript da Opus escrita por wlung de 18/06/2003
 * @author Glauber Micheloni Gallego - ggallego@sao.politec.com.br
 * @version release 1.0
 */
public class BarCode extends TagSupport {
	private static final long serialVersionUID = -2226706605976776389L;
    
    /** Inicialização do Log4J */
    private static final Logger LOG = Logger
            .getLogger(BarCode.class);

    /**
	 * Variável que armazena o caminho para imagens.
	 */
	private String imagePath;

	/**
	 * Variável que armazena o codigo de barras (full barcode).
	 */
	private String code;



	/**
	 * Variáveis que armazenam configuracoes do codigo de barras.
	 */
	private static final int BAR_HEIGHT = 50;
	private static final int BAR_WIDTH = 1;
	private static final String BINARY_TABLE[] = {
					"00110", "10001", "01001", "11000", "00101", "10100", "01100", "00011", "10010", "01010"};

	
	/**
	 * Método doStartTag.
	 * Imprime o código html correspondente ao codigo de barras.
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag()
	 * @return Controle para o web container.
	 */
	public int doStartTag() {
		try {
			String binaryBarCode = this.getBinaryBarCode(getCode());

			String BAR_BLACK  = "<img src='" +getImagePath()+ "/codebarBlack.jpg' height='"+BAR_HEIGHT+"' width="+BAR_WIDTH+">";
			String BAR_WHITE  = "<img src='" +getImagePath()+ "/codebarWhite.jpg' height='"+BAR_HEIGHT+"' width="+BAR_WIDTH+">";
			String BAR_3BLACK = "<img src='" +getImagePath()+ "/codebarBlack.jpg' height='"+BAR_HEIGHT+"' width="+(BAR_WIDTH*3)+">";
			String BAR_3WHITE = "<img src='" +getImagePath()+ "/codebarWhite.jpg' height='"+BAR_HEIGHT+"' width="+(BAR_WIDTH*3)+">";

			StringBuffer barcode = new StringBuffer();
			// Inicio da Barra
			barcode.append(BAR_BLACK + BAR_WHITE + BAR_BLACK + BAR_WHITE);
			// Conteudo da Barra
			boolean isBarBlack = false;
			for (int i=0; i < binaryBarCode.length(); i++) {
				isBarBlack = !isBarBlack;
				if (binaryBarCode.charAt(i)== '0' ) {
					barcode.append((isBarBlack)?BAR_BLACK:BAR_WHITE);
				} else {				// == '1'
					barcode.append((isBarBlack)?BAR_3BLACK:BAR_3WHITE);
				}
			}
			// Fim da Barra
			barcode.append(BAR_BLACK + BAR_BLACK + BAR_BLACK + BAR_WHITE + BAR_BLACK);
			
			this.pageContext.getOut().println(barcode.toString());
		}catch(IOException ioe){
			LOG.error("BarCode doStartTag IOException caught while rendering tag - Exception message: "+ioe.getMessage(), ioe);
		}catch(Exception e){
            LOG.error("BarCode doStartTag() - Exception message: "+e.getMessage(), e);
		}
		return SKIP_BODY;
	}

	private String getBinaryBarCode( String fullBarCode) {
		String code = fullBarCode.length() % 2 == 0 ? fullBarCode : "0" + fullBarCode;
		String binaryCode = "";
		for(int i = 0; i < code.length(); i += 2) {
			binaryCode = binaryCode + intercalaCode(code.charAt(i), code.charAt(i + 1));
        }    

		return binaryCode;
	}
	public static String intercalaCode(char code1, char code2)
	{
		String codeBin1 = BINARY_TABLE[Character.getNumericValue(code1)];
		String codeBin2 = BINARY_TABLE[Character.getNumericValue(code2)];
		String codeIntercala = "";
		for(int i = 0; i < codeBin1.length(); i++) {
			codeIntercala = codeIntercala + Character.getNumericValue(codeBin1.charAt(i)) + "" + Character.getNumericValue(codeBin2.charAt(i));
        }    

		return codeIntercala;
	}

	/**
	 * @return
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @param string
	 */
	public void setImagePath(String string) {
		imagePath = string;
	}

	/**
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param string
	 */
	public void setCode(String string) {
		code = string;
	}

}