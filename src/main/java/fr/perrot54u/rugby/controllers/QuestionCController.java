package fr.perrot54u.rugby.controllers;

import fr.perrot54u.rugby.models.QuestionCModel;
import fr.perrot54u.rugby.pojo.Arbitre;
import fr.perrot54u.rugby.views.Views;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

public class QuestionCController {

    public ChoiceBox<String> listeArbitres;
    public TextArea result;
    public QuestionCModel model;


    public void initialize() {
        this.model = new QuestionCModel();
        this.initializeChoicebox();
    }

    public void initializeChoicebox() {
        listeArbitres.getItems().setAll(model.getArbitres().stream().map(Arbitre::toString).toList());
    }

    public void rechercher(ActionEvent actionEvent) {

        if (listeArbitres.getValue() == null) {
            result.setText("Erreur : vous n'avez pas choisi votre arbitre");
            return;
        }

        QuestionCModel model = new QuestionCModel();

        int numArbitre = Integer.parseInt(listeArbitres.getValue().split(": ")[0]);
        String string = model.afficherEquipeArbitre(numArbitre);

        result.setText(string);

    }

    public void onBack(ActionEvent actionEvent) {
        Views.MENU.loadScene();
    }

}
