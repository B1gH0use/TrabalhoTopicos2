package com.br.petshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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

		request.getSession().setAttribute("listaProdutos", listaProdutos);
		
		if(session.getAttribute("listaProdutos") != null) {
			listaProdutos = (ArrayList<Produto>) session.getAttribute("listaProdutos");		
		} 
		
		String nomeProduto = request.getParameter("nomeProduto");
		String preco = request.getParameter("preco");
		String marca = request.getParameter("marca");
		String descricao = request.getParameter("descricao");
		String qntidade = request.getParameter("qntidade");
		
		Produto produto = new Produto();
		produto.setNome(nomeProduto);
		produto.setDescricao(descricao);
		produto.setMarca(marca);
		produto.setPreco(preco);
		produto.setQntidade(qntidade);
		
		listaProdutos.add(produto);
		
		request.getSession().setAttribute("listaProdutos", listaProdutos);
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("Produto " + nomeProduto  + "adicionado com sucesso!");
		out.println("<a href='index.html'>Voltar para a página inicial</a>");
		out.println("</body></html>");
		
	}

}
