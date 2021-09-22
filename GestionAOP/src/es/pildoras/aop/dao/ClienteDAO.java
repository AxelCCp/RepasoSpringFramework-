package es.pildoras.aop.dao;

import org.springframework.stereotype.Component;

import es.pildoras.aop.Cliente;

@Component
public class ClienteDAO {

	public void insertaCliente(Cliente elClientes, String tipo) {
		System.out.println("Cliente insertado OK");
	}
	
}
