package br.edu.univasf.agencia_turismo.controller;

import br.edu.univasf.agencia_turismo.service.ClienteService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import br.edu.univasf.agencia_turismo.model.Reserva;
import br.edu.univasf.agencia_turismo.service.ReservaService;
import br.edu.univasf.agencia_turismo.service.PacoteService;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class FazerReservaController {

    @FXML
    private TextField cpfField;

    @FXML
    private TextField codigoPacoteField;

    @FXML
    private TextField vagasField;

    @FXML
    private Button botaoVoltar;

    @FXML
    private void confirmarReserva() {
        try {
            String cpfCliente = cpfField.getText();
            int codigoPacote = Integer.parseInt(codigoPacoteField.getText());
            int quantidadeVagas = Integer.parseInt(vagasField.getText());
            Date dataAtual = new Date();
            Timestamp dataReserva = new Timestamp(dataAtual.getTime());

            Reserva novaReserva = new Reserva(0, cpfCliente, codigoPacote, dataReserva, quantidadeVagas);

            ReservaService reservaService = new ReservaService();
            PacoteService pacoteService = new PacoteService();
            ClienteService clienteService = new ClienteService();


            if (!clienteService.verificarClienteExistente(cpfCliente)) {
                exibirAlertaErro("Cliente não encontrado. Verifique o CPF.");
                return;
            }


            if (!pacoteService.verificarPacoteExistente(codigoPacote)) {
                exibirAlertaErro("Pacote não encontrado. Verifique o código do pacote.");
                return;
            }


            if (!pacoteService.verificarVagasDisponiveis(codigoPacote, quantidadeVagas)) {
                exibirAlertaErro("Não há vagas disponíveis para a quantidade solicitada.");
                return;
            }


            reservaService.adicionarReserva(novaReserva);

            exibirAlerta("Reserva realizada com sucesso!");
        } catch (NumberFormatException e) {
            exibirAlertaErro("Certifique-se de preencher os campos corretamente.");
        } catch (Exception e) {
            exibirAlertaErro("Ocorreu um erro ao processar a reserva. Tente novamente mais tarde.");
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

    private void exibirAlerta(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informação");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    private void exibirAlertaErro(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
