package set.iterator;


import set.model.Aluno;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ExemploIterator {
    public static void main(String[] args) {
        Aluno a1 = new Aluno();
        a1.setNome("Leo");

        Aluno a2 = new Aluno();
        a2.setNome("Rei");

        Aluno a3 = new Aluno();
        a3.setNome("Lú");

        Aluno a4 = new Aluno();
        a4.setNome("Emy");

        Set<Aluno> alunos = new HashSet<>();
        alunos.add(a1);
        alunos.add(a2);
        alunos.add(a3);
        alunos.add(a4);

        Iterator<Aluno> alunosIterator = alunos.iterator();

        while (alunosIterator.hasNext()){
            Aluno it = alunosIterator.next();
            System.out.println(it.getNome());
        }
    }
}
