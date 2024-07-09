package br.edu.ifpe.apoo.negocio;

import br.edu.ifpe.apoo.entidades.Cliente;
import br.edu.ifpe.apoo.excecoes.ExcecaoClienteNaoCadastrado;
import br.edu.ifpe.apoo.persistencia.GenericDAO;

public class ControladorCliente {
    private GenericDAO<Cliente> clienteDAO = new GenericDAO<>();

    public void adicionarCliente(Cliente cliente) {
        clienteDAO.inserir(cliente);
        System.out.println("Cliente adicionado: " + cliente.getNome());
    }

    public void removerCliente(String nome) throws ExcecaoClienteNaoCadastrado {
        Cliente cliente = consultarCliente(nome);
        if (clienteDAO.remover(cliente)) {
            System.out.println("Cliente removido: " + cliente.getNome());
        } else {
            throw new ExcecaoClienteNaoCadastrado("Cliente não encontrado para remoção.");
        }
    }

    public Cliente consultarCliente(String nome) throws ExcecaoClienteNaoCadastrado {
        return clienteDAO.buscarPorNome(nome, Cliente::getNome)
                         .orElseThrow(() -> new ExcecaoClienteNaoCadastrado("Cliente não encontrado."));
    }

    public void editarCliente(String nome, Cliente novosDados) throws ExcecaoClienteNaoCadastrado {
        Cliente cliente = consultarCliente(nome);
        clienteDAO.atualizar(cliente, c -> c.getNome().equalsIgnoreCase(nome), c -> {
            c.setNome(novosDados.getNome());
            c.setSexo(novosDados.getSexo());
            c.setIdade(novosDados.getIdade());
        });
        System.out.println("Cliente atualizado: " + novosDados.getNome());
    }
}
