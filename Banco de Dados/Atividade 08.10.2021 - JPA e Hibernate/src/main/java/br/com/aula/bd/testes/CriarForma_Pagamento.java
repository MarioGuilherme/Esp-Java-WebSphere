package br.com.aula.bd.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.aula.bd.model.bean.Forma_Pagamento;

public class CriarForma_Pagamento {
	public static void main(String[] args) {
		Forma_Pagamento formaPagamento = new Forma_Pagamento();
		formaPagamento.setForma("Débito");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaJpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(formaPagamento);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}