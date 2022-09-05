package main;

import model.Pessoa;

public class TesteArrayDeReferencias {
    public static void main(String[] args) {
        Pessoa[] pessoas = new Pessoa[5];

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Baiano");
        pessoas[0] = pessoa1;
        System.out.println(pessoa1.getNome());
        System.out.println(pessoas[0].getNome());

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Maria");
        pessoas[4] = pessoa2;
        System.out.println(pessoa2.getNome());
        System.out.println(pessoas[4].getNome());




    }
}
