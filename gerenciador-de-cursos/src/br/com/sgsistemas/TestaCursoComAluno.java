package br.com.sgsistemas;

public class TestaCursoComAluno {
    public static void main(String[] args) {
        Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");

        javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
        javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
        javaColecoes.adiciona(new Aula("Modelando com coleções", 24));

        Aluno a1 = new Aluno("Cassiano",1);
        Aluno a2 = new Aluno("Hubner",2);
        Aluno a3 = new Aluno("Felipe",3);
        Aluno a4 = new Aluno("Aleph",4);
        Aluno a5 = new Aluno("Passoni",5);

        Aluno a6 = new Aluno("Passoni",5);

        javaColecoes.matricula(a1);
        javaColecoes.matricula(a2);
        javaColecoes.matricula(a3);
        javaColecoes.matricula(a4);
        javaColecoes.matricula(a5);

        System.out.println("--- Todos os alunos matriculados ---");
        javaColecoes.getAlunos().forEach(aluno -> {
            System.out.println(aluno);
        });

        System.out.println(javaColecoes.estaMatriculado(a1));

        System.out.println(a5.hashCode() == a6.hashCode());


    }
}
