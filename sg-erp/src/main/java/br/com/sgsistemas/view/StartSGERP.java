package br.com.sgsistemas.view;

import br.com.sgsistemas.dao.*;
import br.com.sgsistemas.factory.JPAUtil;
import br.com.sgsistemas.model.*;

import javax.persistence.EntityManager;
import java.util.List;

public class StartSGERP {
    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        ClienteDAO clienteDAO = new ClienteDAO(em);
        EnderecoDAO enderecoDAO = new EnderecoDAO(em);
        CidadeDAO cidadeDAO = new CidadeDAO(em);
        UFDAO ufDAO = new UFDAO(em);

        clienteDAO.limparEntidade();
        enderecoDAO.limparEntidade();
        cidadeDAO.limparEntidade();
        ufDAO.limparEntidade();

        cadastraDados();

        List<Cliente> clientes = clienteDAO.buscarTodos();
        clientes.forEach(listaClientes -> System.out.println(listaClientes));

        /*
        List<Cliente> clientes = clienteDAO.buscarTodos();
        clientes.forEach(cli -> System.out.println(cli.getNome() + " " +
                                                   cli.getEndereco().getLogradouro() + " " +
                                                   cli.getEndereco().getCidade().getNome() + " " +
                                                   cli.getEndereco().getCidade().getUf().getDescricao()));
        */

        //criaCliente();

//        Cliente cliente = em.find(Cliente.class, 5l);
//
//        String cpf = clienteDAO.getCPFCliente(cliente);
//        System.out.println("CPF do cliente: " + cpf);

        /*
        em.getTransaction().begin();
        clienteDAO.remover(cliente);
        em.getTransaction().commit();
        em.close();
        */


//        clienteDAO.remover(cliente);
//        em.close();

    }

    public static void criaCliente(){
        EntityManager em = JPAUtil.getEntityManager();
        Cliente cliente = new Cliente("Leonardo",
                "099.506.689-21",
                "22/04/1995");

        ClienteDAO clienteDAO = new ClienteDAO(em);

        em.getTransaction().begin();
        clienteDAO.cadastrar(cliente);
        em.getTransaction().commit();
        em.close();
    }

    private static void cadastraDados() {
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
