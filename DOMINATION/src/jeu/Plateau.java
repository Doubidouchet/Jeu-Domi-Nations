package jeu;

import java.util.Random;
import jeu.Case.TerrainType;
import java.util.ArrayList;
import java.util.List;

//Cette classe represente le plateau du joueur

public class Plateau {
	private List<Tuiles> dominos;
	private Tuiles dominoChoisi;
	private Case[][] plateauJoueur = new Case[10][10];
	private int totalScoreBoard = 0;
	// Case[][] testBoard = new Case[10][10];

	
	public Plateau() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if ((i == 4) && (j == 4)) {
					plateauJoueur[j][i] = new Case(TerrainType.CHATEAU);
				} else {
					plateauJoueur[j][i] = new Case(TerrainType.BLANK);
				}
			}
		}
	}

//	//Test de generation dun terrain aleatoire (na jamais marché)
	
	List<Case> laZone = new ArrayList<Case>();


	public boolean inoccupé(int x, int y) {
		if (plateauJoueur[x][y].getNom() != ":") {

			return false;
		} else {

			return true;
		}
	}

	public void setPlateauBordure() {
		int minX = 9;
		int maxX = 0;
		int minY = 9;
		int maxY = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (plateauJoueur[j][i].getNom() != ":" && plateauJoueur[j][i].getNom() != "X") {
					if (j < minX) {
						minX = j;
					}
					if (j > maxX) {
						maxX = j;
					}
					if (i < minY) {
						minY = i;
					}
					if (i > maxY) {
						maxY = i;
					}
				}

			}
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (j > minX + 4) {
					plateauJoueur[j][i] = new Case(TerrainType.HORSMAP);
				}
				if (j < maxX - 4) {
					plateauJoueur[j][i] = new Case(TerrainType.HORSMAP);
				}
				if (i > minY + 4) {
					plateauJoueur[j][i] = new Case(TerrainType.HORSMAP);
				}
				if (i < maxY - 4) {
					plateauJoueur[j][i] = new Case(TerrainType.HORSMAP);
				}
			}
		}
	}


	public void trouverZone(int x, int y) {

		if (!(plateauJoueur[x][y].estCompté())) {
			if (plateauJoueur[x][y].getNom() == "X" || plateauJoueur[x][y].getNom() == ":") {

			} else {
				laZone.add(plateauJoueur[x][y]);
				plateauJoueur[x][y].setEstCompté(true);
				if (plateauJoueur[x + 1][y].getNom() == plateauJoueur[x][y].getNom() && (x + 1 != 10)
						&& !plateauJoueur[x + 1][y].estCompté()) {

					trouverZone(x + 1, y);

				}

				if ((plateauJoueur[x - 1][y].getNom() == plateauJoueur[x][y].getNom()) && (x - 1 != -1)
						&& !plateauJoueur[x - 1][y].estCompté()) {
					trouverZone(x - 1, y);

				}

				if (plateauJoueur[x][y + 1].getNom() == plateauJoueur[x][y].getNom() && (y + 1 != 10)
						&& !plateauJoueur[x][y + 1].estCompté()) {
					trouverZone(x, y + 1);

				}

				if (plateauJoueur[x][y - 1].getNom() == plateauJoueur[x][y].getNom() && (y - 1 != -1)
						&& !plateauJoueur[x][y - 1].estCompté()) {
					trouverZone(x, y - 1);

				}

			}

		}

	}

	public void scoreAZone(int x, int y) {

		trouverZone(x, y);
		
		int nbCouronnes = 0;
		
		
		for (int i = 0; i < laZone.size(); i++) {
			nbCouronnes += laZone.get(i).getCouronnes();
		}
		totalScoreBoard += (laZone.size() * nbCouronnes);
		
		laZone = new ArrayList<Case>();

	}

	public void scoreTheBoard() {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				scoreAZone(j, i);
			}
		}

		System.out.print(totalScoreBoard);
	}

	public void affichePlateau() {
		System.out.println("");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (plateauJoueur[j][i].getNom() == "B")
					System.out.print(plateauJoueur[j][i].getNom() + "" + j + "" + i + " ");
				else if (plateauJoueur[j][i].getNom() == "X")
					System.out.print(plateauJoueur[j][i].getNom() + "   ");
				else
					System.out.print(plateauJoueur[j][i].getNom() + "" + plateauJoueur[j][i].getCouronnes() + "  ");

			}
			System.out.println("");

		}
		System.out.println("");
	}

	public Case[][] getPlateauJoueur() {
		return plateauJoueur;
	}

	public void addDomino(Tuiles domino) {
		dominos.add(domino);
	}
	
	public void setDominoChoisi(Tuiles dominoChoisi) {
		this.dominoChoisi = dominoChoisi;
	}
}
