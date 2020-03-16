package HibernateEj2_modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import HibernateEj2_utiles.HibernateEj2_utilidades;

public class HibernateEj2_ProfesorHibernate {
	/**
	 * Insertar los datos.
	 * @param Profesor
	 */
	public static void insertar(HibernateEj2_Profesor Profesor) {
		Transaction t = null;
		try {
			Session session = HibernateEj2_utilidades.getSessionFactory().openSession();
			t = session.beginTransaction();

			int id = (Integer) session.save(Profesor);

			t.commit();
			System.out.println("------- Insertado : -------");
			System.out.println("Id Profesor " + id);

			HibernateEj2_utilidades.getSessionFactory().close();

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
		}

	}

	@SuppressWarnings("unchecked")
	/**
	 * Leer los datos.
	 * 
	 * @return Profesor profesor
	 */
	public static List<HibernateEj2_Profesor> leer() {
		Session session = null;
		List<HibernateEj2_Profesor> profesor = new ArrayList<HibernateEj2_Profesor>();
		try {
			session = HibernateEj2_utilidades.getSessionFactory().openSession();
			session.beginTransaction();
			// comando de SQL
			String sql = "Select p.id, nombre,ape1,ape2, calle,numero,poblacion,provincia from Profesor as p ,Direccion as d where p.id=d.id";
			Query query = session.createNativeQuery(sql);
			// Para conseguir el resultado de la lista
			List<Object[]> lista = query.getResultList();

			for (Object[] list : lista) {
				HibernateEj2_Direccion d = new HibernateEj2_Direccion(list[4].toString(),
						Integer.parseInt(list[5].toString()), list[6].toString(), list[7].toString());
				d.setid(Integer.parseInt(list[0].toString()));

				HibernateEj2_Profesor p = new HibernateEj2_Profesor(list[1].toString(), list[2].toString(),
						list[3].toString(), d);
				p.setId(Integer.parseInt(list[0].toString()));

				profesor.add(p);
			}

			session.getTransaction().commit();

		} catch (HibernateException he) {
			HibernateEj2_utilidades.exceptionHibernate(he);
		} finally {
			if (session != null) {
				HibernateEj2_utilidades.getSessionFactory().close();
			}
		}

		return profesor;

	}

	/**
	 * Leer los datos por id;
	 * 
	 * @param id
	 * @return
	 */
	public static HibernateEj2_Profesor leerPorID(int id) {
		HibernateEj2_Profesor prof = new HibernateEj2_Profesor();
		Session session = null;
		try {
			session = HibernateEj2_utilidades.getSessionFactory().openSession();
			session.beginTransaction();
			prof = (HibernateEj2_Profesor) session.load(HibernateEj2_Profesor.class, id);
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println(he.getMessage());
		} catch (PersistenceException p) {
			System.err.println(p + " " + p.getMessage());
		} finally {
			if (session != null) {
				HibernateEj2_utilidades.getSessionFactory().close();
			}
		}
		return prof;
	}

}
