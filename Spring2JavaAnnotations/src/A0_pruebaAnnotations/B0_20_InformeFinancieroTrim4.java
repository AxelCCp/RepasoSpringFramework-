package A0_pruebaAnnotations;

import org.springframework.stereotype.Component;

@Component("InformeFinancieroTrim4")
public class B0_20_InformeFinancieroTrim4 implements A4_17_CreacionInformeFinanciero {

	@Override
	public String getInformeFinanciero() {
		// TODO Auto-generated method stub
		return "Presentación de informe financiero cierre de año TRIMESTRE 4";
	}

}
