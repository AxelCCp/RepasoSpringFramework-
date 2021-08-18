package A0_SpringMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class A0_27_Controlador {
	
	//MÉTODO QUE SE ENCARGA DE ESPECIFICAR LA VISTA QUE QUEREMOS QUE NOS PROPORCIONE.
	//LE ESPECIFICAMOS UN REQUESTMAPPING, PARA QUE VAYA AL ARCHIVO ESPECIFICADO
	
	@RequestMapping
	public String muestraPagina() {
		return "A1_27_paginaEjemplo";
	}

}
