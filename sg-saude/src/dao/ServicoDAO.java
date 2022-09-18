package dao;

import model.Paciente;
import model.Servico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicoDAO {
    private Connection connection;

    public ServicoDAO(Connection connection){
        this.connection = connection;
    }

    public void salvar(Servico servico) throws SQLException {
        String sql = "INSERT INTO servico (nome) values (?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1,servico.getNome());

            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                while(resultSet.next()){
                    servico.setId(resultSet.getInt(1));
                }
            }
        }
    }

    public List<Servico> listar() throws SQLException {
        List<Servico> servicos = new ArrayList<>();
        String sql = "SELECT id,nome FROM servico";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while(resultSet.next()){
                    Servico servico = new Servico(resultSet.getInt(1),
                                                  resultSet.getString(2));
                    servicos.add(servico);
                }
            }
        }
        return servicos;
    }

    public void deletar(Servico servico) throws SQLException {
        String sql = "DELETE FROM servico WHERE servico.id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,servico.getId());
            preparedStatement.execute();
        }
    }

    public void altera(Servico servico, String nome) throws SQLException {
        servico.setNome(nome);

        String sql = "UPDATE servico SET nome = ? WHERE servico.id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,nome);
            preparedStatement.setInt(2,servico.getId());
        }
    }

}
