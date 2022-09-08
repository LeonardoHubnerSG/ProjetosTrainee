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
        Scanner linhaScanner = new Scanner(linha);
        linhaScanner.useLocale(Locale.US);
        linhaScanner.useDelimiter("\\|");

        int contador = 0;

        while (linhaScanner.hasNext()) {
            contador += 1;

            switch(contador){
                case 1:{
                    this.codigo = linhaScanner.next();
                    break;
                }
                case 2:{
                    this.descProd = linhaScanner.next();
                    break;
                }
                case 3:{
                    this.dtIni = linhaScanner.next();
                    break;
                }
                case 4:{
                    this.dtFim = linhaScanner.next();
                    break;
                }
                case 5:{
                    this.ncm = linhaScanner.next();
                    break;
                }
                case 6:{
                    this.ncmEX = linhaScanner.next();
                    break;
                }
                case 7:{
                    this.exIPI = linhaScanner.next();
                    break;
                }
                case 8:{
                    this.aliqPIS = linhaScanner.next();
                    break;
                }
                case 9:{
                    this.aliqCofin = linhaScanner.next();
                    break;
                }
            }
        }

        linhaScanner.close();

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
