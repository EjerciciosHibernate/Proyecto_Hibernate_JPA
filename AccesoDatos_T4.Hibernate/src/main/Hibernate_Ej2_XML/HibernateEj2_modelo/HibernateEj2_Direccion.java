package HibernateEj2_modelo;

public class HibernateEj2_Direccion {

	private int id;
	private String calle;
	private int numero;
	private String poblacion;
	private String provincia;

	public HibernateEj2_Direccion(String calle, int numero, String poblacion, String provincia) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.poblacion = poblacion;
		this.provincia = provincia;
	}
	
	public HibernateEj2_Direccion() {
		
	}

	public int getId() {
		return id;
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

	public void setid(int id) {
		this.id = id;
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

		return "Direccion : " + " id : " + this.getId() + " Calle : " + this.getCalle() + " Numero : "
				+ this.getNumero() + " Poblacion : " + this.getPoblacion() + " Provincia : " + this.getProvincia();

	}

}
