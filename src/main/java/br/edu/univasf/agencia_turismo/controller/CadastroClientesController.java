package br.edu.univasf.agencia_turismo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import br.edu.univasf.agencia_turismo.model.Cliente;
import br.edu.univasf.agencia_turismo.service.ClienteService;

import java.io.IOException;

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
    private Button botaoVoltar;

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

    @FXML
    private void onVoltarButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/edu/univasf/agencia_turismo/controller/clientes.fxml"));
            Parent home = loader.load();
            Scene scene = botaoVoltar.getScene();
            scene.setRoot(home);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void limparCampos() {
        nomeField.clear();
        emailField.clear();
        telefoneField.clear();
        historicoField.clear();
        preferenciasField.clear();
    }
}
