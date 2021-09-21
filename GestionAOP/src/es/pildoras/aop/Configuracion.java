package es.pildoras.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy //LE DECIMOS QUE SE USARÁ AOP.
@ComponentScan("es.pildoras.aop")  //INDICA DONDE DEBE IR A BUSCAR LOS ASPECTOS. 
public class Configuracion {

}
