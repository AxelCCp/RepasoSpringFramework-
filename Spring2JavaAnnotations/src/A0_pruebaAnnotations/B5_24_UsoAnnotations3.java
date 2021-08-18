package A0_pruebaAnnotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class B5_24_UsoAnnotations3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		//LEER EL CLASS DE CONFIGURACIÓN
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(B2_23_EmpleadosConfig.class);
		
		//"directorFinanciero" ES EL NOMBRE DEL MÉTODO CON EL QUE SE HACE LA INYECCIÓN DE LA DEPENDENCIA EN LA CLASE EmpleadosConfig
		A1_16_Empleados empleado = contexto.getBean("directorFinanciero",A1_16_Empleados.class);
		
		System.out.println(empleado.getTareas());
		System.out.println(empleado.getInformes());
		
		
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		
		
		B4_24_DirectorFinanciero empleado2 = contexto.getBean("directorFinanciero", B4_24_DirectorFinanciero.class);
		System.out.println(empleado2.getEmail());
		System.out.println(empleado2.getNombreEmpresa());
		contexto.close();
		
		
	}

}
