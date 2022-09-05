package main;

import model.Lista;

public class TesteArraysDePrimitivas {
    public static void main(String[] args) {
        Lista lista = new Lista();

        try {
            lista.preencheArray();
            lista.imprimeArray();
        }catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
            System.out.println("Foi acessada uma posição inválida na array.");
        }
    }
}
