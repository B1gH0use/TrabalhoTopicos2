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

		out.println("<html>");
		out.println("<title>Petshop</title>\r\n"
				+ "<link rel=\"stylesheet\" href=\"style.css\">\r\n"
				+ "<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n"
				+ "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n"
				+ "<link href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap\" rel=\"stylesheet\">");
		out.println("<body>");
		out.println("<h1>Lista de Clientes </h1>");
		out.println("<table>");
		out.println("<tr><th>Nome</th><th>Nome do Pet</th><th>Endereco</th><th>Telefone</th></tr>");
		int countCliente = 0;
		
		for (Cliente cliente : listaClientes) {
			out.println("<tr>");
			out.println("<td>" + cliente.getNome() + "</td>");
			out.println("<td>" + cliente.getNomePets() + "</td>");
			out.println("<td>" + cliente.getEndereco() + "</td>");
			out.println("<td>" + cliente.getTelefone() + "</td>");
			out.println("</tr>");
			countCliente += 1;
		}
		
		out.println("</table>");
		out.println("Numero de clientes: " + countCliente);
		out.println("<hr>");
		
		out.println("<h1>Produtos</h1>");
		out.println("<table>");
		out.println("<tr><th>Nome</th><th>Marca</th><th>Descricao</th><th>Preco</th><th>Qtidade</th></tr>");
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
		out.println("</table>");
		
		out.println("Quantidade de produtos: " + countProduto);
		out.println("<hr>");
		out.println("<a href='index.html'>Voltar para pagina inicial</a>");
		out.println("</body></html>");
	}

}
