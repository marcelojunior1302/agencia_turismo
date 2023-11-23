package br.edu.univasf.agencia_turismo.model;

import java.math.BigDecimal;
import java.util.Date;

public class PacoteTuristico {
    private int codigoPacote;
    private String destino;
    private Date data;
    private String itinerario;
    private BigDecimal preco;
    private String descricao;
    private int quantidadeVagas;

    // Construtores

    public PacoteTuristico() {
    }

    public PacoteTuristico(int codigoPacote, String destino, Date data, String itinerario, BigDecimal preco, String descricao, int quantidadeVagas) {
        this.codigoPacote = codigoPacote;
        this.destino = destino;
        this.data = data;
        this.itinerario = itinerario;
        this.preco = preco;
        this.descricao = descricao;
        this.quantidadeVagas = quantidadeVagas;
    }

    // Getters e Setters

    public int getCodigoPacote() {
        return codigoPacote;
    }

    public void setCodigoPacote(int codigoPacote) {
        this.codigoPacote = codigoPacote;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getItinerario() {
        return itinerario;
    }

    public void setItinerario(String itinerario) {
        this.itinerario = itinerario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidadeVagas() {
        return quantidadeVagas;
    }

    public void setQuantidadeVagas(int quantidadeVagas) {
        this.quantidadeVagas = quantidadeVagas;
    }


}
