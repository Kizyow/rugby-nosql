package fr.perrot54u.rugby.controllers;

import fr.perrot54u.rugby.models.QuestionJModel;
import fr.perrot54u.rugby.views.Views;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

public class QuestionJController {

    public TextArea result;

    public void afficher(ActionEvent actionEvent) {

        QuestionJModel model = new QuestionJModel();
        String resultString = model.afficherJoueurs();

        result.setText(resultString);

    }

    public void onBack(ActionEvent actionEvent) {
        Views.MENU.loadScene();
    }

}
