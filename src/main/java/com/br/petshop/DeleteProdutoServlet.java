package com.br.petshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
		
		String nomeProduto = request.getParameter("nomeProduto");
		PrintWriter out = response.getWriter();
		
		ArrayList<Produto> listaProdutos = (ArrayList<Produto>)request.getSession().getAttribute("listaProdutos");
		for (Produto produto : listaProdutos) {
			if(produto.getNome().equals(nomeProduto)) {
				listaProdutos.remove(produto);
			}
		}
		request.setAttribute("listaProdutos", listaProdutos);
		

		out.println("<html>"
				+ "<link rel=\"stylesheet\" href=\"style.css\">\r\n"
				+ "<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n"
				+ "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n"
				+ "<link href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap\" rel=\"stylesheet\">"
				+ "<body>");
		out.println("Produto " + nomeProduto + " excluído.");
		
		out.println("</body></html>");
	}

}
