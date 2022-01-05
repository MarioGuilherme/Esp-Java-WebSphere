package br.com.loja.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "phones")
@Entity
public class Phone {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id_phone;
    private Integer id_client;
    private String phone;

	public Integer getId_phone() {
		return id_phone;
	}
	public void setId_phone(Integer id_phone) {
		this.id_phone = id_phone;
	}
	public Integer getId_client() {
		return id_client;
	}
	public void setId_client(Integer id_client) {
		this.id_client = id_client;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone.replaceAll("\\s", "").replace("+", "").replaceAll("\\(", "").replaceAll("\\)", "").replace("-", "");
	}
}