import java.awt.Color;
import IG.ZoneCliquable;

// 
// Decompiled by Procyon v0.5.36
// 

class Validation extends ZoneCliquable
{
    private Plateau plateau;
    
    public Validation(final Plateau plateau) {
        super("Valider", 80, 25);
        this.plateau = plateau;
    }
    
    public void clicGauche() {
        if (this.plateau.verifieConfiguration()) {
            this.setBackground(Color.GREEN);
        }
        else {
            this.setBackground(Color.RED);
        }
    }
    
    public void clicDroit() {
    }
}
