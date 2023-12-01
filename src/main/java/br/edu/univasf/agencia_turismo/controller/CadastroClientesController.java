package br.edu.univasf.agencia_turismo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import br.edu.univasf.agencia_turismo.model.Cliente;
import br.edu.univasf.agencia_turismo.service.ClienteService;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CadastroClientesController {

    @FXML
    private AnchorPane layoutPrincipal;

    @FXML
    private TextField cpfField;
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
    private Button botaoVoltar;

    @FXML
    private void finalizarCadastro() {

        String cpf = cpfField.getText();
        String nome = nomeField.getText();
        String email = emailField.getText();
        String telefone = telefoneField.getText();
        String historicoViagens = historicoField.getText();
        String preferencias = preferenciasField.getText();

        Cliente novoCliente = new Cliente(cpf, nome, email, telefone, historicoViagens, preferencias);

        ClienteService clienteService = new ClienteService();
        clienteService.adicionarCliente(novoCliente);

        exibirAlerta();

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
        cpfField.clear();
        nomeField.clear();
        emailField.clear();
        telefoneField.clear();
        historicoField.clear();
        preferenciasField.clear();
    }

    private void exibirAlerta() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Informação");
        alert.setHeaderText(null);
        alert.setContentText("Cadastro realizado com sucesso!");
        alert.showAndWait();
    }

    @FXML
    private void mostraInterfacePacotes() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pacotes.fxml"));
            Parent pacotesInterface = loader.load();

            Scene scene = layoutPrincipal.getScene();
            scene.setRoot(pacotesInterface);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
