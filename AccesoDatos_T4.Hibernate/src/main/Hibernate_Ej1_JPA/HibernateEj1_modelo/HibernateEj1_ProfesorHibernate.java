package HibernateEj1_modelo;

import java.util.Iterator;
import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import HibernateEj1_utiles.HibernateEj1_utilidades;

public class HibernateEj1_ProfesorHibernate {

	public static void insertar(HibernateEj1_Profesor profesor) {
		Session session = null;
		try {
			session = HibernateEj1_utilidades.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();

			int id = (Integer) session.save(profesor);
			System.out.println("------- Insertado : -------");
			System.out.println("Id Profesor " + id);
			t.commit();
		} catch (HibernateException he) {
			HibernateEj1_utilidades.exceptionHibernate(he);
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	@SuppressWarnings("rawtypes")
	public static void leer() {
		Session session = null;
		try {
			session = HibernateEj1_utilidades.getSessionFactory().openSession();
			session.beginTransaction();

			List profesores = session.createQuery("FROM HibernateEj1_Profesor").list();

			for (Iterator iterator = profesores.iterator(); iterator.hasNext();) {
				HibernateEj1_Profesor profesor = (HibernateEj1_Profesor) iterator.next();
				System.out.println(profesor.toString());
			}
			session.getTransaction().commit();
		} catch (HibernateException he) {
			HibernateEj1_utilidades.exceptionHibernate(he);
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	public static void leerPorID() {
		Session session = null;
		try {
			session = HibernateEj1_utilidades.getSessionFactory().openSession();
			session.beginTransaction();

			HibernateEj1_Profesor p = session.get(HibernateEj1_Profesor.class, 7);
			System.out.println(p.toString());
		} catch (HibernateException he) {
			System.out.println(he.getMessage());
		} catch (PersistenceException p) {

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
