package br.gov.caixa.sigcb.bean;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import br.com.politec.sao.business.BusinessObject;
import br.com.politec.sao.http.RequestParser;
import br.com.politec.sao.util.Money;
import br.com.politec.sao.util.Percentual;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.ObjectProperty;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável por implementar processos de obtencao de dados do bean
 * vindos de paginas jsp
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>30/08/2003</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */

public abstract class SigcbBean extends BusinessObject {

    /**
     * Cria um novo bean e o inicia sem valores nulos nas propriedades
     * 
     * @param BusinessObject -
     *            beanType: instancia do tipo requerido
     * @return BusinessObject - bean requerido
     */
    @SuppressWarnings("finally")
    public SigcbBean newBean() throws Exception {
        SigcbBean bean = this; // (SigcbBean) prototype();

        try {
            Class beanClass = bean.getClass();
            Field[] fields = beanClass.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Class fieldType = fields[i].getType();
                String fieldName = fields[i].getName().toUpperCase().charAt(0)
                                   + fields[i].getName().substring(1);
                Method setMethod = beanClass.getMethod("set" + fieldName,
                        new Class[] { fieldType });
                if (fieldType.equals(Integer.class)) {
                    setMethod.invoke(bean, new Object[] { new Integer(0) });
                } else if (fieldType.equals(Long.class)) {
                    setMethod.invoke(bean, new Object[] { new Long(0) });
                } else if (fieldType.equals(String.class)) {
                    setMethod.invoke(bean, new Object[] { "" });
                } else if (fieldType.equals(Money.class)) {
                    setMethod.invoke(bean, new Object[] { Money.reais(0) });
                } else if (fieldType.equals(Double.class)) {
                    setMethod.invoke(bean, new Object[] { new Double(0.0) });
                } else if (fieldType.equals(Percentual.class)) {
                    setMethod.invoke(bean, new Object[] { new Percentual(0) });
                }
            }
        } catch (IllegalAccessException ex) {
            LogUtilSigcb.error("newBean() - Nao foi possivel limpar bean "
                               + this.getClass().getName());
        } catch (IllegalArgumentException ex) {
            LogUtilSigcb.error("newBean() - Nao foi possivel limpar bean "
                               + this.getClass().getName());
        } catch (InvocationTargetException ex) {
            LogUtilSigcb.error("newBean() - Nao foi possivel limpar bean "
                               + this.getClass().getName());
        } finally {
            return bean;
        }
    }

    /**
     * Obtem bean do ambiente
     * 
     * @param HttpServletRequest -
     *            request: objeto representando o request http
     * @param String -
     *            beanName: nome do bean a ser obtido
     * @return BusinessObject - bean requerido
     */
    public SigcbBean getSessionBean(HttpServletRequest request, String beanName)
            throws Exception {
        SigcbBean bean = (SigcbBean) request.getSession()
                .getAttribute(beanName);
        return bean;
    }

    /**
     * Obtem bean do request
     * 
     * @param HttpServletRequest -
     *            request: objeto representando o request http
     * @param String -
     *            beanName: nome do bean a ser obtido
     * @param BusinessObject -
     *            bean a ser preenchido pelo request
     * @return BusinessObject - bean requerido
     */
    public SigcbBean getRequestBean(HttpServletRequest request)
            throws Exception {
        SigcbBean bean = (SigcbBean) newBean();
        bean.accept(new RequestParser(request));
        return bean;
    }

    /**
     * Copia os atributos do bean passado como parametro Nao serao copiados
     * nulos, brancos e zeros.
     * 
     * @param SigcbBean -
     *            bean com dados de origem
     * @return void
     */
    public void copyBean(SigcbBean origBean) throws Exception {
        ObjectProperty.copyPropertyValues(this, origBean);
    }

    // Este metodo sera removido
    public SigcbBean getBean(HttpServletRequest request,
            String origBean,
            String fluxo) throws Exception {
        return null;
    }

    /**
     * Informa o id da session do usuário.
     * 
     * @param HttpServletRequest
     * @return String - Retorna o id da sessão como String
     */
    public static String getId(HttpServletRequest request) {
        String id;
        id = request.getSession().getId().toString();
        return id;
    }

}
