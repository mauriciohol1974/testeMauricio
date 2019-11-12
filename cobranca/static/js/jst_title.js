/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2003
*Projeto CAIXA - SIGCB
*Componente: jst_fset.js - JavaScript
*Autor: Glauber M. Gallego - ggallego
*Adaptado de Joust Outliner + Hydroskript
*Ultima Atualização: 01/10/2004
************************************************/

if (self.name != 'title')
	self.location = 'index.html';

// Trava o Menu enquanto carrega o serviço
function closeMn() {
	parent.theMenu.closeAll();
	parent.theMenu.selectEntry(-1);
}

// Mostra e Esconde o NavigationDial
function showNavigationDial() {
	if(document.getElementById)
		document.getElementById("navigationDial").style.display = "block";
}
function hideNavigationDial() {
	if(document.getElementById)
		document.getElementById("navigationDial").style.display = "none";
}

// Funcoes de Navegacao do NavigationDial
function goNextItem() {
	if (parent.theMenu) {
		theMenu = parent.theMenu;

		//var eID = parent.theMenu.findEntry(parent.frames.text.location.pathname, "url", "right");
		var pathName = replaceAll(parent.frames.text.location.pathname, "\\", "/");
		var iPathName = pathName.lastIndexOf("/");
		var eID = 0;
		
    if(iPathName != - 1) {
    	eID = parent.theMenu.findEntry(pathName.substring(iPathName), "url", "contains",0);
    }
		
		eID = eID + 1;

		while (eID <= theMenu.count) {
			if (parent.theMenu.entry[eID].url != "") {
				parent.frames.text.location.href = parent.theMenu.entry[eID].url;
				return;
			}
			eID = eID + 1;
		}
		closeMn();
		parent.frames.text.location.href = "../saibamais/init/home.html";
		parent.frames.text.focus();
		//hideNavigationDial();
	}
}
function goPrevItem() {
	if (parent.theMenu) {
		
		//var eID = parent.theMenu.findEntry(parent.frames.text.location.pathname, "url", "right");
		var pathName = replaceAll(parent.frames.text.location.pathname, "\\", "/");
		var iPathName = pathName.lastIndexOf("/");
		var eID = 0;
		
    if(iPathName != - 1) {
    	eID = parent.theMenu.findEntry(pathName.substring(iPathName), "url", "contains",0);
    }
		
		eID = eID - 1;

		while (eID >= 0) {
			if (parent.theMenu.entry[eID].url != "") {
				parent.frames.text.location.href = parent.theMenu.entry[eID].url;
				return;
			}
			eID = eID - 1;
		}
		closeMn();
		parent.frames.text.location.href = "../saibamais/init/home.html";
		parent.frames.text.focus();
		//hideNavigationDial();
	}
}
function goParentItem() {
	if (parent.theMenu) {

		//var eID = parent.theMenu.findEntry(parent.frames.text.location.pathname, "url", "right");
		var pathName = replaceAll(parent.frames.text.location.pathname, "\\", "/");
		var iPathName = pathName.lastIndexOf("/");
		var eID = 0;
		
    if(iPathName != - 1) {
    	eID = parent.theMenu.findEntry(pathName.substring(iPathName), "url", "contains",0);
    }

		if (eID >= 0) {
			eID = parent.theMenu.entry[eID].parent;

			while (eID >= 0) {
				if (parent.theMenu.entry[eID].url != "") {
					parent.frames.text.location.href = parent.theMenu.entry[eID].url;
					return;
				}
				eID = parent.theMenu.entry[eID].parent;
			}
		}
		closeMn();
		parent.frames.text.location.href = "../saibamais/init/home.html";
		parent.frames.text.focus();
		//hideNavigationDial();
	}
}

function goItemTop() {
}

function replaceAll(pVar, pVar1, pVar2)
{
   if(pVar.indexOf(pVar1) != - 1) pVar = replaceAll(pVar.replace(pVar1, pVar2), pVar1, pVar2);
   return pVar;
}
