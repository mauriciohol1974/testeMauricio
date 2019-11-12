package br.gov.caixa.sigcb.util;

import java.io.Serializable;
import java.util.ArrayList;

import br.gov.caixa.sigcb.bean.SigcbBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente que implementa uma pilha para ser utilizada para guardar os beans
 * que ja foram usados nas estrategias
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>03/11/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class PilhaVoltar implements Serializable {

    // Tamanho maximo da pilha
    private static int MAX_SIZE = 10;

    // Indica qual indice eh o topo da pilha
    private int topo = 0;

    // ArrayList utilizado para fazer a pilha
    private ArrayList pilha = new ArrayList();

    public void push(SigcbBean bean) {
        if (pilha == null) {
            pilha = new ArrayList();
        }

        // Nao empilha se tiver dois beans iguais
        // Utilizado caso o usuario faca Refresh na pagina
        if (topo - 1 >= 0) {
            SigcbBean beanAnterior = (SigcbBean) pilha.get(topo - 1);
            if (beanAnterior != null && beanAnterior.equals(bean)) {
                return;
            }
        }

        // se a adicao desse bean na pilha ultrapassar o tamanho maximo
        // remove o primeiro (base da pilha)
        if (topo + 1 >= MAX_SIZE) {
            pilha.remove(0);
            topo--;
        }

        this.limpaTopo();

        pilha.add(bean);
        topo++;
    }

    public SigcbBean pop() {
        SigcbBean bean = null;

        if (topo - 2 >= 0) {
            topo--;
            bean = (SigcbBean) pilha.get(topo - 1);
        }

        return bean;
    }

    private void limpaTopo() {
        for (int i = pilha.size() - 1; i >= topo; i--) {
            pilha.remove(i);
        }
    }
}
