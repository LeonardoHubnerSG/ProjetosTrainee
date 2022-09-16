package model;

import java.util.ArrayList;
import java.util.List;

public class Medico extends Pessoa{
    private Integer id;
    private String crm;
    private List<Especialidade> especialidades = new ArrayList<>();

    public Medico(Integer id, String nome) {
        this.id = id;
        super.setNome(nome);
    }

    public Medico(Integer id, String nome, String cpf, String crm, String dataNascimento){
        this.id = id;
        super.setNome(nome);
        super.setCpf(cpf);
        super.setDataNascimento(dataNascimento);
        this.crm = crm;
    }

    public Medico(String nome, String cpf, String crm, String dataNascimento){
        super.setNome(nome);
        super.setCpf(cpf);
        super.setDataNascimento(dataNascimento);
        this.crm = crm;
    }

    public Integer getId() {
        return id;
    }

    public String getCrm() {
        return crm;
    }

    public List<Especialidade> getEspecialidades() {
        return this.especialidades;
    }

    public Especialidade getEspecialidade(int index){
        return this.especialidades.get(index);
    }

    public void addEspecialidade(Especialidade especialidade) {
        this.especialidades.add(especialidade);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Medico: " + this.getNome() + "\n" +
               "Data Nascimento: " + this.getDataNascimento() + "\n" +
               "CPF: " + this.getCpf() + "\n" +
               "CRM: " + this.getCrm() + "\n" +
               "Especialidades: " + this.especialidades + "\n";

    }


}
