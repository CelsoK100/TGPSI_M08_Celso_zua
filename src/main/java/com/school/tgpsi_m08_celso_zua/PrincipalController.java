package com.school.tgpsi_m08_celso_zua;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.zip.InflaterInputStream;

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
    private TableColumn<QuartosDisponiveis, Integer> roomNumberCollum;

    @FXML
    private TextField roomPrice;

    @FXML
    private TableColumn<QuartosDisponiveis, Double> roomPriceCollum;

    @FXML
    private TextField roomSearch;

    @FXML
    private ComboBox<?> roomStatus;

    @FXML
    private TableColumn<QuartosDisponiveis, String> roomStatusCollum;

    @FXML
    private ComboBox<?> roomType;

    @FXML
    private TableColumn<QuartosDisponiveis, String> roomTypeCollum;

    @FXML
    private Button btnSair;

    @FXML
    private TextField searchClientes;

    @FXML
    private Button updateBtn;

    @FXML
    private TableView tableViewQuartos;


    public String type[] = {"Um Quarto", "Dois Quartos", "Três Quartos", "Quatro Quartos"};

    public void QuartosDisponiveisRoomType() {
        List<String> listData = new ArrayList<>();

        for (String data : type) {
            listData.add(data);
        }

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
    //------------------------------------------------------------------------------------------------------------------
    // Metodos para a lista dos Quartos disponiveis

    public void associarQuartos() {
        roomNumberCollum.setCellValueFactory(new PropertyValueFactory<QuartosDisponiveis, Integer>("numQuarto"));
        roomTypeCollum.setCellValueFactory(new PropertyValueFactory<QuartosDisponiveis, String>("tipoDeQuarto"));
        roomStatusCollum.setCellValueFactory(new PropertyValueFactory<QuartosDisponiveis, String>("status"));
        roomPriceCollum.setCellValueFactory(new PropertyValueFactory<QuartosDisponiveis, Double>("preco"));
        tableViewQuartos.setItems(Settings.getListaQuartos());
    }


    //------------------------------------------------------------------------------------------------------------------/


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

    }

    public void verQuartos() {
        QuartosDisponiveis RoomData = (QuartosDisponiveis) tableViewQuartos.getSelectionModel().getSelectedItem();
        roomNumber.setText(String.valueOf(RoomData.getNumQuarto()));
        itemComboBox(roomType, RoomData.getTipoDeQuarto());
        itemComboBox(roomStatus, RoomData.getStatus());
        roomPrice.setText(String.valueOf(RoomData.getPreco()));
    }

    private void itemComboBox(ComboBox<?> roomType, String tipoDeQuarto) {

    }

    public void buttonAddOnAction(ActionEvent actionEvent) {
        if (roomNumber.getText().isEmpty() || roomType.getSelectionModel().getSelectedItem() == null || roomStatus.getSelectionModel().getSelectedItem() == null || roomPrice.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("Por favor,coloque todos os dados nos respetivos campos");
            alert.setContentText("Clique no botao para tentar novamente!");
            alert.showAndWait();
        } else {
            int quartoNovo = Integer.parseInt(roomNumber.getText());
            if (Settings.listaQuartos.stream().anyMatch(q -> q.getNumQuarto() == quartoNovo)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText("Esse Botao ja foi inserido, por favor coloque outro");
                alert.setContentText("Clique no botao para continuar");
                alert.showAndWait();
            } else {
                int newRoom = Integer.parseInt(roomNumber.getText());
                String newType = String.valueOf(roomType.getSelectionModel().getSelectedItem());
                String newStatus = String.valueOf(roomStatus.getSelectionModel().getSelectedItem());
                double newPrice = Double.parseDouble(roomPrice.getText());

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("CONFIRMAR");
                alert.setHeaderText("Deseja mesmo acionar este pedido?");

                alert.setHeaderText(("Quartos: " + newRoom + "\nTipo de quarto: " + newType + "\nStatus: " + newStatus + "\nPreço: " + newPrice));
                alert.setContentText("Deseja mesmo adicionar?");
                ButtonType buttonSim = new ButtonType("Sim");
                ButtonType buttonNao = new ButtonType("Não");
                alert.getButtonTypes().setAll(buttonSim, buttonNao);
                Optional<ButtonType> choose = alert.showAndWait();
                if (choose.get() == buttonSim) {
                    Settings.listaQuartos.add(new QuartosDisponiveis(newRoom, newType, newStatus, newPrice));
                    Alert alertAddQuartos = new Alert(Alert.AlertType.INFORMATION);
                    alertAddQuartos.setTitle("INFORMARÇAO!!!");
                    alertAddQuartos.setHeaderText("VERIFICANDO DADOS....");
                    alertAddQuartos.setHeaderText("PRODUTO INSERIDO COM SUCESSO!!");
                    alertAddQuartos.showAndWait();
                } else {
                    Alert alertCancelAddQuartos = new Alert(Alert.AlertType.INFORMATION);
                    alertCancelAddQuartos.setTitle("INFORMAÇAO!!!");
                    alertCancelAddQuartos.setContentText("DEIXA DE SER BURRO MADJE-_-");
                    alertCancelAddQuartos.setContentText("CANCELADO COM SUCESSO!!!");
                    alertCancelAddQuartos.showAndWait();
                }
            }

        }
    }


    public void buttonClearOnAction(ActionEvent actionEvent) {
        Settings.listaQuartos.clear();
    }

    public void buttonEditOnAction(ActionEvent actionEvent) {
        if (roomNumber.getText().isEmpty() || roomType.getSelectionModel().getSelectedItem() == null || roomStatus.getSelectionModel().getSelectedItem() == null || roomPrice.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("Por favor,coloque todos os dados nos respetivos campos");
            alert.setContentText("Clique no botao para tentar novamente!");
            alert.showAndWait();
        } else {
            QuartosDisponiveis EditarQuarto = null;
            int newRoom = Integer.parseInt(roomNumber.getText());
            for (QuartosDisponiveis q : Settings.getListaQuartos()) {
                if (q.getNumQuarto() == newRoom) {
                    EditarQuarto = q;
                    break;
                }
            }
            if (EditarQuarto != null){
                EditarQuarto.setNumQuarto(roomNumber.getText());
                EditarQuarto.getTipoDeQuarto(roomType.getSelectionModel().getSelectedItem());


            }
        }
    }



    public void ButtonSairOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
    }


    public void btnDeleteOnAction(ActionEvent actionEvent) {
        if (roomNumber.getText().isEmpty() || roomType.getSelectionModel().getSelectedItem() == null || roomStatus.getSelectionModel().getSelectedItem() == null || roomPrice.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("Nao selecionou nenhum item,por favor selecione um item!!!");
            alert.setContentText("Clique no botão para continuar");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("ELIMINAR");
            alert.setHeaderText("Quartos: " + roomNumber + "\nTipo de quarto: " + roomType + "\nStatus: " + roomStatus + "\nPreço: " + roomPrice);
            alert.setContentText("Deseja realemte elimiar?");
            ButtonType ButtonSim = new ButtonType("Sim");
            ButtonType ButtonNao = new ButtonType("Não");
            alert.getButtonTypes().setAll(ButtonSim, ButtonNao);
            Optional<ButtonType> choose = alert.showAndWait();

            if (choose.get() == ButtonSim) {
                int newRoom = Integer.parseInt(roomNumber.getText());
                for (QuartosDisponiveis q : Settings.listaQuartos) {
                    if (q.getNumQuarto() == newRoom) {
                        Settings.getListaQuartos().remove(q);
                        Alert alertRmQuartos = new Alert(Alert.AlertType.ERROR);
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
}
