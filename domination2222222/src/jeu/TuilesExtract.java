package jeu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;


public class TuilesExtract {

    public static void main(String[] args) {
        ArrayList<Tuile> tuilesDoc = tuilesdoc();
        System.out.println(tuilesDoc);
    }


    public static ArrayList<Tuile> tuilesdoc() {
        ArrayList<Tuile> tuiles = new ArrayList<>();
        String dominoFile =  "resources/dominos.csv";
        //lire le document csv
        BufferedReader document = null;
        String ligne = "";
        String separation = ",";
        try {

            document = new BufferedReader(new FileReader(dominoFile));
            while ((ligne = document.readLine()) != null) {
                // Utiliser une virgule pour séparer
                String[] line = ligne.split(separation);
                Tuile domino = new Tuile(parseInt(line[0]),
                        line[1],
                        parseInt(line[2]),
                        line[3],
                        parseInt(line[4]));
                tuiles.add(domino);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return tuiles;
    }

}
