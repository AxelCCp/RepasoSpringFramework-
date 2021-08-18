package A0_pruebaAnnotations;

import org.springframework.beans.factory.annotation.Value;

public class B4_24_DirectorFinanciero implements A1_16_Empleados {
	
	//----------------------------------------------------------------------------------------------------------------
	public B4_24_DirectorFinanciero(A4_17_CreacionInformeFinanciero informeFinanciero) {
		super();
		this.informeFinanciero = informeFinanciero;
	}
	//----------------------------------------------------------------------------------------------------------------

	@Override
	public String getTareas() {
		// TODO Auto-generated method stub
		return "Gestión y dirección de operaciones financieras de la empresa";
	}
	//----------------------------------------------------------------------------------------------------------------
	@Override
	public String getInformes() {
		// TODO Auto-generated method stub
		return informeFinanciero.getInformeFinanciero();
	}
	//----------------------------------------------------------------------------------------------------------------
	
	
	public String getEmail() {
		return email;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}



	private A4_17_CreacionInformeFinanciero informeFinanciero;
	@Value("${email}")//PARA INYECTAR LOS VALORES QUE ESTAN EN EL ARCHIVO B6_15_DatosEmpresaPropiedades, LE PONEMOS LOS NOMBRES QE ESTÁN EN ESTE ARCHIVO 
	private String email;
	@Value("${nombreEmpresa}")
	private String nombreEmpresa;
	
}
