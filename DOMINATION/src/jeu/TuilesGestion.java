package jeu;

//Cette classe sauvegarde les donn�es dun domino (position type)

public class TuilesGestion {
	int x;
	int y;
	Tuiles aPlacer;
	String entete;
	public TuilesGestion(int x, int y, Tuiles aPlacer, String entete){
		this.x = x;
		this.y = y;
		this.aPlacer = aPlacer;
		this.entete = entete;
	}
}
