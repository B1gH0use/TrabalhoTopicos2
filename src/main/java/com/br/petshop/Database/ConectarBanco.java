package com.br.petshop.Database;

public class ConectarBanco {
	public static void main(String[] args) {
		
		Singleton.getIntancia();
		
		Singleton.getIntancia().fecharConexao();
	}
}
