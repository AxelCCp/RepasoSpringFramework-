package A1_InversionOfControl_v2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class B1_13_UsoDemoSingletonPrototype {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1.CARGAR EL ARCHIVO XML
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("B0_13_ApplicationContext2.xml");
		
		//PIDO BEANS AL ARCHIVO XML
		A3_7_SecretarioEmpleado ulon = contexto.getBean("miEmpleado2", A3_7_SecretarioEmpleado.class);
		A3_7_SecretarioEmpleado puar = contexto.getBean("miEmpleado2", A3_7_SecretarioEmpleado.class);
		
		System.out.println(ulon);
		System.out.println(puar);
	}

}
