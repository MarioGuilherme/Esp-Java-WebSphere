<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

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
            font-size: 3rem;
            background-color: #ffb0b0;
        }
        
        * {
            box-sizing: border-box;
        }
    </style>
</head>

<body class="d-flex align-items-center">
    <div class="container justify-content-center d-flex">
        <div class="row">
            <div class="col-md-12">
                Produto ${param.nome} Cadastrado!!
            </div>
        </div>
    </div>
</body>

</html>