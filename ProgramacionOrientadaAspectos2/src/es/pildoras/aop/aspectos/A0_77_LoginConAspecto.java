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
	
	
	//COMBINACI�N DE POINTCUTS : MENOS PARA GETTERS O PARA SETTERS
	@Pointcut("paraClientes() && !(paraGetters() || paraSetters())")
	private void paqueteExceptoGetSet() {}
	
	
	//AQU� DEBE IR EL C�DIGO DE LAS COMPROBACIONES DEL LOGIN VALIDO 
	//	@Before: PARA QUE EL M�TODO SE EJECUTE ANTES DE INSERTAR AL CLIENTE. 
	//... E INDICAMOS EL M�TODO QUE SE EJECUTAR� DESPU�S DE LA COMPROBACI�N DE ESTE ASPECTO.
	//...es.pildoras.aop.dao.A1_78_ClienteVipDAO : ES LA RUTA DEL M�TODO QUE LLEVAR� COMPROVACI�N (ASPECTO) CON @Before. 
	//...SINO SE PONE LA RUTA, EJECUTAR� TODOS LOS METODOS QUE TENGAN EL MISMO NOMBRE, EL DE A0_77_ClienteDAO Y A1_78_ClienteVipDAO.
	
	//@Before("execution(public void es.pildoras.aop.dao.A1_78_ClienteVipDAO.insertarCliente())")
	
	//@Before("execution(public void insertar*())") //CON ESTA NOTACI�N " * " SE APLICAR� EL ASPECTO A TODOS LO METODOS QUE EMPIECEN POR "INSERTAR" 
	
	//@Before("execution(public * insertar*())")  //SI TENEMOS VARIOS M�TODOS CON = NOMBRE, PERO VOID O DE != TIPO, PODEMOS PONER UN ASTERISCO EN VEZ UN TIPO O VOID.
	
	//@Before("execution(public void insertarCliente())")
	
	//@Before("execution(public * insertar*(..))") //PARA METODOS DE CUALQUIER TIPO Y DIFERENTE N�MERO DE PAR�METROS. 
	
	//@Before("execution(public * insertar*(es.pildoras.aop.A2_79_Cliente,..))") //INDICAMOS QUE UNO DE LOS M�TODOS RECIBE UN ARGUMENTO DE TIPO A2_79_Cliente. CON " .." INDICAMOS QUE RECIBE OTRO PAR�METRO M�S.
	
	//@Before("paraClientes()")
	@Before("paraGetters()")
	public void antesInsertarCliente() {
		
		System.out.println("El usuario est� logeado");
		System.out.println("El perfil para insertar clientes es correcto");
	}
	
	
	//M�TODO QUE COMPRUEBA REQUISITOS DEL CLIENTE QUE SE VA A INGRESAR A LA BASE DE DATOS 
	@Before("paqueteExceptoGetSet()")
	public void requisitosCliente() {
		//60 L�NEAS DE C�DIGO
		System.out.println("El cliente cumple los requisitos para ser insertado en la BBDD");
	}
	
	
	//M�TODO QUE COMPRUEBA QUE LA TABLA NO TENGA M�S DE 3000 REGISTROS
	//@Before("paraClientes()")
	public void requisitosTabla() {
		System.out.println("Hay menos de 3000 registros en la tabla. Puedes insertar el nuevo cliente");
	}
}
