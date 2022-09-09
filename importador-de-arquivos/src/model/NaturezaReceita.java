package model;

import java.util.Locale;
import java.util.Scanner;

public class NaturezaReceita {
    private String codigo = "";
    private String descProd = "";
    private String dtIni = "";
    private String dtFim = "";
    private String ncm = "";
    private String ncmEX = "";
    private String exIPI = "";
    private String aliqPIS = "";
    private String aliqCofin = "";

    public NaturezaReceita(String linha) {
        String[] dadosSeparados = linha.split("\\|",10);

         this.codigo    = dadosSeparados[0];
         this.descProd  = dadosSeparados[1];
         this.dtIni     = dadosSeparados[2];
         this.dtFim     = dadosSeparados[3];
         this.ncm       = dadosSeparados[4];
         this.ncmEX     = dadosSeparados[5];
         this.exIPI     = dadosSeparados[6];

         if (dadosSeparados.length > 7) {
             this.aliqPIS = dadosSeparados[7];
             this.aliqCofin = dadosSeparados[8];
         }

        //Scanner linhaScanner = new Scanner(linha);
        //linhaScanner.useLocale(Locale.US);
        //linhaScanner.useDelimiter("\\|");
        //linhaScanner.close();

        /*
        if (linhaScanner.hasNext()) this.codigo = linhaScanner.next();
        if (linhaScanner.hasNext()) this.descProd = linhaScanner.next();
        if (linhaScanner.hasNext()) this.dtIni = linhaScanner.next();
        if (linhaScanner.hasNext()) this.dtFim = linhaScanner.next();
        if (linhaScanner.hasNext()) this.ncm = linhaScanner.next();
        if (linhaScanner.hasNext()) this.ncmEX = linhaScanner.next();
        if (linhaScanner.hasNext()) this.exIPI = linhaScanner.next();
        if (linhaScanner.hasNext()) this.aliqPIS = linhaScanner.next();
        if (linhaScanner.hasNext()) this.aliqCofin = linhaScanner.next();
        */
    }

    @Override
    public String toString() {
        return "\nCódigo        : " + this.codigo +
               "\nProduto       : " + this.descProd +
               "\nData inicial  : " + this.dtIni +
               "\nData final    : " + this.dtFim +
               "\nNCM           : " + this.ncm +
               "\nNCM EX        : " + this.ncmEX +
               "\nEX IPI        : " + this.exIPI +
               "\nAliquota PIS  : " + this.aliqPIS +
               "\nAliquota Cofin: " + this.aliqCofin;
    }
}
