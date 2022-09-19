/*
package main;

import conexao.ConnectionFactory;

import java.net.ConnectException;
import java.sql.*;

public class TestaInsercaoParametros2 {
    public static void main(String[] args) throws SQLException {
        String nome = "Banana";
        String descricao = "Banana Prata";

        */
/*
        PreparedStatement preparedStatement =
                ConnectionFactory.obterConexao().prepareStatement("INSERT INTO produto (nome,descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
        *//*


        try(Connection connection = ConnectionFactory.obterConexao()) {
            connection.setAutoCommit(false);

            try (PreparedStatement preparedStatement =
                         connection.prepareStatement("INSERT INTO produto (nome,descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
                inserirProduto("teste1", "teste1 teste1", preparedStatement);
                inserirProduto("teste2", "teste2 teste2", preparedStatement);

                connection.commit();
            } catch (Exception ex) {
                ex.printStackTrace();
                connection.rollback();
                System.out.println("ROLLBACK REALIZADO!");
            }
        }
    }

    public static void inserirProduto(String param1, String param2, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, param1);
        preparedStatement.setString(2, param2);

        preparedStatement.execute();

        try(ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
            resultSet.next();

            System.out.println("ID: " + resultSet.getInt(1) +
                    "\nNome: " + resultSet.getString(2) +
                    "\nDescrição: " + resultSet.getString(3));
        }
    }
}
*/
