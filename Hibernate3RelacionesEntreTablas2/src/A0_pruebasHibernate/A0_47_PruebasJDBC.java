package A0_pruebasHibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class A0_47_PruebasJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//DIRECCI�N DEL SERVIDOR DONDE EST� LA BBDD
		//?useSSL=false : INDICAMOS QUE NO ESTAMOS USANDO "SSL" UN PROTOCOLO DE CONEXI�N SEGURA. 
		String jdbcUrl = "jdbc:mysql://localhost:3306/relacionesHibernet?useSSL=false";
		String usuario ="root";
		String contra = "";
		try {
			System.out.println("Intentando conectar con la BBDD: " + jdbcUrl);
			Connection miConexion = DriverManager.getConnection(jdbcUrl,usuario,contra);
			System.out.println("Conexi�n OK!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
