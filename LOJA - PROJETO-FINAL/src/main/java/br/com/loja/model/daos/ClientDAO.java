package br.com.loja.model.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.loja.model.entities.Client;
import br.com.loja.model.entities.Phone;

public class ClientDAO {
	
	public Boolean Delete(Client client) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaJpa");
      	EntityManager em = emf.createEntityManager();
		try {
			client.setId_client(client.getId_client());
			client.setName(client.getName());
			client.setEmail(client.getEmail());
			client.setCpf(client.getCpf());
			client.setRg(client.getRg());
			client.setStatus(0);
			em.getTransaction().begin();
			em.merge(client);
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

	public Boolean Update(Client client) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaJpa");
      	EntityManager em = emf.createEntityManager();
		try {
			client.setId_client(client.getId_client());
			client.setName(client.getName());
			client.setEmail(client.getEmail());
			client.setCpf(client.getCpf());
			client.setRg(client.getRg());
			client.setStatus(1);
			em.getTransaction().begin();
			em.merge(client);
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
	
	public Client SelectById(Client client) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaJpa");
      	EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
		    client = em.find(Client.class, client.getId_client());
		    em.getTransaction().commit();
			return client;
		} finally {
			em.close();
			emf.close();
		}
	}
	
	public List<Client> SelectAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaJpa");
      	EntityManager em = emf.createEntityManager();
		try {
			Query sql = em.createQuery("SELECT c FROM Client as c WHERE status = 1");
			List<Client> listClients = sql.getResultList();
			return listClients;
		} finally {
			em.close();
			emf.close();
		}
	}

	public Boolean Insert(Client client) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaJpa");
      	EntityManager em = emf.createEntityManager();
		try {
			client.setName(client.getName());
			client.setEmail(client.getEmail());
			client.setCpf(client.getCpf());
			client.setRg(client.getRg());
			client.setStatus(1);
			em.getTransaction().begin();
			em.persist(client);
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