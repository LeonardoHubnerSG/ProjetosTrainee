package model;

public class Paciente extends Pessoa{
    private Integer id;
    private String nomeMae;
    private String numCarteirinha;
    private String corPulseira;

    public Paciente(Integer id, String nome) {
        this.id = id;
        super.setNome(nome);
    }

    public Paciente(Integer id, String nome, String cpf, String dataNascimento, String nomeMae, String numCarteirinha, String corPulseira){
        this.id = id;
        super.setNome(nome);
        super.setCpf(cpf);
        super.setDataNascimento(dataNascimento);
        this.nomeMae = nomeMae;
        this.numCarteirinha = numCarteirinha;
        this.corPulseira = corPulseira;
    }
    public Paciente(String nome, String cpf, String dataNascimento, String nomeMae, String numCarteirinha, String corPulseira){
        super.setNome(nome);
        super.setCpf(cpf);
        super.setDataNascimento(dataNascimento);
        this.nomeMae = nomeMae;
        this.numCarteirinha = numCarteirinha;
        this.corPulseira = corPulseira;
    }

    public Integer getId() {
        return id;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public String getNumCarteirinha() {
        return numCarteirinha;
    }

    public String getCorPulseira() {
        return corPulseira;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Paciente: " + super.getNome() + "\n" +
                "CPF: " + super.getCpf() + "\n" +
                "Data Nascimento: " + super.getDataNascimento() + "\n" +
                "Nome Mãe: " + this.nomeMae + "\n" +
                "Carteirinha: " + this.numCarteirinha + "\n" +
                "Cor Pulseira" + this.corPulseira + "\n";
    }
}
