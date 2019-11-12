function validaTamanhoCampo(campo, nome, tamanho) {
	if(campo.value.length < tamanho) {
		msg("002",nome);
		try{
			campo.focus();
		}catch(exp){}
		return false;
	}
	return true;
}

function validaTamanhoCampo2(campo, nome, tamanho, msgErro) {
	if(campo.value.length < tamanho) {
		msg(msgErro,nome);
		try{
			campo.focus();
		}catch(exp){}
		return false;
	}
	return true;
}

function validaIntervalo(campo, nome, ini, fim) {
	if(parseInt(campo.value,10) < parseInt(ini,10) || parseInt(campo.value,10) > parseInt(fim,10) ) {
		msg("005", nome, ini, fim);
		try{
			campo.focus();
		}catch(exp){}
		return false;
	}
	return true;
}

function validaMaior(campo, nome, fim) {
	if(parseInt(campo.value,10) > parseInt(fim,10)) {
		msg("007",nome, fim);
		try{
			campo.focus();
		}catch(exp){}
		return false;
	}
	return true;
}

function validaMenor(campo, nome, ini) {
	if(parseInt(campo.value,10) < parseInt(ini,10)) {
		msg("006",nome, ini);
		try{
			campo.focus();
		}catch(exp){}
		return false;
	}
	return true;
}
function validaMenorIgual(campo, nome, ini, noAlert) {
	if(parseInt(campo.value,10) <= parseInt(ini,10)) {
		msg("006",nome, ini, null, noAlert);
		try{
			campo.focus();
		}catch(exp){}
		return false;
	}
	return true;
}

function validaCampoObrigatorio(campo, nome, noAlert) {
	if(trim(campo.value) == "") {
		msg("001", nome, null, null, noAlert);
		if(!campo.disabled) {
			try{
				campo.focus();
			}catch(exp){}
		}
		return false;
	}
	return true;
}

//
// Depende da funcao desformataMoney do funcoes.js
//
function validaCampoMoneyObrigatorio(campo, nome) {
	if(trim(campo.value) == "" || desformataMoney(campo.value) == 0) {
		msg("001", nome);
		if(!campo.disabled) {
			try{
				campo.focus();
			}catch(exp){}
		}
		return false;
	}
	return true;
}

function validaCampoPercentualObrigatorio(campo, nome) {
	if(trim(campo.value) == "" || desformataPercentual(campo.value) == 0) {
		msg("001", nome);
		if(!campo.disabled) {
			try{
				campo.focus();
			}catch(exp){}
		}
		return false;
	}
	return true;
}

function validaComboObrigatorio(campo, nome, brancoValue, noAlert) {
	if(campo.value == "-1" || campo.value == "" || campo.value == brancoValue) {
		msg("001", nome, null, null, noAlert);
		if(!campo.disabled) {
			try{
				campo.focus();
			}catch(exp){}
		}
		return false;
	}
	return true;
}

/* Valida se uma das opcoes de um radio button foi pressionado
	 Caso nao, chama mensagem msg do parametro em mensagem.js
*/
function validaRadioButtonMsg(campo, nomeCampo, codMsg) {
	var validaRadio = false;
	for(i=0;i<campo.length;i++) {
		if(campo[i].checked == true) {
			validaRadio = true;
		}
	}
	if(!validaRadio) {
		msg(codMsg,nomeCampo);
		return false;
	}
	return true;
}

/* Valida se uma das opcoes de um radio button foi pressionado
	 Caso nao, chama mensagem 004 do javascript: mensagem.js
*/
function validaRadioButton(campo, nomeCampo) {
	return validaRadioButtonMsg(campo, nomeCampo, "003");
}

