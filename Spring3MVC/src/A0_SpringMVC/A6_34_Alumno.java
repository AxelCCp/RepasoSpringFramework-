package A0_SpringMVC;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}



	@NotNull
	@Size(min=2, message="Campo requerido")  //(M�NIMO 2 CARACTERES, MENSAJE QUE APARECER� EN CASO DE ERROR)
	private String nombre;
	
	private String apellido;
	
	@Min(value=10, message="Est�s muy chico")
	@Max(value=100,message="Est�s muy viejo")
	private int edad;
	
	private String optativa;
	private String ciudadEstudios; 
	private String idiomas;
	
	@Email
	private String email;
	
	@Pattern(regexp = "[0-9]{5}", message="Solo 5 valores num�ricos")
	private String codigoPostal;
	
	

}
