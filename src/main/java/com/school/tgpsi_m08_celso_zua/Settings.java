package com.school.tgpsi_m08_celso_zua;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Settings {
    public static ObservableList<QuartosDisponiveis> listaQuartos = FXCollections.observableArrayList();
    public static ObservableList<Funcionario> listaFuncionarios = FXCollections.observableArrayList();
    public static ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
    public static ObservableList<Funcionario>getListaFuncionarios(){
        return listaFuncionarios;
    }

    public static ObservableList<QuartosDisponiveis>getListaQuartos(){
        return listaQuartos;
    }
    public static ObservableList<Cliente>getListaClientes(){
        return listaClientes;
    }
//----------------------------------------------------------------------------------------------------------------------
    public static QuartosDisponiveis EditarQuarto;
    public static Funcionario EditarFuncionario;
    public static Cliente EditarCliente;

//----------------------------------------------------------------------------------------------------------------------
    public static QuartosDisponiveis getEditarQuarto(){
        return EditarQuarto;
    }
    public static Funcionario getEditarFuncionario(){
        return EditarFuncionario;
    }
    public static Cliente getEditarCliente(){
        return EditarCliente;
    }
//----------------------------------------------------------------------------------------------------------------------
    public static void setEditarQuarto(QuartosDisponiveis EditarQuarto){
        Settings.EditarQuarto = EditarQuarto;
    }
    public static void setListaQuartosDisponiveis(ObservableList<QuartosDisponiveis> listaQuartos) {
        Settings.listaQuartos = listaQuartos;
    }
    public static void setEditarCliente(Cliente EditarCliente){
        Settings.EditarCliente = EditarCliente;
    }

//---------------------------------------------------------------------------------------------------------------------
    public static void setEditarFuncionario(Funcionario EditarFuncionario){
        Settings.EditarFuncionario = EditarFuncionario;
    }

    public static void setListaFuncionarios(ObservableList<Funcionario> listaFuncionarios){
        Settings.listaFuncionarios = listaFuncionarios;
    }
    public static void setListaClientes(ObservableList<Cliente>listaClientes){
        Settings.listaClientes = listaClientes;
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
    public static void loadClientList(){
        listaClientes.add(new Cliente(1,"Celso Alexandre","933867200","20-10-2024","21-10-2024"));
        listaClientes.add(new Cliente(2,"sadsada","933867201","22-10-2024","23-10-2024"));
    }
}
