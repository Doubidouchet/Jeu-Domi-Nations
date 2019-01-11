package jeu;

import java.util.Random;

//Cette classe se d�roule pendant un tour

public class JoueurTour {
	private TuilesExtract reserve = new TuilesExtract();
	private Tuiles[] rsvPlateau;
	
	public void choixDuTour(int x){
		rsvPlateau = new Tuiles[x];
	}
	
	public Tuiles[] getRsvPlateau(){
		return rsvPlateau;
	}
	
	public void setRsvPlateau(){
		// on creer la reserve
		for (int i = 0; i < rsvPlateau.length; i++){
			rsvPlateau[i] = donneRandomDomino();
		}
		 for (int i = 0; i < rsvPlateau.length - 1; i++)
	        {
	            int index = i;
	            for (int j = i + 1; j < rsvPlateau.length; j++)
	                if (rsvPlateau[j].getNombre() < rsvPlateau[index].getNombre()) 
	                    index = j;
	      
	            Tuiles petitDomino = rsvPlateau[index];  
	            rsvPlateau[index] = rsvPlateau[i];
	            rsvPlateau[i] = petitDomino;
	        }
		
	}
	
	// Donne un domino aleatoire dans le tour
	
	public Tuiles donneRandomDomino() {
		
		Tuiles leTour = new Tuiles();
		boolean trouv� = true;
		
		while (trouv�) {
			int rdom = new Random().nextInt(reserve.length() - 1);
			if (reserve.getUnplayed()[rdom].getJou�() == false) {
				leTour = reserve.getUnplayed()[rdom];
				reserve.getUnplayed()[rdom].setJou�();
				trouv� = false;
			}
		}
		return leTour;
	}
}
