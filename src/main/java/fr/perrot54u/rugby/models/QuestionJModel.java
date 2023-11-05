package fr.perrot54u.rugby.models;

import fr.perrot54u.rugby.pojo.Equipe;
import fr.perrot54u.rugby.pojo.Joueur;
import fr.perrot54u.rugby.pojo.Match;

import java.util.List;

public class QuestionJModel extends BaseModel {

    public List<Joueur> meilleursJoueurs() {

        Joueur joueurEssaiMax = null;
        int essaisMax = Integer.MIN_VALUE;

        Joueur joueurPointMax = null;
        int pointsMax = Integer.MIN_VALUE;

        List<Match> matches = this.getMatchs();

        for (Match match : matches) {

            Equipe equipeR = match.getEquipeR();
            Equipe equipeD = match.getEquipeD();

            for (Joueur joueur : equipeR.getJoueurs()) {

                if (joueur.getNbPoints() > pointsMax) {
                    pointsMax = joueur.getNbPoints();
                    joueurPointMax = joueur;
                }

                if (joueur.getNbEssais() > essaisMax) {
                    essaisMax = joueur.getNbEssais();
                    joueurEssaiMax = joueur;
                }

            }

            for (Joueur joueur : equipeD.getJoueurs()) {

                if (joueur.getNbPoints() > pointsMax) {
                    pointsMax = joueur.getNbPoints();
                    joueurPointMax = joueur;
                }

                if (joueur.getNbEssais() > essaisMax) {
                    essaisMax = joueur.getNbEssais();
                    joueurEssaiMax = joueur;
                }

            }


        }

        return List.of(joueurPointMax, joueurEssaiMax);

    }

    public String afficherJoueurs() {

        String string = "";

        List<Joueur> joueurs = this.meilleursJoueurs();
        Joueur joueurPoint = joueurs.get(0);
        Joueur joueurEssai = joueurs.get(1);

        if (joueurPoint != null) {
            string += joueurPoint.getNumJoueur() + " (" + joueurPoint.getNom() + " " + joueurPoint.getPrenom() + ") avec le plus de points (" + joueurPoint.getNbPoints() + " points)\n";
        }

        if (joueurEssai != null) {
            string += joueurEssai.getNumJoueur() + " (" + joueurEssai.getNom() + " " + joueurEssai.getPrenom() + ") avec le plus d'essais (" + joueurEssai.getNbEssais() + " essais)\n";
        }

        return string;

    }

}
