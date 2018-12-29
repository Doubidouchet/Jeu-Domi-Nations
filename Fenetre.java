package Jeu;

import javax.swing.JFrame;

public class Fenetre {
	public JFrame f;
	
	public Fenetre() {
		
		f=new JFrame();
		f.setTitle("Domi'Nations"); //on indique le titre de la fenêtre 
		f.setSize(1280, 1280/16*9);  //on indique la taille de la fenêtre
		f.setLocationRelativeTo(null); //on place au centre la fenêtre
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //on indique la fermeture de la fenêtre
		f.setVisible(true); //on rend visible la fenêtre
	}

}
