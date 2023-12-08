package br.edu.univasf.agencia_turismo.controller;

import br.edu.univasf.agencia_turismo.dao.PacoteDAO;
import br.edu.univasf.agencia_turismo.model.PacoteTuristico;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class AtualizacaoPacoteController {

    @FXML
    private AnchorPane layoutPrincipal;

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
    @FXML
    private Button botaoVoltar;

    private PacoteDAO pacoteDAO;

    public void initialize() {
        this.pacoteDAO = new PacoteDAO();
    }

    @FXML
    private void onBuscarButtonClick() {
        String codigoPacote = codigoPacoteField.getText();

        if (codigoPacote.isEmpty()) {
            showAlert("Erro", "Código do Pacote não pode estar vazio");
            return;
        }

        PacoteTuristico pacote = pacoteDAO.buscarPacote(Integer.parseInt(codigoPacote));

        if (pacote == null) {
            showAlert("Pacote não encontrado", "Não foi possível encontrar um pacote com o código fornecido.");
            return;
        }

        // Preencher os campos com os dados do pacote encontrado
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

    @FXML
    private void onAtualizarPacoteButtonClick() {
        // Obter os valores dos campos
        int codigoPacote = Integer.parseInt(codigoPacoteField.getText());
        BigDecimal preco = new BigDecimal(precoField.getText());
        String descricao = descricaoField.getText();
        String itinerario = itinerarioField.getText();
        String destino = destinoField.getText();
        Date data = java.sql.Date.valueOf(dataPicker.getValue());
        int quantidadeVagas = Integer.parseInt(vagasField.getText());

        // Criar um novo objeto Pacote com os valores atualizados
        // PacoteTuristico(int codigoPacote, String destino, Date data, String itinerario, BigDecimal preco, String descricao, int quantidadeVagas)
        PacoteTuristico pacoteAtualizado = new PacoteTuristico(codigoPacote, destino, data, itinerario, preco, descricao, quantidadeVagas);


        pacoteDAO.atualizarPacote(pacoteAtualizado);


        showAlert("Sucesso", "Pacote atualizado com sucesso!");


        limparCampos();
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
