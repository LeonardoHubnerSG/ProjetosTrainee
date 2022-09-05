package classes;

import java.util.ArrayList;

public class Turma {
    //private int idTurma;
    private String nomeMateria;
    private ArrayList<Aluno> alunos;

    public Turma(String nomeMateria){
        this.nomeMateria = nomeMateria;
        this.alunos = new ArrayList<Aluno>();
    }

    public String getNomeMateria() {
        return this.nomeMateria;
    }

    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }


    public Aluno getAluno(int pos) {
        return this.alunos.get(pos);
    }

    public void adicionaAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void mostrarAlunos(){
        for(Aluno aluno : this.alunos){
            System.out.println(aluno.getNome());
        }
    }

    public int getNumeroAlunos() {
        return this.alunos.size();
    }
}
