package br.com.politec.sao.http;

import javax.servlet.http.HttpServletRequest;

import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.parser.BeanParser;
import br.com.politec.sao.util.Assertions;
import br.com.politec.sao.util.Utils;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Parser de objetos a partir de um request. Fornece suporte a obten��o de
 * beans, tratados pela framework a partir de uma requisi��o http encapsulada em
 * objeto de request.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class RequestParser extends BeanParser {
    /**
     * Requisi��o http encapsulada.
     */
    private final HttpServletRequest request;

    /**
     * Construtor default do objeto.
     * 
     * @param request
     *            Requisi��o http encapsulada.
     */
    public RequestParser(HttpServletRequest request) {
        Assertions.requires(request != null);
        this.request = request;
    }

    /**
     * M�todo get.
     * 
     * @see br.com.politec.sao.business.parser.BeanParser#get(br.com.politec.sao.business.Property)
     *      Obtem o valor encapsulado no request para a propriedade de nome
     *      correspondente. O valor � recuperado do request, e � retornado para
     *      a instancia��o de uma propriedade a partir deste valor retornado
     *      como String.
     * @param property
     *            Propriedade que identificar� o nome do parametro em request,
     *            al�m do tipo deste.
     * @return String contendo o valor da propriedade a ser criada.
     */
    protected Object get(Property property) {
        Assertions.requires(property != null);
        String result = this.request.getParameter(property.getName());
        if (result != null) {
            // GMG: remover apenas espacos em branco do fim da propriedade.
            // result = result.trim();
            // if (result.equals("")) {
            result = Utils.rtrim(result);
            if (result.trim().equals("")) {
                result = null;
            }
        }
        return result;
    }
}