package fr.perrot54u.rugby.controllers;

import fr.perrot54u.rugby.views.Views;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

public class MenuController {

    /**
     * Se deconnecter de la base de donnée
     *
     * @param mouseEvent
     */
    public void onDisconnect(MouseEvent mouseEvent) {
        Views.LOGIN_MONGO.loadScene();
    }

    public void questionA(ActionEvent actionEvent) {
        Views.QUESTION_A.loadScene();
    }

    public void questionB(ActionEvent actionEvent) {
        Views.QUESTION_B.loadScene();
    }

    public void questionC(ActionEvent actionEvent) {
        Views.QUESTION_C.loadScene();
    }

    public void questionD(ActionEvent actionEvent) {
        Views.QUESTION_D.loadScene();
    }

    public void questionE(ActionEvent actionEvent) {
        Views.QUESTION_E.loadScene();
    }

    public void questionF(ActionEvent actionEvent) {
        Views.QUESTION_F.loadScene();
    }

    public void questionG(ActionEvent actionEvent) {
        Views.QUESTION_G.loadScene();
    }

    public void questionH(ActionEvent actionEvent) {
        Views.QUESTION_H.loadScene();
    }

    public void questionI(ActionEvent actionEvent) {
        Views.QUESTION_I.loadScene();
    }

    public void questionJ(ActionEvent actionEvent) {
        Views.QUESTION_J.loadScene();
    }

    public void questionK(ActionEvent actionEvent) {
        Views.QUESTION_K.loadScene();
    }

}
