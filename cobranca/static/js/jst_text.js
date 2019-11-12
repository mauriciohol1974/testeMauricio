/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2003
*Projeto CAIXA - SIGCB
*Componente: jst_fset.js - JavaScript
*Autor: Glauber M. Gallego - ggallego
*Adaptado de Joust Outliner + Hydroskript
*Ultima Atualização: 01/10/2004
************************************************/

if ((self != top) && (parent.theMenu)) {

	//var eID = parent.theMenu.findEntry(parent.frames.text.location.pathname, "url", "right");
	var pathName = parent.frames.title.replaceAll(parent.frames.text.location.pathname, "\\", "/");
	var iPathName = pathName.lastIndexOf("/");
	var eID = 0;
	
  if(iPathName != - 1) {
		eID = parent.theMenu.findEntry(pathName.substring(iPathName), "url", "contains",0);
  }

	if (eID >= 0) {
		parent.theMenu.selectEntry(eID);
		if (parent.theMenu.setEntry(eID, true)) {
			parent.theMenu.refresh();
		}
	}
} else {
	var navPrinting = false;
	if ((navigator.appName + navigator.appVersion.substring(0, 1)) == "Netscape4") {
		navPrinting = (self.innerHeight == 0) && (self.innerWidth == 0);}
	if ((self.name != 'text') && (self.location.protocol != "file:") && (document.cookie.indexOf('mode=NoFrames') < 0) && !navPrinting) {
		var newLoc = "../../jst_menu/index.html?page=" + escape(self.location.pathname);
		if (parseInt(navigator.appVersion) >= 3) {self.location.replace(newLoc);} else {self.location.href = newLoc;}
	}
}
if (eID >= 0) {	setTimeout("top.frames.title.showNavigationDial()",300); }
