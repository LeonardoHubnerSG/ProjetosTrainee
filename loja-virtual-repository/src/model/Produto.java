package model;

public class Produto {
    private int id;
    private String nome;
    private String descricao;

    public Produto(int id, String nome, String descricao){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Produto(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + "\nNome: " + this.nome + "\nDescricao: " + this.descricao + "\n";
    }
}
