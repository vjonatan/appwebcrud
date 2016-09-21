<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Actualizar Información</h1>
        
        <jsp:useBean id="persona" class="com.enlawebdekaaf.bean.Persona" scope="request"></jsp:useBean>
        <form action="/appwebcrud/ServletActualizar" method="post">
        	<input type="hidden" id="txtId" name="txtId" value="<%=persona.getId()%>">    
        	<label for="txtNombre">Nombre</label>
        	<input type="text" id="txtNombre" name="txtNombre" value="<%=persona.getNombre()%>">
        	<br>
        	<label for="txtApellido">Apellido</label>
        	<input type="text" id="txtApellido" name="txtApellido" value="<%=persona.getApellido()%>">
        	<br>
        	<label for="txtDocumentoIdentidad">Documento de Identidad</label>
        	<input type="text" id="txtDocumentoIdentidad" name="txtDocumentoIdentidad" value="<%=persona.getDocumentoIdentidad()%>">
        	<br>
        	<label for="txtCorreoElectronico">Correo Electronico</label>
        	<input type="text" id="txtCorreoElectronico" name="txtCorreoElectronico" value="<%=persona.getCorreoElectronico()%>">
        	<br>
        	<label for="txtFechaNacimiento">Fecha Nacimiento</label>
        	<input type="date" id="txtFechaNacimiento" name="txtFechaNacimiento"  value="<%=persona.getFechaNacimiento()%>">
        	<br>
        	<input type="submit" value="Actualizar Datos">
        </form>
    </body>
</html>
