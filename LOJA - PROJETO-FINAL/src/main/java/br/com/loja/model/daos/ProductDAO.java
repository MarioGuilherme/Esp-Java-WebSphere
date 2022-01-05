package br.com.loja.model.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.loja.model.entities.Product;

public class ProductDAO {

	public List<Product> SelectAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaJpa");
      	EntityManager em = emf.createEntityManager();
		try {
			Query sql = em.createQuery("SELECT p FROM Product as p WHERE status = 1");
			List<Product> listProducts = sql.getResultList();
			return listProducts;
		} finally {
			em.close();
			emf.close();
		}
	}

	public Boolean Delete(Product product) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaJpa");
      	EntityManager em = emf.createEntityManager();
		try {
			product.setId_product(product.getId_product());
			product.setName(product.getName());
			product.setPrice(product.getPrice());
			product.setCost(product.getCost());
			product.setQuantity(product.getQuantity());
			product.setStatus(0);
			em.getTransaction().begin();
			em.merge(product);
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

	public Boolean Update(Product product) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaJpa");
      	EntityManager em = emf.createEntityManager();
		try {
			product.setId_product(product.getId_product());
			product.setName(product.getName());
			product.setPrice(product.getPrice());
			product.setCost(product.getCost());
			product.setQuantity(product.getQuantity());
			product.setStatus(1);
			em.getTransaction().begin();
			em.merge(product);
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

	public Boolean Insert(Product product) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaJpa");
      	EntityManager em = emf.createEntityManager();
		try {
			product.setName(product.getName());
			product.setPrice(product.getPrice());
			product.setCost(product.getCost());
			product.setQuantity(product.getQuantity());
			product.setStatus(1);
			em.getTransaction().begin();
			em.persist(product);
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
}