import java.awt.Color;
import IG.ZoneCliquable;

// 
// Decompiled by Procyon v0.5.36
// 

class Indice extends ZoneCliquable
{
    private Plateau plateau;
    
    public Indice(final Plateau plateau) {
        super("Indice", 80, 25);
        this.plateau = plateau;
    }
    
    public void clicGauche() {
        if (this.plateau.verifieResolubilite()) {
            this.setBackground(Color.GREEN);
            this.plateau.plateau[this.plateau.getIndiceL()][this.plateau.getIndiceC()].setBackground(Color.BLUE);
        }
        else {
            this.setBackground(Color.RED);
        }
    }
    
    public void clicDroit() {
    }
}
