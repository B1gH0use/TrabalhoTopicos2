package com.br.petshop.Database.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.br.petshop.Database.Model.modelProduto;

public class DAOproduto extends AbstractDAO{

	private String selectAllProdutos = "SELECT * FROM PETSHOP.PRODUTO";
	
	private String insertProdutos = "INSERT INTO PETSHOP.PRODUTO (IDPRODUTO, NOME, PRECO, MARCA, DESCRICAO, QUANTIDADE) VALUES (?, ?, ?, ?, ?, ?)";
	
	private String deleteProdutos = "DELETE FROM PETSHOP.PRODUTO WHERE IDPRODUTO = ?";
	
	private String updateProdutos = "UPDATE PETSHOP.PRODUTO SET NOME = ?, PRECO = ?, MARCA = ?, DESCRICAO = ?, QUANTIDADE = ? WHERE IDPRODUTO = ?";
	
	private PreparedStatement PSselectAllProdutos;
	private PreparedStatement PSDeleteProdutos;
	private PreparedStatement PSinsertProduto;
	private PreparedStatement PSupdateProduto;
	
	public DAOproduto(final Connection conn) throws SQLException {
		PSselectAllProdutos = conn.prepareStatement(selectAllProdutos);
		PSinsertProduto = conn.prepareStatement(insertProdutos);
		PSDeleteProdutos = conn.prepareStatement(deleteProdutos);
		PSupdateProduto = conn.prepareStatement(updateProdutos);
	}
	
	@Override
	public List<Object> Select(Object as_parameter) throws SQLException {
		return null;
	}

	@Override
	public List<Object> SelectWithOutParameter() throws SQLException {
		ArrayList<Object> arlProdutos = new ArrayList<Object>();
		
		ResultSet result = PSselectAllProdutos.executeQuery();
		
		while(result.next()){
			
			modelProduto produto = new modelProduto();
			
			produto.setId(result.getString("idproduto"));
			produto.setNome(result.getString("nome"));
			produto.setPreco(result.getString("preco"));
			produto.setMarca(result.getString("marca"));
			produto.setDescricao(result.getString("descricao"));
			produto.setQntidade(result.getString("quantidade"));
			
			arlProdutos.add(produto);
	
		}
		result.close();
		
		return arlProdutos;
	}

	@Override
	public void Insert(Object ao_object) throws SQLException {
		modelProduto produto = (modelProduto) ao_object;
		
		Set(PSinsertProduto, 1, produto.getId());
		Set(PSinsertProduto, 2, produto.getNome());
		Set(PSinsertProduto, 3, produto.getPreco());
		Set(PSinsertProduto, 4, produto.getMarca());
		Set(PSinsertProduto, 5, produto.getDescricao());
		Set(PSinsertProduto, 6, produto.getQntidade());
		
		
		PSinsertProduto.execute();
	}

	@Override
	public void Update(Object ao_object) throws SQLException {
		modelProduto produto = (modelProduto) ao_object;		
		
		Set(PSDeleteProdutos, 1, produto.getNome());
		Set(PSDeleteProdutos, 2, produto.getPreco());
		Set(PSDeleteProdutos, 3, produto.getMarca());
		Set(PSDeleteProdutos, 4, produto.getDescricao());
		Set(PSDeleteProdutos, 5, produto.getQntidade());
		Set(PSDeleteProdutos, 6, produto.getId());

		PSupdateProduto.execute();

	}

	@Override
	public void Delete(Object ao_object) throws SQLException {
		modelProduto produto = (modelProduto) ao_object;
		Set(PSDeleteProdutos, 1, produto.getId());
		
		PSDeleteProdutos.execute();
	}

}
