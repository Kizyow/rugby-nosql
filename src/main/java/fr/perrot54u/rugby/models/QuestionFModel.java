package fr.perrot54u.rugby.models;

import fr.perrot54u.rugby.pojo.Equipe;
import fr.perrot54u.rugby.pojo.Joueur;

public class QuestionFModel extends BaseModel {

    public String afficherJoueurs(String codeEquipe) {

        Equipe equipe = this.getEquipeFromCodeEq(codeEquipe);
        String string = "";

        for (Joueur joueur : equipe.getJoueurs()) {

            string += joueur.getNumJoueur() + " (" + joueur.getNom() + " " + joueur.getPrenom() + ") " + " - " +
                    "Nombre de matchs joués : " + joueur.getNbMatchsJoues() + ", " +
                    "Nombre de points : " + joueur.getNbPoints() + ", " +
                    "Nombre d'essais : " + joueur.getNbEssais() + "\n";

        }

        return string;

    }

}
