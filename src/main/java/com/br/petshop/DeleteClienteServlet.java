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
import jakarta.servlet.ServletException;

@WebServlet(name = "DeleteCliente", urlPatterns = { "/DeleteCliente" })
public class DeleteClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeCliente = request.getParameter("nomeCliente");
		PrintWriter out = response.getWriter();
		
		ArrayList<Cliente> listaClientes = (ArrayList<Cliente>)request.getSession().getAttribute("listaClientes");
		for (Cliente cliente : listaClientes) {
			if(cliente.getNome().equals(nomeCliente)) {
				listaClientes.remove(cliente);
			}
		}
		request.setAttribute("listaClientes", listaClientes);
		

		out.println("<html>"
				+ "<link rel=\"stylesheet\" href=\"style.css\">\r\n"
				+ "<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n"
				+ "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n"
				+ "<link href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap\" rel=\"stylesheet\">"
				+ "<body>");
		out.println("Cliente " + nomeCliente + " excluído.");
		
		out.println("</body></html>");
	}

}
