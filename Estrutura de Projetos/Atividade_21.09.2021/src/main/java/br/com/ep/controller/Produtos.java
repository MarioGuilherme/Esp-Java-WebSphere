package br.com.ep.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ep.model.Produto;
import br.com.ep.model.ProdutoDAO;

@WebServlet("/Produtos")
public class Produtos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProdutoDAO produtoDAO;
       
    public Produtos() {
        super();
        produtoDAO = new ProdutoDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		Float preco = Float.parseFloat(request.getParameter("preco"));
		Float custo = Float.parseFloat(request.getParameter("custo"));
		String marca = request.getParameter("marca");
		Integer quantidade = Integer.parseInt(request.getParameter("quantidade"));
		Integer status = request.getParameter("status") == "on" ? 1 : 0;

		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setPreco(preco);
		produto.setCusto(custo);
		produto.setMarca(marca);
		produto.setQuantidade(quantidade);
		produto.setStatus(status);
		try {
			produtoDAO.Inserir(produto);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Deu erro: "+e.getMessage());
		}
		RequestDispatcher rd = request.getRequestDispatcher("produtocadastrado.jsp");
		rd.forward(request, response);
	}
}