package A0_SpringMVC;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/principal")
public class A2_28_ControladorHolaAlumnos {

	//MÉTODO QUE PIDE EL PRIMER FORMULARO AL SERVIDOR
	//@RequestMapping("muestraFormulario"): ES LA URL CON LA QUE PEDIMOS EL FORMULARIO 
	@RequestMapping("/muestraFormulario")
	public String muestraFormulario() {
		return "A3_28_HolaAlumnosFormulario";
	}
	
	//MÉTODO QUE PROCESA EL FORMULARIO YA RELLENADO
	@RequestMapping("/procesarFormulario")
	public String procesarFormulario() {
		return "A4_28_HolaAlumnosSpring";	
	}
	
	
	/*
	//MÉTODO AGREGA INFORMACIÓN ADICIONAL AL MODELO Y DESPÚES LLAMA A LA VISTA 
	//RECIVE 2 PARAMETROS. EL REQUEST Y EL MODELO
	@RequestMapping("/procesarFormulario2")
	//public String otroProcesoFormulario(HttpServletRequest request, Model modelo) {
	
		//CAPTURAMOS INFORMACIÓN DEL CUADRO DE TEXTO
		String nombre = request.getParameter("nombreAlumno");
		nombre+= " es el mejor alumno";
		String mensajeFinal = "¿Quién es el mejor alumno?" + nombre;
		
		//AGREGANDO INFO AL MODELO
		modelo.addAttribute("mensajeClaro", mensajeFinal);
		
		return "A4_28_HolaAlumnosSpring";
	}*/
	
	
	
	//ALMACENAMOS EN String nombre, LO QUE SE OBTENGA CON (@RequestParam("nombreAlumno")
	@RequestMapping("/procesarFormulario2")
	public String otroProcesoFormulario(@RequestParam("nombreAlumno")String nombre, Model modelo) {
		
		
		nombre+= " es el mejor alumno";
		String mensajeFinal = "¿Quién es el mejor alumno?" + nombre;
		
		modelo.addAttribute("mensajeClaro", mensajeFinal);
		
		return "A4_28_HolaAlumnosSpring";
	}
	
	
	
}
