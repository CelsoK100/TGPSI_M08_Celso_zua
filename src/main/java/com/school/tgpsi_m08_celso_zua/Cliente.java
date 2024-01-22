package com.school.tgpsi_m08_celso_zua;

public class Cliente {
    //Atributos
    private int idClientes;
    private String nome;
    private String telefone;
    private String checkIn;
    private String checkOut;

    // Construtor da classe Cliente
    public Cliente(int idClientes, String nome, String telefone, String checkIn, String checkOut) {
        this.idClientes = idClientes;
        this.nome = nome;
        this.telefone = telefone;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    //Métodos getters e setters

    // Método para obter o ID do cliente
    public int getIdClientes() {
        return idClientes;
    }

    // Método para obter o nome do cliente
    public String getNome() {
        return nome;
    }

    // Método para definir o nome do cliente
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método para obter o telefone do cliente
    public String getTelefone() {
        return telefone;
    }

    // Método para definir o telefone do cliente
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Método para obter a data de check-in do cliente
    public String getCheckIn() {
        return checkIn;
    }

    // Método para definir a data de check-in do cliente
    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    // Método para obter a data de check-out do cliente
    public String getCheckOut() {
        return checkOut;
    }

    // Método para definir a data de check-out do cliente
    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }
}
