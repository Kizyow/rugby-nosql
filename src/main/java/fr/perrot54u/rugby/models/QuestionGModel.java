package fr.perrot54u.rugby.models;

import fr.perrot54u.rugby.pojo.Equipe;
import fr.perrot54u.rugby.pojo.Joueur;
import fr.perrot54u.rugby.pojo.Match;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Filters.eq;

public class QuestionGModel extends BaseModel {

    public List<Joueur> unionJoueursDeuxMatchs(String codeEq1, String codeEq2, String codeEq3) {

        Bson query = or(
                or(
                        and(
                                eq("equipeR.codeEquipe", codeEq1),
                                eq("equipeD.codeEquipe", codeEq2)),
                        and(
                                eq("equipeR.codeEquipe", codeEq2),
                                eq("equipeD.codeEquipe", codeEq1)
                        )
                ),
                or(
                        and(
                                eq("equipeR.codeEquipe", codeEq1),
                                eq("equipeD.codeEquipe", codeEq3)),
                        and(
                                eq("equipeR.codeEquipe", codeEq3),
                                eq("equipeD.codeEquipe", codeEq1)
                        )
                )
        );

        List<Match> matches = this.getMatchsWithFilter(query);
        List<Joueur> joueursTemp = new ArrayList<>();
        List<Joueur> joueursResult = new ArrayList<>();

        for (Match match : matches) {

            Equipe equipe;

            if (match.getEquipeR().getCodeEquipe().equalsIgnoreCase(codeEq1)) {
                equipe = match.getEquipeR();
            } else {
                equipe = match.getEquipeD();
            }

            if (joueursTemp.isEmpty()) {
                joueursTemp = new ArrayList<>(equipe.getJoueurs());

            } else {

                for (Joueur joueur : equipe.getJoueurs()) {

                    Joueur j = this.getJoueurFromId(joueur.getNumJoueur(), joueursTemp);

                    if (j != null && joueur.getTpsJeu() > 0 && j.getTpsJeu() > 0) {
                        joueursResult.add(joueur);
                    }

                }

            }

        }

        return joueursResult;

    }

    public String afficherJoueurs(String codeEq1, String codeEq2, String codeEq3) {

        List<Joueur> joueurs = this.unionJoueursDeuxMatchs(codeEq1, codeEq2, codeEq3);

        String string = "";

        for (Joueur joueur : joueurs) {

            string += joueur.getNumJoueur() + " (" + joueur.getNom() + " " + joueur.getPrenom() + ") \n";

        }

        return string;

    }

}
