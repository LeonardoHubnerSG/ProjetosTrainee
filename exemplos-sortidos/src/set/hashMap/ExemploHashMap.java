package set.hashMap;

import set.model.Aluno;
import set.model.Turma;

public class ExemploHashMap {
    public static void main(String[] args) {
        Turma turma = new Turma();

        Aluno a1 = new Aluno();
        a1.setCodigo(1);
        a1.setNome("Leo");

        Aluno a2 = new Aluno();
        a2.setCodigo(2);
        a2.setNome("Rei");

        Aluno a3 = new Aluno();
        a3.setCodigo(3);
        a3.setNome("Lú");

        Aluno a4 = new Aluno();
        a4.setCodigo(4);
        a4.setNome("Emy");

        Aluno a5 = new Aluno();
        a5.setCodigo(1);
        a5.setNome("Okay");

        turma.matricula(a1);
        turma.matricula(a2);
        turma.matricula(a3);
        turma.matricula(a4);
        turma.matricula(a5);

        System.out.println("Quem é o aluno de codigo/matricula 3?");
        Aluno aluno = turma.buscaMatriculado(1);
        System.out.println("Aluno: " + aluno);

        turma.percorreMap();



    }
}
