package fr.perrot54u.rugby.models;

import fr.perrot54u.rugby.pojo.Equipe;
import fr.perrot54u.rugby.pojo.Joueur;

public class QuestionIModel extends BaseModel {

    public String afficherJoueurs(String codeEq) {

        Equipe equipe = this.getEquipeFromCodeEq(codeEq);
        int matchTotaux = this.getEquipesFromCodeEq(codeEq).size();

        String string = "";

        for (Joueur joueur : equipe.getJoueurs()) {

            if (joueur.getNbMatchsJoues() == matchTotaux) {
                string += joueur.getNumJoueur() + " (" + joueur.getNom() + " " + joueur.getPrenom() + ") \n";

            }

        }

        return string;

    }

}
