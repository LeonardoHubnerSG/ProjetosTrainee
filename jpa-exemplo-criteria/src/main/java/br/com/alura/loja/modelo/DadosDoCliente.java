package br.com.alura.loja.modelo;

import javax.persistence.Embeddable;

@Embeddable
public class DadosDoCliente {
    private String nome;
    private String cpf;

    public DadosDoCliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public DadosDoCliente() {
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
