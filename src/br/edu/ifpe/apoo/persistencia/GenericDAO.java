package br.edu.ifpe.apoo.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GenericDAO<T> {
    private List<T> lista = new ArrayList<>();

    public void inserir(T obj) {
        lista.add(obj);
    }

    public boolean remover(T obj) {
        return lista.remove(obj);
    }

    public Optional<T> buscarPorNome(String nome, java.util.function.Function<T, String> nomeFunc) {
        return lista.stream().filter(obj -> nomeFunc.apply(obj).equalsIgnoreCase(nome)).findFirst();
    }

    public void atualizar(T obj, java.util.function.Predicate<T> predicado, java.util.function.Consumer<T> atualizador) {
        lista.stream().filter(predicado).findFirst().ifPresent(atualizador);
    }
}