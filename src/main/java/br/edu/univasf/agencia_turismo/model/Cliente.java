package br.edu.univasf.agencia_turismo.model;

public class Cliente {
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private String historicoViagens;
    private String preferencias;

    public Cliente() {

    }

    public Cliente(String cpf, String nome, String email, String telefone, String historicoViagens, String preferencias) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.historicoViagens = historicoViagens;
        this.preferencias = preferencias;

    }

    public Cliente( String nome, String email, String telefone, String historicoViagens, String preferencias) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.historicoViagens = historicoViagens;
        this.preferencias = preferencias;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getHistoricoViagens() {
        return historicoViagens;
    }

    public void setHistoricoViagens(String historicoViagens) {
        this.historicoViagens = historicoViagens;
    }

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }
}
