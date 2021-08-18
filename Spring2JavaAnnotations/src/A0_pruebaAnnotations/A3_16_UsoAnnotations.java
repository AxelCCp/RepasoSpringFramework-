package A0_pruebaAnnotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class A3_16_UsoAnnotations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//LEER XML DE CONFIGURACIÓN
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("A0_15_ApplicationContext.xml");
		
		//PEDIR BEAN AL CONTENEDOR XML, ESCRIBIMOS LA JAVA ANNOTATION DEL BEAN QUE QUEREMOS
		// A1_16_Empleados Giru = contexto.getBean("ComercialExperimentado", A1_16_Empleados.class);
		
		//USAR BEAN
		//System.out.println(Giru.getTareas());
		//System.out.println(Giru.getInformes());
		
		//-------------------------------------------------------------------------------
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		//-------------------------------------------------------------------------------
		
		//A1_16_Empleados Pilaf = contexto.getBean("ComercialExperimentado2", A1_16_Empleados.class);
		//System.out.println(Pilaf.getTareas());
		//System.out.println(Pilaf.getInformes());
		
		//-------------------------------------------------------------------------------
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		//-------------------------------------------------------------------------------
				
		A1_16_Empleados may = contexto.getBean("ComercialExperimentado", A1_16_Empleados.class);
		System.out.println(may.getTareas());
		System.out.println(may.getInformes());
		
		//CERRAR CONTEXTO
		contexto.close();
	}

}
