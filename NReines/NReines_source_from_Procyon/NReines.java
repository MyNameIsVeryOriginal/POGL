import javax.swing.JComponent;
import IG.Fenetre;

// 
// Decompiled by Procyon v0.5.36
// 

public class NReines
{
    public static void main(final String[] args) {
        final int nb = Integer.parseInt(args[0]);
        final Fenetre fenetre = new Fenetre(String.valueOf(nb) + " reines");
        final Plateau plateau = new Plateau(nb);
        final Validation validation = new Validation(plateau);
        final Indice indice = new Indice(plateau);
        fenetre.ajouteElement(plateau);
        fenetre.ajouteElement(validation);
        fenetre.ajouteElement(indice);
        fenetre.dessineFenetre();
    }
}
