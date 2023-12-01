package br.edu.univasf.agencia_turismo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class PacotesController {

    @FXML
    private AnchorPane layoutPrincipal;
    @FXML
    private Button removerPacoteButton;
    @FXML
    private Button cadastrarPacoteButton;
    @FXML
    private Button listarPacotesButton;
    @FXML
    private Button atualizarDadosPacoteButton;
    @FXML
    private Button fazerReservaButton;
    @FXML
    private Button cancelarReservaButton;
    @FXML
    private Button listarReservaButton;
    @FXML
    private Button botaoVoltar;

    @FXML
    private void onCadastrarPacoteButtonClick() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("cadastroPacote.fxml"));
            Parent cadastroPacotes = loader.load();

            Scene scene = cadastrarPacoteButton.getScene();
            scene.setRoot(cadastroPacotes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void onListarPacotesButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("listarPacotes.fxml"));
            Parent listarPacotes = loader.load();

            Scene scene = listarPacotesButton.getScene();
            scene.setRoot(listarPacotes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void onAtualizarDadosPacoteButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("atualizacaoPacote.fxml"));
            Parent atualizarPacotes = loader.load();

            Scene scene = atualizarDadosPacoteButton.getScene();
            scene.setRoot(atualizarPacotes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void onRemoverPacoteButtonClick() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("remocaoPacote.fxml"));
            Parent removerPacote = loader.load();

            Scene scene = removerPacoteButton.getScene();
            scene.setRoot(removerPacote);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void onVoltarButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/edu/univasf/agencia_turismo/home.fxml"));
            Parent home = loader.load();
            Scene scene = botaoVoltar.getScene();
            scene.setRoot(home);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onFazerReservaButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fazerReserva.fxml"));
            Parent fazerReserva = loader.load();

            Scene scene = fazerReservaButton.getScene();
            scene.setRoot(fazerReserva);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onCancelarReservaButtonClick(ActionEvent actionEvent) {
    }

    public void onListarReservaButtonClick() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("listarReservas.fxml"));
            Parent listarReservas = loader.load();

            Scene scene = listarReservaButton.getScene();
            scene.setRoot(listarReservas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void mostraInterfaceClientes() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("clientes.fxml"));
            Parent clientesInterface = loader.load();

            Scene scene = layoutPrincipal.getScene();
            scene.setRoot(clientesInterface);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
