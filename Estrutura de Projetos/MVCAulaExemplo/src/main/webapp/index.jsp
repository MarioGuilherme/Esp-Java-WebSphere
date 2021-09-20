<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>
		Cadastro de Cliente
	</title>
</head>
<body>
	<form action="clienteServlet" method="post">
		<table>
			<tr>
				<td><label> Nome </label>
				<td><input type="text" name="nome"></td>
			</tr>
			<tr>
				<td><label> CPF </label>
				<td><input type="text" name="cpf"></td>
			</tr>
		</table>
		<input type="submit" value="Enviar">
	</form>
</body>
</html>