package br.com.sgsistemas;

public class Aluno {
    private String nome;
    private int numeroMatricula;

    public Aluno(String nome, int numeroMatricula){
        this.nome = nome;
        this.numeroMatricula = numeroMatricula;
    }

    @Override
    public boolean equals(Object obj) {
        Aluno outroAluno = (Aluno) obj;
        return this.nome.equals(outroAluno.nome);
    }

    @Override
    public int hashCode() {
        return this.nome.hashCode();
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome +
               ", N° Matricula: " + this.numeroMatricula;
    }
}
