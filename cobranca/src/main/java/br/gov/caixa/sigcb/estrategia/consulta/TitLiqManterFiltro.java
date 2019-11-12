package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.ConGerTitulosLiquidadosDiaBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;
import br.gov.caixa.sigcb.util.jsp.PaginacaoTag;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consulta - Titulos
 * Liquidados Dia
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>05/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class TitLiqManterFiltro extends TitLiqManterEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String retorno = "";

        configMsgSucessoErro(request);

        String fluxo = getFluxo(request);

        ConGerTitulosLiquidadosDiaBean filtroBean = new ConGerTitulosLiquidadosDiaBean();
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        InformacoesUsuarioBean usuarioBean = new InformacoesUsuarioBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
            filtroBean = (ConGerTitulosLiquidadosDiaBean) filtroBean.getRequestBean(request);
            cedCabBean = (CedenteCabecaBean) cedCabBean.getRequestBean(request);
            // EAM 23/08
            PilhaVoltarControle.push(request, filtroBean);
        } else {
            // EAM 22/08
            filtroBean = (ConGerTitulosLiquidadosDiaBean) PilhaVoltarControle.pop(request);
            if (filtroBean == null) {
                return (new TitLiqManterIniciar()).processRequest(request,
                        response);
            }
            cedCabBean = (CedenteCabecaBean) cedCabBean.getSessionBean(request,
                    CABECALHO_BEAN);
        }

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(USUARIOLDAP_BEAN);

        request.getSession().setAttribute(CEDENTE_ATUAL,
                filtroBean.getCodigoCedente());// cedente padrao
        request.getSession().setAttribute(FILTRO_BEAN, filtroBean);
        
        int tipoConsulta = filtroBean.getTpConsulta().intValue();
        
        String tipoConsultaStr = String.valueOf(filtroBean.getTpConsulta());

        switch (tipoConsulta) {

        case 0: /* consulta por cedente */

            /* BGM0 */// - Obtem dados do Cedente
            cedCabBean.setTipoConsulta(new Long(1));
            cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
            cedCabBean.setCodigoCedente(filtroBean.getCodigoCedente());
            cedCabBean.setOrigemConsulta(new Long(1));

            BeanList cedCabBeanList = (BeanList) handler.executeSimpleTransactionQuery(cedCabBean,
                    TRANS_CEDENTE_CABECALHO);

            CedenteCabecaBean cabecalhoBean = (CedenteCabecaBean) cedCabBeanList.get(0);
            cabecalhoBean.setCodigoCedente(filtroBean.getCodigoCedente());

            request.getSession().setAttribute(CABECALHO_BEAN, cabecalhoBean);

            /* BGD4 */// - Listar Títulos
            int paginaAtual = 1;
            try {
                paginaAtual = Integer.parseInt(request.getParameter("pagina"));
                
            } catch (Exception e) {
            }

            filtroBean.setPagina((long) paginaAtual);

            if (filtroBean.getTipoConsulta()==1){
            	filtroBean.setNossoNumero(0L);
            }

            
            filtroBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());

            List titulosList = (List) handler.executeFixDataRecordsetTransaction(filtroBean,TRANS_LISTA_TITULOS);

            ConGerTitulosLiquidadosDiaBean fixoBean = (ConGerTitulosLiquidadosDiaBean) ((BeanList) titulosList.get(0)).get(0);

            BeanList titLiqBeanList = (BeanList) titulosList.get(1);
            ArrayList titPagArray = convertDataStructure(titLiqBeanList.iterator());

            filtroBean.setDataCredito(fixoBean.getDataCredito());
            filtroBean.setTotalRegistro(fixoBean.getTotalRegistro());
            request.getSession().setAttribute("totalRegistros", fixoBean.getTotalRegistro());
            request.getSession().setAttribute(PAGINACAO_LIST,getPageHolder(titPagArray));
            request.setAttribute(PAGINACAO_PAGE, "0");

            request.setAttribute(PaginacaoTag.PAGINA_ATUAL, paginaAtual);
            //request.setAttribute(PaginacaoTag.PAGINA_TOTAL, (int) Math.ceil(titPagArray.size() / 20.0));
            request.setAttribute(PaginacaoTag.PAGINA_TOTAL, (int) Math.ceil(fixoBean.getTotalRegistro() / 20.0));

            retorno = PAGE_LIQ_LISTA_CED;
            break;

        case 1: /* consulta por Unidade de Vinculacao */

            /* BGD3 */// - Lista cedentes por Unidade Vinculacao
            filtroBean.setTipoConsulta(new Long(1));
            filtroBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());

            List listaCedente = (List) handler.executeFixDataRecordsetTransaction(filtroBean,  TRANS_CEDENTE_POR_PV);

            ConGerTitulosLiquidadosDiaBean fixoCedBean = (ConGerTitulosLiquidadosDiaBean) ((BeanList) listaCedente.get(0)).get(0);
            ArrayList cedenteArray = convertDataStructure(((BeanList) listaCedente.get(1)).iterator());

            filtroBean.setNomeUnidade(fixoCedBean.getNomeUnidade());
            filtroBean.setDataCredito(fixoCedBean.getDataCredito());
            filtroBean.setTipoConsulta(fixoCedBean.getTipoConsulta());

            request.getSession().setAttribute(PAGINACAO_LIST,  getPageHolder(cedenteArray));

            request.setAttribute(PAGINACAO_PAGE, "0");

            retorno = PAGE_LIQ_LISTA_PV;
            break;
        case 3: //Expotar consulta para arquivo
        	
        	
        	 /* BGM0 */// - Obtem dados do Cedente
            cedCabBean.setTipoConsulta(new Long(1));
            cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
            cedCabBean.setCodigoCedente(filtroBean.getCodigoCedente());
            cedCabBean.setOrigemConsulta(new Long(1));

            cedCabBeanList = (BeanList) handler.executeSimpleTransactionQuery(cedCabBean,
                    TRANS_CEDENTE_CABECALHO);

            cabecalhoBean = (CedenteCabecaBean) cedCabBeanList.get(0);
            cabecalhoBean.setCodigoCedente(filtroBean.getCodigoCedente());

                       /* BGD4 */// - Listar Títulos
            
            ArrayList<ConGerTitulosLiquidadosDiaBean> titLiqLista = new ArrayList<ConGerTitulosLiquidadosDiaBean>();
            
            int totPag = filtroBean.getTotalRegistro().intValue() / 20;
    		int resto = filtroBean.getTotalRegistro().intValue() % 20;
    		if (resto > 0 ) {
    			totPag++;
    		}
            
            
            for(int i=1; i<=totPag;i++){
            	
                filtroBean.setPagina((long) i);

                if (filtroBean.getTipoConsulta()==1){
                	filtroBean.setNossoNumero(0L);
                }

                
                filtroBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());

                titulosList = (List) handler.executeFixDataRecordsetTransaction(filtroBean,TRANS_LISTA_TITULOS);

                fixoBean = (ConGerTitulosLiquidadosDiaBean) ((BeanList) titulosList.get(0)).get(0);

                titLiqBeanList = (BeanList) titulosList.get(1);
                titPagArray = convertDataStructure(titLiqBeanList.iterator());

                filtroBean.setDataCredito(fixoBean.getDataCredito());
                filtroBean.setTotalRegistro(fixoBean.getTotalRegistro());
                
                for (int z=0;z<titLiqBeanList.size();z++){
                	ConGerTitulosLiquidadosDiaBean tituloLiq = (ConGerTitulosLiquidadosDiaBean) titLiqBeanList.get(z);
                	titLiqLista.add(tituloLiq);
                }

            }
            
            String[] cabecalho = new String[6];
            cabecalho[0] = "Cedente:" + cabecalhoBean.getCodigoCedenteFormatado() +" Nome Cedente:" +cabecalhoBean.getNomeFantasia() + "\r\n";
            cabecalho[1] = "Tipo Pessoa:" + cabecalhoBean.getTipoPessoaTexto() + " CPF/CNPJ:" + cabecalhoBean.getCpfCnpjFormatado() + "\r\n";
            cabecalho[2] = "Codigo Cliente (COCLI):" + cabecalhoBean.getCodigoClienteCOCLI() + "\r\n";
            cabecalho[3] = "==========================================================================================================================================="+ "\r\n";
            cabecalho[4] = "Nosso Numero;Valor Pagamento;Meio Liquidacao;Forma"+ "\r\n";
            
            String[] dados = new String[titLiqLista.size()];
            
            for (int x=0;x<titLiqLista.size();x++){
            	ConGerTitulosLiquidadosDiaBean tituloLiq = (ConGerTitulosLiquidadosDiaBean) titLiqLista.get(x);
            	dados[x] = tituloLiq.getNossoNumeroFormatado() +";" + tituloLiq.getValorPagamento() + ";" +  tituloLiq.getMeioLiquidacao() + ";" + tituloLiq.getFormaLiquidacaoFormatada();
            }
            ServletOutputStream out = response.getOutputStream();
            
            response.setHeader("Content-Disposition","attachment;filename=TituloLiquidado.csv");
        	response.setContentType("application/x-download");		
        	response.setHeader ("Pragma", "public");
        	response.setHeader("Cache-control", "must-revalidate");
        	
            out.write(cabecalho[0].getBytes());
  	        out.write(cabecalho[1].getBytes());
  	        out.write(cabecalho[2].getBytes());
  	        out.write(cabecalho[3].getBytes());
  	        out.write(cabecalho[4].getBytes());
        	
 			for (int i=0;i < dados.length  ;i++){
 				String linha = dados[i] + "\r\n";
 				out.write(linha.getBytes());
 			}
 			
 			out.write(cabecalho[3].getBytes());
        	
 			out.flush();
 			out.close();
 			
 			filtroBean.setTpConsulta(1L);
 			
 			retorno =  PAGE_LIQ_FILTRO;
 			
 			break;
        	
        }

        request.getSession().setAttribute(FILTRO_BEAN, filtroBean);

        return retorno;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();

        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);

        request.getSession().setAttribute(MSG_BEAN, msgBean);

    }

}
