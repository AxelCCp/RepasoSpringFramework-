package A0_pruebaAnnotations;

import org.springframework.stereotype.Component;

//ESTAES LA DEPENDENCIA ... A5_17_InformeFinancieroTrim1 implements A4_17_CreacionInformeFinanciero


@Component("InformeFinancieroTrim1")
public class A5_17_InformeFinancieroTrim1 implements A4_17_CreacionInformeFinanciero {

	@Override
	public String getInformeFinanciero() {
		// TODO Auto-generated method stub
		return "Presentación de informe financiero TRIMESTRE 1";
	}

}
