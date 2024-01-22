package com.school.tgpsi_m08_celso_zua;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class PrincipalController implements Initializable {
    //Atributos
    @FXML
    private Button AcercaDeBtn;

    @FXML
    private Button ClearFunBtn;

    @FXML
    private Button ClientBtn;

    @FXML
    private AnchorPane ClientForm;

    @FXML
    private TableView<Cliente> ClientTableView;

    @FXML
    private TableColumn<Funcionario, Integer> FuncionarioAgeColumm;

    @FXML
    private TableColumn<Funcionario, String> FuncionarioCargoColumm;

    @FXML
    private TableColumn<Funcionario, String> FuncionarioFirstNameColumm;

    @FXML
    private TableColumn<Funcionario, Integer> FuncionarioIdColumm;

    @FXML
    private TableColumn<Cliente, String> clientCheckInCollumn;

    @FXML
    private TableColumn<Cliente, String> clientCheckOutCollumn;

    @FXML
    private TableColumn<Cliente, String> clientNameCollumn;

    @FXML
    private TableColumn<Cliente, Integer> clientNumberCollumn;

    @FXML
    private TableColumn<Cliente, String> clientNumberPhoneCollumn;


    @FXML
    private TextField FuncionarioSearch;

    @FXML
    private TableColumn<Funcionario, String> FuncionarioSecondNameColumm;

    @FXML
    private AnchorPane FuncionariosForm;

    @FXML
    private Button QuartosDisponiveisBtn;

    @FXML
    private AnchorPane QuartosDisponiveisForm;

    @FXML
    private AnchorPane aboutForm;

    @FXML
    private Button addBtn;

    @FXML
    private Button addFunBtn;

    @FXML
    private Button btnSair;

    @FXML
    private Button chekInBtn;

    @FXML
    private Button clearBtn;

    @FXML
    private TableColumn<Cliente, String> clientCheckIn;

    @FXML
    private TableColumn<Cliente,String> clientCheckOut;

    @FXML
    private TableColumn<Cliente, String> clientFirstName;


    @FXML
    private TableColumn<Cliente, String> clientNumbersPhone;



    @FXML
    private Button delFunbtn;

    @FXML
    private Button deleteBn;

    @FXML
    private Button editFunBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private TextField funcionarioAge;

    @FXML
    private Button funcionarioBtn;

    @FXML
    private TextField ClientCheckOut;
    @FXML
    private TextField ClientCheckIn;

    @FXML
    private TextField ClienteNome;

    @FXML
    private TextField ClienteTelefone;

    @FXML
    private ComboBox<String> funcionarioCargo;

    @FXML
    private TextField funcionariosFirstName;

    @FXML
    private TextField funcionariosId;

    @FXML
    private TextField funcionariosSecondName;

    @FXML
    private Button minimizeBtn;

    @FXML
    private TextField roomNumber;

    @FXML
    private TableColumn<QuartosDisponiveis, Integer> roomNumberCollum;

    @FXML
    private TextField roomPrice;

    @FXML
    private TextField clientID;

    @FXML
    private TableColumn<QuartosDisponiveis, Double> roomPriceCollum;

    @FXML
    private TextField roomSearch;

    @FXML
    private ComboBox<String> roomStatus;

    @FXML
    private TableColumn<QuartosDisponiveis, String> roomStatusCollum;

    @FXML
    private ComboBox<String> roomType;

    @FXML
    private TableColumn<QuartosDisponiveis, String> roomTypeCollum;

    @FXML
    private TextField searchClientes;

    @FXML
    private TableView<Funcionario> tableViewFuncionarios;

    @FXML
    private TableView<QuartosDisponiveis> tableViewQuartos;

    @FXML
    private Button updateBtn;

    @FXML
    private Button addClientBtn;

    @FXML
    private Button editClientBtn;

    @FXML
    private Button clearClientBtn;

    @FXML
    private Button deleteClientBtn;


//----------------------------------------------------------------------------------------------------------------------
    //Array que armazena os diferentes tipos de quartos disponíveis
    public String type[] = {"Um Quarto", "Dois Quartos", "Três Quartos", "Quatro Quartos"};
    // Preenche o ComboBox 'roomType' com tipos de quartos
    public void QuartosDisponiveisRoomType() {
        List<String> listData = new ArrayList<>();

        //Adiciona os tipos de quartos à lista
        for (String data : type) {
            listData.add(data);
        }
        // Converte a lista num ObservableList e associa ao ComboBox 'roomType'
        ObservableList lista = FXCollections.observableArrayList(listData);
        roomType.setItems(lista);
    }

    public String status[] = {"Disponível", "Não Disponível", "Ocupado"};

    public void QuartosDisponiveisRoomStatus() {
        List<String> listData = new ArrayList<>();

        for (String data : status) {
            listData.add(data);
        }

        ObservableList lista = FXCollections.observableArrayList(listData);
        roomStatus.setItems(lista);

    }
    public String cargo[] = {"Superior","gerente de departamento", "supervisor da equipa","auxiliar administrativo"};

    public void FuncionariosCargos(){
        List<String> listFunData = new ArrayList<>();

        for (String data : cargo) {
            listFunData.add(data);
        }

        ObservableList lista = FXCollections.observableArrayList(listFunData);
        funcionarioCargo.setItems(lista);
    }

//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
    // Configura as colunas da tabela
    public void associarQuartos() {
        roomNumberCollum.setCellValueFactory(new PropertyValueFactory<QuartosDisponiveis, Integer>("numQuarto"));
        roomTypeCollum.setCellValueFactory(new PropertyValueFactory<QuartosDisponiveis, String>("tipoDeQuarto"));
        roomStatusCollum.setCellValueFactory(new PropertyValueFactory<QuartosDisponiveis, String>("status"));
        roomPriceCollum.setCellValueFactory(new PropertyValueFactory<QuartosDisponiveis, Double>("preco"));

        // Associa a lista de quartos à tabela
        tableViewQuartos.setItems(Settings.getListaQuartos());
    }

    public void associarFuncionarios(){
        FuncionarioIdColumm.setCellValueFactory(new PropertyValueFactory<Funcionario, Integer>("id"));
        FuncionarioFirstNameColumm.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("primeiroNome"));
        FuncionarioSecondNameColumm.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("segundoNome"));
        FuncionarioAgeColumm.setCellValueFactory(new PropertyValueFactory<Funcionario, Integer>("idade"));
        FuncionarioCargoColumm.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("cargo"));
        tableViewFuncionarios.setItems(Settings.getListaFuncionarios());

    }

    public void associarClientes(){
        clientNumberCollumn.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("idClientes"));
        clientNameCollumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        clientNumberPhoneCollumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefone"));
        clientCheckInCollumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("CheckIn"));
        clientCheckOutCollumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("CheckOut"));
        ClientTableView.setItems(Settings.getListaClientes());
    }

