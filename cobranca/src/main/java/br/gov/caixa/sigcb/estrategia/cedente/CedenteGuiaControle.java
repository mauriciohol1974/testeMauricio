package br.gov.caixa.sigcb.estrategia.cedente;

import javax.servlet.http.HttpServletRequest;

import br.gov.caixa.sigcb.bean.CedentePrincipalBean;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.SigcbException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Cedente (Controle de
 * Guias)
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>17/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public abstract class CedenteGuiaControle extends CedenteEstrategia {

    public static int mudaGuiaAberta(CedentePrincipalBean principalBean,
            HttpServletRequest request) throws Exception {

        try {

            request.getSession().setAttribute(CEDENTE_PRINCIPAL_BEAN,
                    principalBean);

            if (principalBean.getGuiaAberta() != null) {
                return principalBean.getGuiaAberta().intValue();
            } else {
                return 0;
            }

        } catch (Exception ex) {
            LogUtilSigcb.error("CedenteGuiaControle: erro na guia", ex);
            throw new SigcbException(new Exception("Erro na Guia do Cedente"));
            // ex.printStackTrace();
            // throw ex;
        }

    }

    public static void fechaGuias(HttpServletRequest request) throws Exception {
        CedentePrincipalBean principalBean = (CedentePrincipalBean) (new CedentePrincipalBean()).getSessionBean(request,
                CEDENTE_PRINCIPAL_BEAN);

        principalBean.setGuiaAberta(new Integer(GUIA_NENHUMA));

        request.getSession()
                .setAttribute(CEDENTE_PRINCIPAL_BEAN, principalBean);
    }

}
