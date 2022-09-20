package br.com.sgsistemas.model;

import javax.persistence.*;

@Entity
@Table(name = "cidade")
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    @ManyToOne
    private UF uf;

    public Cidade(String nome, UF uf) {
        this.nome = nome;
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }
}
