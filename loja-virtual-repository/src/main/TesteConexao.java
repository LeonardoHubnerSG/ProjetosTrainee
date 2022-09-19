/*
package main;

import conexao.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteConexao {
    public static void main(String[] args) throws SQLException {
        */
/*
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/loja_virtual",
                                                           "postgres",
                                                        "senha1");
        *//*


        //Connection connection = ConnectionFactory.obterConexao();

        Statement statement = ConnectionFactory.obterConexao().createStatement();

        System.out.println("Fechando conexão");

        //connection.close(); CONNECTION É UMA INTERFACE AUTOCLOSEABLE
    }
}
*/
