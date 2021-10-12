package br.com.aula.bd.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.aula.bd.model.bean.Produto;

public class CriarProduto {
	public static void main(String[] args) {
		Produto produto = new Produto();
		produto.setNome("Placa de Vídeo");
		produto.setPreco((float) 1199.99);
		produto.setCusto((float) 899.99);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaJpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}