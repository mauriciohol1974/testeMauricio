
package br.gov.caixa.sigcb.sirot.transaction;

import org.apache.log4j.Logger;



import br.gov.caixa.iso.ISOException;
import br.gov.caixa.iso.ISOField;
import br.gov.caixa.iso.ISOMsg;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

public class MontaTransacao {
	
	private static final Logger LOG = Logger.getLogger(MontaTransacao.class);
	
	
	public ISOMsg BGMJ (String bit62, String usuario) throws ISOException{
	
	try{	
		
		
		LOG.info("<<Conteudo bit62 BGMJ::" + bit62);
		LOG.info("Montando ISOMsg...");
		ISOMsg mensagem = new ISOMsg();
		mensagem.set(new ISOField(0, "0205"));
		mensagem.set(new ISOField(3, "640400"));
		mensagem.set(new ISOField(33, "9683"));
		mensagem.set(new ISOField(62, bit62));
		mensagem.set(new ISOField(63, "BGMJ" + usuario.toUpperCase() + " " + "                  "));
		mensagem.set(new ISOField(71, "0001"));
		mensagem.set(new ISOField(72, "9999"));
		mensagem.set(new ISOField(100, "0104"));
		LOG.info("ISOMsg Criada");
		return mensagem;
	} catch (ISOException e){
		LOG.error(e);
	} catch (Exception ex){
		LOG.error(ex);
	}
		return null;
	}
	
	public ISOMsg BGMT (String bit62, String usuario) throws ISOException{
		
		try{	
			
			
			LOG.info("<<Conteudo bit62 BGMT::" + bit62);
			LOG.info("Montando ISOMsg...");
			ISOMsg mensagem = new ISOMsg();
			mensagem.set(new ISOField(0, "0205"));
			mensagem.set(new ISOField(3, "640400"));
			mensagem.set(new ISOField(33, "9683"));
			mensagem.set(new ISOField(62, bit62));
			mensagem.set(new ISOField(63, "BGMT" + usuario.toUpperCase() + " " + "                  "));
			mensagem.set(new ISOField(71, "0001"));
			mensagem.set(new ISOField(72, "9999"));
			mensagem.set(new ISOField(100, "0104"));
			LOG.info("ISOMsg Criada");
			return mensagem;
		} catch (ISOException e){
			LOG.error(e);
		} catch (Exception ex){
			LOG.error(ex);
		}
			return null;
		}
	
	public ISOMsg BGMK (String bit62,String usuario) throws ISOException{
		
	try{	
		
		
		LOG.info("<<Conteudo bit62 BGMK::" + bit62);
		LOG.info("Montando ISOMsg...");
		ISOMsg mensagem = new ISOMsg();
		mensagem.set(new ISOField(0, "0205"));
		mensagem.set(new ISOField(3, "640400"));
		mensagem.set(new ISOField(33, "9683"));
		mensagem.set(new ISOField(62, bit62));
		mensagem.set(new ISOField(63, "BGMK" + usuario.toUpperCase() + " " + "                  "));
		mensagem.set(new ISOField(71, "0001"));
		mensagem.set(new ISOField(72, "9999"));
		mensagem.set(new ISOField(100, "0104"));
		LOG.info("ISOMsg Criada");
		return mensagem;
	} catch (ISOException e){
		LOG.error(e);
	} catch (Exception ex){
		LOG.error(ex);
	}
		return null;
	}
	
	
	
	public ISOMsg BGUL (String bit62, String usuario) throws ISOException{
		
	try{	
		
		
		LOG.info("<<Conteudo bit62 BGUL::" + bit62);
		LOG.info("Montando ISOMsg...");
		ISOMsg mensagem = new ISOMsg();
		mensagem.set(new ISOField(0, "0205"));
		mensagem.set(new ISOField(3, "640400"));
		mensagem.set(new ISOField(33, "9683"));
		mensagem.set(new ISOField(62, bit62));
		mensagem.set(new ISOField(63, "BGUL" + usuario.toUpperCase() + " " + "                  "));
		mensagem.set(new ISOField(71, "0001"));
		mensagem.set(new ISOField(72, "9999"));
		mensagem.set(new ISOField(100, "0104"));
		LOG.info("ISOMsg Criada");
		return mensagem;
	} catch (ISOException e){
		LOG.error(e);
	} catch (Exception ex){
		LOG.error(ex);
	}
		return null;
	}


	public ISOMsg BGNO (String bit62, String usuario) throws ISOException{
		
		try{	
			
			
			LOG.info("<<Conteudo bit62 BGNO::" + bit62);
			LOG.info("Montando ISOMsg...");
			ISOMsg mensagem = new ISOMsg();
			mensagem.set(new ISOField(0, "0205"));
			mensagem.set(new ISOField(3, "640400"));
			mensagem.set(new ISOField(33, "9683"));
			mensagem.set(new ISOField(62, bit62));
			mensagem.set(new ISOField(63, "BGMO" + usuario.toUpperCase() + " " + "                  "));
			mensagem.set(new ISOField(71, "0001"));
			mensagem.set(new ISOField(72, "9999"));
			mensagem.set(new ISOField(100, "0104"));
			LOG.info("ISOMsg Criada");
			return mensagem;
		} catch (ISOException e){
			LOG.error(e);
		} catch (Exception ex){
			LOG.error(ex);
		}
			return null;
		}
	
	public ISOMsg BGMW (String bit62, String usuario) throws ISOException{
		
		try{	
			
			
			LOG.info("<<Conteudo bit62 BGMW::" + bit62);
			LOG.info("Montando ISOMsg...");
			ISOMsg mensagem = new ISOMsg();
			mensagem.set(new ISOField(0, "0205"));
			mensagem.set(new ISOField(3, "640400"));
			mensagem.set(new ISOField(33, "9683"));
			mensagem.set(new ISOField(62, bit62));
			mensagem.set(new ISOField(63, "BGMW" + usuario.toUpperCase() + " " + "                  "));
			mensagem.set(new ISOField(71, "0001"));
			mensagem.set(new ISOField(72, "9999"));
			mensagem.set(new ISOField(100, "0104"));
			LOG.info("ISOMsg Criada");
			return mensagem;
		} catch (ISOException e){
			LOG.error(e);
		} catch (Exception ex){
			LOG.error(ex);
		}
			return null;
		}
	
	
	public ISOMsg BGMU (String bit62, String usuario) throws ISOException{
		
		try{	
			
			
			LOG.info("<<Conteudo bit62 BGMU::" + bit62);
			LOG.info("Montando ISOMsg...");
			ISOMsg mensagem = new ISOMsg();
			mensagem.set(new ISOField(0, "0205"));
			mensagem.set(new ISOField(3, "640400"));
			mensagem.set(new ISOField(33, "9683"));
			mensagem.set(new ISOField(62, bit62));
			mensagem.set(new ISOField(63, "BGMU" + usuario.toUpperCase() + " " + "                  "));
			mensagem.set(new ISOField(71, "0001"));
			mensagem.set(new ISOField(72, "9999"));
			mensagem.set(new ISOField(100, "0104"));
			LOG.info("ISOMsg Criada");
			return mensagem;
		} catch (ISOException e){
			LOG.error(e);
		} catch (Exception ex){
			LOG.error(ex);
		}
			return null;
		}

}
