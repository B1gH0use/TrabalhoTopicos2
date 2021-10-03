package com.br.petshop;

import java.io.IOException;
import java.util.ArrayList;

import com.br.petshop.Objs.Cliente;
import com.br.petshop.Objs.Produto;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;

@WebServlet(name = "addNovoProduto", urlPatterns = { "/addNovoProduto" })
public class InsertNovoProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
		
		if(session.getAttribute("listaClientes") != null) {
			listaProdutos = (ArrayList<Produto>) session.getAttribute("listaProdutos");		
		} 
		
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
		
		request.getSession().setAttribute("listaProdutos", listaProdutos);
		
	}

}
