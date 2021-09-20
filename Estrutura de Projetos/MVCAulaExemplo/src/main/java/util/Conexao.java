package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	 public static Connection conectar() throws SQLException{
		Connection conexao = null;
		String URL = "jdbc:mysql://localhost:3306/mvcaulaexemplo?useTimezone=true&serverTimezone=UTC";
 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection(URL, "root", "root");
			System.out.println("Conectado");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Não conectado: "+e.getMessage());
		}
		return conexao;
	}
}