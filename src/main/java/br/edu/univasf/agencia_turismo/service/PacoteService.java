package br.edu.univasf.agencia_turismo.service;

import br.edu.univasf.agencia_turismo.dao.PacoteDAO;
import br.edu.univasf.agencia_turismo.model.PacoteTuristico;

import java.util.List;

public class PacoteService {

    private PacoteDAO pacoteDAO;

    public PacoteService() {
        this.pacoteDAO = new PacoteDAO();
    }

    public void adicionarPacote(PacoteTuristico pacote) {
        pacoteDAO.adicionarPacote(pacote);
    }

    public PacoteTuristico buscarPacote(int codigoPacote) {
        return pacoteDAO.buscarPacote(codigoPacote);
    }

    public void atualizarPacote(PacoteTuristico pacote) {
        pacoteDAO.atualizarPacote(pacote);
    }

    public void removerPacote(int codigoPacote) {
        pacoteDAO.removerPacote(codigoPacote);
    }

    public List<PacoteTuristico> listarPacotes() {
        return pacoteDAO.listarPacotes();
    }
    public boolean verificarPacoteExistente(int codigoPacote) {
        PacoteTuristico pacote = pacoteDAO.buscarPacote(codigoPacote);
        return pacote != null;
    }
    public boolean verificarVagasDisponiveis(int codigoPacote, int quantidadeVagasSolicitadas) {
        PacoteTuristico pacote = pacoteDAO.buscarPacote(codigoPacote);
        return pacote != null && pacote.getQuantidadeVagas() >= quantidadeVagasSolicitadas;
    }

}
