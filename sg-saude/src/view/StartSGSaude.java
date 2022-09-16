package view;

import dao.*;
import factory.ConnectionFactory;
import model.*;

import java.sql.SQLException;
import java.util.List;

/**
 * !!!!!!!!!!!!!!!!!   ATENÇÃO   !!!!!!!!!!!!!!!!!
 * Os métodos CRUD foram criados
 * Os UPDATES ainda não foram testados e estão alterando apenas um campo de cada tabela (precisaria mais tempo para terminar)
 * @version 1.0
 * @author Leonardo Rodrigues Hubner
 */

public class StartSGSaude {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        /******************************  OPERACOES COM PACIENTE  *****************************/

        Paciente paciente1 = new Paciente("Reinaldo",
                                         "099.551.871-87",
                                         "23/07/1965",
                                         "Iraci",
                                         "123-456-789",
                                         "Amarelo");
        PacienteDAO pacienteDAO = new PacienteDAO(connectionFactory.getConnection());
        pacienteDAO.salvar(paciente1);
        //pacienteDAO.deletar(paciente1);

        List<Paciente> pacientes = pacienteDAO.listar();
        pacientes.forEach(paciente -> System.out.println(paciente));


        /****************************  OPERACOES COM ESPECIALIDADE  *****************************/

        Especialidade especialidade1 = new Especialidade("Ortopedia");
        Especialidade especialidade2 = new Especialidade("Odontologia");
        EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO(connectionFactory.getConnection());
        especialidadeDAO.salvar(especialidade1);
        especialidadeDAO.salvar(especialidade2);
        //especialidadeDAO.deletar(especialidade1);


        /**************************  OPERACOES COM MEDICO  *****************************/

        Medico medico1 = new Medico("Fernando",
                                    "555.506.689-99",
                                    "833-2122",
                           "10/10/1950");
        MedicoDAO medicoDAO = new MedicoDAO(connectionFactory.getConnection());
        medicoDAO.salvar(medico1);
        medicoDAO.addEspecialidade(medico1, especialidade1);
        //medicoDAO.deletar(medico1);

        List<Medico> medicos = medicoDAO.listar();
        medicos.forEach(medico -> System.out.println(medico));


        /**************************  OPERACOES COM MEDICAMENTO  *****************************/

        Medicamento medicamento1 = new Medicamento("Dorflex");
        Medicamento medicamento2 = new Medicamento("Paracetamol");
        MedicamentoDAO medicamentoDAO = new MedicamentoDAO(connectionFactory.getConnection());
        medicamentoDAO.salvar(medicamento1);
        medicamentoDAO.salvar(medicamento2);
        //medicamentoDAO.deletar(medicamento1);


        /**************************  OPERACOES COM SERVICO  *****************************/

        Servico servico1 = new Servico("Cirurgia");
        Servico servico2 = new Servico("Tratamento dentario");
        ServicoDAO servicoDAO = new ServicoDAO(connectionFactory.getConnection());
        servicoDAO.salvar(servico1);
        servicoDAO.salvar(servico2);
        //servicoDAO.deletar(servico1);


        /**************************  OPERACOES COM ATENDIMENTO  *****************************/

        Atendimento atendimento1 = new Atendimento("20/12/2020", paciente1, medico1);
        AtendimentoDAO atendimentoDAO = new AtendimentoDAO(connectionFactory.getConnection());
        atendimentoDAO.salvar(atendimento1);
        atendimentoDAO.addServicoAtendimento(atendimento1, servico1);
        atendimentoDAO.addMedicamentoAtendimento(atendimento1,medicamento1);
        atendimentoDAO.addMedicamentoAtendimento(atendimento1,medicamento2);
        //atendimentoDAO.deletar(atendimento1);

        List<Atendimento> atendimentos = atendimentoDAO.listar();
        atendimentos.forEach(atendimento -> System.out.println(atendimento));

    }
}