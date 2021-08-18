package A1_conexionHibernate;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="pedido")
public class A7_60_Pedido {

	
	public A7_60_Pedido() {
		
	}
	
	public A7_60_Pedido(GregorianCalendar fecha) {
		super();
		this.fecha = fecha;
	}
	
	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public A0_54_Cliente getCliente() {
		return cliente;
	}

	public void setCliente(A0_54_Cliente cliente) {
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "A7_60_Pedido [id=" + id + ", fecha=" + fecha + ", formaPago=" + formaPago + "]";
	}




	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="FECHA")
	private GregorianCalendar fecha;
	@Column(name="FORMA_PAGO")
	private String formaPago;
	
	//ESTABLECEMOS DIRECCIÓN DE VARIOS A UNO, DE PEDIDOS A CLIENTE 
	//ESPECIFICAMOS CON LAS CASCADAS QUE NO QUEREMOS ELIMINAR EN CASCADA
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH,CascadeType.REFRESH})
	//@JoinColumn : RELACIONAMOS LA TABLA DE PEDIDO CON LA DE CLIENTE A TRAVÉS DEL CAMPO CLIENTE_ID
	@JoinColumn(name="CLIENTE_ID")
	private A0_54_Cliente cliente;

}
