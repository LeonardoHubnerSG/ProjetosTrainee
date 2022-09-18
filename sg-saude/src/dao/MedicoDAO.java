package dao;

import model.Especialidade;
import model.Medico;
import model.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {
    private Connection connection;

    public MedicoDAO(Connection connection){
        this.connection = connection;
    }

    public void salvar(Medico medico) throws SQLException {
        String sql = "INSERT INTO medico (nome,cpf,crm,data_nascimento) values (?,?,?,?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1,medico.getNome());
            preparedStatement.setString(2,medico.getCpf());
            preparedStatement.setString(3,medico.getCrm());
            preparedStatement.setString(4,medico.getDataNascimento());

            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                while(resultSet.next()){
                    medico.setId(resultSet.getInt(1));
                }
            }
        }
    }

    public List<Medico> listar() throws SQLException {
        Medico ultimoMedico = null;
        List<Medico> medicos = new ArrayList<>();

        String sql = "SELECT medico.nome," +
                            "medico.cpf," +
                            "medico.crm," +
                            "medico.data_nascimento," +
                            "especialidade.nome " +
                     "FROM medico " +
                     "INNER JOIN especialidade_medico ON medico.id = especialidade_medico.medico " +
                     "INNER JOIN especialidade ON especialidade_medico.especialidade = especialidade.id ";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while(resultSet.next()){
                    if (ultimoMedico == null || !ultimoMedico.getNome().equals(resultSet.getString(1))) {

                        Medico medico = new Medico(resultSet.getString(1), //nome
                                                   resultSet.getString(2), //cpf
                                                   resultSet.getString(3), //crm
                                                   resultSet.getString(4)); //dataNascimento

                        medicos.add(medico);
                        ultimoMedico = medico;
                    }

                    Especialidade especialidade = new Especialidade(resultSet.getString(5));
                    ultimoMedico.addEspecialidade(especialidade);
                }
            }
        }
        return medicos;
    }

    public void addEspecialidade(Medico medico, Especialidade especialidade) throws SQLException {

        medico.addEspecialidade(especialidade);

        String sql = "INSERT INTO especialidade_medico (medico,especialidade) values (?,?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setInt(1,medico.getId());
            preparedStatement.setInt(2,especialidade.getId());

            preparedStatement.execute();
            /*
            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                while(resultSet.next()){
                    medico.setId(resultSet.getInt(1));
                }
            }
            */
        }
    }

    public void deletar(Medico medico) throws SQLException {
        String sql = "DELETE FROM especialidade_medico WHERE especialidade_medico.medico = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,medico.getId());
            preparedStatement.execute();
        }

        sql = "DELETE FROM medico WHERE medico.id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,medico.getId());
            preparedStatement.execute();
        }
    }

    public void altera(Medico medico, String nome) throws SQLException {
        medico.setNome(nome);

        String sql = "UPDATE medico SET nome = ? WHERE medico.id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,nome);
            preparedStatement.setInt(2,medico.getId());
        }
    }
}
