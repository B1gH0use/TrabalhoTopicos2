package com.br.petshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.br.petshop.Database.Singleton;
import com.br.petshop.Database.DAO.DAOclient;
import com.br.petshop.Database.Model.modelCliente;
import com.br.petshop.Database.Model.modelProduto;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

@WebServlet(name = "listarClientes", urlPatterns = { "/listarInfo" })
public class ListarInfoServlet extends HttpServlet {
	private Connection conn;
	List<Object> obj;
	private DAOclient dao;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		conn = (Connection) Singleton.getIntancia();
		ArrayList<modelCliente> listaClientes = new ArrayList<modelCliente>();
		ArrayList<modelProduto> listaProdutos = new ArrayList<modelProduto>();
		
		obj = dao.Select(conn);	
		
		for(Object ob : obj) {
			modelCliente cliente = (modelCliente) ob;
			modelCliente objnewCliente = new modelCliente();
			objnewCliente.setId(cliente.getId());
			objnewCliente.setNome(cliente.getNome());
			objnewCliente.setNomePets(cliente.getNomePets());
			objnewCliente.setTelefone(cliente.getTelefone());
			
			listaClientes.add(objnewCliente);
		}
		
		
		for(Object obj1 : obj) {
			modelProduto produto = (modelProduto) obj1;
			modelProduto objnewProduto = new modelProduto();
			objnewProduto.setId(produto.getId());
			objnewProduto.setNome(produto.getNome());
			objnewProduto.setMarca(produto.getMarca());
			objnewProduto.setPreco(produto.getPreco());
			objnewProduto.setQntidade(produto.getQntidade());
			
			listaProdutos.add(objnewProduto);
		}
		
		
		request.setAttribute("listaClientes", listaClientes);
		request.setAttribute("listaProdutos", listaProdutos);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listarInfo.jsp");
		rd.forward(request, response);
	}

}
