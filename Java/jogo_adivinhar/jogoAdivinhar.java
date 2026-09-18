import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numeroSecreto = random.nextInt(100) + 1;
        int tentativa;
        int quantidadeTentativas = 0;

        System.out.println("================================");
        System.out.println("       JOGO DE ADIVINHAÇÃO");
        System.out.println("================================");
        System.out.println("Tente descobrir o número entre 1 e 100!");

        do {
            System.out.print("\nDigite seu palpite: ");
            tentativa = scanner.nextInt();

            quantidadeTentativas++;

            if (tentativa < numeroSecreto) {
                System.out.println("O número secreto é MAIOR.");
            } else if (tentativa > numeroSecreto) {
                System.out.println("O número secreto é MENOR.");
            } else {
                System.out.println("\n🎉 Parabéns! Você acertou!");
                System.out.println("Número secreto: " + numeroSecreto);
                System.out.println("Tentativas: " + quantidadeTentativas);
            }

        } while (tentativa != numeroSecreto);

        scanner.close();
    }
}
