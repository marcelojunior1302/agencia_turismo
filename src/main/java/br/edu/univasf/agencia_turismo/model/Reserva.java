package br.edu.univasf.agencia_turismo.model;

import java.util.Date;

public class Reserva {
    private int idReserva;
    private String cpfCliente;
    private int codigoPacote;
    private Date dataReserva;
    private int quantidadeVagasSolicitadas;

    // Construtores

    public Reserva() {
    }

    public Reserva(int idReserva, String cpfCliente, int codigoPacote, Date dataReserva, int quantidadeVagasSolicitadas) {
        this.idReserva = idReserva;
        this.cpfCliente = cpfCliente;
        this.codigoPacote = codigoPacote;
        this.dataReserva = dataReserva;
        this.quantidadeVagasSolicitadas = quantidadeVagasSolicitadas;
    }

    // Getters e Setters

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public int getCodigoPacote() {
        return codigoPacote;
    }

    public void setCodigoPacote(int codigoPacote) {
        this.codigoPacote = codigoPacote;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public int getQuantidadeVagasSolicitadas() {
        return quantidadeVagasSolicitadas;
    }

    public void setQuantidadeVagasSolicitadas(int quantidadeVagasSolicitadas) {
        this.quantidadeVagasSolicitadas = quantidadeVagasSolicitadas;
    }


}
