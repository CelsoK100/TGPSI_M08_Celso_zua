package com.school.tgpsi_m08_celso_zua;

public class Funcionario {
    //Atributos
    private int id;
    private String primeiroNome;
    private String segundoNome;
    private int idade;
    private String cargo;

    // Construtor da classe Funcionario
    public Funcionario(int id, String primeiroNome, String segundoNome, int idade, String cargo) {
        this.id = id;
        this.primeiroNome = primeiroNome;
        this.segundoNome = segundoNome;
        this.idade = idade;
        this.cargo = cargo;
    }

    //Métodos getters e setters

    // Obtém o identificador do funcionário
    public int getId(){
        return id;
    }

    // Obtém o Primeiro nome  do funcionário
    public String getPrimeiroNome() {
        return primeiroNome;
    }

    // Define o primeiro nome do funcionário
    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    // Obtém o Segundo nome  do funcionário
    public String getSegundoNome() {
        return segundoNome;
    }

    // Define o Segundo nome do funcionário
    public void setSegundoNome(String segundoNome) {
        this.segundoNome = segundoNome;
    }

    // Obtém a idade do funcionário
    public int getIdade() {
        return idade;
    }

    // Define a idade do funcionário
    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Obtém o cargo do funcionário
    public String getCargo() {
        return cargo;
    }

    // Define o cargo do funcionário

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
