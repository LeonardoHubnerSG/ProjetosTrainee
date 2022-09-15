package main;

import conexao.ConnectionFactory;
import model.Produto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaExclusao {
    public static void main(String[] args) throws SQLException {
        Statement statement = ConnectionFactory.obterConexao().createStatement();

        //Esse método "execute" é NECESSARIO para depois conseguir realizar os gets da tabela (ele é como se fosse o CTRL+ENTER do dbeaver, ele é que executa o comando sql ali)
        statement.execute("DELETE FROM produto WHERE nome = 'Mouse'", Statement.RETURN_GENERATED_KEYS);

        ResultSet resultSet = statement.getGeneratedKeys();
        Produto produto = new Produto();

        /*
        while(resultSet.next()){
            System.out.println("Registros deletados:");
            produto.setId(resultSet.getInt(1));
            produto.setNome(resultSet.getString(2));
            produto.setDescricao(resultSet.getString(3));
            System.out.println(produto.toString());
        }

        Statement statement = ConnectionFactory.obterConexao().createStatement();
        statement.execute("select nome,descricao from produto");

        ResultSet resultSet = statement.getResultSet();

        while(resultSet.next()){
            System.out.println(resultSet.getString("nome"));
            System.out.println(resultSet.getString("descricao"));
        }
        */
    }
}
