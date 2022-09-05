package execucao;

import classes.Aluno;
import classes.Endereco;
import classes.Escola;

public class Programa {

    public static void main(String[] args) {

        Escola escola = new Escola("SG Sistemas");
        escola.setEndereco("Rua Americo Brasiliense",
                     "1574",
                         "Jardim Independencia",
                           "87113160",
                         "Sarandi");
        escola.setTurma("Portugues");

        Aluno aluno1 = new Aluno("Leonardo", "111.111.111-11", 27);
        aluno1.setEndereco("Rua Joaquim",
                     "1593",
                         "Jardim Panorama",
                           "87111111",
                         "Maringa");

        Aluno aluno2 = new Aluno("Reinaldo", "222.222.222-22", 58);
        Aluno aluno3 = new Aluno("Luzia", "333.333.333-33", 55);
        Aluno aluno4 = new Aluno("Emilly", "444.444.444-44", 17);

        escola.getTurma().adicionaAluno(aluno1);
        escola.getTurma().adicionaAluno(aluno2);
        escola.getTurma().adicionaAluno(aluno3);
        escola.getTurma().adicionaAluno(aluno4);

        System.out.println("Número de alunos: " + escola.getTurma().getNumeroAlunos());
        escola.getTurma().mostrarAlunos();


        /*
        System.out.println("Nome Escola: " + escola.getNomeEscola());
        System.out.println("Cidade Escola: " + escola.getEndereco().getCidade());
        System.out.println("Materia da Escola: " + escola.getTurma().getNomeMateria());
        System.out.println("Nome Aluno: " + escola.getTurma().getAluno(1).getNome());
        System.out.println("Cidade Aluno: " + escola.getTurma().getAluno(0).getEndereco().getCidade());
        */

        //aluno1.setSexo("m");
        //aluno1.getEndereco().setCidade("Paranavaí");
        //System.out.println("Cidade Aluno: " + escola.getTurma().getAluno().getEndereco().getCidade());

    }
}
