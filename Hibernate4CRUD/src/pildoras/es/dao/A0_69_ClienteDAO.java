package pildoras.es.dao;

import java.util.List;

import pildoras.es.controlador.entity.A0_68_Cliente;

//ESTA INTERFAZ DEBE DEVOLVER UNA LISTA CON TODOS LOS CLIENTES


public interface A0_69_ClienteDAO {

	//getClientes() : CREA LISTA DE TIPO CLIENTES
	public List<A0_68_Cliente>getClientes();

	
	//PARA INSERTAR NUEVOS CLIENTES
	public void insertarCliente(A0_68_Cliente elCliente);


	public A0_68_Cliente getCliente(int id);


	public void eliminarCliente(int id);
	
}
