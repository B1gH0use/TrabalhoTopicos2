package com.br.petshop.Database.Model;

public class modelProduto {
	private int id;
	private String nome;
	private String preco;
	private String marca;
	private String descricao;
	private String qntidade;
	
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
	
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getQntidade() {
		return qntidade;
	}
	public void setQntidade(String qntidade) {
		this.qntidade = qntidade;
	}
	
	
}
