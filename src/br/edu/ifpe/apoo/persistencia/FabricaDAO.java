package br.edu.ifpe.apoo.persistencia;

import br.edu.ifpe.apoo.entidades.Cliente;

public class FabricaDAO {
    private static DAO<Cliente> clienteDAO;

    public static DAO<Cliente> getDAO() {
        if (clienteDAO == null) {
            clienteDAO = new GenericDAO<>();
        }
        return clienteDAO;
    }
}
