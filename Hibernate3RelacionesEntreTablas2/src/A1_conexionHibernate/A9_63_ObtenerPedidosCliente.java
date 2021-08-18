package A1_conexionHibernate;

import java.util.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class A9_63_ObtenerPedidosCliente {

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
			//A0_54_Cliente elCliente = miSession.get(A0_54_Cliente.class, 5);
			//System.out.println("Cliente: " + elCliente);
			//System.out.println("Pedidos: " + elCliente.getPedidos());
			
			
			//(CLASE 65) HACEMOS UNA CONSULTA
			Query<A0_54_Cliente>consulta = miSession.createQuery("SELECT CL FROM A0_54_Cliente CL JOIN FETCH CL.pedidos WHERE CL.id=:elClienteId",A0_54_Cliente.class);
			//ESPECIFICAMOS EL ID DEL CLIENTE(ALIAS) 
			consulta.setParameter("elClienteId", 5);
			//LE DECIMOS QUE CARGUE LOS DATOS DE LA CONSULTA EN MEMORIA
			A0_54_Cliente elCliente = consulta.getSingleResult();
			System.out.println("Cliente: " + elCliente);
				
			miSession.getTransaction().commit();
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			miSession.close();
			miFactory.close();
		}
	}
}
