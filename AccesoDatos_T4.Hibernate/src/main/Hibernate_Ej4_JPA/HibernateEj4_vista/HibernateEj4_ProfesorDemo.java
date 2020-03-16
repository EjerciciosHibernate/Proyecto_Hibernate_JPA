package HibernateEj4_vista;

import HibernateEj4_Modelo.Direccion;
import HibernateEj4_Modelo.Modulo;
import HibernateEj4_Modelo.Profesor;
import HibernateEj4_Modelo.ProfesorHibernate;

public class HibernateEj4_ProfesorDemo {

	public static void main(String[] args) {

		Direccion direccion = new Direccion("Arganda", 20, "Madrid", "Madrid");
		Modulo modulo = new Modulo();
		modulo.setNombre("Matematica");
		modulo.setCreditos(3000);
		Profesor profesor = new Profesor("Miriam", "Garcia", "Gonzalez", direccion, modulo);

		ProfesorHibernate.insertar(profesor);
		System.out.println();
		System.out.println(ProfesorHibernate.leer().toString());
		System.out.println();
		System.out.println();

		Direccion direccion2 = new Direccion("Fernandez Mendoza", 10, "Madrid", "Madrid");
		Profesor profesor2 = new Profesor("Jose", "Garcia", "Martin", direccion2, modulo);

		ProfesorHibernate.insertar(profesor2);
		System.out.println();
		System.out.println(ProfesorHibernate.leer().toString());

		System.out.println();
		System.out.println();

		System.out.println(ProfesorHibernate.leerPorID(3).toString());
	}

}
