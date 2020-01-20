// 
// Decompiled by Procyon v0.5.36
// 

package IG;

import javax.swing.JComponent;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Fenetre extends JFrame
{
    private JPanel elements;
    
    public Fenetre(final String nom) {
        super(nom);
        this.add(this.elements = new JPanel());
    }
    
    public void ajouteElement(final JComponent element) {
        this.elements.add(element);
    }
    
    public void dessineFenetre() {
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
    }
}
