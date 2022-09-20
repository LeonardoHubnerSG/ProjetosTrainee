package br.com.sgsistemas.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    @ManyToOne
    private Endereco endereco;

    public Cliente(String nome, String cpf, String dataNascimento, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento =  LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getLocalDate() {
        return dataNascimento;
    }

    public void setLocalDate(LocalDate localDate) {
        this.dataNascimento = localDate;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
