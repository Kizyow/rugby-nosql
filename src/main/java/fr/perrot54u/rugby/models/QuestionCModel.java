package fr.perrot54u.rugby.models;

import fr.perrot54u.rugby.pojo.Equipe;
import fr.perrot54u.rugby.pojo.Match;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.*;

public class QuestionCModel extends BaseModel {

    public List<Equipe> listeEquipeRWithNumArbitre(int arbitreId) {

        Bson query = eq("arbitre.numArbitre", arbitreId);
        List<Match> matches = this.getMatchsWithFilter(query);

        List<Equipe> equipeList = new ArrayList<>();

        for (Match match : matches) {
            equipeList.add(match.getEquipeR());
        }

        return equipeList;

    }

    public String afficherEquipeArbitre(int arbitreId) {

        String string = "";

        for (Equipe equipe : this.listeEquipeRWithNumArbitre(arbitreId)) {
            string += equipe.toString() + "\n";
        }

        return string;

    }

}
