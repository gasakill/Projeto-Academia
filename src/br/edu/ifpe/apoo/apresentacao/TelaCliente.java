package br.edu.ifpe.apoo.apresentacao;

import br.edu.ifpe.apoo.entidades.Cliente;
import br.edu.ifpe.apoo.excecoes.ExcecaoSexoInvalido;
import br.edu.ifpe.apoo.negocio.ControladorCliente;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TelaCliente {

    private ControladorCliente controladorCliente;
    private Scanner scanner;

    public TelaCliente() {
        this.controladorCliente = new ControladorCliente();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = 0;
        do {
            System.out.println("=== Menu Cliente ===");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Remover Cliente");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Consultar Cliente");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer de entrada
                processarOpcao(opcao);
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, digite um número.");
                scanner.nextLine(); // Limpar o buffer de entrada
            }
        } while (opcao != 5);
    }

    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                adicionarCliente();
                break;
            case 2:
                removerCliente();
                break;
            case 3:
                atualizarCliente();
                break;
            case 4:
                consultarCliente();
                break;
            case 5:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida! Digite um número de 1 a 5.");
        }
    }

    private void adicionarCliente() {
        try {
            System.out.print("Nome do cliente: ");
            String nome = scanner.nextLine();
            System.out.print("Sexo do cliente (masculino/feminino): ");
            String sexo = scanner.nextLine();
            System.out.print("Idade do cliente: ");
            int idade = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada
            System.out.print("CPF do cliente: ");
            String cpf = scanner.nextLine();

            Cliente cliente = new Cliente(nome, sexo, idade, cpf);
            controladorCliente.adicionarCliente(cliente);
        } catch (ExcecaoSexoInvalido e) {
            System.out.println(e.getMessage());
        }
    }

    private void removerCliente() {
        System.out.print("Nome do cliente a remover: ");
        String nome = scanner.nextLine();

        Cliente cliente = controladorCliente.consultarClientePorNome(nome);
        if (cliente != null) {
            controladorCliente.removerCliente(cliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private void atualizarCliente() {
        try {
            System.out.print("Nome do cliente a atualizar: ");
            String nome = scanner.nextLine();

            Cliente cliente = controladorCliente.consultarClientePorNome(nome);
            if (cliente != null) {
                System.out.print("Novo nome do cliente: ");
                String novoNome = scanner.nextLine();
                System.out.print("Novo sexo do cliente (masculino/feminino): ");
                String novoSexo = scanner.nextLine();
                System.out.print("Nova idade do cliente: ");
                int novaIdade = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer de entrada
                System.out.print("Novo CPF do cliente: ");
                String novoCpf = scanner.nextLine();

                cliente.setNome(novoNome);
                cliente.setSexo(novoSexo);
                cliente.setIdade(novaIdade);
                cliente.setCpf(novoCpf);
                controladorCliente.atualizarCliente(cliente);
            } else {
                System.out.println("Cliente não encontrado.");
            }
        } catch (ExcecaoSexoInvalido e) {
            System.out.println(e.getMessage());
        }
    }

    private void consultarCliente() {
        System.out.print("Nome do cliente a consultar: ");
        String nome = scanner.nextLine();

        Cliente cliente = controladorCliente.consultarClientePorNome(nome);
        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}

