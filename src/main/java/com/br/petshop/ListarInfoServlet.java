package com.br.petshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.br.petshop.Objs.Cliente;
import com.br.petshop.Objs.Produto;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;

@WebServlet(name = "listarClientes", urlPatterns = { "/listarInfo" })
public class ListarInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
		
		if(session.getAttribute("listaClientes") != null) {
			listaClientes = (ArrayList<Cliente>) session.getAttribute("listaClientes");		
		} 
		
		if(session.getAttribute("listaProdutos") != null) {
			listaProdutos = (ArrayList<Produto>) session.getAttribute("listaProdutos");		
		} 
		
		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		out.println("<h1>Lista de Clientes </h1>");
		int countCliente = 0;
		for (Cliente cliente : listaClientes) {
			out.println(cliente.getNome());
			out.println(cliente.getNomePets());
			out.println(cliente.getEndereco());
			out.println(cliente.getTelefone());
			countCliente += 1;
		}
		out.println("Número de clientes: " + countCliente);
		out.println("<hr>");
		
		out.println("<h1>Produtos</h1>");
		int countProduto = 0;
		for (Produto produto : listaProdutos) {
			out.println(produto.getNome());
			out.println(produto.getMarca());
			out.println(produto.getDescricao());
			out.println(produto.getPreco());
			out.println(produto.getQntidade());
			countProduto += 1;	
		} 
		
		out.println("Quantidade de produtos: " + countProduto);
		out.println("<hr>");
		out.println("<a href='index.html'>Voltar para página inicial</a>");
		out.println("</body></html>");
	}

}
