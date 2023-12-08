package br.edu.univasf.agencia_turismo.controller;

import br.edu.univasf.agencia_turismo.model.Reserva;
import br.edu.univasf.agencia_turismo.service.ReservaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert.AlertType;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

public class CancelarReservaController {

    @FXML
    private AnchorPane layoutPrincipal;
    @FXML
    private TextField cpfField;

    @FXML
    private TextField idReservaField;

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
    private Button botaoVoltar;

    private ReservaService reservaService;

    public CancelarReservaController() {
        this.reservaService = new ReservaService();
    }

    @FXML
    private void initialize() {
        coluna_id.setCellValueFactory(new PropertyValueFactory<>("idReserva"));
        coluna_cpf.setCellValueFactory(new PropertyValueFactory<>("cpfCliente"));
        coluna_pacote.setCellValueFactory(new PropertyValueFactory<>("codigoPacote"));
        coluna_data.setCellValueFactory(new PropertyValueFactory<>("dataReserva"));
        coluna_vagas.setCellValueFactory(new PropertyValueFactory<>("quantidadeVagasSolicitadas"));
    }

    @FXML
    private void onBuscarButtonClick(ActionEvent event) {
        String cpf = cpfField.getText();
        // Verificar se o CPF está preenchido antes de chamar o serviço
        if (!cpf.isEmpty()) {
            carregarReservas(cpf);
        }
    }

    @FXML
    private void cancelarReserva(ActionEvent event) {
        // Obter o ID da reserva a ser cancelada
        String idReservaText = idReservaField.getText();
        if (!idReservaText.isEmpty()) {
            try {
                int idReserva = Integer.parseInt(idReservaText);

                // Chame o serviço para remover a reserva
                boolean removidoComSucesso = reservaService.removerReserva(idReserva);

                if (removidoComSucesso) {
                    // Atualize a TableView após o cancelamento
                    String cpf = cpfField.getText();
                    tableView.getItems().setAll(reservaService.listarReservasCPF(cpf));

                    // Exiba uma mensagem de sucesso
                    mostrarMensagem("Reserva cancelada com sucesso!", AlertType.INFORMATION);
                } else {
                    // Exiba uma mensagem se a reserva não pôde ser encontrada
                    mostrarMensagem("Reserva não encontrada. Verifique o ID inserido.", AlertType.WARNING);
                }
            } catch (NumberFormatException e) {
                // Exiba uma mensagem de erro se o ID da reserva não for um número
                mostrarMensagem("ID da reserva inválido. Insira um número válido.", AlertType.ERROR);
            } catch (Exception e) {
                // Exiba uma mensagem de erro genérica se algo der errado
                mostrarMensagem("Erro ao cancelar a reserva: " + e.getMessage(), AlertType.ERROR);
            }
        } else {
            // Exiba uma mensagem se o campo ID da reserva estiver vazio
            mostrarMensagem("Insira o ID da reserva a ser cancelada.", AlertType.WARNING);
        }
    }

    private void mostrarMensagem(String mensagem, AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle("Mensagem");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
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
    private void carregarReservas(String cpf) {
        ReservaService reservaService = new ReservaService();
        List<Reserva> listaReservas = reservaService.listarReservasCPF(cpf);

        // Adicione a lista de pacotes à tabela
        tableView.getItems().clear();
        tableView.getItems().addAll(listaReservas);
    }


}
