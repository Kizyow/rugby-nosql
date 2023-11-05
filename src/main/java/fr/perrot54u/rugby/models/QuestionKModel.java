package fr.perrot54u.rugby.models;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import fr.perrot54u.rugby.database.DBConnection;
import fr.perrot54u.rugby.pojo.Arbitre;
import fr.perrot54u.rugby.pojo.Match;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import static com.mongodb.client.model.Filters.*;

public class QuestionKModel extends BaseModel {

    public boolean isArbitreCompatibleWithMatch(Match match, Arbitre arbitre) {
        return !arbitre.getPays().equalsIgnoreCase(match.getEquipeR().getPays()) && !arbitre.getPays().equalsIgnoreCase(match.getEquipeD().getPays());
    }

    public boolean insererArbitre(int numMatch, int numArbitre) {

        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        try (MongoClient mongoClient = DBConnection.createSession()) {
            MongoDatabase db = mongoClient.getDatabase(DBConnection.getDatabase()).withCodecRegistry(pojoCodecRegistry);

            MongoCollection<Match> matchs = db.getCollection(DBConnection.getCollection(), Match.class);

            Match match = this.getMatchFromId(numMatch);
            Arbitre arbitre = this.getArbitreFromId(numArbitre);

            if (!this.isArbitreCompatibleWithMatch(match, arbitre)) return false;

            match.setArbitre(arbitre);

            Bson query = eq("numMatch", numMatch);
            matchs.findOneAndReplace(query, match);

        }

        return true;

    }

}
