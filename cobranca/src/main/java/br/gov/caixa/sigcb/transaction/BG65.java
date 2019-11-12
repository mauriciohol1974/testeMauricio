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
public class BG65 implements LayoutTransaction, Serializable {

    public void setLayout(FieldsByTransaction fields) {

        // BG65: Banco de titulos - Consulta Dados Complementares

        fields.listSimpleTransaction.put("BG65-IDA",
                new String[] { "codigoCedente", "nossoNumero", "meioEntrada" });
        fields.listSimpleTransaction.put("BG65-VOLTA",
                new String[] {
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
                              "compleRetidoValorIOF",
                              "iofAtraso",
                              "jurosAtraso",
                              "tipoDesconto",
                              "valorJuros",
                              "datajuros"});
    }
}
