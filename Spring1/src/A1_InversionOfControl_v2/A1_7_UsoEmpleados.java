package A1_InversionOfControl_v2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class A1_7_UsoEmpleados {

	public static void main(String[] args) {
		
		
		//1.CARGAR EL ARCHIVO XML
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("A5_8_ApplicationContext.xml");
		
		//2.LE PEDIMOS EL BEAN AL ARCHIVO XML. getBean(id DEL GENERADOR DE BEANS, INTERFAZclass)
		A2_7_Empleados Giru = contexto.getBean("miEmpleado", A2_7_Empleados.class);
		
		//3.USAR EL BEAN
		System.out.println(Giru.getTareas());
		System.out.println(Giru.getInforme());
		
		//----------------------------------------------------------------------------------------
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		//----------------------------------------------------------------------------------------
		
		A2_7_Empleados ulon = contexto.getBean("miEmpleado2", A2_7_Empleados.class);
		System.out.println(ulon.getTareas());
		System.out.println(ulon.getInforme());
		
		//----------------------------------------------------------------------------------------
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		//----------------------------------------------------------------------------------------
		
		//AHORA CREAMOS UN BEAN A PARTIR DE LA CLASE SECRETARIO EMPLEADO, PARA USAR LA INYECCIÓN DE CAMPOS DE EMAIL Y NOMBRE EMPRESA
		A3_7_SecretarioEmpleado puar = contexto.getBean("miEmpleado2", A3_7_SecretarioEmpleado.class);
		System.out.println(puar.getTareas());
		System.out.println(puar.getInforme());
		System.out.println(puar.getEmail());
		System.out.println(puar.getNombreEmpresa());
		
		//----------------------------------------------------------------------------------------
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		//----------------------------------------------------------------------------------------
		
		A4_7_DirectorEmpleado may = contexto.getBean("miEmpleado", A4_7_DirectorEmpleado.class);
		System.out.println(may.getTareas());
		System.out.println(may.getInforme());
		System.out.println(may.getEmail());
		System.out.println(may.getNombreEmpresa());
		
		//----------------------------------------------------------------------------------------
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		//----------------------------------------------------------------------------------------
		
		
		//4.CERRAR XML
		contexto.close();
	}
}
