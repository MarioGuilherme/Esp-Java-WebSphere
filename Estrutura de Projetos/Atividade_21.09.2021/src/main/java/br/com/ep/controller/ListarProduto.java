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

@WebServlet("/ListarProduto")
public class ListarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProdutoDAO produtoDAO;
       
    public ListarProduto() {
        super();
        produtoDAO = new ProdutoDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Produto> listaProdutos = new ArrayList<>();
        produtoDAO = new ProdutoDAO();
		try {
			listaProdutos = produtoDAO.Listar();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("listaProdutos", listaProdutos);
		RequestDispatcher rd = request.getRequestDispatcher("listarprodutos.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
}