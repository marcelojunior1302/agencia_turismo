package br.edu.univasf.agencia_turismo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.io.IOException;

public class ClientesController {

    @FXML
    private Button cadastrarClienteButton;
    @FXML
    private void onCadastrarClienteButtonClick() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("cadastroClientes.fxml"));
            Parent cadastroClientes = loader.load();
            CadastroClientesController cadastroClientesController = loader.getController();

            Scene scene = cadastrarClienteButton.getScene();
            scene.setRoot(cadastroClientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
