package main;
/**
 * Para alterar o argumentos que são passados para o programa e que posteriormente poderão ser testados através
 * do args[], procurar por "Modify Run Configurations" e inserir os parâmentros
 */



public class TestandoArgumentos {
    public static void main(String[] args) {


        try {

            if (args[0].equals("P")) {
                System.out.println("Abriu parametros");
            } else {
                System.out.println("Abriu como programa normal");
            }

        } catch (Exception ex){

        }
    }
}
