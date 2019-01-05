package jeu;

import java.util.ArrayList;

public class Joueur {
    private String name;
    private ArrayList<jeu.Roi> rois;
    private ArrayList<jeu.Chateau> chateaux;
    private ArrayList<Tuile> reserve;


    public Joueur(String name, ArrayList<Roi> rois, ArrayList<Chateau> chateaux, ArrayList<Tuile> paquet){
        this.name = name;
        this.rois = rois;
        this.chateaux = chateaux;
        this.reserve = reserve;
    }

}
