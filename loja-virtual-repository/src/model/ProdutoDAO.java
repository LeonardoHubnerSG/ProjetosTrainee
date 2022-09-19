package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private Connection connection;

    public ProdutoDAO(Connection con){
        this.connection = con;
    }

    public void adiciona(Produto produto) throws SQLException {
        String sql = "INSERT INTO produto (nome,descricao) VALUES (?,?)";

        try(PreparedStatement preparedStatement =
                this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getDescricao());
            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                while(resultSet.next()){
                    produto.setId(resultSet.getInt(1));
                }
            }
        }
    }

    public List<Produto> listar() throws SQLException {
        List<Produto> produtos = new ArrayList<>();

        String sql = "SELECT id,nome,descricao FROM produto";
        try(PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getResultSet()) {
                while (resultSet.next()) {
                    Produto produto = new Produto(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3));
                    produtos.add(produto);
                }
            }
        }
        return produtos;
    }

}
