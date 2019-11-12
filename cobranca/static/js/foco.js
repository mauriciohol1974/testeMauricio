/* Seta o foco no primeiro campo da tela dentre os tipo definidos:
	 	 text, select-one,	textarea,	radio.
	 Deve ser utilizada dentro da function inicia().
*/
function setFirstFieldFocus() {
	if(document.forms.length == 1) 
		oFrm = document.forms[0];
		for (n=0;n < oFrm.length; n ++){
			tipo = oFrm.elements[n].type;
			if (tipo=='text' || tipo=='select-one' || tipo=='textarea' || tipo=='radio' || tipo=='button'){
				if (!oFrm.elements[n].disabled){
					try{
						oFrm.elements[n].focus();
					}catch(erro){}
					break;
				}
			}
		}
}		

/* Seta o foco no proximo campo quando o campo original estiver totalmente preenchido.
	 	 key: ultima tecla pressionada
  	 fieldFrom: campo original
	   fieldTo: campo destino
	 Deve ser implementado na funcao onkeyup: onkeyup="nextFocus(event.keyCode, this, document.frmMain.nomeproxcampo)"
*/
function nextFocus(key, fieldFrom, fieldTo) {
	if( key!=9 && key!=16) {
		if(fieldFrom.value.length == fieldFrom.maxLength) {
			try{
				fieldTo.focus();
				if(fieldTo.type != "select-one") {
			  	 fieldTo.select();
				}
			}catch(erro){}
		}
	}
}

/* Seta o foco no proximo campo após o usuário selecionar uma opção de radio button
	   fieldTo: campo destino
	 Deve ser implementado na funcao onclick: onclick="javascript:radioNextFocus(document.frmMain.nomeproxcampo);"
*/
function radioNextFocus(fieldTo) {
			    	fieldTo.select();
}

/* Selecionado todo o conteudo do campo caso este esteja totalmente preenchido.
	 	 field: nome do campo atual
	 Deve ser implementado na funcao onfocus: onFocus="prevFocus(this);"
*/
function prevFocus(field) {
	if(field.value.length == field.maxLength) {
		field.select();
	}
}