//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
    // Mostra os detalhes do quarto,funcionario e clientes quando é selecionado
    public void verQuartos() {
        QuartosDisponiveis RoomDataVer = (QuartosDisponiveis) tableViewQuartos.getSelectionModel().getSelectedItem();
        roomNumber.setText(String.valueOf(RoomDataVer.getNumQuarto()));
        roomType.setValue(RoomDataVer.getTipoDeQuarto());
        roomStatus.setValue(RoomDataVer.getStatus());
        roomPrice.setText(String.valueOf(RoomDataVer.getPreco()));
    }

    public void verFuncionario(){
        Funcionario funDataVer = (Funcionario) tableViewFuncionarios.getSelectionModel().getSelectedItem();
        funcionariosId.setText(String.valueOf(funDataVer.getId()));
        funcionariosFirstName.setText(String.valueOf(funDataVer.getPrimeiroNome()));
        funcionariosSecondName.setText(String.valueOf(funDataVer.getSegundoNome()));
        funcionarioAge.setText((String.valueOf(funDataVer.getIdade())));
        funcionarioCargo.setValue(funDataVer.getCargo());
    }

    public void verClientes(){
        Cliente clienteDataVer = (Cliente) ClientTableView.getSelectionModel().getSelectedItem();
        clientID.setText(String.valueOf(clienteDataVer.getIdClientes()));
        ClienteNome.setText(String.valueOf(clienteDataVer.getNome()));
        ClienteTelefone.setText(String.valueOf(clienteDataVer.getTelefone()));
        ClientCheckIn.setText(String.valueOf(clienteDataVer.getCheckIn()));
        ClientCheckOut.setText(String.valueOf(clienteDataVer.getCheckOut()));
    }
