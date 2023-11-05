package fr.perrot54u.rugby.models;

import fr.perrot54u.rugby.pojo.Equipe;
import fr.perrot54u.rugby.pojo.Joueur;
import fr.perrot54u.rugby.pojo.Match;
import org.bson.conversions.Bson;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Filters.and;

public class QuestionDModel extends BaseModel {

    public Equipe recupererEquipe(String codeEq1, LocalDate localDate, String codeEq2) {

        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Bson query = and(
                gte("dateMatch", date),
                or(
                        and(
                                eq("equipeR.codeEquipe", codeEq1),
                                eq("equipeD.codeEquipe", codeEq2)),
                        and(
                                eq("equipeR.codeEquipe", codeEq2),
                                eq("equipeD.codeEquipe", codeEq1)
                        )
                )
        );

        Equipe equipe = null;

        Optional<Match> optionalMatch = this.getMatchsWithFilter(query).stream().findFirst();
        if (optionalMatch.isPresent()) {
            Match match = optionalMatch.get();
            if (match.getEquipeR().getCodeEquipe().equalsIgnoreCase(codeEq1)) {
                equipe = match.getEquipeR();
            } else {
                equipe = match.getEquipeD();
            }
        }

        return equipe;

    }

    public String afficherEquipe(String codeEq1, LocalDate localDate, String codeEq2) {

        Equipe equipe = this.recupererEquipe(codeEq1, localDate, codeEq2);
        String string = "";

        for (Joueur joueur : equipe.getJoueurs()) {

            if (joueur.getTitulaire() != null && joueur.getTitulaire()) {
                string += joueur.getNumJoueur() + " (" + joueur.getNom() + " " + joueur.getPrenom() + ") " + "\n";
            }

        }

        return string;

    }

}
