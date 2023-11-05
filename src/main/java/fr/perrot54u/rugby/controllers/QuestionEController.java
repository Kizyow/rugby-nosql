package fr.perrot54u.rugby.controllers;

import fr.perrot54u.rugby.models.QuestionEModel;
import fr.perrot54u.rugby.views.Views;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

public class QuestionEController {

    public ChoiceBox<String> listeEquipe;
    public TextArea result;

    public void initialize() {
        this.initializeChoicebox();
    }

    public void initializeChoicebox() {
        listeEquipe.getItems().setAll("NZL", "FRA", "AUS", "SCO");
    }

    public void afficher(ActionEvent actionEvent) {

        if (listeEquipe.getValue() == null) {
            result.setText("Erreur : vous n'avez pas choisi votre équipe");
            return;
        }

        QuestionEModel model = new QuestionEModel();
        String string = model.afficherJoueurs(listeEquipe.getValue());

        result.setText(string);

    }

    public void onBack(ActionEvent actionEvent) {
        Views.MENU.loadScene();
    }

}
