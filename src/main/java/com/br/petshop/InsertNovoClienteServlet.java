package com.br.petshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.br.petshop.Database.connectionFactory;
import com.br.petshop.Database.DAO.DAOclient;
import com.br.petshop.Database.Model.modelCliente;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;


@WebServlet(name = "addNovoCliente", urlPatterns = { "/addNovoCliente" })
public class InsertNovoClienteServlet extends HttpServlet {
	
	private static Connection conn;
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			conn = connectionFactory.getConnection("localhost", 3306, "petshop", "root", "root");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		
		String nomeCliente = request.getParameter("nomeCliente");
		String telefone = request.getParameter("phone");
		String nomePet = request.getParameter("nomePet");
		
		modelCliente modelCliente = new modelCliente();
		modelCliente.setNome(nomeCliente);
		modelCliente.setNomePets(nomePet);
		modelCliente.setTelefone(telefone);
		
		
		try {
			DAOclient dao = new DAOclient(conn);
			dao.Insert(modelCliente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/novoClienteCadastrado.jsp");

		rd.forward(request, response);
	}
}
