package br.com.sgsistemas.dao;

import br.com.sgsistemas.model.Cliente;
import br.com.sgsistemas.model.Endereco;
import br.com.sgsistemas.model.UF;

import javax.persistence.EntityManager;
import java.util.List;

public class EnderecoDAO {
    private EntityManager em;

    public EnderecoDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Endereco endereco){
        this.em.persist(endereco);
    }

    public void atualizar(Endereco endereco){
        this.em.merge(endereco);
    }

    public void remover(Endereco endereco){
        endereco = em.merge(endereco);
        this.em.remove(endereco);
    }

    public List<Endereco> buscarTodos(){
        String jpql = "SELECT endereco FROM Endereco endereco";
        return this.em.createQuery(jpql, Endereco.class).getResultList();
    }

    public List<Endereco> buscaEnderecoPorNumero(String numero){
        String jpql = "SELECT endereco FROM Endereco endereco WHERE endereco.numero = :numero";
        return this.em.createQuery(jpql, Endereco.class)
                .setParameter("numero",numero)
                .getResultList();
    }

    public void limparEntidade(){
        String jpql = "DELETE FROM Endereco";
        em.getTransaction().begin();
        this.em.createQuery(jpql).executeUpdate();
        em.getTransaction().commit();
        em.clear();
    }

}
