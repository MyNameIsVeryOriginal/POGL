// 
// Decompiled by Procyon v0.5.36
// 

package IG;

import javax.swing.SwingUtilities;
import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public abstract class ZoneCliquable extends JPanel implements MouseListener
{
    private Texte texte;
    
    public ZoneCliquable(final int x, final int y) {
        this.setPreferredSize(new Dimension(x, y));
        this.addMouseListener(this);
        this.setBackground(Color.WHITE);
    }
    
    public ZoneCliquable(final String texte, final int x, final int y) {
        this(x, y);
        this.add(this.texte = new Texte(texte));
    }
    
    public void changeTexte(final String texte) {
        this.texte.changeTexte(texte);
    }
    
    protected abstract void clicGauche();
    
    protected abstract void clicDroit();
    
    @Override
    public void mouseClicked(final MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            this.clicDroit();
        }
        else {
            this.clicGauche();
        }
    }
    
    @Override
    public void mouseEntered(final MouseEvent e) {
    }
    
    @Override
    public void mouseExited(final MouseEvent e) {
    }
    
    @Override
    public void mousePressed(final MouseEvent e) {
    }
    
    @Override
    public void mouseReleased(final MouseEvent e) {
    }
}
