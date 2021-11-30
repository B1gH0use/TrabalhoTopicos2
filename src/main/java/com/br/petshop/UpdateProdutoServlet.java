 package com.br.petshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.br.petshop.Database.Model.modelProduto;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;


@WebServlet(name = "updateProduto", urlPatterns = { "/updateProduto" })
public class UpdateProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeProduto = request.getParameter("nomeProduto");
		String nome = request.getParameter("nome");
		String preco = request.getParameter("preco");
		String marca = request.getParameter("marca");
		String descricao = request.getParameter("descricao");
		String qntidade = request.getParameter("qntidade");
		
		PrintWriter out = response.getWriter();
		
		
		ArrayList<modelProduto> listaProdutos = (ArrayList<modelProduto>)request.getSession().getAttribute("listaProdutos");
		
		for (modelProduto produto : listaProdutos) {
			if(produto.getNome().equals(nomeProduto)) {
				produto.setNome(nome);
				produto.setDescricao(descricao);
				produto.setMarca(marca);
				produto.setPreco(preco);
				produto.setQntidade(qntidade);
			}
		}
		
		request.setAttribute("listaProdutos", listaProdutos);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/produtoAlterado.jsp");
		request.setAttribute("nomeCliente", nomeProduto);
		rd.forward(request, response);
		
	}
}