package br.edu.ifpe.apoo.apresentacao;

import br.edu.ifpe.apoo.negocio.ControladorCliente;
import br.edu.ifpe.apoo.entidades.Cliente;
import br.edu.ifpe.apoo.excecoes.ExcecaoNegocio;
import br.edu.ifpe.apoo.excecoes.ExcecaoClienteNaoCadastrado;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TelaCliente {
    private Scanner scanner = new Scanner(System.in);
    private ControladorCliente controlador = new ControladorCliente();

    public void exibirMenu() {
        int opcao = -1;
        do {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Remover Cliente");
            System.out.println("3. Editar Cliente");
            System.out.println("4. Consultar Cliente");
            System.out.println("5. Sair");
            System.out.print("Selecione uma opção: ");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcao) {
                    case 1:
                        adicionarCliente();
                        break;
                    case 2:
                        removerCliente();
                        break;
                    case 3:
                        editarCliente();
                        break;
                    case 4:
                        consultarCliente();
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida! Por favor, selecione uma opção entre 1 e 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, digite um número.");
                scanner.nextLine(); 
            }
        } while (opcao != 5);
    }

    private void adicionarCliente() {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o sexo do cliente: ");
        String sexo = scanner.nextLine();
        System.out.print("Digite a idade do cliente: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); 

        Cliente cliente = new Cliente(nome, sexo, idade);
        controlador.adicionarCliente(cliente);
    }

    private void removerCliente() {
        System.out.print("Digite o nome do cliente a ser removido: ");
        String nome = scanner.nextLine();
        try {
            controlador.removerCliente(nome);
        } catch (ExcecaoNegocio e) {
            System.out.println(e.getMessage());
        }
    }

    private void editarCliente() {
        System.out.print("Digite o nome do cliente a ser editado: ");
        String nome = scanner.nextLine();
        try {
            Cliente clienteExistente = controlador.consultarCliente(nome);

            System.out.print("Digite o novo nome do cliente: ");
            String novoNome = scanner.nextLine();
            System.out.print("Digite o novo sexo do cliente: ");
            String novoSexo = scanner.nextLine();
            System.out.print("Digite a nova idade do cliente: ");
            int novaIdade = scanner.nextInt();
            scanner.nextLine(); 

            Cliente novosDados = new Cliente(novoNome, novoSexo, novaIdade);
            controlador.editarCliente(nome, novosDados);
        } catch (ExcecaoClienteNaoCadastrado e) {
            System.out.println(e.getMessage());
        }
    }

    private void consultarCliente() {
        System.out.print("Digite o nome do cliente a ser consultado: ");
        String nome = scanner.nextLine();
        try {
            Cliente cliente = controlador.consultarCliente(nome);
            System.out.println("Cliente encontrado: " + cliente.getNome() + ", " + cliente.getSexo() + ", " + cliente.getIdade());
        } catch (ExcecaoClienteNaoCadastrado e) {
            System.out.println(e.getMessage());
        }
    }
}
