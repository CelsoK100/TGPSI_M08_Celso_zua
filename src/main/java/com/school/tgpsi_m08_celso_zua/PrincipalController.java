package com.school.tgpsi_m08_celso_zua;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PrincipalController implements Initializable {
    @FXML
    private Button AcercaDeBtn;

    @FXML
    private Button ClearFunBtn;

    @FXML
    private Button ClientBtn;

    @FXML
    private AnchorPane ClientForm;

    @FXML
    private TableView<?> ClientTableView;

    @FXML
    private TableColumn<?, ?> FuncionarioAgeColumm;

    @FXML
    private TableColumn<?, ?> FuncionarioCargoColumm;

    @FXML
    private TableColumn<?, ?> FuncionarioFirstNameColumm;

    @FXML
    private TextField FuncionarioSearch;

    @FXML
    private TableColumn<?, ?> FuncionarioSecondNameColumm;

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
    private Button chekInBtn;

    @FXML
    private Button clearBtn;

    @FXML
    private TableColumn<?, ?> clientCheckIn;

    @FXML
    private TableColumn<?, ?> clientCheckOut;

    @FXML
    private TableColumn<?, ?> clientFirstName;

    @FXML
    private TableColumn<?, ?> clientNumber;

    @FXML
    private TableColumn<?, ?> clientNumbersPhone;

    @FXML
    private TableColumn<?, ?> clientSecondName;

    @FXML
    private TableColumn<?, ?> clientTotalPayment;

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
    private ComboBox<?> funcionarioStatus;

    @FXML
    private TextField funcionariosFirstName;

    @FXML
    private TextField funcionariosSecondName;

    @FXML
    private Button minimizeBtn;

    @FXML
    private TextField roomNumber;

    @FXML
    private TableColumn<QuartosDisoniveis, Integer> roomNumberCollum;

    @FXML
    private TextField roomPrice;

    @FXML
    private TableColumn<QuartosDisoniveis, Double> roomPriceCollum;

    @FXML
    private TextField roomSearch;

    @FXML
    private ComboBox<?> roomStatus;

    @FXML
    private TableColumn<QuartosDisoniveis, String> roomStatusCollum;

    @FXML
    private ComboBox<?> roomType;

    @FXML
    private TableColumn<QuartosDisoniveis, String> roomTypeCollum;

    @FXML
    private ImageView sairBtn;

    @FXML
    private TextField searchClientes;

    @FXML
    private Button updateBtn;

    @FXML
    private TableView tableViewQuartos;


    public String type[] = {"Um Quarto","Dois Quartos","Três Quartos","Quatro Quartos"};

    public void QuartosDisponiveisRoomType(){
        List<String> listData = new ArrayList<>();

        for(String data: type){
            listData.add(data);
        }

        ObservableList lista = FXCollections.observableArrayList(listData);
        roomType.setItems(lista);
    }

    public static ObservableList<QuartosDisoniveis> listaQuartos = FXCollections.observableArrayList();

    public static ObservableList<QuartosDisoniveis>getListaQuartos(){
        return listaQuartos;
    }


    public void associarQuartos(){
        roomNumberCollum.setCellValueFactory(new PropertyValueFactory<QuartosDisoniveis, Integer>("numQuarto"));
        roomTypeCollum.setCellValueFactory(new PropertyValueFactory<QuartosDisoniveis, String>("tipoDeQuarto"));
        roomStatusCollum.setCellValueFactory(new PropertyValueFactory<QuartosDisoniveis, String>("status"));
        roomPriceCollum.setCellValueFactory(new PropertyValueFactory<QuartosDisoniveis, Double>("preco"));
        tableViewQuartos.setItems(getListaQuartos());
    }

    public static void loadRoomList(){
        listaQuartos.add(new QuartosDisoniveis(1,"Dois Quartos","Disponivel",100));
    }


    public String status[] = {"Disponível","Não Disponível","Ocupado"};

    public void QuartosDisponiveisRoomStatus(){
        List<String> listData = new ArrayList<>();

        for(String data: status){
            listData.add(data);
        }

        ObservableList lista = FXCollections.observableArrayList(listData);
        roomStatus.setItems(lista);

    }


    public void exitApplication(ActionEvent actionEvent) {
    }

    public void menuSairApp(MouseEvent mouseEvent) {
    }

    public void btnSairEntered(MouseEvent mouseEvent) {
    }

    public void btnRooomEntered(MouseEvent mouseEvent) {
    }

    public void btnClientEntered(MouseEvent mouseEvent) {
    }

    public void btnClientExited(MouseEvent mouseEvent) {
    }

    public void btnFuncionariosEntered(MouseEvent mouseEvent) {
    }

    public void btnAcercaDeEntered(MouseEvent mouseEvent) {
    }

    public void btnAcercaDeExited(MouseEvent mouseEvent) {
    }

    public void btnSairExit(MouseEvent mouseEvent) {
    }

    public void btnFuncionariosExited(MouseEvent mouseEvent) {
    }

    public void btnRoomExited(MouseEvent mouseEvent) {
    }

    public void btnAddEntered(MouseEvent mouseEvent) {
    }

    public void btnAddExited(MouseEvent mouseEvent) {
    }

    public void btnUpdateEntered(MouseEvent mouseEvent) {
    }

    public void btnUpdateExit(MouseEvent mouseEvent) {
    }

    public void btnClearExited(MouseEvent mouseEvent) {
    }

    public void btnDeleteEntered(MouseEvent mouseEvent) {
    }

    public void btnDeleteExited(MouseEvent mouseEvent) {
    }

    public void btnCheckInEntered(MouseEvent mouseEvent) {
    }

    public void btnCheckInExit(MouseEvent mouseEvent) {
    }

    public void btnClearEntered(MouseEvent mouseEvent) {
    }

    public void btnAddFunEntered(MouseEvent mouseEvent) {
    }

    public void btnAddFunExited(MouseEvent mouseEvent) {
    }

    public void btnEditFunEntered(MouseEvent mouseEvent) {
    }

    public void btnEdtFunExited(MouseEvent mouseEvent) {
    }

    public void btnClearFunEntered(MouseEvent mouseEvent) {
    }

    public void btnClearFunExited(MouseEvent mouseEvent) {
    }

    public void btnDelFunExited(MouseEvent mouseEvent) {
    }

    public void btnDelFunEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        QuartosDisponiveisRoomType();
        QuartosDisponiveisRoomStatus();
        associarQuartos();
        loadRoomList();
    }
}
