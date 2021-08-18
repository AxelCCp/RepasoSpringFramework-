package A0_pruebaAnnotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class B1_21_UsoAnnotations2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("A0_15_ApplicationContext.xml");
		
		//LEER EL CLASS DE CONFIGURACIÓN
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(B2_23_EmpleadosConfig.class);
		
		A1_16_Empleados may = contexto.getBean("ComercialExperimentado", A1_16_Empleados.class);
		A1_16_Empleados bra = contexto.getBean("ComercialExperimentado", A1_16_Empleados.class);
		
		System.out.println(may);
		System.out.println(bra);
		
		
		contexto.close();
		
		
	}

}
