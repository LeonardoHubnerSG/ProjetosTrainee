package br.com.sgsistemas.dao;

import br.com.sgsistemas.model.Cliente;
import br.com.sgsistemas.model.Cliente;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDAO {
    private EntityManager em;

    public ClienteDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Cliente cliente){
        this.em.persist(cliente);
    }

    public void atualizar(Cliente cliente){
        this.em.merge(cliente);
    }

    public void remover(Cliente cliente){
        cliente = em.merge(cliente);
        em.getTransaction().begin();
        this.em.remove(cliente);
        em.getTransaction().commit();
    }

    public void limparEntidade(){
        String jpql = "DELETE FROM Cliente";
        em.getTransaction().begin();
        this.em.createQuery(jpql).executeUpdate();
        em.getTransaction().commit();
        em.clear();
    }

    public List<Cliente> buscarTodos(){
//        String jpql = "SELECT " +
//                      "cliente.nome," +
//                      "cliente.cpf ," +
//                      "cliente.dataNascimento," +
//                      "endereco.logradouro ," +
//                      "endereco.numero ," +
//                      "endereco.bairro," +
//                      "cidade.nome ," +
//                      "uf.descricao " +
//                      "FROM Cliente cliente " +
//                      "INNER JOIN Endereco endereco ON cliente.endereco.id = endereco.id " +
//                      "INNER JOIN Cidade cidade ON endereco.cidade.codigo  = cidade.codigo " +
//                      "INNER JOIN UF uf ON cidade.uf.sigla  = uf.sigla";

        String jpql = "SELECT cliente FROM Cliente cliente ";
        return this.em.createQuery(jpql, Cliente.class).getResultList();
    }

    public List<Cliente> buscaClientePorNome(String nome){
        String jpql = "SELECT cliente FROM Cliente cliente WHERE cliente.nome = :nome";
        return this.em.createQuery(jpql, Cliente.class)
                .setParameter("nome",nome)
                .getResultList();
    }

    public String getCPFCliente(Cliente cliente){
        String jpql = "SELECT cliente.cpf FROM Cliente cliente WHERE cliente.id = :id";
        return this.em.createQuery(jpql, String.class)
                .setParameter("id",cliente.getId())
                .getSingleResult();
    }


}
