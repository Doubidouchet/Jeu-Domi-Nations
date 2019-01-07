package jeu;

//import static java.lang.Integer.parseInt;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;

import jeu.Case.TerrainType;

//public class TuilesExtract {
//
//    public static void main(String[] args) {
//        ArrayList<Tuile> tuilesDoc = tuilesdoc();
//        System.out.println(tuilesDoc);
//    }
//
//
//    public static ArrayList<Tuile> tuilesdoc() {
//    	
//        ArrayList<Tuile> tuiles = new ArrayList<>();
//        
//        String dominoFile =  "resources/dominos.csv";
//        //lire le document csv
//        BufferedReader document = null;
//        String ligne = "";
//        String separation = ",";
//        try {
//
//            document = new BufferedReader(new FileReader(dominoFile));
//            while ((ligne = document.readLine()) != null) {
//                // Utiliser une virgule pour séparer
//                String[] line = ligne.split(separation);
//                Tuile domino = new Tuile(parseInt(line[0]),
//                        line[1],
//                        parseInt(line[2]),
//                        line[3],
//                        parseInt(line[4]));
//                tuiles.add(domino);
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (document != null) {
//                try {
//                    document.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return tuiles;
//    }

// Cette class est la reserve de domino de chaque tour

public class TuilesExtract {

	public TuilesExtract() {
		setUpReserve();
	}


	private Tuiles[] dominoNonJoue = new Tuiles[48];

	// creation des dominos de chaque tour en coherence avec le CSV 
	public void setUpReserve() {

		for (int i = 0; i < dominoNonJoue.length; i++) {

			dominoNonJoue[i] = new Tuiles();
			
			if (i == 0 || i == 1 || i == 12 || i == 13 || i == 14 || i == 15 || i == 18 || i == 19 || i == 20 || i == 21
					|| i == 22 || i == 35 || i == 37 || i == 40 || i == 42 || i == 47) {
				dominoNonJoue[i].setGauche(new Case(TerrainType.PRAIRIE));
			}
			if (i == 0 || i == 1 || i == 23 || i == 24 || i == 25 || i == 26 || i == 29 || i == 30 || i == 39
					|| i == 44) {
				dominoNonJoue[i].setDroite(new Case(TerrainType.PRAIRIE));
			}
			if (i == 2 || i == 3 || i == 4 || i == 5 || i == 16 || i == 17 || i == 23 || i == 24 || i == 25 || i == 26
					|| i == 27 || i == 28) {
				dominoNonJoue[i].setGauche(new Case(TerrainType.FORET));
			}
			if (i == 2 || i == 3 || i == 4 || i == 5 || i == 12 || i == 18 || i == 31 || i == 32 || i == 33
					|| i == 34) {
				dominoNonJoue[i].setDroite(new Case(TerrainType.FORET));
			}
			if (i == 6 || i == 7 || i == 8 || i == 29 || i == 30 || i == 31 || i == 32 || i == 33 || i == 34 || i == 36
					|| i == 41) {
				dominoNonJoue[i].setGauche(new Case(TerrainType.MER));
			}
			if (i == 6 || i == 7 || i == 8 || i == 13 || i == 16 || i == 19 || i == 27) {
				dominoNonJoue[i].setDroite(new Case(TerrainType.MER));
			}
			if (i == 9 || i == 10 || i == 38 || i == 43) {
				dominoNonJoue[i].setGauche(new Case(TerrainType.CHAMPS));
			}
			if (i == 9 || i == 10 || i == 14 || i == 17 || i == 20 || i == 28 || i == 35 || i == 36 || i == 40
					|| i == 41) {
				dominoNonJoue[i].setDroite(new Case(TerrainType.CHAMPS));
			}
			if (i == 11 || i == 45 || i == 46) {
				dominoNonJoue[i].setGauche(new Case(TerrainType.MONTAGNE));
			}
			if (i == 11 || i == 15 || i == 21 || i == 37 || i == 38 || i == 42 || i == 43) {
				dominoNonJoue[i].setDroite(new Case(TerrainType.MONTAGNE));
			}
			if (i == 39 || i == 44) {
				dominoNonJoue[i].setGauche(new Case(TerrainType.MINE));
			}
			if (i == 22 || i == 45 || i == 46 || i == 47) {
				dominoNonJoue[i].setDroite(new Case(TerrainType.MINE));
			}
			if (i >= 0 && i <= 17) {
				dominoNonJoue[i].setCouronneGauche(0);
				dominoNonJoue[i].setCouronneCaseRef(0);
			}
			if ((i >= 18 && i <= 34) || i == 39) {
				dominoNonJoue[i].setCouronneGauche(1);
				dominoNonJoue[i].setCouronneCaseRef(0);

			}
			if (i >= 35 && i <= 38) {
				dominoNonJoue[i].setCouronneGauche(0);
				dominoNonJoue[i].setCouronneCaseRef(1);

			}
			if ((i >= 40 && i <= 43) || i == 45 || i == 46) {
				dominoNonJoue[i].setCouronneGauche(0);
				dominoNonJoue[i].setCouronneCaseRef(2);
			}
			if (i == 44) {
				dominoNonJoue[i].setCouronneGauche(2);
				dominoNonJoue[i].setCouronneCaseRef(0);
			}
			if (i == 47) {

				dominoNonJoue[i].setCouronneGauche(0);
				dominoNonJoue[i].setCouronneCaseRef(3);
			}

			dominoNonJoue[i].setNombre(i + 1);

		}

	}

	// getter pour les dominos nonjoué
	
	public Tuiles[] getUnplayed() {
		return dominoNonJoue;
	}

	//On utilise desormais length() au lieu de dominoNonJoue.lenght
	public int length() {
		return dominoNonJoue.length;
	}

	// Permet de verifier s'il y a toujours des dominos dans la reserve
	
	public boolean isEmpty() {
		for (int i = 0; i < dominoNonJoue.length; i++) {
			if (dominoNonJoue[i].getJoué() == false) {
				return false;
			}
		}
		return true;
	}

}
