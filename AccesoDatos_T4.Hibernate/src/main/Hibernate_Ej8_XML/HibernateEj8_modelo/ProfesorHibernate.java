package HibernateEj8_modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import HibernateEj8_utiles.Utilidades;

public class ProfesorHibernate {

	public static void insertar(Profesor Profesor) {
		Transaction t = null;
		Session session = null;
		try {
			session = Utilidades.getSessionFactory().openSession();
			t = session.beginTransaction();

			session.save(Profesor);

			t.commit();
			System.out.println("Insertado");
			System.out.println("Id Profedor : " + Profesor.getId());

		} catch (HibernateException he) {
			// utilidades.exceptionHibernate(he);
			// System.err.println(he + " "+ he.getMessage());
			he.printStackTrace();
		} catch (RuntimeException e) {
			if (t != null) {
				t.rollback();
				System.out.println("Ocurrio un error");
			}

		} finally {
			if (session != null) {
				Utilidades.getSessionFactory().close();

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
				Utilidades.getSessionFactory().close();
			}
		}

		return lista;

	}

	public static Profesor leerPorID(int id) {
		Session session = null;
		Profesor profesor = new Profesor();
		try {
			session = Utilidades.getSessionFactory().openSession();
			session.beginTransaction();
			Profesor prof = (Profesor) session.get(Profesor.class, id);
			profesor = new Profesor(prof.getNombre(), prof.getApe1(), prof.getApe2(), prof.getDireccion(),
					prof.getModulo());
			profesor.setId(prof.getId());
			profesor.setListaCorreo(prof.getListaCorreo());
			session.getTransaction().commit();

		} catch (HibernateException he) {
			Utilidades.exceptionHibernate(he);
		} catch (RuntimeException e) {
			System.out.println("Ocurrio un error");
		} finally {
			if (session != null) {
				Utilidades.getSessionFactory().close();
			}
		}
		return profesor;
	}

}
