package fr.perrot54u.rugby.pojo;

import java.util.Date;

public class Match {

    private int numMatch;
    private Date dateMatch;
    private int nbSpectateurs;
    private Stade stade;
    private Equipe equipeR;
    private Equipe equipeD;
    private Arbitre arbitre;

    public int getNumMatch() {
        return numMatch;
    }

    public void setNumMatch(int numMatch) {
        this.numMatch = numMatch;
    }

    public Date getDateMatch() {
        return dateMatch;
    }

    public void setDateMatch(Date dateMatch) {
        this.dateMatch = dateMatch;
    }

    public int getNbSpectateurs() {
        return nbSpectateurs;
    }

    public void setNbSpectateurs(int nbSpectateurs) {
        this.nbSpectateurs = nbSpectateurs;
    }

    public Stade getStade() {
        return stade;
    }

    public void setStade(Stade stade) {
        this.stade = stade;
    }

    public Equipe getEquipeR() {
        return equipeR;
    }

    public void setEquipeR(Equipe equipeR) {
        this.equipeR = equipeR;
    }

    public Equipe getEquipeD() {
        return equipeD;
    }

    public void setEquipeD(Equipe equipeD) {
        this.equipeD = equipeD;
    }

    public Arbitre getArbitre() {
        return arbitre;
    }

    public void setArbitre(Arbitre arbitre) {
        this.arbitre = arbitre;
    }

    @Override
    public String toString() {
        return "Match{" +
                "numMatch=" + numMatch +
                ", dateMatch=" + dateMatch +
                ", nbSpectateurs=" + nbSpectateurs +
                ", stade=" + stade +
                ", equipeR=" + equipeR +
                ", equipeD=" + equipeD +
                ", arbitre=" + arbitre +
                '}';
    }

}
