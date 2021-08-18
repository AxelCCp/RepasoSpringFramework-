package A1_conexionHibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity//PARA QUE HIBERNATE HAGA UN MAPEO DE CLASE A TABLA
@Table(name="detalles_cliente")//ESPECIFICAMOS LA TABLA A LA QUE NOS REFERIMOS.
public class A1_54_DetallesCliente {
	
	//HACEMOS QUE LA CLASE SEA FUNCIONAL, CREANDO CONSTRUCTORES
	public A1_54_DetallesCliente() {
		super();
	}
	
	
	public A1_54_DetallesCliente(String web, String tfno, String comentarios) {
		super();
		this.web = web;
		this.tfno = tfno;
		this.comentarios = comentarios;
	}


	//CREAMOS GETTERS Y SETTERS PARA MANIPULAR LAS PROPIEDADES DE LA CLASE
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public String getTfno() {
		return tfno;
	}
	public void setTfno(String tfno) {
		this.tfno = tfno;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public A0_54_Cliente getElCliente() {
		return elCliente;
	}
	public void setElCliente(A0_54_Cliente elCliente) {
		this.elCliente = elCliente;
	}

	//(CLASE 57)
	@Override
	public String toString() {
		return "A1_54_DetallesCliente [id=" + id + ", web=" + web + ", tfno=" + tfno + ", comentarios=" + comentarios
				+ "]";
	}
	
	
	//(CLASE 57) PARA HACER MAPEO BIDIRECCIONAL 
	@OneToOne(mappedBy="detallesCliente", cascade=CascadeType.ALL)
	private A0_54_Cliente elCliente;
	
	
	/*//(CLASE 59) PARA ELIMINAR SOLO DETALLES DE CLIENTE CON LA CLASE A6_59_EliminaDetallesCliente 
	@OneToOne(mappedBy="detallesCliente")
	private A0_54_Cliente elCliente;
	*/
	
	
	//@Column : PARA HACER MAPEO DE LAS COLUMNAS DE LA TABLA.
	//@Id : ESPECIFICAMOS QUE ES LLAVE PRIMARIA.
	//@GeneratedValue : LE DECIMOS A HIBERNATE QUE SERÁ CLAVE PRINCIPAL.
	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="web")
	private String web;
	@Column(name="tfno")
	private String tfno;
	@Column(name="comentarios")
	private String comentarios;
}
