package dao;

import model.Especialidade;
import model.Medicamento;
import model.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicamentoDAO {
    private Connection connection;

    public MedicamentoDAO(Connection connection){
        this.connection = connection;
    }

    public void salvar(Medicamento medicamento) throws SQLException {
        String sql = "INSERT INTO medicamento (nome) values (?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1,medicamento.getNome());

            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                while(resultSet.next()){
                    medicamento.setId(resultSet.getInt(1));
                }
            }
        }
    }

    public List<Medicamento> listar() throws SQLException {
        List<Medicamento> medicamentos = new ArrayList<>();
        String sql = "SELECT id,nome FROM medicamento";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while(resultSet.next()){
                    Medicamento medicamento = new Medicamento(resultSet.getInt(1),
                                                              resultSet.getString(2));
                    medicamentos.add(medicamento);
                }
            }
        }
        return medicamentos;
    }

    public void deletar(Medicamento medicamento) throws SQLException {
        String sql = "DELETE FROM medicamento WHERE medicamento.id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,medicamento.getId());
            preparedStatement.execute();
        }
    }

    public void altera(Medicamento medicamento, String nome) throws SQLException {
        medicamento.setNome(nome);

        String sql = "UPDATE medicamento SET nome = ? WHERE medicamento.id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,nome);
            preparedStatement.setInt(2,medicamento.getId());
        }
    }
}
