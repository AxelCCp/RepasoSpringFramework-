package A1_conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class A2_55_InsertaCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//LE INDICAMOS AL OBJ SESIONFACTORY QUE DEBE TRABAJAR CON LAS CLASES A0_54_Cliente Y A1_54_DetallesCliente
		
		SessionFactory miFactory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml")
														.addAnnotatedClass(A0_54_Cliente.class)
														.addAnnotatedClass(A1_54_DetallesCliente.class)
														.buildSessionFactory();
		
		Session miSession = miFactory.openSession();
		
		
		try {
			//3.CREAMOS OBJ DE TIPO CLIENTE
			A0_54_Cliente cliente1 = new A0_54_Cliente("Pilaf","Rey","Castillo");
			//MANEJAMOS LOS DETALLES DEL CLIENTE
			A1_54_DetallesCliente detallesCliente1 = new A1_54_DetallesCliente("www.pildoras.es","28438473","segundo cliente");
			
			//ASOCIAMOS LOS OBJ'S PARA QUE HIBERNET SEPA QUE TIPO DE ASOCIACIÓN HAY ENTRE LOS DATOS. USAMOS EL SETTER DE LA ASOCIACIÓN. 
			cliente1.setDetallesCliente(detallesCliente1);
			
			
			//EJECUTAMOS TRANSACCIÓN 
			miSession.beginTransaction(); 
			//GUARDAMOS EL OBJ DE TIPO CLIENTES EN LA BBDD. AL ESTAR RELACIONADA, AUTOMATICAMENTE SE GUARDA detallesCliente1
			miSession.save(cliente1);
			//HACEMOS EL COMMIT
			miSession.getTransaction().commit();
			System.out.println("Registro insertado en la base de datos");
			
			
			miSession.close();
			
		}finally {
			miFactory.close();
		}

	}

}
