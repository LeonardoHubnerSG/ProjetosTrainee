package main;

import conexao.ConnectionFactory;

import java.sql.SQLException;

public class TestaPoolConexoes {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        for (int i = 1; i < 20; i++){
            connectionFactory.obterConexao();
            System.out.println("Conexão de número: " + i);
        }
    }
}
