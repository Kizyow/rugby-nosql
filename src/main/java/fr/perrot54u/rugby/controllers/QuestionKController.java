package fr.perrot54u.rugby.controllers;

import fr.perrot54u.rugby.models.QuestionKModel;
import fr.perrot54u.rugby.pojo.Arbitre;
import fr.perrot54u.rugby.views.Views;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

import java.util.List;

public class QuestionKController {

    public QuestionKModel model;

    public ChoiceBox<String> listeMatch;
    public ChoiceBox<String> listeArbitre;
    public TextArea result;

    public void initialize() {
        this.model = new QuestionKModel();
        this.initializeChoicebox();
    }

    public void initializeChoicebox() {

        List<String> matches = model.getMatchs().stream().map(match -> match.getNumMatch() + " (" + match.getEquipeR().getCodeEquipe() + "-" + match.getEquipeD().getCodeEquipe() + ")").toList();
        listeMatch.getItems().setAll(matches);

        List<String> arbitres = model.getArbitres().stream().map(Arbitre::toString).toList();
        listeArbitre.getItems().setAll(arbitres);

    }

    public void inserer(ActionEvent actionEvent) {

        if (listeMatch.getValue() == null || listeArbitre.getValue() == null) {
            result.setText("Erreur : vous n'avez pas rempli tous les paramètres requis");
            return;
        }

        int numMatch = Integer.parseInt(listeMatch.getValue().split(" ")[0]);
        int numArbitre = Integer.parseInt(listeArbitre.getValue().split(": ")[0]);

        boolean updated = model.insererArbitre(numMatch, numArbitre);

        if (updated) {
            result.setText("Vous avez bien inséré l'arbitre " + listeArbitre.getValue() + " au match " + listeMatch.getValue() + " avec succès !");
            List<String> arbitres = model.getArbitres().stream().map(Arbitre::toString).toList();
            listeArbitre.getItems().setAll(arbitres);
        } else {
            result.setText("Erreur : l'arbitre n'a pas pu être remplacé car il appartient au même pays qu'une équipe du match");
        }

    }

    public void onBack(ActionEvent actionEvent) {
        Views.MENU.loadScene();
    }

}
