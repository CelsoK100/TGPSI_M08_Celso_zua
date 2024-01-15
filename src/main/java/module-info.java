module com.school.tgpsi_m08_celso_zua {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.school.tgpsi_m08_celso_zua to javafx.fxml;
    exports com.school.tgpsi_m08_celso_zua;
}