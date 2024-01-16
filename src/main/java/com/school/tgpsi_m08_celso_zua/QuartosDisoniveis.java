package com.school.tgpsi_m08_celso_zua;

public class QuartosDisoniveis {
    private int numQuarto;
    private String tipoDeQuarto;
    private String status;
    private double preco;

    public QuartosDisoniveis(int numQuarto, String tipoDeQuarto, String status, double preco) {
        this.numQuarto = numQuarto;
        this.tipoDeQuarto = tipoDeQuarto;
        this.status = status;
        this.preco = preco;
    }

    public int getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(int numQuarto) {
        this.numQuarto = numQuarto;
    }

    public String getTipoDeQuarto() {
        return tipoDeQuarto;
    }

    public void setTipoDeQuarto(String tipoDeQuarto) {
        this.tipoDeQuarto = tipoDeQuarto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
