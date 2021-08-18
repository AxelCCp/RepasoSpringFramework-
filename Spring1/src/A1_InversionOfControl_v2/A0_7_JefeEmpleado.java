package A1_InversionOfControl_v2;

public class A0_7_JefeEmpleado implements A2_7_Empleados {
	public A0_7_JefeEmpleado(A6_9_CreacionInformes informeNuevo) {
		this.informeNuevo=informeNuevo;
	}
	
	public String getTareas() {
		return "Gestiono las cuestiones relativas a mis empleados de sección"; 
	}

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		return "Informe Creado por el JEFE: " + informeNuevo.getInforme() ;
	}
	
	private A6_9_CreacionInformes informeNuevo;
}
