package fr.perrot54u.rugby.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class DBConnection {

    private static String host = "localhost";
    private static String port = "27017";
    private static String database = "rugby";
    private static String collection = "rugby";
    private static String username;
    private static String password;
    private static String MONGO_URL;

    /**
     * Initialiser la base de donnée avec le login/password
     *
     * @param hote
     * @param portNumber
     * @param db
     * @param collect
     * @param usr
     * @param passwd
     */
    public static void initializeDatabase(String hote, String portNumber, String db, String collect, String usr, String passwd) {
        host = hote;
        port = portNumber;
        if (!db.isEmpty()) database = db;
        if (!collect.isEmpty()) collection = collect;
        username = usr;
        password = passwd;

        if (username.isEmpty() && password.isEmpty()) {
            MONGO_URL = "mongodb://" + host + ":" + port;
        } else {
            MONGO_URL = "mongodb://" + username + ":" + password + "@" + host + ":" + port;
        }

    }

    /**
     * @return Une session de MongoClient
     */
    public static MongoClient createSession() {
        return MongoClients.create(MONGO_URL);
    }

    public static String getDatabase() {
        return database;
    }

    public static String getCollection() {
        return collection;
    }

}