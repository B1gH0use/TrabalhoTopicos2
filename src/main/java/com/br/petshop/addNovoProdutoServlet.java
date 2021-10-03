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
		String marca = request.getParameter("marca");
		String descricao = request.getParameter("descricao");
		int qntidade = Integer.parseInt(request.getParameter("qntidade"));
		
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setPreco(preco);
		produto.setMarca(marca);
		produto.setDescricao(descricao);
		produto.setQntidade(qntidade);
		
		request.getSession().setAttribute("produto", produto);
		
		
		
	}

}
