package classes;

import java.util.ArrayList;

public class Escola {
    //private idEscola;
    private String nomeEscola;
    private Turma turma;
    private Endereco endereco;
    //private ArrayList<Turma> turma;

    public Escola(String nomeEscola){
        this.nomeEscola = nomeEscola;
    }

    public String getNomeEscola() {
        return this.nomeEscola;
    }

    public void setNomeEscola(String nomeEscola){
        this.nomeEscola = nomeEscola;
    }

    public Turma getTurma() {
        return this.turma;
    }

    public void setTurma(String nomeMateria){
        this.turma = new Turma(nomeMateria);
    }

    public Endereco getEndereco(){
        return endereco;
    }

    public void setEndereco(String rua, String numeroCasa, String bairro, String cep, String cidade){
        this.endereco = new Endereco(rua, numeroCasa, bairro, cep, cidade);
    }

}
