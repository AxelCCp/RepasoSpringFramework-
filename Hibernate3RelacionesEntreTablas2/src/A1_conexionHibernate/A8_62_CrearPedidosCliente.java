package A1_conexionHibernate;

import java.util.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class A8_62_CrearPedidosCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//LE INDICAMOS AL OBJ SESIONFACTORY QUE DEBE TRABAJAR CON LAS CLASES A0_54_Cliente Y A1_54_DetallesCliente
		
		SessionFactory miFactory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml")
														.addAnnotatedClass(A0_54_Cliente.class)
														.addAnnotatedClass(A1_54_DetallesCliente.class)
														.addAnnotatedClass(A7_60_Pedido.class)
														.buildSessionFactory();
		
		Session miSession = miFactory.openSession();
		
		
		try {
			miSession.beginTransaction(); 
			
			//CREAMOS OBJ DE TIPO CLIENTE, PARA OBTENER AL CLIENTE DE LA BBDD
			A0_54_Cliente elCliente = miSession.get(A0_54_Cliente.class, 5);
			
			//CREAMOS PEDIDOS DEL CLIENTE
			A7_60_Pedido pedido1 = new A7_60_Pedido(new GregorianCalendar(2020,7,5));
			A7_60_Pedido pedido2 = new A7_60_Pedido(new GregorianCalendar(2020,6,15));
			A7_60_Pedido pedido3 = new A7_60_Pedido(new GregorianCalendar(2020,4,25));
			
			//AGREGAR PEDIDOS CREADOS AL CLIENTE CREADO
			elCliente.agregarPedidos(pedido1);
			elCliente.agregarPedidos(pedido2);
			elCliente.agregarPedidos(pedido3);
			
			//GUARDAR PEDIDOS EN LA BBDD
			miSession.save(pedido1);
			miSession.save(pedido2);
			miSession.save(pedido3);
			
			miSession.getTransaction().commit();
			System.out.println("Registro insertado en la base de datos");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			miSession.close();
			miFactory.close();
		}
	}
}
