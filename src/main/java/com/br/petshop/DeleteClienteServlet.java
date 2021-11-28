package com.br.petshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.br.petshop.Database.Singleton;
import com.br.petshop.Database.DAO.DAOclient;
import com.br.petshop.Database.DAO.DAOproduto;
import com.br.petshop.Database.Model.modelCliente;
import com.br.petshop.Database.Model.modelProduto;
import com.br.petshop.Objs.Cliente;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

@WebServlet(name = "DeleteCliente", urlPatterns = { "/DeleteCliente" })
public class DeleteClienteServlet extends HttpServlet {
	private Connection conn;
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		conn = (Connection) Singleton.getIntancia();
		
		int idCliente = request.getParameter("idCliente");
		PrintWriter out = response.getWriter();
		
		modelCliente modelCliente = new modelCliente();
		modelCliente.setId(idCliente);
		
		DAOclient daoCliente = new DAOclient(conn);
		daoCliente.Delete(modelCliente);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/clienteDeletado.jsp");
		rd.forward(request, response);
	}

}
