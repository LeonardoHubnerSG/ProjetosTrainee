package dao;

import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AtendimentoDAO {
    private Connection connection;

    public AtendimentoDAO(Connection connection){
        this.connection = connection;
    }

    public void salvar(Atendimento atendimento) throws SQLException {
        String sql = "INSERT INTO atendimento (data_atendimento,paciente,medico) values (?,?,?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1,atendimento.getDataAtendimento());
            preparedStatement.setInt(2,atendimento.getPacienteID());
            preparedStatement.setInt(3,atendimento.getMedicoID());

            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                while(resultSet.next()){
                    atendimento.setNumero(resultSet.getInt(1));
                }
            }
        }
    }

    public List<Atendimento> listar() throws SQLException {
        Atendimento ultimoAtendimento = null;

        List<Atendimento> atendimentos = new ArrayList<>();
        
        String sql = "SELECT atendimento.numero, " +
                            "atendimento.data_atendimento, " +
                            "atendimento.paciente, " +
                            "paciente.nome, " +
                            "atendimento.medico, " +
                            "medico.nome, " +
                            "servico.id, " +
                            "servico.nome, " +
                            "medicamento.id, " +
                            "medicamento.nome " +
                     "FROM atendimento " +
                     "INNER JOIN paciente ON atendimento.paciente = paciente.id " +
                     "INNER JOIN medico ON atendimento.medico = medico.id " +
                     "INNER JOIN medicamentos_atendimento ON atendimento.numero = medicamentos_atendimento.atendimento " +
                     "INNER JOIN medicamento ON medicamentos_atendimento.medicamento = medicamento.id " +
                     "INNER JOIN servicos_atendimento ON atendimento.numero = servicos_atendimento.atendimento " +
                     "INNER JOIN servico ON servicos_atendimento.servico = servico.id ";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while(resultSet.next()){
                    
                    if (ultimoAtendimento == null || !ultimoAtendimento.getNumero().equals(resultSet.getInt(1))) {
                        Atendimento atendimento = new Atendimento(resultSet.getInt(1), resultSet.getString(2));

                        atendimentos.add(atendimento);
                        ultimoAtendimento = atendimento;

                        Paciente paciente = new Paciente(resultSet.getInt(3), resultSet.getString(4));
                        ultimoAtendimento.setPaciente(paciente);

                        Medico medico = new Medico(resultSet.getInt(5), resultSet.getString(6));
                        ultimoAtendimento.setMedico(medico);
                    }

                    //if (ultimoServico == null || !ultimoAtendimento.getServicos().c    equals(resultSet.getInt(1))) {
                        Servico servico = new Servico(resultSet.getInt(7), resultSet.getString(8));
                        ultimoAtendimento.addServico(servico);
                    //}

                    //if (true) {
                        Medicamento medicamento = new Medicamento(resultSet.getInt(9), resultSet.getString(10));
                        ultimoAtendimento.addMedicamento(medicamento);
                    //}
                }
            }
        }
        return atendimentos;
    }

    public void addServicoAtendimento(Atendimento atendimento, Servico servico) throws SQLException {

        atendimento.addServico(servico);

        String sql = "INSERT INTO servicos_atendimento (atendimento,servico) values (?,?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setInt(1,atendimento.getNumero());
            preparedStatement.setInt(2,servico.getId());

            preparedStatement.execute();
        }
    }

    public void addMedicamentoAtendimento(Atendimento atendimento, Medicamento medicamento) throws SQLException {

        atendimento.addMedicamento(medicamento);

        String sql = "INSERT INTO medicamentos_atendimento (atendimento,medicamento) values (?,?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setInt(1,atendimento.getNumero());
            preparedStatement.setInt(2,medicamento.getId());

            preparedStatement.execute();
        }
    }

    public void deletar(Atendimento atendimento) throws SQLException {

        String sql = "DELETE FROM servicos_atendimento WHERE servicos_atendimento.atendimento = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,atendimento.getNumero());
            preparedStatement.execute();
        }

        sql = "DELETE FROM medicamentos_atendimento WHERE medicamentos_atendimento.atendimento = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,atendimento.getNumero());
            preparedStatement.execute();
        }

        sql = "DELETE FROM atendimento WHERE atendimento.numero = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,atendimento.getNumero());
            preparedStatement.execute();
        }
    }

    public void altera(Atendimento atendimento, String dataAtendimendo) throws SQLException {
        atendimento.setDataAtendimento(dataAtendimendo);

        String sql = "UPDATE especialidade SET nome = ? WHERE especialidade.id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,dataAtendimendo);
            preparedStatement.setInt(2,atendimento.getNumero());
        }
    }

}
