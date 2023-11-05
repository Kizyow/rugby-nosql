package fr.perrot54u.rugby.pojo;

import java.util.Objects;

public class Arbitre {

    private int numArbitre;
    private String nomArbitre;
    private String prenomArbitre;
    private String pays;

    public int getNumArbitre() {
        return numArbitre;
    }

    public void setNumArbitre(int numArbitre) {
        this.numArbitre = numArbitre;
    }

    public String getNomArbitre() {
        return nomArbitre;
    }

    public void setNomArbitre(String nomArbitre) {
        this.nomArbitre = nomArbitre;
    }

    public String getPrenomArbitre() {
        return prenomArbitre;
    }

    public void setPrenomArbitre(String prenomArbitre) {
        this.prenomArbitre = prenomArbitre;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arbitre arbitre = (Arbitre) o;
        return numArbitre == arbitre.numArbitre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numArbitre);
    }

    @Override
    public String toString() {
        return numArbitre + ": " + nomArbitre + " " + prenomArbitre + " (" + pays + ")";
    }
}
