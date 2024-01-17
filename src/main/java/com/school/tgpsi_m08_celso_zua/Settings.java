package com.school.tgpsi_m08_celso_zua;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Settings {

    public static ObservableList<QuartosDisponiveis> listaQuartos = FXCollections.observableArrayList();

    public static ObservableList<QuartosDisponiveis>getListaQuartos(){
        return listaQuartos;
    }

    public static void setListaQuartosDisponiveis(ObservableList<QuartosDisponiveis> listaQuartos) {
        Settings.listaQuartos = listaQuartos;
    }

    public static void loadRoomList(){
        listaQuartos.add(new QuartosDisponiveis(1,"Dois Quartos","Disponivel",100));
        listaQuartos.add(new QuartosDisponiveis(2,"Um Quarto","Não Disponivel",200));
    }
}
