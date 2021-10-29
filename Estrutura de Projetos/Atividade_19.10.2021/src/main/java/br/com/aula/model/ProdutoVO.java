package br.com.aula.model;

public class ProdutoVO {
	private Integer id_produto;
	private String nome;
	private Integer quantidade;
	private Float custo;
	private Float preco;
	private Integer status;

	public Integer getId_produto() {
		return id_produto;
	}
	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Float getCusto() {
		return custo;
	}
	public void setCusto(Float custo) {
		this.custo = custo;
	}
	public Float getPreco() {
		return preco;
	}
	public void setPreco(Float preco) {
		this.preco = preco;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}