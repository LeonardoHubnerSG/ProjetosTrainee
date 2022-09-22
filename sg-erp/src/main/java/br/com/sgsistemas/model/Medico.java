package br.com.sgsistemas.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Medico extends Pessoa{
    private String crm;

    public Medico(String nome, String cpf) {
        super. (nome);
    }
}
