package HibernateEj3XML_modelo;

public class Profesor {

	private int id;
	private String nombre;
	private String ape1;
	private String ape2;
	private Direccion direccion;

	public Profesor(String nombre, String ape1, String ape2, Direccion direccion) {
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
		this.direccion = direccion;
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

	public String toString() {

		return "Profesor : " + " idProfesor : " + this.getId() + " Nombre : " + this.getNombre() + " Apellido 1 : "
				+ this.getApe1() + " Apellido 2 : " + this.getApe2() + "\r\n" + this.getDireccion();

	}

}
