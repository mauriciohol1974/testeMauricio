package br.gov.caixa.sigcb.transaction;

import java.io.Serializable;

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
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br *
 */
public class BG63 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BG63: Banco de titulos - Alteração dos Dados

        fields.listSimpleTransaction.put("BG63-IDA",
                new String[] {
                              "codigoCedente",
                              "nossoNumero",
                              "princiNumeroDocumento",
                              "princiDataVencimento",
                              "princiMoeda",
                              "princiAceite",
                              "princiIndicadorProt",
                              "princiPrazoProtDev",
                              "princiEndosso",
                              "princiEspecie",
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
                              "compleTipoJurosMes",
                              "complePercenJurosMes",
                              "compleSacadorNome",
                              "compleSacadorTipoPessoa",
                              "compleSacadorCpfCnpj",
                              "compleAbatimento",
                              "compleDescontoUmPercen",
                              "compleDescontoUmValor",
                              "compleDescontoUmPrazo",
                              "compleDescontoUmData",
                              "compleDescontoDoisPercen",
                              "compleDescontoDoisValor",
                              "compleDescontoDoisPrazo",
                              "compleDescontoDoisData",
                              "compleDescontoTresPercen",
                              "compleDescontoTresValor",
                              "compleDescontoTresPrazo",
                              "compleDescontoTresData",
                              "compleMultaPercen",
                              "compleMultaValor",
                              "compleMultaPrazo",
                              "compleMultaData",
                              "comunicacaoSacado",
                              "cobrarTarifa",
                              "codigoUsuario",
                              "emissaoBloqueto",
                              "envioBloqueto",
                              "compleRetidoValorIOF",
                              "dddSMS",
                              "celularSMS",
                              "tipoSMS",
                              "icTipoPagamento",
                              "icAutPagto",
                              "qtPgtoPossivel",
                              "vrMaximoPgto",
                              "vrMinPgto",
                              "princiValorTitulo",
                              "tipoDesconto",
                              "valorJuros",
                              "datajuros"});
    }
}
