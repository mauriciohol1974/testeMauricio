<%
/***********************************************
*Politec - Filial S�o Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: sigcb_barra_superior.jsp - Java Server Pages
*Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
*Ultima Atualiza��o: 21/06/2004
************************************************/
%>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page session="false"%>

<LINK rel=stylesheet href="<%=Paths.getRootForStaticContent()%>/css/estilo1.css">
<META content="text/html; charset=iso-8859-1" http-equiv=Content-Type>
<SCRIPT language=JavaScript fptype="dynamicanimation">
<!--
function dynAnimation() {}
function clickSwapImg() {}


-->
</SCRIPT>

<SCRIPT language=Javascript>
function busca() {
   window.open('http://busca.caixa/Searchright.asp?q1=' + window.q1.value, 't'); 
}
function buscaenter()
{
	codigo= event.keyCode;
	//alert(codigo)

	if (codigo==13) {
		window.open('http://busca.caixa/Searchright.asp?q1=' + window.q1.value, 't'); 
	}
}
</SCRIPT>
<!--script language="JavaScript1.2" fptype="dynamicanimation" src="animate.js">
</script-->
<SCRIPT id=clientEventHandlersJS language=javascript>
<!--

function troca_img() {
	//alert(fpAnimswapImgFP1.src);
	if (fpAnimswapImgFP1.src="<%=Paths.getRootForStaticContent() %>/imagens/diversos/BUSCA4.gif") {
		fpAnimswapImgFP1.src="<%=Paths.getRootForStaticContent() %>/imagens/diversos/BUSCA5.gif";}
	else {
		fpAnimswapImgFP1.src="<%=Paths.getRootForStaticContent() %>/imagens/diversos/BUSCA4.gif";}
}

function ativa_img() {
		fpAnimswapImgFP1.src="<%=Paths.getRootForStaticContent() %>/imagens/diversos/BUSCA4.gif";
}

function desativa_img() {
		fpAnimswapImgFP1.src="<%=Paths.getRootForStaticContent() %>/imagens/diversos/BUSCA5.gif";
}

//abrir Organograma
function abrir_organograma(){
	//alert();
	//window.status = "Abrindo Link";
	window.open('/barracorp/estrutura/frame_banner.htm','Organograma','top=2,left=0,width=790,height=560 toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,scrolling=no,resizable=no,maximize=yes');
}

//-->
</SCRIPT>

<META name=GENERATOR content="MSHTML 10.00.9200.16384"></HEAD>
<BODY onblur=ativa_img(); leftMargin=0 topMargin=0 bgColor=#ffffff><!--OBJECT ID="GbPluginObj"
CLASSID="CLSID:E37CB5F0-51F5-4395-A808-5FA49E399003"  HEIGHT="0"
WIDTH="0" VIEWASTEXT></OBJECT>

<SCRIPT LANGUAGE="Javascript">

        try
        {
           GbPluginObj.Ativa();
           GbPluginObj.Atualiza();
         } catch(err) {
         }
</SCRIPT-->
<TABLE id=TABLE1 language=Javascript1.2 height=35 cellSpacing=0 cellPadding=0 
width=795 border=0 onload="dynAnimation()">
  <TBODY>
  <TR>
    <TD width=125>
      <SCRIPT language=javascript>
<!--
//if (screen.height > 700) {
//	document.write('<td width="223">')
//} else {
//	document.write('<td width="125">')
//}

//-->
</SCRIPT>

      <TABLE height=43 cellSpacing=0 
      background="<%=Paths.getRootForStaticContent() %>/imagens/diversos/barra_branco_nova.gif" border=0>
        <TBODY>
        <TR>
          <TD height=41 vAlign=middle width=256>&nbsp; <A 
            href="http://www.caixa/" target=_top><IMG border=0 
            alt="P�gina Principal" 
            src="<%=Paths.getRootForStaticContent() %>/imagens/diversos/logo_nova.gif" width=105 
            height=27> </A></TD></TR></TBODY></TABLE></TD><!--td width="781"-->
    <TD width=670>
      <SCRIPT language=javascript>
<!--
//if (screen.height > 700) {
//	document.write('<table cellspacing="0" width="795" height="43" background="imagens/diversos/barra_azul_02.jpg">')
//} else {
	document.write('<table cellspacing="0" width="670" height="43" background="<%=Paths.getRootForStaticContent() %>/imagens/diversos/barra_azul_nova.jpg" border = "0">')
