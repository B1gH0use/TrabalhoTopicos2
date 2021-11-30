package com.br.petshop.Database;

import java.sql.Connection;
import java.sql.SQLException;

public class ConectarBanco {
	private static Connection conn;
	public static void main(String[] args) throws SQLException {
		
		conn = connectionFactory.getConnection("localhost", 3306, "petshop", "root", "root");

	}
}
