package br.com.sgsistemas.dao;

import br.com.sgsistemas.model.Endereco;
import br.com.sgsistemas.model.UF;

import javax.persistence.EntityManager;
import java.util.List;

public class UFDAO {
    private EntityManager em;

    public UFDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(UF uf){
        this.em.persist(uf);
    }

    public void atualizar(UF uf){
        this.em.merge(uf);
    }

    public void remover(UF uf){
        uf = em.merge(uf);
        this.em.remove(uf);
    }

    public List<UF> buscarTodos(){
        String jpql = "SELECT uf FROM UF uf";
        return this.em.createQuery(jpql, UF.class).getResultList();
    }

    public List<UF> buscaUFPorDescricao(String descricao){
        String jpql = "SELECT uf FROM UF uf WHERE uf.descricao = :descricao";
        return this.em.createQuery(jpql, UF.class)
                .setParameter("descricao",descricao)
                .getResultList();
    }

    public void limparEntidade(){
        String jpql = "DELETE FROM UF";
        em.getTransaction().begin();
        this.em.createQuery(jpql).executeUpdate();
        em.getTransaction().commit();
        em.clear();
    }
}
