package fr.perrot54u.rugby.controllers;

import fr.perrot54u.rugby.models.QuestionBModel;
import fr.perrot54u.rugby.views.Views;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class QuestionBController {

    public DatePicker date;
    public TextField score;
    public TextArea result;

    public void rechercher(ActionEvent actionEvent) {

        if (date.getValue() == null) {
            result.setText("Erreur : vous n'avez pas choisi la date");
            return;
        }

        int scoreInt = 0;

        String replacement = score.getText().replaceAll("[^\\d.]", "");
        score.setText(replacement);

        if (!score.getText().isBlank() && !score.getText().isBlank()) {
            scoreInt = Integer.parseInt(score.getText());
        }

        QuestionBModel model = new QuestionBModel();
        String string = model.afficherMatchs(date.getValue(), scoreInt);

        result.setText(string);

    }

    public void onBack(ActionEvent actionEvent) {
        Views.MENU.loadScene();
    }

}
