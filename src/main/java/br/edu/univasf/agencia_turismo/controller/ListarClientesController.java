package br.edu.univasf.agencia_turismo.controller;

import br.edu.univasf.agencia_turismo.model.Cliente;
import br.edu.univasf.agencia_turismo.service.ClienteService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;

public class ListarClientesController {
    @FXML
    private Button botaoVoltar;
    @FXML
    private TableView<Cliente> tableView; // Sua TableView
    @FXML
    private TableColumn<Cliente, String> coluna_cpf;
    @FXML
    private TableColumn<Cliente, String> coluna_nome;
    @FXML
    private TableColumn<Cliente, String> coluna_email;
    @FXML
    private TableColumn<Cliente, String> coluna_fone;
    @FXML
    private TableColumn<Cliente, String> coluna_historico;
    @FXML
    private TableColumn<Cliente, String> coluna_preferencias;

    @FXML
    private void initialize() {
        // Configurar as colunas com as propriedades de célula
        coluna_cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        coluna_nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        coluna_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        coluna_fone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        coluna_historico.setCellValueFactory(new PropertyValueFactory<>("historicoViagens"));
        coluna_preferencias.setCellValueFactory(new PropertyValueFactory<>("preferencias"));

        // Carregar os clientes na tabela
        carregarClientes();
    }

    private void carregarClientes() {
        ClienteService clienteService = new ClienteService();
        List<Cliente> listaClientes = clienteService.listarClientes();

        // Adicione a lista de clientes à tabela
        tableView.getItems().clear();
        tableView.getItems().addAll(listaClientes);
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
}
