package com.school.tgpsi_m08_celso_zua;

public class Reserva {
    private int roomNumber;
    private String Roomtype;
    private String status;
    private double price;

    public Reserva(int roomNumber, String roomtype, String status, double price) {
        this.roomNumber = roomNumber;
        Roomtype = roomtype;
        this.status = status;
        this.price = price;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomtype() {
        return Roomtype;
    }

    public void setRoomtype(String roomtype) {
        Roomtype = roomtype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
