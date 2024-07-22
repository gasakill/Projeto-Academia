package br.edu.ifpe.apoo.excecoes;

public class ExcecaoSexoInvalido extends ExcecaoNegocio {
    public ExcecaoSexoInvalido() {
        super("Sexo inválido! Por favor, insira 'masculino' ou 'feminino'.");
    }
}
