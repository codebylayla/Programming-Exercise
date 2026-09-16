import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Estacionamento {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Veiculo> veiculos = new ArrayList<>();

    static final double VALOR_PRIMEIRA_HORA = 5.00;
    static final double VALOR_HORA_ADICIONAL = 3.00;

    static DateTimeFormatter formato =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static void main(String[] args) {

        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    registrarEntrada();
                    break;

                case 2:
                    registrarSaida();
                    break;

                case 3:
                    listarVeiculos();
                    break;

                case 4:
                    buscarVeiculo();
                    break;

                case 5:
                    exibirResumo();
                    break;

                case 0:
                    System.out.println("\nEncerrando o sistema...");
                    System.out.println("Obrigado por utilizar o estacionamento!");
                    break;

                default:
                    System.out.println("\nOpção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }

    // =========================
    // MENU PRINCIPAL
    // =========================

    static void exibirMenu() {

        System.out.println("\n======================================");
        System.out.println("       SISTEMA DE ESTACIONAMENTO");
        System.out.println("======================================");
        System.out.println("1 - Registrar entrada");
        System.out.println("2 - Registrar saída");
        System.out.println("3 - Listar veículos estacionados");
        System.out.println("4 - Buscar veículo");
        System.out.println("5 - Resumo do estacionamento");
        System.out.println("0 - Sair");
        System.out.println("======================================");
    }

    // =========================
    // REGISTRAR ENTRADA
    // =========================

    static void registrarEntrada() {

        System.out.println("\n--- REGISTRAR ENTRADA ---");

        String placa = lerTexto("Digite a placa do veículo: ").toUpperCase();

        if (buscarPorPlaca(placa) != null) {
            System.out.println("Este veículo já está estacionado.");
            return;
        }

        String modelo = lerTexto("Digite o modelo do veículo: ");
        String proprietario = lerTexto("Digite o nome do proprietário: ");

        Veiculo veiculo = new Veiculo(
                placa,
                modelo,
                proprietario,
                LocalDateTime.now()
        );

        veiculos.add(veiculo);

        System.out.println("\nEntrada registrada com sucesso!");
        System.out.println("Placa: " + veiculo.getPlaca());
        System.out.println("Modelo: " + veiculo.getModelo());
        System.out.println("Horário de entrada: "
                + veiculo.getEntrada().format(formato));
    }

    // =========================
    // REGISTRAR SAÍDA
    // =========================

    static void registrarSaida() {

        System.out.println("\n--- REGISTRAR SAÍDA ---");

        String placa = lerTexto("Digite a placa do veículo: ").toUpperCase();

        Veiculo veiculo = buscarPorPlaca(placa);

        if (veiculo == null) {
            System.out.println("Veículo não encontrado.");
            return;
        }

        LocalDateTime saida = LocalDateTime.now();

        long minutos = Duration.between(
                veiculo.getEntrada(),
                saida
        ).toMinutes();

        // Garante pelo menos 1 hora de cobrança.
        long horas = Math.max(1, (minutos + 59) / 60);

        double valor;

        if (horas == 1) {
            valor = VALOR_PRIMEIRA_HORA;
        } else {
            valor = VALOR_PRIMEIRA_HORA
                    + (horas - 1) * VALOR_HORA_ADICIONAL;
        }

        veiculo.setSaida(saida);
        veiculo.setValorPago(valor);

        System.out.println("\n======================================");
        System.out.println("           COMPROVANTE");
        System.out.println("======================================");
        System.out.println("Placa:       " + veiculo.getPlaca());
        System.out.println("Modelo:      " + veiculo.getModelo());
        System.out.println("Proprietário:" + veiculo.getProprietario());
        System.out.println("Entrada:     "
                + veiculo.getEntrada().format(formato));
        System.out.println("Saída:       "
                + saida.format(formato));
        System.out.println("Tempo:       " + horas + " hora(s)");
        System.out.printf("Valor:       R$ %.2f%n", valor);
        System.out.println("======================================");

        veiculos.remove(veiculo);
    }

    // =========================
    // LISTAR VEÍCULOS
    // =========================

    static void listarVeiculos() {

        System.out.println("\n--- VEÍCULOS ESTACIONADOS ---");

        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo estacionado.");
            return;
        }

        for (int i = 0; i < veiculos.size(); i++) {

            Veiculo veiculo = veiculos.get(i);

            System.out.println("\nVeículo #" + (i + 1));
            System.out.println("Placa: " + veiculo.getPlaca());
            System.out.println("Modelo: " + veiculo.getModelo());
            System.out.println("Proprietário: "
                    + veiculo.getProprietario());
            System.out.println("Entrada: "
                    + veiculo.getEntrada().format(formato));
        }
    }

    // =========================
    // BUSCAR VEÍCULO
    // =========================

    static void buscarVeiculo() {

        System.out.println("\n--- BUSCAR VEÍCULO ---");

        String placa = lerTexto("Digite a placa: ").toUpperCase();

        Veiculo veiculo = buscarPorPlaca(placa);

        if (veiculo == null) {
            System.out.println("Veículo não encontrado.");
            return;
        }

        System.out.println("\nVeículo encontrado!");
        System.out.println("Placa: " + veiculo.getPlaca());
        System.out.println("Modelo: " + veiculo.getModelo());
        System.out.println("Proprietário: "
                + veiculo.getProprietario());
        System.out.println("Entrada: "
                + veiculo.getEntrada().format(formato));
    }

    // =========================
    // RESUMO
    // =========================

    static void exibirResumo() {

        System.out.println("\n--- RESUMO DO ESTACIONAMENTO ---");

        System.out.println("Veículos atualmente estacionados: "
                + veiculos.size());

        if (veiculos.isEmpty()) {
            System.out.println("O estacionamento está vazio.");
        } else {
            System.out.println("O estacionamento possui "
                    + veiculos.size()
                    + " veículo(s) no momento.");
        }
    }

    // =========================
    // BUSCAR POR PLACA
    // =========================

    static Veiculo buscarPorPlaca(String placa) {

        for (Veiculo veiculo : veiculos) {

            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                return veiculo;
            }
        }

        return null;
    }

    // =========================
    // FUNÇÕES AUXILIARES
    // =========================

    static String lerTexto(String mensagem) {

        while (true) {

            System.out.print(mensagem);
            String texto = scanner.nextLine().trim();

            if (!texto.isEmpty()) {
                return texto;
            }

            System.out.println("O campo não pode ficar vazio.");
        }
    }

    static int lerInteiro(String mensagem) {

        while (true) {

            try {

                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println(
                        "Digite apenas números."
                );
            }
        }
    }
}

// ==========================================
// CLASSE VEÍCULO
// ==========================================

class Veiculo {

    private String placa;
    private String modelo;
    private String proprietario;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private double valorPago;

    public Veiculo(
            String placa,
            String modelo,
            String proprietario,
            LocalDateTime entrada) {

        this.placa = placa;
        this.modelo = modelo;
        this.proprietario = proprietario;
        this.entrada = entrada;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getProprietario() {
        return proprietario;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
}
