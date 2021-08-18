package A1_conexionHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class A2_51_ConsultaClientes {
	public static void main(String[]args) {
		//1.CREAMOS OBJ SESSION FACTORY PARA QUE LEA EL ARCHIVO DE CONFIGURACIÓN Y CONSTRUYA UN SESSIONFCTORY
		//addAnnotatedClass(A0_48_Clientes.class) : LE INDICAMOS A miFactory LA CLASE CON LA QUE TIENE QUE TRABAJAR. 
		//buildSessionFactory() : LE INDICAMOS QUE CONSTRUYA EL SESSIONFACTORY.
		SessionFactory miFactory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(A0_48_Clientes.class).buildSessionFactory();
					
		//2. CREAMOS OBJ DE TIPO SESSION PARA ABRIR LA SESIÓN
		Session miSession = miFactory.openSession();
		
		try {
			//COMENZAR SESIÓN
			miSession.beginTransaction();
			//CONSULTA DE CLIENTES CON INSTRUCCIÓN HQL
			List<A0_48_Clientes> losClientes = miSession.createQuery("from A0_48_Clientes").getResultList();
			//MOSTRAR CLIENTES
			for(A0_48_Clientes unCliente : losClientes) {
				System.out.println(unCliente);
			}
			
			
			//FILTRADO... CONSULTA .... SOLO LOS QUE VIVEN EN JAPAN
			System.out.println("::::::::::FILTRADO DE CONSULTA:::::::::LOS QUE VIVEN EN JAPAN:::::::::::");
			losClientes = miSession.createQuery("from A0_48_Clientes ps where ps.direccion='Japan'").getResultList();
			for(A0_48_Clientes unCliente : losClientes) {
				System.out.println(unCliente);
			}
			
			
			//FILTRADO... CONSULTA ...LOS QUE SE LLAMAN GIRU O VIVEN EN KAMEHOUSE
			System.out.println("::::::::::FILTRADO DE CONSULTA:::::::::LOS QUE SE LLAMAN GIRU O VIVEN EN KAMEHOUSE:::::::::::");
			losClientes = miSession.createQuery("from A0_48_Clientes ps where ps.direccion='KameHouse' or ps.nombre='Giru'").getResultList();
			for(A0_48_Clientes unCliente : losClientes) {
				System.out.println(unCliente);
			}
			
			
			//-----------------------------------------
			miSession.getTransaction().commit();
			miSession.close();
			
		}finally{
			miFactory.close();
		}
	}
}
