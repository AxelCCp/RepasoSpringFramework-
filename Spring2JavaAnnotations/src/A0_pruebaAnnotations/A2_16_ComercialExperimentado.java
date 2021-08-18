package A0_pruebaAnnotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("ComercialExperimentado")
@Scope("singleton")
public class A2_16_ComercialExperimentado implements A1_16_Empleados {	

	
	//EJECUCIÓN DE CÓDIGO DESPUÉS DE CREACIÓN DEL BEAN -------------------------------------------------------
	@PostConstruct
	public void ejecutaDespuesCreacion() {
		System.out.println("Ejecutado tras creación de bean");
	}
	
	//EJECUCIÓN DE CÓDIGO DESPUES DE APAGADO CONTENEDOR SPRING-----------------------------------------------
	@PreDestroy
	public void ejecutaAntesDestruccion() {
		System.out.println("Ejecutado antes de la destrucción");
	}
	
	
	//INYECCIÓN DE DEPENDENCIAS CON CONSTRUCTOR------------------------------------------------------- 
	/*@Autowired
	public A2_16_ComercialExperimentado(A4_17_CreacionInformeFinanciero nuevoInforme) {
		super();
		this.nuevoInforme = nuevoInforme;
	}*/
	
	
	//INYECCIÓN DE DEPENDENCIAS CON SETTER------------------------------------------------------------
	/*@Autowired
	@Qualifier("InformeFinancieroTrim2")
	public void setNuevoInforme(A4_17_CreacionInformeFinanciero nuevoInforme) {
		this.nuevoInforme = nuevoInforme;
	}*/
	

	@Override
	public String getTareas() {
		// TODO Auto-generated method stub
		return "Vender, vender, vender, ...";
	}

	@Override
	public String getInformes() {
		return nuevoInforme.getInformeFinanciero();
	}
	

	//INYECCIÓN DE DEPENDENCIAS CON CAMPO DE CLASE----------------------------------------------------
	@Autowired
	@Qualifier("InformeFinancieroTrim3")
	private A4_17_CreacionInformeFinanciero nuevoInforme;
}