//----------------------------------------------------------------------------------------------------------------------

    // Método executado ao clicar no botão de adicionar quartos,funcionarios e clientes
    public void buttonAddOnAction(ActionEvent actionEvent) {
        // Verifica se algum dos campos obrigatórios está vazio
        if (roomNumber.getText().isEmpty() || roomType.getSelectionModel().getSelectedItem() == null || roomStatus.getSelectionModel().getSelectedItem() == null || roomPrice.getText().isEmpty()) {
            // Mostra uma mensagem de erro se algum campo estiver vazio
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("Por favor,coloque todos os dados nos respetivos campos");
            alert.setContentText("Clique no botao para tentar novamente!");
            alert.showAndWait();
        } else {
            // Obtém o número do quarto que vai ser inserido
            int quartoNovo = Integer.parseInt(roomNumber.getText());

            // Verifica se um quarto com o mesmo número já existe
            if (Settings.listaQuartos.stream().anyMatch(q -> q.getNumQuarto() == quartoNovo)) {
                // mostra  uma mensagem de erro se um quarto com o mesmo número já existe
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText("Esse Botao ja foi inserido, por favor coloque outro");
                alert.setContentText("Clique no botao para continuar");
                alert.showAndWait();
            } else {
                // Obtém os dados do quarto a ser adicionado
                int newRoom = Integer.parseInt(roomNumber.getText());
                String newType = String.valueOf(roomType.getSelectionModel().getSelectedItem());
                String newStatus = String.valueOf(roomStatus.getSelectionModel().getSelectedItem());
                double newPrice = Double.parseDouble(roomPrice.getText());

                // Confirmação do utilizador antes de adicionar o quarto
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("CONFIRMAR");
                alert.setHeaderText("Deseja mesmo acionar este pedido?");
                alert.setHeaderText(("Quartos: " + newRoom + "\nTipo de quarto: " + newType + "\nStatus: " + newStatus + "\nPreço: " + newPrice));
                alert.setContentText("Deseja mesmo adicionar?");

                // Adiciona botões de "Sim" e "Não" à janela de confirmação
                ButtonType buttonSim = new ButtonType("Sim");
                ButtonType buttonNao = new ButtonType("Não");
                alert.getButtonTypes().setAll(buttonSim, buttonNao);

                // Obtém a escolha do utilizador
                Optional<ButtonType> choose = alert.showAndWait();
                // Executa a ação correspondente à escolha do utilizador
                if (choose.get() == buttonSim) {
                    Settings.listaQuartos.add(new QuartosDisponiveis(newRoom, newType, newStatus, newPrice));
                    Alert alertAddQuartos = new Alert(Alert.AlertType.INFORMATION);

                    // Mostra uma mensagem de sucesso
                    alertAddQuartos.setTitle("INFORMARÇAO!!!");
                    alertAddQuartos.setHeaderText("VERIFICANDO DADOS....");
                    alertAddQuartos.setHeaderText("PRODUTO INSERIDO COM SUCESSO!!");
                    alertAddQuartos.showAndWait();
                } else {
                    // Mostra  uma mensagem de que a operaçao foi cancelada
                    Alert alertCancelAddQuartos = new Alert(Alert.AlertType.INFORMATION);
                    alertCancelAddQuartos.setTitle("INFORMAÇAO!!!");
                    alertCancelAddQuartos.setHeaderText("CANCELADO COM SUCESSO!!!");
                    alertCancelAddQuartos.setContentText("Clica no botao para continuar ->");
                    alertCancelAddQuartos.showAndWait();
                }
            }

        }
    }
    public void buttonaddFunOnAction(ActionEvent actionEvent) {
        if (funcionariosId.getText().isEmpty() || funcionariosFirstName.getText().isEmpty() || funcionariosSecondName.getText().isEmpty()|| funcionarioAge.getText().isEmpty() ||funcionarioCargo.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("Por favor,coloque todos os dados nos respetivos campos");
            alert.setContentText("Clique no botao para tentar novamente!");
            alert.showAndWait();
        } else {
            int newFun = Integer.parseInt(funcionariosId.getText());
            if (Settings.listaFuncionarios.stream().anyMatch(f -> f.getId() == newFun)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText("Esse id ja foi inserido, por favor coloque outro");
                alert.setContentText("Clique no botao para continuar");
                alert.showAndWait();
            } else {
                int newIDFuncionario = Integer.parseInt(funcionariosId.getText());
                String newFirsName = String.valueOf(funcionariosFirstName.getText());
                String newSecondName = String.valueOf(funcionariosSecondName.getText());
                int newAge  = Integer.parseInt(funcionarioAge.getText());
                String newCargo = String.valueOf(funcionarioCargo.getSelectionModel().getSelectedItem());

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("CONFIRMAR");
                alert.setHeaderText("Deseja mesmo acionar este funcionario?");

                alert.setHeaderText(("ID: " + newIDFuncionario + "\nTPrimeiro nome: " + newFirsName + "\nSegundo nome: " + newSecondName + "\nidade: " + newAge +"\ncargo: "+ newCargo));
                alert.setContentText("Deseja mesmo adicionar?");
                ButtonType buttonSim = new ButtonType("Sim");
                ButtonType buttonNao = new ButtonType("Não");
                alert.getButtonTypes().setAll(buttonSim, buttonNao);
                Optional<ButtonType> choose = alert.showAndWait();
                if (choose.get() == buttonSim) {
                    Settings.listaFuncionarios.add(new Funcionario(newIDFuncionario, newFirsName, newSecondName,newAge, newCargo));
                    Alert alertAddFuncionarios = new Alert(Alert.AlertType.INFORMATION);
                    alertAddFuncionarios.setTitle("INFORMARÇAO!!!");
                    alertAddFuncionarios.setHeaderText("VERIFICANDO DADOS....");
                    alertAddFuncionarios.setContentText("Funcionario INSERIDO COM SUCESSO!!");
                    alertAddFuncionarios.showAndWait();
                } else {
                    Alert alertCancelAddFuncionarios = new Alert(Alert.AlertType.INFORMATION);
                    alertCancelAddFuncionarios.setTitle("INFORMAÇAO!!!");
                    alertCancelAddFuncionarios.setHeaderText("CANCELADO COM SUCESSO!!!");
                    alertCancelAddFuncionarios.setContentText("Clica no botao para continuar ->");
                    alertCancelAddFuncionarios.showAndWait();
                }
            }

        }
    }
    public void buttonaddClientOnAction(ActionEvent actionEvent) {
        if (clientID.getText().isEmpty() || ClienteNome.getText().isEmpty() || ClienteTelefone.getText().isEmpty()|| ClientCheckIn.getText().isEmpty() || ClientCheckOut.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("Por favor,coloque todos os dados nos respetivos campos");
            alert.setContentText("Clique no botao para tentar novamente!");
            alert.showAndWait();
        } else {
            int newCliente = Integer.parseInt(clientID.getText());
            if (Settings.listaClientes.stream().anyMatch(c -> c.getIdClientes() == newCliente)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText("Esse id ja foi inserido, por favor coloque outro");
                alert.setContentText("Clique no botao para continuar");
                alert.showAndWait();
            } else {
                int newIDCliente = Integer.parseInt(clientID.getText());
                String newName = String.valueOf(ClienteNome.getText());
                String newPhoneNumber = String.valueOf(ClienteTelefone.getText());
                String newDateCheckIn = String.valueOf(ClientCheckIn.getText());
                String newDateCheckOut = String.valueOf(ClientCheckOut.getText());

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("CONFIRMAR");
                alert.setHeaderText("Deseja mesmo acionar este funcionario?");

                alert.setHeaderText(("ID Cliente: " + newIDCliente + "\nNome: " + newName + "\nTelefone: " + newPhoneNumber + "\nCheck-In: " + newDateCheckIn +"\nCheck-Out: "+ newDateCheckOut));
                alert.setContentText("Deseja mesmo adicionar?");
                ButtonType buttonSim = new ButtonType("Sim");
                ButtonType buttonNao = new ButtonType("Não");
                alert.getButtonTypes().setAll(buttonSim, buttonNao);
                Optional<ButtonType> choose = alert.showAndWait();
                if (choose.get() == buttonSim) {
                    Settings.listaClientes.add(new Cliente(newIDCliente,newName,newPhoneNumber,newDateCheckIn,newDateCheckOut));
                    Alert alertAddCliente = new Alert(Alert.AlertType.INFORMATION);
                    alertAddCliente.setTitle("INFORMARÇAO!!!");
                    alertAddCliente.setHeaderText("VERIFICANDO DADOS....");
                    alertAddCliente.setContentText("Funcionario INSERIDO COM SUCESSO!!");
                    alertAddCliente.showAndWait();
                } else {
                    Alert alertCancelAddCliente = new Alert(Alert.AlertType.INFORMATION);
                    alertCancelAddCliente.setTitle("INFORMAÇAO!!!");
                    alertCancelAddCliente.setContentText("DEIXA DE SER BURRO MADJE-_-");
                    alertCancelAddCliente.setContentText("CANCELADO COM SUCESSO!!!");
                    alertCancelAddCliente.showAndWait();
                }
            }

        }
    }

//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
    // Método executado ao clicar no botão 'Sair'
    public void ButtonSairOnAction(ActionEvent actionEvent) {
        // Obtém a referência à janela atual e a fecha
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
    }

//----------------------------------------------------------------------------------------------------------------------
    // Método executado ao clicar no botão 'Limpar Quartos,Funcionarios Clientes'
    public void buttonClearClientOnAction(ActionEvent actionEvent) {
        Settings.listaClientes.clear();
    }

    public void buttonClearFunOnAction(ActionEvent actionEvent) {
        Settings.listaFuncionarios.clear();
    }

    public void buttonClearOnAction(ActionEvent actionEvent) {
        Settings.listaQuartos.clear();
    }


