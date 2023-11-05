package fr.perrot54u.rugby.models;

import fr.perrot54u.rugby.pojo.Match;
import org.bson.conversions.Bson;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Filters.gte;

public class QuestionBModel extends BaseModel {

    public String afficherMatchs(LocalDate localDate, int score) {

        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Bson query = and(
                gte("dateMatch", date),
                or(
                        gte("equipeR.score", score),
                        gte("equipeD.score", score)
                )
        );

        List<Match> matches = this.getMatchsWithFilter(query);
        String string = "";

        for (Match match : matches) {
            string += "Match n°" + match.getNumMatch() + " opposant l'équipe " + match.getEquipeR().getCodeEquipe() +
                    " (" + match.getEquipeR().getScore() + " points) contre l'équipe " + match.getEquipeD().getCodeEquipe() + " (" +
                    match.getEquipeD().getScore() + " points)\n";

        }

        return string;

    }

}
