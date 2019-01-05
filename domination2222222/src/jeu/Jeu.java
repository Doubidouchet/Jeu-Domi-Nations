package jeu;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import edu.princeton.cs.introcs.StdDraw;


import static java.lang.Integer.parseInt;

public class Jeu {

    public static void Teste() {

        ArrayList<Tuile> tuiles = TuilesExtract.tuilesdoc();
        SetColor SetColor = new SetColor();

        Color[] kingColors = SetColor.getKingColors();

        //Création de la pioche de rois et de chateaux

        ArrayList<Roi> rois = new ArrayList<>();
        int nbRois = 4;
        int nbChateau = 4;
        
        for (int i = 0; i < nbRois ; i++){
            int a = (int)(Math.random() * (kingColors.length - 1));
            Roi roi = new Roi(kingColors[a]);
            rois.add(roi);
            kingColors[a] = null;
        }

        ArrayList<Chateau> chateaux = new ArrayList<>();
        ArrayList<Tuile> reserve = new ArrayList<>();
        ArrayList<Chateau> newChateau = new ArrayList<>();
        ArrayList<Roi> newRois = new ArrayList<>();
        ArrayList<Tuile> paquetJoueurs = new ArrayList<>();
        ArrayList<Tuile> paquetPlateforme = new ArrayList<>();
        ArrayList<Roi> countRois = new ArrayList<>();
        ArrayList<Joueur> joueurs = new ArrayList<>();
        ArrayList<Joueur> premiertourjoueur = new ArrayList<>(joueurs);
        ArrayList<Integer> countPoints = new ArrayList<>();
        
        for (int i = 0; i <nbChateau ; i ++){
            int a = (int)(Math.random() * (kingColors.length - 1));
            Chateau chateau = new Chateau(kingColors[a]);
            chateaux.add(chateau);
            kingColors[a] = null;
        }


        // Test le nombre de joueurs
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisissez le nombre de joueurs");
        int nbJoueurs = scanner.nextInt();
        scanner.nextLine();
        
        while (nbJoueurs < 2 || nbJoueurs > 4) {
            System.out.println("Vous n'êtes pas le bon nombre de joueurs, recommencez");
            nbJoueurs = scanner.nextInt();

        }
        System.out.println("Veuillez commencer Ã  jouer");


        // La pioche
        
        for (int i = 0; i < 48; i++) {
            reserve.add(tuiles.get((int) (Math.random() * 48)));
        }
        if (nbJoueurs == 3) {
            for (int k = 0; k < 12 ; k++){
                reserve.remove((int) (Math.random() * 48));
            }
        } else if (nbJoueurs == 2) {
            for (int g = 0 ; g < 24; g++){
                reserve.remove((int) (Math.random() * 48));
            }
        }

        // initialisation du premier tour
        Collections.shuffle(premiertourjoueur);


        // Attribuer paquet, rois et chateau a  chaque joueur

        for (int i = 0 ; i < nbJoueurs; i++){

            // jeu.Chateau
            Chateau EChat = chateaux.get((int) Math.random() * 4);
            
            newChateau.add(EChat);
            chateaux.remove(EChat);
            
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            StdDraw.filledSquare(x,y, 5 );

            //jeu.Roi
            Roi ERoi = rois.get((int) Math.random() * 8);
            
            newRois.add(ERoi);
            rois.remove(ERoi);
            countRois.add(ERoi);
            
            if (nbJoueurs == 2) {
                Roi test = rois.get((int) Math.random() * 8);
                newRois.add(test);
                rois.remove(test);
                Roi test2 = rois.get((int) Math.random() * 7);
                while (test2 != test) {
                    test2 = rois.get((int) Math.random() * 7);
                }
                newRois.add(test2);
                rois.remove(test2);
                countRois.add(test);
                countRois.add(test2);
            }

            // La tuile de départ
            Tuile tuileDepart = reserve.get((int)Math.random()*reserve.size());
            paquetJoueurs.add(tuileDepart);
            reserve.remove(tuileDepart);
            StdDraw.filledSquare(x,y, 5 );


            //Création du joueur
            Joueur joueur = new Joueur("Joueur " + i, newRois,newChateau,paquetJoueurs);
            joueurs.add(joueur);


            // Remettre à  0 les arguments du joueur pour le joueur d'après
            newRois.remove(newRois.size());
            newChateau.remove(newChateau.size());
            paquetJoueurs.remove(paquetJoueurs.size());

        }

        // Le jeu commence

        // Savoir qui commence
        Roi roiChoisi = countRois.get((int) (Math.random() * countRois.size()));

        //Jouer
        int turnNumber = 1;

        while (reserve.size() != 0) {

            for (int i = 0; i < countRois.size() ; i++) {
                Tuile pioche = reserve.get(0);
                
                //Mettre les dominos au milieu du jeu
                paquetPlateforme.add(pioche);
                reserve.remove(pioche);
                TuilesGestion.sortTuilesByNumber(paquetPlateforme);
            }


            for (int j = 0 ; j < nbJoueurs ; j ++) {
            	
                Joueur joueurPlaying = choixJoueur(premiertourjoueur, turnNumber);
                
                // Le joueur choisi le domino qu'il veut
                int dominoChoisi = scanner.nextInt();
                paquetJoueurs.add(paquetPlateforme.get(dominoChoisi));


            }
            turnNumber++;
        }

        StdDraw.clear(StdDraw.BLACK);

    }

    /**
     *
     * @param premiertourJoueur
     * @param turnNumber
     * @return
     */
    private static Joueur choixJoueur(ArrayList<Joueur> premiertourJoueur, int turnNumber) {
    	
        if (turnNumber == 1) {
            Joueur joueur = premiertourJoueur.get(0);
            premiertourJoueur.remove(joueur);
            return joueur;
        } else {
            // TODO : Implements
            return null;
        }
    }
}

