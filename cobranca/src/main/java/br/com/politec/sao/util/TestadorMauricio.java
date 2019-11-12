package br.com.politec.sao.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import br.com.politec.sao.business.types.PercentualType;

public class TestadorMauricio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String valor ="1550,00";
		DecimalFormat formatoDois = new DecimalFormat("##,###,###,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
		formatoDois.setMinimumFractionDigits(2);   
		formatoDois.setParseBigDecimal (true);  
		  
		System.out.println(formatoDois.format(valor)); 
	}
}
