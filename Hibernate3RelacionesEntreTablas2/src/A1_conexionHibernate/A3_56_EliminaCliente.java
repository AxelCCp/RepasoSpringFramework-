package A1_conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class A3_56_EliminaCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//LE INDICAMOS AL OBJ SESIONFACTORY QUE DEBE TRABAJAR CON LAS CLASES A0_54_Cliente Y A1_54_DetallesCliente
		
		SessionFactory miFactory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml")
														.addAnnotatedClass(A0_54_Cliente.class)
														.addAnnotatedClass(A1_54_DetallesCliente.class)
														.buildSessionFactory();
		
		Session miSession = miFactory.openSession();
		
		
		try {
			
			//get() : OBTENEMOS EL OBJ Cliente QUE QUEREMOS ELIMINAR, ESPECIFICANDO LA CLASE Y EL ID EN LA TABLA 
			A0_54_Cliente elCliente = miSession.get(A0_54_Cliente.class, 2);
			
			//ELIMINAMOS
			if(elCliente!=null) {
				
				System.out.println("Se va a eliminar al cliente " + elCliente.getNombre());
				miSession.delete(elCliente);
			}
			
			//EJECUTAMOS TRANSACCIÓN 
			miSession.beginTransaction(); 
		
			//HACEMOS EL COMMIT
			miSession.getTransaction().commit();
			
			if(elCliente!=null) System.out.println("Registro eliminado en la base de datos");
			
			else System.out.println("No hay registros para eliminar");
			
			miSession.close();
			
		}finally {
			miFactory.close();
		}

	}

}
