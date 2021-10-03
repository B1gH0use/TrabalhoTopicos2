package com.br.petshop;

import java.io.IOException;

import com.br.petshop.Objs.Cliente;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;


@WebServlet(name = "addNovoCliente", urlPatterns = { "/addNovoCliente" })
public class UpdateClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeCliente = request.getParameter("nomeCliente");
		String telefone = request.getParameter("phone");
		String endereco = request.getParameter("endereco");
		String nomePet = request.getParameter("NomePet");
		
		Cliente cliente = new Cliente();
		cliente.setNome(nomeCliente);
		cliente.setEndereco(endereco);
		cliente.setTelefone(telefone);
		cliente.setNomePets(nomePet);
		
		request.getSession().setAttribute(nomeCliente, cliente.getNome());
		request.getSession().setAttribute(endereco, cliente.getEndereco());
		request.getSession().setAttribute(telefone, cliente.getTelefone());
		request.getSession().setAttribute(nomePet, cliente.getNomePets());
		
	}
}