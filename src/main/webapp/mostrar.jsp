<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar</title>
    </head>
    <body>
        <h1>Listar Personas</h1>
        
        <table border="1">
        	<thead>
        		<th>NOMBRE </th>
        		<th>APELLIDO </th>
        		<th>DOCUMENTO IDENTIDAD </th>
        		<th>CORREO ELECTRONICO </th>
        		<th>FECHA NACIMIENTO </th>
        		<th>FECHA REGISTRO </th>
        		<th>FECHA ACTUALIZACION </th>
        		<th></th>
        		<th></th>
        	</thead>
        	<tbody>
        		<c:forEach var="item" items="${lista}">
		        	<tr>
		        		<th><c:out value="${item.getNombre()}"></c:out> </th>
		        		<th><c:out value="${item.getApellido()}"></c:out> </th>
		        		<th><c:out value="${item.getDocumentoIdentidad()}"></c:out> </th>
		        		<th><c:out value="${item.getCorreoElectronico()}"></c:out> </th>
		        		<th><c:out value="${item.getFechaNacimiento()}"></c:out> </th>
		        		<th><c:out value="${item.getFechaRegistro()}"></c:out> </th>
		        		<th><c:out value="${item.getFechaActualizacion()}"></c:out> </th>
		        		<th><input type="button" value="Editar" onclick="editar('${item.getId()}');"></th>
		        		<th><input type="button" value="Eliminar" onclick="eliminar('${item.getId()}');"></th>
		        	</tr>
	        	</c:forEach>
        	</tbody>
        	
        </table>
        
    </body>
    <script src="resource/js/funciones_crud.js" type="text/javascript"></script>
</html>
