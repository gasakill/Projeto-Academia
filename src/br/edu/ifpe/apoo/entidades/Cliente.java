package br.edu.ifpe.apoo.entidades;

public class Cliente {
    private static int contadorId = 0;
    private int id;
    private String nome;
    private String sexo;
    private int idade;
    private String cpf;

    public Cliente(String nome, String sexo, int idade, String cpf) {
        this.id = ++contadorId;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", idade=" + idade +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
