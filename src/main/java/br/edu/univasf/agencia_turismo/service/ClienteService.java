package br.edu.univasf.agencia_turismo.service;

import br.edu.univasf.agencia_turismo.model.Cliente;
import br.edu.univasf.agencia_turismo.dao.ClienteDAO;

import java.util.List;

public class ClienteService {
    private final ClienteDAO clienteDAO;

    public ClienteService() {
        this.clienteDAO = new ClienteDAO();
    }

    public void adicionarCliente(Cliente cliente) {
        clienteDAO.adicionarCliente(cliente);
    }

    public Cliente buscarCliente(String cpf) {
        return clienteDAO.buscarCliente(cpf);
    }

    public void atualizarCliente(Cliente cliente) {
        clienteDAO.atualizarCliente(cliente);
    }

    public void removerCliente(String cpf) {
        clienteDAO.removerCliente(cpf);
    }

    public List<Cliente> listarClientes() {
        return clienteDAO.listarClientes();
    }
}
