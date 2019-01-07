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
	private int totalBoardScore = 0;
	Case[][] testBoard = new Case[10][10];

	// Le plateau du début est en 10*10 avec le chateau au milieu 
	
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

//	//Test de generation dun terrain aleatoire pour points.
//	public Case giveRandDomino() {
//		Random rand = new Random();
//		Case s;
//		int n = rand.nextInt(31) + 1;
//		int ca = rand.nextInt(3);
//		if (n <= 5) {
//			s = new Case(TerrainType.PRAIRIE);
//		} else if (n > 5 && n <= 10) {
//			s = new Case(TerrainType.MINE);
//		} else if (n > 10 && n <= 15) {
//			s = new Case(TerrainType.MER);
//		} else if (n > 15 && n <= 20) {
//			s = new Case(TerrainType.MONTAGNE);
//		} else if (n > 20 && n <= 25) {
//			s = new Case(TerrainType.CHAMPS);
//		} else if (n > 25 && n <= 30) {
//			s = new Case(TerrainType.FORET);
//		} else {
//			s = new Case(TerrainType.BLANK);
//		}
//		s.setCouronnes(ca);
//
//		return s;
//
//	}

//	//T
//	public void populateRandomBoard() {
//
//		for (int i = 0; i < 9; i++) {
//			for (int j = 0; j < 9; j++) {
//
//				if (j < 2 || j > 6 || i < 2 || i > 6) {
//					plateauJoueur[j][i] = new Case(TerrainType.BLANK);
//				} else if ((i == 4) && (j == 4)) {
//					plateauJoueur[j][i] = new Case(TerrainType.CHATEAU);
//				} else if (i < 4 && i > 1) {
//
//					plateauJoueur[j][i] = giveRandDomino();
//
//				} else if (i > 4 && i < 7) {
//					plateauJoueur[j][i] = giveRandDomino();
//
//				}
//
//			}
//		}
//		plateauJoueur[2][4] = giveRandDomino();
//		plateauJoueur[3][4] = giveRandDomino();
//		plateauJoueur[5][4] = giveRandDomino();
//		plateauJoueur[6][4] = giveRandDomino();
//
//	}


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
					plateauJoueur[j][i] = new Case(TerrainType.OUTOFBOUNDS);
				}
				if (j < maxX - 4) {
					plateauJoueur[j][i] = new Case(TerrainType.OUTOFBOUNDS);
				}
				if (i > minY + 4) {
					plateauJoueur[j][i] = new Case(TerrainType.OUTOFBOUNDS);
				}
				if (i < maxY - 4) {
					plateauJoueur[j][i] = new Case(TerrainType.OUTOFBOUNDS);
				}
			}
		}
	}

	List<Case> laZone = new ArrayList<Case>();

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
		int numCouronnes = 0;
		for (int i = 0; i < laZone.size(); i++) {
			numCouronnes += laZone.get(i).getCouronnes();
		}
		totalBoardScore += (laZone.size() * numCouronnes);
		laZone = new ArrayList<Case>();
		// System.out.print(" " + numCrowns + " ");
		// System.out.print(laZone.size());

		// System.out.print("Scored");

	}

	public void scoreTheBoard() {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				scoreAZone(j, i);
			}
		}

		System.out.print(totalBoardScore);
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
	
	public void setDominoChoisi(Tuiles chosenDomino) {
		this.dominoChoisi = chosenDomino;
	}
}
