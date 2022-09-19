package main;

import conexao.ConnectionFactory;
import model.Produto;

import java.sql.*;

public class TestaListagem {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.obterConexao();
        /*
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/loja_virtual",
                                                           "postgres",
                                                        "senha1");
        */

        //Statement statement = connection.createStatement();
        Statement statement = factory.obterConexao().createStatement();

        //Esse método "execute" é NECESSARIO para depois conseguir realizar os gets da tabela (ele é como se fosse o CTRL+ENTER do dbeaver, ele é que executa o comando sql ali)
        System.out.println("Está trazendo algo: " + statement.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO") + "\n");
        statement.execute("SELECT id, nome, descricao FROM produto");

        ResultSet resultSet = statement.getResultSet();

        Produto produto;

        while(resultSet.next()){
            produto = new Produto(resultSet.getString("nome"),
                                  resultSet.getString("descricao"));

            produto.setId(resultSet.getInt("id"));
            System.out.println(produto);
        }

        System.out.println("Fechando conexão");


        //connection.close(); CONNECTION É UMA INTERFACE AUTOCLOSEABLE
    }
}
