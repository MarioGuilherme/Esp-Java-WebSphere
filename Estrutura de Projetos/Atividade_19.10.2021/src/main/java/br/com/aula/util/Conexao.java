package br.com.aula.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	 public static Connection conectar() throws SQLException{
		Connection conexao = null;
		String URL = "jdbc:mysql://localhost:3306/jsf_mvc?useTimezone=true&serverTimezone=UTC&verifyServerCertificate=false&useSSL=false";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection(URL, "root", "");
		} catch (Exception e) {}
		return conexao;
	}
}