package jeu;


import java.util.Scanner;

public class Tuile {
    private int nbCouronne1;
    private String type1;
    private int nbCouronne2;
    private String type2;
    private int nbDomino ;

    public Tuile(int nbDomino) {
        this.nbDomino = nbDomino;
    }

    public Tuile(int nbCouronne1, String type1, int nbCouronne2, String type2, int nbDomino) {
    	
        this.nbCouronne1 = nbCouronne1;
        this.type1=type1;
        this.nbCouronne2 = nbCouronne2;
        this.type2 = type2;
        this.nbDomino = nbDomino;
    }

    @Override
    public String toString() {
        return "Tuile{" +"nbCouronne1=" + nbCouronne1 + ", type1=" + type1 +", nbCouronne2=" + nbCouronne2 +
                ", type2=" + type2 +
                ", nbDomino=" + nbDomino +
                '}';
    }

    public int getNbCouronne1() {
        return nbCouronne1;
    }

    public void setNbCouronne1(int nbCouronne1) {
        this.nbCouronne1 = nbCouronne1;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public int getNbCouronne2() {
        return nbCouronne2;
    }

    public void setNbCouronne2(int nbCouronne2) {
        this.nbCouronne2 = nbCouronne2;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public int getNbDomino() {
        return nbDomino;
    }

    public void setNbDomino(int nbDomino) {
        this.nbDomino = nbDomino;
    }
}