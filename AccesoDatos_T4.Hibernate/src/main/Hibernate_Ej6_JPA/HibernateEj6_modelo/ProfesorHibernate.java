package HibernateEj6_modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import HibernateEj6_utiles.Utilidades;

public class ProfesorHibernate {

	public static void insertar(Profesor profesor) {
		Transaction t = null;
		Session session = null;
		try {
			session = Utilidades.getSessionFactory().openSession();
			t = session.beginTransaction();

			session.save(profesor);
			t.commit();
			System.out.println("---------------------------Insertado : ------------------------");
			System.out.println(profesor.toString());

		} catch (HibernateException he) {
			Utilidades.exceptionHibernate(he);
		} catch (RuntimeException e) {
			if (t != null) {
				t.rollback();
				System.out.println("Ocurrio un error");
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	@SuppressWarnings("rawtypes")
	public static List<Profesor> leer() {
		List<Profesor> lista = new ArrayList<Profesor>();
		Session session = null;
		try {
			session = Utilidades.getSessionFactory().openSession();
			session.beginTransaction();

			List profesores = session.createQuery("FROM Profesor").list();

			for (Iterator iterator = profesores.iterator(); iterator.hasNext();) {
				Profesor profesor = (Profesor) iterator.next();
				lista.add(profesor);
				// System.out.println(profesor.toString());
			}
			session.getTransaction().commit();
		} catch (HibernateException he) {
			Utilidades.exceptionHibernate(he);
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return lista;

	}
	
	
	

	public static Profesor leerPorID(int id) {
		Profesor p = new Profesor();
		Session session = null;
		try {
			session = Utilidades.getSessionFactory().openSession();
			session.beginTransaction();

			p = session.get(Profesor.class, id);
			session.getTransaction().commit();
		} catch (HibernateException he) {
			Utilidades.exceptionHibernate(he);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return p;
	}

}
