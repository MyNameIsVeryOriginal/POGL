// 
// Decompiled by Procyon v0.5.36
// 

package IG;

import java.awt.Component;
import javax.swing.JComponent;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class Grille extends JPanel
{
    public Grille(final int hauteur, final int largeur) {
        this.setLayout(new GridLayout(hauteur, largeur, 5, 5));
    }
    
    public void ajouteElement(final JComponent element) {
        this.add(element);
    }
}
