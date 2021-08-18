package A1_conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class A6_59_EliminaDetallesCliente {

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
			A1_54_DetallesCliente detalleDelCliente = miSession.get(A1_54_DetallesCliente.class, 4);
			
			
			//OBTENEMOS EL CLIENTE Y LE DECIMOS QUE ESTE CLIENTE NO TIENE DETALLESCLIENTE.
			//AL  FINAL NO ES POSIBLE HACER ESTA ELIMINACIÓN, YA Q HBRÍA QUE MODIFICAR LA TABLA.
			detalleDelCliente.getElCliente().setDetallesCliente(null);;
			
			
			//ELIMINAMOS
			if(detalleDelCliente!=null) {
				miSession.delete(detalleDelCliente);
			}
			
			//EJECUTAMOS TRANSACCIÓN 
			miSession.beginTransaction(); 
		
			//HACEMOS EL COMMIT
			miSession.getTransaction().commit();
			
			if(detalleDelCliente!=null) System.out.println("Registro eliminado en la base de datos");
			else System.out.println("No hay registros para eliminar");
			
			miSession.close();
			
		}finally {
			miFactory.close();
		}

	}

}
