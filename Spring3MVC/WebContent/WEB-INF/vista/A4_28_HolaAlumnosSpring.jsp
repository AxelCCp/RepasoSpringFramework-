<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/recursos/estilos/miestilo.css">
</head>
<body>
	
	Hola ${param.nombreAlumno}. Bienvenido al curso de Spring
	
	<p><br>
		<h2>Atención a todos</h2>
		${mensajeClaro}
	</p>
	
	<!-- ${pageContext.request.contextPath} : DEVUELVE LA RAIZ DEL SITIO WEB, webContent -->
	<img alt="foto" src="${pageContext.request.contextPath}/recursos/imgs/1a048b57090001e4082a2f8f18f7bce5.jpg">
	
</body>
</html>