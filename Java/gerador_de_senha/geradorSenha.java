import java.util.Random;
import java.util.Scanner;

public class GeradorSenha {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String letrasMaiusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String letrasMinusculas = "abcdefghijklmnopqrstuvwxyz";
        String numeros = "0123456789";
        String simbolos = "!@#$%&*?";

        String caracteres = letrasMaiusculas
                + letrasMinusculas
                + numeros
                + simbolos;

        System.out.println("================================");
        System.out.println("       GERADOR DE SENHAS");
        System.out.println("================================");

        System.out.print("Digite o tamanho da senha: ");
        int tamanho = scanner.nextInt();

        if (tamanho <= 0) {
            System.out.println("O tamanho deve ser maior que zero.");
        } else {

            StringBuilder senha = new StringBuilder();

            for (int i = 0; i < tamanho; i++) {
                int indice = random.nextInt(caracteres.length());
                senha.append(caracteres.charAt(indice));
            }

            System.out.println("\nSenha gerada:");
            System.out.println(senha);
        }

        scanner.close();
    }
}
