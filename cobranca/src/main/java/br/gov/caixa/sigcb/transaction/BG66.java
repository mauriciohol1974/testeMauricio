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
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */
public class BG66 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BG66: Banco de titulos - Consulta Encargos e Abatimento

        fields.listSimpleTransaction.put("BG66-IDA",
                new String[] { "codigoCedente", "nossoNumero", "meioEntrada" });
        fields.listSimpleTransaction.put("BG66-VOLTA",
                new String[] {
                              "abatiDataEmissao",
                              "abatiDataEntrada",
                              "abatiDataPrevisaoProtDev",
                              "abatiCustasCartorarias",
                              "abatiModalidade",
                              "abatiMultaPercen",
                              "abatiMultaValor",
                              "abatiMultaPrazo",
                              "abatiMultaData",
                              "abatiJurosPercen",
                              "abatiJurosValor",
                              "abatiJurosData",
                              "abatiDescontoUmPercen",
                              "abatiDescontoUmValor",
                              "abatiDescontoUmPrazo",
                              "abatiDescontoUmData",
                              "abatiDescontoDoisPercen",
                              "abatiDescontoDoisValor",
                              "abatiDescontoDoisPrazo",
                              "abatiDescontoDoisData",
                              "abatiDescontoTresPercen",
                              "abatiDescontoTresValor",
                              "abatiDescontoTresPrazo",
                              "abatiDescontoTresData",
                              "abatiAbatimento",
                              "abatiRetidoValorIOF",
                              "iofAtraso",
                              "jurosAtraso",
                              "tipoDesconto",
                              "tipoJuros"});
    }
}
