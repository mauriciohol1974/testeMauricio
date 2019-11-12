/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2003
*Projeto CAIXA - SIGCB
*Componente: jst_fset.js - JavaScript
*Autor: Glauber M. Gallego - ggallego
*Adaptado de Joust Outliner + Hydroskript
*Ultima Atualização: 01/10/2004
************************************************/

function buildRobotshtm() {
	var e = null;
	theMenu = parent.theMenu;
	
	var theWin = window.open("", "Robots", "toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,width=600,height=400");
	theWin.focus();
		
	var d = theWin.document;
	d.open();
	d.writeln('<HTML><HEAD><TITLE>robots.htm</TITLE></HEAD><BODY>\n');
	d.writeln('Copia e cole os links a seguir no arquivo robots.html\n');
	d.writeln('<PRE STYLE="background=#FFFFCC; font-family:"Courier New","Courier",monospace; font-size:8pt;">\n');
	

	d.writeln('&lt;!-- Links para ferramentas de busca seguirem... --&gt;');

	var oktolist = true;
	for (var i = 0; i <= theMenu.count; i++) {
		e = theMenu.entry[i];
		if (e) {
			if (e.url != '') {
				oktolist = true;
				for (var j  = 0; j < i; j++) {
					if (theMenu.entry[j].url == e.url) {
						oktolist = false;
						break;
					}
				}
				if (oktolist) {	
					d.writeln('&lt;A HREF="' + e.url + '"&gt;' + e.text + '&lt;/A&gt;');
				}
			}
		}
	}

	d.writeln('</PRE>\n</BODY>\n</HTML>');
}