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
	// Cette fonction demande le nmobre de joueurs dans la partie
	// Si le choix n'est pas entre 2 et 4, la fonction se relance
	// Et ils ont a choisir de nouveau

	public void setNbJoueur() {

		while (nbJoueur < 2 || nbJoueur > 4) {
			System.out.print("Combien de Joueurs?");

			nbJoueur = JeuMessage.recupereInt("Vous pouvez être 2, 3, ou 4.");

		}
		lesJoueurs = new Joueur[nbJoueur];
		for (int i = 0; i < lesJoueurs.length; i++) {
			lesJoueurs[i] = new Joueur();

		}
		turnOrder = new int[nbJoueur];
		for (int i = 0; i < turnOrder.length; i++) {
			turnOrder[i] = i;
		}
		leTour.choixDuTour(nbJoueur);
	}
	

	public void faireNouvellePartie() {
		setNbJoueur();
		boucleDesTours();
	}

	public void printLeTour() {
		for (int i = 0; i < leTour.getRsvPlateau().length; i++) {
			leTour.getRsvPlateau()[i].printADomino();
		}
	}

	// Cette fonction retourne le domino choisi par le joueur encours 
	
	// Si il tente de prendre un domino deja choisi, on lui redemande de choisir et il reçoit un message derreur
	
	public Tuiles chooseADomino() {

		boolean bonChoix = false;
		printLeTour();
		System.out.print("Quel domino voudrais tu choisir?");
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

		faireTheTour();
		turnIncrement = 0;

	}

	// iNDIQUE LE TOUR DE LA PERSONNE DANS LORDRE
	public void faireTheTour() {
		for (int i = 0; i < turnOrder.length; i++) {
			System.out.println("Tour du joueur" + (turnOrder[i] + 1));
			lesJoueurs[turnOrder[i]].faireTour(chooseADomino());
			leChoix = 0;
		}

	}

	// Cette boucle lance les 12 tours a la suite (nombre de tour dune partie de domination)
	public void boucleDesTours() {

		for (int i = 0; i < 12; i++) {
			faireNouveauTour();
		}
		for (int i = 0; i < lesJoueurs.length; i++) {
			lesJoueurs[i].getPlateau().scoreTheBoard();
		}

	}

	public static void main(String[] args) {
		GestionTour x = new GestionTour();

		x.faireNouvellePartie();

		// TODO Auto-generated method stub

	}

}
