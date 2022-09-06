package model;

import java.text.SimpleDateFormat;
import java.util.*;

public class Compra {
    private Date data;
    private Cliente cliente;
    public ArrayList<Produto> produtos;
    private double totalCompra = 0;

    public Compra(){
        produtos = new ArrayList<Produto>();
    }

    public String getData() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(data);
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void getListaProdutos() {
        System.out.print("**** Lista de Compras ****");
        for (Produto produto : this.produtos){
            System.out.println(produto);
        }
    }

    public void adicionaProdutos(Produto produto) {
        this.produtos.add(produto);
        totalCompra += produto.getValor();
    }

    public void removeProdutos(int posicao) {
        totalCompra -= this.produtos.get(posicao).getValor();
        this.produtos.remove(posicao);
    }

    public double getTotalCompra() {
        double valorTotal = 0;
        for (Produto produto : this.produtos){
            valorTotal += produto.getValor();
        }
        return valorTotal; //totalCompra;
    }

    public void mostraCompra() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        double valorTotal = 0;

        System.out.println("********** COMPRA **********");
        System.out.println("Data: " + formato.format(data));
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("********* PRODUTOS *********");
        System.out.printf("%1s%10s%15s\n", "Cód", "Descrição", "Valor (R$)");
        for (Produto produto : this.produtos){
            System.out.printf("%-4s%-15s%.2f\n", produto.getCod(), produto.getNome(), produto.getValor());
            valorTotal += produto.getValor();
        }
        System.out.println("----------------------------");
        System.out.printf("TOTAL DA COMPRA: R$%.2f\n", valorTotal);
        System.out.println("----------------------------");

    }
}
