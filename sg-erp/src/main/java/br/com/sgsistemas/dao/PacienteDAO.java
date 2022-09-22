package br.com.sgsistemas.dao;

import br.com.sgsistemas.model.Paciente;

import javax.persistence.EntityManager;

public class PacienteDAO {
    private EntityManager em;

    public PacienteDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Paciente paciente){
        this.em.persist(paciente);
    }

    public void atualizar(Paciente paciente){
        this.em.merge(paciente);
    }

    public void remover(Paciente paciente){
        paciente = em.merge(paciente);
        this.em.remove(paciente);
    }
}
