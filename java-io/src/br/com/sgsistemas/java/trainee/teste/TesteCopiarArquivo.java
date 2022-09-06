package br.com.sgsistemas.java.trainee.teste;

import java.io.*;

public class TesteCopiarArquivo {
    public static void main(String[] args) throws IOException {
        InputStream fis = new FileInputStream("Lorem.txt");
        Reader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        OutputStream fos = new FileOutputStream("Lorem2.txt");
        Writer osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);

        String linha = br.readLine();
        while (linha != null){
            bw.write(linha);
            bw.newLine();
            linha = br.readLine();
        }

        br.close();
        bw.close();
    }
}
