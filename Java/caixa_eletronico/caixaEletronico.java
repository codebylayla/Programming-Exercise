import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double saldo = 1000.00;
        int opcao;

        do {
            System.out.println("\n===== CAIXA ELETRÔNICO =====");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.printf("\nSaldo atual: R$ %.2f%n", saldo);
                    break;

                case 2:
                    System.out.print("\nDigite o valor do depósito: R$ ");
                    double deposito = scanner.nextDouble();

                    if (deposito > 0) {
                        saldo += deposito;
                        System.out.printf(
                            "Depósito realizado! Novo saldo: R$ %.2f%n",
                            saldo
                        );
                    } else {
                        System.out.println("O valor deve ser maior que zero.");
                    }
                    break;

                case 3:
                    System.out.print("\nDigite o valor do saque: R$ ");
                    double saque = scanner.nextDouble();

                    if (saque <= 0) {
                        System.out.println("O valor deve ser maior que zero.");
                    } else if (saque > saldo) {
                        System.out.println("Saldo insuficiente.");
                    } else {
                        saldo -= saque;
                        System.out.printf(
                            "Saque realizado! Novo saldo: R$ %.2f%n",
                            saldo
                        );
                    }
                    break;

                case 4:
                    System.out.println("\nObrigado por utilizar o caixa eletrônico!");
                    break;

                default:
                    System.out.println("\nOpção inválida.");
            }

        } while (opcao != 4);

        scanner.close();
    }
}