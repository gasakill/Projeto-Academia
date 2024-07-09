package br.edu.ifpe.apoo.negocio;

import br.edu.ifpe.apoo.entidades.Cliente;
import br.edu.ifpe.apoo.persistencia.DAO;
import br.edu.ifpe.apoo.persistencia.FabricaDAO;

public class ControladorCliente {

    private DAO<Cliente> clienteDAO;

    public ControladorCliente() {
        this.clienteDAO = FabricaDAO.getDAO();
    }

    public void adicionarCliente(Cliente cliente) {
        clienteDAO.adicionar(cliente);
    }

    public void removerCliente(Cliente cliente) {
        clienteDAO.remover(cliente);
    }

    public void atualizarCliente(Cliente cliente) {
        clienteDAO.atualizar(cliente);
    }

    public Cliente consultarClientePorNome(String nome) {
        return clienteDAO.consultarPorNome(nome);
    }
}
