package A1_conexionHibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity//PARA QUE HIBERNATE HAGA UN MAPEO DE CLASE A TABLA
@Table(name="clientes")//ESPECIFICAMOS LA TABLA A LA QUE NOS REFERIMOS.
public class A0_48_Clientes {
	
	//HACEMOS QUE LA CLASE SEA FUNCIONAL, CREANDO CONSTRUCTORES
	public A0_48_Clientes() {
		super();
	}
	public A0_48_Clientes(String nombre, String apellidos, String direccion) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
	}
	
	//CREAMOS GETTERS Y SETTERS PARA MANIPULAR LAS PROPIEDADES DE LA CLASE
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	@Override
	public String toString() {
		return "A0_48_Clientes [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion="
				+ direccion + "]";
	}


	//@Column : PARA HACER MAPEO DE LAS COLUMNAS DE LA TABLA.
	//@Id : ESPECIFICAMOS QUE ES LLAVE PRIMARIA.
	//@GeneratedValue : LE DECIMOS A HIBERNATE QUE SERÁ CLAVE PRINCIPAL.
	
	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="Nombre")
	private String nombre;
	@Column(name="Apellidos")
	private String apellidos;
	@Column(name="Direccion")
	private String direccion;
}
