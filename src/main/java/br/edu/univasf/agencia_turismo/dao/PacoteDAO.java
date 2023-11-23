package br.edu.univasf.agencia_turismo.dao;

import br.edu.univasf.agencia_turismo.model.PacoteTuristico;
import br.edu.univasf.agencia_turismo.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacoteDAO {

    public void adicionarPacote(PacoteTuristico pacote) {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO pacote_turistico (codigo_pacote, destino, data, itinerario, preco, descricao, quantidade_vagas) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pacote.getCodigoPacote());
            stmt.setString(2, pacote.getDestino());
            stmt.setDate(3, new java.sql.Date(pacote.getData().getTime()));
            stmt.setString(4, pacote.getItinerario());
            stmt.setBigDecimal(5, pacote.getPreco());
            stmt.setString(6, pacote.getDescricao());
            stmt.setInt(7, pacote.getQuantidadeVagas());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PacoteTuristico buscarPacote(int codigoPacote) {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM pacote_turistico WHERE codigo_pacote = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codigoPacote);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    PacoteTuristico pacote = new PacoteTuristico();
                    pacote.setCodigoPacote(rs.getInt("codigo_pacote"));
                    pacote.setDestino(rs.getString("destino"));
                    pacote.setData(rs.getDate("data"));
                    pacote.setItinerario(rs.getString("itinerario"));
                    pacote.setPreco(rs.getBigDecimal("preco"));
                    pacote.setDescricao(rs.getString("descricao"));
                    pacote.setQuantidadeVagas(rs.getInt("quantidade_vagas"));

                    return pacote;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void atualizarPacote(PacoteTuristico pacote) {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "UPDATE pacote_turistico SET destino = ?, data = ?, itinerario = ?, preco = ?, descricao = ?, quantidade_vagas = ? " +
                "WHERE codigo_pacote = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pacote.getDestino());
            stmt.setDate(2, new java.sql.Date(pacote.getData().getTime()));
            stmt.setString(3, pacote.getItinerario());
            stmt.setBigDecimal(4, pacote.getPreco());
            stmt.setString(5, pacote.getDescricao());
            stmt.setInt(6, pacote.getQuantidadeVagas());
            stmt.setInt(7, pacote.getCodigoPacote());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerPacote(int codigoPacote) {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "DELETE FROM pacote_turistico WHERE codigo_pacote = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codigoPacote);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PacoteTuristico> listarPacotes() {
        List<PacoteTuristico> pacotes = new ArrayList<>();
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM pacote_turistico";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    PacoteTuristico pacote = new PacoteTuristico();
                    pacote.setCodigoPacote(rs.getInt("codigo_pacote"));
                    pacote.setDestino(rs.getString("destino"));
                    pacote.setData(rs.getDate("data"));
                    pacote.setItinerario(rs.getString("itinerario"));
                    pacote.setPreco(rs.getBigDecimal("preco"));
                    pacote.setDescricao(rs.getString("descricao"));
                    pacote.setQuantidadeVagas(rs.getInt("quantidade_vagas"));

                    pacotes.add(pacote);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pacotes;
    }
}
