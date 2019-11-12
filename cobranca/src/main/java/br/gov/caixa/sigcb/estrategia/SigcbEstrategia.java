package br.gov.caixa.sigcb.estrategia;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.ejb.CreateException;
import javax.servlet.http.HttpServletRequest;

import br.com.politec.sao.business.util.PageableList;
import br.com.politec.sao.controlStrategy.StrategyTemplate;
import br.com.politec.sao.util.PageHolder;
import br.com.politec.sao.util.ServiceLocator;
import br.com.politec.sao.util.WrappingException;
import br.gov.caixa.sigcb.util.SigcbException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável por centralizar a chamada ao EJB MainFrameTransactions
 * e metodos uteis ao sistema.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>11/06/2003</DD>
 * </DL>
 * 
 * @author Andrew Betencourt - abetencourt@sao.politec.com.br
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br. Data 21/06/2004.
 */
public abstract class SigcbEstrategia extends StrategyTemplate {

    
	public static String COD_USUARIO = "";
	
	public static String FLUXO_NORMAL = "normal";

    public static String FLUXO_VOLTAR = "voltar";

    public static String USUARIOLDAP_BEAN = "usuarioLdap";

    public static String CEDENTE_ATUAL = "cedente";
    
    public static String INFORMACAO_ATUAL = "informacao";
    
    /*

    public static MainFrameTransactionsSigcb lookUpMFHandler()
            throws SigcbException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();

            String jndiName = "java:comp/env/ejb/MainFrameTransactionsSigcb";
            Class className = MainFrameTransactionsSigcbHome.class;

            MainFrameTransactionsSigcbHome homeInterface = (MainFrameTransactionsSigcbHome) service.getEjbHome(jndiName,
                    className);

            return homeInterface.create();
        } catch (RemoteException eRem) {
            throw new WrappingException(eRem);
        } catch (CreateException eCre) {
            throw new WrappingException(eCre);
        }
    }
    */

    public ArrayList convertDataStructure(Iterator iterator) {
        ArrayList list = new ArrayList();
        while (iterator.hasNext())
            list.add(iterator.next());
        return list;
    }

    public PageHolder getPageHolder(List beans) {
        PageHolder resultado = new PageHolder(new PageableList(beans));
        resultado.setPageSize(20);
        return resultado;
    }
    
    public PageHolder getPageHolder2(List beans) {
        PageHolder resultado = new PageHolder(new PageableList(beans));
        resultado.setPageSize(2000);
        return resultado;
    }

    /**
     * fluxo: Variavel de controle do fluxo entre telas
     */
    protected String getFluxo(HttpServletRequest request) {
        String fluxo = FLUXO_NORMAL;

        if (request.getParameter("fluxo") != null)
            fluxo = (String) request.getParameter("fluxo");

        return fluxo;
    }

    /**
     * Configura e retem bean MsgSucessoErroBean que possui as mensagens
     * configuradas para telas de erro e sucesso.
     */
    protected abstract void configMsgSucessoErro(HttpServletRequest request);

    /* ***********Controle de retenção de atributos************** */

    /**
     * HashMap que mantém os valores a serem retidos
     */
    private static HashMap permitidos = new HashMap();
    static {
        permitidos.put(USUARIOLDAP_BEAN, "");
        permitidos.put(CEDENTE_ATUAL, "");
        permitidos.put("msgBean", "");
        permitidos.put("perfilusuario", "");
    }

    /**
     * Metodo que remove os Beans
     * 
     * @param HttpServletRequest
     *            request
     */
    public static void removeBean(HttpServletRequest request) {
        String fluxo = (String) request.getParameter("fluxo");
        if (fluxo == null)
            fluxo = "";

        if (fluxo.equals(FLUXO_NORMAL)) {
            Enumeration en = request.getSession().getAttributeNames();
            String valor = "";
            while (en.hasMoreElements()) {
                valor = en.nextElement().toString();
                if (!permitidos.containsKey(valor))
                    request.getSession().removeAttribute(valor);
            }
        }
    }
}
