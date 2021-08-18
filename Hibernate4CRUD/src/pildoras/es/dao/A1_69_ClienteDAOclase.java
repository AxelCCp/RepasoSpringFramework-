package pildoras.es.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pildoras.es.controlador.entity.A0_68_Cliente;


@Repository //PARA QUE SPRING LA RECONOZCA COMO UN BEAN
public class A1_69_ClienteDAOclase implements A0_69_ClienteDAO {

	@Transactional//CON ESTA ANNOTATION NOS AHORRAMOS EL BEGIN, EL COMMIT, EL ROLLBACK 
	public List<A0_68_Cliente> getClientes() {
		// TODO Auto-generated method stub
		
		//OBTENER LA SESSION
		Session miSession = sessionFactory.getCurrentSession();
		
		//CREAR LA CONSULTA
		Query<A0_68_Cliente> miQuery = miSession.createQuery("from A0_68_Cliente", A0_68_Cliente.class);  
		
		//EJECUTAR LA QUERY Y DEVOLVER RESULTADOS
		List<A0_68_Cliente>clientes = miQuery.getResultList();
		
		return clientes;
	}

	

	@Transactional
	public void insertarCliente(A0_68_Cliente elCliente) {
		// TODO Auto-generated method stub
		
		//OBTENER LA SESSION
		Session miSession = sessionFactory.getCurrentSession();
		
		//INSERTAR EL CLIENTE
		//miSession.save(elCliente);
		
		//INSERTAR CLIENTE O ACTUALIZARLO
		miSession.saveOrUpdate(elCliente);
	} 
	
	
	
	@Transactional
	public A0_68_Cliente getCliente(int id) {
		// TODO Auto-generated method stub
		
		//OBTENER LA SESSION
		Session miSession = sessionFactory.getCurrentSession();
		//OBTENER LA INFORMACIÓN DEL CLIENTE SELECCIONADO
		A0_68_Cliente elCliente = miSession.get(A0_68_Cliente.class, id);
		return elCliente;
	}
	
	
	

	@Transactional
	public void eliminarCliente(int id) {
		// TODO Auto-generated method stub
		//OBTENER LA SESSION
		Session miSession = sessionFactory.getCurrentSession();
		
		//BORRAR CLIENTE DE BBDD CON EL ID CORRESPONDIENTE
		Query consulta = miSession.createQuery("delete from A0_68_Cliente where id=: IdDelCliente");
		//ESTABLECEMOS EL PARÁMETRO
		consulta.setParameter("IdDelCliente", id);
		consulta.executeUpdate();
	}

	
	
	
	//EL OBJ SessionFactory DEBE LLAMARSE IGUAL A COMÓ SE ESPECIFICÓ EN EL ARCHIVO DE CONFIGURACIÓN 
	//HAY QUE HACER UNA INTECCIÓN DE DEPENDENCIAS PARA sessionFactory.
	@Autowired
	private SessionFactory sessionFactory;








}
