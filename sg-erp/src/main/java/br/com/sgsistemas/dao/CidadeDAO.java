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

    public void atualizar(Cidade cidade){
        this.em.persist(cidade);
    }

    public void remover(Cidade cidade){
        cidade = em.merge(cidade);
        this.em.remove(cidade);
    }

    public void limparEntidade(){
        String jpql = "DELETE FROM Cidade";
        em.getTransaction().begin();
        this.em.createQuery(jpql).executeUpdate();
        em.getTransaction().commit();
        em.clear();
    }
}
