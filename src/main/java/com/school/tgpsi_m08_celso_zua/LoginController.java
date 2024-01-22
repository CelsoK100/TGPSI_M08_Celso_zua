package com.school.tgpsi_m08_celso_zua;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class LoginController {
    //Atributos
    @FXML
    private Button buttonCancel;
    @FXML
    private Button buttonLogin;
    @FXML
    private TextField nameTxt;
    @FXML
    private PasswordField passPf;
    private Dialog<Object> primaryStage;

    // Ação do botão de cancelar
    public void buttonCancelOnAction(ActionEvent actionEvent){
        Stage stage = (Stage) buttonCancel.getScene().getWindow();
        stage.close();
    }

    // Ação do botão de login
    public void buttonLoginOnAction(ActionEvent actionEvent) throws Exception {
        // Verifica se o nome e a palavra-passe correspondem
        if(nameTxt.getText().equals("celso") && passPf.getText().equals("admin")){

            //Mostra  uma mensagem de login bem-sucedido
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login");
            alert.setHeaderText("Realizado com sucesso!");
            alert.setContentText("Clique no botão para a proxima janela...");
            alert.show();

            // Carrega a próxima janela (Principal.fxml)
            Parent scene = FXMLLoader.load(getClass().getResource("Principal.fxml"));
            //primaryStage.initStyle(StageStyle.UNDECORATED);
            Stage back = new Stage();

            //Definições da Stage
            back.setTitle("");
            back.setResizable(false);
            back.initModality(Modality.WINDOW_MODAL);
            back.setScene(new Scene(scene));

            // Esconde a janela de login e mostra a próxima janela
            Window window = buttonLogin.getScene().getWindow();
            window.hide();
            back.show();
        }
        else {

            // Mostra uma mensagem de erro se o login falhar
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login");
            alert.setHeaderText("Nome ou palavra passe incorretos,tente novamente!");
            alert.setContentText("clique no botao para continuar.");
            alert.show();
        }

        }
    }

