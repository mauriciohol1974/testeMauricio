/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Dezembro de 2003
*Projeto CAIXA - SIGCB
*Componente: gcb_fset.js - JavaScript
*Autor: Glauber M. Gallego - ggallego
*Ultima Atualização: 06/12/2004
************************************************/

	self.document.writeln('<frameset id="sigcbParent" border="0" rows="40,30,*" frameborder="0">');
	self.document.writeln('  <frame name="bannerCAIXA" scrolling="no" noresize marginwidth="4" src="/cobrancastatic/barra.htm"/>');
	self.document.writeln('  <frame name="barraSistema" scrolling="no" noresize marginwidth="4" unselectable="on" src="/cobranca/sigcb_barra_superior.jsp"/>');
	self.document.writeln('  <frame name="areaTrabalho'+numeroAleatorio()+'" "scrolling="yes" noresize src="/cobranca/protegida.jsp"/>');
	self.document.writeln('  <noframes>');
	self.document.writeln('    <body topmargin="0" leftmargin="0" marginheigth="0" marginwidth="0">');
	self.document.writeln('      Seu browser não permite frames.');
	self.document.writeln('      É necessário um browser com frames para visualizar este site.');
	self.document.writeln('    </body>');
	self.document.writeln('  </noframes>');
	self.document.writeln('</frameset>');

	function numeroAleatorio(){
		var retorno;
		retorno = Math.floor(Math.random() * (100000000000 + 1));
		return retorno;
	}
