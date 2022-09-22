package br.com.sgsistemas.view;

import br.com.sgsistemas.dao.*;
import br.com.sgsistemas.factory.JPAUtil;
import br.com.sgsistemas.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StartTeste {
    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        Medico medico = new Medico("Guri","3343-434");
        MedicoDAO medicoDAO = new MedicoDAO(em);

        Paciente paciente = new Paciente("Marcelo","77-7777--7-7");
        PacienteDAO pacienteDAO = new PacienteDAO(em);

        em.getTransaction().begin();
        medicoDAO.cadastrar(medico);
        pacienteDAO.cadastrar(paciente);
        em.getTransaction().commit();
        em.close();

        /*
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
        */
    }
}
