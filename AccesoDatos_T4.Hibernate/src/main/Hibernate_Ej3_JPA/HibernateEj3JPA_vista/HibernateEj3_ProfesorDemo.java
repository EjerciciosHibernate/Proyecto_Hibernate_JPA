package HibernateEj3JPA_vista;

import HibernateEj3JPA_modelo.DireccionFK;
import HibernateEj3JPA_modelo.HibernateEj3_ProfesorHibernate;
import HibernateEj3JPA_modelo.ProfesorFK;

public class HibernateEj3_ProfesorDemo {

	public static void main(String[] args) {

		DireccionFK direccion = new DireccionFK("Arganda", 20, "Madrid", "Madrid");
		ProfesorFK profesor = new ProfesorFK("Miriam", "Garcia", "Gonzalez", direccion);

		HibernateEj3_ProfesorHibernate.insertar(profesor);
		System.out.println(HibernateEj3_ProfesorHibernate.leer().toString());
		System.out.println(HibernateEj3_ProfesorHibernate.leerPorID(1).toString());
	}

}
