package br.edu.ifpe.apoo.persistencia;

import java.util.List;

public interface DAO<T> {

    void adicionar(T elemento);

    void remover(T elemento);

    void atualizar(T elemento);

    T consultarPorNome(String nome);

    List<T> listarTodos();
}
