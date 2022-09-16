package dao;

import model.Atendimento;
import model.Especialidade;
import model.Medicamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadeDAO {
    private Connection connection;

    public EspecialidadeDAO(Connection connection){
        this.connection = connection;
    }

    public void salvar(Especialidade especialidade) throws SQLException {
        String sql = "INSERT INTO especialidade (nome) values (?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1,especialidade.getNome());

            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                while(resultSet.next()){
                    especialidade.setId(resultSet.getInt(1));
                }
            }
        }
    }

    public List<Especialidade> listar() throws SQLException {
        List<Especialidade> especialidades = new ArrayList<>();
        String sql = "SELECT id,nome FROM especialidade";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while(resultSet.next()){
                    Especialidade especialidade = new Especialidade(resultSet.getInt(1),
                                                                    resultSet.getString(2));
                    especialidades.add(especialidade);
                }
            }
        }
        return especialidades;
    }

    public void deletar(Especialidade especialidade) throws SQLException {
        String sql = "DELETE FROM especialidade WHERE especialidade.id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,especialidade.getId());
            preparedStatement.execute();
        }
    }

    public void altera(Especialidade especialidade, String nome) throws SQLException {
        especialidade.setNome(nome);

        String sql = "UPDATE especialidade SET nome = ? WHERE especialidade.id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,nome);
            preparedStatement.setInt(2,especialidade.getId());
        }
    }
}
