package com.br.petshop.Database.Model;

public class modelCliente {
	private String id;
	private String nome;
	private String telefone; 
	private String NomePets;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getNomePets() {
		return NomePets;
	}
	public void setNomePets(String nomePets) {
		NomePets = nomePets;
	}
}
