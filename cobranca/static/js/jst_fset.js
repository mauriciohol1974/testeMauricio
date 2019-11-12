/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2003
*Projeto CAIXA - SIGCB
*Componente: jst_fset.js - JavaScript
*Autor: Glauber M. Gallego - ggallego
*Adaptado de Joust Outliner + Hydroskript
*Ultima Atualização: 01/10/2004
************************************************/

if (self.name == 'menu') {
	// Sometimes, Netscape will try to load this index inside the menu frame.  I haven't
	// worked out why but this will detect that situation and reset the location property.
	self.location.href = "menu.html";
} else {
	initialise();
	var thePage = pageFromSearch('../saibamais/init/home.html', theMenu, true);
	
	if (floatingMode) 
	{
		self.document.writeln('<frameset cols="100%" rows="*,48" onUnload="unloadFloating();" onResize="defaultResizeHandler();">');
		self.document.writeln('<frame name="menu" src="menu.html" scrolling="auto" marginwidth="1" marginheight="1" APPLICATION="yes">');
		self.document.writeln('<frame name="menuCntrl" src="menucntrl.html" scrolling="no" marginwidth="0" marginheight="0" APPLICATION="yes">');
		self.document.writeln('</frameset>');
	}
	 else 
	 {
		self.document.writeln('<frameset cols="100%" rows="36,*" frameborder="0" framespacing="0" border="0">');
			self.document.writeln('<frame name="title" src="title.html" scrolling="no" marginwidth="0" marginheight="0" noresize title="titleframe" >');
			self.document.writeln('<frameset id="corpo" cols="190,6,*" rows="100%" border="1" frameborder="0">');
				self.document.writeln('<frameset cols="100%" rows="14,*" border="0" frameborder="0">');
					self.document.writeln('<frame name="menuCntrl" src="menucntrl.html" scrolling="no" marginwidth="0" marginheight="0" noresize title="menucontrolframe" >');
					self.document.writeln('<frame name="menu" src="menu.html" scrolling="auto" marginwidth="0" marginheight="0" noresize title="menuframe" >');
				self.document.writeln('</frameset>');
				self.document.writeln('<frame name="dummy" src="dummy.html" scrolling="no" marginwidth="0" marginheight="0" noresize title="dummyframe">');
				self.document.writeln('<frame name="text" src="' + thePage +'" scrolling="auto" title="textframe">');
			self.document.writeln('</frameset>');
		self.document.writeln('</frameset>');		
	}
}
