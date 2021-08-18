package A1_conexionHibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity//PARA QUE HIBERNATE HAGA UN MAPEO DE CLASE A TABLA
@Table(name="cliente")//ESPECIFICAMOS LA TABLA A LA QUE NOS REFERIMOS.
public class A0_54_Cliente {
	
	//HACEMOS QUE LA CLASE SEA FUNCIONAL, CREANDO CONSTRUCTORES
	public A0_54_Cliente() {
		super();
	}
	public A0_54_Cliente(String nombre, String apellido, String direccion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public A1_54_DetallesCliente getDetallesCliente() {
		return detallesCliente;
	}
	public void setDetallesCliente(A1_54_DetallesCliente detallesCliente) {
		this.detallesCliente = detallesCliente;
	}
	
	
	
	@Override
	public String toString() {
		return "A0_54_Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion
				+ "]";
	}

	
	//HACEMOS EL MAPEO ORM PARA ESTABLECER UNA RELACI�N 1:1 ENTRE LAS TABLAS CLIENTE Y DETALLESCLIENTE
	//ESTABLECEMOS LAS OPERACIONES EN CASCADA.
	//ESTABLECEMOS A TRAV�S DE QUE CAMPO SE RELACIONAN LAS TABLAS.
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	private A1_54_DetallesCliente detallesCliente;


	//@Column : PARA HACER MAPEO DE LAS COLUMNAS DE LA TABLA.
	//@Id : ESPECIFICAMOS QUE ES LLAVE PRIMARIA.
	//@GeneratedValue : LE DECIMOS A HIBERNATE QUE SER� CLAVE PRINCIPAL.
	
	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="direccion")
	private String direccion;
}
