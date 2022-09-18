package dao;

import model.Medicamento;
import model.Paciente;
import model.Servico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {
    private Connection connection;

    public PacienteDAO(Connection connection){
        this.connection = connection;
    }

    public void salvar(Paciente paciente) throws SQLException {
        String sql = "INSERT INTO paciente (nome,cpf,data_nascimento,nome_mae,numero_carteirinha,cor_pulseira) values (?,?,?,?,?,?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1,paciente.getNome());
            preparedStatement.setString(2,paciente.getCpf());
            preparedStatement.setString(3,paciente.getDataNascimento());
            preparedStatement.setString(4,paciente.getNomeMae());
            preparedStatement.setString(5,paciente.getNumCarteirinha());
            preparedStatement.setString(6,paciente.getCorPulseira());

            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                while(resultSet.next()){
                    paciente.setId(resultSet.getInt(1));
                }
            }
        }
    }

    public List<Paciente> listar() throws SQLException {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT id,nome,cpf,data_nascimento,nome_mae,numero_carteirinha,cor_pulseira FROM paciente";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while(resultSet.next()){
                    Paciente paciente = new Paciente(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7));
                    pacientes.add(paciente);
                }
            }
        }
        return pacientes;
    }

    public void deletar(Paciente paciente) throws SQLException {
        String sql = "DELETE FROM paciente WHERE paciente.id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,paciente.getId());
            preparedStatement.execute();
        }
    }

    public void altera(Paciente paciente, String nome) throws SQLException {
        paciente.setNome(nome);

        String sql = "UPDATE paciente SET nome = ? WHERE paciente.id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,nome);
            preparedStatement.setInt(2,paciente.getId());
        }
    }
}
