package es.pildoras.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class A1_78_ClienteVipDAO {
	
	//MÉTODO QUE INSERTA CLIENTES EN LA BASE DE DATOS
	public void insertarCliente() {
		System.out.println("Cliente VIP insertado con éxito");
	}
}
