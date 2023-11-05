package fr.perrot54u.rugby.models;

import fr.perrot54u.rugby.pojo.Equipe;
import fr.perrot54u.rugby.pojo.Joueur;

public class QuestionAModel extends BaseModel {

    public String afficherEquipe(String codeEquipe) {

        Equipe equipe = this.getEquipeFromCodeEq(codeEquipe);
        String string = "";

        equipe.getJoueurs().sort((o1, o2) -> {

            double coef1 = 0;
            double coef2 = 0;

            if (o1.getTpsJeu() > 0) {
                coef1 = (double) o1.getNbPoints() / (double) o1.getTpsJeu();
            }

            if (o2.getTpsJeu() > 0) {
                coef2 = (double) o2.getNbPoints() / (double) o2.getTpsJeu();

            }

            return Double.compare(coef2, coef1);

        });


        for (Joueur joueur : equipe.getJoueurs()) {

            double coef = 0;

            if (joueur.getTpsJeu() > 0) {
                coef = (double) joueur.getNbPoints() / (double) joueur.getTpsJeu();
            }

            string += joueur.getNumJoueur() + " (" + joueur.getNom() + " " + joueur.getPrenom() + ") " + " - " +
                    "Temps de jeu : " + joueur.getTpsJeu() + ", " +
                    "Nombre d'essais : " + joueur.getNbEssais() + ", " +
                    "Nombre de points : " + joueur.getNbPoints() + ", " +
                    "Coefficient : " + coef + " \n";

        }

        return string;

    }

}
