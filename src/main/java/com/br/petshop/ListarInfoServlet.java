package com.br.petshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.br.petshop.Objs.Cliente;
import com.br.petshop.Objs.Produto;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

@WebServlet(name = "listarClientes", urlPatterns = { "/listarInfo" })
public class ListarInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
		
		if(session.getAttribute("listaClientes") != null) {
			listaClientes = (ArrayList<Cliente>) session.getAttribute("listaClientes");		
		} 
		
		if(session.getAttribute("listaProdutos") != null) {
			listaProdutos = (ArrayList<Produto>) session.getAttribute("listaProdutos");		
		} 
		
		request.setAttribute("listaClientes", listaClientes);
		request.setAttribute("listaProdutos", listaProdutos);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listarInfo.jsp");
		rd.forward(request, response);
	}

}
