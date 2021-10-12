package br.com.aula.bd.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import br.com.aula.bd.model.bean.Forma_Pagamento;

public class ListarForma_Pagamento {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaJpa");
		EntityManager em = emf.createEntityManager();
		Query sql = em.createQuery("SELECT fp from Forma_Pagamento as fp");
		List<Forma_Pagamento> listaProduto = sql.getResultList();
		System.out.println("\n-----Listando Fromas de Pagamento-------");
		for (Forma_Pagamento fp : listaProduto) {
			System.out.printf("{ id_forma_pagamento: %d , forma: %s }\n", fp.getId_forma_pagamento(), fp.getForma());
		}
	}
}