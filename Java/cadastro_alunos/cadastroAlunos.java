import java.util.Scanner;

class Aluno {
    String nome;
    double nota1;
    double nota2;
    double nota3;

    double calcularMedia() {
        return (nota1 + nota2 + nota3) / 3;
    }

    String verificarSituacao() {
        double media = calcularMedia();

        if (media >= 7) {
            return "Aprovado";
        } else if (media >= 5) {
            return "Recuperação";
        } else {
            return "Reprovado";
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Aluno aluno = new Aluno();

        System.out.println("===== CADASTRO DE ALUNO =====");

        System.out.print("Nome do aluno: ");
        aluno.nome = scanner.nextLine();

        System.out.print("Primeira nota: ");
        aluno.nota1 = scanner.nextDouble();

        System.out.print("Segunda nota: ");
        aluno.nota2 = scanner.nextDouble();

        System.out.print("Terceira nota: ");
        aluno.nota3 = scanner.nextDouble();

        double media = aluno.calcularMedia();

        System.out.println("\n===== RESULTADO =====");
        System.out.println("Aluno: " + aluno.nome);
        System.out.printf("Nota 1: %.1f%n", aluno.nota1);
        System.out.printf("Nota 2: %.1f%n", aluno.nota2);
        System.out.printf("Nota 3: %.1f%n", aluno.nota3);
        System.out.printf("Média: %.2f%n", media);
        System.out.println("Situação: " + aluno.verificarSituacao());

        scanner.close();
    }
}