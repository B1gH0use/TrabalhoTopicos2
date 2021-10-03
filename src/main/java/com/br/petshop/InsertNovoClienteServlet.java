package com.br.petshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.br.petshop.Objs.Cliente;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import jakarta.servlet.ServletException;


@WebServlet(name = "addNovoCliente", urlPatterns = { "/addNovoCliente" })
public class InsertNovoClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		Cliente cliente1 = new Cliente();
		cliente1.setNome("Marcelo");
		cliente1.setEndereco("Rua");
		cliente1.setTelefone("3433-8557");
		cliente1.setNomePets("Teste");
		
		listaClientes.add(cliente1);
		request.getSession().setAttribute("listaClientes", listaClientes);
		
		if(session.getAttribute("listaClientes") != null) {
			listaClientes = (ArrayList<Cliente>) session.getAttribute("listaClientes");		
		} 
		
		String nomeCliente = request.getParameter("nomeCliente");
		String telefone = request.getParameter("phone");
		String endereco = request.getParameter("endereco");
		String nomePet = request.getParameter("NomePet");
		
		Cliente cliente = new Cliente();
		cliente.setNome(nomeCliente);
		cliente.setEndereco(endereco);
		cliente.setTelefone(telefone);
		cliente.setNomePets(nomePet);
		
		listaClientes.add(cliente);
		
		request.getSession().setAttribute("listaClientes", listaClientes);
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("Cliente " + nomeCliente  + "adicionado com sucesso!");
		out.println("<a href='index.html'>Voltar para a página inicial</a>");
		out.println("</body></html>");
	}
}
