package br.com.sgsistemas.java.trainee.teste;

import java.io.*;

public class TesteEscrita {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("Lorem2.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);

        bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        bw.newLine();
        bw.newLine();
        bw.write("fdgdfdfgv dffdgdf dfg");

        bw.close();
    }
}
