<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Insertar Datos</h1>
        
        <a href="/appwebcrud/ServletIndex">Ir a Index</a>
        
        <form action="/appwebcrud/ServletInsertar" method="post">
        	<label for="txtNombre">Nombre</label>
        	<input type="text" id="txtNombre" name="txtNombre">
        	<br>
        	<label for="txtApellido">Apellido</label>
        	<input type="text" id="txtApellido" name="txtApellido">
        	<br>
        	<label for="txtDocumentoIdentidad">Documento de Identidad</label>
        	<input type="text" id="txtDocumentoIdentidad" name="txtDocumentoIdentidad">
        	<br>
        	<label for="txtCorreoElectronico">Correo Electronico</label>
        	<input type="text" id="txtCorreoElectronico" name="txtCorreoElectronico">
        	<br>
        	<label for="txtFechaNacimiento">Fecha Nacimiento</label>
        	<input type="date" id="txtFechaNacimiento" name="txtFechaNacimiento">
        	<br>
        	<input type="submit" value="Registrar Persona">
        </form>
        
    </body>
</html>
