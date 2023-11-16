package br.edu.univasf.agencia_turismo.controller;

import br.edu.univasf.agencia_turismo.dao.ClienteDAO;
import br.edu.univasf.agencia_turismo.model.Cliente;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.IOException;

public class RemocaoClientesController {

    @FXML
    private TextField cpfField;
    @FXML
    private TextField nomeField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField telefoneField;
    @FXML
    private TextField historicoField;
    @FXML
    private TextField preferenciasField;
    @FXML
    private Button botaoVoltar;
    private ClienteDAO clienteDAO;

    public void initialize() {
        this.clienteDAO = new ClienteDAO();
    }

    @FXML
    private void onBuscarButtonClick() {
        String cpf = cpfField.getText();

        if (cpf.isEmpty()) {
            showAlert("Erro", "CPF não pode estar vazio");
            return;
        }

        Cliente cliente = clienteDAO.buscarCliente(cpf);

        if (cliente == null) {
            showAlert("Cliente não encontrado", "Não foi possível encontrar um cliente com o CPF fornecido.");
            return;
        }

        preencherCampos(cliente);
    }

    @FXML
    private void onRemoverButtonClick() {
        String cpf = cpfField.getText();

        if (cpf.isEmpty()) {
            showAlert("Erro", "CPF não pode estar vazio");
            return;
        }

        Cliente cliente = clienteDAO.buscarCliente(cpf);

        if (cliente == null) {
            showAlert("Cliente não encontrado", "Não foi possível encontrar um cliente com o CPF fornecido.");
            return;
        }

        clienteDAO.removerCliente(cliente.getCpf());
        showAlert("Sucesso", "Cliente removido com sucesso!");

        limparCampos();
    }

    @FXML
    private void onVoltarButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/edu/univasf/agencia_turismo/controller/clientes.fxml"));
            Parent home = loader.load();
            Scene scene = botaoVoltar.getScene();
            scene.setRoot(home);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void preencherCampos(Cliente cliente) {
        nomeField.setText(cliente.getNome());
        emailField.setText(cliente.getEmail());
        telefoneField.setText(cliente.getTelefone());
        historicoField.setText(cliente.getHistoricoViagens());
        preferenciasField.setText(cliente.getPreferencias());
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void limparCampos() {
        nomeField.clear();
        emailField.clear();
        telefoneField.clear();
        historicoField.clear();
        preferenciasField.clear();
    }
}
