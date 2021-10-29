package br.com.aula.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.aula.util.Conexao;

public class ProdutoDAO {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	public boolean Inserir(ProdutoVO produtoVO) throws SQLException {
		con = Conexao.conectar();
		String sql = "INSERT INTO produtos (nome, quantidade, custo, preco) VALUES (?, ?, ?, ?)";
		pst = con.prepareStatement(sql);
		pst.setString(1, produtoVO.getNome());
		pst.setInt(2, produtoVO.getQuantidade());
		pst.setFloat(3, produtoVO.getCusto());
		pst.setFloat(4, produtoVO.getPreco());

		if(pst.executeUpdate() > 0) {
			pst.close();
			con.close();
			return true;
		}else {
			pst.close();
			con.close();
			return false;
		}
	}

	public boolean Atualizar(ProdutoVO produtoVO) throws SQLException {
		con = Conexao.conectar();
		String sql = "UPDATE produtos SET nome = ?, quantidade = ?, custo = ?, preco = ? WHERE id_produto = ?";
		pst = con.prepareStatement(sql);
		pst.setString(1, produtoVO.getNome());
		pst.setInt(2, produtoVO.getQuantidade());
		pst.setFloat(3, produtoVO.getCusto());
		pst.setFloat(4, produtoVO.getPreco());
		pst.setInt(5, produtoVO.getId_produto());

		if(pst.executeUpdate() > 0) {
			pst.close();
			con.close();
			return true;
		}else {
			pst.close();
			con.close();
			return false;
		}
	}

	public List<ProdutoVO> Listar() throws SQLException {
		List<ProdutoVO> listaProdutos = new ArrayList<ProdutoVO>();
		con = Conexao.conectar();
		String sql = "SELECT * FROM produtos WHERE status = 1";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();

		while(rs.next()) {
			ProdutoVO produto = new ProdutoVO();
			produto.setId_produto(rs.getInt("id_produto"));
			produto.setNome(rs.getString("nome"));
			produto.setQuantidade(rs.getInt("quantidade"));
			produto.setCusto(rs.getFloat("custo"));
			produto.setPreco(rs.getFloat("preco"));
			listaProdutos.add(produto);
		}
		rs.close();
		pst.close();
		con.close();
		return listaProdutos;
	}

	public boolean Deletar(ProdutoVO produtoVO) throws SQLException {
		con = Conexao.conectar();
		String sql = "UPDATE produtos SET status = 0 WHERE id_produto = ?";
		pst = con.prepareStatement(sql);
		pst.setInt(1, produtoVO.getId_produto());
		if(pst.executeUpdate() > 0) {
			pst.close();
			con.close();
			return true;
		}else {
			pst.close();
			con.close();
			return false;
		}
	}
}