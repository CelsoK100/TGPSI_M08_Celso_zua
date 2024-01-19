package com.school.tgpsi_m08_celso_zua;

public class Cliente {
    private int idClientes;
    private String nome;
    private String telefone;
    private String checkIn;
    private String checkOut;

    public Cliente(int idClientes, String nome, String telefone, String checkIn, String checkOut) {
        this.idClientes = idClientes;
        this.nome = nome;
        this.telefone = telefone;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getIdClientes() {
        return idClientes;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }
}
