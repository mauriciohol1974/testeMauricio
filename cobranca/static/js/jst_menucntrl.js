/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2003
*Projeto CAIXA - SIGCB
*Componente: jst_fset.js - JavaScript
*Autor: Glauber M. Gallego - ggallego
*Adaptado de Joust Outliner + Hydroskript
*Ultima Atualização: 01/10/2004
************************************************/

if ((self.name != 'menuCntrl') & (self.location.protocol != "file:")) {
	self.location = "index.html";
}
if (parent.theBrowser) {
	if (parent.theBrowser.canOnError) {window.onerror = parent.defOnError;}
}

// function hides menu and dummy frame (ie)
var corpo_cols = "190,6,*";
var menustatus = "show";
function hidemenu() {
	corpo_cols = top.corpo.cols;
	top.corpo.cols = "0,0,*";
	menustatus = "hide";
	top.frames.title.treeImage.style.display = "block";
	top.frames.title.borderdummy.style.display = "none";
	top.frames.title.ttdummylinks.style.display = "block";
}
function showmenu() {
	top.corpo.cols = corpo_cols;
	menustatus = "show";
	top.frames.title.treeImage.style.display = "none";
	top.frames.title.borderdummy.style.display = "block";
	top.frames.title.ttdummylinks.style.display = "none";
}
