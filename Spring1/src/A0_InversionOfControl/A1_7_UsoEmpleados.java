package A0_InversionOfControl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class A1_7_UsoEmpleados {

	public static void main(String[] args) {
		
		
		//1.CARGAR EL ARCHIVO XML
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("A5_8_ApplicationContext.xml");
		
		//2.LE PEDIMOS EL BEAN AL ARCHIVO XML. getBean(id DEL GENERADOR DE BEANS, INTERFAZclass)
		A2_7_Empleados Giru = contexto.getBean("miEmpleado", A2_7_Empleados.class);
		
		//3.USAR EL BEAN
		System.out.println(Giru.getTareas());
		
		//4.CERRAR XML
		contexto.close();
	}
}
