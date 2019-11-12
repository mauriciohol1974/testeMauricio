package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

import br.com.politec.sao.util.Money;
import br.gov.caixa.sigcb.util.FieldsByTransaction;
import br.gov.caixa.sigcb.util.LayoutTransaction;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Banco de Títulos
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>22/09/2004</DD>
 * </DL>
 * 
 * @author Antonio Nestor Fusel - afusel@sao.politec.com.br
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */
public class BG60 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BG60: Banco de titulos - Consulta Dados Principais

        fields.listSimpleTransaction.put("BG60-IDA",
                new String[] { "codigoCedente", "nossoNumero", "meioEntrada","nuIdentificaCIP","nuRefereciaCIP" , "nuBaixa"});
        fields.listSimpleTransaction.put("BG60-VOLTA",
                new String[] {
                              "princiMeioEntrada",
                              "princiValorTitulo",
                              "princiSituacao",
                              "princiDescricaoSituacao",
                              "princiNumeroDocumento",
                              "princiDataVencimento",
                              "princiMoeda",
                              "princiAceite",
                              "princiDescricaoAceite",
                              "princiIndicadorProt",
                              "princiPrazoProtDev",
                              "princiEndosso",
                              "princiEspecie",
                              "princiSiglaEspecie",
                              "princiSacadoNome",
                              "princiSacadoTipoPessoa",
                              "princiSacadoCpfCnpj",
                              "princiSacadoCep",
                              "princiSacadoUf",
                              "princiSacadoLogradouro",
                              "princiSacadoNumero",
                              "princiSacadoComplemento",
                              "princiSacadoBairro",
                              "princiSacadoMunicipio",
                              "princiSacadoEmail",
                              "princiPvCobrador",
                              "princiDescricaoPvCobrador",
                              "princiDescricaoEspecie",
                              // !inclusao de campo gcb ! dia: 22/06/2006
                              "comunicacaoSacado",
                              "cobrarTarifa",
                              // BLOQUETO-EXPRESSO
                              "princiDataDocumento",
                              "princiPvVinculacao",
                              "princiModalidade",
                              "blqexpdummyDataProcessamento",
                              "ordProtDataMovimento",
                              "emissaoBloqueto",
                              "envioBloqueto",
                              //DDA SIGCB
                              "situacaoBloqSE",
                              "numIdDDA",
                              "aceiteSE",
                              "alegacaoSE",
                              "tipoCalculo",
                              "autorizacao",
                              "filler",
                              "dddSMS",
                              "celularSMS",
                              "tipoSMS",
                              "descrEntrega",
                              "icRateio",
                              "icGarantia",
                              "dtGarantia",
                              "coUsuario",
                              "parcela",
                              "icRegistroCIP",
                              "nuIdentificaCIP",
                              "nuRefereciaCIP",
                              "sgIndexador",
                              "icTipoPagamento",
                              "vrMaximoPgto",
                              "vrMinPgto",
                              "icAutPagto",
                              "qtPgtoPossivel",
                              "qtPgtoEfetuado",
							  "vrSaldoTitulo",
							  "nossoNumero",
							  "coErroCIP",
							  "dtCompetencia",
							  "tpPessoaPrt",
		  					  "cpfCnpjPrt",
							  "snBaixa"});
    }
}
