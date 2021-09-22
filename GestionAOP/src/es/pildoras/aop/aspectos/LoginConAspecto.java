package es.pildoras.aop.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect  //LE INDICAMOS QUE ES UN ASPECTO
@Component
public class LoginConAspecto {
	
	//LE INDICAMOS QUE IRÁ ANTES DE insertaClienteVip() DE LA CLASE ClienteVipDAO.
	//@Before("execution(public void es.pildoras.aop.dao.ClienteVipDAO.insertaClienteVip())")  
	//PARA QUE APLIQUE EL ASPECTO A TODOS LOS MÉTODOS QUE EMPIECEN POR insertaCliente...
	//@Before("execution(public void insertaCliente*())")  
	//@Before("execution(public String insertaCliente*())")  
	//@Before("execution(public * insertaCliente*())")
	//@Before("execution(public * insertaCliente*(es.pildoras.aop.Cliente))")  
	//@Before("execution(public * insertaCliente*(es.pildoras.aop.Cliente, ..))")  
	
	//DECLARACIÓN DEL POINTCUT
	@Pointcut("execution(public * insertaCliente*(..))")  
	private void paraClientes() {}
	
	@Before("paraClientes()")  
	public void antesInsertarCliente() {
		System.out.println("El usuario está logeado");
		System.out.println("El perfil para insertar clientes es correcto");
	}
	@Before("paraClientes()")  
	public void requisitosCliente() {
		System.out.println("El Cliente cumple con los requisitos para ser insertado en la base de datos");
	}
	@Before("paraClientes()")  
	public void requisitosTabla() {
		System.out.println("Hay menos de 3000 registros en la tabla. Puede insertar el nuevo cliente");
	}
	

}
