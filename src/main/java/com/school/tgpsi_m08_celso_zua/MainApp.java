package com.school.tgpsi_m08_celso_zua;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        // Carregar o FXML do login
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("login.fxml"));

        // Criar a cena com o conteúdo do FXML
        Scene scene = new Scene(fxmlLoader.load());

        // Configurar a Stage
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);

        // Carregar listas Quartos Disponiveis, Funcionarios e Clientes
        Settings.loadRoomList();
        Settings.loadFuncionariosList();
        Settings.loadClientList();

        // Mostrar a stage
        primaryStage.show();
    }
}
