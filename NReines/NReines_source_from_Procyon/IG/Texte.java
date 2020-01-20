// 
// Decompiled by Procyon v0.5.36
// 

package IG;

import javax.swing.JLabel;

public class Texte extends JLabel
{
    public Texte() {
        super("");
    }
    
    public Texte(final String texte) {
        super(texte);
    }
    
    public void changeTexte(final String texte) {
        this.setText(texte);
        this.repaint();
    }
}
