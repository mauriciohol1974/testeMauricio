package br.com.politec.sao.http;

import javax.servlet.http.HttpServletRequest;

import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.parser.BeanParser;
import br.com.politec.sao.util.Assertions;
import br.com.politec.sao.util.Utils;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Parser de objetos a partir de um request. Fornece suporte a obtenção de
 * beans, tratados pela framework a partir de uma requisição http encapsulada em
 * objeto de request.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class RequestParser extends BeanParser {
    /**
     * Requisição http encapsulada.
     */
    private final HttpServletRequest request;

    /**
     * Construtor default do objeto.
     * 
     * @param request
     *            Requisição http encapsulada.
     */
    public RequestParser(HttpServletRequest request) {
        Assertions.requires(request != null);
        this.request = request;
    }

    /**
     * Método get.
     * 
     * @see br.com.politec.sao.business.parser.BeanParser#get(br.com.politec.sao.business.Property)
     *      Obtem o valor encapsulado no request para a propriedade de nome
     *      correspondente. O valor é recuperado do request, e é retornado para
     *      a instanciação de uma propriedade a partir deste valor retornado
     *      como String.
     * @param property
     *            Propriedade que identificará o nome do parametro em request,
     *            além do tipo deste.
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