package br.com.aula.bd.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import br.com.aula.bd.model.bean.Cliente;

public class ListarCliente {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaJpa");
		EntityManager em = emf.createEntityManager();
		Query sql = em.createQuery("SELECT c from Cliente as c");
		List<Cliente> listaClente = sql.getResultList();
		System.out.println("\n-----Listando Clientes-------");
		for (Cliente c : listaClente) {
			System.out.printf("{ id_cliente: %d , nome: %s }\n", c.getId_cliente(), c.getNome());
		}
	}
}