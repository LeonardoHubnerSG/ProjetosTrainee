package classes;

public class Aluno {
    private String nome;
    private String cpf;
    private int idade;
    private String sexo;
    private Endereco endereco;

    public Aluno(String nome, String cpf, int idade){
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        if (sexo != "m" && sexo != "f"){
            System.out.println("Sexo invalido");
            return;
        }
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String rua, String numeroCasa, String bairro, String cep, String cidade){
        this.endereco = new Endereco(rua, numeroCasa, bairro, cep, cidade);
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome;
    }
}
