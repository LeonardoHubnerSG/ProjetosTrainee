package br.com.sgsistemas.loja.testes;

import br.com.sgsistemas.loja.modelo.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {
        Categoria celulares = new Categoria("CELULARES");

        Produto celular = new Produto("Xiaomi Redmi",
                                      "Muito legal",
                                      new BigDecimal("800"),
                                      celulares);

        //EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja_db");
        EntityManager em =  JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);
        
        em.getTransaction().begin();
        categoriaDAO.cadastrar(celulares);
        produtoDAO.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }
}
