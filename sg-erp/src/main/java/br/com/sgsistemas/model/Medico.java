package br.com.sgsistemas.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "medico")
public class Medico extends Pessoa {
    private String crm;

    public Medico() {
    }

    public Medico(String nome, String crm) {
        super.setNome(nome);
        this.crm = crm;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
}
