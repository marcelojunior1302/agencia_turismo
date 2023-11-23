package br.edu.univasf.agencia_turismo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import br.edu.univasf.agencia_turismo.model.PacoteTuristico;
import br.edu.univasf.agencia_turismo.service.PacoteService;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

public class CadastroPacoteController {

    @FXML
    private TextField codigoPacoteField;
    @FXML
    private TextField destinoField;
    @FXML
    private DatePicker dataPicker;
    @FXML
    private TextField itinerarioField;
    @FXML
    private TextField precoField;
    @FXML
    private TextField descricaoField;
    @FXML
    private TextField vagasField;
    @FXML
    private Button botaoVoltar;

    @FXML
    private void finalizarCadastro() {

        try {
            int codigoPacote = Integer.parseInt(codigoPacoteField.getText());
            String destino = destinoField.getText();
            Date data = java.sql.Date.valueOf(dataPicker.getValue());
            String itinerario = itinerarioField.getText();
            BigDecimal preco = new BigDecimal(precoField.getText());
            String descricao = descricaoField.getText();
            int quantidadeVagas = Integer.parseInt(vagasField.getText());

            PacoteTuristico novoPacote = new PacoteTuristico(codigoPacote, destino, data, itinerario, preco, descricao, quantidadeVagas);

            PacoteService pacoteService = new PacoteService();
            pacoteService.adicionarPacote(novoPacote);

            exibirAlerta();

            limparCampos();
        } catch (NumberFormatException e) {
            exibirAlertaErro();
        }
    }

    @FXML
    private void onVoltarButtonClick() {
        try {
            // Aqui, substitua o caminho do FXML conforme necessário
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pacotes.fxml"));
            Parent home = loader.load();
            Scene scene = botaoVoltar.getScene();
            scene.setRoot(home);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void limparCampos() {
        codigoPacoteField.clear();
        destinoField.clear();
        dataPicker.setValue(null);
        itinerarioField.clear();
        precoField.clear();
        descricaoField.clear();
        vagasField.clear();
    }

    private void exibirAlerta() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informação");
        alert.setHeaderText(null);
        alert.setContentText("Cadastro realizado com sucesso!");
        alert.showAndWait();
    }

    private void exibirAlertaErro() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro de Formato");
        alert.setHeaderText(null);
        alert.setContentText("Certifique-se de preencher os campos corretamente.");
        alert.showAndWait();
    }
}
