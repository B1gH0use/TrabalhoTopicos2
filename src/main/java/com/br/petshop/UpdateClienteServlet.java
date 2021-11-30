package com.br.petshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.br.petshop.Database.Model.modelCliente;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;


@WebServlet(name = "UpdateCliente", urlPatterns = { "/updateCliente" })
public class UpdateClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeCliente = request.getParameter("nomeCliente");
		String nome = request.getParameter("nome");
		String telefone = request.getParameter("phone");
		String endereco = request.getParameter("endereco");
		String nomePet = request.getParameter("nomePet");
		
		ArrayList<modelCliente> listaClientes = (ArrayList<modelCliente>)request.getSession().getAttribute("listaClientes");
		for (modelCliente cliente : listaClientes) {
			if(cliente.getNome().equals(nomeCliente)) {
				cliente.setNome(nome);
				cliente.setTelefone(telefone);
				cliente.setNomePets(nomePet);
			}
		}
		request.setAttribute("listaClientes", listaClientes);
		
		RequestDispatcher rd = request.getRequestDispatcher("/clienteAlterado.jsp");
		request.setAttribute("nomeCliente", nomeCliente);
		rd.forward(request, response);
	}
}