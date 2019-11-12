package br.gov.caixa.sigcb.util.jsp;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.jsp.JspException;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.jsp.controlTags.Select;
import br.com.politec.sao.util.Assertions;
import br.com.politec.sao.util.Cache;
import br.com.politec.sao.util.Creation;
import br.com.politec.sao.util.WrappingException;
import br.gov.caixa.sigcb.bean.ComboBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.ejb.session.MainframeException;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.SigcbException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Tag de renderização do Combo Transação
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br (Data:11/09/04) -
 *         implementacao de cache com timeout para obter BeanLists obtidos dos
 *         varios tipo de transacao.
 * @version release 1.1
 */
public abstract class ComboTransacao extends Select {

    // Cache com timeout para BeanLists obtidos de transacao
    private static final Cache transactions = new Cache(getCacheableTransactions());

    // transacao que popula o combo
    private String transacao = "";

    // valor que comeca selecionado
    private String selectedValue = "0";

    // Indica se existe uma primeira opcao em branco
    // O option tem value 0
    private boolean branco = false;

    // Valor da opcao em branco: default -1
    private String brancoValue = "-1";

    // OPTIONs inseridos no final do combo
    // valores no formato "1;2;3"
    private String valoresFixo = "";

    // descricoes no formato "opcao 1;opcao 2;opcao 3"
    private String descricoesFixo = "";

    /**
     * Construtor default.
     */
    public ComboTransacao() {
    }

    protected void setTransacao(String transacao) {
        this.transacao = transacao;
    }

