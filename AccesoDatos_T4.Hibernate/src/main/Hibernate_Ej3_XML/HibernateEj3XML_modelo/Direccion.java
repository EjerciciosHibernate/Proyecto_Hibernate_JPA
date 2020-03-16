package HibernateEj3XML_modelo;

public class Direccion {

	private int direccion_id;
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

	public int getDireccion_id() {
		return direccion_id;
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

	public void setDireccion_id(int direccion_id) {
		this.direccion_id = direccion_id;
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

		return "Direccion : " + " direccion_id : " + this.getDireccion_id() + " Calle : " + this.getCalle() + " Numero : "
				+ this.getNumero() + " Poblacion : " + this.getPoblacion() + " Provincia : " + this.getProvincia();

	}


}
