package com.school.tgpsi_m08_celso_zua;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class PrincipalController  {
    @FXML
    private AnchorPane ClientForm;

    @FXML
    private TableView ClientTableView;

    @FXML
    private Button QuartosDisponiveisBtn;

    @FXML
    private AnchorPane QuartosDisponiveisForm;

    @FXML
    private Button addBtn;

    @FXML
    private Button chekInBtn;

    @FXML
    private Button clearBtn;

    @FXML
    private Button clientBtn;

    @FXML
    private TableColumn clientCheckIn;

    @FXML
    private TableColumn clientCheckOut;

    @FXML
    private TableColumn clientFirstName;

    @FXML
    private TableColumn clientNumber;

    @FXML
    private TableColumn clientNumbersPhone;

    @FXML
    private TableColumn clientSecondName;

    @FXML
    private TableColumn clientTotalPayment;

    @FXML
    private Button deleteBn;

    @FXML
    private Button funcionariosBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private Button minimizeBtn;

    @FXML
    private TextField roomNumber;

    @FXML
    private TableColumn roomNumberCollum;

    @FXML
    private TextField roomPrice;

    @FXML
    private TableColumn roomPriceCollum;

    @FXML
    private TextField roomSearch;

    @FXML
    private TableColumn roomStatusCollum;

    @FXML
    private ComboBox roomType;

    @FXML
    private TableColumn<?, ?> roomTypeCollum;

    @FXML
    private ComboBox<?> roomTypeStatus;

    @FXML
    private ImageView sairBtn;

    @FXML
    private TextField searchClientes;

    @FXML
    private Button updateBtn;

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
}
