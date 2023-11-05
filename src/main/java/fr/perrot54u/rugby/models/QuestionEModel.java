package fr.perrot54u.rugby.models;

import fr.perrot54u.rugby.pojo.Equipe;
import fr.perrot54u.rugby.pojo.Joueur;

import java.util.ArrayList;
import java.util.List;

public class QuestionEModel extends BaseModel {

    public List<Joueur> getJoueursEntresEnCoursDeJeu(String codeEquipe) {

        List<Equipe> equipeList = this.getEquipesFromCodeEq(codeEquipe);

        List<Joueur> joueurs = new ArrayList<>();

        for (Equipe equipe : equipeList) {

            for (Joueur joueur : equipe.getJoueurs()) {

                if (joueurs.contains(joueur)) continue;

                if (joueur.getTitulaire() != null && !joueur.getTitulaire()) {
                    joueurs.add(joueur);
                }

            }

        }

        return joueurs;

    }

    public String afficherJoueurs(String codeEq) {

        List<Joueur> joueurs = this.getJoueursEntresEnCoursDeJeu(codeEq);
        String string = "";

        for (Joueur joueur : joueurs) {
            string += joueur.getNumJoueur() + " (" + joueur.getNom() + " " + joueur.getPrenom() + ") " + "\n";
        }

        return string;

    }

}
