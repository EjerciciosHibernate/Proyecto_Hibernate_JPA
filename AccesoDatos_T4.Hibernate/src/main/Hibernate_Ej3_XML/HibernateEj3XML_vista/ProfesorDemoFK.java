package HibernateEj3XML_vista;

import HibernateEj3XML_modelo.Direccion;
import HibernateEj3XML_modelo.Profesor;
import HibernateEj3XML_modelo.ProfesorHibernateFK;

public class ProfesorDemoFK {

	public static void main(String[] args) {

		Direccion direccion = new Direccion();
		direccion.setCalle("Fernando Diaz Mendoza");
		direccion.setNumero(20);
		direccion.setPoblacion("Madrid");
		direccion.setProvincia("Madrid");
		Profesor profesor = new Profesor("Fernando", "Martinez", "Martin", direccion);

		System.out.println("-----------------------------Insertar los datos-----------------------------");
		ProfesorHibernateFK.insertar(profesor);
		
		System.out.println();
		System.out.println("-----------------------------Leer los datos-----------------------------");
		ProfesorHibernateFK.leerf();
		
		Profesor p = ProfesorHibernateFK.leerPorID(2);
		System.out.println(p.toString());
		
	}

}
