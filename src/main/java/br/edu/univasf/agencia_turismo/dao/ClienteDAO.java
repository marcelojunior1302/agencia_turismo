package br.edu.univasf.agencia_turismo.dao;

import br.edu.univasf.agencia_turismo.model.Cliente;
import br.edu.univasf.agencia_turismo.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void adicionarCliente(Cliente cliente) {

        Connection conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO cliente (cpf, nome, email, telefone, historicoViagens, preferencias) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getHistoricoViagens());
            stmt.setString(6, cliente.getPreferencias());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cliente buscarCliente(String cpf) {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM cliente WHERE cpf = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setTelefone(rs.getString("telefone"));
                    cliente.setHistoricoViagens(rs.getString("historicoViagens"));
                    cliente.setPreferencias(rs.getString("preferencias"));


                    return cliente;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void atualizarCliente(Cliente cliente) {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "UPDATE cliente SET nome = ?, email = ?, telefone = ?, historicoViagens = ?, preferencias = ? WHERE cpf = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getHistoricoViagens());
            stmt.setString(5, cliente.getPreferencias());
            stmt.setString(6, cliente.getCpf());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerCliente(String cpf) {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "DELETE FROM cliente WHERE cpf = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM cliente";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setTelefone(rs.getString("telefone"));
                    cliente.setHistoricoViagens(rs.getString("historicoViagens"));
                    cliente.setPreferencias(rs.getString("preferencias"));

                    clientes.add(cliente);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }
}
