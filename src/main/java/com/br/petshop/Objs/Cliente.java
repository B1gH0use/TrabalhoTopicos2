package com.br.petshop.Objs;

import java.util.List;

public class Cliente {
	private int id;
	private String nome;
	private List<String> pedidos;
	private String telefone; 
	private List<String> NomePets;
	private String endereco;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<String> getPedidos() {
		return pedidos;
	}
	public void setPedidos(String pedido) {
		this.pedidos.add(pedido);
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public List<String> getPets() {
		return NomePets;
	}
	public void setPets(String pet) {
		this.NomePets.add(pet);
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
}
