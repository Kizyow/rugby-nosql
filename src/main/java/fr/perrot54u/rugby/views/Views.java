package fr.perrot54u.rugby.views;

import fr.perrot54u.rugby.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public enum Views {

    /**
     * Liste des toutes les vues de l'application (conversion FXML vers Java)
     */
    LOGIN_MONGO("login-mongo-view.fxml", "Connexion à la base de donnée - Coupe du monde de rugby"),
    MENU("menu-view.fxml", "Menu - Coupe du monde de rugby"),
    QUESTION_A("question-a-view.fxml", "Question A - Coupe du monde de rugby"),
    QUESTION_B("question-b-view.fxml", "Question B - Coupe du monde de rugby"),
    QUESTION_C("question-c-view.fxml", "Question C - Coupe du monde de rugby"),
    QUESTION_D("question-d-view.fxml", "Question D - Coupe du monde de rugby"),
    QUESTION_E("question-e-view.fxml", "Question E - Coupe du monde de rugby"),
    QUESTION_F("question-f-view.fxml", "Question F - Coupe du monde de rugby"),
    QUESTION_G("question-g-view.fxml", "Question G - Coupe du monde de rugby"),
    QUESTION_H("question-h-view.fxml", "Question H - Coupe du monde de rugby"),
    QUESTION_I("question-i-view.fxml", "Question I - Coupe du monde de rugby"),
    QUESTION_J("question-j-view.fxml", "Question J - Coupe du monde de rugby"),
    QUESTION_K("question-k-view.fxml", "Question K - Coupe du monde de rugby");

    private final String fileName;
    private final String windowTitle;
    private static Stage stage;

    Views(String fileName, String windowTitle) {
        this.fileName = fileName;
        this.windowTitle = windowTitle;
    }

    /**
     * Permet de charger les scènes à partir d'un stage donné
     * @param pStage
     */
    public static void initialize(Stage pStage) {
        stage = pStage;
        stage.setResizable(false);
    }

    /**
     * Permet de charger une scène à partir de la liste ci dessus
     * @return Retourne le contrôleur correspondant à l'application
     * @param <T> Le controleur
     */
    public <T> T loadScene() {
        URL url = Main.class.getResource("/fxml/" + fileName);
        FXMLLoader fxmlLoader = new FXMLLoader(url);

        try {
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle(windowTitle);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return fxmlLoader.getController();

    }

}
