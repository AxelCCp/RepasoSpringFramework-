package es.pildoras.aop.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect 
@Component
@Order(3)
public class A2_82_RequisitosTabla {

	//MÉTODO QUE COMPRUEBA QUE LA TABLA NO TENGA MÁS DE 3000 REGISTROS
		@Before("es.pildoras.aop.aspectos.A0_77_LoginConAspecto.paraClientes()")
		public void requisitosTabla() {
			System.out.println("Hay menos de 3000 registros en la tabla. Puedes insertar el nuevo cliente");
		}
	
}
