package model;

public class Lista {
    private int[] arrayNumeros = new int[50];

    public void preencheArray(){
        for (int i = 0; i <= arrayNumeros.length; i++){
            this.arrayNumeros[i] = i * 2;
        }
    }

    public void imprimeArray(){
        for (int i = 0; i < arrayNumeros.length; i++){
            System.out.println("Posição " + i + ": " + this.arrayNumeros[i]);
        }
    }
}
