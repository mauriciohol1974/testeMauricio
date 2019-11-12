package br.gov.caixa.sigcb.util.jsp;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;

import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MenuBean;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Tag de renderização do Combo com valores fixos SALDOS CONTABEIS E POSICOES
 * CONTABEIS
 * 
 * @author Eduardo A.Morás - emoras@sao.politec.com.br
 * @version release 1.0
 */
public class ComboConsultaContabil extends ComboFixo {

    public int doStartTag() throws JspException {
        try {

            ArrayList listCodigos = new ArrayList();
            ArrayList listDescricoes = new ArrayList();

            // Montar o combo de acordo com as permissões de acesso do usuário
            MenuBean menuBean = MenuBean.getInstance();
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) pageContext.getSession()
                    .getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN);

            if (menuBean.hasUserAcessByInternalAction("consulta.contabil.operacional",
                    usuarioBean.getNomeGrupo())) {
                listCodigos.add("1");
                listDescricoes.add("VALORES A CREDITAR");
            }
            if (menuBean.hasUserAcessByInternalAction("consulta.contabil.saldo",
                    usuarioBean.getNomeGrupo())) {
                listCodigos.add("2");
                listDescricoes.add("SALDOS OPERACIONAIS");
            }
            if (menuBean.hasUserAcessByInternalAction("consulta.contabil.posicao",
                    usuarioBean.getNomeGrupo())) {
                listCodigos.add("3");
                listDescricoes.add("LIQUIDAÇÕES");
            }
            if (!menuBean.hasUserAcessByInternalAction("consulta.contabil.operacional",
                    usuarioBean.getNomeGrupo())
                && !menuBean.hasUserAcessByInternalAction("consulta.contabil.saldo",
                        usuarioBean.getNomeGrupo())
                && !menuBean.hasUserAcessByInternalAction("consulta.contabil.posicao",
                        usuarioBean.getNomeGrupo())) {
                listCodigos.add("0");
                listDescricoes.add("Usuário não possui acesso a nenhuma das consultas.");
            }
            this.setListCodigo(listCodigos);
            this.setListDescricao(listDescricoes);

        } catch (Exception e) {
            throw new JspException(e.getMessage());
        }
        return super.doStartTag();
    }

    public String getDescricao(Long codigo) {
        if (new Long(1).equals(codigo)) {
            return "VALORES A CREDITAR";
        } else if (new Long(2).equals(codigo)) {
            return "SALDOS OPERACIONAIS";
        } else if (new Long(3).equals(codigo)) {
            return "LIQUIDAÇÕES";
        }
        return "";
    }
}