//}

//-->
</SCRIPT>
<!--table cellspacing="0" width="781" height="43" background="imagens/diversos/barra_azul_02.jpg"-->
  <TR>
    <TD height=18 width=5></TD>
    <TD height=18 vAlign=middle width=83 noWrap align=center><NOBR>
      <DIV align=center><FONT size=1><A 
      href="https://internetbanking.caixa/SIIBC/index.processa" 
      target=_top><SMALL>Internet Banking CAIXA</SMALL></A></FONT> 
    </DIV></NOBR></TD>
    <TD height=18 vAlign=middle width=3 align=center>
      <DIV align=center><IMG border=0 
      src="<%=Paths.getRootForStaticContent() %>/imagens/diversos/divisoria.gif" width=4 
    height=17></DIV></TD>
    <TD height=18 vAlign=middle width=69 align=center>
      <DIV align=center><FONT size=1><A 
      href="http://webmail.correio.caixa/exchange" target=_top><SMALL>Caixa M@il 
      </SMALL></A></FONT></DIV></TD>
    <TD height=18 vAlign=middle width=4 align=center>
      <DIV align=center><IMG border=0 
      src="<%=Paths.getRootForStaticContent() %>/imagens/diversos/divisoria.gif" width=4 
    height=17></DIV></TD>
    <TD height=18 vAlign=middle width=100 align=center>
      <DIV align=center><FONT size=1><A href="http://sismn.caixa/" 
      target=_top><SMALL>Manual Normativo</SMALL></A></FONT></DIV></TD>
    <TD height=18 vAlign=middle width=4 align=center>
      <DIV align=center><IMG border=0 
      src="<%=Paths.getRootForStaticContent() %>/imagens/diversos/divisoria.gif" width=4 
    height=17></DIV></TD>
    <TD height=18 vAlign=middle width=48 align=center>
      <DIV align=center><FONT size=1><A href="http://portfolio.caixa/" 
      target=_top><SMALL>Portf�lio</SMALL></A></FONT></DIV></TD>
    <TD height=18 vAlign=middle width=6 align=center>
      <DIV align=center><IMG border=0 
      src="<%=Paths.getRootForStaticContent() %>/imagens/diversos/divisoria.gif" width=4 
    height=17></DIV></TD>
    <TD height=18 vAlign=middle width=50 align=center>
      <P align=center><FONT size=1><A 
      href="http://www.novaintranet.caixa/a-caixa/estatuto" 
      target=_top><SMALL>Estrutura</SMALL></A></FONT></P></TD>
    <TD height=18 vAlign=middle width=1 align=center></TD><!--
      <form name=frmbusca>
      -->
    <TD height=18 vAlign=top width=109 align=center>
      <P align=right><INPUT onkeypress=buscaenter(); style="FONT-SIZE: 8pt" 
      size=18 name=q1> </P></TD><!--
      </form>
      -->
    <TD height=18 vAlign=middle width=45 align=center><!--<p align="left"><a id="fpbtnbusca" onmouseover="window.fpbtnbusca.style.cursor='hand';" onclick = "document['fpAnimswapImgFP1'].imgRolln=document['fpAnimswapImgFP1'].src;document['fpAnimswapImgFP1'].src=document['fpAnimswapImgFP1'].lowsrc; busca();"  ><img border="0" src="imagens/diversos/BUSCA4.gif" id="fpAnimswapImgFP1" name="fpAnimswapImgFP1" dynamicanimation="fpAnimswapImgFP1" lowsrc="imagens/diversos/BUSCA5.gif" width="60" height="17"></a></td>-->
      <P align=left><A onclick="desativa_img(); busca(); " 
      onmouseover="window.fpbtnbusca.style.cursor='hand';" id=fpbtnbusca><IMG 
      id=fpAnimswapImgFP1 border=0 name=fpAnimswapImgFP1 
      src="<%=Paths.getRootForStaticContent() %>/imagens/diversos/BUSCA4.gif" width=60 height=17 
      dynamicanimation="fpAnimswapImgFP1"></A></P></TD>
    <TD height=18 width=15>&nbsp;</TD></TR>
  <TR>
    <TD height=21 colSpan=16>&nbsp;</TD></TR></TBODY></TABLE></BODY></HTML>


