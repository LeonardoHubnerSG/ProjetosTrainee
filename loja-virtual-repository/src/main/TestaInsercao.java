package main;

import conexao.ConnectionFactory;
import model.Produto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*

public class TestaInsercao {
    public static void main(String[] args) throws SQLException {
        String nome = "Mouse";
        String descricao = "Sem fios";

        //Usar o PreparedStatement é uma boa prática para evitar SQL Injection
        PreparedStatement preparedStatement =
                ConnectionFactory.obterConexao().prepareStatement("INSERT INTO produto (nome,descricao) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1,nome);
        preparedStatement.setString(2,descricao);

        //Esse método "execute" é NECESSARIO para depois conseguir realizar os gets da tabela (ele é como se fosse o CTRL+ENTER do dbeaver, ele é que executa o comando sql ali)
        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();

        Produto produto = new Produto();

        resultSet.next();
        System.out.println(resultSet.getInt(1));
    }

    */
/*
    public static void main(String[] args) throws SQLException {
        Statement statement = ConnectionFactory.obterConexao().createStatement();

        //Esse método "execute" é NECESSARIO para depois conseguir realizar os gets da tabela (ele é como se fosse o CTRL+ENTER do dbeaver, ele é que executa o comando sql ali)
        statement.execute("INSERT INTO produto (nome,descricao) VALUES ('Mouse','Mouse sem fio')", Statement.RETURN_GENERATED_KEYS);

        ResultSet resultSet = statement.getGeneratedKeys();
        Produto produto = new Produto();

        while (resultSet.next()) {
            produto.setId(resultSet.getInt(1));
            produto.setNome(resultSet.getString(2));
            produto.setDescricao(resultSet.getString(3));
            System.out.println(produto.toString());
        }
    }
    *//*

}

//Statement
//ResultSet
*/
