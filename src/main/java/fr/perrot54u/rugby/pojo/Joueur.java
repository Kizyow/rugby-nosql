package fr.perrot54u.rugby.pojo;

import java.util.Objects;

public class Joueur {

    private int numJoueur;
    private String prenom;
    private String nom;
    private String poste;
    private String codeEquipe;
    private Boolean titulaire;
    private int tpsJeu;
    private int nbPoints;
    private int nbEssais;
    private int nbMatchsJoues;

    public int getNumJoueur() {
        return numJoueur;
    }

    public void setNumJoueur(int numJoueur) {
        this.numJoueur = numJoueur;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getCodeEquipe() {
        return codeEquipe;
    }

    public void setCodeEquipe(String codeEquipe) {
        this.codeEquipe = codeEquipe;
    }

    public Boolean getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(Boolean titulaire) {
        this.titulaire = titulaire;
    }

    public int getTpsJeu() {
        return tpsJeu;
    }

    public void setTpsJeu(int tpsJeu) {
        this.tpsJeu = tpsJeu;
    }

    public int getNbPoints() {
        return nbPoints;
    }

    public void setNbPoints(int nbPoints) {
        this.nbPoints = nbPoints;
    }

    public int getNbEssais() {
        return nbEssais;
    }

    public void setNbEssais(int nbEssais) {
        this.nbEssais = nbEssais;
    }

    public int getNbMatchsJoues() {
        return nbMatchsJoues;
    }

    public void setNbMatchsJoues(int nbMatchsJoues) {
        this.nbMatchsJoues = nbMatchsJoues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joueur joueur = (Joueur) o;
        return numJoueur == joueur.numJoueur;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numJoueur);
    }


}
