package com.school.tgpsi_m08_celso_zua;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Settings {
    public static ObservableList<QuartosDisponiveis> listaQuartos = FXCollections.observableArrayList();
    public static ObservableList<Funcionario> listaFuncionarios = FXCollections.observableArrayList();

    public static ObservableList<Funcionario>getListaFuncionarios(){
        return listaFuncionarios;
    }

    public static ObservableList<QuartosDisponiveis>getListaQuartos(){
        return listaQuartos;
    }
//----------------------------------------------------------------------------------------------------------------------
    public static QuartosDisponiveis EditarQuarto;
    public static Funcionario EditarFuncionario;

//----------------------------------------------------------------------------------------------------------------------
    public static QuartosDisponiveis getEditarQuarto(){
        return EditarQuarto;
    }
    public static Funcionario getEditarFuncionario(){
        return EditarFuncionario;
    }
//----------------------------------------------------------------------------------------------------------------------
    public static void setEditarQuarto(QuartosDisponiveis EditarQuarto){
        Settings.EditarQuarto = EditarQuarto;
    }
    public static void setListaQuartosDisponiveis(ObservableList<QuartosDisponiveis> listaQuartos) {
        Settings.listaQuartos = listaQuartos;
    }

    public static void setEditarFuncionario(Funcionario EditarFuncionario){
        Settings.EditarFuncionario = EditarFuncionario;
    }

    public static void setListaFuncionarios(ObservableList<Funcionario> listaFuncionarios){
        Settings.listaFuncionarios = listaFuncionarios;
    }
//----------------------------------------------------------------------------------------------------------------------
    public static void loadRoomList(){
        listaQuartos.add(new QuartosDisponiveis(1,"Dois Quartos","Disponivel",100));
        listaQuartos.add(new QuartosDisponiveis(2,"Um Quarto","Não Disponivel",200));
    }

    public static void loadFuncionariosList(){
        listaFuncionarios.add(new Funcionario(1,"Celso","Alexandre",17,"Superior"));
        listaFuncionarios.add(new Funcionario(2,"Luana","Ascenso",16,"Superior"));

    }
}
