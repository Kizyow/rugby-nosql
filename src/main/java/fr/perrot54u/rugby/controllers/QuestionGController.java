package fr.perrot54u.rugby.controllers;

import fr.perrot54u.rugby.models.QuestionGModel;
import fr.perrot54u.rugby.views.Views;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

public class QuestionGController {

    public ChoiceBox<String> listeEquipe1;
    public ChoiceBox<String> listeEquipe2;
    public ChoiceBox<String> listeEquipe3;
    public TextArea result;

    public void initialize() {
        this.initializeChoicebox();
    }

    public void initializeChoicebox() {
        listeEquipe1.getItems().setAll("NZL", "FRA", "AUS", "SCO");
        listeEquipe2.getItems().setAll("NZL", "FRA", "AUS", "SCO");
        listeEquipe3.getItems().setAll("NZL", "FRA", "AUS", "SCO");
    }

    public void afficher(ActionEvent actionEvent) {

        if (listeEquipe1.getValue() == null || listeEquipe2.getValue() == null || listeEquipe3.getValue() == null) {
            result.setText("Erreur : vous n'avez pas rempli tout les paramètres requis");
            return;
        }

        if (listeEquipe1.getValue().equals(listeEquipe2.getValue()) || listeEquipe1.getValue().equals(listeEquipe3.getValue()) || listeEquipe2.getValue().equals(listeEquipe3.getValue())) {
            result.setText("Erreur : vous devez définir une équipe différente pour chaque paramètre");
            return;
        }

        QuestionGModel model = new QuestionGModel();
        String resultString = model.afficherJoueurs(listeEquipe1.getValue(), listeEquipe2.getValue(), listeEquipe3.getValue());

        result.setText(resultString);

    }

    public void onBack(ActionEvent actionEvent) {
        Views.MENU.loadScene();
    }

}