//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------

    // Método executado ao clicar no botão 'Editar' dos Qquartos,Funcionarios e Clientes
    public void buttonEditOnAction(ActionEvent actionEvent) {

        // Verifica se algum dos campos obrigatórios está vazio
        if (roomNumber.getText().isEmpty() || roomType.getSelectionModel().getSelectedItem() == null || roomStatus.getSelectionModel().getSelectedItem() == null || roomPrice.getText().isEmpty()) {

            // Mostra uma mensagem de erro se algum campo estiver vazio
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("Por favor,coloque todos os dados nos respetivos campos");
            alert.setContentText("Clique no botao para tentar novamente!");
            alert.showAndWait();
        } else {
            // Obtém o número do quarto a ser editado
            int newRoom = Integer.parseInt(roomNumber.getText());

            // Procura o quarto na lista para edição
            for (QuartosDisponiveis q : Settings.getListaQuartos()) {
                if (q.getNumQuarto() == newRoom) {
                    Settings.EditarQuarto = q;
                    break;
                }
            }
            // Verifica se o quarto foi encontrado para edição
            if (Settings.EditarQuarto != null){
                Settings.EditarQuarto.setTipoDeQuarto((String) roomType.getSelectionModel().getSelectedItem());
                Settings.EditarQuarto.setStatus((String) roomStatus.getSelectionModel().getSelectedItem());
                Settings.EditarQuarto.setPreco(Double.parseDouble(roomPrice.getText()));

                // Confirmação do utilizador antes de realizar a edição
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Editar Quarto");
                alert.setHeaderText("deseja realmente editar?");
                alert.setContentText("Clique no botao para continuar");
                ButtonType ButtonSim = new ButtonType("Sim");
                ButtonType ButtonNao = new ButtonType("Não");
                alert.getButtonTypes().setAll(ButtonSim,ButtonNao);

                // Janela de informação sobre o resultado da edição
                Alert alertEditRoom = new Alert(Alert.AlertType.INFORMATION);
                alertEditRoom.setTitle("CONFIRMAÇÃO!!!");
                alertEditRoom.setHeaderText(null);

                // Obtém a escolha do utilizador
                Optional<ButtonType> choose = alert.showAndWait();

                // Executa a ação correspondente à escolha do utilizador
                if(choose.get() == ButtonSim){
                    // Atualiza o quarto na lista de quartos
                    for(QuartosDisponiveis quarto: Settings.getListaQuartos()) {
                        if (quarto.getNumQuarto() == Settings.getEditarQuarto().getNumQuarto()) {
                            int index = Settings.getListaQuartos().indexOf(quarto);
                            Settings.getListaQuartos().set(index, Settings.getEditarQuarto());
                            break;
                        }
                    }
                    // Atualiza a tabela de quartos
                    Settings.setEditarQuarto(Settings.EditarQuarto);
                    tableViewQuartos.refresh();

                    // Mostra uma mensagem de sucesso
                    alertEditRoom.setHeaderText("Ediçao realizada com sucesso");
                    alertEditRoom.setContentText("| Clique no botão para continuar ->");
                    alertEditRoom.showAndWait();

                    // Limpa a referência ao quarto em edição
                    Settings.setEditarQuarto(null);
                } else{

                    // Mostra  uma mensagem de que a operaçao foi cancelada
                    Alert alertEditCancel = new Alert(Alert.AlertType.INFORMATION);
                    alertEditCancel.setTitle("INFORMAÇÃO!!!");
                    alertEditCancel.setHeaderText("Operação cancelada com sucesso");
                    alertEditCancel.showAndWait();
                }
            }else {

                // Mostra uma mensagem de erro se o número do quarto não foi encontrado
                Alert alertIDNotFound = new Alert(Alert.AlertType.ERROR);
                alertIDNotFound.setContentText("ERRO");
                alertIDNotFound.setHeaderText("Numero do quarto nao encontrado");
                alertIDNotFound.setContentText("Clique no botao para continuar");
                alertIDNotFound.showAndWait();
            }


        }

    }
    public void buttonEditFunOnAction(ActionEvent actionEvent) {
        if (funcionariosId.getText().isEmpty() || funcionariosFirstName.getText().isEmpty() || funcionariosSecondName.getText().isEmpty()|| funcionarioAge.getText().isEmpty() ||funcionarioCargo.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("Por favor,coloque todos os dados nos respetivos campos");
            alert.setContentText("Clique no botao para tentar novamente!");
            alert.showAndWait();
        } else {
            //Settings.EditarQuarto = null;
            int newFuncionario = Integer.parseInt(funcionariosId.getText());
            for (Funcionario f : Settings.getListaFuncionarios()) {
                if (f.getId() == newFuncionario) {
                    Settings.EditarFuncionario = f;
                    break;
                }
            }
            if (Settings.EditarFuncionario != null){
                Settings.EditarFuncionario.setPrimeiroNome(funcionariosFirstName.getText());
                Settings.EditarFuncionario.setSegundoNome(funcionariosSecondName.getText());
                Settings.EditarFuncionario.setIdade(Integer.parseInt(funcionarioAge.getText()));
                Settings.EditarFuncionario.setCargo((String) funcionarioCargo.getSelectionModel().getSelectedItem());

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Editar Funcionario");
                alert.setHeaderText("deseja realmente editar?");
                alert.setContentText("Clique no botao para continuar");
                ButtonType ButtonSim = new ButtonType("Sim");
                ButtonType ButtonNao = new ButtonType("Não");
                alert.getButtonTypes().setAll(ButtonSim,ButtonNao);
                Alert alertEditFuncionario = new Alert(Alert.AlertType.INFORMATION);
                alertEditFuncionario.setTitle("CONFIRMAÇÃO!!!");
                alertEditFuncionario.setHeaderText(null);
                Optional<ButtonType> choose = alert.showAndWait();
                if(choose.get() == ButtonSim){
                    for(Funcionario fun: Settings.getListaFuncionarios()) {
                        if (fun.getId() == Settings.getEditarFuncionario().getId()){
                            int index = Settings.getListaFuncionarios().indexOf(fun);
                            Settings.getListaFuncionarios().set(index, Settings.getEditarFuncionario());
                            break;
                        }
                    }
                    Settings.setEditarFuncionario(Settings.EditarFuncionario);
                    tableViewFuncionarios.refresh();
                    alertEditFuncionario.setHeaderText("Ediçao realizada com sucesso");
                    alertEditFuncionario.setContentText("| Clique no botão para continuar ->");
                    alertEditFuncionario.showAndWait();
                    Settings.setEditarFuncionario(null);
                } else{
                    Alert alertEditFunCancel = new Alert(Alert.AlertType.INFORMATION);
                    alertEditFunCancel.setTitle("INFORMAÇÃO!!!");
                    alertEditFunCancel.setHeaderText("Operação cancelada com sucesso");
                    alertEditFunCancel.showAndWait();
                }
            }else {
                Alert alertIDFunNotFound = new Alert(Alert.AlertType.ERROR);
                alertIDFunNotFound.setContentText("ERRO");
                alertIDFunNotFound.setHeaderText("ID do funcionario  nao encontrado");
                alertIDFunNotFound.setContentText("Clique no botao para continuar");
                alertIDFunNotFound.showAndWait();
            }

        }
    }
    public void buttonEditClientOnAction(ActionEvent actionEvent) {
        if (clientID.getText().isEmpty() || ClienteNome.getText().isEmpty() || ClienteTelefone.getText().isEmpty()|| ClientCheckIn.getText().isEmpty() || ClientCheckOut.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("Por favor,coloque todos os dados nos respetivos campos");
            alert.setContentText("Clique no botao para tentar novamente!");
            alert.showAndWait();
        } else {
            //Settings.EditarQuarto = null;
            int newClient = Integer.parseInt(clientID.getText());
            for (Cliente c : Settings.getListaClientes()) {
                if (c.getIdClientes() == newClient) {
                    Settings.EditarCliente = c;
                    break;
                }
            }
            if (Settings.EditarCliente != null){
                Settings.EditarCliente.setNome(ClienteNome.getText());
                Settings.EditarCliente.setTelefone(ClienteTelefone.getText());
                Settings.EditarCliente.setCheckIn(ClientCheckIn.getText());
                Settings.EditarCliente.setCheckOut(ClientCheckOut.getText());

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Editar Quarto");
                alert.setHeaderText("deseja realmente editar?");
                alert.setContentText("Clique no botao para continuar");
                ButtonType ButtonSim = new ButtonType("Sim");
                ButtonType ButtonNao = new ButtonType("Não");
                alert.getButtonTypes().setAll(ButtonSim,ButtonNao);
                Alert alertEditRoom = new Alert(Alert.AlertType.INFORMATION);
                alertEditRoom.setTitle("CONFIRMAÇÃO!!!");
                alertEditRoom.setHeaderText(null);
                Optional<ButtonType> choose = alert.showAndWait();
                if(choose.get() == ButtonSim){
                    for(Cliente cliente: Settings.getListaClientes()) {
                        if (cliente.getIdClientes() == Settings.getEditarCliente().getIdClientes()) {
                            int index = Settings.getListaClientes().indexOf(cliente);
                            Settings.getListaClientes().set(index, Settings.getEditarCliente());
                            break;
                        }
                    }
                    Settings.setEditarCliente(Settings.EditarCliente);
                    tableViewQuartos.refresh();
                    alertEditRoom.setHeaderText("Ediçao realizada com sucesso");
                    alertEditRoom.setContentText("| Clique no botão para continuar ->");
                    alertEditRoom.showAndWait();
                    Settings.setEditarQuarto(null);
                } else{
                    Alert alertEditCancel = new Alert(Alert.AlertType.INFORMATION);
                    alertEditCancel.setTitle("INFORMAÇÃO!!!");
                    alertEditCancel.setHeaderText("Operação cancelada com sucesso");
                    alertEditCancel.showAndWait();
                }
            }else {
                Alert alertIDNotFound = new Alert(Alert.AlertType.ERROR);
                alertIDNotFound.setContentText("ERRO");
                alertIDNotFound.setHeaderText("Cliente nao encontrado");
                alertIDNotFound.setContentText("Clique no botao para continuar");
                alertIDNotFound.showAndWait();
            }


        }
    }


