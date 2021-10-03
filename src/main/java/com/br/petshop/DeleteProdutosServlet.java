package com.br.petshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.br.petshop.Objs.Produto;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

@WebServlet(name = "DeleteProdutos", urlPatterns = { "/listarProdutos" })
public class DeleteProdutosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		Produto ss = (Produto)request.getSession().getAttribute("produto");

		out.println("<html><body>");

		System.out.print(ss.getId());
		System.out.print(ss.getNome());
		System.out.print(ss.getDescricao());
		System.out.print(ss.getMarca());
		System.out.print(ss.getPreco());
		System.out.print(ss.getQntidade());
		
		out.println("</body></html>");
	}

}
