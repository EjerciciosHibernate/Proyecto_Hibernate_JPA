package HibernateEj7_modelo;

import java.io.Serializable;

public class Correo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String direccion;
	private String proveedor;

	public Correo() {

	}

	public Correo(String direccion, String proveedor) {
		this.direccion = direccion;
		this.proveedor = proveedor;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public String toString() {
		return "Correo [id=" + id + ", direccion=" + direccion + ", proveedor=" + proveedor + "]" + "\r\n";
	}

}
