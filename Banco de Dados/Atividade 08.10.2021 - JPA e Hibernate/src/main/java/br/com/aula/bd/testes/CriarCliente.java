package br.com.aula.bd.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.aula.bd.model.bean.Cliente;

public class CriarCliente {
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setNome("Mário Guilherme");
		cliente.setCpf("40028922400");
		cliente.setCelular(555555555);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaJpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}