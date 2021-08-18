package A1_conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class A1_49_GuardaClientePrueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//1.CREAMOS OBJ SESSION FACTORY PARA QUE LEA EL ARCHIVO DE CONFIGURACIÓN Y CONSTRUYA UN SESSIONFCTORY
		//addAnnotatedClass(A0_48_Clientes.class) : LE INDICAMOS A miFactory LA CLASE CON LA QUE TIENE QUE TRABAJAR. 
		//buildSessionFactory() : LE INDICAMOS QUE CONSTRUYA EL SESSIONFACTORY.
		
		SessionFactory miFactory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(A0_48_Clientes.class).buildSessionFactory();
	
		
		//2. CREAMOS OBJ DE TIPO SESSION PARA ABRIR LA SESIÓN
		Session miSession = miFactory.openSession();
		
		try {
			//3.CREAMOS OBJ DE TIPO CLIENTE
			A0_48_Clientes cliente1 = new A0_48_Clientes("Rochi","Maestro","KameHouse");
			
			//4.EJECUTAMOS TRANSACCIÓN Y GUARDAMOS EL OBJ DE TIPO CLIENTES EN LA BBDD 
			miSession.beginTransaction(); 
			//5.GUARDAMOS EL OBJ DE TIPO CLIENTES EN LA BBDD 
			miSession.save(cliente1);
			//HACEMOS EL COMMIT
			miSession.getTransaction().commit();
			System.out.println("Registro insertado en la base de datos");
			
			//---------------------------------------
			
			//LECTURA DE REGISTRO
			miSession.beginTransaction();
			System.out.println("Lectura del registro del Id: " + cliente1.getId());
			//PARA OBTENER TODA LA INFORMACIÓN:
			//clienteInsertado : ALMACENA TODA LA INFORACIÓN DEL CLIENTE QUE HEMOS INSERTADO 
			A0_48_Clientes clienteInsertado = miSession.get(A0_48_Clientes.class, cliente1.getId());
			System.out.println("Registro: " + clienteInsertado);
			miSession.getTransaction().commit();
			System.out.println("Terminado!");
			miSession.close();
			
		}finally {
			miFactory.close();
		}
	}

}
