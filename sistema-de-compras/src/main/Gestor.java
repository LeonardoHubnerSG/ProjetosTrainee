package main;

import model.Cliente;
import model.Compra;
import model.Produto;

import java.text.SimpleDateFormat;
import java.util.Collections;
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

        /*ComparadorValorProdutos comparadorPorValor = new ComparadorValorProdutos();

        compra.getListaProdutos();
        compra.produtos.sort(comparadorPorValor);
        compra.getListaProdutos();

        ComparadorDescricaoProdutos comparadorPorDescricao = new ComparadorDescricaoProdutos();

        compra.getListaProdutos();
        compra.produtos.sort(comparadorPorDescricao);
        compra.getListaProdutos();
        */

        compra.getListaProdutos();
        compra.produtos.sort(null); //Ordena pela ordem natural definida na definição da classe Produto (evitar fazer dessa forma)
        compra.getListaProdutos();

        Collections.sort(compra.produtos);
        compra.getListaProdutos();
        Collections.reverse(compra.produtos);
        compra.getListaProdutos();

        /*
        compra.produtos.sort(new Comparator<Produto>(){ //criando classe anônima
                                    @Override
                                    public int compare(Produto produto1, Produto produto2) {
                                        return Double.compare(produto1.getValor(), produto2.getValor());
                                    }
                                }
                            );

        Comparator<Produto> comparador = new Comparator<Produto>(){ //criando classe anônima
                                                @Override
                                                public int compare(Produto produto1, Produto produto2) {
                                                    String nomeProduto1 = produto1.getNome();
                                                    String nomeProduto2 = produto2.getNome();
                                                    return nomeProduto1.compareTo(nomeProduto2);
                                                }
                                        };
        compra.produtos.sort(comparador);
        compra.getListaProdutos();
         */

        compra.produtos.sort((prod1, prod2) -> Double.compare(produto1.getValor(), produto2.getValor()));

        compra.getListaProdutos();

        compra.produtos.forEach((produtos) -> System.out.println(produtos + " OI"));

    }
}

class ComparadorDescricaoProdutos implements Comparator<Produto>{
    @Override
    public int compare(Produto produto1, Produto produto2) {
        String nomeProduto1 = produto1.getNome();
        String nomeProduto2 = produto2.getNome();
        return nomeProduto1.compareTo(nomeProduto2);

        //return produto1.getNome().compareTo(produto2.getNome());
    }
}

class ComparadorValorProdutos implements Comparator<Produto>{

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