/* Valida se o caracter digitado esta presente em sua lista de validacao
	 Utilizado em onkeypress: onKeyPress="javascript:return eval('verificaCaractInvalido(this, String.fromCharCode(event.charCode || event.keyCode),0);')"
*/
function validaCaract(campo, caract, valor) {
  alfa = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzçÇÁáÀàÉéÈèÍíÌìÓóÒòÚúÙùÃãÕõÂâÊêÎîÔôÛû";
	alfaNumericoSemEspeciais = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890 ";
	email = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890@._-";
	numerico = "1234567890";
	numericoTelefone = "1234567890-";
	numericoValor = "1234567890.,";
	numericoCpfCnpj = ".1234567890/ ";
	alfaNumericoNomeImpressora = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890_-";
	alfaNumericoSimples = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890/<>=-+*$%_-().,; !?";
	alfaSemEspeciais = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	switch(valor) {

		case 0: { // NUMERICO: Testa se o valor pertence ao conjunto dos numericos
			if(numerico.indexOf(caract) >= 0) {
				return true;
			} else {
				return false;
			}
			break;
		}

		case 1: { // ALFA: Testa se o valor pertence ao conjunto dos alfanumericos com todas as especiais
			if(campo.value.length >= 0) {
				if(alfa.indexOf(caract) >= 0) {
					return true;
				} else {
					return false;
				}
			}
			break;
		}

		case 2: { // CPFCNPJ: Testa se o valor é valido para CPF e CNPJ
			if(numericoCpfCnpj.indexOf(caract) >= 0) {
				return true;
			} else {
				return false;
			}
			break;
		}

		case 3: { // ALFANUMEIMPRESSORA: Testa se o valor é valido para Alfanumericos, traco e underscore
			if(campo.value.length == 0) {
				if(alfaSemEspeciais.indexOf(caract) >= 0) {
					return true;
				} else {
					return false;
				}
			}	else {
				if(alfaNumericoNomeImpressora.indexOf(caract) >= 0) {
					return true;
				} else {
					return false;
				}
			}
			break;
		}

		case 4: { // NUMEROVALOR: Testa se o valor é valido para NUMERICOVALOR (numero .  , )
			if(campo.value.length == 0) {
				if(numerico.indexOf(caract) >= 0) {
					return true;
				}
				return false;
			}	else {
				if(numericoValor.indexOf(caract) >= 0) {
					return true;
				}
				return false;
			}
			break;
		}

		case 5: { // NUMEROTELEFONE: Testa se o valor é valido para NUMEROTELEFONE (numero - )
			if(campo.value.length == 0) {
				if(numerico.indexOf(caract) >= 0) {
					return true;
				}
				return false;
			} else {
				if(numericoTelefone.indexOf(caract) >= 0) {
					return true;
				}
				return false;
			}
			break;
		}

		case 6: { // ALFASEMESPECIAIS: Testa se o valor é valido para Alfanumericos sem especiais
			if(alfaNumericoSemEspeciais.indexOf(caract) >= 0) {
				return true;
			}	else {
				return false;
			}
			break;
		}

		case 7: { // EMAIL: Testa se o valor é valido para Alfanumericos, arroba, underscore, traco e ponto
			if(email.indexOf(caract) >= 0) {
				return true;
			} else {
				return false;
			}
			break;
		}

		case 8: { // ALFASIMPLES: Testa se o valor é valido para AlfaSimples: alfa + alguns simbolos
			if(alfaNumericoSimples.indexOf(caract) >= 0) {
				return true;
			}	else {
				return false;
			}
			break;
		}
	}
}

/**********************************************************************************
comparaDatas: compara duas datas, se a primeira data for anterior a segunda,
devolve true. Nao verifica se as datas sao validas.
Devem ser passados os inputs de dia, mes e ano
**********************************************************************************/

function comparaDatas(dia1, mes1, ano1, dia2, mes2, ano2) {
	var dia1 = dia1.value == "" ? 0 : parseFloat(dia1.value);
	var mes1 = mes1.value == "" ? 0 : parseFloat(mes1.value);
	var ano1 = ano1.value == "" ? 0 : parseFloat(ano1.value);
	var dia2 = dia2.value == "" ? 0 : parseFloat(dia2.value);
	var mes2 = mes2.value == "" ? 0 : parseFloat(mes2.value);
	var ano2 = ano2.value == "" ? 0 : parseFloat(ano2.value);

	if (ano1 < ano2){
		return true;
	}
	if (ano1 == ano2){
		if (mes1 < mes2) {
			return true;
		}
		if (mes1 == mes2) {
			if (dia1 <= dia2){
				return true;
			}
		}
	}
	return false;
}


/**********************************************************************************
 validaData: valida campo data (dd/mm/aaaa).
 Devem ser passados os inputs de dia, mes e ano
**********************************************************************************/

