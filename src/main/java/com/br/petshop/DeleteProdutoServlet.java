package com.br.petshop;

import java.io.IOException;
import java.io.PrintWriter;

import com.br.petshop.Objs.Produto;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

@WebServlet(name = "DeleteProduto", urlPatterns = { "/DeleteProduto" })
public class DeleteProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		Produto ss = (Produto)request.getSession().getAttribute("produto");

		out.println("<html><body>");

		request.getSession().removeAttribute(ss.getNome());
		request.getSession().removeAttribute(ss.getDescricao());
		request.getSession().removeAttribute(ss.getMarca());
		request.getSession().removeAttribute(ss.getPreco());
		request.getSession().removeAttribute(ss.getQntidade());
		
		out.println("</body></html>");
	}

}
