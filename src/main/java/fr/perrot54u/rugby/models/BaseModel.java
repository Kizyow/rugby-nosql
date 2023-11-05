package fr.perrot54u.rugby.models;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Projections;
import fr.perrot54u.rugby.database.DBConnection;
import fr.perrot54u.rugby.pojo.Arbitre;
import fr.perrot54u.rugby.pojo.Equipe;
import fr.perrot54u.rugby.pojo.Joueur;
import fr.perrot54u.rugby.pojo.Match;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.project;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * Classe permettant de mettre les requêtes MongoDB les plus courante
 */
public class BaseModel {

    /**
     * Permet de récupérer tous les matchs sans filtre
     *
     * @return La liste des matchs
     */
    public List<Match> getMatchs() {

        List<Match> matches = new ArrayList<>();

        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        try (MongoClient mongoClient = DBConnection.createSession()) {
            MongoDatabase db = mongoClient.getDatabase(DBConnection.getDatabase()).withCodecRegistry(pojoCodecRegistry);

            MongoCollection<Match> matchCollection = db.getCollection(DBConnection.getCollection(), Match.class);

            for (Match match : matchCollection.find()) {
                matches.add(match);
            }

        }

        return matches;

    }

    /**
     * Récupérer un match via son numéro du match
     *
     * @param numMatch Le numéro du match
     * @return Le Match sinon une exception s'il n'existe pas
     */
    public Match getMatchFromId(int numMatch) {
        Optional<Match> optionalMatch = this.getMatchs().stream().filter(match -> match.getNumMatch() == numMatch).findFirst();
        if (optionalMatch.isPresent()) {
            return optionalMatch.get();
        } else {
            throw new NullPointerException("Aucun match n'existe avec le numéro fourni");
        }
    }

    /**
     * Permet de récupérer tous les matchs avec un filtre
     *
     * @param filter Le filtre à appliquer
     * @return La liste des matchs
     */
    public List<Match> getMatchsWithFilter(Bson filter) {

        List<Match> matches = new ArrayList<>();

        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        try (MongoClient mongoClient = DBConnection.createSession()) {
            MongoDatabase db = mongoClient.getDatabase(DBConnection.getDatabase()).withCodecRegistry(pojoCodecRegistry);

            MongoCollection<Match> matchCollection = db.getCollection(DBConnection.getCollection(), Match.class);

            for (Match match : matchCollection.find(filter)) {
                matches.add(match);
            }

        }

        return matches;

    }

    /**
     * Permet de récupérer les équipes (même équipe mais chaque match) via le code de l'équipe
     *
     * @param codeEq Code de l'équipe
     * @return La liste des équipes
     */
    public List<Equipe> getEquipesFromCodeEq(String codeEq) {

        List<Match> matches = this.getMatchs();
        List<Equipe> equipes = new ArrayList<>();

        for (Match match : matches) {

            Equipe equipeR = match.getEquipeR();
            Equipe equipeD = match.getEquipeD();

            if (equipeR.getCodeEquipe().equalsIgnoreCase(codeEq)) {
                equipes.add(equipeR);
            }

            if (equipeD.getCodeEquipe().equalsIgnoreCase(codeEq)) {
                equipes.add(equipeD);
            }

        }

        return equipes;

    }

    /**
     * Permet de récupérer une seule équipe avec toutes les statistiques additionnées à travers tous les matchs
     *
     * @param codeEq Le code de l'équipe
     * @return Equipe avec les statistiques additionnées
     */
    public Equipe getEquipeFromCodeEq(String codeEq) {

        List<Equipe> equipes = this.getEquipesFromCodeEq(codeEq);

        Equipe equipeResult = new Equipe();
        equipeResult.setScore(0);
        equipeResult.setNbEssais(0);
        equipeResult.setJoueurs(new ArrayList<>());

        for (Equipe equipe : equipes) {

            equipeResult.setCodeEquipe(equipe.getCodeEquipe());
            equipeResult.setPays(equipe.getPays());
            equipeResult.setEntraineur(equipe.getEntraineur());
            equipeResult.setScore(equipeResult.getScore() + equipe.getScore());
            equipeResult.setNbEssais(equipeResult.getNbEssais() + equipe.getNbEssais());

            for (Joueur joueur : equipe.getJoueurs()) {

                Joueur j = getJoueurFromId(joueur.getNumJoueur(), equipeResult.getJoueurs());

                if (j != null) {

                    j.setNbEssais(j.getNbEssais() + joueur.getNbEssais());
                    j.setTpsJeu(j.getTpsJeu() + joueur.getTpsJeu());
                    j.setNbPoints(j.getNbPoints() + joueur.getNbPoints());
                    if (joueur.getTitulaire() != null) j.setNbMatchsJoues(j.getNbMatchsJoues() + 1);

                } else {
                    if (joueur.getTitulaire() != null) joueur.setNbMatchsJoues(1);
                    equipeResult.getJoueurs().add(joueur);
                }

            }

        }

        return equipeResult;

    }

    /**
     * Permet de récupérer un Joueur via son numéro dans une liste de joueurs
     *
     * @param numJoueur Le numéro du joueur
     * @param joueurs   La liste de joueurs
     * @return Le Joueur s'il existe sinon null
     */
    public Joueur getJoueurFromId(int numJoueur, List<Joueur> joueurs) {

        for (Joueur joueur : joueurs) {
            if (joueur.getNumJoueur() == numJoueur) {
                return joueur;
            }
        }

        return null;

    }

    /**
     * Permet de récupérer la liste des arbitres à travers tous les matchs
     *
     * @return La liste des arbitres;
     */
    public List<Arbitre> getArbitres() {
        List<Arbitre> arbitres = new ArrayList<>();

        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        try (MongoClient mongoClient = DBConnection.createSession()) {
            MongoDatabase db = mongoClient.getDatabase(DBConnection.getDatabase()).withCodecRegistry(pojoCodecRegistry);

            MongoCollection<Match> matchs = db.getCollection(DBConnection.getCollection(), Match.class);

            for (Match match : matchs.aggregate(Arrays.asList(
                    group("$arbitre.numArbitre", Accumulators.first("arbitre", "$arbitre")),
                    project(Projections.fields(Projections.excludeId(), Projections.include("arbitre")))
            ))) {
                arbitres.add(match.getArbitre());
            }

        }

        return arbitres.stream().distinct().toList();

    }

    /**
     * Récupérer un arbitre via son Id
     *
     * @param numArbitre le numéro de l'arbitre
     * @return Un Arbitre sinon une exception s'il n'existe pas
     */
    public Arbitre getArbitreFromId(int numArbitre) {
        Optional<Arbitre> optionalArbitre = this.getArbitres().stream().filter(arbitre -> arbitre.getNumArbitre() == numArbitre).findFirst();
        if (optionalArbitre.isPresent()) {
            return optionalArbitre.get();
        } else {
            throw new NullPointerException("Aucun arbitre n'existe avec le numéro fourni");
        }
    }

}