function validaData(dia, mes, ano){
  var idia = dia.value == "" ? 0 : parseFloat(dia.value);
  var imes = mes.value == "" ? 0 : parseFloat(mes.value);
  var iano = ano.value == "" ? 0 : parseFloat(ano.value);

  if ((imes==1 || imes==3 || imes==5 || imes==7 || imes==8 || imes==10 || imes==12) && idia>31){
  	msg("005");
        dia.focus();
        return false;
  }
  if ((imes==4 || imes==6 || imes==9 || imes==11) && idia>30) {
  	msg("005");
        dia.focus();
        return false;
  }
  if (imes==2) {
      if ((iano%4 != 0) && (idia>28)){
  	msg("005");
        dia.focus();
        return false;
      }
      else if ((iano%4 == 0) && (idia>29)){
  	msg("005");
        dia.focus();
        return false;
      }
  }
  if (idia==0) {
  	msg("005");
        dia.focus();
        return false;
  }

  if (imes>12 || imes==0) {
  	msg("005");
        mes.focus();
        return false;
  }

  if (iano<1900 || iano>2200) {
  	msg("005");
        ano.focus();
        return false;
  }
  return true;
}

function validaCPF(numeroCPF){
	valor = numeroCPF;
	if(numeroCPF.length != 11 && numeroCPF.length != 14){
		return false;
	}
	if (numeroCPF.length > 11){
		if (numeroCPF.indexOf(".") < 0 && numeroCPF.indexOf("-") < 0){
			numeroCPF = numeroCPF.substring(3,14);
		}
		CPF = "";
		for(i=0;i<(numeroCPF.length);i++){
			if (numeroCPF.charAt(i) != "." && numeroCPF.charAt(i) != "-"){
				CPF += numeroCPF.charAt(i);
			}
		}
	}
	else{
		CPF = numeroCPF;
	}
	if (CPF.length != 11 || CPF == "00000000000" || CPF == "11111111111" ||
		CPF == "22222222222" ||	CPF == "33333333333" || CPF == "44444444444" ||
		CPF == "55555555555" || CPF == "66666666666" || CPF == "77777777777" ||
		CPF == "88888888888" || CPF == "99999999999"){
		return false;
	}
	soma = 0;
	for (i=0; i < 9; i ++)
		soma += parseInt(CPF.charAt(i)) * (10 - i);
	resto = 11 - (soma % 11);
	if (resto == 10 || resto == 11)
		resto = 0;
	if (resto != parseInt(CPF.charAt(9))){
		return false;
	}
	soma = 0;
	for (i = 0; i < 10; i ++)
		soma += parseInt(CPF.charAt(i)) * (11 - i);
	resto = 11 - (soma % 11);
	if (resto == 10 || resto == 11)
		resto = 0;
	if (resto != parseInt(CPF.charAt(10))){
		return false;
	}
	return true;
}

function validaCNPJ(numeroCNPJ){
	if (numeroCNPJ.length != 14 && numeroCNPJ.length != 18){
		return false;
	}
	if (numeroCNPJ.length > 14){
		CNPJ = "";
		for(i=0;i<numeroCNPJ.length;i++){
			if (numeroCNPJ.charAt(i) != "." && numeroCNPJ.charAt(i) != "-" && numeroCNPJ.charAt(i) != "/"){
				CNPJ = CNPJ + numeroCNPJ.charAt(i);
			}
		}
	}
	else{
		CNPJ = numeroCNPJ;
	}
	// Recebe o CNPJ e informa se
	// é falso ou verdadeiro ' O sinal > indica que a linha continua
	var numCNPJ, DV;
	var Soma, Digito;
	var i, j;
	var Controle, Mult;

	// Identifica as 2 partes do CNPJ
	numCNPJ = CNPJ.substring(0,12);
	DV = CNPJ.substring(12);

	// Multiplicadores que fazem parte
	// do algoritmo de checagem
	Mult = "543298765432";

	// Inicializa a variável Controle
	Controle = "";

	// Loop de verificação
	for(j=0; j < 2; j++){
		Soma = 0;

		for(i=0; i < 12; i++){
				Soma = Soma + numCNPJ.charAt(i) * Mult.charAt(i);
		}

		if(j == 1){
			Soma = Soma + (2 * Digito);
		}

		Digito = (Soma * 10) % 11 ;

		if(Digito == 10) Digito = 0;

		Controle = Controle + Digito;

		// Seqüência de multiplicadores para
		// o cálculo do segundo Digito
		Mult = "654329876543";
	}

	// Compara dígitos calculados (Controle)
	// com dígitos informados (DV)
	if(Controle != DV){
		return false;
	}
	else{
		return true;
	}
}

