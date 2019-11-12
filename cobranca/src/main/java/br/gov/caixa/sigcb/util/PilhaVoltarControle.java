package br.gov.caixa.sigcb.util;

import javax.servlet.http.HttpServletRequest;

import br.gov.caixa.sigcb.bean.SigcbBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável por manter os beans usados nas estrategias que já
 * foram executadas para serem recuperados caso o usuario aperte o botao voltar
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>03/11/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class PilhaVoltarControle {

    // Nome da pilha
    private static String PILHA_DE_BEANS_VOLTAR = "pilhaDeBeansVoltar";

    public static void init(HttpServletRequest request) {
        PilhaVoltar pilha = new PilhaVoltar();
        request.getSession().setAttribute(PILHA_DE_BEANS_VOLTAR, pilha);
    }

    public static void push(HttpServletRequest request, SigcbBean bean) {
        PilhaVoltar pilha = (PilhaVoltar) request.getSession()
                .getAttribute(PILHA_DE_BEANS_VOLTAR);

        if (pilha == null) {
            pilha = new PilhaVoltar();
        }

        pilha.push(bean);

        request.getSession().setAttribute(PILHA_DE_BEANS_VOLTAR, pilha);
    }

    public static SigcbBean pop(HttpServletRequest request) {
        PilhaVoltar pilha = (PilhaVoltar) request.getSession()
                .getAttribute(PILHA_DE_BEANS_VOLTAR);

        SigcbBean bean = pilha.pop();

        request.getSession().setAttribute(PILHA_DE_BEANS_VOLTAR, pilha);

        return bean;
    }

}
