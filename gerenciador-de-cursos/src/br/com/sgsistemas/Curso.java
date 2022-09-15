package br.com.sgsistemas;

import java.util.*;

public class Curso {

	private String nome;
	private String instrutor;
	private List<Aula> aulas = new LinkedList<Aula>();
	private Set<Aluno> alunos = new HashSet<>();

	public Curso(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}

	public String getNome() {
		return nome;
	}

	public String getInstrutor() {
		return instrutor;
	}

	public List<Aula> getAulas() {
		return Collections.unmodifiableList(aulas);
	}

	public void adiciona(Aula aula) {
		this.aulas.add(aula);
	}

	public void matricula(Aluno aluno) {
		this.alunos.add(aluno);
	}

	public Set<Aluno> getAlunos(){
		return Collections.unmodifiableSet(this.alunos);
	}

	public boolean estaMatriculado(Aluno aluno){
		return alunos.contains(aluno);
	}
}
