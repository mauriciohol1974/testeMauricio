package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.IntegerType;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.IntegerValue;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;
import br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia;
import br.gov.caixa.sigcb.util.Formatador;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

public class CedentePrincipalBean extends SigcbBean {
    private java.lang.Long cedenteCentralizador;

    private java.lang.Integer cedenteEletronicoCadastrado;

    private java.lang.Integer guiaAberta;

    private java.lang.Integer ultimaGuiaCadastrada;

    private java.lang.String situacaoGuia;

    private java.lang.Long tipoCobranca;
    

    public CedentePrincipalBean() {
        this.cedenteCentralizador = null;
        this.cedenteEletronicoCadastrado = null;
        this.guiaAberta = null;
        this.ultimaGuiaCadastrada = null;
        this.situacaoGuia = null;
        this.tipoCobranca = null;
    }

    public String getApplicationName() {
        return "CedentePrincipalBean";
    }

    

	public java.lang.Long getCedenteCentralizador() {
        return this.cedenteCentralizador;
    }

    public void setCedenteCentralizador(java.lang.Long cedenteCentralizador) {
        this.cedenteCentralizador = cedenteCentralizador;
    }

    public java.lang.Integer getCedenteEletronicoCadastrado() {
        return this.cedenteEletronicoCadastrado;
    }

    public void setCedenteEletronicoCadastrado(java.lang.Integer cedenteEletronicoCadastrado) {
        this.cedenteEletronicoCadastrado = cedenteEletronicoCadastrado;
    }

    public java.lang.Integer getGuiaAberta() {
        return this.guiaAberta;
    }

    public void setGuiaAberta(java.lang.Integer guiaAberta) {
        this.guiaAberta = guiaAberta;
    }

    public int getGuiaEmCadastramento() {
        int guiaEmCadastramento = this.getUltimaGuiaCadastrada().intValue() + 1;

        // Se permite cadastramento da guia Cedente Eletronico
        if (!this.naoPodeCedenteEletronico()) {
            if (guiaEmCadastramento > CedenteEstrategia.GUIA_CEDENTE_ELETRONICO) {
                // Se ja passou da guia de cedente eletronico, mas nao existe um
                // cedente eletronico cadastrado no banco a guia fica Em
                // Cadastramento
                if (!this.isCedenteEletronicoCadastrado()) {
                    return CedenteEstrategia.GUIA_CEDENTE_ELETRONICO;
                }
            }
        }

        return guiaEmCadastramento;
    }

    public java.lang.Integer getUltimaGuiaCadastrada() {
    	
        if (this.ultimaGuiaCadastrada != null
            && this.ultimaGuiaCadastrada.intValue() + 1 == CedenteEstrategia.GUIA_CEDENTE_ELETRONICO
            && this.naoPodeCedenteEletronico()) {

        		 this.ultimaGuiaCadastrada = new Integer(this.ultimaGuiaCadastrada.intValue() + 1);

           
        }

        return this.ultimaGuiaCadastrada;
    }

    public void setUltimaGuiaCadastrada(java.lang.Integer guia) {
        this.ultimaGuiaCadastrada = guia;
    }

    public java.lang.String getSituacaoGuia() {
        return this.situacaoGuia;
    }

    public void setSituacaoGuia(java.lang.String situacaoGuia) {
        this.situacaoGuia = situacaoGuia;
    }

    public java.lang.Long getTipoCobranca() {
        return this.tipoCobranca;
    }

    public void setTipoCobranca(java.lang.Long tipoCobranca) {
        this.tipoCobranca = tipoCobranca;
    }

    // 0 - Nao cadastrado
    // 1 - Cadastrado
    public boolean isCedenteEletronicoCadastrado() {
        return (new Integer(1).equals(cedenteEletronicoCadastrado));
    }

