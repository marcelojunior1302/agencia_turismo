package br.edu.univasf.agencia_turismo.controller;

import br.edu.univasf.agencia_turismo.model.PacoteTuristico;
import br.edu.univasf.agencia_turismo.service.PacoteService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

public class RemocaoPacoteController {

    @FXML
    private Button botaoVoltar;
    @FXML
    private TextField codigoPacoteField;
    @FXML
    private TextField precoField;
    @FXML
    private TextField descricaoField;
    @FXML
    private TextField itinerarioField;
    @FXML
    private TextField destinoField;
    @FXML
    private DatePicker dataPicker;
    @FXML
    private TextField vagasField;

    private PacoteService pacoteService;

    public void initialize() {
        this.pacoteService = new PacoteService();
    }

    @FXML
    private void onBuscarButtonClick() {
        try {
            int codigoPacote = Integer.parseInt(codigoPacoteField.getText());
            PacoteTuristico pacote = pacoteService.buscarPacote(codigoPacote);

            if (pacote != null) {
                preencherCampos(pacote);
            } else {
                showAlert("Pacote não encontrado", "Não foi possível encontrar um pacote com o código fornecido.");
                limparCampos();
            }
        } catch (NumberFormatException e) {
            showAlert("Erro", "Por favor, insira um código válido.");
        }
    }

    @FXML
    private void onRemoverPacoteButtonClick() {
        try {
            int codigoPacote = Integer.parseInt(codigoPacoteField.getText());

            PacoteTuristico pacote = pacoteService.buscarPacote(codigoPacote);

            if (pacote != null) {
                // Mostrar um diálogo de confirmação antes de remover
                boolean confirmacao = showConfirmationDialog("Confirmação", "Tem certeza que deseja remover o pacote?");

                if (confirmacao) {
                    pacoteService.removerPacote(codigoPacote);
                    showAlert("Sucesso", "Pacote removido com sucesso!");
                    limparCampos();
                }
            } else {
                showAlert("Pacote não encontrado", "Não foi possível encontrar um pacote com o código fornecido.");
            }
        } catch (NumberFormatException e) {
            showAlert("Erro", "Por favor, insira um código válido.");
        }
    }

    @FXML
    private void onVoltarButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/edu/univasf/agencia_turismo/controller/pacotes.fxml"));
            Parent home = loader.load();
            Scene scene = botaoVoltar.getScene();
            scene.setRoot(home);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void preencherCampos(PacoteTuristico pacote) {
        precoField.setText(String.valueOf(pacote.getPreco()));
        descricaoField.setText(pacote.getDescricao());
        itinerarioField.setText(pacote.getItinerario());
        destinoField.setText(pacote.getDestino());
        java.sql.Date dataSql = (Date) pacote.getData();
        java.util.Date dataUtil = new java.util.Date(dataSql.getTime());
        LocalDate localDate = dataUtil.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        dataPicker.setValue(localDate);
        vagasField.setText(String.valueOf(pacote.getQuantidadeVagas()));
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void limparCampos() {
        precoField.clear();
        descricaoField.clear();
        itinerarioField.clear();
        destinoField.clear();
        dataPicker.setValue(null);
        vagasField.clear();
    }

    private boolean showConfirmationDialog(String title, String content) {
        Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationDialog.setTitle(title);
        confirmationDialog.setHeaderText(null);
        confirmationDialog.setContentText(content);

        // Botões padrão do diálogo de confirmação do JavaFX
        ButtonType simButton = new ButtonType("Sim");
        ButtonType naoButton = new ButtonType("Não");

        confirmationDialog.getButtonTypes().setAll(simButton, naoButton);

        // Mostrar o diálogo e aguardar a resposta do usuário
        Optional<ButtonType> result = confirmationDialog.showAndWait();

        // Retornar verdadeiro se o usuário clicar em "Sim", falso caso contrário
        return result.isPresent() && result.get() == simButton;
    }



}
