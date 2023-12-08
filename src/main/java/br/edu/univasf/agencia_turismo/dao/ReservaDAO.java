package br.edu.univasf.agencia_turismo.dao;

import br.edu.univasf.agencia_turismo.model.Reserva;
import br.edu.univasf.agencia_turismo.util.ConnectionFactory;
import br.edu.univasf.agencia_turismo.util.ReservaNaoEncontradaException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    public void adicionarReserva(Reserva reserva) {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO reserva (cpf_cliente, codigo_pacote, data_reserva, quantidade_vagas_solicitadas) " +
                "VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, reserva.getCpfCliente());
            stmt.setInt(2, reserva.getCodigoPacote());
            stmt.setTimestamp(3, reserva.getDataReserva());
            stmt.setInt(4, reserva.getQuantidadeVagasSolicitadas());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Reserva buscarReserva(int idReserva) {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM reserva WHERE id_reserva = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idReserva);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Reserva reserva = new Reserva();
                    reserva.setIdReserva(rs.getInt("id_reserva"));
                    reserva.setCpfCliente(rs.getString("cpf_cliente"));
                    reserva.setCodigoPacote(rs.getInt("codigo_pacote"));
                    reserva.setDataReserva(rs.getTimestamp("data_reserva"));
                    reserva.setQuantidadeVagasSolicitadas(rs.getInt("quantidade_vagas_solicitadas"));

                    return reserva;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void atualizarReserva(Reserva reserva) {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "UPDATE reserva SET cpf_cliente = ?, codigo_pacote = ?, data_reserva = ?, " +
                "quantidade_vagas_solicitadas = ? WHERE id_reserva = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, reserva.getCpfCliente());
            stmt.setInt(2, reserva.getCodigoPacote());
            stmt.setTimestamp(3, reserva.getDataReserva());
            stmt.setInt(4, reserva.getQuantidadeVagasSolicitadas());
            stmt.setInt(5, reserva.getIdReserva());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerReserva(int idReserva) {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "DELETE FROM reserva WHERE id_reserva = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idReserva);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas == 0) {
                // Se nenhuma linha foi afetada, a reserva não foi encontrada
                throw new ReservaNaoEncontradaException("Reserva com ID " + idReserva + " não encontrada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ReservaNaoEncontradaException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Reserva> listarReservas() {
        List<Reserva> reservas = new ArrayList<>();
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM reserva";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Reserva reserva = new Reserva();
                    reserva.setIdReserva(rs.getInt("id_reserva"));
                    reserva.setCpfCliente(rs.getString("cpf_cliente"));
                    reserva.setCodigoPacote(rs.getInt("codigo_pacote"));
                    reserva.setDataReserva(rs.getTimestamp("data_reserva"));
                    reserva.setQuantidadeVagasSolicitadas(rs.getInt("quantidade_vagas_solicitadas"));

                    reservas.add(reserva);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservas;
    }

    public List<Reserva> listarReservasCPF(String cpf) {
        List<Reserva> reservas = new ArrayList<>();
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM reserva WHERE cpf_cliente = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf); // Define o valor do parâmetro CPF
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Reserva reserva = new Reserva();
                    reserva.setIdReserva(rs.getInt("id_reserva"));
                    reserva.setCpfCliente(rs.getString("cpf_cliente"));
                    reserva.setCodigoPacote(rs.getInt("codigo_pacote"));
                    reserva.setDataReserva(rs.getTimestamp("data_reserva"));
                    reserva.setQuantidadeVagasSolicitadas(rs.getInt("quantidade_vagas_solicitadas"));

                    reservas.add(reserva);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return reservas;
    }

}
