package com.br.petshop;

import java.io.IOException;

import com.br.petshop.Objs.Produto;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

/**
 * Servlet implementation class addNovoProdutoServlet
 */
@WebServlet(name = "addNovoProduto", urlPatterns = { "/addNovoProduto" })
public class addNovoProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nomeProduto");
		float preco = Float.parseFloat(request.getParameter("preco"));

		
		Produto servico = new Produto();
		produto.setNome(nome);
		produto.setPreco(preco);

		request.getSession().setAttribute("produto", produto);
		
		
		
	}

}
