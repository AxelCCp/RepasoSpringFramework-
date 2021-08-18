package A1_InversionOfControl_v2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class B3_14_UsoCicloVidaBean {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1.CARGAR XML CONFIGURCIÓN
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("B2_14_ApplicationContext3.xml");
		
		//2.PEDIR BEAN
		
		A2_7_Empleados pilaf = contexto.getBean("miEmpleado",A2_7_Empleados.class);
		
		System.out.println(pilaf.getInforme());
		
		contexto.close();
	}
}
