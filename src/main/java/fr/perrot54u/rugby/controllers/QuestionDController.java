package fr.perrot54u.rugby.controllers;

import fr.perrot54u.rugby.models.QuestionDModel;
import fr.perrot54u.rugby.views.Views;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

public class QuestionDController {

    public ChoiceBox<String> listeEquipe1;
    public DatePicker date;
    public ChoiceBox<String> listeEquipe2;
    public TextArea result;


    public void initialize() {
        this.initializeChoicebox();
    }

    public void initializeChoicebox() {
        listeEquipe1.getItems().setAll("NZL", "FRA", "AUS", "SCO");
        listeEquipe2.getItems().setAll("NZL", "FRA", "AUS", "SCO");
    }

    public void rechercher(ActionEvent actionEvent) {

        if (listeEquipe1.getValue() == null || listeEquipe2.getValue() == null || date.getValue() == null) {
            result.setText("Erreur : vous n'avez pas rempli tout les paramètres requis");
            return;
        }

        QuestionDModel model = new QuestionDModel();
        String string = model.afficherEquipe(listeEquipe1.getValue(), date.getValue(), listeEquipe2.getValue());

        result.setText(string);

    }

    public void onBack(ActionEvent actionEvent) {
        Views.MENU.loadScene();
    }

}
