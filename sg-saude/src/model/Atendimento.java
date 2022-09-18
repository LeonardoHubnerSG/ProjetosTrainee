package model;

import java.util.ArrayList;
import java.util.List;

public class Atendimento {
    private Integer numero;
    private String dataAtendimento;
    private Paciente paciente = null;
    private Medico medico = null;
    private List<Servico> servicos = new ArrayList<>();
    private List<Medicamento> medicamentos = new ArrayList<>();

    public Atendimento(Integer numero, String dataAtendimento) {
        this.numero = numero;
        this.dataAtendimento = dataAtendimento;
    }

    public Atendimento(Integer numero, String dataAtendimento, Paciente paciente, Medico medico) {
        this.numero = numero;
        this.dataAtendimento = dataAtendimento;
        this.paciente = paciente;
        this.medico = medico;
    }

    public Atendimento(String dataAtendimento, Paciente paciente, Medico medico) {
        this.dataAtendimento = dataAtendimento;
        this.paciente = paciente;
        this.medico = medico;
    }

    public void setDataAtendimento(String dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getDataAtendimento() {
        return this.dataAtendimento;
    }

    public Paciente getPaciente() {
        return this.paciente;
    }

    public Integer getPacienteID() {
        return this.paciente.getId();
    }

    public Medico getMedico() {
        return this.medico;
    }

    public Integer getMedicoID() {
        return this.medico.getId();
    }

    public List<Servico> getServicos() {
        return this.servicos;
    }

    public List<Medicamento> getMedicamentos() {
        return this.medicamentos;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void addServico(Servico servico) {
        this.servicos.add(servico);
    }

    public void addMedicamento(Medicamento medicamento) {
        this.medicamentos.add(medicamento);
    }

    public Integer getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Data Atendimento: " + this.dataAtendimento + "\n" +
               "Paciente: " + this.paciente.getNome() + "\n" +
               "Medico: " + this.medico.getNome() + "\n" +
               "Servicos: " + this.servicos + "\n" +
               "Medicamentos: " + this.medicamentos + "\n";
    }
}
