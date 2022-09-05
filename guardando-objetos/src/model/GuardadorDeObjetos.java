package model;

import java.security.Guard;

public class GuardadorDeObjetos {
    private Object[] referencias;
    private int contadorDeObjetos;

    public GuardadorDeObjetos(){
        referencias = new Object[10];
        contadorDeObjetos = 0;
    }

    public void armazenaObjeto(Object objeto) {
        referencias[contadorDeObjetos] = objeto;
        contadorDeObjetos++;
        System.out.println(referencias);
    }

    public int getQtdeObjetosGuardados(){
        return contadorDeObjetos;
    }

    public Object getReferencia(int ref){
        return this.referencias[ref];
    }
}
