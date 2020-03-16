package HibernateEj7_modelo;

import java.io.Serializable;
import java.util.List;


public class Profesor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private String nombre;

	private String ape1;

	private String ape2;

	private Direccion direccion;

	private Modulo modulo;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public String toString() {

		return "Profesor : " + " idProfesor : " + this.getId() + " Nombre : " + this.getNombre() + " Apellido 1 : "
				+ this.getApe1() + " Apellido 2 : " + this.getApe2() 
				+ "\r\n" + this.getDireccion().toString()
				+ "\r\n" + this.getModulo().toString()
				+ "\r\n" + this.getListaCorreo().toString()
				+ "\r\n";

	}

}
