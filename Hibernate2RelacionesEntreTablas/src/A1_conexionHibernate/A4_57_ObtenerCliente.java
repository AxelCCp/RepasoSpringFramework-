package A1_conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class A4_57_ObtenerCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//LE INDICAMOS AL OBJ SESIONFACTORY QUE DEBE TRABAJAR CON LAS CLASES A0_54_Cliente Y A1_54_DetallesCliente
		
				SessionFactory miFactory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml")
																.addAnnotatedClass(A0_54_Cliente.class)
																.addAnnotatedClass(A1_54_DetallesCliente.class)
																.buildSessionFactory();
				
				Session miSession = miFactory.openSession();
				
				
				try {
					
					//EMPEZAMOS LA TRANSACCIÓN 
					miSession.beginTransaction(); 
					
					//OBTENER DETALLES CLIENTE
					A1_54_DetallesCliente detallesDeCliente = miSession.get(A1_54_DetallesCliente.class, 1);
					
					//IMPRIMIMOS OBJ
					System.out.println(detallesDeCliente);
					
					//OBTENEMOS EL CLIENTE
					System.out.println(detallesDeCliente.getElCliente());
					
					//HACEMOS EL COMMIT
					miSession.getTransaction().commit();
					
				
				}catch(Exception e) {
					System.out.println("No existe el cliente con el id descrito");
					e.printStackTrace();
					
				}finally {
					miSession.close();
					miFactory.close();
				}
		
	}

}
