package A0_SpringMVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/secundario")
public class A5_33_TirarControlador {
	
	
	@RequestMapping("/muestraFormulario")
	public String muestraFormulario() {
		return "A3_28_HolaAlumnosFormulario";
	}
	
	
	@RequestMapping("/procesarFormulario2")
	public String otroProcesoFormulario(@RequestParam("nombreAlumno")String nombre, Model modelo) {
		nombre+= " es el peor alumno";
		String mensajeFinal = "¿Quién es el peor alumno?" + nombre;
		modelo.addAttribute("mensajeClaro", mensajeFinal);
		return "A4_28_HolaAlumnosSpring";
	}
}
