package HibernateEj1_modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "Direccion")
public class HibernateEj1_Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	@Type(type = "integer")
	private int idDireccion;

	@Column(name = "calle", length = 225)
	@Type(type = "string")
	private String calle;

	@Column(name = "numero")
	@Type(type = "integer")
	private int numero;

	@Column(name = "poblacion", length = 225)
	@Type(type = "string")
	private String poblacion;

	@Column(name = "provincia", length = 225)
	@Type(type = "string")
	private String provincia;

	public HibernateEj1_Direccion(String calle, int numero, String poblacion, String provincia) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.poblacion = poblacion;
		this.provincia = provincia;
	}
	
	public HibernateEj1_Direccion() {
		
	}

	public int getIdDireccion() {
		return idDireccion;
	}

	public String getCalle() {
		return calle;
	}

	public int getNumero() {
		return numero;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String toString() {

		return "Direccion : " + " idDireccion : " + this.getIdDireccion() + " Calle : " + this.getCalle() + " Numero : "
				+ this.getNumero() + " Poblacion : " + this.getPoblacion() + " Provincia : " + this.getProvincia();

	}

}
