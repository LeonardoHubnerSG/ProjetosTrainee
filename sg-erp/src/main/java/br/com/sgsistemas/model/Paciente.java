package br.com.sgsistemas.model;

import javax.persistence.Entity;

@Entity
public class Paciente extends Pessoa {
    private String cpf;

    public Paciente() {
    }

    public Paciente(String nome, String cpf) {
        super.setNome(nome);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
