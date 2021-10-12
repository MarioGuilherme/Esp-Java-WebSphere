package br.com.aula.bd.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import br.com.aula.bd.model.bean.Produto;

public class ListarProduto {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaJpa");
		EntityManager em = emf.createEntityManager();
		Query sql = em.createQuery("SELECT c from Produto as c");
		List<Produto> listaProduto = sql.getResultList();
		System.out.println("\n-----Listando Produtos-------");
		for (Produto p : listaProduto) {
			System.out.printf("{ id_cliente: %d , nome: %s, preco %.2f, custo: %.2f }\n", p.getId_produto(), p.getNome(), p.getPreco(), p.getCusto());
		}
	}
}