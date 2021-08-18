package pildoras.es.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pildoras.es.controlador.entity.A0_68_Cliente;
import pildoras.es.dao.A0_69_ClienteDAO;

@Controller
@RequestMapping("/cliente")
public class A0_67_Controlador {

	
	//MÉTODO QUE NOS DEVUELVE EL ARCHIVO JSP
	@RequestMapping("/lista")
	public  String listaClientes(Model modelo) {
		
		//OBTENER LOS CLIENTES DESDE EL DAO //HAY QUE HACER UNA INYECCIÓN DE OBJ DE TIPO ClienteDAO
		List <A0_68_Cliente>losClientes = clienteDAO.getClientes();
		
		//AGREGAMOS LOS CLIENTES AL MODELO
		modelo.addAttribute("clientes",losClientes);
		
		return "A0_67_listaClientes";
	}
	
	
	//MÉTODO PARA CREAR NUEVOS CLIENTES Y AGREGARLOS A LA TABLA 
	@RequestMapping("/muestraFormularioAgregar")
	public String muestraFormularioAgregar(Model modelo) {
			
		//BIND DE DATOS DE LOS CLIENTES
		A0_68_Cliente elCliente = new 	A0_68_Cliente();
		modelo.addAttribute("cliente", elCliente);
		
		return "A1_71_formularioCliente";
	}
	
	
	//USAMOS @PostMapping(url) SEGÚN LO INDICADO EN <form:form action="insertarCliente" modelAttribute="cliente" method="POST">
	//LE PASAMOS POR PARÁMETRO EL modelAttribute="cliente" Y DESPUÉS LE PASAMOS UN OBJDE TIPO CLIENTE PARA ALMACENARLO
	@PostMapping("/insertarCliente")
	public String insertarCliente(@ModelAttribute("cliente") A0_68_Cliente elCliente) {
		//INSERTAMOS EL REGISTRO EN LA BASE DE DATOS
		clienteDAO.insertarCliente(elCliente);
		return "redirect:/cliente/lista";
	}
	
	
	//@GetMapping : USAMOS GET PARA OBTENER EL ID DEL CLIENTE A TRAVÉS DE LA URL.
	//RequestParam : LA USAMOS PARA RECIBIR EL ID DEL CLIENTE.
	//int Id: CORRESPONDE AL PARÁMETRO QUE LE ESTAMOS PASANDO CON EL MODELO.
	@GetMapping("/muestraFormularioActualizar")
	public String muestraFormularioActualizar(@RequestParam("clienteId")int Id, Model modelo) {
		
		//OBTENER EL CLIENTE.
		A0_68_Cliente elCliente = clienteDAO.getCliente(Id);
		//ESTABLECER EL CLIENTE COMO ATRIBUTO DEL MODELO
		modelo.addAttribute("cliente",elCliente);
		//ENVIAR AL FORMULARIO
		return "A1_71_formularioCliente";
	}
	
	
	//MÉTODO PARA ELIMINAR
	@GetMapping("/eliminar")
	public String eliminarCliente(@RequestParam("clienteId")int Id) {
		
		//ELIMINAR EL CLIENTE.
		clienteDAO.eliminarCliente(Id);
	
		//REDIRECCIONAR A LA LISTA DE CLIENTE
		return "redirect:/cliente/lista";
	}
	
	
	@Autowired //HACEMOS LA INYECCIÓN DE DEPENDENCIA PARA USAR EL OBJ clienteDAO 
	private A0_69_ClienteDAO clienteDAO;
	
}
