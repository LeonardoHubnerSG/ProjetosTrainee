package main;

import model.Animal;
import model.GuardadorDeObjetos;
import model.Pessoa;

public class Testando {
    public static void main(String[] args) {
        GuardadorDeObjetos guardador = new GuardadorDeObjetos();

        Animal animal1 = new Animal(50);
        Pessoa pessoa1 = new Pessoa(80);

        guardador.armazenaObjeto(animal1);
        guardador.armazenaObjeto(pessoa1);

        System.out.println(guardador.getQtdeObjetosGuardados());

        //Object obj = guardador.getReferencia(0);
        //obj.getClass();

        Pessoa ref = (Pessoa) guardador.getReferencia(1);
        int pesoPessoa = ref.getPeso();
        System.out.println(pesoPessoa);
    }
}