    protected String getTransacao() {
        return this.transacao;
    }

    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String str) {
        selectedValue = str;
    }

    public boolean isBranco() {
        return branco;
    }

    public void setBranco(boolean b) {
        branco = b;
    }

    public String getBrancoValue() {
        return brancoValue;
    }

    public void setBrancoValue(String string) {
        brancoValue = string;
    }

    public String getDescricoesFixo() {
        return descricoesFixo;
    }

    public void setDescricoesFixo(String string) {
        descricoesFixo = string;
    }

    public String getValoresFixo() {
        return valoresFixo;
    }

    public void setValoresFixo(String string) {
        valoresFixo = string;
    }

    /**
     * Método doStartTag. Renderiza a porção inicial do código da tag. Adiciona
     * na página o controle Select com seus atributos, eventos e ítens.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     * @return int
     * @throws JspException
     * @throws
     * @throws SigcbException
     */
    public int doStartTag() throws JspException {
        try {
            StringBuffer buffer = new StringBuffer();
            fillHeaderSelect(buffer);
            fillOptions(buffer);
            fillFooter(buffer);
            pageContext.getOut().print(buffer.toString());
        } catch (Exception ex) {
            LogUtilSigcb.error("ComboTransacao: Erro na construcao da Tag: "
                               + ex.getMessage(), ex);
            try {
                pageContext.getOut()
                        .print("<font color='orange'><b>erro na montagem da caixa de seleção</b></font>");
            } catch (IOException e) {
                LogUtilSigcb.error(ex.getMessage(), ex);
                throw new JspException(ex.getMessage());
            }
        }
        return EVAL_BODY_INCLUDE;
    }

    /**
     * Método fillHeaderSelect. Adiciona o controle Select com seus atributos e
     * eventos na página.
     * 
     * @param buffer
     */
    private void fillHeaderSelect(StringBuffer buffer) {
    	
    	if (this.getTransacao().equalsIgnoreCase("BGM9")){
    		
    		buffer.append("<SELECT NAME='" 
                    + super.getName()
                    + "'"
                    + "style='width: 120px' ONBLUR='"
                    + super.getOnBlur()
                    + "'"
                    + " ONCHANGE='"
                    + getOnChange()
                    + "' "
                    + (isMultiple() ? " multiple " : "")
                    + " ONFOCUS='"
                    + getOnFocus()
                    + "' "
                    + (getDisabled().equals("true") ? "disabled" : "")
                    + ">");
    		
    	}else{
    		
    	
    		buffer.append("<SELECT NAME='"
                      + super.getName()
                      + "'"
                      + " ONBLUR='"
                      + super.getOnBlur()
                      + "'"
                      + " ONCHANGE='"
                      + getOnChange()
                      + "' "
                      + (isMultiple() ? " multiple " : "")
                      + " ONFOCUS='"
                      + getOnFocus()
                      + "' "
                      + (getDisabled().equals("true") ? "disabled" : "")
                      + ">");
    	}
    }

    /**
     * Método fillOptions. Adiciona na página os itens do Select, também faz o
     * controle dos ítens que precisam ser selecionados no Select.
     * 
     * @param buffer
     */
    protected void fillOptions(StringBuffer info) throws Exception {
        try {
            BeanList comboBeanList = consultaTransacao(this.getTransacao());

            if (isBranco()) {
                info.append("<option value='" + this.getBrancoValue() + "'");
                if (this.getSelectedValue().equals(this.getBrancoValue())) {
                    info.append(" selected");
                }
                info.append("> </option>");
            }
            	
                for (int i = 0; i < comboBeanList.size(); i++) {
                    ComboBean bean = (ComboBean) comboBeanList.get(i);
                    if (this.getTransacao().equalsIgnoreCase("BGMY")){
                    	 info.append("<option value='" + bean.getDescrReduzida().trim() + "'");
                    }else{
                    	 info.append("<option value='" + bean.getCodigo() + "'");
                    }
                    
                    if (!this.getTransacao().equalsIgnoreCase("BGMY")){
                    	   if (this.getSelectedValue().equals(""
                                   + bean.getCodigo()
                                           .longValue())) {
							    info.append(" selected");
							}
                    }
                   
                 
                    if (this.getTransacao().equalsIgnoreCase("BGM9")){
                    	info.append(">" + bean.getDescricao().substring(0, bean.getDescricao().length()-1) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + bean.getDescricao().substring(bean.getDescricao().length()-1, bean.getDescricao().length()) + "</option>");
                    }else  if (this.getTransacao().equalsIgnoreCase("BGMY")){
                    	info.append(">" + bean.getDescrReduzida() + "</option>");
                    }else{
                    	info.append(">" + bean.getDescricao() + "</option>");
                    }
                    
                }
            	


            if (!this.getValoresFixo().equals("")
                && !this.getDescricoesFixo().equals("")) {
                StringTokenizer tokenizerValores = new StringTokenizer(this.getValoresFixo(),
                        ";");
                StringTokenizer tokenizerDescricoes = new StringTokenizer(this.getDescricoesFixo(),
                        ";");

                Assertions.check(tokenizerValores.countTokens() == tokenizerDescricoes.countTokens(),
                        "ComboTransacao: numero diferente de valores e descricoes");

                while (tokenizerValores.hasMoreTokens()) {
                    String valor = tokenizerValores.nextToken();
                    String descricao = tokenizerDescricoes.nextToken();

                    info.append("<option value='" + valor + "'");
                    if (this.getSelectedValue().equals(valor)) {
                        info.append(" selected");
                    }
                    info.append(">" + descricao + "</option>");
                }
            }

        } catch (Exception exc) {
            throw exc;
        }
    }

    /**
     * Método fillFooter. Insere a tag de fechamento do controle Select.
     * 
     * @param buffer
     */
    private void fillFooter(StringBuffer buffer) {
        buffer.append("</SELECT>");
    }

    /**
     * Método doEndTag.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doEndTag()
     * @return int
     */
    public int doEndTag() {
        return SKIP_BODY;
    }

    protected BeanList consultaTransacao(String transacao) throws Exception {
        List transactionCached = (List) transactions.get(transacao);
        return (BeanList) transactionCached.get(1);
    }

    private static Creation getCacheableTransactions() {
        return new Creation() {

            // tempo para expírar dados da transacao em cache: 12 horas
            // private long expiresTime = (12 * 60 * 60 * 1000L);
            private long expiresTime = (1L);

            public boolean updateIsNeeded(Object key, Object value) {
                if (transactions.containsKey(key)) {
                    List transactionCached = (List) value;

                    long currentTime = System.currentTimeMillis();
                    long lastExecTime = Long.parseLong((String) transactionCached.get(0));

                    if (currentTime - lastExecTime < expiresTime)
                        return false;
                }
                return true;
            }

            public Object create(Object key) {
                List transactionCached = new ArrayList();

                BeanList cachedBeanList = null;
                try {
                	 MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
                   //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
                    cachedBeanList = handler.executeSimpleTransactionQuery(new ComboBean(), (String) key);
                } catch (MainframeException re) {
                    throw new WrappingException(re);
                }

                long currentTime = System.currentTimeMillis();

                // pos1: hora que foi cacheado
                transactionCached.add(String.valueOf(currentTime));
                // pos2: objeto cacheado
                transactionCached.add(cachedBeanList);

                return transactionCached;
            }
        };
    }

    /**
     * Pega a descricao do codigo passado de uma transacao de combo
     * 
     * @param transacao -
     *            transacao de combo a ser obtida a descricao
     * @param codigo -
     *            codigo do combo cuja descricao eh desejada
     * @return Descricao do codigo pedido, se nao encontrar volta String vazia
     * @throws JspException
     */
    public String getDescricao(Long codigo) throws JspException {
        String descricao = "";

        try {
            BeanList comboBeanList = consultaTransacao(this.getTransacao());

            for (int i = 0; i < comboBeanList.size(); i++) {
                ComboBean bean = (ComboBean) comboBeanList.get(i);
                if (codigo.equals(bean.getCodigo())) {
                    descricao = bean.getDescricao();
                    break;
                }
            }

        } catch (Exception ex) {
            LogUtilSigcb.error("ComboTransacao: Erro getDescricao: "
                               + ex.getMessage(), ex);
            throw new JspException(ex.getMessage());
        }

        return descricao;
    }

}