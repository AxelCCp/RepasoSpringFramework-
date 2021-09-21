package es.pildoras.aop.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect  //LE INDICAMOS QUE ES UN ASPECTO
@Component
public class LoginConAspecto {
	
	//LE INDICAMOS QUE IR� ANTES DE insertaClienteVip() DE LA CLASE ClienteVipDAO.
	//@Before("execution(public void es.pildoras.aop.dao.ClienteVipDAO.insertaClienteVip())")  
	
	//PARA QUE APLIQUE EL ASPECTO A TODOS LOS M�TODOS QUE EMPIECEN POR insertaCliente...
	@Before("execution(public void insertaCliente*())")  
	public void antesInsertarCliente() {
		System.out.println("El usuario est� logeado");
		System.out.println("El perfil para insertar clientes es correcto");
	}

}
