package es.pildoras.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration //INDICAMOS QUE ES UN ARCHIVO DE CONFIGURACI�N 
@EnableAspectJAutoProxy //LE INDICAMOS QUE VAMOS A USAR LA AOP,PARA QUE HABILITE ESTA FUNCIONALIDAD 
@ComponentScan("es.pildoras.aop")//LE INDICAMOS D�NDE DEBE IR A BUSCAR LOS ASPECTOS.
public class A0_77_Configuracion {

}
