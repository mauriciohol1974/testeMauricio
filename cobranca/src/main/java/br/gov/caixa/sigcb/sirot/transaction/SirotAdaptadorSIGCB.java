package br.gov.caixa.sigcb.sirot.transaction;

import java.io.Serializable;

import org.apache.log4j.Logger;

import br.gov.caixa.iso.ISOMsg;
import br.gov.caixa.sirot.ejb.SIROTCon;

public class SirotAdaptadorSIGCB implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 311794497962976419L;

	private static final Logger LOG = Logger.getLogger(SirotAdaptadorSIGCB.class);
	
	private SIROTCon sirotConEjb = null;
	
	public ISOMsg[] executaSirot(ISOMsg mensagem) throws Exception{

		//String sirotEjbName = "java:global/sirotcon-ejb/SIROTConBean!br.gov.caixa.sirot.ejb.SIROTCon";
		
		String sirotEjbName = "java:global/sirotcon-ejb-2.3.0.1/SIROTConBean!br.gov.caixa.sirot.ejb.SIROTCon";
		
		LOG.info("SIROTCon: " + sirotEjbName);
		
		sirotConEjb = (SIROTCon) ServiceLocator.locate(sirotEjbName,ServiceLocator.EJB);
		LOG.info("SIROTCon encontrado!");

		ISOMsg[] retorno = null;
		long start = System.currentTimeMillis();
		LOG.info("Chamando getResponse...");
		retorno = sirotConEjb.getResponse(mensagem);
		long end = System.currentTimeMillis();
		
		
		System.out.println("Tempo de acesso ao SIROT: '" + (end - start) + "' ms");
		LOG.info("Quantidade de mensagens de retorno: " + retorno.length);

		return retorno;
		
	}

}
