/*
ltrim: remove espaço em branco do lado esquerdo
rtrim: remove espaço em branco do lado direito
trim: remove espaço em branco ambos os lados
 */

function rtrim(mvar)
{
   if(mvar.substring(mvar.length - 1, mvar.length) == " ") mvar = rtrim(mvar.substring(0, mvar.length - 1));
   return mvar;
}

function ltrim(mvar)
{
   if(mvar.substring(0, 1) == " ") mvar = ltrim(mvar.substring(1, mvar.length));
   return mvar;
}

function trim(mvar)
{
   return rtrim(ltrim(mvar));
}

/* 
replaceAll: troca todas as "pVar1" por "pVar2" em "pVar"
*/
function replaceAll(pVar, pVar1, pVar2)
{
   if(pVar.indexOf(pVar1) != - 1) pVar = replaceAll(pVar.replace(pVar1, pVar2), pVar1, pVar2);
   return pVar;
}

//
// Substitui barras por pontos
//
function substituiBarraPorPonto( stringComBarras ) {
	//alert('substituiBarraPorPonto');
	return replaceAll(stringComBarras, '/', '.');
}

//
// Substitui pontos por barras
//
function substituiPontoPorBarra( stringComPontos ) {
	//alert('substituiPontoPorBarra');
	return replaceAll(stringComPontos, '.', '/');
}

//
// Retorna a descricao do combo passado
//
function getDescricaoSelect( select ) {
	//alert('getDescricaoSelect');
	return select.options[select.selectedIndex].text;
}

//
// Adiciona dias a uma determinada data. Retorna uma String.
//
function AddDay(Day,Days) {
	//Day = data para calculo 
	//Days = qtd dias para calculo
			
	var strData = new String(Day);
	var dia = new String(strData.substr(0,2));
	var mes = new String(strData.substr(3,2));
	var ano = new String(strData.substr(6,4));
		
	if (dia.substr(0,1) == "0"){
		dia = dia.substr(1,1);
	}
	if (mes.substr(0,1) == "0"){
		mes = mes.substr(1,1);
	}
			
	var d=new Date(parseInt(ano),parseInt(mes),parseInt(dia),00,00,00);
	
	d.setDate(d.getDate() + parseInt(Days));
	dia = d.getDate();
	mes = d.getMonth();
	ano = d.getFullYear();
	strDia = new String();
	strDia = dia.toString();
	strMes = mes.toString();
	
	if (strDia.length == 1){
		strDia = "0" + strDia;
	}
	
	if (strMes.length == 1){
		strMes = "0" + strMes;
	}
		
	return strDia + '/' + strMes + '/' + ano;
}

function comparaDatas(data1, data2){
	
	var dia1 = new String(data1.substr(0,2));
	var mes1 = new String(data1.substr(3,2));
	var ano1 = new String(data1.substr(6,4));
	
	var dia2 = new String(data2.substr(0,2));
	var mes2 = new String(data2.substr(3,2));
	var ano2 = new String(data2.substr(6,4));
	
	if(dia1.length == 1){
		dia1 = "0"+dia1;
	}
	
	if(mes1.length ==1){
		mes1 = "0"+mes1;
	}
	
	if(dia2.length == 1){
		dia2 = "0"+dia2;
	}
	
	if(mes2.length ==1){
		mes2 = "0"+mes2;
	}
	
	var strData1 = ano1 + mes1 + dia1;
	var strData2 = ano2 + mes2 + dia2;
	
	nData1 = new Number(strData1);
	nData2 = new Number(strData2);
	
	if(nData1 < nData2){
		return -1;
	}
	
	if(nData1 == nData2){
		return 0;
	}
	
	if(nData1 > nData2){
		return 1;
	}
	
}

function desformataMoney(valorFormatado) {
	var regExpMoney = /^R\$ [0-9.]+,[0-9][0-9]$/;
	
	if (valorFormatado.match(regExpMoney) == null) {
		return valorFormatado;
	}

	var vlrSemSimbolo = valorFormatado.substring(3);
	var result = '';
	for(i = 0; i < vlrSemSimbolo.length; i++) {
		if((vlrSemSimbolo.charAt(i)!='.')&&(vlrSemSimbolo.charAt(i)!=',')) {
			result = result + vlrSemSimbolo.charAt(i);
		}
	}
	return result;
}

function desformataPercentual(valorFormatado) {
	var regExpPercentual = /^[0-9.]+,[0-9][0-9] %$/;
	
	if (valorFormatado.match(regExpPercentual) == null) {
		return valorFormatado;
	}
	
	var valorSemPorCento = valorFormatado.substr(0, valorFormatado.length - 2);
	var result ='';
	for(var i = 0; i < valorSemPorCento.length; i++){
		if((valorSemPorCento.charAt(i)!='.')&&(valorSemPorCento.charAt(i)!=',')) {
			result = result + valorSemPorCento.charAt(i);
		}
	}
	return result;
}

// Texto formatar inserirndo barraEne nas colunas desejadas
// No texto informado nao pode haver nenhum barraEne
function inserebarraEne(texto, numColunas) {
	texto = removeBarraEne(texto, numColunas);
	
	var textoTemp="";
	var ini=0;
	if ((ini+numColunas < texto.length) && (texto.indexOf('\n') == -1) ) {
		while (ini+numColunas < texto.length) {
			textoTemp += rtrim(texto.substring(ini, ini+numColunas)) + '\n';
			ini += numColunas;
		}
		textoTemp += rtrim(texto.substring(ini));
		texto = textoTemp + '\n';
	}
	return texto;
}	
	
// Texto a Concatenar, tamanho da coluna a ser formatada
// Remove os barraEne
function removeBarraEne(texto, numColunas){ 
		var textoTemp = "";
		var txtLinha = "";
		var colunaAtual = 0;
		if (texto.indexOf('\n') != -1) {
			for (var i = 0; i < texto.length; i++) {
  			if (texto.charAt(i) != '\r' && texto.charAt(i) != '\n') {
					txtLinha += texto.charAt(i);
  			} else {
					if (texto.charAt(i) == '\r')
	  				i++;
					if (colunaAtual < numColunas)
						for (var j=0; j <= ((numColunas-1)-colunaAtual); j++)
							txtLinha += " ";
					colunaAtual = -1;
					textoTemp += txtLinha;
					txtLinha = "";
	  		}
				colunaAtual++;
			}
		} else {
			textoTemp = texto;
		}
		return textoTemp;    
}
	    
	    