    // Retorna a descricao da situacao de acordo com a guia passada no parametro
    public String getSituacaoGuiaTexto(int guia) {
    	
    	 if (this.getUltimaGuiaCadastrada() != null) {
             int guiaInclusao = this.getUltimaGuiaCadastrada().intValue() + 1;

             LogUtilSigcb.info("GUIA:::>"+ guia + "guiaInclusao:::>"+ guiaInclusao);
             
             if (guia == 11){
            	 return "Somente Consulta";
             }
             
             if (guia == CedenteEstrategia.GUIA_CEDENTE_ELETRONICO
                 && this.naoPodeCedenteEletronico()) {
                 return "Não Permitido";
             }
             
             if (guia == 10 && guiaInclusao==8){
            	 return "Em Cadastramento";
             }
             if (guia == 10 && guiaInclusao==9){
            	 return "Cadastrado";
             }
             if (guia == 8 && guiaInclusao==8){
            	 return "Não Cadastrado";
             }
             if (guia == 8 && guiaInclusao==9){
            	 return "Em Cadastramento";
             }

             if (guia == this.getGuiaEmCadastramento()) {
                 return "Em Cadastramento";
             } else if (guia < guiaInclusao) {
                 return "Cadastrado";
             } else {
                 return "Não Cadastrado";
             }
         }

         return "";
    }

    // private String getSituacaoGuiaCedenteEletronicoTexto() {
    //        
    // // Se permite cadastramento da guia Cedente Eletronico
    // if (!this.naoPodeCedenteEletronico()) {
    // // Se a guiaEmCadastramento nao chegou na de Cedente Eletronico
    // // Ainda nao esta cadastrado
    // if (this.getGuiaEmCadastramento() <
    // CedenteEstrategia.GUIA_CEDENTE_ELETRONICO) {
    // return "Não Cadastrado";
    // } else if (this.getGuiaEmCadastramento() ==
    // CedenteEstrategia.GUIA_CEDENTE_ELETRONICO) {
    // return "Em Cadastramento";
    // } else {
    // // Se ja passou da guia de cedente eletronico, mas existe um cedente
    // // cadastrado no banco
    // if (this.isCedenteEletronicoCadastrado()) {
    // return "Cadastrado";
    // } else {
    // return "Em Cadastramento";
    // }
    // }
    //            
    // } else {
    // return "Não Permitido";
    // }
    // }
    // ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.cedenteCentralizador);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            CedentePrincipalBean other = (CedentePrincipalBean) obj;
            result = result
                     && equals(getCedenteCentralizador(),
                             other.getCedenteCentralizador());
            result = result
                     && equals(getCedenteEletronicoCadastrado(),
                             other.getCedenteEletronicoCadastrado());
            result = result && equals(getGuiaAberta(), other.getGuiaAberta());
            result = result
                     && equals(getUltimaGuiaCadastrada(),
                             other.getUltimaGuiaCadastrada());
            result = result
                     && equals(getSituacaoGuia(), other.getSituacaoGuia());
            result = result
                     && equals(getTipoCobranca(), other.getTipoCobranca());
            return result;
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = 0;
        return result;
    }

    private static final Layout layout = initLayout();

    private static Layout initLayout() {
        java.util.TreeSet<Property> properties = new java.util.TreeSet<Property>();
        properties.add(new Property("cedenteCentralizador",
                LongType.create(),
                false,
                true));
        properties.add(new Property("cedenteEletronicoCadastrado",
                IntegerType.create(),
                false,
                true));
        properties.add(new Property("guiaAberta",
                IntegerType.create(),
                false,
                true));
        properties.add(new Property("ultimaGuiaCadastrada",
                IntegerType.create(),
                false,
                true));
        properties.add(new Property("situacaoGuia",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoCobranca",
                LongType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "CedentePrincipalBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("tipoCobranca", new LongValue("9(01)"));
        Mainframe.put("cedenteEletronicoCadastrado", new IntegerValue("9(01)"));
        Mainframe.put("situacaoGuia", new StringValue("X(01)"));
        Mainframe.put("cedenteCentralizador", new LongValue("9(07)"));
        Mainframe.put("ultimaGuiaCadastrada", new IntegerValue("9(02)"));
        Mainframe.put("guiaAberta", new IntegerValue("9(01)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }

    public boolean naoPodeCedenteEletronico() {
        if (CedenteEstrategia.COBRANCA_CONVENCIONAL.equals(this.getTipoCobranca())
             || (this.getCedenteCentralizador() != null && !this.getCedenteCentralizador()
                    .equals(new Long(0)))) {
            return true;
        } else if (CedenteEstrategia.COBRANCA_ELEITORAL_CONVENCIONAL.equals(this.getTipoCobranca())
                || (this.getCedenteCentralizador() != null && !this.getCedenteCentralizador()
                        .equals(new Long(0)))) {
           return true;
           } 
        return false;
    }
}
