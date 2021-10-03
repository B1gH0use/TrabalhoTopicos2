package com.br.petshop;

import java.io.IOException;

import com.br.petshop.Objs.Produto;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;


@WebServlet(name = "addNovoCliente", urlPatterns = { "/addNovoCliente" })
public class UpdateProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nomeProduto");
		String preco = request.getParameter("preco");
		String marca = request.getParameter("marca");
		String descricao = request.getParameter("descricao");
		String qntidade = request.getParameter("qntidade");
		
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setPreco(preco);
		produto.setMarca(marca);
		produto.setDescricao(descricao);
		produto.setQntidade(qntidade);
		
		request.getSession().setAttribute(nome, produto.getNome());
		request.getSession().setAttribute(preco, produto.getPreco());
		request.getSession().setAttribute(marca, produto.getMarca());
		request.getSession().setAttribute(descricao, produto.getDescricao());
		request.getSession().setAttribute(qntidade, produto.getQntidade());
		
	}
}