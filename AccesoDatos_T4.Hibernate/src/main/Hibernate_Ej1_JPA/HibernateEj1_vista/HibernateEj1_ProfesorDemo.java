package HibernateEj1_vista;

import HibernateEj1_modelo.HibernateEj1_Direccion;
import HibernateEj1_modelo.HibernateEj1_Profesor;
import HibernateEj1_modelo.HibernateEj1_ProfesorHibernate;

public class HibernateEj1_ProfesorDemo {

	public static void main(String[] args) {
		
		HibernateEj1_Direccion direccion = new HibernateEj1_Direccion("Arganda", 20, "Madrid", "Madrid");
		HibernateEj1_Profesor profesor = new HibernateEj1_Profesor("Miriam", "Garcia", "Gonzalez", direccion);
		
		HibernateEj1_ProfesorHibernate.insertar(profesor);
		HibernateEj1_ProfesorHibernate.leer();
	}

}
