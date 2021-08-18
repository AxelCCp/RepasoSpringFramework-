package A0_SpringMVC;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alumno")
public class A7_34_AlumnoController {
	
	
	//M�TODO QUE MUESTRA EL FORMULARIO -------------------------------------------------------------------------------------
	//modelo ES UN OBJ QUE SIRVE DE PUENTE ENTRE EL CONTROLADOR Y LAS VISTAS.
	@RequestMapping("/muestraFormulario")
	public String muestraFormulario(Model modelo) {
		
		//CREAMOS VARIABLE OBJ DE TIPO ALUMNO 
		A6_34_Alumno elAlumno = new A6_34_Alumno();
		//CARGAMOS elAluno EN EL modelo 
		modelo.addAttribute("elAlumno",elAlumno);
		
		return "A8_34_alumnoRegistroFormulario";
		
	}
	
	//M�TODO QUE NO DEJA PASAR ESPACIOS EN BLANCO (CLASE 41)---------------------------------------------------------------------------
	//RECIBE OBJ BINDER PARA: 
	@InitBinder
	public void miBinder(WebDataBinder binder) {
		//USAMOS EL CONSTRUCTOR QUE RECIBE UN BOOLEAN. TRUE SI UN STRING VACI� DEBE SER CONVERTIDO EN NULL.
		StringTrimmerEditor recortaEspaciosBlanco = new StringTrimmerEditor(true);
		//registerCustomEditor():
		binder.registerCustomEditor(String.class, recortaEspaciosBlanco);
	}
	
	
	
	
	
	//M�TODO QUE MUESTRA EL FORMULARIO DE CONFIRMACI�N  --------------------------------------------------------------------
	//@ModelAttribute: PARA PODER RECIBIR POR P�RAMETRO EL OBJETO modelo, DONDE VA ALMACENADO EL OBJ DE TIPO ALUMNO. 
	//DESPU�S ALMACENAMOS EN elAlumnox, LA INFORMACI�N ALMACENADA EN modelo. 
	
	//(clase39)BindingResult : los resultados de la validaci�n Hibernate se almacenan en el obj resultadoValidacion.
	//(clase39)@Valid : le indicamos a Spring que estamos usando validaci�n.
	@RequestMapping("/procesarFormulario")
	public String procesarFormulario(@Valid @ModelAttribute("elAlumno") A6_34_Alumno elAlumnoX, BindingResult resultadoValidacion) {
		
		//(clase39) PREGUNTAMOS SI EL OBJ resultadoValidacion TIENE ERRORES:
		if(resultadoValidacion.hasErrors()) return "A8_34_alumnoRegistroFormulario";

		else return "A9_35_ConfirmacionRegistroAlumno";
		
	}
}
