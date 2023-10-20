package br.edu.univasf.agencia_turismo.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import br.edu.univasf.agencia_turismo.model.Cliente;
import br.edu.univasf.agencia_turismo.service.ClienteService;

public class CadastroClientesController {

    @FXML
    private TextField nomeField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField telefoneField;
    @FXML
    private TextField historicoField;
    @FXML
    private TextField preferenciasField;
    @FXML
    private Button finalizarCadastroButton;

    @FXML
    private void finalizarCadastro() {

        String nome = nomeField.getText();
        String email = emailField.getText();
        String telefone = telefoneField.getText();
        String historicoViagens = historicoField.getText();
        String preferencias = preferenciasField.getText();

        Cliente novoCliente = new Cliente(nome, email, telefone, historicoViagens, preferencias);

        ClienteService clienteService = new ClienteService();
        clienteService.adicionarCliente(novoCliente);

        limparCampos();
    }

    private void limparCampos() {
        nomeField.clear();
        emailField.clear();
        telefoneField.clear();
        historicoField.clear();
        preferenciasField.clear();
    }
}
