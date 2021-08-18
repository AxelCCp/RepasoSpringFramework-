package A1_InversionOfControl_v2;

public class A3_7_SecretarioEmpleado implements A2_7_Empleados {

	//EN VEZ DE UN CONSTRUCTOR, USAMOS UN SETTER
	public void setInformeNuevo(A6_9_CreacionInformes informeNuevo) {
		this.informeNuevo = informeNuevo;
	}
	
	//-------------------------------------------------
	@Override
	public String getTareas() {
		// TODO Auto-generated method stub
		return "Gestionar la agenda de los jefes";
	}
	
	//-------------------------------------------------
	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		return "Informe generado por SECRETARÍA: " + informeNuevo.getInforme();
	}
	
	//-------------------------------------------------
	
	public String getEmail() {
		return "Email: " + email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreEmpresa() {
		return "Nombre de Empresa: " +  nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	
	//-------------------------------------------------
	//PARA INYECCIÓN DE INFORME
	private A6_9_CreacionInformes informeNuevo;
	
	//PARA INYECCIÓN DE CAMPOS
	private String email;
	private String nombreEmpresa;
}
