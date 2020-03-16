package HibernateEj2_modelo;

public class HibernateEj2_Profesor {

	private int id;
	private String nombre;
	private String ape1;
	private String ape2;
	private HibernateEj2_Direccion direccion;

	public HibernateEj2_Profesor(String nombre, String ape1, String ape2, HibernateEj2_Direccion direccion) {
		super();
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
		this.direccion = direccion;
	}

	public HibernateEj2_Profesor() {

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

	public HibernateEj2_Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(HibernateEj2_Direccion Direccion) {
		this.direccion = Direccion;
	}

	public String toString() {

		return "Profesor : " + " idProfesor : " + this.getId() + " Nombre : " + this.getNombre() + " Apellido 1 : "
				+ this.getApe1() + " Apellido 2 : " + this.getApe2() 
				+ "\r\n" + this.getDireccion().toString()
				+ "\n";

	}

}
