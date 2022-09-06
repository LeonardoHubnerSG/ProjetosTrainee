package br.com.sgsistemas.java.trainee.teste;

import java.io.*;

public class TesteLeitura {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("Lorem.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String linha = br.readLine();

        while (linha != null){
            System.out.println(linha);
            linha = br.readLine();
        }

        br.close();
    }
}
