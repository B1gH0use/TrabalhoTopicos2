<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList, com.br.petshop.Objs.Cliente, com.br.petshop.Objs.Produto" %>


<%
	ArrayList<Cliente> listaClientes = (ArrayList<Cliente>)request.getAttribute("listaClientes");
	ArrayList<Produto> listaProdutos = (ArrayList<Produto>)request.getAttribute("listaProdutos");
%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Petshop - Listar Infos</title>
</head>
<body>
<h1>Lista de Clientes</h1>
<table>
	<tr>
		<th>Nome</th>
		<th>Nome do Pet</th>
		<th>Telefone</th>
	</tr>
	<% 
		int countCliente = 0;
		for (Cliente cliente: listaClientes) {
			out.println("<tr>");
			out.println("<td>" + cliente.getNome() + "</td>");
			out.println("<td>" + cliente.getNomePets() + "</td>");
			out.println("<td>" + cliente.getEndereco() + "</td>");
			out.println("<td>" + cliente.getTelefone() + "</td>");
			out.println("</tr>");
			countCliente += 1;
		}
	%>
</table>
<p>Número de clientes: <%=countCliente %></p>
<hr />

<h1>Lista de Produtos</h1>
<table>
	<tr>
		<th>Nome</th>
		<th>Marca</th>
		<th>Preço</th>
		<th>Descrição</th>
		<th>Quantidade</th>
	</tr>
	<% 
		int countProduto = 0;
		for (Produto produto : listaProdutos) {
			out.println("<tr>");
			out.println("<td>" + produto.getNome() + "</td>");
			out.println("<td>" + produto.getMarca() + "</td>");
			out.println("<td>" + produto.getDescricao() + "</td>");
			out.println("<td>" + produto.getPreco() + "</td>");
			out.println("<td>" + produto.getQntidade() + "</td>");
			out.println("</tr>");
			countProduto += 1;	
		}
	%>
</table>
<p>Número de produtos: <%=countProduto %></p>
<hr />
<a href='index.jsp'>Voltar para pagina inicial</a>
</body>
</html>