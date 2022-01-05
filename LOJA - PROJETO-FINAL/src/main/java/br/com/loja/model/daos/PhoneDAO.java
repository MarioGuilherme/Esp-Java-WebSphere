package br.com.loja.model.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.loja.model.entities.Phone;

public class PhoneDAO {
	
	public Boolean Delete(Phone phone) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaJpa");
      	EntityManager em = emf.createEntityManager();
		try {
		    em.getTransaction().begin();
		    em.find(Phone.class, phone.getId_phone());
		    em.remove(em.contains(phone) ? phone : em.merge(phone));
		    em.getTransaction().commit();
			return true;
		} catch(Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
			return false;
		} finally {
			em.close();
			emf.close();
		}
	}

	public Boolean Update(Phone phone) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaJpa");
      	EntityManager em = emf.createEntityManager();
		try {
			phone.setId_phone(phone.getId_phone());
			phone.setId_client(phone.getId_client());
			phone.setPhone(phone.getPhone());
			em.getTransaction().begin();
			em.merge(phone);
			em.getTransaction().commit();
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		} finally {
			em.close();
			emf.close();
		}
	}
	
	public List<Phone> SelectAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaJpa");
      	EntityManager em = emf.createEntityManager();
		try {
			Query sql = em.createQuery("SELECT p FROM Phone as p");
			List<Phone> listPhones = sql.getResultList();
			return listPhones;
		} finally {
			em.close();
			emf.close();
		}
	}

	public Boolean Insert(Phone phone) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaJpa");
      	EntityManager em = emf.createEntityManager();
		try {
			phone.setId_client(phone.getId_client());
			
			phone.setId_client(phone.getId_client());
			phone.setPhone(phone.getPhone());
			em.getTransaction().begin();
			em.persist(phone);
			em.getTransaction().commit();
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
			return false;
		} finally {
			em.close();
			emf.close();
		}
	}
}