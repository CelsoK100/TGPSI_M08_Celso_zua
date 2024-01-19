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
import java.util.*;

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
    private TableColumn<?, ?> FuncionarioIdColumm;

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
    private Button btnSair;

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
    private TableView<?> tableViewFuncionarios;

    @FXML
    private TableView<QuartosDisponiveis> tableViewQuartos;

    @FXML
    private Button updateBtn;


    //----------------------------------------------------------------------------------------------------------------------
// METODOS PARA A CLASSE QUARTOS DISPONIVEIS
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

    public void associarQuartos() {
        roomNumberCollum.setCellValueFactory(new PropertyValueFactory<QuartosDisponiveis, Integer>("numQuarto"));
        roomTypeCollum.setCellValueFactory(new PropertyValueFactory<QuartosDisponiveis, String>("tipoDeQuarto"));
        roomStatusCollum.setCellValueFactory(new PropertyValueFactory<QuartosDisponiveis, String>("status"));
        roomPriceCollum.setCellValueFactory(new PropertyValueFactory<QuartosDisponiveis, Double>("preco"));
        tableViewQuartos.setItems(Settings.getListaQuartos());
    }

    public void verQuartos() {
        QuartosDisponiveis RoomDataVer = (QuartosDisponiveis) tableViewQuartos.getSelectionModel().getSelectedItem();
        roomNumber.setText(String.valueOf(RoomDataVer.getNumQuarto()));
        roomType.setValue(RoomDataVer.getTipoDeQuarto());
        roomStatus.setValue(RoomDataVer.getStatus());
        roomPrice.setText(String.valueOf(RoomDataVer.getPreco()));

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
            //Settings.EditarQuarto = null;
            int newRoom = Integer.parseInt(roomNumber.getText());
            for (QuartosDisponiveis q : Settings.getListaQuartos()) {
                if (q.getNumQuarto() == newRoom) {
                    Settings.EditarQuarto = q;
                    break;
                }
            }
            if (Settings.EditarQuarto != null){
                Settings.EditarQuarto.setTipoDeQuarto((String) roomType.getSelectionModel().getSelectedItem());
                Settings.EditarQuarto.setStatus((String) roomStatus.getSelectionModel().getSelectedItem());
                Settings.EditarQuarto.setPreco(Double.parseDouble(roomPrice.getText()));

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
                    for(QuartosDisponiveis quarto: Settings.getListaQuartos()) {
                        if (quarto.getNumQuarto() == Settings.getEditarQuarto().getNumQuarto()) {
                            int index = Settings.getListaQuartos().indexOf(quarto);
                            Settings.getListaQuartos().set(index, Settings.getEditarQuarto());
                            break;
                        }
                    }
                    Settings.setEditarQuarto(Settings.EditarQuarto);
                    tableViewQuartos.refresh();
                    alertEditRoom.setHeaderText("Ediçao realizada com sucesso");
                    alertEditRoom.setContentText("| Clique no botão para continuar ->");
                    alertEditRoom.showAndWait();
                } else{
                    Alert alertEditCancel = new Alert(Alert.AlertType.INFORMATION);
                    alertEditCancel.setTitle("INFORMAÇÃO!!!");
                    alertEditCancel.setHeaderText("Operação cancelada com sucesso");
                    alertEditCancel.showAndWait();
                }
            }else {
                Alert alertIDNotFound = new Alert(Alert.AlertType.ERROR);
                alertIDNotFound.setContentText("ERRO");
                alertIDNotFound.setHeaderText("Numero do quarto nao encontrado");
                alertIDNotFound.setContentText("Clique no botao para continuar");
                alertIDNotFound.showAndWait();
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
            alert.setHeaderText("Quartos: " + roomNumber.getText() + "\nTipo de quarto: " + roomType.getSelectionModel().getSelectedItem() + "\nStatus: " + roomStatus.getSelectionModel().getSelectedItem() + "\nPreço: " + roomPrice.getText());
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

    public void procurarQuarto(KeyEvent keyEvent) {
        FilteredList<QuartosDisponiveis> filter = new FilteredList<>(Settings.listaQuartos, e -> true);

        roomSearch.textProperty().addListener((Observable, oldValue, newValue) ->{

            filter.setPredicate(predicateroom ->{
                if(newValue == null && newValue.isEmpty()){
                    return true;
                }
                String ProcurarQ = newValue.toLowerCase();
                if (predicateroom.getNumQuarto().toString.contains(ProcurarQ)){
                return true;
                }else if (predicateroom.getTipoDeQuarto().toLowerCase().contains(ProcurarQ)) {
                    return true;
                } else if (predicateroom.getStatus().toLowerCase().contains(ProcurarQ)) {
                    return true;
                } else if (predicateroom.getPreco().toString.contains(ProcurarQ)) {
                    return true;

                }
                return false;
            });
        });
        SortedList<QuartosDisponiveis> sortList =  new SortedList<>(filter);
        sortList.comparatorProperty().bind(tableViewQuartos.comparatorProperty());
        tableViewQuartos.setItems(sortList);
    }



//----------------------------------------------------------------------------------------------------------------------

    public void switchformOnAction(ActionEvent actionEvent) {
        if (actionEvent.getSource() == "QuartosDisponiveisBtn"){
            if(actionEvent.getSource() == QuartosDisponiveisForm){
                QuartosDisponiveisForm.setVisible(true);
                FuncionariosForm.setVisible(false);
                ClientForm.setVisible(false);
                aboutForm.setVisible(false);
            } else if (actionEvent.getSource() == "funcionarioBtn") {
                QuartosDisponiveisForm.setVisible(false);
                FuncionariosForm.setVisible(true);
                ClientForm.setVisible(false);
                aboutForm.setVisible(false);

            } else if (actionEvent.getSource() == "ClientBtn") {
                QuartosDisponiveisForm.setVisible(false);
                FuncionariosForm.setVisible(false);
                ClientForm.setVisible(true);
                aboutForm.setVisible(false);

            } else if (actionEvent.getSource() == "AcercaDeBtn") {
                QuartosDisponiveisForm.setVisible(false);
                FuncionariosForm.setVisible(false);
                ClientForm.setVisible(false);
                aboutForm.setVisible(true);


            }
        }
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
            if (Settings.listaFuncionarios.stream().anyMatch(q -> q.getId() == newFun)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText("Esse id ja foi inserido, por favor coloque outro");
                alert.setContentText("Clique no botao para continuar");
                alert.showAndWait();
            } else {
                int newIDFuncionario = Integer.parseInt(funcionariosId.getText());
                String newFirsName = String.format(funcionariosFirstName.getText());
                String newSecondName = String.format(funcionariosSecondName.getText());
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
                    Alert alertAddQuartos = new Alert(Alert.AlertType.INFORMATION);
                    alertAddQuartos.setTitle("INFORMARÇAO!!!");
                    alertAddQuartos.setHeaderText("VERIFICANDO DADOS....");
                    alertAddQuartos.setContentText("Funcionario INSERIDO COM SUCESSO!!");
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
                Alert alertEditRoom = new Alert(Alert.AlertType.INFORMATION);
                alertEditRoom.setTitle("CONFIRMAÇÃO!!!");
                alertEditRoom.setHeaderText(null);
                Optional<ButtonType> choose = alert.showAndWait();
                if(choose.get() == ButtonSim){
                    for(Funcionario fun: Settings.getListaQuartos()) {
                        if (fun.getId() == Settings.getEditarFuncionario().getId()){
                            int index = Settings.getListaQuartos().indexOf(fun);
                            Settings.getListaFuncionarios().set(index, Settings.getEditarFuncionario());
                            break;
                        }
                    }
                    Settings.setEditarQuarto(Settings.EditarFuncionario);
                    tableViewQuartos.refresh();
                    alertEditRoom.setHeaderText("Ediçao realizada com sucesso");
                    alertEditRoom.setContentText("| Clique no botão para continuar ->");
                    alertEditRoom.showAndWait();
                } else{
                    Alert alertEditCancel = new Alert(Alert.AlertType.INFORMATION);
                    alertEditCancel.setTitle("INFORMAÇÃO!!!");
                    alertEditCancel.setHeaderText("Operação cancelada com sucesso");
                    alertEditCancel.showAndWait();
                }
            }else {
                Alert alertIDNotFound = new Alert(Alert.AlertType.ERROR);
                alertIDNotFound.setContentText("ERRO");
                alertIDNotFound.setHeaderText("ID nao encontrado");
                alertIDNotFound.setContentText("Clique no botao para continuar");
                alertIDNotFound.showAndWait();
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
                int newRoom = Integer.parseInt(roomNumber.getText());
                for (Funcionario f : Settings.listaFuncionarios) {
                    if (q.getNumQuarto() == newRoom) {
                        Settings.getListaFuncionarios().remove(f);
                        Alert alertRmQuartos = new Alert(Alert.AlertType.INFORMATION);
                        alertRmQuartos.setTitle("INFORMACÇAO!!!");
                        alertRmQuartos.setHeaderText("O seu funcionario foi eliminado");
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
