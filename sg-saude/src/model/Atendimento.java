package model;

import java.util.List;

public class Atendimento {
    private int numero;
    private String dataAtendimento;
    private Paciente paciente;
    private Medico medico;
    private List<Servico> servicos;
    private List<Medicamento> medicamentos;
}
