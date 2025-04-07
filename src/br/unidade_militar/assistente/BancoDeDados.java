package br.unidade_militar.assistente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDeDados {
    private static final String URL = "jdbc:mysql://localhost:3306/sessaoinformatica";
    private static final String USUARIO = "root";
    private static final String SENHA = "Persch12";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }
}
