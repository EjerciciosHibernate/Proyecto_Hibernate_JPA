package HibernateEj3XML_modelo;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import HibernateEj3XML_utiles.Utilidades;

public class ProfesorHibernateFK {

	public static void insertar(Profesor Profesor) {
		Transaction t = null;
		Session session = null;
		try {
			session = Utilidades.getSessionFactory().openSession();
			t = session.beginTransaction();

			int id = (Integer) session.save(Profesor);
			System.out.println("Insertado  " + id);

			t.commit();
			System.out.println("Insertado");
			System.out.println("Id Profedor : " + Profesor.getId());

		} catch (HibernateException he) {
			Utilidades.exceptionHibernate(he);
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

	public static void leerf() {
		Session session = null;
		try {
			session = Utilidades.getSessionFactory().openSession();
			session.beginTransaction();
			String sql = "From Profesor";
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery(sql);
			@SuppressWarnings("unchecked")
			List<Profesor> lista = query.list();
			for (int i = 0; i < lista.size(); i++) {
				System.out.println(lista.get(i));
			}

		} catch (HibernateException h) {
			h.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static void leer() {
		Session session = null;
		try {
			session = Utilidades.getSessionFactory().openSession();
			session.beginTransaction();
			String sql = "Select p.id, nombre,ape1,ape2, calle,numero,poblacion,provincia from ProfesorFK as p ,DireccionFK as d where p.id=d.direccion_id";
			Query query = session.createNativeQuery(sql);
			List<Object[]> lista = query.getResultList();
			for (Object[] list : lista) {
				Direccion d = new Direccion(list[4].toString(), Integer.parseInt(list[5].toString()),
						list[6].toString(), list[7].toString());
				d.setDireccion_id(Integer.parseInt(list[0].toString()));

				Profesor p = new Profesor(list[1].toString(), list[2].toString(), list[3].toString(), d);
				p.setId(Integer.parseInt(list[0].toString()));

				System.out.println(p.toString());
			}

			session.getTransaction().commit();

		} catch (HibernateException he) {
			Utilidades.exceptionHibernate(he);
		} catch (RuntimeException e) {
			System.out.println(e + "Ocurrio un error " + e.getMessage());
		} finally {
			if (session != null) {
				Utilidades.getSessionFactory().close();
			}
		}

	}

	public static Profesor leerPorID(int id) {
		Session session = null;
		Profesor profesor = new Profesor();
		try {
			session = Utilidades.getSessionFactory().openSession();
			session.beginTransaction();
			Profesor prof = (Profesor) session.get(Profesor.class, id);
			profesor = new Profesor(prof.getNombre(), prof.getApe1(), prof.getApe2(), prof.getDireccion());
			profesor.setId(prof.getId());
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
