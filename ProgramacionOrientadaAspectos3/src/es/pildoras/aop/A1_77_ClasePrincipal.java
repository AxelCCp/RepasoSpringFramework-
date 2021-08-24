package es.pildoras.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.pildoras.aop.dao.A0_77_ClienteDAO;
import es.pildoras.aop.dao.A1_78_ClienteVipDAO;


public class A1_77_ClasePrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//LEER LA CONFIGURACIÓN DE SPRING
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(A0_77_Configuracion.class);
		//OBTENER EL BEAN DEL CONTENEDOR DE SPRING. "a0_77_ClienteDAO" : DEBE LLAMARSE = A LA CLASE, PERO CON LA 1RA LETRA EN MINÚSCULA.
		A0_77_ClienteDAO elCliente = contexto.getBean("a0_77_ClienteDAO", A0_77_ClienteDAO.class);
		A1_78_ClienteVipDAO elClienteVip = contexto.getBean("a1_78_ClienteVipDAO", A1_78_ClienteVipDAO.class);
		
		elClienteVip.insertarCliente();
		System.out.println(":::::::::::::::::::::::::");
		
		A2_79_Cliente cl1 = new A2_79_Cliente();
		cl1.setNobmre("Giru Giru");
		cl1.setTipo("Normal");
		elCliente.insertarCliente(cl1,cl1.getTipo());
		System.out.println(":::::::::::::::::::::::::");
		
		//CERRAR EL CONTEXTO
		contexto.close();

	}

}
