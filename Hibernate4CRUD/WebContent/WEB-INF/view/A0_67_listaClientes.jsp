<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"  %>  


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Clientes</title>

<!-- LE DECIMOS A ESTA HOJA QUE TOME LOS ESTILOS INDICANDO EL DIRECTORIO  -->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css"/>

</head>
<body>

***Lista de clientes*** 

<table>
	<tr>
		<th>nombre</th>
		<th>apellido</th>
		<th>email</th>
		<th>modificar</th>
	</tr>
	
	<!-- ESTE BUCLE RECORRE LA INFORMACIÓN ALMACENADA EN modelo.addAttribute("clientes",losClientes); -->
	<!-- LE DECIMOS QUE CONSTRUYA FILAS <tr> y celdas <td> SEGÚN LA CANTIDAD DE REGISTROS EN LA TABLA -->
	<!-- USAMOS clienteTemp PARA AGREGAR LOS REGISTROS A LAS CELDAS -->
	<c:forEach var="clienteTemp" items="${clientes}">
		
		<!-- LINK PARA ACTUALIZAR -->
		<!-- var : DEBE COINCIDIR CON EL HREF,  value : ESPECIFICA A DONDE TIENE QUE LLEVARNOS ESTE LINK -->
		<!-- A ESTA URL DE VALUE ... LE TENEMOS QUE PASAR EL ID DEL CLIENTE, PARA MODIFICARLO. PARA ESTO USAMOS C:PARAM  -->
		<c:url var="linkActualizar" value="/cliente/muestraFormularioActualizar">
			<c:param name="clienteId" value="${clienteTemp.id}"/>
		</c:url>
		
		<!-- LINK PARA ELIMINAR -->
		<c:url var="linkEliminar" value="/cliente/eliminar">
			<c:param name="clienteId" value="${clienteTemp.id}"/>
		</c:url>
		
		<tr>
			<td>${clienteTemp.nombre}</td>
			<td>${clienteTemp.apellido}</td>
			<td>${clienteTemp.email}</td>
			<td><a href="${linkActualizar}"> <input type="button" value="modificar"/> </a></td>
			<td><a href="${linkEliminar}"> <input type="button" value="eliminar" onclick="if(!(confirm('Vas a eliminar un registro...')))return false"/> </a></td>
		</tr>
	</c:forEach>
</table>

</br>
<!--return false; CON ESTO LE DECIMOS QUE NO HAGA NADA MÁS QUE REDIRIGIRNOS A DONDE ESTAMOS  -->
<input type="button" value="Agregar Cliente" onClick="window.location.href='muestraFormularioAgregar';return false;"/>

</body>
</html>