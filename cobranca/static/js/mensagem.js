/**********************************************************
	m�todo utilizado para padroniza��o de mensagems do sistema
	  numero: numero da mensagem
	  nomeCampo: nome do campo a ser informado na tela
**********************************************************/
function conf(numero, nomeCampo) {
	if(numero == "100") {
		texto = 'Deseja realmente incluir este ' + nomeCampo + '?';
	}
	if(numero == "101") {
		texto = 'Deseja realmente alterar este ' + nomeCampo + '?';
	}
	if(numero == "102") {
		texto = 'Deseja realmente excluir este ' + nomeCampo + '?';
	}
	if(numero == "103") {
		texto = 'Deseja voltar e descartar os dados informados?';
	}
	if(numero == "104") {
		texto = "Este cedente ficar� pendente de conclus�o. Deseja realmente voltar?";
	}
	if(numero == "105") {
		texto = 'Deseja realmente cancelar o cadastramento deste Cedente?';
	}
	if(numero == "106") {
		texto = "Deseja realmente abrir a guia e descartar os dados informados?";
	}
	if(numero == "107") {
		texto = "Deseja realmente incluir esta Guia?";
	}
	if(numero == "108") {
		texto = 'Deseja realmente estornar esta Liquida��o Rejeitada?';
	}
	if(numero == "109") {
		texto = 'Esta Liquida��o encontra-se ' + nomeCampo + '. Deseja realmente cancelar essa A��o?';
	}
	if(numero == "110") {
		texto = 'Deseja realmente executar o Recomando desta Liquida��o Rejeitada?';
	}
	if(numero == "111") {
		texto = 'Deseja realmente executar o Recomando Especial desta Liquida��o Rejeitada?';
	}
	if(numero == "114") {
		texto = 'Deseja realmente incluir estas Tarifas?';
	}
	if(numero == "115") {
		texto = 'Deseja realmente cancelar o cadastramento destas Tarifas?';
	}
	if(numero == "117") {
		texto = 'Deseja realmente incluir este Cedente com Pend�ncias?';
	}
	if(numero == "118") {
		texto = 'Deseja retornar ao cadastro para corrigir pend�ncias?';
	}
	if(numero == "124") {
		texto = 'Cedente inativo, deseja recuper�-lo? Para efetivar a Reativa��o desse Cedente\n � obrigat�rio clicar no bot�o Confirmar na Guia Conclus�o.';
	}
	if(numero == "126") {
		texto = 'Deseja realmente cancelar a altera��o deste Cedente?';
	}
	if(numero == "127") {
		texto = 'Deseja realmente alterar esta Guia?';
	}
	if(numero == "128") {
		texto = 'Os dados alterados ser�o descartados. Continuar?';
	}
	if(numero == "137") {
		texto = 'Este border� j� est� finalizado! Deseja realmente excluir este ' +nomeCampo+ '?';
	}
	if(numero == "138") {
		texto = 'Este border� j� est� finalizado! Deseja reabrir este Border�?';
	}
	if(numero == "139") {
		texto = 'Deseja realmente finalizar este Border�?';
	}
	if(numero == "140") {
		texto = 'Este border� j� foi finalizado. Para fazer a exclus�o de um t�tulo o border� dever� ser reaberto e finalizado novamente. Deseja reabrir o border� para excluir este T�tulo?';
	}
	if(numero == "141") {
		texto = 'Este border� n�o ser� finalizado. Deseja realmente voltar?';
	}
	if(numero == "142") {
		texto = 'Janela de Informe de Tarifas ser� fechada. Continuar?';
	}
	if(numero == "143") {
		texto = 'Deseja realmente incluir esta ' + nomeCampo + '?';
	}
	if(numero == "144") {
		texto = 'Deseja realmente alterar esta ' + nomeCampo + '?';
	}
	if(numero == "145") {
		texto = 'Deseja realmente excluir esta ' + nomeCampo + '?';
	}
	if(numero == "150") {
		texto = 'Deseja realmente atualizar este Endereco?';
	}
	if(numero == "151") {
		texto = 'Descartar contas rateio?';
	}
	if(numero == "155") {
		texto = 'Deseja realmente executar esta a��o?';
	}
	if(numero == "156") {
		texto = 'Deseja realmente executar esta a��o?\nA��o sujeita a cobran�a de tarifa.';
	}
	if(numero == "157") {
		texto = 'Deseja realmente executar esta a��o?\nJ� existe d�bito de custas para este t�tulo.';
	}
	if(numero == "158") {
		texto = 'Deseja realmente enviar o Cedente Eletr�nico de Teste para Produ��o?';
	}
	if(numero == "159") {
		texto = 'Deseja realmente vincular este(s) cedente(s) a este usuario internet?';
	}
	if(numero == "160") {
		texto = 'Deseja realmente alterar este Cedente com Pend�ncias?';
	}
	if(numero == "161") {
		texto = "Todas as altera��es efetuadas ser�o descartadas. Deseja realmente voltar?";
	}
	if(numero == "1271") {
		texto = 'Deseja realmente solicitar a Carga?';
	}

	return (texto);
}

