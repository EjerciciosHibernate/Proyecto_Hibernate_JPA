package HibernateEj3JPA_modelo;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import javax.persistence.PersistenceException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import HibernateEj3JPA_util.Utilidades;

public class HibernateEj3_ProfesorHibernate {

	public static void insertar(ProfesorFK profesor) {
		Transaction t = null;
		Session session = null;
		try {
			session = Utilidades.getSessionFactory().openSession();
			t = session.beginTransaction();

			int id = (Integer) session.save(profesor);

			System.out.println("Insertado Id Profesor : " + id);

			t.commit();
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
	public static List<ProfesorFK> leer() {
		List<ProfesorFK> lista = new ArrayList<ProfesorFK>();
		Session session = null;
		try {
			session = Utilidades.getSessionFactory().openSession();
			session.beginTransaction();

			List profesores = session.createQuery("FROM HibernateEj3JPA_modelo.ProfesorFK").list();

			for (Iterator iterator = profesores.iterator(); iterator.hasNext();) {
				ProfesorFK profesor = (ProfesorFK) iterator.next();
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

	public static ProfesorFK leerPorID(int id) {
		ProfesorFK p = new ProfesorFK();
		Session session = null;
		try {
			session = Utilidades.getSessionFactory().openSession();
			session.beginTransaction();

			p = session.get(ProfesorFK.class, id);
			session.getTransaction().commit();
			
		} catch (HibernateException he) {
			System.out.println(he.getMessage());
		} catch (PersistenceException e) {
			System.out.println(e + " " + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return p;
	}

}
