package com.br.petshop.Database.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.br.petshop.Database.Model.modelCliente;

public class DAOclient extends AbstractDAO{

	private String selectAllClients = "SELECT * FROM PETSHOP.CLIENTE";
	
	private String insertClients = "INSERT INTO PETSHOP.CLIENTE (IDCLIENTE, NOME, TELEFONE, NOME_PET) VALUES (?, ?, ?, ?)";
	
	private String deleteClients = "DELETE FROM PETSHOP.CLIENTE WHERE IDCLIENTE = ?";
	
	private String updateClients = "UPDATE PETSHOP.CLIENTE SET NOME = ?, TELEFONE = ?, NOME_PET = ? WHERE IDCLIENTE = ?";
	
	private PreparedStatement PSselectAllClients;
	private PreparedStatement PSdeleteClients;
	private PreparedStatement PSinsertClients;
	private PreparedStatement PSupdateClients;
	
	public DAOclient(final Connection conn) throws SQLException {
		PSselectAllClients = conn.prepareStatement(selectAllClients);
		PSdeleteClients = conn.prepareStatement(deleteClients);
		PSinsertClients = conn.prepareStatement(insertClients);
		PSupdateClients = conn.prepareStatement(updateClients);
	}
	
	@Override
	public List<Object> Select(Object as_parameter) throws SQLException {
		return null;
	}

	@Override
	public List<Object> SelectWithOutParameter() throws SQLException {
		ArrayList<Object> arlClients = new ArrayList<Object>();
		
		ResultSet result = PSselectAllClients.executeQuery();
		
		while(result.next()){
			
			modelCliente client = new modelCliente();
			
			client.setId(result.getInt("idcliente"));
			client.setNome(result.getString("nome"));
			client.setTelefone(result.getString("telefone"));
			client.setNomePets(result.getString("nome_pet"));
			
			arlClients.add(client);
	
		}
		result.close();
		
		return arlClients;
	}

	@Override
	public void Insert(Object ao_object) throws SQLException {
		modelCliente cliente = (modelCliente) ao_object;
		
		Set(PSinsertClients, 1, cliente.getId());
		Set(PSinsertClients, 2, cliente.getNome());
		Set(PSinsertClients, 3, cliente.getTelefone());
		Set(PSinsertClients, 4, cliente.getNomePets());
		
		PSinsertClients.execute();
	}

	@Override
	public void Update(Object ao_object) throws SQLException {
		modelCliente cliente = (modelCliente) ao_object;		
		
		Set(PSupdateClients, 1, cliente.getNome());
		Set(PSupdateClients, 2, cliente.getTelefone());
		Set(PSupdateClients, 3, cliente.getNomePets());
		Set(PSupdateClients, 4, cliente.getId());

		PSupdateClients.execute();

	}

	@Override
	public void Delete(Object ao_object) throws SQLException {
		modelCliente cliente = (modelCliente) ao_object;
		Set(PSdeleteClients, 1, cliente.getId());
		
		PSdeleteClients.execute();
	}

}
