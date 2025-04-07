package br.unidade_militar.assistente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Visita {
    private int id;
    private String tipoProblema;
    private Date data;
    private int idMilitarResponsavel;
    private int idInstalacaoVisitada;

    public Visita(String tipoProblema, Date data, int idMilitarResponsavel, int idInstalacaoVisitada) {
        this.tipoProblema = tipoProblema;
        this.data = data;
        this.idMilitarResponsavel = idMilitarResponsavel;
        this.idInstalacaoVisitada = idInstalacaoVisitada;
    }

    public boolean salvarNoBanco() {
        String sql = "INSERT INTO Visitas (Tipo_problema, Data, Id_usuario_responsavel, Id_Instalacao_visitada) VALUES (?, ?, ?, ?)";
        try (Connection conexao = BancoDeDados.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, tipoProblema);
            stmt.setDate(2, new java.sql.Date(data.getTime()));
            stmt.setInt(3, idMilitarResponsavel);
            stmt.setInt(4, idInstalacaoVisitada);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao salvar visita: " + e.getMessage());
            return false;
        }
    }
}
