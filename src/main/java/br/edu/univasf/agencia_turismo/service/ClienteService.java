package br.edu.univasf.agencia_turismo.service;

import br.edu.univasf.agencia_turismo.model.Cliente;
import br.edu.univasf.agencia_turismo.dao.ClienteDAO;

import java.util.List;

public class ClienteService {
    private ClienteDAO clienteDAO;

    public ClienteService() {
        this.clienteDAO = new ClienteDAO();
    }

    public void adicionarCliente(Cliente cliente) {
        clienteDAO.adicionarCliente(cliente);
    }

    public Cliente buscarCliente(int id) {
        return clienteDAO.buscarCliente(id);
    }

    public void atualizarCliente(Cliente cliente) {
        clienteDAO.atualizarCliente(cliente);
    }

    public void removerCliente(int id) {
        clienteDAO.removerCliente(id);
    }

    public List<Cliente> listarClientes() {
        return clienteDAO.listarClientes();
    }
}
