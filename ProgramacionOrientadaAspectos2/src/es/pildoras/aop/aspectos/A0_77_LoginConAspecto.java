package es.pildoras.aop.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect //LE INDICAMOS QUE ESTA CLASE ES UN ASPECTO.
@Component //LE INICAMOS QUE ESTA CLASE ES UN COMPONENTE.  
public class A0_77_LoginConAspecto {

	
	//POINTCUT QUE FUNCIONE A NIVEL DE PAQUETE  
	@Pointcut("execution(*es.pildoras.aop.dao.*.*(..))")
	private void paraClientes() {}
	
	
	//POINTCUT SOLO PARA GETTERS
	@Pointcut("execution(*es.pildoras.aop.dao.*.get*(..))")
	private void paraGetters() {}
	
	//POINTCUT SOLO PARA Setters
	@Pointcut("execution(*es.pildoras.aop.dao.*.set*(..))")
	private void paraSetters() {}
	
	
	//COMBINACIÓN DE POINTCUTS : MENOS PARA GETTERS O PARA SETTERS
	@Pointcut("paraClientes() && !(paraGetters() || paraSetters())")
	private void paqueteExceptoGetSet() {}
	
	
	//AQUÍ DEBE IR EL CÓDIGO DE LAS COMPROBACIONES DEL LOGIN VALIDO 
	//	@Before: PARA QUE EL MÉTODO SE EJECUTE ANTES DE INSERTAR AL CLIENTE. 
	//... E INDICAMOS EL MÉTODO QUE SE EJECUTARÁ DESPUÉS DE LA COMPROBACIÓN DE ESTE ASPECTO.
	//...es.pildoras.aop.dao.A1_78_ClienteVipDAO : ES LA RUTA DEL MÉTODO QUE LLEVARÁ COMPROVACIÓN (ASPECTO) CON @Before. 
	//...SINO SE PONE LA RUTA, EJECUTARÁ TODOS LOS METODOS QUE TENGAN EL MISMO NOMBRE, EL DE A0_77_ClienteDAO Y A1_78_ClienteVipDAO.
	
	//@Before("execution(public void es.pildoras.aop.dao.A1_78_ClienteVipDAO.insertarCliente())")
	
	//@Before("execution(public void insertar*())") //CON ESTA NOTACIÓN " * " SE APLICARÁ EL ASPECTO A TODOS LO METODOS QUE EMPIECEN POR "INSERTAR" 
	
	//@Before("execution(public * insertar*())")  //SI TENEMOS VARIOS MÉTODOS CON = NOMBRE, PERO VOID O DE != TIPO, PODEMOS PONER UN ASTERISCO EN VEZ UN TIPO O VOID.
	
	//@Before("execution(public void insertarCliente())")
	
	//@Before("execution(public * insertar*(..))") //PARA METODOS DE CUALQUIER TIPO Y DIFERENTE NÚMERO DE PARÁMETROS. 
	
	//@Before("execution(public * insertar*(es.pildoras.aop.A2_79_Cliente,..))") //INDICAMOS QUE UNO DE LOS MÉTODOS RECIBE UN ARGUMENTO DE TIPO A2_79_Cliente. CON " .." INDICAMOS QUE RECIBE OTRO PARÁMETRO MÁS.
	
	//@Before("paraClientes()")
	@Before("paraGetters()")
	public void antesInsertarCliente() {
		
		System.out.println("El usuario está logeado");
		System.out.println("El perfil para insertar clientes es correcto");
	}
	
	
	//MÉTODO QUE COMPRUEBA REQUISITOS DEL CLIENTE QUE SE VA A INGRESAR A LA BASE DE DATOS 
	@Before("paqueteExceptoGetSet()")
	public void requisitosCliente() {
		//60 LÍNEAS DE CÓDIGO
		System.out.println("El cliente cumple los requisitos para ser insertado en la BBDD");
	}
	
	
	//MÉTODO QUE COMPRUEBA QUE LA TABLA NO TENGA MÁS DE 3000 REGISTROS
	//@Before("paraClientes()")
	public void requisitosTabla() {
		System.out.println("Hay menos de 3000 registros en la tabla. Puedes insertar el nuevo cliente");
	}
}
