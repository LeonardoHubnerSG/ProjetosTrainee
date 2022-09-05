package classes;

public class Endereco {
    private String rua;
    private String numeroCasa;
    private String bairro;
    private String cep;
    private String cidade;

    public Endereco(String rua, String numeroCasa, String bairro, String cep, String cidade){
        this.rua = rua;
        this.numeroCasa = numeroCasa;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
    }

    public String getRua() {
        return this.rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumeroCasa() {
        return this.numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