//----------------------------------------------------------------------------------------------------------------------
// Método executado ao clicar no botão 'Eliminar' dos Qquartos,Funcionarios e Clientes
    public void btnDeleteOnAction(ActionEvent actionEvent) {
        // Verifica se algum dos campos obrigatórios está vazio
        if (roomNumber.getText().isEmpty() || roomType.getSelectionModel().getSelectedItem() == null || roomStatus.getSelectionModel().getSelectedItem() == null || roomPrice.getText().isEmpty()) {

            // Mostra uma mensagem de erro se algum campo estiver vazio
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("Nao selecionou nenhum item,por favor selecione um item!!!");
            alert.setContentText("Clique no botão para continuar");
            alert.showAndWait();
        } else {
            // Confirmação do utilizador antes de eliminar o quarto
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("ELIMINAR");
            alert.setHeaderText("Quartos: " + roomNumber.getText() + "\nTipo de quarto: " + roomType.getSelectionModel().getSelectedItem() + "\nStatus: " + roomStatus.getSelectionModel().getSelectedItem() + "\nPreço: " + roomPrice.getText());
            alert.setContentText("Deseja realemte elimiar?");
            ButtonType ButtonSim = new ButtonType("Sim");
            ButtonType ButtonNao = new ButtonType("Não");
            alert.getButtonTypes().setAll(ButtonSim, ButtonNao);

            // Obtém a escolha do utilizador
            Optional<ButtonType> choose = alert.showAndWait();

            // Executa a ação correspondente à escolha do utilizador
            if (choose.get() == ButtonSim) {

                // Obtém o número do quarto a ser eliminado
                int newRoom = Integer.parseInt(roomNumber.getText());

                // Procura o quarto na lista e remove-o
                for (QuartosDisponiveis q : Settings.listaQuartos) {
                    if (q.getNumQuarto() == newRoom) {

                        // Mostra uma mensagem de sucesso
                        Settings.getListaQuartos().remove(q);
                        Alert alertRmQuartos = new Alert(Alert.AlertType.INFORMATION);
                        alertRmQuartos.setTitle("INFORMACÇAO!!!");
                        alertRmQuartos.setHeaderText("O seu quarto foi eliminado");
                        alertRmQuartos.setContentText("| Clique no botão para continuar |");
                        alertRmQuartos.showAndWait();
                        break;
                    }
                }
            } else {
                // Mostra uma mensagem de sucesso
                Alert alertRmCancel = new Alert(Alert.AlertType.INFORMATION);
                alertRmCancel.setTitle("INFORMAÇAO!!!");
                alertRmCancel.setHeaderText("Pedido cancelado com sucesso!!!");
                alertRmCancel.setContentText("Clique no botao para continuar.");
                alertRmCancel.showAndWait();
            }

        }
    }
    public void buttonDeleteFunOnAction(ActionEvent actionEvent) {
        if (funcionariosId.getText().isEmpty() || funcionariosFirstName.getText().isEmpty() || funcionariosSecondName.getText().isEmpty()|| funcionarioAge.getText().isEmpty() ||funcionarioCargo.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("Nao selecionou nenhum item,por favor selecione um item!!!");
            alert.setContentText("Clique no botão para continuar");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("ELIMINAR");
            alert.setHeaderText("ID: " + funcionariosId.getText() + "\nPrimeiro nome: " +  funcionariosFirstName.getText() + "\nSegundo nome: " + funcionariosSecondName.getText() + "\nIdade: " + funcionarioAge.getText() + "\ncargo: " + funcionarioCargo.getSelectionModel().getSelectedItem());
            alert.setContentText("Deseja realemte eliminar?");
            ButtonType ButtonSim = new ButtonType("Sim");
            ButtonType ButtonNao = new ButtonType("Não");
            alert.getButtonTypes().setAll(ButtonSim, ButtonNao);
            Optional<ButtonType> choose = alert.showAndWait();

            if (choose.get() == ButtonSim) {
                int newF = Integer.parseInt(funcionariosId.getText());
                for (Funcionario f : Settings.listaFuncionarios) {
                    if (f.getId() == newF) {
                        Settings.getListaFuncionarios().remove(f);
                        Alert alertRmFunQuartos = new Alert(Alert.AlertType.INFORMATION);
                        alertRmFunQuartos.setTitle("INFORMACÇAO!!!");
                        alertRmFunQuartos.setHeaderText("O seu funcionario foi eliminado");
                        alertRmFunQuartos.setContentText("| Clique no botão para continuar |");
                        alertRmFunQuartos.showAndWait();
                        break;
                    }
                }
            } else {
                Alert alertRmFunCancel = new Alert(Alert.AlertType.INFORMATION);
                alertRmFunCancel.setTitle("INFORMAÇAO!!!");
                alertRmFunCancel.setHeaderText("Pedido cancelado com sucesso!!!");
                alertRmFunCancel.setContentText("Clique no botao para continuar.");
                alertRmFunCancel.showAndWait();
            }

        }
    }

    public void buttonDeleteClientOnAction(ActionEvent actionEvent) {
        if (clientID.getText().isEmpty() || ClienteNome.getText().isEmpty() || ClienteTelefone.getText().isEmpty()|| ClientCheckIn.getText().isEmpty() || ClientCheckOut.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("Nao selecionou nenhum item,por favor selecione um item!!!");
            alert.setContentText("Clique no botão para continuar");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("ELIMINAR");
            alert.setHeaderText("ID cliente: " + clientID.getText() + "\nTelefone: " + ClienteNome.getText() + "\n:Nome " + ClienteNome.getText() + "\nCheck-IN: " + ClientCheckIn.getText() + "\nCheck-OUT:" + ClientCheckOut.getText());
            alert.setContentText("Deseja realemte elimiar?");
            ButtonType ButtonSim = new ButtonType("Sim");
            ButtonType ButtonNao = new ButtonType("Não");
            alert.getButtonTypes().setAll(ButtonSim, ButtonNao);
            Optional<ButtonType> choose = alert.showAndWait();

            if (choose.get() == ButtonSim) {
                int newClient = Integer.parseInt(clientID.getText());
                for (Cliente cliente : Settings.listaClientes) {
                    if (cliente.getIdClientes() == newClient) {
                        Settings.getListaClientes().remove(cliente);
                        Alert alertRmQuartos = new Alert(Alert.AlertType.INFORMATION);
                        alertRmQuartos.setTitle("INFORMACÇAO!!!");
                        alertRmQuartos.setHeaderText("O seu quarto foi eliminado");
                        alertRmQuartos.setContentText("| Clique no botão para continuar |");
                        alertRmQuartos.showAndWait();
                        break;
                    }
                }
            } else {
                Alert alertRmCancel = new Alert(Alert.AlertType.INFORMATION);
                alertRmCancel.setTitle("INFORMAÇAO!!!");
                alertRmCancel.setHeaderText("Pedido cancelado com sucesso!!!");
                alertRmCancel.setContentText("Clique no botao para continuar.");
                alertRmCancel.showAndWait();
            }

        }
    }


