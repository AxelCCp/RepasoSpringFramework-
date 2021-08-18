<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmación de registro</title>
</head>
<body>

El alumno con nombre <strong>${elAlumno.nombre}</strong> y apellido <strong>${elAlumno.apellido}</strong> se ha registrado con éxito. 
</br>
La asignatura escogida es: <strong>${elAlumno.optativa}</strong>
</br>
La ciudad escogida por el alumno es: <strong>${elAlumno.ciudadEstudios}</strong> 
</br>
Los idioma escogidos son: <strong>${elAlumno.idiomas}</strong>


</body>
</html>