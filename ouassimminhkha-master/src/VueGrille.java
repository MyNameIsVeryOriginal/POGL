import javax.swing.*;
import java.awt.*;
import java.util.*;


class VueGrille extends JPanel implements Observer {
    // reference vers le modele
    private Modele modele;
    
    // taille d'affichage des cellules
    private final static int TAILLE = 12;
    
    // constructeur
    public VueGrille(Modele modele){
        this.modele = modele;
        modele.addObserver(this);
        Dimension dim = new Dimension(TAILLE*modele.LARGEUR, TAILLE*modele.HAUTEUR);
        this.setPreferredSize(dim);
    }

    public void update() {
        // methode de reaffichage de la grille
        repaint();
    }

    // affichage de la cellule
    public void paint(Graphics g, Cellule c, int x, int y){
        if(c.etat ==0){
            g.setColor(Color.green);
        }else if( c.etat ==1){
            g.setColor(Color.blue);
        } else if(c.etat ==2){
            g.setColor(Color.BLACK);
        } else {
            g.setColor(Color.gray);
        }
        g.fillRect(x,y,TAILLE,TAILLE);
    }
    
    // fonction du dessin de la cellule
    public void paintCellule(Graphics graphics){
        super.repaint();
        for(int i = 1; i <modele.LARGEUR;i++){
            for(int j = 1; j<=modele.HAUTEUR;j++){
                paint(graphics,modele.getCellules(i,j),(i-1)*TAILLE, (j-1)*TAILLE);

            }
        }
    }

}
