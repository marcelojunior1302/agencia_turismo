package br.edu.univasf.agencia_turismo.service;

import br.edu.univasf.agencia_turismo.dao.ReservaDAO;
import br.edu.univasf.agencia_turismo.model.Reserva;
import br.edu.univasf.agencia_turismo.model.PacoteTuristico;
import java.util.List;

public class ReservaService {

    private ReservaDAO reservaDAO;
    private PacoteService pacoteService;

    public ReservaService() {
        this.reservaDAO = new ReservaDAO();
        this.pacoteService = new PacoteService();
    }

    public void adicionarReserva(Reserva reserva) {
        // Buscar informações do pacote
        PacoteTuristico pacote = pacoteService.buscarPacote(reserva.getCodigoPacote());

        // Verificar se há vagas disponíveis
        if (pacote != null && pacote.getQuantidadeVagas() >= reserva.getQuantidadeVagasSolicitadas()) {
            // Adicionar a reserva
            reservaDAO.adicionarReserva(reserva);

            // Atualizar a quantidade de vagas disponíveis no pacote
            pacote.setQuantidadeVagas(pacote.getQuantidadeVagas() - reserva.getQuantidadeVagasSolicitadas());
            pacoteService.atualizarPacote(pacote);
        } else {
            System.out.println("Não há vagas suficientes para a reserva.");
        }
    }

    public Reserva buscarReserva(int idReserva) {
        return reservaDAO.buscarReserva(idReserva);
    }

    public void atualizarReserva(Reserva reserva) {
        reservaDAO.atualizarReserva(reserva);
    }

    public boolean removerReserva(int idReserva) {
        try {
            reservaDAO.removerReserva(idReserva);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            // Se a remoção falhar, retorne false
            return false;
        }
    }

    public List<Reserva> listarReservas() {
        return reservaDAO.listarReservas();
    }

    public List<Reserva> listarReservasCPF(String cpf) {
        return reservaDAO.listarReservasCPF(cpf);
    }
}
