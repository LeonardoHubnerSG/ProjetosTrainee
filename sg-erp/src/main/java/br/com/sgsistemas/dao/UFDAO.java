package br.com.sgsistemas.dao;

import br.com.sgsistemas.model.UF;

import javax.persistence.EntityManager;

public class UFDAO {
    private EntityManager em;

    public UFDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(UF uf){
        this.em.persist(uf);
    }
}
