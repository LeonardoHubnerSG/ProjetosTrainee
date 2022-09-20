package br.com.sgsistemas.dao;

import br.com.sgsistemas.model.Endereco;

import javax.persistence.EntityManager;

public class EnderecoDAO {
    private EntityManager em;

    public EnderecoDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Endereco endereco){
        this.em.persist(endereco);
    }
}
