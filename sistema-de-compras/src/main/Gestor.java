package main;

import model.Cliente;
import model.Compra;
import model.Produto;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Gestor {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setCod(1);
        cliente.setNome("Leonardo");
        cliente.setCpf("111.111.111-11");

        Produto produto1 = new Produto();
        produto1.setCod(1);
        produto1.setNome("Caderno");
        produto1.setValor(20.5);

        Produto produto2 = new Produto();
        produto2.setCod(2);
        produto2.setNome("Lápis");
        produto2.setValor(5.75);

        Produto produto3 = new Produto();
        produto3.setCod(3);
        produto3.setNome("Borracha");
        produto3.setValor(8.0);

        Compra compra = new Compra();
        compra.setCliente(cliente);
        compra.adicionaProdutos(produto1);
        compra.adicionaProdutos(produto2);
        compra.adicionaProdutos(produto3);

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try{
            Date data = formato.parse("05/09/2022");
            compra.setData(data);
        } catch (Exception ex){
            System.out.println("Erro ao capturar a data");
        }

        compra.getListaProdutos();
        System.out.println();
        System.out.println("Valor total da compra: " + compra.getTotalCompra());
        System.out.println("Data da Compra: " + compra.getData());
        System.out.println();

        compra.mostraCompra();

        //compra.removeProdutos(1);
        //System.out.println(compra.getTotalCompra());
        //compra.getListaProdutos();

        ComparadorProdutos comparadorPorValor = new ComparadorProdutos();

        compra.getListaProdutos();
        compra.produtos.sort(comparadorPorValor);
        compra.getListaProdutos();
    }
}

class ComparadorProdutos implements Comparator<Produto>{

    @Override
    public int compare(Produto produto1, Produto produto2) {
        if(produto1.getValor() < produto2.getValor()){
            return -1;
        }
        if(produto1.getValor() > produto2.getValor()){
            return 1;
        }
        return 0;
    }
}
