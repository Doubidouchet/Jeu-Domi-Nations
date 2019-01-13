package jeu;

import java.util.Scanner;

public class Joueur {
	private Plateau plateau = new Plateau();
	Scanner reader = new Scanner(System.in);



	// Fonction qui permet de demander ou estce qu'on veut placer le domino au joueur en cours

	public TuilesGestion choixPlacement(Tuiles aPlacer) {
		String entete;
		int x=0;
		int y=0;
		
		boolean a = false;
		TuilesGestion lePlacement;
		
		// QUAND ON DEMANDE LA POSITION X ON PLACE LA CASE DE DROITE PAR EXEMPLE
		// SI LA TUILE C F0 C0 LE X Y VA PLACER C0 ENSUITE LORIENTATION
		// CEST LE F0 QUI VA ENTRE EN HAUT EN BAS A GAUCHE A DROITE (NORD SUD EST OUEST)
		// On demande jusque ce soit bon
		
		while (!a) {
			x = JeuMessage.recupereInt("Entrez la colonne ou vous voulez placer le domino de droite");
			y = JeuMessage.recupereInt("Entrez la ligne ou vous voulez placer le domino de droite");
			
			if (inoccupe(x, y)) {
				System.out.println("Vous avez choisi une bonne position !");
				a = true;
			} else {
				System.out.println("Impossible de le placer ici, choisissez un nouveau lieu.");
			}
		}
		System.out.print("Choisissez l'orientation");
	
		entete = JeuMessage.recupereString("Entrez une orientation pour le domino de gauche, N, S, E ou O");
			
		lePlacement = new TuilesGestion(x, y, aPlacer, entete);
		return lePlacement;

	}



	// Cette fonction place une tuile aPlacer 
	
	public void placeTuile(TuilesGestion lePlacement) {

		Tuiles aPlacer = lePlacement.aPlacer;
		String entete = lePlacement.entete;
		
		int x = lePlacement.x;
		int y = lePlacement.y;
		
		switch (entete) {

		case ("S"):
			plateau.getPlateauJoueur()[x][y] = aPlacer.getCaseRef();
			plateau.getPlateauJoueur()[x][y - 1] = aPlacer.getCaseGauche();
			break;
			
		case ("N"):
			plateau.getPlateauJoueur()[x][y] = aPlacer.getCaseRef();
			plateau.getPlateauJoueur()[x][y + 1] = aPlacer.getCaseGauche();
			break;
			
		case ("E"):
			plateau.getPlateauJoueur()[x][y] = aPlacer.getCaseRef();
			plateau.getPlateauJoueur()[x - 1][y] = aPlacer.getCaseGauche();
			break;
			
		case ("O"):
			plateau.getPlateauJoueur()[x][y] = aPlacer.getCaseRef();
			plateau.getPlateauJoueur()[x + 1][y] = aPlacer.getCaseGauche();
			break;
			
		}
	}

	// Cette fonction sert a verifier si une tuile n'est pas deja la a lendroit voulu
	
	public boolean inoccupe(int x, int y) {
		if (plateau.getPlateauJoueur()[x][y].getNom() != ":") {
			return false;
		} else {

			return true;
		}
	}
	
	// 
	
	public void faireTour(Tuiles dominoChoisi) {
		
		TuilesGestion placementActuel;
		plateau.setPlateauBordure();
		plateau.affichePlateau();
		dominoChoisi.printADomino();
		boolean bonChoix= false;
		
		while (!bonChoix) {

			placementActuel = choixPlacement(dominoChoisi);

			if (placementActuel.entete.equals("U")) {
				System.out.print("Dommage");
				bonChoix = true;

			} else {
				if (estBienPlacer(placementActuel)) {
					placeTuile(placementActuel);
					bonChoix = true;

				} else {
					System.out.println("Vous ne pouvez pas placer la tuile ici");

				}
			}

		}
	}

	//Cette fonction test si le terrain adjacent au domino correspond
	
