package set.hashMap;

import java.util.HashMap;
import java.util.Map;

//Sabendo que temos acesso ao conjunto de chaves de um Map através do método keySet(),
// implemente um código que itere por esse conjunto e imprima os seus valores.

public class MaisExemplosHashMap {

    public static void main(String[] args) {

        Map<Integer, String> pessoas = new HashMap<>();

        pessoas.put(21, "Leonardo Cordeiro");
        pessoas.put(27, "Fabio Pimentel");
        pessoas.put(19, "Silvio Mattos");
        pessoas.put(23, "Romulo Henrique");


        //System.out.println(pessoas.keySet());

        pessoas.forEach((idade, nome) -> System.out.println("Idade/chave: " + idade + "\nNome: " + pessoas.get(idade) + nome));

    }
}