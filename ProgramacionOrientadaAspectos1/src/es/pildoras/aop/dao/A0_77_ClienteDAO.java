package es.pildoras.aop.dao;

import org.springframework.stereotype.Component;

import es.pildoras.aop.A2_79_Cliente;

//ESTA CLASEDEBE FUNCIONAR A MODO DE COMPONENTE
@Component
public class A0_77_ClienteDAO {
	
	//MÉTODO QUE INSERTA CLIENTES EN LA BASE DE DATOS
	
	public void insertarCliente() {
		System.out.println("Cliente insertado con éxito");
	}

	public void insertarCliente2(A2_79_Cliente elCliente, String tipo) {
		System.out.println("Cliente insertado con éxito (del método con argumento)");
	}
}
