package br.com.sgsistemas;

import java.util.HashSet;
import java.util.Set;

public class ImprimindoAlunosSemAcentos {
    public static void main(String[] args) {
        Set<String> alunos = new HashSet<>();
        alunos.add("Paulo");
        alunos.add("Alberto");
        alunos.add("Pedro");
        alunos.add("Nico");

        alunos.forEach(aluno -> System.out.println(aluno));
        /*
        for (String aluno : alunos) {
            System.out.println(aluno);
        }
        */

        System.out.println(alunos.size());

        alunos.add("Paulo");

        System.out.println(alunos.size());

    }
}
