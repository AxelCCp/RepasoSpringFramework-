package A0_pruebaAnnotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//ESTA CLASE REEMPLAZA AL ARCHIVO XML APPLICATION CONTEXT

@Configuration
@ComponentScan("A0_pruebaAnnotations")     //PARA QUE ESCANEE EL PAQUETE CON LAS CLASES EN BUSCA DE JAVA ANNOTATIONS
@PropertySource("classpath:B6_25_DatosEmpresaPropiedades")   //IMPORTAMOS EL ARCHIVO TXT DE PROPIEDADES 
public class B2_23_EmpleadosConfig {

	//LE DECIMOS A SPRING QUE NOS D� BEANS DE InformeFinancieroDtoCompras y DirectorFinanciero--------------------------
	
	//DEFINIR BEAN PARA  InformeFinancieroDtoCompras / CREAMOS METODO CON EL NOMBRE DEL ID DEL BEAN
	@Bean
	public A4_17_CreacionInformeFinanciero informeFinancieroDtoCompras() {
		return new B3_24_InformeFinancieroDtoCompras();
	}
	
	//DEFINIR BEAN PARA DirectorFinanciero
	//EL CONSTRUCTOR DE DirectorFinanciero, RECIBE POR PAR�METRO EN EL CONSTRUCTOR, UN OBJ DE TIPO InformeFinancieroDtoCompras,...
	//...POR LO TANTO LE PASAMOS LO QUE DEVUELVE EL M�TODO informeFinancieroDtoCompras(). AS� SE CREA LA INYECCI�N DE DEPENDENCIAS.
	@Bean
	public A1_16_Empleados directorFinanciero() {
		return new B4_24_DirectorFinanciero(informeFinancieroDtoCompras());
		
	}
	
}
