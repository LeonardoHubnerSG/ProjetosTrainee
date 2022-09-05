package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Compra {
    private Date data;
    private Cliente cliente;
    private ArrayList<Produto> produtos;
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

}
