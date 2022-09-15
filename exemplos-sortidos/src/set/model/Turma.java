package set.model;

import java.util.*;

public class Turma {
    private String nome;
    private Set<Aluno> alunos = new HashSet<>();
    private Map<Integer, Aluno> matriculaParaAluno = new HashMap<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Map<Integer, Aluno> getMatriculaParaAluno() {
        return matriculaParaAluno;
    }

    public void setMatriculaParaAluno(Map<Integer, Aluno> matriculaParaAluno) {
        this.matriculaParaAluno = matriculaParaAluno;
    }

    public void matricula(Aluno aluno){
        this.alunos.add(aluno);
        this.matriculaParaAluno.put(aluno.getCodigo(), aluno);
    }

    public boolean estaMatriculado(Aluno aluno){
        return this.alunos.contains(aluno);
    }

    public Aluno buscaMatriculado(int codigoAluno){
        if (!this.matriculaParaAluno.containsKey(codigoAluno) ){
            throw new NoSuchElementException("Matricula nao encontrada");
        }
        return matriculaParaAluno.get(codigoAluno);
    }


    public void percorreMap(Map alunos){
        alunos.forEach((idade, nome) -> System.out.println("Idade/chave: " + idade + "\nNome: " + alunos.get(idade) + nome));
    }


    /*
    public Aluno buscaMatriculado(int codigoAluno){
        for (Aluno aluno: this.alunos) {
            if(aluno.getCodigo() == codigoAluno){
                return aluno;
            }
        }
        throw new NoSuchElementException("Matricula nao encontrada");
    }
    */
}
