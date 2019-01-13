package jeu;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import jeu.Case.TerrainType;

public class GestionTour {

	private Joueur[] lesJoueurs;
	private JoueurTour leTour = new JoueurTour();
	private int nbJoueur;
	int[] turnOrder;
	int turnIncrement = 0;
	int leChoix;
	// Cette fonction demande le nombre de joueurs dans la partie
	// Si le choix n'est pas entre 2 et 4, la fonction se relance
	// Et ils ont a choisir de nouveau

	public void setNbJoueur() {

		while (nbJoueur < 2 || nbJoueur > 4) {
			System.out.print("A combien de joueur voulez vous joué ? ");

			nbJoueur = JeuMessage.recupereInt("Vous pouvez être entre 2 et 4 joueurs");

		}
		lesJoueurs = new Joueur[nbJoueur];
		//ajout joueur
		for (int i = 0; i < lesJoueurs.length; i++) {
			lesJoueurs[i] = new Joueur();

		}
		// init nb de tour selon les joueurs
		turnOrder = new int[nbJoueur];
		
		for (int i = 0; i < turnOrder.length; i++) {
			turnOrder[i] = i;
		}
		leTour.choixDuTour(nbJoueur);
	}

	public void printLeTour() {
		
		for (int i = 0; i < leTour.getRsvPlateau().length; i++) {
			leTour.getRsvPlateau()[i].printADomino();
		}
	}

	// Cette fonction retourne le domino choisi par le joueur encours 
	
	// Si il tente de prendre un domino deja choisi, on lui redemande de choisir et il reçoit un message derreur
	
	public Tuiles chooseADomino() {

		printLeTour();
		System.out.print("Parmis ces dominos, lequel voudrais tu choisir?");
		while (leChoix < 1 || leChoix > leTour.getRsvPlateau().length) {

			leChoix = JeuMessage.recupereInt("Entrez 1 pour le domino du haut, 2 pour le domino du bas, etc..");
			try {
				if (!leTour.getRsvPlateau()[leChoix - 1].estChoisi()) {
					leTour.getRsvPlateau()[leChoix - 1].setChoisi();

				} else {
					System.out.print("Ce domino est déjà choisi par un joueur, prenez en un autre.");
					leChoix = 0;

				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
		}
		turnOrder[turnIncrement] = leChoix - 1;
		turnIncrement += 1;
		return leTour.getRsvPlateau()[leChoix - 1];

	}

	// iNSTANCE UN NOUVEAU TOUR DE JEU
	public void faireNouveauTour() {

		for (int i = 0; i < lesJoueurs.length; i++) {
			lesJoueurs[i].getPlateau().setPlateauBordure();
			lesJoueurs[i].getPlateau().affichePlateau();
		}
		leTour.setRsvPlateau();

		faireLeTour();
		turnIncrement = 0;

	}

	// iNDIQUE LE TOUR DE LA PERSONNE DANS LORDRE
	public void faireLeTour() {
		
		for (int i = 0; i < turnOrder.length; i++) {
			System.out.println("Tour du joueur" + (turnOrder[i] + 1));
			lesJoueurs[turnOrder[i]].faireTour(chooseADomino());
			leChoix = 0;
		}

	}

	// Cette boucle lance les tours a la suite 
	public void boucleDesTours() {

		for (int i = 0; i < 12; i++) {
			faireNouveauTour();
		}
		for (int i = 0; i < lesJoueurs.length; i++) {
			lesJoueurs[i].getPlateau().scoreTheBoard();
		}

	}

	public void faireNouvellePartie() {
		setNbJoueur();
		boucleDesTours();
	}


}