// noAlert indica para nao fazer o alert da mensagem
// retorna o texto escolhido
function msg(numero, nomeCampo, valor1, valor2, noAlert, nomeCampo2) {
	var texto = null;

	if(numero == "001") {
		texto = 'Campo ' + nomeCampo + ' deve ser preenchido.';
	}
	if(numero == "002") {
		texto = 'A data final deve ser posterior a data inicial.';
	}
	if(numero == "003") {
		if (nomeCampo == "") {
			texto = '� obrigat�ria a sele��o de uma op��o.';
		} else {
			texto = '� obrigat�ria a sele��o de uma op��o de ' + nomeCampo + '.';
		}
	}
	if(numero == "004") {
		texto = 'Favor selecionar o crit�rio de consulta: ' + nomeCampo;
	}
	if(numero == "005") {
		texto = 'O campo ' + nomeCampo + ' deve estar entre ' + valor1 + ' e ' + valor2 + '.';
	}
	if(numero == "006") {
		texto = 'O campo ' + nomeCampo + ' deve ser maior que ' + valor1 + '.';
	}
	if(numero == "007") {
		texto = 'O campo ' + nomeCampo + ' deve ser menor que ' + valor1 + '.';
	}
	if(numero == "008") {
		texto = 'Digito Verificador de ' + nomeCampo + ' inv�lido.';
	}
	if(numero == "009") {
		texto = 'Para alterar um PV Cobrador a Situa��o deve ser Ativa.';
	}
	if(numero == "010") {
		texto = '� obrigat�rio o preenchimento do '+ nomeCampo + ' (Dias ou Data).';
	}
	if(numero == "011") {
		texto = 'Tamanho m�ximo de linhas permitido no campo ' + nomeCampo + ' : ' + valor1 + ' linhas.';
	}
	if(numero == "012") {
		texto = 'Tamanho m�ximo de caracteres permitido no campo ' + nomeCampo + ' : ' + valor1 + ' caracteres.';
	}
	if(numero == "013") {
		texto =  nomeCampo + ' est� duplicada.';
	}
	if(numero == "014") {
		texto =  "Data inv�lida no campo: " + nomeCampo + '.';
	}
	if(numero == "016") {
		texto =  "Este Border� n�o est� finalizado. Impress�o n�o permitida.";
	}
	if(numero == "017") {
		texto =  "Este Border� j� est� finalizado.";
	}
	if(numero == "018") {
		texto =  'Sess�o inv�lida. Ao clicar no bot�o OK a janela ser� fechada.';
	}
	if(numero == "019") {
		texto =  valor1 + ' Inclu�dos diferente do ' + valor2 + ' do Border�.';
	}
	if(numero == "020") {
		texto = 'Selecione a forma de aviso.';
	}
	if(numero == "021") {
		texto = 'Essa pend�ncia est� marcada como '+ valor1 + '. Somente ser� permitido\nresponder pendencias marcadas como "NAO LIBERADA".';
	}
	if(numero == "022") {
		texto = 'Essa pend�ncia est� marcada como '+ valor1 + '. Somente ser� permitido\nalterar a data de vig�ncia das pend�ncias marcadas como "LIBERADA".';
	}
	if(numero == "023") {
		texto = 'Essa pend�ncia est� marcada como '+ valor1 + '. Somente ser� permitido\nexcluir agendamento das pend�ncias marcadas como "AGENDADA".';
	}
	if(numero == "024") {
		texto = 'Nova data fim inv�lida. A data deve ser superior a data de in�cio e inferior a '+valor1+'.';
	}
	if(numero == "025") {
		texto = 'Nova data fim inv�lida. A data fim (nova) � igual a data de fim orginal.';
	}
	if(numero == "026") {
		texto = "Para excluir um PV Cobrador a Situa��o deve ser Ativa.";
	}
	if(numero == "027") {
		texto = "Extrato Mov. D�b./Cr�d. s� pode ser SIM se Extrato Mov. T�tulos for SIM.";
	}
	if(numero == "028") {
		texto = nomeCampo + " deve ser menor ou igual que a atual.";
	}
	if(numero == "029") {
		texto = nomeCampo + " n�o � uma data v�lida.";
	}
	if(numero == "030") {
		texto = "Esta Solicita��o de Bloqueto On-line j� foi processada.";
	}
	if(numero == "031") {
		texto = "Preencher somente o Prazo Protesto ou o Prazo Devolu��o";
	}
	if(numero == "032") {
		texto = "Inclus�o de novos T�tulos n�o permitida. \nT�tulos inclu�dos igual ao Total de T�tulos informado.";
	}
	if(numero == "033") {
		texto = 'O campo ' + nomeCampo + ' deve ser maior ou igual que ' + valor1 + '.';
	}
	if(numero == "034") {
		texto = 'O campo ' + nomeCampo + ' deve ser menor ou igual que ' + valor1 + '.';
	}
	if(numero == "035") {
		texto = 'Para alterar um PV Cobrador a Situa��o deve ser Ativa.';
	}
	if(numero == "036") {
		texto = nomeCampo + ' somente pode ser '	+ valor1  + '\nno mesmo dia da data de solicita��o.';
	}
	if(numero == "037") {
		texto = "Conta rateio duplicada.";
	}
	if(numero == "038") {
		texto = 'O campo ' + nomeCampo +  ' deve ser maior ou igual a ' + valor1 + '.';
	}
	if(numero == "039") {
		texto = 'Conta rateio j� definida como principal.';
	}
	if(numero == "040") {
		texto = 'O campo ' + nomeCampo +  ' deve ser menor ou igual a ' + valor1 + '.';
	}
	if(numero == "041") {
		texto = '� necess�rio a sele��o de pelo menos um '+ nomeCampo + '.';
	}
	if(numero == "042") {
		texto = 'T�tulo somente pode ser alterado se Situa��o = EM ABERTO.';
	}
	if(numero == "043") {
		texto = 'CPF/CNPJ do Sacado deve ser diferente do Sacador/Avalista.';
	}
	if(numero == "044") {
		texto = 'CPF/CNPJ do Sacado deve ser diferente do Cedente.';
	}
	if(numero == "045") {
		texto = 'CPF/CNPJ do Sacador/Avalista deve ser diferente do Cedente.';
	}
	if(numero == "046") {
		texto = nomeCampo + ' j� processado. Altera��o n�o permitida.';
	}
	if(numero == "047"){
		texto = "Dia de Vencimento deve ser posterior ao \nDia de Emiss�o mais 10 dias.";
	}
	if(numero == "048") {
		texto = "VAN de Teste deve ser diferente de VAN de Produ��o.";
	}
	if(numero == "049") {
		texto = "E-mail inv�lido.";
	}
	if(numero == "050") {
		texto = "Banco Correspondente n�o pode ser 104 - Caixa Econ�mica Federal";
	}
	if(numero == "051") {
		texto = "O Cedente Jun��o n�o pode ser ele mesmo.";
	}
	if(numero == "052") {
		texto = "Senha e sua confirma��o devem ser iguais.";
	}
	if(numero == "053") {
		texto = 'T�tulo somente pode ser alterado se Data Vencimento e\n Data Protesto/Devolu��o n�o estiverem vencidas.';
	}
	if(numero == "054") {
		texto = 'Novo Cliente Internet deve ser diferente do atual.';
	}
	if(numero == "055") {
		texto = 'Senha deve ter seis caracteres.';
	}
	if(numero == "056") {
		texto = 'Somente � poss�vel excluir um Arquivo Remessa no mesmo dia de recebimento.';
	}
	if(numero == "057") {
		texto = 'Somente � poss�vel cancelar a exclus�o um Arquivo Remessa no mesmo dia de recebimento.';
	}
	if(numero == "058") {
		texto = 'Selecione um Arquivo Remessa.';
	}
	if(numero == "059") {
		texto = 'Arquivo Remessa sem registro de erros.';
	}
	if(numero == "060") {
		texto = 'Relat�rio inconsistente. N�o � poss�vel efetuar esse relat�rio por Cedente.';
	}
	if(numero == "061") {
		texto = nomeCampo + ' j� processado. Exclus�o n�o permitida.';
	}
	if(numero == "062") {
		texto = 'Se o Tipo de Cobran�a for ' + valor1 + ' ,Cliente GiroCaixa n�o pode ser '+ valor2 + '.';
	}
	if(numero == "063") {
		texto = 'Soma dos Percentuais '+ valor1 +' deve ser menor que '+ valor2 +'.';
	}
	if(numero == "064") {
		texto = 'O campo '+nomeCampo+' n�o pode ser maior que '+ valor1 +'.\nFavor corrigir o valor informado no campo '+ valor2 +'.';
	}
	if(numero == "065") {
		texto = 'Quando selecionado ' + valor1 + ' no campo ' + nomeCampo+ ', \no campo ' + nomeCampo2 + ' deve ser diferente de ' + valor2 +'.';
	}
	if(numero == "066") {
		texto = 'Usu�rio n�o possui permiss�o para executar esta a��o.';
	}
	if(numero == "067") {
		texto = 'Para ' + valor1 + ' um Cedente o campo ' + nomeCampo+ ' deve ser diferente de '+valor2+'.';
	}

	if(numero == "068"){
		texto = 'Valor inv�lido de Tipo de Juros para a op��o de Tipo de Cobran�a.';
	}

	if(numero == "069"){
		texto = 'Valor inv�lido de Extrato Mov. T�tulos para a op��o de Tipo de Cobran�a.';
	}

	if(numero == "070"){
		texto = 'Valor inv�lido de Extrato Mov. D�b./Cr�d para a op��o de Tipo de Cobran�a.';
	}

	if(numero == "071"){
		texto = 'Perc. D�bito n�mero ' + valor1 + ' deve estar associado a um Perc. Cr�dito ou um Valor Cr�dito.';
	}

	if(numero == "072"){
		texto = 'Campo ' + nomeCampo + ' possui valor inv�lido.' ;
	}

	if(numero == "073"){
		//texto = 'CEP n�o encontrado. Informe um CEP v�lido para realizar altera��o.';
		texto = 'CEP n�o encontrado.';
	}

	if(numero == "074"){
		texto = 'Classifica��o inv�lida para a Situa��o do T�tulo.';
	}

	if (noAlert != true) {
		alert(texto);
	}

	return texto;
}