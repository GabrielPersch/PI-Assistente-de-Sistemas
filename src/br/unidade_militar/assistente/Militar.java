package br.unidade_militar.assistente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Militar {
    private int id;
    private String nome;
    private int idade;
    private int numeroPraca;

    public Militar(String nome, int idade, int numeroPraca) {
        this.nome = nome;
        this.idade = idade;
        this.numeroPraca = numeroPraca;
    }

    public boolean salvarNoBanco() {
        String sql = "INSERT INTO Militares (Nome, Idade, Numero_praca) VALUES (?, ?, ?)";
        try (Connection conexao = BancoDeDados.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setInt(2, idade);
            stmt.setInt(3, numeroPraca);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao salvar militar: " + e.getMessage());
            return false;
        }
    }
}
