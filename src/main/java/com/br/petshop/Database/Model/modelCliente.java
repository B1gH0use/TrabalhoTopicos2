package com.br.petshop.Database.Model;

public class modelCliente {
	private int id;
	private String nome;
	private String telefone; 
	private String NomePets;
	
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
