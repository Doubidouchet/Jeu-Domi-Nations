package jeu;

import java.awt.*;

public class SetColor {

    Color rouge = new Color(255, 0 , 0);
    Color foret = new Color(255 - 0 - 0);
    Color jaune = new Color(255 - 255 - 0);
    Color champs = new Color(255 - 255 - 0);
    Color vert = new Color(34 - 139 - 34);
    Color prairie = new Color(34 - 139 - 34);
    Color bleu = new Color(0 - 191 - 255);
    Color mer = new Color(0 - 191 - 255);
    Color marron = new Color(139 - 69 - 19);
    Color montagne = new Color(139 - 69 - 19);
    Color gris = new Color(190 - 190 - 190);
    Color mine = new Color(190 - 190 - 190);
    Color rose = new Color(255 - 105 - 180);

    Color[] getKingColors() {
        Color[] colors = {jaune,vert,bleu,rose};
        return colors;
    }


}
