package br.edu.ifpe.apoo.excecoes;

public class ExcecaoClienteNaoCadastrado extends Exception {
    public ExcecaoClienteNaoCadastrado(String mensagem) {
        super(mensagem);
    }
}
