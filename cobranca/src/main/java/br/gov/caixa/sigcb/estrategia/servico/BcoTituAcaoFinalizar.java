package br.gov.caixa.sigcb.estrategia.servico;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.CodBar;
import br.com.politec.sao.util.Interleaved2of5;
import br.gov.caixa.sigcb.bean.BoletoJasperBean;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.ImpressaoBloqBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.LiquidacoesSTRBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.TituloBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.Formatador;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Banco de Títulos
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>17/09/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */

public class BcoTituAcaoFinalizar extends BcoTituEstrategia {

    private String custom_SUCESSO_ACAO = "";

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Configurações para Mensagens e Telas de Erro e Sucesso
        configMsgSucessoErro(request);

        // Recupera/define informacoes do titulo
        TituloBean tituloBean = new TituloBean();
        if (getFluxo(request).equals(FLUXO_NORMAL)) {
            // Obtem dados do request:
            TituloBean reqTituloBean = new TituloBean();
            reqTituloBean = (TituloBean) reqTituloBean.getRequestBean(request);
            reqTituloBean.setMeioEntrada(new Long(1));

            // Obtem dados:
            tituloBean = (TituloBean) tituloBean.getSessionBean(request,
                    DATA_BEAN);
            copyTituloDadosFiltroToTitulo(reqTituloBean, tituloBean);

            // Recupera informacoes do usuario
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                    .getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN);
            tituloBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());

            // Retem informacoes do bean antes do acesso ao mainframe
            request.getSession().setAttribute(DATA_BEAN, tituloBean);

        } else {
            tituloBean = (TituloBean) tituloBean.getSessionBean(request,
                    DATA_BEAN);
        }

        // Recupera/define informacoes de cabecalho do cedente
        BcoTituEstrategia.setCedenteCabecaBean(tituloBean, request);

        // Executa transacao de Acoes
        //MainFrameTransactionsSigcb handler = BcoTituEstrategia.lookUpMFHandler();

        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_ACOES_PROTESTO_OUTROS + usuarioBean.getCodigoUsuario().toUpperCase();
        handler.executeSimpleTransactionVoid(tituloBean,
        		transUser);

        // Executa transacao de Impressao
        List tituloMsgBlqList = new ArrayList();
        switch (tituloBean.getAcoesServicoTitulo().intValue()) {

        case 13: // Impressão 2 via de bloqueto
            // Obtem bean com informacoes da guia "Dados Impressao
            // Bloqueto(BG64)"
            List tituloList = (ArrayList) getTituloDadosImpressaoBloqueto(request, response,  tituloBean);
            tituloBean = (TituloBean) tituloList.get(0);
            
            /* BG65 */
            usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            transUser = TRANSACAO_DADOS_COMPLEMENTARES + usuarioBean.getCodigoUsuario().toUpperCase();
      
            BeanList tituloBeanList = (BeanList) handler.executeSimpleTransactionQuery(tituloBean,  transUser);
            TituloBean newTituloBean = (TituloBean) tituloBeanList.get(0);
            
            tituloMsgBlqList = (ArrayList) tituloList.get(1);
            
            //Chamada da transação de salvar a impressão do bloqueto
            
            // Chamada ao Mainframe
            //handler = SigcbEstrategia.lookUpMFHandler();// Instancia
            handler = new MainFrameTransactionsSigcbEjb();
            BeanList fixoBeanList;
            ImpressaoBloqBean impressaoBloqBean = new ImpressaoBloqBean();
            
            impressaoBloqBean.setCodigoCedente(tituloBean.getCodigoCedente());
            impressaoBloqBean.setNossoNumero(tituloBean.getNossoNumero());
            impressaoBloqBean.setDataVencimento(tituloBean.getPrinciDataVencimentoFormatada());
            Date data = new Date();  
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");  
            SimpleDateFormat formatHora = new SimpleDateFormat("HH:mm:ss");
            impressaoBloqBean.setDataImpressao(formatador.format(data));
            impressaoBloqBean.setHoraImpressao(formatHora.format(data));
            impressaoBloqBean.setLinhaDigitavel(tituloBean.getBloqCodigoBarrasNumerico());
            impressaoBloqBean.setValorDocumento(tituloBean.getPrinciValorTitulo());
            String ip = request.getRemoteAddr();
            impressaoBloqBean.setIpMaquina(ip);
            impressaoBloqBean.setSistema("1");
            impressaoBloqBean.setCodUsuario(SigcbEstrategia.COD_USUARIO);
             usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
             transUser = TRANSACAO_SALVA_IMPRESSAO_BLOQUETO + usuarioBean.getCodigoUsuario().toUpperCase();
            fixoBeanList = handler.executeSimpleTransactionQuery(impressaoBloqBean, transUser);
            
            impressaoBloqBean = (ImpressaoBloqBean) fixoBeanList.get(0);
            
            
         // Impressão 2 via de bloqueto
            // Obtem bean com informacoes da guia "Dados Impressao
            // Bloqueto(BG64)"
           
            tituloBean = (TituloBean) tituloList.get(0);
            tituloMsgBlqList = (ArrayList) tituloList.get(1);
            
            //Incluir dados para geração do boleto JASPER
            
            CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
            cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();
            
            cedCabBean = (CedenteCabecaBean) request.getSession().getAttribute(CEDENTE_CABECALHO_BEAN);
            
            BoletoJasperBean bolJasper = new BoletoJasperBean();
        	
        	bolJasper.setAceite(tituloBean.getPrinciDescricaoAceite());
        	bolJasper.setAgenciaCedente(tituloBean.getPrinciPvVinculacaoFormatado() + "/" + tituloBean.getCodigoCedenteFormatado());
        	bolJasper.setCarteira(tituloBean.getPrinciModalidade());
        	bolJasper.setCepCedente(cedCabBean.getCepFormatado());
        	bolJasper.setCepSacado(tituloBean.getPrinciSacadoCepFormatado());
        	bolJasper.setCpfAvalista(newTituloBean.getCompleSacadorCpfCnpjFormatado());
        	bolJasper.setCpfCedente(cedCabBean.getCpfCnpjFormatado());
        	bolJasper.setCpfSacado(tituloBean.getPrinciSacadoCpfCnpjFormatado());
        	//bolJasper.setDtDocto(tituloBean.getPrinciDataDocumentoFormatada());
        	bolJasper.setDtDocto(tituloBean.getAbatiDataEmissaoFormatada());
        	bolJasper.setDtProcessamento(Formatador.formatarData(Calendar.getInstance().getTime()));
        	bolJasper.setEndCedente(cedCabBean.getLogradouro().trim()+","+cedCabBean.getNumero().trim()+"-"+ cedCabBean.getComplemento().trim()+ "," + cedCabBean.getBairro().trim()+ "-"+ cedCabBean.getMunicipio().trim());
        	bolJasper.setEndSacado(tituloBean.getPrinciSacadoLogradouro().trim()+","+tituloBean.getPrinciSacadoNumero().trim()+","+tituloBean.getPrinciSacadoComplemento().trim()+","+tituloBean.getPrinciSacadoBairro().trim()+","+tituloBean.getPrinciSacadoMunicipio().trim());
        	bolJasper.setEspecie(tituloBean.getPrinciSiglaEspecie());
    		
        	String mensagemRecibo[] = new String[100];
        	
        	String mensagemCorporativa[] = new String [100];
        	
        	for(int i=0; i < 100; i++) {
        		mensagemRecibo[i] = "";

            	
        	}
        	
        	TituloBean B = new TituloBean();
			for(int i=0; i < tituloMsgBlqList.size(); i++) {
          			B = (TituloBean) tituloMsgBlqList.get(i);
          			mensagemRecibo[i] = B.getBloqDescricaoMensagem().trim();
			}          												
        	
        	bolJasper.setInstrucao1(mensagemRecibo[0]);
        	bolJasper.setInstrucao2(mensagemRecibo[1]);
        	bolJasper.setInstrucao3(mensagemRecibo[2]);
        	
        	List<String> mensagemCorp = new ArrayList<String>();
        	List<String> mensagemFicha = new ArrayList<String>();
        	TituloBean oB = new TituloBean();
			for(int i=0; i < tituloMsgBlqList.size(); i++) { 
				oB = (TituloBean) tituloMsgBlqList.get(i);
				if (oB.getBloqTipoMensagem()!=9){
					mensagemFicha.add(oB.getBloqDescricaoMensagem().trim());
				}else{
					mensagemCorp.add(oB.getBloqDescricaoMensagem().trim());
				}
			}

			
			List<String> mensagemBoleto = new ArrayList<String>();
			int totalMensagens = 16 - mensagemCorp.size();
			for (int i=0;i<mensagemFicha.size();i++){
				String mensAux = (String) mensagemFicha.get(i);
				mensagemBoleto.add(mensAux);
			}
			int itensBrancos = totalMensagens - mensagemBoleto.size();		
			for(int i=0; i < itensBrancos; i++) {
				mensagemBoleto.add("");
			}
			

			for(int i=0; i < mensagemCorp.size(); i++) {
				mensagemBoleto.add((String) mensagemCorp.get(i));
			}

        	if (tituloBean.getPrinciSiglaEspecie().trim().equalsIgnoreCase("BP")){
            	
        		String msgDesc[] = new String[4];
				msgDesc[0]="";
				msgDesc[1]="";
				msgDesc[2]="";
				msgDesc[3]="";
        		int contMsg = 0;
        		for (int ms=0;ms<16;ms++){
        			if (contMsg>3){
        				break;
        			}
        			if ( mensagemBoleto.get(ms).toString().contains("DESCONTO")){
        				msgDesc[contMsg] =  mensagemBoleto.get(ms).toString();
        				contMsg++;
        			}
        			
        			
        		}
            	
        		bolJasper.setMens1(msgDesc[0]);
            	bolJasper.setMens2(msgDesc[1]);
            	bolJasper.setMens3(msgDesc[2]);
        		bolJasper.setMens4(msgDesc[3]);
            	bolJasper.setMens5("BOLETO DE PROPOSTA");
            	bolJasper.setMens6("ESTE BOLETO SE REFERE A UMA PROPOSTA JÁ FEITA A VOCÊ E O SEU PAGAMENTO NÃO É OBRIGATÓRIO.");
            	bolJasper.setMens7("Deixar de pagá-lo não dará causa a protesto, a cobrança judicial ou extrajudicial, ");
            	bolJasper.setMens8("nem a inserção de seu nome em cadastro de restrição ao crédito. ");
            	bolJasper.setMens9("Pagar até a data de vencimento significa aceitar a proposta.");
            	bolJasper.setMens10("Informações adicionais sobre a proposta e sobre o respectivo contrato poderão ser solicitadas a qualquer momento ao Beneficiário,");
            	bolJasper.setMens11("por meio de seus canais de atendimento." );
            	bolJasper.setMens12("");
            	bolJasper.setMens13("");
            	bolJasper.setMens14("");
            	bolJasper.setMens15("");
            	bolJasper.setMens16("");
        		
            	
        	}else{
            	bolJasper.setMens1((String) mensagemBoleto.get(0));
            	bolJasper.setMens2((String) mensagemBoleto.get(1));
            	bolJasper.setMens3((String) mensagemBoleto.get(2));
            	bolJasper.setMens4((String) mensagemBoleto.get(3));
            	bolJasper.setMens5((String) mensagemBoleto.get(4));
            	bolJasper.setMens6((String) mensagemBoleto.get(5));
            	bolJasper.setMens7((String) mensagemBoleto.get(6));
            	bolJasper.setMens8((String) mensagemBoleto.get(7));
            	bolJasper.setMens9((String) mensagemBoleto.get(8));
            	bolJasper.setMens10((String) mensagemBoleto.get(9));
            	bolJasper.setMens11((String) mensagemBoleto.get(10));
            	bolJasper.setMens12((String) mensagemBoleto.get(11));
            	bolJasper.setMens13((String) mensagemBoleto.get(12));
            	bolJasper.setMens14((String) mensagemBoleto.get(13));
            	bolJasper.setMens15((String) mensagemBoleto.get(14));
            	bolJasper.setMens16((String) mensagemBoleto.get(15));
        	}
        	
        	bolJasper.setMoeda(tituloBean.getPrinciMoedaSimbolo());
        	bolJasper.setNomeCedente(cedCabBean.getNomeFantasia());
        	bolJasper.setNossoNumero(tituloBean.getNossoNumeroFormatado()+"-" +tituloBean.getBloqDigitoCtrlNossoNumero());
        	bolJasper.setNumDocto(tituloBean.getPrinciNumeroDocumento());
        	bolJasper.setSacado(tituloBean.getPrinciSacadoNome());
        	bolJasper.setSacAvalista(newTituloBean.getCompleSacadorNome());
        	bolJasper.setUfCedente(cedCabBean.getUf());
        	bolJasper.setUfSacado(tituloBean.getPrinciSacadoUf());
        	
        	String valDecimal =  String.valueOf(tituloBean.getPrinciValorTitulo().getDecimalAmount());
        	if (valDecimal.length()<2){
        		valDecimal = "0"+valDecimal;
        	}
        	
        	String valFormatado = String.valueOf(tituloBean.getPrinciValorTitulo().getIntegerAmount()) +"." +valDecimal;
        	
    		Double valDouble = Double.valueOf(valFormatado);
    		Locale localePtBr = new Locale("pt" , "BR");
        	bolJasper.setValorDocumento( NumberFormat.getCurrencyInstance(localePtBr).format(valDouble));
        	
        	bolJasper.setVencimento(tituloBean.getPrinciDataVencimentoFormatada());
        	bolJasper.setRepresentacao(tituloBean.getBloqCodigoBarrasFormatado());
        	bolJasper.setCodBarras(tituloBean.getBloqCodigoBarrasNumerico());
        	

        	if (tituloBean.getVrDesAba().getAmount()>0L){
        		bolJasper.setDescontoAbatimento(tituloBean.getVrDesAba().toString());
        	}else{
        		bolJasper.setDescontoAbatimento("");
        	}
        	if (tituloBean.getVrMltJur().getAmount()>0L){
        		bolJasper.setMultaJuros(tituloBean.getVrMltJur().toString());
        	}else{
        		bolJasper.setMultaJuros("");
        	}
        	if (tituloBean.getVrMltJur().getAmount()>0L){
        		bolJasper.setMultaJuros(tituloBean.getVrMltJur().toString());
        	}else{
        		bolJasper.setMultaJuros("");
        	}
        	if (tituloBean.getVrCalculado().getAmount()>0L){
        		bolJasper.setValorPago(tituloBean.getVrCalculado().toString());
        	}else{
        		bolJasper.setValorPago("");
        	}
        	if (tituloBean.getVrCalculado().getAmount()>0L){
        		bolJasper.setValorPago(tituloBean.getVrCalculado().toString());
        	}else{
        		bolJasper.setValorPago("");
        	}
        	if (tituloBean.getVrCalculado().getAmount()>0L){
        		bolJasper.setValorPago(tituloBean.getVrCalculado().toString());
        	}else{
        		bolJasper.setValorPago("");
        	}
        	if (tituloBean.getVrDesconto().getAmount()>0L){
        		bolJasper.setValorDesconto(tituloBean.getVrDesconto().toString());
        	}else{
        		bolJasper.setValorDesconto("");
        	}
        	
        	if (tituloBean.getVrCobrado().getAmount()>0L){
        		bolJasper.setValorCobrado(tituloBean.getVrCobrado().toString());
        	}else{
        		bolJasper.setValorCobrado("");
        	}
        	
        	
        	//Criar o arquivo do código de barras
        	
    		CodBar bar = new Interleaved2of5(bolJasper.getCodBarras());
            
    		bar.ALTURA = 50;
    		bar.LARGURA = 450;
    		bar.COR_FUNDO = Color.WHITE;
    		bar.COR_BARRAS = Color.BLACK;
    		bar.MARGEM_ESQUERDA = 15;
    		bar.MARGEM_DIREITA = 15;
    		        
    		BufferedImage BarImage = bar.render();

    		//File fileSaida = new File(File.separator + "apl" + File.separator +"sigcb" + File.separator +"codBarras" + bolJasper.getCodBarras() + ".gif");
    		
    		//FileOutputStream fos = new FileOutputStream(fileSaida);
    		
    		//ImageIO.write(BarImage, "GIF", fileSaida);
    		//fos.flush();
    		//fos.close();
    		
    		List<BoletoJasperBean> lista = new ArrayList<BoletoJasperBean>();
    		
    		lista.add(bolJasper);
    		
    		File fileImg = new File(File.separator + "apl" + File.separator +"sigcb" + File.separator +"logo_caixa.gif");
            
            BufferedImage logo = ImageIO.read(fileImg) ;
            //BufferedImage cdBar = ImageIO.read(fileSaida) ;

            Map parametros = new HashMap();  
      		parametros.put("IMAGEM", logo);
      		parametros.put("IMAGEM2", logo);
      		parametros.put("IMAGEM3", BarImage);
    		
      		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(lista); 
    		
      		JasperPrint impressao = JasperFillManager.fillReport(File.separator + "apl" + File.separator +"sigcb" + File.separator + "Boleto.jasper",parametros, ds);
    		
    		//converte o relatorio em bytes gerando o pdf  
    		byte[] bytes = JasperExportManager.exportReportToPdf(impressao);  
    		byte[] arquivoSaida = bytes;  
    		
    		//Tratamento para exportacao do pdf para a url do browser e o tratamento de erros.  
    		String nomeDoArquivo = "Boleto.pdf";  
    		response.setContentType("application/x-msdownload");  
    		response.setHeader("Content-Disposition", "attachment; filename=".concat(nomeDoArquivo));  
    		response.setContentLength(arquivoSaida.length);  
    		ServletOutputStream sos = response.getOutputStream();  
    		sos.write(arquivoSaida, 0, arquivoSaida.length);  
    		sos.flush();  
    		sos.close();  
    		
    		return PAGE_FILTRO_ACAO;
    		
            
            /////////////////////////////////////////////
            

        case 5: // Impressão 2 via ordem de protesto e Impressão 2 via de
                // bloqueto
            // Obtem bean com informacoes da guia "Dados Principais (BG60)"
            // tituloBean = getTituloDadosPrincipais (request, response,
            // tituloBean);
            // Obtem bean com informacoes da guia "Dados Complementares (BG65)"
            tituloBean = getTituloDadosComplementares(request,
                    response,
                    tituloBean);

            // Retem informacoes do bean depois do acesso ao mainframe
            request.getSession().setAttribute(DATA_BEAN, tituloBean);
            request.getSession().setAttribute(DATA_MSG_BLQ_LIST,
                    tituloMsgBlqList);
        }

        // RE-Configurações para Mensagens e Telas de Erro e Sucesso
        this.custom_SUCESSO_ACAO = tituloBean.getAcoesServicoTituloTexto();
        configMsgSucessoErro(request);

        return PAGE_SUCESSO;

    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("Ação " + this.custom_SUCESSO_ACAO + SUCESSO_ACAO);
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_FILTRO);
        msgBean.setStrategySucessReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setTitlePage(PAGE_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}