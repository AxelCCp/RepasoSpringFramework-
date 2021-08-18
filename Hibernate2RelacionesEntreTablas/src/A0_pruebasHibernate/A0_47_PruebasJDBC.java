package A0_pruebasHibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class A0_47_PruebasJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//DIRECCIÓN DEL SERVIDOR DONDE ESTÁ LA BBDD
		//?useSSL=false : INDICAMOS QUE NO ESTAMOS USANDO "SSL" UN PROTOCOLO DE CONEXIÓN SEGURA. 
		String jdbcUrl = "jdbc:mysql://localhost:3306/relacionesHibernet?useSSL=false";
		String usuario ="root";
		String contra = "";
		try {
			System.out.println("Intentando conectar con la BBDD: " + jdbcUrl);
			Connection miConexion = DriverManager.getConnection(jdbcUrl,usuario,contra);
			System.out.println("Conexión OK!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
