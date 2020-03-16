package HibernateEj7_vista;

import java.util.ArrayList;

import java.util.List;

import HibernateEj7_modelo.Correo;
import HibernateEj7_modelo.Direccion;
import HibernateEj7_modelo.Modulo;
import HibernateEj7_modelo.Profesor;
import HibernateEj7_modelo.ProfesorHibernate;

public class ProfesorDemo {

	public static void main(String[] args) {

		Direccion direccion = new Direccion();
		direccion.setCalle("Mercedes");
		direccion.setNumero(3);
		direccion.setPoblacion("Sevilla");
		direccion.setProvincia("Sevilla");

		Modulo modulo = new Modulo();
		modulo.setNombre("Matematica");
		modulo.setCreditos(3000);

		List<Correo> listaCorreo = new ArrayList<Correo>();
		listaCorreo.add(new Correo("Miriam@educa.org", "EducaMadrid"));
		listaCorreo.add(new Correo("Miriam2@gmail.com", "Gmail"));

		Profesor profesor = new Profesor("Miriam", "Garcia", "Gonzalez", direccion, modulo);

		profesor.setListaCorreo(listaCorreo);
		
		ProfesorHibernate.insertar(profesor);
		System.out.println(ProfesorHibernate.leer().toString());
		
		Direccion direccion2 = new Direccion("Fernandez Mendoza", 10, "Madrid", "Madrid");

		List<Correo> listaCorreo2 = new ArrayList<Correo>();
		listaCorreo2.add(new Correo("JoseGarcia@educa.org", "EducaMadrid"));
		listaCorreo2.add(new Correo("JoseGarcia222@gmail.com", "Gmail"));

		Profesor profesor2 = new Profesor("Jose", "Garcia", "Martin", direccion2, modulo);
		profesor2.setListaCorreo(listaCorreo2);


		ProfesorHibernate.insertar(profesor2);
		System.out.println();
		System.out.println(ProfesorHibernate.leer().toString());
		
		System.out.println(ProfesorHibernate.leerPorID(4).toString());
	}

}
