package jeu;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;
import java.awt.* ;
import java.net.SocketOption ;

public class GestionGraphiqueJeu {

    // Fonction du menu principal, retourne le nombre de joueurs de la partie
        int  Menu () {

            Font font1 =  new  Font( " Arial " , 1 , 45 );
            Font font2 =  new  Font( " Arial " , 1 , 20 );

            // Titre
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.setFont (font1);
            StdDraw.text(0.5 , 0.8 , " DomiNation ");

            // Boutons
            StdDraw.setFont(font2);
            StdDraw.setPenRadius(0.01);
            
            // 2 joueurs
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledRectangle(0,2 , 0,5);
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.text(0.2 , 0.5 , " 2 joueurs ");
            
            // 3 joueurs
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledRectangle(0,5 , 0,5);
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.text(0.5 , 0.5 , " 3 joueurs ");
            
            // 4 joueurs
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledRectangle(0,8 , 0,5);
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.text(0.8 , 0.5 , " 4 joueurs ");

            while ( true ) {

                if (StdDraw.mouseX() >=  0.1  &&  StdDraw.mouseX() <=  0.3  &&  StdDraw.mouseY() >=  0.45  &&  StdDraw.mouseY() <=  0.55 ) {
                    if (StdDraw.isMousePressed()) {
                        return  2 ;
                    }
                }
                else  if (StdDraw.mouseX() >=  0.4  &&  StdDraw.mouseX() <=  0.6  &&  StdDraw.mouseY() >=  0.45  &&  StdDraw.mouseY() <=  0.55 ) {
                    if ( StdDraw.isMousePressed()) {
                        return  3 ;
                    }
                }
                else  if (StdDraw.mouseX() >=  0.7  &&  StdDraw.mouseX() <=  0.9  &&  StdDraw.mouseY() >=  0.45  &&  StdDraw.mouseY() <=  0.55 ) {
                    if (StdDraw.isMousePressed()) {
                        return  4 ;
                    }
                }

            }

        }

        public  static  void  main ( String [] args ) {
        }
}

