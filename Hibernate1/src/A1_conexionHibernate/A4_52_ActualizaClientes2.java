package A1_conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class A4_52_ActualizaClientes2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//1.CREAMOS OBJ SESSION FACTORY PARA QUE LEA EL ARCHIVO DE CONFIGURACIÓN Y CONSTRUYA UN SESSIONFCTORY
		//addAnnotatedClass(A0_48_Clientes.class) : LE INDICAMOS A miFactory LA CLASE CON LA QUE TIENE QUE TRABAJAR. 
		//buildSessionFactory() : LE INDICAMOS QUE CONSTRUYA EL SESSIONFACTORY.
		
		SessionFactory miFactory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(A0_48_Clientes.class).buildSessionFactory();
	
		
		//2. CREAMOS OBJ DE TIPO SESSION PARA ABRIR LA SESIÓN
		Session miSession = miFactory.openSession();
		
		try {
			
			miSession.beginTransaction(); 
			
			//HACEMOS UN CAMBIO EN LA COLUMNA APELLIDOS A TODOS LOS CAMPOS QUE EMPIECEN CON C
			miSession.createQuery("update A0_48_Clientes set Apellidos='CorporacionCápsula' where Apellidos LIKE 'C%'").executeUpdate();
			
			miSession.getTransaction().commit();
			System.out.println("Registro ACTUALIZADO en la base de datos");
			
			//---------------------------------------
			
			
			miSession.close();
			
		}finally {
			miFactory.close();
		}
	}

}
