package fr.perrot54u.rugby.controllers;

import fr.perrot54u.rugby.database.DBConnection;
import fr.perrot54u.rugby.views.Views;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginMongoController {

    public TextField host;
    public TextField port;
    public TextField database;
    public TextField collection;
    public TextField login;
    public PasswordField password;

    @FXML
    public void onLogin(MouseEvent mouseEvent) {

        DBConnection.initializeDatabase(host.getText(), port.getText(), database.getText(), collection.getText(), login.getText(), password.getText());

        Views.MENU.loadScene();

    }

}
