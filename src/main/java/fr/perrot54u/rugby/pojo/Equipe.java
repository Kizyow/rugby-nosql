package fr.perrot54u.rugby.pojo;

import java.util.List;

public class Equipe {

    private String codeEquipe;
    private String pays;
    private String couleur;
    private String entraineur;
    private int score;
    private int nbEssais;
    private List<Joueur> joueurs;

    public String getCodeEquipe() {
        return codeEquipe;
    }

    public void setCodeEquipe(String codeEquipe) {
        this.codeEquipe = codeEquipe;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getEntraineur() {
        return entraineur;
    }

    public void setEntraineur(String entraineur) {
        this.entraineur = entraineur;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNbEssais() {
        return nbEssais;
    }

    public void setNbEssais(int nbEssais) {
        this.nbEssais = nbEssais;
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    @Override
    public String toString() {
        return "Equipe " + codeEquipe + " (" + pays + ", " + couleur + ") entraînée par " + entraineur + ", avec un score total de " + score + " points pour " + nbEssais + " essais";
    }
}
