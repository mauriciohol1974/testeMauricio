<%@page contentType="text/html; charset=ISO-8859-1"%>




<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml"> 

<body>


<form name="frmUpload" method="post" action="UploadArquivoServlet"  enctype="multipart/form-data">

<input type="hidden" name="acao" value="2" />


<table>

		<tr>
			<td> <input type="file" name="dataFile"  id="fileChooser" /></td>
		</tr>
		
</table>

<table width="779" cellpadding="0" cellspacing="0">
  <tr>
    <td width="100%" height="24" align="center"><a href="javascript: enviaForm();">Enviar</a></td>
  </tr>
</table>



</form>

<script type="text/Javascript">


function enviaForm(){
	alert("Enviar Form");
	document.frmUpload.submit();	
}




</script>

</body>

</html>