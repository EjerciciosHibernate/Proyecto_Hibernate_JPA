package HibernateEj8_modelo;

import java.io.Serializable;

public class Direccion implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private int idDireccion;
	private String calle;
	private int numero;
	private String poblacion;
	private String provincia;

	public Direccion(String calle, int numero, String poblacion, String provincia) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.poblacion = poblacion;
		this.provincia = provincia;
	}
	
	public Direccion() {
		
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
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

		return "Direccion [ " + " idDireccion : " + idDireccion + " Calle : " + calle + " Numero : "
				+numero + " Poblacion : " + poblacion + " Provincia : " + provincia + " ]";

	}


}
