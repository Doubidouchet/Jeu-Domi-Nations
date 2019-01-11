package jeu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.*;

//Cette class repr�sente les carr�s que occupe chaque domino. Chaque carr� est un type diff�rent
public class Case extends Rectangle {

	private int couronnes;

	private String nom;
	private Color theColor;
	private boolean estCompt� = false;
	public enum TerrainType {
	PRAIRIE, MINE, MER, MONTAGNE, CHAMPS, FORET, CHATEAU, BLANK, HORSMAP;
	}

	public Case(TerrainType terrainType) {

		switch (terrainType) {
		
		case PRAIRIE:
			nom = "P";
			theColor = Color.YELLOW;
			break;
		
		case MINE:
			nom = "M";
			theColor = Color.BLACK;
			break;
		
		case MER:
			nom = "E";
			theColor = Color.BLUE;
			break;
	
		case MONTAGNE:
			nom = "O";
			theColor = Color.GRAY;
			break;
			
		case CHAMPS:
			nom = "H";
			theColor = Color.GREEN;
			break;
			
		case FORET:
			nom = "F";
			theColor = new Color(0x004d00);
			break;
			
		case CHATEAU:
			nom = "C";
			theColor = Color.PINK;
			break;

		case BLANK:
			 nom = ":";
			theColor = Color.WHITE;
			 break;
		
		case HORSMAP:
			nom = "X";
			break;

		}
	}
	
	public Color getColor() {
		return theColor;
	}

	public String getNom() {
		return nom;
	}

	public void setCouronnes(int crowns) {
		this.couronnes = crowns;
	}

	public int getCouronnes() {
		return couronnes;
	}

	public String getCouronneString() {
		return Integer.toString(couronnes);
	}
	public boolean estCompt�() {
		return estCompt�;
	}
	public void setEstCompt�(boolean estCompt�) {
		this.estCompt� = estCompt�;
	}
	
	

}
