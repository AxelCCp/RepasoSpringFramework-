package A1_InversionOfControl_v2;

public class A4_7_DirectorEmpleado implements A2_7_Empleados {

	//DESPUES DE CREAR LA INTERFAZ A6_9_CreacionInformes y LA CLASE A7_10_Informe,... 
	//...HAY QUE HACER UN CONTRUCTOR PARA INYECTAR LA DEPENDENCIA. EL OBJ informeNuevo
	public A4_7_DirectorEmpleado(A6_9_CreacionInformes informeNuevo) {
		this.informeNuevo=informeNuevo;
	}
	
	@Override
	public String getTareas() {
		// TODO Auto-generated method stub
		return "Gestionar la plantilla de la empresa";
	}

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		return "Informe Creado por el DIRECTOR: " + informeNuevo.getInforme();
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

	//CLASE 14. MÉTODO INIT()EJECUTAR TAREAS ANTES DE QUE EL BEAN ESTÉ DISPONIBLE. INIT(),GENERALMENTE ES VOID,PERO TAMBN PUEDEN TENER UN RETURN. 
	public void metodoInicial() {
		System.out.println("Dentro del método init. Aquí van las tareas ANTES de que el bean esté listo");
	}
	
	//CLASE 14.METODO DESTROY() EJECUTAR TAREAS DESPUÉS DE QUE ELMBEAN HAYA SIDO USADO
	public void metodoFinal() {
		System.out.println("Dentro del método final. Aquí van las tareas DESPUÉS de usar el bean");
	}
	//-------------------------------------------------
	private A6_9_CreacionInformes informeNuevo;
	//PARA INYECCIÓN DE CAMPOS
	private String email;
	private String nombreEmpresa;
}
