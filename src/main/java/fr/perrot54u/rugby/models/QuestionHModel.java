package fr.perrot54u.rugby.models;

import fr.perrot54u.rugby.pojo.Equipe;
import fr.perrot54u.rugby.pojo.Joueur;

public class QuestionHModel extends BaseModel {

    public String afficherJoueurs(String codeEq) {

        Equipe equipe = this.getEquipeFromCodeEq(codeEq);

        String string = "";

        for (Joueur joueur : equipe.getJoueurs()) {

            if (joueur.getTpsJeu() <= 0) {
                string += joueur.getNumJoueur() + " (" + joueur.getNom() + " " + joueur.getPrenom() + ") \n";

            }

        }

        return string;

    }

}
