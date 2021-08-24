package es.pildoras.aop.aspectos;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import es.pildoras.aop.A2_79_Cliente;

@Aspect //LE INDICAMOS QUE ESTA CLASE ES UN ASPECTO.
@Component //LE INICAMOS QUE ESTA CLASE ES UN COMPONENTE.  
@Order(2)
public class A0_77_LoginConAspecto {

	
	//POINTCUT QUE FUNCIONE A NIVEL DE PAQUETE  
	@Pointcut("execution(*es.pildoras.aop.dao.*.*(..))")
	public void paraClientes() {}
		
	
	// miJoin : ESTABLECEMOS PUNTO DE OBSERVACIÓN
	@Before("paraClientes()")
	public void antesInsertarCliente(JoinPoint miJoin) {
		System.out.println("El usuario está logeado");
		System.out.println("El perfil para insertar clientes es correcto");
		//CAPTURAMOS LOS ARGUMENTOS DEL MÉTODO. DEVUELVE UN ARRAY CON LOS ARGUMENTOS DEL MÉTODO QUE SE EJECUTARÁ A CONTINUACIÓN...
		//... insertarCliente(A2_79_Cliente elCliente, String tipo)
		Object[]argumentos = miJoin.getArgs();
		for(Object temp : argumentos) {
			if(temp instanceof A2_79_Cliente) {
				A2_79_Cliente elCliente = (A2_79_Cliente)temp;
				System.out.println("Nombre del cliente " + elCliente.getNobmre());
				System.out.println("Nombre del cliente " + elCliente.getTipo());
			}
		}
		
	}
	
	
	
	
	
	
}
