package br.edu.univasf.agencia_turismo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.io.IOException;

public class ClientesController {

    @FXML
    private Button removerClienteButton;
    @FXML
    private Button cadastrarClienteButton;
    @FXML
    private Button listarClientesButton;
    @FXML
    private Button atualizarDadosButton;
    @FXML
    private Button botaoVoltar;

    @FXML
    private void onCadastrarClienteButtonClick() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("cadastroClientes.fxml"));
            Parent cadastroClientes = loader.load();

            Scene scene = cadastrarClienteButton.getScene();
            scene.setRoot(cadastroClientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void onListarClientesButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("listarClientes.fxml"));
            Parent listarClientes = loader.load();

            Scene scene = listarClientesButton.getScene();
            scene.setRoot(listarClientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void onAtualizarDadosButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("atualizacaoClientes.fxml"));
            Parent atualizarClientes = loader.load();

            Scene scene = atualizarDadosButton.getScene();
            scene.setRoot(atualizarClientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void onRemoverClienteButtonClick() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("remocaoClientes.fxml"));
            Parent removerCliente = loader.load();

            Scene scene = removerClienteButton.getScene();
            scene.setRoot(removerCliente);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void onVoltarButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/edu/univasf/agencia_turismo/home.fxml"));
            Parent clientes = loader.load();
            Scene scene = botaoVoltar.getScene();
            scene.setRoot(clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
