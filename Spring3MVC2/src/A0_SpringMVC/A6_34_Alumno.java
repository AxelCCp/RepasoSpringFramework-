package A0_SpringMVC;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class A6_34_Alumno {
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getOptativa() {
		return optativa;
	}
	public void setOptativa(String optativa) {
		this.optativa = optativa;
	}
	public String getCiudadEstudios() {
		return ciudadEstudios;
	}
	public void setCiudadEstudios(String ciudadEstudios) {
		this.ciudadEstudios = ciudadEstudios;
	}
	public String getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}


	@NotNull
	@Size(min=2, message="Campo requerido")  //(MÍNIMO 2 CARACTERES, MENSAJE QUE APARECERÁ EN CASO DE ERROR)
	private String nombre;
	private String apellido;
	private String optativa;
	private String ciudadEstudios; 
	private String idiomas;
	

}
