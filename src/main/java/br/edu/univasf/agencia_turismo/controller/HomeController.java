package br.edu.univasf.agencia_turismo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private AnchorPane layoutPrincipal;

    @FXML
    private void mostrarInterfaceClientes() {
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
