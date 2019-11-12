package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;
import br.gov.caixa.sigcb.util.Formatador;

public class CedConsultaPermissaoBean extends SigcbBean {
	
	
	  private String DE_STCO_INTERNA;
	  private String DT_STCO_INTERNA;
	  private String HH_STCO_INTERNA;
	  private String CO_USRO_INTERNA;
	  private String DE_HIST_INTERNA;
	  private String DE_STCO_CIP;
	  private String DT_STCO_CIP;
	  private String HH_STCO_CIP;
	  private String DE_STCO_FINAL;
	  private String DT_STCO_FINAL;
	  private String HH_STCO_FINAL;
	  private String CO_USRO_FINAL;
	  private String DE_HIST_FINAL;
	  private String DE_ACAT_CIP;
	  private String DT_ACAT_CIP;
	  private String HH_ACAT_CIP;
	  private String CO_USRO_CIP;
	  private String DE_HIST_CIP;
	  
	  
	
	  public String getDE_STCO_INTERNA() {
		return DE_STCO_INTERNA;
	}
	public void setDE_STCO_INTERNA(String dE_STCO_INTERNA) {
		DE_STCO_INTERNA = dE_STCO_INTERNA;
	}
	public String getDT_STCO_INTERNA() {
		return DT_STCO_INTERNA;
	}
	public void setDT_STCO_INTERNA(String dT_STCO_INTERNA) {
		DT_STCO_INTERNA = dT_STCO_INTERNA;
	}
	public String getHH_STCO_INTERNA() {
		return HH_STCO_INTERNA;
	}
	public void setHH_STCO_INTERNA(String hH_STCO_INTERNA) {
		HH_STCO_INTERNA = hH_STCO_INTERNA;
	}
	public String getCO_USRO_INTERNA() {
		return CO_USRO_INTERNA;
	}
	public void setCO_USRO_INTERNA(String cO_USRO_INTERNA) {
		CO_USRO_INTERNA = cO_USRO_INTERNA;
	}
	public String getDE_HIST_INTERNA() {
		return DE_HIST_INTERNA;
	}
	public void setDE_HIST_INTERNA(String dE_HIST_INTERNA) {
		DE_HIST_INTERNA = dE_HIST_INTERNA;
	}
	public String getDE_STCO_CIP() {
		return DE_STCO_CIP;
	}
	public void setDE_STCO_CIP(String dE_STCO_CIP) {
		DE_STCO_CIP = dE_STCO_CIP;
	}
	public String getDT_STCO_CIP() {
		return DT_STCO_CIP;
	}
	public void setDT_STCO_CIP(String dT_STCO_CIP) {
		DT_STCO_CIP = dT_STCO_CIP;
	}
	public String getHH_STCO_CIP() {
		return HH_STCO_CIP;
	}
	public void setHH_STCO_CIP(String hH_STCO_CIP) {
		HH_STCO_CIP = hH_STCO_CIP;
	}
	public String getDE_STCO_FINAL() {
		return DE_STCO_FINAL;
	}
	public void setDE_STCO_FINAL(String dE_STCO_FINAL) {
		DE_STCO_FINAL = dE_STCO_FINAL;
	}
	public String getDT_STCO_FINAL() {
		return DT_STCO_FINAL;
	}
	public void setDT_STCO_FINAL(String dT_STCO_FINAL) {
		DT_STCO_FINAL = dT_STCO_FINAL;
	}
	public String getHH_STCO_FINAL() {
		return HH_STCO_FINAL;
	}
	public void setHH_STCO_FINAL(String hH_STCO_FINAL) {
		HH_STCO_FINAL = hH_STCO_FINAL;
	}
	public String getCO_USRO_FINAL() {
		return CO_USRO_FINAL;
	}
	public void setCO_USRO_FINAL(String cO_USRO_FINAL) {
		CO_USRO_FINAL = cO_USRO_FINAL;
	}
	public String getDE_HIST_FINAL() {
		return DE_HIST_FINAL;
	}
	public void setDE_HIST_FINAL(String dE_HIST_FINAL) {
		DE_HIST_FINAL = dE_HIST_FINAL;
	}
	public String getDE_ACAT_CIP() {
		return DE_ACAT_CIP;
	}
	public void setDE_ACAT_CIP(String dE_ACAT_CIP) {
		DE_ACAT_CIP = dE_ACAT_CIP;
	}
	public String getDT_ACAT_CIP() {
		return DT_ACAT_CIP;
	}
	public void setDT_ACAT_CIP(String dT_ACAT_CIP) {
		DT_ACAT_CIP = dT_ACAT_CIP;
	}
	public String getHH_ACAT_CIP() {
		return HH_ACAT_CIP;
	}
	public void setHH_ACAT_CIP(String hH_ACAT_CIP) {
		HH_ACAT_CIP = hH_ACAT_CIP;
	}
	public String getCO_USRO_CIP() {
		return CO_USRO_CIP;
	}
	public void setCO_USRO_CIP(String cO_USRO_CIP) {
		CO_USRO_CIP = cO_USRO_CIP;
	}
	public String getDE_HIST_CIP() {
		return DE_HIST_CIP;
	}
	public void setDE_HIST_CIP(String dE_HIST_CIP) {
		DE_HIST_CIP = dE_HIST_CIP;
	}
	@Override
	public String getApplicationName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Layout getLayout() {
		// TODO Auto-generated method stub
		return null;
	}
	  
	  
	  
}
