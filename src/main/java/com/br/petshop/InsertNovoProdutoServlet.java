package com.br.petshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

import com.br.petshop.Database.Singleton;
import com.br.petshop.Database.DAO.DAOclient;
import com.br.petshop.Database.DAO.DAOproduto;
import com.br.petshop.Database.Model.modelCliente;
import com.br.petshop.Database.Model.modelProduto;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

@WebServlet(name = "addNovoProduto", urlPatterns = { "/addNovoProduto" })
public class InsertNovoProdutoServlet extends HttpServlet {
	private Connection conn;
	private static final long serialVersionUID = 1L;	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		conn = (Connection) Singleton.getIntancia();
		
		HttpSession session = request.getSession();
		
		String nomeProduto = request.getParameter("nomeProduto");
		String preco = request.getParameter("preco");
		String marca = request.getParameter("marca");
		String descricao = request.getParameter("descricao");
		String qntidade = request.getParameter("qntidade");
		
		modelProduto modelProduto = new modelProduto();
		modelProduto.setNome(nomeProduto);
		modelProduto.setDescricao(descricao);
		modelProduto.setMarca(marca);
		modelProduto.setPreco(preco);
		modelProduto.setQntidade(qntidade);
		
		DAOproduto dao = new DAOproduto(conn);
		dao.Insert(modelProduto);
		
		RequestDispatcher rd = request.getRequestDispatcher("/novoProdutoCadastrado.jsp");
		
		rd.forward(request, response);
		
	}

}
