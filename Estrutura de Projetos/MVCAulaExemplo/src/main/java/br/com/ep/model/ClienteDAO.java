package br.com.ep.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import util.Conexao;

public class ClienteDAO {
	public void Inserir(Cliente cliente) throws SQLException {
		try {
			Connection conexao;
			conexao = Conexao.conectar();
			String sql = "INSERT INTO clientes (nome, cpf) VALUES (?, ?)";
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getCpf());
			pst.executeUpdate();
			pst.close();
			conexao.close();
		}catch(Exception e){
			System.out.println("Erro ao fazer o insert: "+e.getMessage());
		}
	}

	public void Atualizar(Cliente cliente) {}

	public void Deletar(Cliente cliente) {}

	public ArrayList<Cliente> Listar() {
		return null;
	}
}