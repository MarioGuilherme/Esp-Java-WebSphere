<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<%@page import="br.com.ep.model.*, java.util.*" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>
        Listagem de Produtos
    </title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        body {
            height: 100vh;
            margin: 0;
            padding: 0;
            font-family: "Poppins", sans-serif;
            font-size: 1.25rem;
            background-color: #ffb0b0;
        }
        
        * {
            box-sizing: border-box;
        }

        tbody tr {
            background-color: aliceblue !important;
        }

        tbody tr:hover {
            background-color: rgb(200, 202, 204) !important;
        }
        
        input[type="checkbox"]{
        	width: 25px;
        	height: 25px;
        }
    </style>
</head>

<body class="d-flex align-items-center">
    <div class="container justify-content-center d-flex">
        <div class="row">
            <div class="col-md-12">
                <table class="table table-hover display compact cell-border text-center" style="width: 100%;">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Preço</th>
                            <th scope="col">Custo</th>
                            <th scope="col">Marca</th>
                            <th scope="col">Quantidade</th>
                            <th scope="col">Ativo</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach items="${listaProdutos}" var="produto">
	                        <tr>
	                            <td>
	                            	<c:out value="${produto.getId_produto()}"/>
	                            </td>
	                            <td>
	                            	<c:out value="${produto.getNome()}"/>
	                            </td>
	                            <td>
	                            	<c:out value="${produto.getPreco()}"/>
	                            </td>
	                            <td>
	                            	<c:out value="${produto.getCusto()}"/>
	                            </td>
	                            <td>
	                            	<c:out value="${produto.getMarca()}"/>
	                            </td>
	                            <td>
	                            	<c:out value="${produto.getQuantidade()}"/>
	                            </td>
	                            <td>  
	                            	<c:if test = "${produto.getStatus() == 1}">
										<input type="checkbox" id="scales" disabled name="scales" checked>
								    </c:if>  
	                            	<c:if test = "${produto.getStatus() == 0}">
										<input type="checkbox" id="scales" disabled name="scales">
								    </c:if>
	                            </td>
	                        </tr>
                    	</c:forEach>
                    </tbody>
                </table>
                <a href="index.jsp">Cadastrar Produto</a>
            </div>
        </div>
    </div>
</body>

</html>