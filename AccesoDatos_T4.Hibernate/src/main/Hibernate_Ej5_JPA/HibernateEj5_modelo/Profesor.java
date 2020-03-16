package HibernateEj5_modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "Profesor", uniqueConstraints = @UniqueConstraint(columnNames = { "ID" }))
public class Profesor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Hibernate usará el valor de la columna de tipo autoincremento. Es decir que
	// al insertar la fila la base de datos le asignará el valor. La columna de base
	// de datos debe ser de tipo autonumérico
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true, insertable = false, updatable = false)
	private int id;

	@Column(name = "nombre", length = 255)
	@Type(type = "string")
	private String nombre;

	@Column(name = "ape1", length = 255)
	@Type(type = "string")
	private String ape1;

	@Column(name = "ape2", length = 255)
	@Type(type = "string")
	private String ape2;

	@OneToOne(cascade = CascadeType.ALL) // la relación uno a uno de las 2 tablas.
	@JoinColumn(name = "direccion_id") // la relación entre las dos tablas se realiza mediante la clave primaria.
	private Direccion direccion;

	@ManyToOne(cascade = CascadeType.ALL) // un modulo, n profesor.
	@JoinColumn(name = "modulo_id", nullable = false)
	private Modulo modulo;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // un profesor n correo
	@JoinColumn(name = "idProfesor", nullable = false)
	private List<Correo> listaCorreo;

	public Profesor(String nombre, String ape1, String ape2, Direccion direccion2, Modulo modulo) {
		super();
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
		this.direccion = direccion2;
		this.modulo = modulo;
	}

	public Profesor() {

	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApe1() {
		return ape1;
	}

	public String getApe2() {
		return ape2;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public List<Correo> getListaCorreo() {
		return listaCorreo;
	}

	public void setListaCorreo(List<Correo> listaCorreo) {
		this.listaCorreo = listaCorreo;
	}

	public String toString() {

		return "Profesor : " + " idProfesor : " + this.getId() + " Nombre : " + this.getNombre() + " Apellido 1 : "
				+ this.getApe1() + " Apellido 2 : " + this.getApe2() 
				+ "\r\n" + this.getDireccion() 
				+ "\r\n" + this.getModulo()
				+ "\r\n" + this.getListaCorreo().toString() 
				+ "\r\n";

	}

}
