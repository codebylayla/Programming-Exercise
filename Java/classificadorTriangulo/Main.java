import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o valor do lado a: ");
        double a = scanner.nextDouble();
        System.out.print("Digite o valor do lado b: ");
        double b = scanner.nextDouble();
        System.out.print("Digite o valor do lado c: ");
        double c = scanner.nextDouble();

        if ( a <= 0 || b <= 0 || c <= 0) {
            System.out.println("Os valores dos lados devem ser positivos.");
        } else if (a + b > c && a + c > b && b + c > a) {
            System.out.println("Os valores fornecidos podem formar um triângulo.");
            System.out.println("Classificação do triângulo:");
            
            if (a == b || a == c || b == c) {
                System.out.println("Equilátero");
            } else if (a == b && a == c && b == c) {
                System.out.println("Isósceles");
            } else {
                System.out.println("Escaleno");
            }
        
        } else {
            System.out.println("Os valores fornecidos não podem formar um triângulo.");
        }

    
    }
}