	public boolean terrainAdjacentCorrespond(TuilesGestion lePlacement) {
		int x = lePlacement.x;
		int y = lePlacement.y;
		
		Tuiles aPlacer = lePlacement.aPlacer;
		String entete = lePlacement.entete;
		// Verifie pour toute les cases adjacente si elle correspond, sans inclure la caseRef et verifie pour toutes
		// les cases adjacente sans inclure la CaseGauche
		switch (entete) {
		
		case "S":
			for (int i = -1; i <= 1; i = i+2) {
				if (verifieTerrainAdjacent(x + i, y, aPlacer) 
					|| verifieTerrainAdjacent(x, y + 1, aPlacer)) {
				return true;
					
				} else if (verifieTerrainAdjacent(x + i, y - 1, aPlacer)
						|| verifieTerrainAdjacent(x, y - 2, aPlacer)) {
				return true;
				}
			}
			System.out.println("Ce n'est pas un bon placement, recommencez!");
			break;
			
		case "N":
			for (int i = -1; i <= 1; i = i+2) {
				if (verifieTerrainAdjacent(x + i, y, aPlacer) 
					|| verifieTerrainAdjacent(x, y - 1, aPlacer)) {
				return true;
				} else if (verifieTerrainAdjacent(x + i, y + 1, aPlacer)
						|| verifieTerrainAdjacent(x, y + 2, aPlacer)) {
				return true;
				}
			}
			System.out.println("Ce n'est pas un bon placement, recommencez!");
			break;
			
		case "E":
			for (int i = -1; i <= 1; i = i+2) {
				if (verifieTerrainAdjacent(x, y + i, aPlacer) 
					|| verifieTerrainAdjacent(x + 1, y, aPlacer)) {
				return true;
				} else if (verifieTerrainAdjacent(x - 1, y + i, aPlacer)
						|| verifieTerrainAdjacent(x - 2, y, aPlacer)) {
				return true;
				}
			}
			System.out.println("Ce n'est pas un bon placement, recommencez!");
			break;
			
		case "O":
			for (int i = -1; i <= 1; i = i+2) {
				if (verifieTerrainAdjacent(x, y + i, aPlacer) 
					|| verifieTerrainAdjacent(x - 1, y, aPlacer)) {
				return true;
				} else if (verifieTerrainAdjacent(x + 1, y + i, aPlacer)
						|| verifieTerrainAdjacent(x + 2, y, aPlacer)) {
				return true;
				}
			}
			System.out.println("Ce n'est pas un bon placement, recommencez!");
			break;
		}
		return false;
	}

	// Cette fonction utilise terrainAdjacentCorrespond pour verifier si la piece adjacente est bonne
	// et si lemplacement est inoccup�
	public boolean estBienPlacer(TuilesGestion lePlacement) {
		

		String entete = lePlacement.entete;
		
		int x = lePlacement.x;
		int y = lePlacement.y;
		
		switch (entete) {
		case "S":
			if (terrainAdjacentCorrespond(lePlacement) && inoccupe(x, y - 1))
				return true;
			else {

				return false;
			}
		case "N":
			if (terrainAdjacentCorrespond(lePlacement) && inoccupe(x, y + 1))
				return true;
			else
				return false;
		case "E":
			if (terrainAdjacentCorrespond(lePlacement) && inoccupe(x - 1, y))
				return true;
			else
				return false;
		case "O":
			if (terrainAdjacentCorrespond(lePlacement) && inoccupe(x + 1, y))
				return true;
			else
				return false;

		}
		return false;

	}
	
	public Plateau getPlateau() {
		return plateau;
	}

	// Cette fonction verifie si une tuile a plac� partage bien un terrain avec une tuile sur le plateau!
	
	
	public boolean verifieTerrainAdjacent(int x, int y, Tuiles aPlacer) {
		
		if (plateau.getPlateauJoueur()[x][y].getNom() == aPlacer.getCaseRef().getNom()
				|| plateau.getPlateauJoueur()[x][y].getNom() == aPlacer.getCaseGauche().getNom()
				|| plateau.getPlateauJoueur()[x][y].getNom() == "C") {
			return true;
		} else
			return false;
	}

}