function validaDvMod11(numConta,numDig)
{
	var i, total, fator, dv;
	total= 0;
	fator= 2;
	dv= 0;
	for (i = 15; i > 0; i--)
	{
		total=total+parseInt(numConta.substring(i-1,i))*fator;
		fator++;
		if (fator>9)
			fator=2;
	}
	dv=11-(total % 11);
	if (dv == 10)
		dv= 0;

        if (dv == numDig)
            return true;
        else
            return false;
}


function desabilitaCampoAlternado(campo1, campo2){
	if(campo1.value == '0,00 %' || campo1.value == 'R$ 0,00'){
		campo1.value = '';
	}
	if(trim(campo1.value) != ''){
		campo2.disabled=true;
		campo2.value = '';
	}
}

function habilitaCampoAlternado(campo1, campo2){
	if(trim(campo1.value) != '' && campo1.value != '0,00 %' && campo1.value != 'R$ 0,00'){
		campo2.disabled=false;
		campo2.value = '';
	}
}

function desabilitaCampoDependente(campo1, campo2, campoDep){

	if(campo1.value == '0,00 %' || campo1.value == 'R$ 0,00'){
		campo1.value = '';
	}
	if(campo2.value == '0,00 %' || campo2.value == 'R$ 0,00'){
		campo2.value = '';
	}

	if(trim(campo1.value) == '' && trim(campo2.value) == ''){
		campoDep.disabled=true;
		if (campoDep.type == "select-one") {
			campoDep.value = '0';
		}
		else{
			campoDep.value = '';
		}
	}
	if (campo1.type == "select-one" && trim(campo1.value) == '0') {
		campoDep.disabled=true;
		campoDep.value = '';
	}
}

function habilitaCampoDependente(campo1, campo2){
	campo2.disabled=false;
}

function habilitaCampoDependente2(campoValor, campoPercentual, campoDep){
	if(trim(campoValor.value) != '' || trim(campoPercentual.value) != ''){
		campoDep.disabled=false;
	}
}

function validaCampoObrigatorioAlternado(campo1,campo2, nome, msge, valor1, valor2) {
	if(trim(campo1.value) == "" && trim(campo2.value) == "") {
		msg(msge, nome, valor1, valor2);
		if(!campo1.disabled) {
			campo1.focus();
		}
		return false;
	}
	return true;
}


// Valida array de campos obrigatorios no formato:
//	    	var camposObrigatorios = new Array(11);
//				camposObrigatorios[0] = new Array( "prazoProtesto", "Prazo Protesto" );
//	    	camposObrigatorios[1] = new Array( "prazoDevolucao", "Prazo Devolução" );
// Array com o nome do campo, label do campo
//
// Limitacoes:
// . Nome do form deve ser frmMain
// . Valida Input Text e Combos (select-one)
//
function validaArrayCamposObrigatorios( camposObrigatorios ) {
	for (var i = 0; i < camposObrigatorios.length; i++) {
		if(camposObrigatorios[i] == null){
			continue;
		}
		var field = eval("document.frmMain." + camposObrigatorios[i][0]);
		if (field.type == "text") {
			if (!validaCampoObrigatorio(field, camposObrigatorios[i][1])) {
				return false;
			}
		} else if (field.type == "select-one") {
			if (!validaComboObrigatorio(field, camposObrigatorios[i][1])) {
				return false;
			}
		}
	}

	return true;
}


//
function validaCEPMaior(campo, nome, ini) {
  if (parseInt(CEPsemTraco(campo.value)) < parseInt(CEPsemTraco(ini))) {
    msg("006",nome, ini);
    try{
      campo.focus();
    }catch(exp){}
    return false;
  }
  return true;
}

function validaCEPMaiorIgual(campo, nome, ini) {
  if (parseInt(CEPsemTraco(campo.value)) <= parseInt(CEPsemTraco(ini))) {
    msg("006",nome, ini);
    try{
      campo.focus();
    }catch(exp){}
    return false;
  }
  return true;
}


function CEPsemTraco(s) {
//sem zero inicial
  var result = '';
  for(var k=0; k<s.length; k++) {
    if(s.charAt(k)!='-') {
      result = result + s.charAt(k);
    }
  }
  return parseInt(result,10);
}

