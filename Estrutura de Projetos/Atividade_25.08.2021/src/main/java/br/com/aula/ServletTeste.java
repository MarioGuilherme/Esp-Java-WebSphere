package br.com.aula;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletTeste")
public class ServletTeste extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletTeste() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String nascimento = request.getParameter("nascimento");
		String senha = request.getParameter("senha");

		System.out.println("Sucesso no cadastro do usuário");
		System.out.println("NOME: "+nome);
		System.out.println("EMAIL: "+email);
		System.out.println("DATA "+nascimento);
		System.out.println("SENHA: "+senha);

		out.println("<h1>Usuário cadastrado com êxito</h1><br>");
		out.println("Nome: "+nome+"<br>");
		out.println("Email: "+email+"<br>");
		out.println("Data de Nascimento: "+nascimento+"<br>");
		out.println("Senha: "+senha);
	}
}