package com.br.petshop.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
	
	private Connection conexao = null;

	private String host = "localhost";
	
	private String banco = "teste";
	
	private String url = "jdbc:mysql://" + host + "/" + banco;

	private String usuario = "root";

	private String senha = "root";

	
	
	private Singleton() {
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static Singleton instacia = null;
	
	public static synchronized Singleton getIntancia() {
		if(instacia == null) {
			System.out.println("criada");
			instacia = new Singleton();
		}
		return instacia;
	}
	
	
	public boolean fecharConexao() {
		if (conexao != null) {
			try {
				conexao.close();
				System.out.println("Conexao Fechada");
				return true;
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return false;
	}
	
}
