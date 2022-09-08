package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ImportacaoReceita {
    public ArrayList<NaturezaReceita> naturezaReceita;

    public ImportacaoReceita(){
        naturezaReceita = new ArrayList<NaturezaReceita>();
    }

    public void adicionaLinha(String linha) {
        NaturezaReceita naturezaReceita = new NaturezaReceita(linha);
        this.naturezaReceita.add(naturezaReceita);
    }

    public void armazenarDadosArquivo(String nomeArquivo) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(nomeArquivo), "windows-1252");
        scanner.nextLine();

        while(scanner.hasNextLine()){
            String linha = scanner.nextLine();
            adicionaLinha(linha);
        }
        scanner.close();
    }

    public void listarDadosArquivo(){
        for (NaturezaReceita natureRevenue : this.naturezaReceita){
            System.out.println(natureRevenue);
        }
    }

}
