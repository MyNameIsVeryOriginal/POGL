import java.awt.Color;
import IG.ZoneCliquable;

// 
// Decompiled by Procyon v0.5.36
// 

class Case extends ZoneCliquable
{
    private boolean occupee;
    private Plateau plateau;
    
    public Case(final Plateau plateau) {
        super(40, 40);
        this.occupee = false;
        this.plateau = plateau;
    }
    
    public boolean estOccupee() {
        return this.occupee;
    }
    
    public void occupe() {
        this.occupee = true;
    }
    
    public void libere() {
        this.occupee = false;
    }
    
    public void clicGauche() {
        this.occupee = !this.occupee;
        if (this.occupee) {
            this.setBackground(Color.BLACK);
        }
        else {
            this.setBackground(Color.WHITE);
        }
    }
    
    public void clicDroit() {
    }
}
