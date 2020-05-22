import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cvue {
    private JFrame frame;
    private VueGrille grille;
    private VueCommandes commandes;

    public Cvue(Modele modele) {
        frame = new JFrame();
        frame.setTitle("Jeu de L'ile interdite");
        frame.setLayout(new FlowLayout());

        grille = new VueGrille(modele);
        frame.add(grille);
        commandes = new VueCommandes(modele);
        frame.add(commandes);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}

