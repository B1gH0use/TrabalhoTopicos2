package com.br.petshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

import com.br.petshop.Database.Singleton;
import com.br.petshop.Database.DAO.DAOproduto;
import com.br.petshop.Database.Model.modelProduto;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

@WebServlet(name = "DeleteProduto", urlPatterns = { "/DeleteProduto" })
public class DeleteProdutoServlet extends HttpServlet {
	private Connection conn;
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		conn = (Connection) Singleton.getIntancia();
		
		int idProduto = request.getParameter("idProduto");
		PrintWriter out = response.getWriter();
		
		modelProduto modelProduto = new modelProduto();
		modelProduto.setId(idProduto);
		
		DAOproduto daoProduto = new DAOproduto(conn);
		daoProduto.Delete(modelProduto);
		
		RequestDispatcher rd = request.getRequestDispatcher("/produtoDeletado.jsp");
		
		rd.forward(request, response);
	}

}
