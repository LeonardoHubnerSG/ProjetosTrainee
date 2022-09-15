package model;

public class Produto {
    private int id;
    private String nome;
    private String descricao;

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + "\nNome: " + this.nome + "\nDescricao: " + this.descricao + "\n";
    }
}
