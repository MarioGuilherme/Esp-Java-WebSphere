<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>
        Cadastro de Produtos
    </title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        body {
            height: 100vh;
            margin: 0;
            padding: 0;
            font-family: "Poppins", sans-serif;
            font-size: 1.75rem;
            background-color: #ffb0b0;
        }

        * {
            box-sizing: border-box;
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
                <form action="Produtos" method="post">
                    <div class="row">
                        <div class="col-12 justify-content-center">
                            <div class="form-group">
                                <label for="my-input">
                                    Nome do Produto
                                </label>
                                <input id="my-input" class="form-control" type="text" name="nome">
                            </div>
                            <div class="form-group">
                                <label for="my-input">
                                    Preço pago ao fornecedor
                                </label>
                                <input id="my-input" class="form-control" type="number" name="custo">
                            </div>
                            <div class="form-group">
                                <label for="my-input">
                                    Preço a ser pago pelo cliente
                                </label>
                                <input id="my-input" class="form-control" type="number" name="preco">
                            </div>
                            <div class="form-group">
                                <label for="my-input">
                                    Marca do Produto
                                </label>
                                <input id="my-input" class="form-control" type="text" name="marca">
                            </div>
                            <div class="form-group">
                                <label for="my-input">
                                    Quantidade em estoque
                                </label>
                                <input id="my-input" class="form-control" type="number" name="quantidade">
                            </div>
                            <div class="form-check">
                                <input id="checkbox" class="form-check-input" type="checkbox" name="status" value="off">
                                <label for="checkbox" class="form-check-label ml-4">Status</label>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">
                                Cadastrar
                            </button>
                        </div>
                    </div>
                </form>
                <a href="ListarProduto">
                    Ver todos os produtos
                </a>
            </div>
        </div>
    </div>
    <script>
    	document.querySelector("input[type='checkbox']")
    </script>
</body>

</html>