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
        listaQuartos.add(new QuartosDisponiveis(1,"Um Quartos","Disponivel",120));
        listaQuartos.add(new QuartosDisponiveis(2,"Dois Quartos","Disponivel",250));
        listaQuartos.add(new QuartosDisponiveis(3,"Tres quartos","Disponivel",310));
        listaQuartos.add(new QuartosDisponiveis(4,"Quatro quartos","Nao disponivel",470));
        listaQuartos.add(new QuartosDisponiveis(5,"tres quatros","Ocupado",310));
    }

    public static void loadFuncionariosList(){
        listaFuncionarios.add(new Funcionario(1,"Celso","Alexandre",17,"Superior"));
        listaFuncionarios.add(new Funcionario(2,"Ana","Santos",16,"Gerente de Departamento"));
        listaFuncionarios.add(new Funcionario(3,"João","Silva",28,"Superior"));
        listaFuncionarios.add(new Funcionario(4," Pedro","Oliveira",42,"Supervisor da Equipa"));
        listaFuncionarios.add(new Funcionario(5,"Carolina","Pereira",25,"Auxiliar Administrativo"));


    }
    public static void loadClientList(){
        listaClientes.add(new Cliente(1,"Celso Zua","933867200","20-10-2024","25-10-2024"));
        listaClientes.add(new Cliente(2,"Ana Silva","912345678","15-06-2024","20-06-2024"));
        listaClientes.add(new Cliente(2,"João Santos","935678901","01-02-2024","05-02-2024"));
        listaClientes.add(new Cliente(2,"Maria Oliveira","926123456","22-04-2024","26-04-2024"));
        listaClientes.add(new Cliente(2,"Pedro Pereira"," 910234567","10-10-2024","15-10-2024"));
    }
}
