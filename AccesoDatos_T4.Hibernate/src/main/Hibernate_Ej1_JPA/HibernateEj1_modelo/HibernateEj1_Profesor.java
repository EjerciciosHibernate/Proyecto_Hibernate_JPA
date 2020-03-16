package HibernateEj1_modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "Profesor")
public class HibernateEj1_Profesor {

	// Hibernate usará el valor de la columna de tipo autoincremento. Es decir que
	// al insertar la fila la base de datos le asignará el valor. La columna de base
	// de datos debe ser de tipo autonumérico
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Type(type = "integer")
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
	@PrimaryKeyJoinColumn // la relación entre las dos tablas se realiza mediante la clave primaria.
	private HibernateEj1_Direccion direccion;

	public HibernateEj1_Profesor(String nombre, String ape1, String ape2, HibernateEj1_Direccion direccion2) {
		super();
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
		this.direccion = direccion2;
	}

	public HibernateEj1_Profesor() {

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

	public HibernateEj1_Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(HibernateEj1_Direccion direccion) {
		this.direccion = direccion;
	}

	public String toString() {

		return "Profesor : " + " idProfesor : " + this.getId() + " Nombre : " + this.getNombre() + " Apellido 1 : "
				+ this.getApe1() + " Apellido 2 : " + this.getApe2() + "\r\n" + this.getDireccion();

	}

}
