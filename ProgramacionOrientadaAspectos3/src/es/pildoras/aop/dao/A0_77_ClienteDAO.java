package es.pildoras.aop.dao;

import org.springframework.stereotype.Component;

import es.pildoras.aop.A2_79_Cliente;

//ESTA CLASEDEBE FUNCIONAR A MODO DE COMPONENTE
@Component
public class A0_77_ClienteDAO {
	
	public void insertarCliente(A2_79_Cliente elCliente, String tipo) {
		System.out.println("Cliente insertado con éxito (del método con argumento)");
	}
}
	
	
	
	
	
	