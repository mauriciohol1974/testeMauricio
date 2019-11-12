package br.com.politec.sao.util;

import br.gov.caixa.sigcb.util.LogUtilSigcb;

public class SubstringTokenizer {
    private final String text;

    private int currentPosition = 0;

    public SubstringTokenizer(String text) {
        Assertions.requires(text != null);
        this.text = text;
    }

    public String getNext(int substringSize) {
        Assertions.requires(hasNext(substringSize), "Invalid substringSize ["
                                                    + substringSize
                                                    + "]");
        this.currentPosition = this.currentPosition + substringSize;
        return this.text.substring(this.currentPosition - substringSize,
                this.currentPosition);
    }

    public boolean hasNext(int substringSize) {
         if ((this.currentPosition + substringSize) > this.text.length()) {
           
           //LogUtilSigcb.debug("\n");
           //LogUtilSigcb.debug("##############################");
           //LogUtilSigcb.debug("SubstringTokenizer.hasNext: talvez o tamanho da resposta do mainframe nao bata com tamanho dos campos do bean");
           //LogUtilSigcb.debug("##############################");
           //LogUtilSigcb.debug("\n");
         }
        return (this.currentPosition + substringSize) <= this.text.length();
    }

    public int getRemaining() {
        return getTextLength() - getCurrentPosition();
    }

    public int getTextLength() {
        return this.text.length();
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        Assertions.requires((currentPosition >= 0)
                            && (currentPosition < this.text.length()),
                "Invalid currentPosition [" + currentPosition + "]");
        this.currentPosition = currentPosition;
    }

    public String getText() {
        return this.text;
    }
}