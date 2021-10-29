package br.com.aula.controller;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.aula.model.ProdutoDAO;
import br.com.aula.model.ProdutoVO;

@ManagedBean(name = "produtoMB")
@SessionScoped
public class ProdutoMBean {
	private ProdutoVO produtoVO = new ProdutoVO();
	private DataModel<ProdutoVO> listaProdutos;

	public ProdutoVO getProdutoVO() {
		return produtoVO;
	}

	public void setProdutoVO(ProdutoVO produtoVO) {
		this.produtoVO = produtoVO;
	}

	public void selecionarReg() {
		this.produtoVO = listaProdutos.getRowData();
	}

	public void novoReg() {
		this.produtoVO = new ProdutoVO();
	}
	
	public String AddProduto() throws SQLException {
		String retorno = "erro";
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			if(produtoDAO.Inserir(produtoVO)) {
				retorno =  "listar";
			}
		}catch (Exception e){}
		return retorno;
	}
	
	public String AtualizarProduto() throws SQLException {
		String retorno = "erro";
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			if(produtoDAO.Atualizar(produtoVO)) {
				retorno =  "listar";
			}
		}catch (Exception e){}
		return retorno;
	}
	
	public String DeletarProduto() throws SQLException {
		String retorno = "erro";
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			if(produtoDAO.Deletar(produtoVO)) {
				retorno =  "listar";
			}
		}catch (Exception e){
			System.out.println("Erro "+e.getMessage());
		}
		return retorno;
	}
	
	public DataModel<ProdutoVO> getListaProdutos() throws SQLException {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<ProdutoVO> listagem = produtoDAO.Listar();
		listaProdutos = new ListDataModel<ProdutoVO> (listagem);
		return listaProdutos;
	}
}