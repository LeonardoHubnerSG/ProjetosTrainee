package main;

import conexao.ConnectionFactory;
import model.Produto;
import model.ProdutoDAO;

import java.sql.SQLException;
import java.util.List;

public class TestesUsandoDAO {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        Produto produto = new Produto("Feijão","Feijão Carioca");

        ProdutoDAO produtoDAO = new ProdutoDAO(connectionFactory.obterConexao());

        produtoDAO.adiciona(produto);

        List<Produto> produtos = produtoDAO.listar();
        produtos.forEach(prod -> System.out.println(prod));

    }
}
