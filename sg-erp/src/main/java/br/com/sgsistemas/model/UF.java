package br.com.sgsistemas.model;

import javax.persistence.*;

@Entity
@Table(name = "uf")
public class UF {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String sigla;
    private String descricao;
    public UF() {
    }

    public UF(String sigla, String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
