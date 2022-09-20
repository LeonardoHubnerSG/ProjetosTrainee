package br.com.sgsistemas.dao;

import br.com.sgsistemas.model.Cidade;

import javax.persistence.EntityManager;

public class CidadeDAO {
    private EntityManager em;

    public CidadeDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Cidade cidade){
        this.em.persist(cidade);
    }
}
