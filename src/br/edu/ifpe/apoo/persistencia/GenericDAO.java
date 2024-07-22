package br.edu.ifpe.apoo.persistencia;

import java.util.ArrayList;
import java.util.List;
import br.edu.ifpe.apoo.entidades.Cliente;

public class GenericDAO<T> implements DAO<T> {

    private List<T> elementos = new ArrayList<>();

    @Override
    public void adicionar(T elemento) {
        elementos.add(elemento);
        System.out.println("Elemento adicionado.");
    }

    @Override
    public void remover(T elemento) {
        elementos.remove(elemento);
        System.out.println("Elemento removido.");
    }

    @Override
    public void atualizar(T elemento) {
        int index = elementos.indexOf(elemento);
        if (index != -1) {
            elementos.set(index, elemento);
            System.out.println("Elemento atualizado.");
        }
    }

    @Override
    public T consultarPorNome(String nome) {
        for (T elemento : elementos) {
            if (elemento instanceof Cliente) {
                Cliente cliente = (Cliente) elemento;
                if (cliente.getNome().equalsIgnoreCase(nome)) {
                    return elemento;
                }
            }
        }
        return null;
    }

    @Override
    public List<T> listarTodos() {
        return new ArrayList<>(elementos);
    }
}
