package br.edu.univasf.agencia_turismo.controller;

import br.edu.univasf.agencia_turismo.model.PacoteTuristico;
import br.edu.univasf.agencia_turismo.service.PacoteService;
import br.edu.univasf.agencia_turismo.util.CustomDateConverter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import java.io.IOException;
import java.sql.Date;
import java.util.List;


public class ListaPacotesController {

    @FXML
    private Button botaoVoltar;
    @FXML
    private TableView<PacoteTuristico> tableView;
    @FXML
    private TableColumn<PacoteTuristico, Integer> coluna_codigo;
    @FXML
    private TableColumn<PacoteTuristico, String> coluna_destino;
    @FXML
    private TableColumn<PacoteTuristico, Date> coluna_data;
    @FXML
    private TableColumn<PacoteTuristico, String> coluna_preco;
    @FXML
    private TableColumn<PacoteTuristico, String> coluna_itinerario;
    @FXML
    private TableColumn<PacoteTuristico, String> coluna_descricao;
    @FXML
    private TableColumn<PacoteTuristico, Integer> coluna_vagas;

    @FXML
    private void initialize() {
        // Configurar as colunas com as propriedades de célula
        coluna_codigo.setCellValueFactory(new PropertyValueFactory<>("codigoPacote"));
        coluna_destino.setCellValueFactory(new PropertyValueFactory<>("destino"));
        coluna_data.setCellValueFactory(new PropertyValueFactory<>("data"));
        coluna_data.setCellFactory(TextFieldTableCell.forTableColumn(new CustomDateConverter()));

        coluna_preco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        coluna_itinerario.setCellValueFactory(new PropertyValueFactory<>("itinerario"));
        coluna_descricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        coluna_vagas.setCellValueFactory(new PropertyValueFactory<>("quantidadeVagas"));

        // Carregar os pacotes na tabela
        carregarPacotes();
    }

    private void carregarPacotes() {
        PacoteService pacoteService = new PacoteService();
        List<PacoteTuristico> listaPacotes = pacoteService.listarPacotes();

        // Adicione a lista de pacotes à tabela
        tableView.getItems().clear();
        tableView.getItems().addAll(listaPacotes);
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
}
