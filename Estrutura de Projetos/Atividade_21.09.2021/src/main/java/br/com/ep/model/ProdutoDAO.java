package br.com.ep.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Conexao;

public class ProdutoDAO {
	public void Inserir(Produto produto) throws SQLException {
		try {
			Connection conexao;
			conexao = Conexao.conectar();
			String sql = "INSERT INTO produtos (nome, preco, custo, marca, quantidade, status) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, produto.getNome());
			pst.setFloat(2, produto.getPreco());
			pst.setFloat(3, produto.getCusto());
			pst.setString(4, produto.getMarca());
			pst.setInt(5, produto.getQuantidade());
			pst.setInt(6, produto.getStatus());
			pst.executeUpdate();
			pst.close();
			conexao.close();
		}catch(Exception e){
			System.out.println("Erro ao fazer o insert: "+e.getMessage());
		}
	}

	public List<Produto> Listar() throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();
		try {
			Connection conexao = Conexao.conectar();
			String sql = "SELECT * FROM produtos";
			PreparedStatement pst = conexao.prepareStatement(sql);
			ResultSet rs = pst.executeQuery(sql);
			while(rs.next()) {
				Produto produto = new Produto();
				produto.setId_produto(rs.getInt("id_produto"));
				produto.setNome(rs.getString("nome"));
				produto.setPreco(rs.getFloat("preco"));
				produto.setCusto(rs.getFloat("custo"));
				produto.setMarca(rs.getString("marca"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setStatus(rs.getInt("status"));
				produtos.add(produto);
			}
		}catch(Exception e){
			System.out.println("Erro ao fazer o select: "+e.getMessage());
		}
		return produtos;
	}
}