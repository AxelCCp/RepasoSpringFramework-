package A0_pruebaAnnotations;

import org.springframework.stereotype.Component;

@Component("InformeFinancieroTrim2")
public class A8_20_InformeFinancieroTrim2 implements A4_17_CreacionInformeFinanciero {

	@Override
	public String getInformeFinanciero() {
		// TODO Auto-generated method stub
		return "Presentación de informe financiero catastrófico TRIMESTRE 2";
	}

}
