<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FORMULARIO DE REGISTRO</title>
</head>
<body>

	<form:form action="procesarFormulario" modelAttribute="elAlumno">
	
		<!-- "nombre" DEBE COINCIDIR CON EL NOMBRE DEL SETTER DE CLASE ALUMNO -->
		<!-- <form:errors ... PARAQUE PAREZCA EL MENSAJE DE ERROR. -->
		Nombre: <form:input path="nombre"/> <form:errors path="nombre"/>
		<br/><br/>
		
		Apellido: <form:input path="apellido"/>	
		<br/><br/>
		
		Asignaturas optativas: <br/>
		<form:select path="optativa" multiple="true">
			<form:option value="Dise�o" label="Dise�o"/>
			<form:option value="Karate" label="Karate"/>
			<form:option value="Econom�a" label="Econom�a"/>
		</form:select>
		<br/><br/><br/>
		
		Barcelona<form:radiobutton path="ciudadEstudios" value="Barcelona"/>
		Madrid<form:radiobutton path="ciudadEstudios" value="Madrid"/>
		Valencia<form:radiobutton path="ciudadEstudios" value="Valencia"/>
		Bilbao<form:radiobutton path="ciudadEstudios" value="Bilbao"/>
		<br/><br/><br/>
		
		Espa�ol<form:checkbox path="idiomas" value="Espa�ol"/>
		Ingl�s<form:checkbox path="idiomas" value="Ingl�s"/>
		Franc�s<form:checkbox path="idiomas" value="Franc�s"/>
		Alem�n<form:checkbox path="idiomas" value="Alem�n"/>
		<br/><br/><br/>
		
		
		<br/><br/>
		<input type="submit" text="enviar">
		
	</form:form>

</body>
</html>