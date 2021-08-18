<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  


    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css"/>
</head>
<body>

FORMULARIO DE INSERTAR

	<!-- LA ACCION ES INSERTAR CLIENTE, LE PASAMOS EL OBJ CLIENTE ALMACENADO EN EL MODELO, USAMOS POST -->
	<form:form action="insertarCliente" modelAttribute="cliente" method="POST">
		
		<form:hidden path="id"/>
		
		<table>
			<tr>
				<td>nombre:</td>
				<td><form:input path="nombre"/></td>
			</tr>
			
			<tr>
				<td>apellido:</td>
				<td><form:input path="apellido"/></td>
			</tr>
			
			<tr>
				<td>email:</td>
				<td><form:input path="email"/></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="Insertar"></td>
			</tr>
		</table>
	</form:form>

</body>
</html>