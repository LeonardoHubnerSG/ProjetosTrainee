package main;

public class HelloGIT {
    public static void main(String[] args) {
        System.out.println("Hello GIT");
        imprimeMsg();
        imprimeMsg2();
    }

    public static void imprimeMsg(){
        System.out.println("Meu primerio commit na branch OS-123456");
    }

    public static void imprimeMsg2(){
        System.out.println("Commit na branch OS-654321 para fazer pull request no GitHub");
    }
}
