package jeu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

// On represente un domino dans cette classe, composé de 2 carrés ave chacun leur entete et position et situation (joué ou non)
public class Tuiles extends JPanel {

	private Case caseGauche;
	private Case caseRef;
	private int nombre;
	private boolean joué;
	private boolean choisi;

	public Tuiles() {
		joué = false;
		choisi = false;
	}
	

	public void setJoué() {
		joué = true;
	}

	public boolean getJoué() {
		return joué;
	}

	public void setChoisi() {
		choisi = true;
	}

	public boolean estChoisi() {
		return choisi;
	}
	public void printADomino() {
		System.out.println(caseGauche.getNom() + "" + caseGauche.getCouronnes() + " "
				+ caseRef.getNom() + "" + caseRef.getCouronnes() + " " + nombre);
	}

	public void setGauche(Case caseGauche) {
		this.caseGauche = caseGauche;
	}

	public void setDroite(Case caseRef) {
		this.caseRef = caseRef;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public Case getCaseRef() {
		return caseRef;
	}
	public Case getCaseGauche(){
		return caseGauche;
	}

	public void setCouronneGauche(int nb) {
		caseGauche.setCouronnes(nb);
	}

	public void setCouronneCaseRef(int nb) {
		caseRef.setCouronnes(nb);
	}

	public int getCouronneCaseGauche() {
		return caseGauche.getCouronnes();
	}

	public int getCouronneCaseRef() {
		return caseRef.getCouronnes();
	}

	public int getNombre() {
		return nombre;
	}

//	public void paintComponent(Graphics g) {
//
//		super.paintComponent(g);
//		Graphics2D g2 = (Graphics2D) g;
//
//		g2.setFont(new Font("TimesRoman", Font.BOLD, 20));
//		caseGauche.setBounds(0, 0, 50, 50);
//		g2.setColor(caseGauche.getColor());
//		g2.fill(caseGauche);
//		g2.setColor(complementaryColor(g2.getColor()));
//		g2.drawString(caseGauche.getCrownsString(), 5, 50);
//		g.setColor(Color.black);
//		g.drawRect(0, 0, 50, 50);
//
//		caseRef.setBounds(50, 0, 50, 50);
//		g2.setColor(caseRef.getColor());
//		g2.fill(caseRef);
//		g2.setColor(complementaryColor(g2.getColor()));
//		g2.drawString(caseRef.getCrownsString(), 55, 50);
//		g.setColor(Color.black);
//		g.drawRect(50, 0, 50, 50);
//
//	}
//
//	private static Color complementaryColor(Color color) {
//		double y = (299 * color.getRed() + 587 * color.getGreen() + 114 * color.getBlue()) / 1000;
//		return y >= 128 ? Color.black : Color.white;
//	}

}