//----------------------------------------------------------------------------------------------------------------------
// Método para procurar Quartos, Funcionarios, clientes com base nos dados fornecidos
    public void procurarClientes(KeyEvent keyEvent){

        // Cria um objeto FilteredList para filtrar a lista
        FilteredList<Cliente> filter = new FilteredList<>(Settings.listaClientes, e -> true);

        // Adiciona um listener ao texto da barra de pesquisa
        searchClientes.textProperty().addListener((Observable, oldValue, newValue) ->{

            filter.setPredicate(predicateClient ->{
                // Verifica se o novo valor da pesquisa é nulo ou vazio
                if(newValue == null && newValue.isEmpty()){
                    return true;
                }
                // Converte o valor da pesquisa para minúsculas
                String ProcurarC = newValue.toLowerCase();

                // Verifica se o ID do cliente contém o valor da pesquisa
                if (String.valueOf(predicateClient.getIdClientes()).contains(ProcurarC)){
                    return true;
                // Verifica se o nome do cliente contém o valor da pesquisa
                }else if (predicateClient.getNome().toLowerCase().contains(ProcurarC)) {
                    return true;
                // Verifica se o telefone do cliente contém o valor da pesquisa
                } else if (predicateClient.getTelefone().toLowerCase().contains(ProcurarC)) {
                    return true;
                }
                // Retorna falso se nenhum critério for atendido
                return false;
            });
        });

        // Cria uma lista ordenada com base no filtro
        SortedList<Cliente> sortList =  new SortedList<>(filter);

        // Atualiza a tabela de clientes com a lista filtrada e ordenada
        sortList.comparatorProperty().bind(ClientTableView.comparatorProperty());
        ClientTableView.setItems(sortList);
    }
    public void procurarQuarto(KeyEvent keyEvent) {
        FilteredList<QuartosDisponiveis> filter = new FilteredList<>(Settings.listaQuartos, e -> true);

        roomSearch.textProperty().addListener((Observable, oldValue, newValue) ->{

            filter.setPredicate(predicateroom ->{
                if(newValue == null && newValue.isEmpty()){
                    return true;
                }
                String ProcurarQ = newValue.toLowerCase();
                if (String.valueOf(predicateroom.getNumQuarto()).contains(ProcurarQ)){
                    return true;
                }else if (predicateroom.getTipoDeQuarto().toLowerCase().contains(ProcurarQ)) {
                    return true;
                } else if (predicateroom.getStatus().toLowerCase().contains(ProcurarQ)) {
                    return true;
                } else if (String.valueOf(predicateroom.getPreco()).contains(ProcurarQ)) {
                    return true;

                }
                return false;
            });
        });
        SortedList<QuartosDisponiveis> sortList =  new SortedList<>(filter);
        sortList.comparatorProperty().bind(tableViewQuartos.comparatorProperty());
        tableViewQuartos.setItems(sortList);
    }
    public void procurarFuncionario(KeyEvent keyEvent){
        FilteredList<Funcionario> filter = new FilteredList<>(Settings.listaFuncionarios, e -> true);

        FuncionarioSearch.textProperty().addListener((Observable, oldValue, newValue) ->{

            filter.setPredicate(predicateFuncionario ->{
                if(newValue == null && newValue.isEmpty()){
                    return true;
                }
                String ProcurarF = newValue.toLowerCase();
                if (String.valueOf(predicateFuncionario.getId()).contains(ProcurarF)){
                    return true;
                }else if (predicateFuncionario.getPrimeiroNome().toLowerCase().contains(ProcurarF)) {
                    return true;
                } else if (predicateFuncionario.getSegundoNome().toLowerCase().contains(ProcurarF)) {
                    return true;
                } else if (predicateFuncionario.getCargo().contains(ProcurarF)) {
                    return true;

                } else if (String.valueOf(predicateFuncionario.getIdade()).contains(ProcurarF)) {

                }
                return false;
            });
        });
        SortedList<Funcionario> sortList =  new SortedList<>(filter);
        sortList.comparatorProperty().bind(tableViewFuncionarios.comparatorProperty());
        tableViewFuncionarios.setItems(sortList);
    }

