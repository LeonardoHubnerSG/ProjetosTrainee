package br.com.sgsistemas.dao;

import br.com.sgsistemas.model.Medico;

import javax.persistence.EntityManager;

public class MedicoDAO {
    private EntityManager em;

    public MedicoDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Medico medico){
        this.em.persist(medico);
    }

    public void atualizar(Medico medico){
        this.em.merge(medico);
    }

    public void remover(Medico medico){
        medico = em.merge(medico);
        this.em.remove(medico);
    }
}
