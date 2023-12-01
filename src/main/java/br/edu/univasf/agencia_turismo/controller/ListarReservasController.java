package br.edu.univasf.agencia_turismo.controller;


import br.edu.univasf.agencia_turismo.model.Reserva;
import br.edu.univasf.agencia_turismo.service.ReservaService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;


public class ListarReservasController {

    @FXML
    private AnchorPane layoutPrincipal;

    @FXML
    private Button botaoVoltar;
    @FXML
    private TableView<Reserva> tableView;
    @FXML
    private TableColumn<Reserva, Integer> coluna_id;
    @FXML
    private TableColumn<Reserva, String> coluna_cpf;
    @FXML
    private TableColumn<Reserva, Integer> coluna_pacote;
    @FXML
    private TableColumn<Reserva, Timestamp> coluna_data;
    @FXML
    private TableColumn<Reserva, Integer> coluna_vagas;


    @FXML
    private void initialize() {
        // Configurar as colunas com as propriedades de célula
        coluna_id.setCellValueFactory(new PropertyValueFactory<>("idReserva"));
        coluna_cpf.setCellValueFactory(new PropertyValueFactory<>("cpfCliente"));
        coluna_pacote.setCellValueFactory(new PropertyValueFactory<>("codigoPacote"));
        coluna_data.setCellValueFactory(new PropertyValueFactory<>("dataReserva"));
        coluna_vagas.setCellValueFactory(new PropertyValueFactory<>("quantidadeVagasSolicitadas"));

        // Carregar os pacotes na tabela
        carregarReservas();
    }

    private void carregarReservas() {
        ReservaService reservaService = new ReservaService();
        List<Reserva> listaReservas = reservaService.listarReservas();

        // Adicione a lista de pacotes à tabela
        tableView.getItems().clear();
        tableView.getItems().addAll(listaReservas);
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