//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
    // Método executado ao clicar no botão 'Quartos Disponíveis, Funcionario, Cliente  e Acerca De'
    public void buttonQDForOnAction(ActionEvent actionEvent) {
    QuartosDisponiveisForm.setVisible(true);
    FuncionariosForm.setVisible(false);
    ClientForm.setVisible(false);
    aboutForm.setVisible(false);

}

    public void buttonClientFormOnAaction(ActionEvent actionEvent) {
        QuartosDisponiveisForm.setVisible(false);
        FuncionariosForm.setVisible(false);
        ClientForm.setVisible(true);
        aboutForm.setVisible(false);
    }

    public void buttonFunFormOnAction(ActionEvent actionEvent) {
        QuartosDisponiveisForm.setVisible(false);
        FuncionariosForm.setVisible(true);
        ClientForm.setVisible(false);
        aboutForm.setVisible(false);
    }

    public void buttonAcercaDeOnAction(ActionEvent actionEvent) {
        QuartosDisponiveisForm.setVisible(false);
        FuncionariosForm.setVisible(false);
        ClientForm.setVisible(false);
        aboutForm.setVisible(true);
    }


//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------

    // Métodosquando que  quando o rato entra no botão 'Clientes' define o estilo do botão quando o rato passa por cima
    // E em seguida quando o rato sai de cima do botao ele forta para a sua cor original
    public void btnRooomEntered(MouseEvent mouseEvent) {
        QuartosDisponiveisBtn.setStyle("-fx-background-color: #c0c2c1; -fx-text-fill: #000; -fx-border-radius: 4px; -fx-border-color: #c0c2c1;");
    }

    public void btnClientEntered(MouseEvent mouseEvent) {
        ClientBtn.setStyle("-fx-background-color: #c0c2c1; -fx-text-fill: #000; -fx-border-radius: 4px; -fx-border-color: #c0c2c1;");
    }

    public void btnClientExited(MouseEvent mouseEvent) {
        ClientBtn.setStyle("-fx-background-color: #263F73; -fx-border-color: #fff; -fx-border-radius: 10px ; -fx-background-radius: 10px;-fx-text-fill: #fff;");
    }

    public void btnFuncionariosEntered(MouseEvent mouseEvent) {
        funcionarioBtn.setStyle("-fx-background-color: #c0c2c1; -fx-text-fill: #000; -fx-border-radius: 4px; -fx-border-color: #c0c2c1;");
    }

    public void btnAcercaDeEntered(MouseEvent mouseEvent) {
        AcercaDeBtn.setStyle("-fx-background-color: #c0c2c1; -fx-text-fill: #000; -fx-border-radius: 4px; -fx-border-color: #c0c2c1;");
    }

    public void btnAcercaDeExited(MouseEvent mouseEvent) {
        AcercaDeBtn.setStyle("-fx-background-color: #263F73; -fx-border-color: #fff; -fx-border-radius: 10px ; -fx-background-radius: 10px;-fx-text-fill: #fff;");
    }

    public void btnFuncionariosExited(MouseEvent mouseEvent) {
        funcionarioBtn.setStyle("-fx-background-color: #263F73; -fx-border-color: #fff; -fx-border-radius: 10px ; -fx-background-radius: 10px;-fx-text-fill: #fff;");
    }

    public void btnRoomExited(MouseEvent mouseEvent) {
        QuartosDisponiveisBtn.setStyle("-fx-background-color: #263F73; -fx-border-color: #fff; -fx-border-radius: 10px ; -fx-background-radius: 10px;-fx-text-fill: #fff;");
    }

    public void btnAddEntered(MouseEvent mouseEvent) {
        addBtn.setStyle("-fx-background-color: #c0c2c1; -fx-text-fill: #000; -fx-border-radius: 4px; -fx-border-color: #c0c2c1;");
    }

    public void btnAddExited(MouseEvent mouseEvent) {
        addBtn.setStyle("-fx-background-color: #263F73; -fx-border-color: #fff; -fx-border-radius: 10px ; -fx-background-radius: 10px;-fx-text-fill: #fff;");
    }

    public void btnUpdateEntered(MouseEvent mouseEvent) {
        updateBtn.setStyle("-fx-background-color: #c0c2c1; -fx-text-fill: #000; -fx-border-radius: 4px; -fx-border-color: #c0c2c1;");
    }

    public void btnUpdateExit(MouseEvent mouseEvent) {
        updateBtn.setStyle("-fx-background-color: #263F73; -fx-border-color: #fff; -fx-border-radius: 10px ; -fx-background-radius: 10px;-fx-text-fill: #fff;");
    }

    public void btnClearExited(MouseEvent mouseEvent) {
        clearBtn.setStyle("-fx-background-color: #263F73; -fx-border-color: #fff; -fx-border-radius: 10px ; -fx-background-radius: 10px;-fx-text-fill: #fff;");
    }

    public void btnDeleteEntered(MouseEvent mouseEvent) {
        deleteBn.setStyle("-fx-background-color: #c0c2c1; -fx-text-fill: #000; -fx-border-radius: 4px; -fx-border-color: #c0c2c1;");
    }

    public void btnDeleteExited(MouseEvent mouseEvent) {
        deleteBn.setStyle("-fx-background-color: #263F73; -fx-border-color: #fff; -fx-border-radius: 10px ; -fx-background-radius: 10px;-fx-text-fill: #fff;");
    }

    public void btnClearEntered(MouseEvent mouseEvent) {
        clearBtn.setStyle("-fx-background-color: #c0c2c1; -fx-text-fill: #000; -fx-border-radius: 4px; -fx-border-color: #c0c2c1;");
    }

    public void btnAddFunEntered(MouseEvent mouseEvent) {
        addFunBtn.setStyle("-fx-background-color: #c0c2c1; -fx-text-fill: #000; -fx-border-radius: 4px; -fx-border-color: #c0c2c1;");
    }

    public void btnAddFunExited(MouseEvent mouseEvent) {
        addFunBtn.setStyle("-fx-background-color: #263F73; -fx-border-color: #fff; -fx-border-radius: 10px ; -fx-background-radius: 10px;-fx-text-fill: #fff;");
    }

    public void btnEditFunEntered(MouseEvent mouseEvent) {
        editFunBtn.setStyle("-fx-background-color: #c0c2c1; -fx-text-fill: #000; -fx-border-radius: 4px; -fx-border-color: #c0c2c1;");
    }

    public void btnEdtFunExited(MouseEvent mouseEvent) {
        editFunBtn.setStyle("-fx-background-color: #263F73; -fx-border-color: #fff; -fx-border-radius: 10px ; -fx-background-radius: 10px;-fx-text-fill: #fff;");
    }

    public void btnClearFunEntered(MouseEvent mouseEvent) {
        ClearFunBtn.setStyle("-fx-background-color: #c0c2c1; -fx-text-fill: #000; -fx-border-radius: 4px; -fx-border-color: #c0c2c1;");
    }

    public void btnClearFunExited(MouseEvent mouseEvent) {
        ClearFunBtn.setStyle("-fx-background-color: #263F73; -fx-border-color: #fff; -fx-border-radius: 10px ; -fx-background-radius: 10px;-fx-text-fill: #fff;");
    }

    public void btnDelFunExited(MouseEvent mouseEvent) {
        editFunBtn.setStyle("-fx-background-color: #263F73; -fx-border-color: #fff; -fx-border-radius: 10px ; -fx-background-radius: 10px;-fx-text-fill: #fff;");
    }

    public void btnDelFunEntered(MouseEvent mouseEvent) {
        editFunBtn.setStyle("-fx-background-color: #c0c2c1; -fx-text-fill: #000; -fx-border-radius: 4px; -fx-border-color: #c0c2c1;");
    }
    public void btnAddClientEntered(MouseEvent mouseEvent) {
        addClientBtn.setStyle("-fx-background-color: #c0c2c1; -fx-text-fill: #000; -fx-border-radius: 4px; -fx-border-color: #c0c2c1;");
    }

    public void btnAddClientExited(MouseEvent mouseEvent) {
        addClientBtn.setStyle("-fx-background-color: #263F73; -fx-border-color: #fff; -fx-border-radius: 10px ; -fx-background-radius: 10px;-fx-text-fill: #fff;");
    }

    public void btnEditClientEntered(MouseEvent mouseEvent) {
        editClientBtn.setStyle("-fx-background-color: #c0c2c1; -fx-text-fill: #000; -fx-border-radius: 4px; -fx-border-color: #c0c2c1;");
    }

    public void btnEditClientExited(MouseEvent mouseEvent) {
        editClientBtn.setStyle("-fx-background-color: #263F73; -fx-border-color: #fff; -fx-border-radius: 10px ; -fx-background-radius: 10px;-fx-text-fill: #fff;");
    }

    public void btnClearClientEntered(MouseEvent mouseEvent) {
        clearClientBtn.setStyle("-fx-background-color: #c0c2c1; -fx-text-fill: #000; -fx-border-radius: 4px; -fx-border-color: #c0c2c1;");
    }

    public void btnClearClientExited(MouseEvent mouseEvent) {
        clearClientBtn.setStyle("-fx-background-color: #263F73; -fx-border-color: #fff; -fx-border-radius: 10px ; -fx-background-radius: 10px;-fx-text-fill: #fff;");
    }

    public void btnDeleteClientEntered(MouseEvent mouseEvent) {
        deleteClientBtn.setStyle("-fx-background-color: #c0c2c1; -fx-text-fill: #000; -fx-border-radius: 4px; -fx-border-color: #c0c2c1;");
    }

    public void btnDeleteClientExited(MouseEvent mouseEvent) {
        deleteClientBtn.setStyle("-fx-background-color: #263F73; -fx-border-color: #fff; -fx-border-radius: 10px ; -fx-background-radius: 10px;-fx-text-fill: #fff;");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Inicializa os tipos de quarto disponíveis e os estados dos quartos
        QuartosDisponiveisRoomType();
        QuartosDisponiveisRoomStatus();

        // Associa os quartos, funcionários e clientes às respetivas tabelas
        associarQuartos();
        FuncionariosCargos();
        associarFuncionarios();
        associarClientes();


    }
}