/**
Nome:		validarData
Objetivo:	Verificar se data informada é uma data válida.
Data:		18/10/2004
Depende:	-
*/
function validarData(s_date) {
		var re_dt = /^(\d{1,2})\/(\d{1,2})\/(\d{4})$/;
		// check format
		if (!re_dt.test(s_date))
			return false;
		// check allowed ranges
		if (RegExp.$1 > 31 || RegExp.$2 > 12)
			return false;
		// check number of day in month
		var dt_test = new Date(RegExp.$3, Number(RegExp.$2-1), RegExp.$1);
		if (dt_test.getMonth() != Number(RegExp.$2-1))
			return false;
		return true;
}

/**
Nome:		validarDataAteHoje
Objetivo:	Verificar se data é menor ou igual a hoje que a atual
Data:		18/10/2004
Depende:	validarData
*/
function validarDataAteHoje(data) {
	if (!validarData(data)) return false;
	var hoje, hojeEmMS, dia, mes, ano, dataEmMS;
	hoje = new Date();
	dia = hoje.getDate();
	mes = hoje.getMonth();
	ano = hoje.getYear();
	//hoje inclui a hora é necessário gerar uma nova data para retirar a hora.
	hojeEmMS = new Date(ano, mes, dia);
	dia = data.substr(0, 2);
	mes = data.substr(3, 2)-1;
	ano = data.substr(6, 4);
	dataEmMS = new Date(ano, mes, dia);
	if (!(dataEmMS <= hojeEmMS))
		return false;
	else
		return true;
}

/**
Nome: 		Comparar Datas
Objetivo: Verificar se para duas datas informadas o operador é verdadeiro
Data:			21/10/2004
Depende:	validarData2
Parmetro: dataInicio, dataFim é um string que representa uma data no formato "dd/mm/yyyy"
					operadores válidos: ==, <=, >=, !=, <, >, operadores lógicos.
*/
function compararDatas(dataInicio, dataFim, operador) {
			return eval(date2MS(dataInicio) + operador  + date2MS(dataFim));
}
/**
Nome:		date2MS
Objetivo:	Retornar o número de milisegundos que se passaram entre 01/01/1970 e a data fornecida.
Data:		18/10/2004
Depende:	validarData
Parmetro: dateValue é um string que representa uma data no formato "dd/mm/yyyy"
*/
function date2MS(dateValue){
			var tmp;
			if (!validarData(dateValue)) return false;
			dia = dateValue.substr(0, 2);
			mes = dateValue.substr(3, 2)-1;
			ano = dateValue.substr(6, 4);
			tmp = new Date(ano, mes, dia);
			return tmp.getTime();
}

function validaValorZero(objCampo, strMensagem){
	objTemp = new Object('value');
	objTemp.value= objCampo.value;

	if(objTemp.value.substr(0,1) == "R"){
		unFormataCurrency(objTemp);
	}
	else{
		formataCurrency(objTemp);
		unFormataCurrency(objTemp);
	}
	if(new Number(objTemp.value) == 0 || trim(objTemp.value) == ''){
		msg('006',strMensagem, "R$ 0,00");
		try{
			objCampo.focus();
			return false;
		}catch(erro){}
	}
	else{
		return true;
	}
}

function validaPercentualZero(objCampo, strMensagem){
	objTemp = new Object('value');
	objTemp.value= objCampo.value;
	if (objTemp.value.indexOf('%') != -1) {
		unFormataPercentual(objTemp);
	}else {
		formataPercentual(objTemp);
		unFormataPercentual(objTemp);
	}
	if(new Number(objTemp.value) == 0 || trim(objTemp.value) == ''){
		msg('006', strMensagem , "0,00 %");
		try{
			objCampo.focus();
			return false;
		}catch(erro){}
	} else {
		return true;
	}
}

function validaPercentualCem(objCampo, strMensagem){
	objTemp = new Object('value');
	objTemp.value= objCampo.value;
	if (objTemp.value.indexOf('%') != -1) {
		unFormataPercentual(objTemp);
	}else {
		formataPercentual(objTemp);
		unFormataPercentual(objTemp);
	}
	if(new Number(objTemp.value) >= 10000){
		msg('007', strMensagem , "100,00 %");
		try{
			objCampo.focus();
			return false;
		}catch(erro){}
	} else {
		return true;
	}
}

