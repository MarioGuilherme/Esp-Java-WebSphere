package br.com.aula.bd.model.bean;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Forma_Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_forma_pagamento;
    private String forma;

	public int getId_forma_pagamento() {
		return id_forma_pagamento;
	}
	public void setId_forma_pagamento(int id_forma_pagamento) {
		this.id_forma_pagamento = id_forma_pagamento;
	}
	public String getForma() {
		return forma;
	}
	public void setForma(String forma) {
		this.forma = forma;
	}
	
}