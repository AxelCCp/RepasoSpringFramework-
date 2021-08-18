package A0_pruebaAnnotations;

import org.springframework.stereotype.Component;

@Component("InformeFinancieroTrim3")
public class A9_20_InformeFinancieroTrim3 implements A4_17_CreacionInformeFinanciero {

	@Override
	public String getInformeFinanciero() {
		// TODO Auto-generated method stub
		return "Presentación de informe financiero favorable TRIMESTRE 3";
	}

}
