package main;

import model.ImportacaoReceita;

import java.io.FileNotFoundException;

public class TesteLeituraArquivo {
    public static void main(String[] args) throws FileNotFoundException {
        //System.out.println("Deseja realizar a importação dos arquivos?");

        ImportacaoReceita arquivo = new ImportacaoReceita();

        arquivo.armazenarDadosArquivo("Tabela_4_3_10.txt");
        arquivo.armazenarDadosArquivo("Tabela_4_3_12.txt");
        arquivo.armazenarDadosArquivo("Tabela_4_3_13.txt");
        arquivo.armazenarDadosArquivo("Tabela_4_3_14.txt");
        arquivo.armazenarDadosArquivo("Tabela_4_3_15.txt");
        arquivo.armazenarDadosArquivo("Tabela_4_3_16.txt");

        arquivo.listarDadosArquivo();

    }
}
