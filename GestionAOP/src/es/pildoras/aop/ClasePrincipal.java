package es.pildoras.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.pildoras.aop.dao.ClienteDAO;
import es.pildoras.aop.dao.ClienteVipDAO;

public class ClasePrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//LEER LA CONFIGURACIÓN DE SPRING
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);
		//OBTENER EL BEAN DEL CONTENEDOR DE SPRING
		ClienteDAO elCliente = contexto.getBean("clienteDAO",ClienteDAO.class);
		ClienteVipDAO elClienteVip = contexto.getBean("clienteVipDAO",ClienteVipDAO.class);
		
		//LLAMAR AL MÉTODO
		Cliente cl1 = new Cliente();
		elCliente.insertaCliente(cl1,"Normal");
		
		elClienteVip.insertaClienteVip();
		
		//CERRAR EL CONTEXTO	
		contexto.close();
	}

}
