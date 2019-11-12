/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2003
*Projeto CAIXA - SIGCB
*Componente: jst_fset.js - JavaScript
*Autor: Glauber M. Gallego - ggallego
*Adaptado de Joust Outliner + Hydroskript
*Ultima Atualização: 01/10/2004
************************************************/

/*
Joust Outliner Version 2.5.4
(c) Copyright 1996-2001, MITEM (Europe) Ltd. All rights reserved.
This code may be freely copied and distributed provided that it is accompanied by this 
header.  For full details of the Joust license, as well as documentation and help, go 
to http://www.ivanpeters.com/.

Do not modify anything between here and the "End of Joust" marker unless you know what you
are doing.  
*/

var theMenuRef = "parent.theMenu";
var theMenu = eval(theMenuRef);
var theBrowser = parent.theBrowser;
var belowMenu = null;
var menuStart = 0;

if (parent.theBrowser) {
	if (parent.theBrowser.canOnError) {window.onerror = parent.defOnError;}
}

if (theMenu) {
	theMenu.amBusy = true;
	if (theBrowser.hasDHTML) {
		if (document.all) {
			with (document.styleSheets["JoustStyles"]) {
				addRule ("#menuTop", "position:absolute");
				addRule ("#menuBottom", "position:absolute");
				addRule ("#menuBottom", "visibility:hidden");
				addRule ("#statusMsgDiv", "position:absolute");
			}
		} else {
			if (document.layers) {
				document.ids.menuTop.position = "absolute";
				document.ids.menuBottom.position = "absolute";
				document.ids.menuBottom.visibility = "hidden";
				document.ids.statusMsgDiv.position = "absolute";
			} else {
				if (theBrowser.hasW3CDOM) {
					var styleSheetElement = document.styleSheets[0];
    				var styleSheetLength = styleSheetElement.cssRules.length;
					styleSheetElement.insertRule("#menuTop { position:absolute } ", styleSheetLength++);
					styleSheetElement.insertRule("#menuBottom { position:absolute } ", styleSheetLength++);
					styleSheetElement.insertRule("#menuBottom { visibility:hidden } ", styleSheetLength++);
					styleSheetElement.insertRule("#statusMsgDiv { position:absolute } ", styleSheetLength++);
				}
			}
		}
	}
}
function getDHTMLObj(objName) {
	if (theBrowser.hasW3CDOM) {
		return document.getElementById(objName).style;
	} else {
		return eval('document' + theBrowser.DHTMLRange + '.' + objName + theBrowser.DHTMLStyleObj);
	}
}
function getDHTMLObjHeight(objName) {
	if (theBrowser.hasW3CDOM) {
		return document.getElementById(objName).offsetHeight;
	} else {
		return eval('document' + theBrowser.DHTMLRange + '.' + objName + theBrowser.DHTMLDivHeight);
	}
}
function myVoid() { ; }
function setMenuHeight(theHeight) {
	getDHTMLObj('menuBottom').top = theHeight;
}
function drawStatusMsg() {
	if (document.layers) {
		document.ids.statusMsgDiv.top = menuStart;
	} else{
		if (document.all) {
			document.styleSheets["JoustStyles"].addRule ("#statusMsgDiv", "top:" + menuStart);
		}
	}
	document.writeln('<DIV ID="statusMsgDiv"><CENTER>Building Menu...</CENTER></DIV>');
}
function drawLimitMarker() {
	var b = theBrowser;
	if (theMenu && b.hasDHTML && b.needLM) {
		var limitPos = theMenu.maxHeight + menuStart + getDHTMLObjHeight('menuBottom');
		if (b.code == 'NS') {
			document.ids.limitMarker.position = "absolute";
			document.ids.limitMarker.visibility = "hidden";
			document.ids.limitMarker.top = limitPos;
		}
		if (b.code == 'MSIE') {
			with (document.styleSheets["JoustStyles"]) {
				addRule ("#limitMarker", "position:absolute");
				addRule ("#limitMarker", "visibility:hidden");
				addRule ("#limitMarker", "top:" + limitPos + "px");
			}
		}
		document.writeln('<DIV ID="limitMarker">&nbsp;</DIV>');
	}
}
function setTop() {
	if (theMenu && theBrowser.hasDHTML) {
		if (getDHTMLObj('menuTop')) {
			drawStatusMsg();
			menuStart = getDHTMLObjHeight("menuTop");
		} else {
			theBrowser.hasDHTML = false;
		}
	}
}
function setBottom() {
	if (theMenu) {
		if (theBrowser.hasDHTML) {
			var mb = getDHTMLObj('menuBottom');
			if (mb) {
				drawLimitMarker();
				getDHTMLObj("statusMsgDiv").visibility = 'hidden';
				menuStart = getDHTMLObjHeight("menuTop");
				theMenu.refreshDHTML();
				if (theMenu.autoScrolling) {theMenu.scrollTo(theMenu.lastPMClicked);}
				mb.visibility = 'visible';
			} else {
				theBrowser.hasDHTML = false;
				self.location.reload();
			}
		}
		theMenu.amBusy = false;
	}
}

function frameResized() {if (theBrowser.hasDHTML) {theMenu.refreshDHTML();}}

//	############################   End of Joust   ############################

if (self.name != 'menu') { self.location.href = 'index.html'; }