package com.school.tgpsi_m08_celso_zua;

public class Pessoa extends Reserva{
    private int id;

    public Pessoa(int roomNumber, String roomtype, String status, double price, int id) {
        super(roomNumber, roomtype, status, price);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
