package es.pildoras.aop.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect 
@Component
@Order(1)
public class A1_82_RequesitosCliente {

	//MÉTODO QUE COMPRUEBA REQUISITOS DEL CLIENTE QUE SE VA A INGRESAR A LA BASE DE DATOS 
		@Before("es.pildoras.aop.aspectos.A0_77_LoginConAspecto.paraClientes()")
		public void requisitosCliente() {
			//60 LÍNEAS DE CÓDIGO
			System.out.println("El cliente cumple los requisitos para ser insertado en la BBDD");
		}
	
}
