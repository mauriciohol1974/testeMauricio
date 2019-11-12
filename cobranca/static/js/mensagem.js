/**********************************************************
	método utilizado para padronização de mensagems do sistema
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
		texto = "Este cedente ficará pendente de conclusão. Deseja realmente voltar?";
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
		texto = 'Deseja realmente estornar esta Liquidação Rejeitada?';
	}
	if(numero == "109") {
		texto = 'Esta Liquidação encontra-se ' + nomeCampo + '. Deseja realmente cancelar essa Ação?';
	}
	if(numero == "110") {
		texto = 'Deseja realmente executar o Recomando desta Liquidação Rejeitada?';
	}
	if(numero == "111") {
		texto = 'Deseja realmente executar o Recomando Especial desta Liquidação Rejeitada?';
	}
	if(numero == "114") {
		texto = 'Deseja realmente incluir estas Tarifas?';
	}
	if(numero == "115") {
		texto = 'Deseja realmente cancelar o cadastramento destas Tarifas?';
	}
	if(numero == "117") {
		texto = 'Deseja realmente incluir este Cedente com Pendências?';
	}
	if(numero == "118") {
		texto = 'Deseja retornar ao cadastro para corrigir pendências?';
	}
	if(numero == "124") {
		texto = 'Cedente inativo, deseja recuperá-lo? Para efetivar a Reativação desse Cedente\n é obrigatório clicar no botão Confirmar na Guia Conclusão.';
	}
	if(numero == "126") {
		texto = 'Deseja realmente cancelar a alteração deste Cedente?';
	}
	if(numero == "127") {
		texto = 'Deseja realmente alterar esta Guia?';
	}
	if(numero == "128") {
		texto = 'Os dados alterados serão descartados. Continuar?';
	}
	if(numero == "137") {
		texto = 'Este borderô já está finalizado! Deseja realmente excluir este ' +nomeCampo+ '?';
	}
	if(numero == "138") {
		texto = 'Este borderô já está finalizado! Deseja reabrir este Borderô?';
	}
	if(numero == "139") {
		texto = 'Deseja realmente finalizar este Borderô?';
	}
	if(numero == "140") {
		texto = 'Este borderô já foi finalizado. Para fazer a exclusão de um título o borderô deverá ser reaberto e finalizado novamente. Deseja reabrir o borderô para excluir este Título?';
	}
	if(numero == "141") {
		texto = 'Este borderô não será finalizado. Deseja realmente voltar?';
	}
	if(numero == "142") {
		texto = 'Janela de Informe de Tarifas será fechada. Continuar?';
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
		texto = 'Deseja realmente executar esta ação?';
	}
	if(numero == "156") {
		texto = 'Deseja realmente executar esta ação?\nAção sujeita a cobrança de tarifa.';
	}
	if(numero == "157") {
		texto = 'Deseja realmente executar esta ação?\nJá existe débito de custas para este título.';
	}
	if(numero == "158") {
		texto = 'Deseja realmente enviar o Cedente Eletrônico de Teste para Produção?';
	}
	if(numero == "159") {
		texto = 'Deseja realmente vincular este(s) cedente(s) a este usuario internet?';
	}
	if(numero == "160") {
		texto = 'Deseja realmente alterar este Cedente com Pendências?';
	}
	if(numero == "161") {
		texto = "Todas as alterações efetuadas serão descartadas. Deseja realmente voltar?";
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
			texto = 'É obrigatória a seleção de uma opção.';
		} else {
			texto = 'É obrigatória a seleção de uma opção de ' + nomeCampo + '.';
		}
	}
	if(numero == "004") {
		texto = 'Favor selecionar o critério de consulta: ' + nomeCampo;
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
		texto = 'Digito Verificador de ' + nomeCampo + ' inválido.';
	}
	if(numero == "009") {
		texto = 'Para alterar um PV Cobrador a Situação deve ser Ativa.';
	}
	if(numero == "010") {
		texto = 'É obrigatório o preenchimento do '+ nomeCampo + ' (Dias ou Data).';
	}
	if(numero == "011") {
		texto = 'Tamanho máximo de linhas permitido no campo ' + nomeCampo + ' : ' + valor1 + ' linhas.';
	}
	if(numero == "012") {
		texto = 'Tamanho máximo de caracteres permitido no campo ' + nomeCampo + ' : ' + valor1 + ' caracteres.';
	}
	if(numero == "013") {
		texto =  nomeCampo + ' está duplicada.';
	}
	if(numero == "014") {
		texto =  "Data inválida no campo: " + nomeCampo + '.';
	}
	if(numero == "016") {
		texto =  "Este Borderô não está finalizado. Impressão não permitida.";
	}
	if(numero == "017") {
		texto =  "Este Borderô já está finalizado.";
	}
	if(numero == "018") {
		texto =  'Sessão inválida. Ao clicar no botão OK a janela será fechada.';
	}
	if(numero == "019") {
		texto =  valor1 + ' Incluídos diferente do ' + valor2 + ' do Borderô.';
	}
	if(numero == "020") {
		texto = 'Selecione a forma de aviso.';
	}
	if(numero == "021") {
		texto = 'Essa pendência está marcada como '+ valor1 + '. Somente será permitido\nresponder pendencias marcadas como "NAO LIBERADA".';
	}
	if(numero == "022") {
		texto = 'Essa pendência está marcada como '+ valor1 + '. Somente será permitido\nalterar a data de vigência das pendências marcadas como "LIBERADA".';
	}
	if(numero == "023") {
		texto = 'Essa pendência está marcada como '+ valor1 + '. Somente será permitido\nexcluir agendamento das pendências marcadas como "AGENDADA".';
	}
	if(numero == "024") {
		texto = 'Nova data fim inválida. A data deve ser superior a data de início e inferior a '+valor1+'.';
	}
	if(numero == "025") {
		texto = 'Nova data fim inválida. A data fim (nova) é igual a data de fim orginal.';
	}
	if(numero == "026") {
		texto = "Para excluir um PV Cobrador a Situação deve ser Ativa.";
	}
	if(numero == "027") {
		texto = "Extrato Mov. Déb./Créd. só pode ser SIM se Extrato Mov. Títulos for SIM.";
	}
	if(numero == "028") {
		texto = nomeCampo + " deve ser menor ou igual que a atual.";
	}
	if(numero == "029") {
		texto = nomeCampo + " não é uma data válida.";
	}
	if(numero == "030") {
		texto = "Esta Solicitação de Bloqueto On-line já foi processada.";
	}
	if(numero == "031") {
		texto = "Preencher somente o Prazo Protesto ou o Prazo Devolução";
	}
	if(numero == "032") {
		texto = "Inclusão de novos Títulos não permitida. \nTítulos incluídos igual ao Total de Títulos informado.";
	}
	if(numero == "033") {
		texto = 'O campo ' + nomeCampo + ' deve ser maior ou igual que ' + valor1 + '.';
	}
	if(numero == "034") {
		texto = 'O campo ' + nomeCampo + ' deve ser menor ou igual que ' + valor1 + '.';
	}
	if(numero == "035") {
		texto = 'Para alterar um PV Cobrador a Situação deve ser Ativa.';
	}
	if(numero == "036") {
		texto = nomeCampo + ' somente pode ser '	+ valor1  + '\nno mesmo dia da data de solicitação.';
	}
	if(numero == "037") {
		texto = "Conta rateio duplicada.";
	}
	if(numero == "038") {
		texto = 'O campo ' + nomeCampo +  ' deve ser maior ou igual a ' + valor1 + '.';
	}
	if(numero == "039") {
		texto = 'Conta rateio já definida como principal.';
	}
	if(numero == "040") {
		texto = 'O campo ' + nomeCampo +  ' deve ser menor ou igual a ' + valor1 + '.';
	}
	if(numero == "041") {
		texto = 'É necessário a seleção de pelo menos um '+ nomeCampo + '.';
	}
	if(numero == "042") {
		texto = 'Título somente pode ser alterado se Situação = EM ABERTO.';
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
		texto = nomeCampo + ' já processado. Alteração não permitida.';
	}
	if(numero == "047"){
		texto = "Dia de Vencimento deve ser posterior ao \nDia de Emissão mais 10 dias.";
	}
	if(numero == "048") {
		texto = "VAN de Teste deve ser diferente de VAN de Produção.";
	}
	if(numero == "049") {
		texto = "E-mail inválido.";
	}
	if(numero == "050") {
		texto = "Banco Correspondente não pode ser 104 - Caixa Econômica Federal";
	}
	if(numero == "051") {
		texto = "O Cedente Junção não pode ser ele mesmo.";
	}
	if(numero == "052") {
		texto = "Senha e sua confirmação devem ser iguais.";
	}
	if(numero == "053") {
		texto = 'Título somente pode ser alterado se Data Vencimento e\n Data Protesto/Devolução não estiverem vencidas.';
	}
	if(numero == "054") {
		texto = 'Novo Cliente Internet deve ser diferente do atual.';
	}
	if(numero == "055") {
		texto = 'Senha deve ter seis caracteres.';
	}
	if(numero == "056") {
		texto = 'Somente é possível excluir um Arquivo Remessa no mesmo dia de recebimento.';
	}
	if(numero == "057") {
		texto = 'Somente é possível cancelar a exclusão um Arquivo Remessa no mesmo dia de recebimento.';
	}
	if(numero == "058") {
		texto = 'Selecione um Arquivo Remessa.';
	}
	if(numero == "059") {
		texto = 'Arquivo Remessa sem registro de erros.';
	}
	if(numero == "060") {
		texto = 'Relatório inconsistente. Não é possível efetuar esse relatório por Cedente.';
	}
	if(numero == "061") {
		texto = nomeCampo + ' já processado. Exclusão não permitida.';
	}
	if(numero == "062") {
		texto = 'Se o Tipo de Cobrança for ' + valor1 + ' ,Cliente GiroCaixa não pode ser '+ valor2 + '.';
	}
	if(numero == "063") {
		texto = 'Soma dos Percentuais '+ valor1 +' deve ser menor que '+ valor2 +'.';
	}
	if(numero == "064") {
		texto = 'O campo '+nomeCampo+' não pode ser maior que '+ valor1 +'.\nFavor corrigir o valor informado no campo '+ valor2 +'.';
	}
	if(numero == "065") {
		texto = 'Quando selecionado ' + valor1 + ' no campo ' + nomeCampo+ ', \no campo ' + nomeCampo2 + ' deve ser diferente de ' + valor2 +'.';
	}
	if(numero == "066") {
		texto = 'Usuário não possui permissão para executar esta ação.';
	}
	if(numero == "067") {
		texto = 'Para ' + valor1 + ' um Cedente o campo ' + nomeCampo+ ' deve ser diferente de '+valor2+'.';
	}

	if(numero == "068"){
		texto = 'Valor inválido de Tipo de Juros para a opção de Tipo de Cobrança.';
	}

	if(numero == "069"){
		texto = 'Valor inválido de Extrato Mov. Títulos para a opção de Tipo de Cobrança.';
	}

	if(numero == "070"){
		texto = 'Valor inválido de Extrato Mov. Déb./Créd para a opção de Tipo de Cobrança.';
	}

	if(numero == "071"){
		texto = 'Perc. Débito número ' + valor1 + ' deve estar associado a um Perc. Crédito ou um Valor Crédito.';
	}

	if(numero == "072"){
		texto = 'Campo ' + nomeCampo + ' possui valor inválido.' ;
	}

	if(numero == "073"){
		//texto = 'CEP não encontrado. Informe um CEP válido para realizar alteração.';
		texto = 'CEP não encontrado.';
	}

	if(numero == "074"){
		texto = 'Classificação inválida para a Situação do Título.';
	}

	if (noAlert != true) {
		alert(texto);
	}

	return texto;
}