function limpaPercentualZero(objCampo)	{
	objTemp = new Object('value');
	objTemp.value= objCampo.value;

	if(objTemp.value.substr(objTemp.value.length - 1,1) == "%"){
			unFormataPercentual(objTemp);
		}
		else{
			formataPercentual(objTemp);
			unFormataPercentual(objTemp);
		}
  	if(new Number(objTemp.value) == 0 || trim(objTemp.value) == ''){
		objCampo.value = '';
	}
}

//Compara números de acordo com o operador informado
function compara(objCampo1, objCampo2, operador){
	return eval(new Number (objCampo1.value) + operador  + new Number (objCampo2.value));
}

//Mesma função da anterior, porém atribui o foco ao campo
function comparaNumero(objCampo1, objCampo2, operador){
	if(!compara(objCampo1, objCampo2, operador)){
		try{
			objCampo2.focus();
			return false;
		}catch(erro){}
	}else {
		return true;
	}
}


function comparaPercentual(objCampo1, objCampo2, operador){
	objTemp1 = new Object('value');
	objTemp1.value= objCampo1.value;
	objTemp2 = new Object('value');
	objTemp2.value= objCampo2.value;

	if (objTemp1.value.indexOf('%') != -1) {
		unFormataPercentual(objTemp1);
	}else {
		formataPercentual(objTemp1);
		unFormataPercentual(objTemp1);
	}
	if (objTemp2.value.indexOf('%') != -1) {
		unFormataPercentual(objTemp2);
	}else {
		formataPercentual(objTemp2);
		unFormataPercentual(objTemp2);
	}
	if(!compara(objTemp1, objTemp2, operador)){
		try{
			objCampo2.focus();
			return false;
		}catch(erro){}
	}else {
		return true;
	}
}

function comparaValor(objCampo1, objCampo2, operador){
	objTemp1 = new Object('value');
	objTemp1.value= objCampo1.value;
	objTemp2 = new Object('value');
	objTemp2.value= objCampo2.value;

	if(objTemp1.value.substr(0,1) == "R"){
		unFormataCurrency(objTemp1);
	}
	else{
		formataCurrency(objTemp1);
		unFormataCurrency(objTemp1);
	}
	if(objTemp2.value.substr(0,1) == "R"){
		unFormataCurrency(objTemp2);
	}
	else{
		formataCurrency(objTemp2);
		unFormataCurrency(objTemp2);
	}
	if(!compara(objTemp1, objTemp2, operador)){
		try{
			objCampo2.focus();
			return false;
		}catch(erro){}
	}else {
		return true;
	}
}

//Funções para validar se um intervalo de dias sem possuir o mês é válido.
//Exemplo: dia_inicio_intervalo = 1
//				 dia_pesquisa = 12
//				 tamanho_intervalo = 11
//Nesta situação, o intervalo é válido, pois entre o inicio e o final existem 11 dias.

function verifica_dia_no_intervalo(dia_inicio_intervalo, tamanho_intervalo, dia_pesquisa) {
	var dia_limite_ini = dia_inicio_intervalo;
	if (dia_limite_ini==31)
		dia_limite_ini = 1;
	var dia_limite_fim = add_dia_no_intervalo(dia_limite_ini, tamanho_intervalo);

	if (dia_pesquisa==31) {
		dia_pesquisa = 1;
		if (dia_inicio_intervalo == 1)
			return false;
	}

	var i = dia_limite_ini;
	do {
		if (i == dia_pesquisa)
			return true;
		i = add_dia_no_intervalo(i,1);
	} while (i != dia_limite_fim)

	return false;
}
function add_dia_no_intervalo(variavel, taxa) {
	variavel = new Number(variavel) + new Number(taxa);
	if (variavel > 30) {
		variavel = variavel - 30;
		if (variavel == 0)
			variavel++;
	}
	return variavel;
}

/*
Valida o campo input para ter somente valores numéricos. Esta função se difere
das demais no sentido de que não realiza a verificação a cada tecla apertada,
mas no conteúdo como um todo.

parametros:
objetoCampo -> campo a ser validado, obtido por exemplo
			   através de 'document.getElementsByName(<<nome do campo>>)[0]'

retorno:
true - se o campo possui somente dígitos, false caso contrário.

*/
function validaInputNumerico(objetoCampo){
    var valor = objetoCampo.getAttribute('value');
    var reDigits = /^\d+$/;
    return reDigits.test(valor)
}