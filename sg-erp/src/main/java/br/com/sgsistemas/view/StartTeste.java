package br.com.sgsistemas.view;

import br.com.sgsistemas.dao.CidadeDAO;
import br.com.sgsistemas.dao.ClienteDAO;
import br.com.sgsistemas.dao.EnderecoDAO;
import br.com.sgsistemas.dao.UFDAO;
import br.com.sgsistemas.factory.JPAUtil;
import br.com.sgsistemas.model.*;

import javax.persistence.EntityManager;

public class StartTeste {
    public static void main(String[] args) {
        Paciente paciente = new Paciente("")

        UF parana = new UF("PR","Paraná");
        Cidade sarandi = new Cidade("Sarandi",parana);
        Endereco endereco = new Endereco("Rua Americo",
                "1574",
                "Jardim Independencia",
                sarandi);
        Cliente cliente = new Cliente("Leonardo",
                "099.506.689-21",
                "22/04/1995",
                endereco);

        EntityManager em = JPAUtil.getEntityManager();

        UFDAO ufdao = new UFDAO(em);
        CidadeDAO cidadeDAO = new CidadeDAO(em);
        EnderecoDAO enderecoDAO = new EnderecoDAO(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);

        em.getTransaction().begin();
        ufdao.cadastrar(parana);
        cidadeDAO.cadastrar(sarandi);
        enderecoDAO.cadastrar(endereco);
        clienteDAO.cadastrar(cliente);
        em.getTransaction().commit();

        em.close();
    }
}
