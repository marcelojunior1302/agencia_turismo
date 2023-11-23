package br.edu.univasf.agencia_turismo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class HomeController  {

    @FXML
    private AnchorPane layoutPrincipal;

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
