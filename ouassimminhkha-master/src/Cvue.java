import javax.swing.*;
import java.awt.*;

public class Cvue {
    private JFrame frame;
    private VueGrille grille;
    private VueCommandes Commandes;

    public Cvue(Modele modele) {
        frame = new JFrame();
        frame.setTitle("Jeu de L'ile interdite");   //setup du titre de la fenetre
        frame.setLayout(new FlowLayout());          

        // definition des 2 vues et ajout a la fenetre de jeu principale
        grille = new VueGrille(modele);
        frame.add(grille);
        Commandes = new VueCommandes(modele);
        frame.add(Commandes);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    // fermeture de la fenetre et FERMETURE de l'application en arriere plan CONTRAIREMENT A EXIt_ON_CLOSE
        frame.setVisible(true);     // precisons que la fenetre doit bien apparaitre a l ecran
    }
}

