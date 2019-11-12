/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2003
*Projeto CAIXA - SIGCB
*Componente: jst_fset.js - JavaScript
*Autor: Glauber M. Gallego - ggallego
*Autor: Michel Duarte dos Santos - mdsantos
*Adaptado de Joust Outliner + Hydroskript
*Ultima Atualização: 30/11/2004
************************************************/

theBrowser.platform = "hydro";

function initOutlineIcons(imgStore) {
	var dir_imgmnu = '../imagens/saibamais/joust/';
	
	var ip = dir_imgmnu;
	ip += (theBrowser.platform == 'Mac') ? 'mac/' : ((theBrowser.platform == 'OS/2') ? 'os2/' : ((theBrowser.platform == 'Win') ? 'win/' : 'hydro/'));
	
	imgStore.add('iconPlusTop', ip + 'plustop.gif', 18, 16);
	imgStore.add('iconPlus', ip + 'plus.gif', 18, 16);
	imgStore.add('iconPlusBottom', ip + 'plusbottom.gif', 18, 16);
	imgStore.add('iconPlusOnly', ip + 'plusonly.gif', 18, 16);
	imgStore.add('iconMinusTop', ip + 'minustop.gif', 18, 16);
	imgStore.add('iconMinus', ip + 'minus.gif', 18, 16);
	imgStore.add('iconMinusBottom', ip + 'minusbottom.gif', 18, 16);
	imgStore.add('iconMinusOnly', ip + 'minusonly.gif', 18, 16);
	imgStore.add('iconLine', ip + 'line.gif', 18, 16);
	imgStore.add('iconBlank', ip + 'blank.gif', 18, 16);
	imgStore.add('iconJoinTop', ip + 'jointop.gif', 18, 16);
	imgStore.add('iconJoin', ip + 'join.gif', 18, 16);
	imgStore.add('iconJoinBottom', ip + 'joinbottom.gif', 18, 16);
	imgStore.add('iconLong', ip + 'longline4.gif', 17, 128);

	//Add folder images to the imgStore.
	imgStore.add('Folder', ip + 'folderclosed.gif', 18, 15);
	imgStore.add('FolderExpanded', ip + 'folderopen.gif', 18, 15);
	
	dir_imgmnu += '/document/';
	//Add document images to the imgStore. 
	var di = dir_imgmnu;
	if ((theBrowser.code == 'NS') || (theBrowser.code == 'MSIE')) {
		di += theBrowser.code.toLowerCase() + '_doc';
		imgStore.add('WebPage', di + '.gif', 18, 16);
		imgStore.add('WebPageMouseOver', di + '_mo.gif', 18, 16);
		imgStore.add('WebPageSelected', di + '_sel.gif', 18, 16);
	} else {
		imgStore.add('WebPage', di + 'doc.gif', 18, 16);
	}

	imgStore.add('Espiral', dir_imgmnu + 'espiral.gif', 17, 15);
	imgStore.add('EspiralMouseOver', dir_imgmnu + 'espiral_mo.gif', 17, 15);
	imgStore.add('EspiralSelected', dir_imgmnu + 'espiral_sel.gif', 17, 15);

	imgStore.add('Mundo', dir_imgmnu + 'mundo.gif', 17, 15);
	imgStore.add('MundoMouseOver', dir_imgmnu + 'mundo_mo.gif', 17, 15);
	imgStore.add('MundoSelected', dir_imgmnu + 'mundo_sel.gif', 17, 15);

	imgStore.add('Ideia', dir_imgmnu + 'ideia.gif', 17, 15);
	imgStore.add('IdeiaMouseOver', dir_imgmnu + 'ideia_mo.gif', 17, 15);
	imgStore.add('IdeiaSelected', dir_imgmnu + 'ideia_sel.gif', 17, 15);

	imgStore.add('Literatura', dir_imgmnu + 'liter.gif', 17, 15);
	imgStore.add('LiteraturaMouseOver', dir_imgmnu + 'liter_mo.gif', 17, 15);
	imgStore.add('LiteraturaSelected', dir_imgmnu + 'liter_sel.gif', 17, 15);

	imgStore.add('Exercicio', dir_imgmnu + 'exerc.gif', 18, 16);
	imgStore.add('ExercicioMouseOver', dir_imgmnu + 'exerc_mo.gif', 18, 16);
	imgStore.add('ExercicioSelected', dir_imgmnu + 'exerc_sel.gif', 18, 16);

	imgStore.add('Link', dir_imgmnu + 'link.gif', 18, 16);
	imgStore.add('LinkMouseOver', dir_imgmnu + 'link_mo.gif', 18, 16);
	imgStore.add('LinkSelected', dir_imgmnu + 'link_sel.gif', 18, 16);

	imgStore.add('Configuracao', dir_imgmnu + 'config.gif', 18, 16);
	imgStore.add('ConfiguracaoMouseOver', dir_imgmnu + 'config_mo.gif', 18, 16);
	imgStore.add('ConfiguracaoSelected', dir_imgmnu + 'config_sel.gif', 18, 16);

	imgStore.add('Carta', dir_imgmnu + 'carta.gif', 18, 16);
	imgStore.add('CartaMouseOver', dir_imgmnu + 'carta_mo.gif', 18, 16);
	imgStore.add('CartaSelected', dir_imgmnu + 'carta_sel.gif', 18, 16);

	imgStore.add('Close', dir_imgmnu + 'close.gif', 18, 16);
	imgStore.add('CloseMouseOver', dir_imgmnu + 'close_mo.gif', 18, 16);
	imgStore.add('CloseSelected', dir_imgmnu + 'close_sel.gif', 18, 16);

	//Add MyComputer image to imgStore
	//imgStore.add('MyComputerRoot', dir_imgmnu + 'mycomputerroot.gif', 18, 16);
}
function initialise() {
	// Tell joust where to find the various index files it needs
	index1 = 'index.html';
	index2 = 'index2.html';
	index3 = 'index3.html';
	
	// Set up parameters to control menu behaviour
	theMenu.autoScrolling = true;	
	theMenu.modalFolders = true;
	theMenu.linkOnExpand = false;
	theMenu.toggleOnLink = false;
	theMenu.showAllAsLinks = false;
	theMenu.savePage = true;
	theMenu.tipText = "status";
	theMenu.selectParents = false;
	theMenu.name = "theMenu";
	theMenu.container = "self.menu";
	theMenu.reverseRef = "parent";
	theMenu.contentFrame = "text";
	theMenu.defaultTarget = "text";
	
	// Initialise all the icons
	initOutlineIcons(theMenu.imgStore);
	
	// Now set up the menu with a whole lot of addEntry and addChild function calls
	var level1ID = -1;
	var level2ID = -1;
	var level3ID = -1;
	var level4ID = -1;
	var level5ID = -1;
	
	//level1ID = theMenu.addEntry(level1ID, "Folder", "", "", "Bem vindo a Glauber M. Gallego HP");
	//theMenu.entry[level1ID].isopen = true;
	//theMenu.entry[level1ID].noOutlineImg = true;
	//theMenu.entry[level1ID].type = "MyComputerRoot";
	
	level2ID = theMenu.addChild(level1ID, "Ideia",				"Início",							"../saibamais/init/home.html", "Página Inicial do Saiba Mais");
	level2ID = theMenu.addChild(level1ID, "Exercicio",		"Este Manual",				"../saibamais/init/manual.html", "Informações úteis sobre o uso deste manual");
	
	// Informacoes Gerais
	level2ID = theMenu.addChild(level1ID, "Folder", 			"Introdução",					"", "Informações Gerais");
	level3ID = theMenu.addChild(level2ID, "Link",					"Objetivos",					"../saibamais/introducao/objetivos.html", "Objetivos do Sistema");
	level3ID = theMenu.addChild(level2ID, "Configuracao",	"Usuário Gestor",			"../saibamais/introducao/gestor.html", "Usuário Gestor");
	level3ID = theMenu.addChild(level2ID, "Espiral",			"Interfaces",					"../saibamais/introducao/interfaces.html", "Interfaces do Sistema");
	level3ID = theMenu.addChild(level2ID, "Configuracao",	"Público Sistema", 		"../saibamais/introducao/publicosistema.html", "Público Alvo do Sistema");
	level3ID = theMenu.addChild(level2ID, "Configuracao",	"Público do Manual",  "../saibamais/introducao/publicomanual.html", "Público Alvo do Manual");

	// Padrões do Sistema
	level2ID = theMenu.addChild(level1ID, "Folder", 			"Padrões do Sistema",	"", "Padrões do Sistema");
	level3ID = theMenu.addChild(level2ID, "WebPage",			"Navegação",					"../saibamais/padrao/navegacao.html", "Padrões de Navegação");
	level3ID = theMenu.addChild(level2ID, "WebPage",			"Mensagens",					"../saibamais/padrao/mensagens.html", "Mensagens do Sistema");
	level3ID = theMenu.addChild(level2ID, "WebPage",			"Erros",							"../saibamais/padrao/erros.html", "Tratamento de Erros");
	level3ID = theMenu.addChild(level2ID, "WebPage",			"Login",							"../saibamais/padrao/login.html", "Identificação do Usuário");
	level3ID = theMenu.addChild(level2ID, "WebPage",			"Menu",								"../saibamais/padrao/menu.html", "Acesso ao Menu Principal do Sistema");
	level3ID = theMenu.addChild(level2ID, "WebPage", 			"SaibaMais",					"../saibamais/padrao/saibamais.html", "Manual do Usuário on-line");
	level3ID = theMenu.addChild(level2ID, "WebPage", 			"Sair",								"../saibamais/padrao/sair.html", "Processo de saída do Sistema");

	// Telas do Sistema
	
	// ***************************************** Menu Cedentes
	level2ID = theMenu.addChild(level1ID, "Folder", 			"Menu Cedentes",			"", "Menu Cedentes");

		// Cadastro
	level3ID = theMenu.addChild(level2ID, "Folder", 			"Cadastro",						"", "Cadastro");

	level4ID = theMenu.addChild(level3ID, "Folder", 			"Incluir",						"", "Incluir Cedente");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/cedente/cedente_incluir_filtro.html", "Incluir Cedente - Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Incluir",						"../saibamais/cedente/cedente_incluir_principal.html", "Incluir Cedente - Principal");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Geral",							"../saibamais/cedente/cedente_incluir_guiageral.html", "Guia Geral");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Float",							"../saibamais/cedente/cedente_incluir_guiafloat.html", "Guia Float");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Contas",							"../saibamais/cedente/cedente_incluir_guiacontas.html", "Guia Contas Déb. Créd. Rateio");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Cedente Eletronico",	"../saibamais/cedente/cedente_incluir_guiaeletron.html", "Guia Cedente Eletrônico");	
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Bloquetos",					"../saibamais/cedente/cedente_incluir_guiabloq.html", "Guia Bloquetos");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Mensagens",					"../saibamais/cedente/cedente_incluir_guiamsgbloq.html", "Guia Mensagens para Bloquetos");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Tarifa",							"../saibamais/cedente/cedente_incluir_guiatarifa.html", "Guia Tarifa");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Conclusão",					"../saibamais/cedente/cedente_incluir_guiaconc.html", "Guia Tarifa");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Itens Excepcionados","../saibamais/cedente/cedente_incluir_pendencias.html", "Itens Excepcionados");

	level4ID = theMenu.addChild(level3ID, "Folder", 			"Manter",							"", "Manter Cedente");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/cedente/cedente_manter_filtro.html", "Manter Cedente - Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Listar EN",					"../saibamais/cedente/cedente_manter_listar_uniden.html", "Manter Cedente - Listar EN");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Listar PV",					"../saibamais/cedente/cedente_manter_listar_unidpv.html", "Manter Cedente - Listar PV");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Listar CPF/CNPJ",		"../saibamais/cedente/cedente_manter_listar_cpfcnpj.html", "Manter Cedente - Listar CPF/CNPJ");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Ações",							"../saibamais/cedente/cedente_acao.html", "Manter Cedente - Ações");
		
	level5ID = theMenu.addChild(level4ID, "Folder",				"Alterar",						"", "Manter Cedente - Alterar");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Alterar",						"../saibamais/cedente/cedente_alterar_principal.html", "Alterar - Principal");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Geral",							"../saibamais/cedente/cedente_alterar_guiageral.html", "Guia Geral");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Float",							"../saibamais/cedente/cedente_alterar_guiafloat.html", "Guia Float");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Contas",							"../saibamais/cedente/cedente_alterar_guiacontas.html", "Guia Contas Déb. Créd. Rateio");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Cedente Eletronico",	"../saibamais/cedente/cedente_alterar_guiaeletron.html", "Guia Cedente Eletrônico");	
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Bloquetos",					"../saibamais/cedente/cedente_alterar_guiabloq.html", "Guia Bloquetos");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Mensagens",					"../saibamais/cedente/cedente_alterar_guiamsgbloq.html", "Guia Mensagens para Bloquetos");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Tarifa",							"../saibamais/cedente/cedente_alterar_guiatarifa.html", "Guia Tarifa");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Conclusão",					"../saibamais/cedente/cedente_alterar_guiaconc.html", "Guia Tarifa");	
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Excepcionações",			"../saibamais/cedente/cedente_alterar_excepanterior.html", "Excepcionação Vigente");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Itens Excepcionados","../saibamais/cedente/cedente_alterar_pendencias.html", "Itens Excepcionados");
	
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Consultar",					"../saibamais/cedente/cedente_consultar_principal.html", "Consultar");
	
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Sucesso",						"../saibamais/cedente/cedente_sucesso.html", "Cedente - Sucesso");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Erro",								"../saibamais/cedente/cedente_erro.html", "Cedente - Erro");
	
		// Excepcionacao
	level3ID = theMenu.addChild(level2ID, "Folder", 			"Excepcionação",			"", "Excepcionação");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Filtro",							"../saibamais/cedente/excepci_manter_filtro.html", "Filtro");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Listar EN",					"../saibamais/cedente/excepci_manter_listar_uniden.html", "Listar EN");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Listar PV",					"../saibamais/cedente/excepci_manter_listar_unidpv.html", "Listar PV");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Listar CPF/CNPJ",		"../saibamais/cedente/excepci_manter_listar_cpfcnpj.html", "Listar CPF/CNPJ");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Listar Cedente",			"../saibamais/cedente/excepci_manter_listar_cedente.html", "Listar Cedente");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Responder",					"../saibamais/cedente/excepci_acao_responder.html", "Responder Pendência");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Alterar Data",				"../saibamais/cedente/excepci_acao_alterar_data.html", "Alterar Data Vigência");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Consultar",					"../saibamais/cedente/excepci_consultar.html", "Consulta Detalhada");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Sucesso",						"../saibamais/cedente/excepci_sucesso.html", "Sucesso");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Erro",								"../saibamais/cedente/excepci_erro.html", "Erro");

		// Cliente Internet
	level3ID = theMenu.addChild(level2ID, "Folder", 			"Cliente Internet",		"", "Cliente Internet");
		
				// Usuario / Relacionamento
	level4ID = theMenu.addChild(level3ID, "Folder",				"Usuário",  					"", "Usuário/Relacionamento");
	
	level5ID = theMenu.addChild(level4ID, "Folder",				"Incluir",  					"", "Incluir Cliente Internet");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Filtro",							"../saibamais/cedente/cliinte_incluir_filtro.html", "Filtro");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Incluir",						"../saibamais/cedente/cliinte_incluir.html", "Incluir");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Listar CPF/CNPJ",		"../saibamais/cedente/cliinte_incluir_listar_cpfcnpj.html", "Listar CPF/CNPJ");
	
	level5ID = theMenu.addChild(level4ID, "Folder",				"Manter",							"", "Manter Cliente Internet");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Filtro",							"../saibamais/cedente/cliinte_manter_filtro.html", "Filtro");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Listar CPF/CNPJ",		"../saibamais/cedente/cliinte_manter_listar_cpfcnpj.html", "Listar CPF/CNPJ");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Listar CPF Usuário",	"../saibamais/cedente/cliinte_manter_listar_cpfusu.html", "Listar CPF Usuário");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Listar Cedente",			"../saibamais/cedente/cliinte_manter_listar_ced.html", "Listar Cedente");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Alterar Usuário",		"../saibamais/cedente/cliinte_alterar.html", "Alterar Usuário");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Alterar Incluir",		"../saibamais/cedente/cliinte_altinc.html", "Alterar Incluir Novo Usuário");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Alterar Senha",			"../saibamais/cedente/cliinte_alterar_senha.html", "Alterar Senha");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Alterar Relacion.",	"../saibamais/cedente/cliinte_alterar_relacionamento.html", "Alterar Relacionamento");
		
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Sucesso - Incluir",	"../saibamais/cedente/cliinte_sucesso_rs.html", "Sucesso - Incluir");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Sucesso - Manter",		"../saibamais/cedente/cliinte_sucesso.html", "Sucesso - Manter");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Erro - Incluir",			"../saibamais/cedente/cliinte_erro_rs.html", "Erro - Incluir");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Erro - Manter",			"../saibamais/cedente/cliinte_erro.html", "Erro - Manter");
			
				// Perfil Internet
	level4ID = theMenu.addChild(level3ID, "Folder",				"Perfil Internet",		"", "Perfil Internet");

	level5ID = theMenu.addChild(level4ID, "Folder", 			"Incluir",						"", "Incluir Perfil Internet");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Filtro",							"../saibamais/cedente/perinte_incluir_filtro.html", "Filtro");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Incluir",						"../saibamais/cedente/perinte_incluir.html", "Incluir");
	
	level5ID = theMenu.addChild(level4ID, "Folder", 			"Manter",							"", "Manter Perfil Internet");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Listar",							"../saibamais/cedente/perinte_manter_listar.html", "Listar");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Alterar",						"../saibamais/cedente/perinte_alterar.html", "Alterar");
		
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Sucesso",						"../saibamais/cedente/perinte_sucesso.html", "Sucesso");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Erro",								"../saibamais/cedente/perinte_erro.html", "Erro");
	
	// ***************************************** Menu Servicos
	level2ID = theMenu.addChild(level1ID, "Folder", 			"Menu Servicos",			"", "Menu Serviços");

		// Arquivo Remessa/Retorno
	level3ID = theMenu.addChild(level2ID, "Folder", 			"Arquivo Rem./Ret.",	"", "Arquivo Remessa/Retorno");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Filtro",							"../saibamais/servico/arqreme_manter_filtro.html", "Filtro");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Listar",							"../saibamais/servico/arqreme_manter_listar.html", "Listar");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Listar Cedente",			"../saibamais/servico/arqreme_manter_listar_cedente.html", "Listar Cedente");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Consultar",					"../saibamais/servico/arqreme_consultar.html", "Consultar");	
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Sucesso",						"../saibamais/servico/arqreme_sucesso.html", "Sucesso");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Erro",								"../saibamais/servico/arqreme_erro.html", "Erro");
		
		// Banco de Sacados
	level3ID = theMenu.addChild(level2ID, "Folder", 			"Banco de Sacados",		"", "Banco de Sacados");

	level4ID = theMenu.addChild(level3ID, "Folder", 			"Incluir Banco",			"", "Incluir Banco de Sacados");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/servico/bcosaca_incluir_filtro.html", "Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Incluir",						"../saibamais/servico/bcosaca_incluir.html", "Incluir");

	level4ID = theMenu.addChild(level3ID, "Folder", 			"Manter Banco",				"", "Manter Banco de Sacados");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/servico/bcosaca_manter_filtro.html", "Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Listar",							"../saibamais/servico/bcosaca_manter_listar.html", "Listar");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Alterar",						"../saibamais/servico/bcosaca_alterar.html", "Alterar");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Consultar",					"../saibamais/servico/bcosaca_consultar.html", "Consultar");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Sucesso",						"../saibamais/servico/bcosaca_sucesso.html", "Sucesso");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Erro",								"../saibamais/servico/bcosaca_erro.html", "Erro");

	level4ID = theMenu.addChild(level3ID, "Folder", 			"Incluir Sacado",			"", "Incluir Sacado");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/servico/sacado_incluir_filtro.html", "Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Incluir",						"../saibamais/servico/sacado_incluir.html", "Incluir");

	level4ID = theMenu.addChild(level3ID, "Folder", 			"Manter Sacado",			"", "Manter Sacado");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/servico/sacado_manter_filtro.html", "Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Listar Banco",				"../saibamais/servico/sacado_manter_listar_bcosac.html", "Listar Banco");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Listar",							"../saibamais/servico/sacado_manter_listar_sacado.html", "Listar");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Alterar",						"../saibamais/servico/sacado_alterar.html", "Alterar");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Consultar",					"../saibamais/servico/sacado_consultar.html", "Consultar");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Sucesso",						"../saibamais/servico/sacado_sucesso.html", "Sucesso");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Erro",								"../saibamais/servico/sacado_erro.html", "Erro");

	level4ID = theMenu.addChild(level3ID, "Folder", 			"Incluir Sol./Agen.",	"", "Incluir Solicitação/Agendamento de Títulos");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/servico/soagtit_incluir_filtro.html", "Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Incluir",						"../saibamais/servico/soagtit_incluir.html", "Incluir");

	level4ID = theMenu.addChild(level3ID, "Folder", 			"Manter Sol./Agen.",	"", "Manter Solicitação/Agendamento de Títulos");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/servico/soagtit_manter_filtro.html", "Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Listar Banco",				"../saibamais/servico/soagtit_manter_listar_bcosac.html", "Listar Banco");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Listar",							"../saibamais/servico/soagtit_manter_listar.html", "Listar");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Alterar",						"../saibamais/servico/soagtit_alterar.html", "Alterar");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Consultar",					"../saibamais/servico/soagtit_consultar.html", "Consultar");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Sucesso",						"../saibamais/servico/soagtit_sucesso.html", "Sucesso");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Erro",								"../saibamais/servico/soagtit_erro.html", "Erro");

		// Banco de Titulos
	level3ID = theMenu.addChild(level2ID, "Folder", 			"Banco de Títulos",		"", "Banco de Títulos");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Filtro",							"../saibamais/servico/bcotitu_manter_filtro.html", "Filtro");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Listar",							"../saibamais/servico/bcotitu_manter_listar_titulo.html", "Listar");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Listar Consolidado",	"../saibamais/servico/bcotitu_manter_listar_consol.html", "Listar Consolidado");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Ações",							"../saibamais/servico/bcotitu_acao.html", "Ações");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Imp. Bloqueto",			"../saibamais/servico/bcotitu_acao_impbloqueto.html", "Imprimir Bloqueto");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Imp. Ordem Prot.",		"../saibamais/servico/bcotitu_acao_impordemprot.html", "Imprimir Ordem de Protesto");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Alterar",						"../saibamais/servico/bcotitu_alterar.html", "Alterar");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Consultar",					"../saibamais/servico/bcotitu_consultar.html", "Consultar");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Sucesso",						"../saibamais/servico/bcotitu_sucesso.html", "Sucesso");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Erro",								"../saibamais/servico/bcotitu_erro.html", "Erro");
	
		// Bloquetos On-Line
	level3ID = theMenu.addChild(level2ID, "Folder", 			"Bloquetos On-Line",	"", "Bloquetos On-Line");
	
			// Incluir Solicitação
	level4ID = theMenu.addChild(level3ID, "Folder",				"Incluir",						"", "Incluir Solicitação");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/servico/bloquet_incluir_filtro.html", "Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Incluir",						"../saibamais/servico/bloquet_incluir.html", "Incluir");
	
			// Manter Solicitação
	level4ID = theMenu.addChild(level3ID, "Folder",				"Manter",							"", "Manter Solicitação");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/servico/bloquet_manter_filtro.html", "Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Listar",							"../saibamais/servico/bloquet_manter_listar.html", "Listar");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Alterar",						"../saibamais/servico/bloquet_alterar.html", "Alterar");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Consultar",					"../saibamais/servico/bloquet_consultar.html", "Consultar");
	
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Sucesso",						"../saibamais/servico/bloquet_sucesso.html", "Sucesso");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Erro",								"../saibamais/servico/bloquet_erro.html", "Erro");
	
		// Borderô On-Line
	level3ID = theMenu.addChild(level2ID, "Folder", 			"Borderô On-Line",	"", "Borderô On-Line");
	
			// Incluir Borderô
	level4ID = theMenu.addChild(level3ID, "Folder",				"Incluir",						"", "Incluir Borderô");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/servico/bordero_incluir_filtro.html", "Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Incluir",						"../saibamais/servico/bordero_incluir.html", "Incluir");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Título Incluir",			"../saibamais/servico/titulo_incluir.html", "Título Incluir");
	
			// Manter Borderô
	level4ID = theMenu.addChild(level3ID, "Folder",				"Manter",							"", "Manter Borderô");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/servico/bordero_manter_filtro.html", "Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Listar",							"../saibamais/servico/bordero_manter_listar.html", "Listar");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Alterar",						"../saibamais/servico/bordero_alterar.html", "Alterar");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Consultar",					"../saibamais/servico/bordero_consultar.html", "Consultar");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Imp. Borderô",				"../saibamais/servico/bordero_acao_impbordero.html", "Imprimir Borderô");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Título Listar",			"../saibamais/servico/titulo_manter_listar.html", "Título Listar");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Título Alterar",			"../saibamais/servico/titulo_alterar.html", "Título Alterar");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Título Consult.",		"../saibamais/servico/titulo_consultar.html", "Título Consultar");
	
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Borderô Sucesso",		"../saibamais/servico/bordero_sucesso.html", "Sucesso");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Borderô Erro",				"../saibamais/servico/bordero_erro.html", "Erro");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Título Sucesso",			"../saibamais/servico/titulo_sucesso.html", "Sucesso");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Título Erro",				"../saibamais/servico/titulo_erro.html", "Erro");
	
		// Liquidações Rejeitadas
	level3ID = theMenu.addChild(level2ID, "Folder", 			"Liquid. Rejeitadas",	"", "Liquidações Rejeitadas");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Filtro",							"../saibamais/servico/liqreje_manter_filtro.html", "Filtro");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Listar",							"../saibamais/servico/liqreje_manter_listar.html", "Listar");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Recomando",					"../saibamais/servico/liqreje_acao_recomando.html", "Recomando");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Recom. Especial",		"../saibamais/servico/liqreje_acao_rec_altvalor.html", "Recomando Especial");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Consultar",					"../saibamais/servico/liqreje_consultar.html", "Consultar");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Sucesso",						"../saibamais/servico/liqreje_sucesso.html", "Sucesso");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Erro",								"../saibamais/servico/liqreje_erro.html", "Erro");
	
		// Protesto
	level3ID = theMenu.addChild(level2ID, "Folder", 			"Protesto",						"", "Protesto");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Filtro",							"../saibamais/servico/protest_acao_filtro.html", "Filtro");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Ação",								"../saibamais/servico/protest_acao.html", "Ação");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Sucesso",						"../saibamais/servico/protest_sucesso.html", "Sucesso");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Erro",								"../saibamais/servico/protest_erro.html", "Erro");
	
		// Segunda Via de Extrato
	level3ID = theMenu.addChild(level2ID, "Folder", 			"2ª Via de Extrato",	"", "2ª Via de Extrato");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Filtro",							"../saibamais/servico/solextr_manter_filtro.html", "Filtro");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Incluir",						"../saibamais/servico/solextr_incluir.html", "Incluir");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Consultar",					"../saibamais/servico/solextr_consultar.html", "Consultar");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Alterar",						"../saibamais/servico/solextr_alterar.html", "Alterar");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Sucesso",						"../saibamais/servico/solextr_sucesso.html", "Sucesso");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Erro",								"../saibamais/servico/solextr_erro.html", "Erro");
	
		// Tarifa Manual
	level3ID = theMenu.addChild(level2ID, "Folder", 			"Tarifa Manual",			"", "Tarifa Manual");
	
			// Incluir Tarifa
	level4ID = theMenu.addChild(level3ID, "Folder",				"Incluir",						"", "Lançamento de Tarifa Manual (Incluir)");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/servico/tarifa_incluir_filtro.html", "Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Incluir",						"../saibamais/servico/tarifa_incluir.html", "Incluir");
	
			// Manter Tarifa
	level4ID = theMenu.addChild(level3ID, "Folder",				"Manter",							"", "Lançamento de Tarifa Manual (Manter)");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/servico/tarifa_manter_filtro.html", "Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Listar",							"../saibamais/servico/tarifa_manter_listar.html", "Listar");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Consultar",					"../saibamais/servico/tarifa_consultar.html", "Consultar");
	
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Sucesso",						"../saibamais/servico/tarifa_sucesso.html", "Sucesso");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Erro",								"../saibamais/servico/tarifa_erro.html", "Erro");
	
	//*****************************************Menu Consultas
	level2ID = theMenu.addChild(level1ID, "Folder", 			"Menu Consultas",			"", "Menu Consultas");
	
		// Consultas Gerais
	level3ID = theMenu.addChild(level2ID, "Folder", 			"Consultas Gerais",		"", "Consulas Gerais");
	
			// Cedente Centralizador
	level4ID = theMenu.addChild(level3ID, "Folder",				"Cedente Centraliz.",	"", "Cedente Centralizador");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/consulta/cedcent_manter_filtro.html", "Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Consultar",					"../saibamais/consulta/cedcent_consultar.html", "Consultar");
	
			// Cedentes com Banco de Sacados
	level4ID = theMenu.addChild(level3ID, "Folder",				"Ced. c/ Bco. Sac.",	"", "Cedentes com Banco de Sacados");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/consulta/cedbcos_manter_filtro.html", "Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Listar",							"../saibamais/consulta/cedbcos_manter_listar.html", "Listar");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Consultar",					"../saibamais/consulta/cedbcos_consultar.html", "Consultar");
	
			// GiroCaixa Instantâneo
	level4ID = theMenu.addChild(level3ID, "Folder",				"GiroCaixa",					"", "Giro Caixa Instantâneo");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/consulta/girocai_manter_filtro.html", "Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Listar CNPJ",				"../saibamais/consulta/girocai_manter_listar_cpfcnpj.html", "Listar CPF/CNPJ");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Listar EN",					"../saibamais/consulta/girocai_manter_listar_uniden.html", "Listar EN");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Listar PV",					"../saibamais/consulta/girocai_manter_listar_unidpv.html", "Listar PV");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Consultar",					"../saibamais/consulta/girocai_consultar.html", "Consultar");
	
			// Histórico Cedente
	level4ID = theMenu.addChild(level3ID, "Folder",				"Hist. Cedente",			"", "Histórico Cedente");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/consulta/hisced_manter_filtro.html", "Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Listar",							"../saibamais/consulta/hisced_manter_listar.html", "Listar");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Consultar",					"../saibamais/consulta/hisced_consultar.html", "Consultar");
	
			// Lançamento de Tarifa
	level4ID = theMenu.addChild(level3ID, "Folder",				"Lançam. Tarifas",		"", "Lançamento de Tarifas");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/consulta/lantari_manter_filtro.html", "Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Listar",							"../saibamais/consulta/lantari_manter_listar.html", "Listar");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Consultar",					"../saibamais/consulta/lantari_consultar.html", "Consultar");
	
			// Movimento de Cobrança
	level4ID = theMenu.addChild(level3ID, "Folder",				"Mov. Cobrança",			"", "Movimento de Cobrança");
	
				// Cedentes por Rentabilidade
	level5ID = theMenu.addChild(level4ID, "Folder",				"Ced. por Rentab.",		"", "Cedentes por Rentabilidade");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Filtro",							"../saibamais/consulta/mcrenta_manter_filtro.html", "Filtro");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Consultar",					"../saibamais/consulta/mcrenta_consultar.html", "Consultar");
	
				// Movimento do Cedente (Extrato)
	level5ID = theMenu.addChild(level4ID, "Folder",				"Mov. Ced.(Extrato)",	"", "Movimento do Cedente (Extrato)");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Filtro",							"../saibamais/consulta/mcextra_manter_filtro.html", "Filtro");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Consultar",					"../saibamais/consulta/mcextra_consultar.html", "Consultar");
	
				// Movimento do Cedente (Totais)
	level5ID = theMenu.addChild(level4ID, "Folder",				"Mov. Ced.(Totais)",	"", "Movimento do Cedente (Totais)");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Filtro",							"../saibamais/consulta/mctotai_manter_filtro.html", "Filtro");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Consultar",					"../saibamais/consulta/mctotai_consultar.html", "Consultar");
	
				// Rentabilidade do Cedente 
	level5ID = theMenu.addChild(level4ID, "Folder",				"Rentab. Ced.",				"", "Rentabilidade do Cedente");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Filtro",							"../saibamais/consulta/mcrence_manter_filtro.html", "Filtro");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Consultar",					"../saibamais/consulta/mcrence_consultar.html", "Consultar");
	
			// Protesto de Títulos 
	level4ID = theMenu.addChild(level3ID, "Folder",				"Protesto Títulos",		"", "Protesto de Títulos");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/consulta/protest_manter_filtro.html", "Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Consultar",					"../saibamais/consulta/protest_consultar.html", "Consultar");
	
			// Saldo de Cobrança 
	level4ID = theMenu.addChild(level3ID, "Folder",				"Saldo de Cobrança",	"", "Saldo de Cobrança");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/consulta/salcob_manter_filtro.html", "Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Consultar",					"../saibamais/consulta/salcob_consultar.html", "Consultar");
	
			// Serviços Solicitados
	level4ID = theMenu.addChild(level3ID, "Folder",				"Serv. Solicitados",	"", "Serviços Solicitados");
	
				// Solicitações no Dia
	level5ID = theMenu.addChild(level4ID, "Folder",				"Solicitações Dia",		"", "Solicitações no Dia");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Filtro",							"../saibamais/consulta/servdia_manter_filtro.html", "Filtro");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Listar Agnd.",				"../saibamais/consulta/servdia_manter_listar_ageemi.html", "Listar Agendamento Emissão Tít. para Bco de Sacados");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Cons. Agnd.",				"../saibamais/consulta/servdia_consultar_ageemi.html", "Consultar Agendamento Emissão Tít. para Bco de Sacados");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Cons. Bloq.",				"../saibamais/consulta/servdia_consultar_blopreimp.html", "Consultar Bloqueto Pré-Impresso");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Listar Emis.",				"../saibamais/consulta/servdia_manter_listar_emitit.html", "Listar Emissão de Títulos para Banco de Sacados");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Cons. Emis.",				"../saibamais/consulta/servdia_consultar_emitit.html", "Consultar Emissão de Títulos para Banco de Sacados");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Cons. Mov.",					"../saibamais/consulta/servdia_consultar_extmovtit.html", "Consultar Extrato de Movimentação de Títulos");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Cons. Dist.",				"../saibamais/consulta/servdia_consultar_extdiscrdb.html", "Consultar Extrato Distribuição de Creditos e Debitos");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Cons. Tarifa",				"../saibamais/consulta/servdia_consultar_lantarman.html", "Consultar Lançamento de Tarifa Manual");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Cons. Reinc.",				"../saibamais/consulta/servdia_consultar_reititbai.html", "Consultar Reinclusão de Títulos Baixados ou Liquidados");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Cons. Redisp.",			"../saibamais/consulta/servdia_consultar_redarqret.html", "Consultar Redisponibilização de Arquivo Retorno");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Cons. Reem.",				"../saibamais/consulta/servdia_consultar_reeblo.html", "Consultar Reemissão de Bloquetos");
	
				// Solicitações Processadas
	level5ID = theMenu.addChild(level4ID, "Folder",				"Solic. Proces.",			"", "Solicitações Processadas");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Filtro",							"../saibamais/consulta/servpro_manter_filtro.html", "Filtro");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Listar PV",					"../saibamais/consulta/servpro_manter_listar_pvvinc.html", "Filtro");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Listar Agnd.",				"../saibamais/consulta/servpro_manter_listar_ageemi.html", "Listar Agendamento Emissão Tít. para Bco de Sacados");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Cons. Agnd.",				"../saibamais/consulta/servpro_consultar_ageemi.html", "Consultar Agendamento Emissão Tít. para Bco de Sacados");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Cons. Bloq.",				"../saibamais/consulta/servpro_consultar_blopreimp.html", "Consultar Bloqueto Pré-Impresso");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Listar Emis.",				"../saibamais/consulta/servpro_manter_listar_emitit.html", "Listar Emissão de Títulos para Banco de Sacados");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Cons. Emis.",				"../saibamais/consulta/servpro_consultar_emitit.html", "Consultar Emissão de Títulos para Banco de Sacados");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Cons. Mov.",					"../saibamais/consulta/servpro_consultar_extmovtit.html", "Consultar Extrato de Movimentação de Títulos");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Cons. Dist.",				"../saibamais/consulta/servpro_consultar_extdiscrdb.html", "Consultar Extrato Distribuição de Creditos e Debitos");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Cons. Tarifa",				"../saibamais/consulta/servpro_consultar_lantarman.html", "Consultar Lançamento de Tarifa Manual");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Cons. Recup.",				"../saibamais/consulta/servpro_consultar_reititbai.html", "Consultar Recuperação Títulos Baixados ou Liquidados");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Cons. Redisp.",			"../saibamais/consulta/servpro_consultar_redarqret.html", "Consultar Redisponibilização de Arquivo Retorno");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Cons. Reem.",				"../saibamais/consulta/servpro_consultar_reeblo.html", "Consultar Reemissão de Bloquetos");
	
				// Solicitações Rejeitadas
	level5ID = theMenu.addChild(level4ID, "Folder",				"Solic. Rejeit.",			"", "Solicitações Rejeitadas");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Filtro",							"../saibamais/consulta/servrej_manter_filtro.html", "Filtro");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Listar PV",							"../saibamais/consulta/servrej_manter_listar_pvvinc.html", "Listar PV");
	level6ID = theMenu.addChild(level5ID, "WebPage",			"Consultar",					"../saibamais/consulta/servrej_consultar.html", "Consultar");
	
			// Tarifas por Float e EN 
	level4ID = theMenu.addChild(level3ID, "Folder",				"Tarifa Float e EN",	"", "Tarifa por Float e EN");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/consulta/tarflen_manter_filtro.html", "Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Consultar",					"../saibamais/consulta/tarflen_consultar.html", "Consultar");
	
			// Títulos Alterados 
	level4ID = theMenu.addChild(level3ID, "Folder",				"Títulos Alterados",	"", "Títulos Alterados");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/consulta/titalte_manter_filtro.html", "Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Consultar",					"../saibamais/consulta/titalte_consultar.html", "Consultar");
	
			// Títulos Liquidados 
	level4ID = theMenu.addChild(level3ID, "Folder",				"Títulos Liquidados",	"", "Títulos Liquidados");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/consulta/titliq_manter_filtro.html", "Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Listar Cedente",			"../saibamais/consulta/titliq_manter_listar_cedente.html", "Listar Cedente");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Listar Unidade",			"../saibamais/consulta/titliq_manter_listar_unidpv.html", "Listar Unidade");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Consultar",					"../saibamais/consulta/titliq_consultar.html", "Consultar");
	
			// Títulos Liquidados no Dia
	level4ID = theMenu.addChild(level3ID, "Folder",				"Títulos Liquid. Dia","", "Títulos Liquidados no Dia");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/consulta/titliqd_manter_filtro.html", "Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Listar Cedente",			"../saibamais/consulta/titliqd_manter_listar_unidpv.html", "Listar Cedente");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Consultar",					"../saibamais/consulta/titliqd_manter_listar_cedente.html", "Consultar");
	
			// Valores a Serem Lançados 
	level4ID = theMenu.addChild(level3ID, "Folder",				"Val. serem Lanç.",		"", "Valores a Serem Lançados");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/consulta/vallanc_manter_filtro.html", "Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Listar",							"../saibamais/consulta/vallanc_manter_listar.html", "Listar");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Consultar",					"../saibamais/consulta/vallanc_consultar.html", "Consultar");
	
		// Consultas Gerenciais 
	level3ID = theMenu.addChild(level2ID, "Folder",				"Consultas Gerenciais","", "Consultas Gerenciais");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Filtro",							"../saibamais/consulta/gerenc_manter_filtro.html", "Filtro");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Listar",							"../saibamais/consulta/gerenc_manter_listar.html", "Listar");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Bloq. Laser Caixa",	"../saibamais/consulta/gerenc_consultar_blolascai.html", "Bloquetos Laser padrão Caixa");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Bloq. Pré-Impr.",		"../saibamais/consulta/gerenc_consultar_blopreimp.html", "Bloquetos Pré-Impressos");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Carnê Laser Caixa",	"../saibamais/consulta/gerenc_consultar_blocarlascai.html", "Carnês Laser padrão Caixa");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Bloq. Personaliz.",	"../saibamais/consulta/gerenc_consultar_blopers.html", "Bloquetos Personalizados");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Ced. CNAB 240/400",	"../saibamais/consulta/gerenc_consultar_cedpadcna.html", "Cedentes padrões CNAB 240 e 400");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Ced. Meio Entr.",		"../saibamais/consulta/gerenc_consultar_cedmeient.html", "Cedentes por Meio Entrada");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Ced. Situação",			"../saibamais/consulta/gerenc_consultar_cedsitmov.html", "Cedentes por Situação Teste/Produção e Movimento");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Ced. Mov. Tipo Van",	"../saibamais/consulta/gerenc_consultar_cedmovtipvan.html", "Movimento por tipo de Van");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Pos. PV/EN Receb.",	"../saibamais/consulta/gerenc_consultar_prcposunirec.html", "Posição por PV/EN Recebedor");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Pos. PV/EN Vinc.",		"../saibamais/consulta/gerenc_consultar_prcposunivin.html", "Posição por PV/EN Vinculação");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Mov. Títulos",				"../saibamais/consulta/gerenc_consultar_qtmovtit.html", "Movimentação de Títulos");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Mov. Tít/Tar/Float",	"../saibamais/consulta/gerenc_consultar_qtmovtittar.html", "Movimentação de Títulos/Tarifas/Float");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Pos. Tit. por Serv.","../saibamais/consulta/gerenc_consultar_qtpostitcar.html", "Posição de Títulos em Carteira por Serviço");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Títulos Incluídos",	"../saibamais/consulta/gerenc_consultar_qttitinc.html", "Títulos Incluídos");
	level4ID = theMenu.addChild(level3ID, "WebPage",		 "Tít. Incl. - Detalhe","../saibamais/consulta/gerenc_consultar_qttitinc_det.html", "Títulos Incluídos - Detalhes");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Tít. Inc./Liq.",			"../saibamais/consulta/gerenc_consultar_qttitincliq.html", "Títulos Incluídos/Liquidados por Tipo de Cobrança");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Tít. Float = 0",			"../saibamais/consulta/gerenc_consultar_qttitflozer.html", "Títulos Liquidados com Float = 0");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Tít. Liq. Serv.",		"../saibamais/consulta/gerenc_consultar_qttitliqser.html", "Títulos Liquidados por Serviços/Meio de Liquidação");
	level4ID = theMenu.addChild(level3ID, "WebPage",		 "Em. Pos. Bloq./Extr.","../saibamais/consulta/gerenc_consultar_taremipos.html", "Emissão e Postagem de Bloquetos/Extratos");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Liq. Serv./Meio",		"../saibamais/consulta/gerenc_consultar_tarliqser.html", "Liquidação por Serviços/Meio Liquidação");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Protesto de Títulos","../saibamais/consulta/gerenc_consultar_tarprotit.html", "Protesto de Títulos");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Serviços Diversos",	"../saibamais/consulta/gerenc_consultar_tarserdiv.html", "Serviços Diversos");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Total de Tarifas",		"../saibamais/consulta/gerenc_consultar_tartottar.html", "Total de Tarifas");
	
		// Consultas Contábeis
	level3ID = theMenu.addChild(level2ID, "Folder",				"Consultas Contábeis","", "Consultas Contábeis");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Filtro",							"../saibamais/consulta/contab_manter_filtro.html", "Filtro");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Saldo Operacional",	"../saibamais/consulta/contab_consultar_opera.html", "Saldo Opreacional");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Saldos Contábeis",		"../saibamais/consulta/contab_consultar_saldo.html", "Saldos Contábeis");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Posições Contábeis",	"../saibamais/consulta/contab_consultar_posic.html", "Posições Contábeis");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Erro",								"../saibamais/consulta/contab_erro.html", "Erro");
	
	// Parametros
	level2ID = theMenu.addChild(level1ID, "Folder", 			"Menu Parâmetros",		"", "Menu Parâmetros");	

		// Agrupamento de Serviços
	level3ID = theMenu.addChild(level2ID, "Folder", 			"Agrupamento",				"", "Agrupamento de Serviços");

	level4ID = theMenu.addChild(level3ID, "Folder",				"Incluir",						"", "Incluir Agrupamento de Serviços");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/parametro/agrup_incluir_filtro.html", "Incluir Agrupamento de Serviços - Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Incluir",						"../saibamais/parametro/agrup_incluir.html", "Incluir Agrupamento de Serviços - Incluir");

	level4ID = theMenu.addChild(level3ID, "Folder",				"Manter",							"", "Manter Agrupamento de Serviços");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/parametro/agrup_manter_filtro.html", "Manter Agrupamento de Serviços - Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Listar",							"../saibamais/parametro/agrup_manter_listar.html", "Manter Agrupamento de Serviços - Listar");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Alterar",						"../saibamais/parametro/agrup_alterar.html", "Manter Agrupamento de Serviços - Alterar");

	level4ID = theMenu.addChild(level3ID, "WebPage",			"Sucesso",						"../saibamais/parametro/agrup_sucesso.html", "Agrupamento de Serviços - Sucesso");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Erro",								"../saibamais/parametro/agrup_erro.html", "Agrupamento de Serviços - Erro");
		
		// PV Cobrador
	level3ID = theMenu.addChild(level2ID, "Folder", 			"PV Cobrador",				"", "PV Cobrador");

	level4ID = theMenu.addChild(level3ID, "Folder",				"Incluir",						"", "Incluir PV Cobrador");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/parametro/pvcob_incluir_filtro.html", "Incluir PV Cobrador - Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Incluir",						"../saibamais/parametro/pvcob_incluir.html", "Incluir PV Cobrador");

	level4ID = theMenu.addChild(level3ID, "Folder",				"Manter",							"", "Manter Agrupamento de Serviços");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Filtro",							"../saibamais/parametro/pvcob_manter_filtro.html", "Manter PV Cobrador - Filtro");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Listar PV",					"../saibamais/parametro/pvcob_manter_listar.html", "Manter PV Cobrador - Listar PV");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Listar CEP",					"../saibamais/parametro/pvcob_manter_listar_cep.html", "Manter PV Cobrador - Listar CEP");
	level5ID = theMenu.addChild(level4ID, "WebPage",			"Alterar",						"../saibamais/parametro/pvcob_alterar.html", "Manter PV Cobrador - Alterar");

	level4ID = theMenu.addChild(level3ID, "WebPage",			"Sucesso",						"../saibamais/parametro/pvcob_sucesso.html", "PV Cobrador - Sucesso");
	level4ID = theMenu.addChild(level3ID, "WebPage",			"Erro",								"../saibamais/parametro/pvcob_erro.html", "PV Cobrador - Erro");
	// Sair
	level2ID = theMenu.addChild(level1ID, "Close", 				"Sair do SaibaMais",	"javascript:confirm('Deseja realmente sair do Saiba Mais?')?parent.close():void(0)", "Fecha a Tela de SaibaMais");
}

self.defaultStatus = "";	
