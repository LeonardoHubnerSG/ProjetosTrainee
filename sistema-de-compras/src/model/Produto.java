package model;

public class Produto implements Comparable<Produto>{
    private int cod;
    private String nome;
    private double valor;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public int compareTo(Produto outroProduto) {
        return Double.compare(this.valor, outroProduto.valor);
    }

    @Override
    public String toString() {
        return "\nCód Produto: " + this.cod +
               "\nDescrição: " + this.nome +
               "\nValor: " + this.valor;
    }
}
