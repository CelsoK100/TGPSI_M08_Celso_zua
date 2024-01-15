package com.school.tgpsi_m08_celso_zua;

public class Funcionario extends Pessoa{
    private String nome;
    private int idade;

    public Funcionario(int roomNumber, String roomtype, String status, double price, int id, String nome, int idade) {
        super(roomNumber, roomtype, status, price, id);
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
