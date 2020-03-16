package HibernateEj2_vista;

import HibernateEj2_modelo.HibernateEj2_Direccion;
import HibernateEj2_modelo.HibernateEj2_Profesor;
import HibernateEj2_modelo.HibernateEj2_ProfesorHibernate;

public class HibernateEj2_ProfesorDemo {

	public static void main(String[] args) {
		HibernateEj2_Profesor HibernateEj2_Profesor = new HibernateEj2_Profesor();
		HibernateEj2_Profesor.setNombre("Fernando");
		HibernateEj2_Profesor.setApe1("Martinez");
		HibernateEj2_Profesor.setApe2("Martin");
		HibernateEj2_Direccion  HibernateEj2_DIreccion = new HibernateEj2_Direccion();
		HibernateEj2_DIreccion.setCalle("Fernando Diaz Mendoza");
		HibernateEj2_DIreccion.setNumero(20);
		HibernateEj2_DIreccion.setPoblacion("Madrid");
		HibernateEj2_DIreccion.setProvincia("Madrid");
		HibernateEj2_Profesor.setDireccion(HibernateEj2_DIreccion);

		System.out.println("----------------- Insertar los datos -----------------");
		HibernateEj2_ProfesorHibernate.insertar(HibernateEj2_Profesor);
		System.out.println("----------------- Leer los datos -----------------");
		System.out.println(HibernateEj2_ProfesorHibernate.leer().toString());
		System.out.println(HibernateEj2_ProfesorHibernate.leerPorID(HibernateEj2_Profesor.getId()).toString());

	}

}
