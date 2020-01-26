import javax.swing.JComponent;
import IG.Grille;

// 
// Decompiled by Procyon v0.5.36
// 

class Plateau extends Grille
{
    private static int taille;
    public Case[][] plateau;
    private int indiceL;
    private int indiceC;
    
    public Plateau(final int taille) {
        super(taille, taille);
        Plateau.taille = taille;
        this.plateau = new Case[taille][taille];
        for (int i = 0; i < taille; ++i) {
            for (int j = 0; j < taille; ++j) {
                final Case c = new Case(this);
                this.ajouteElement(this.plateau[i][j] = c);
            }
        }
    }
    
    private int compteLigne(final Case[] l) {
        int nb = 0;
        for (final Case c : l) {
            if (c.estOccupee()) {
                ++nb;
            }
        }
        return nb;
    }
    
    private boolean verifieLignes() {
        boolean ok = true;
        Case[][] plateau;
        for (int length = (plateau = this.plateau).length, i = 0; i < length; ++i) {
            final Case[] l = plateau[i];
            ok = (ok && this.compteLigne(l) < 2);
        }
        return ok;
    }
    
    private int compteColonne(final int j) {
        int nb = 0;
        for (int i = 0; i < Plateau.taille; ++i) {
            if (this.plateau[i][j].estOccupee()) {
                ++nb;
            }
        }
        return nb;
    }
    
    private boolean verifieColonnes() {
        boolean ok = true;
        for (int j = 0; j < Plateau.taille; ++j) {
            ok = (ok && this.compteColonne(j) < 2);
        }
        return ok;
    }
    
    private int compteDiagonale(final int k) {
        int nb = 0;
        int min;
        int max;
        if (k < 0) {
            min = -k;
            max = Plateau.taille;
        }
        else {
            min = 0;
            max = Plateau.taille - k;
        }
        for (int i = min; i < max; ++i) {
            if (this.plateau[i][i + k].estOccupee()) {
                ++nb;
            }
        }
        return nb;
    }
    
    private boolean verifieDiagonales() {
        boolean ok = true;
        for (int k = 2 - Plateau.taille; k < Plateau.taille - 1; ++k) {
            ok = (ok && this.compteDiagonale(k) < 2);
        }
        return ok;
    }
    
    private int compteAntidiagonale(final int k) {
        int nb = 0;
        int min;
        int max;
        if (k < 0) {
            min = -k;
            max = Plateau.taille;
        }
        else {
            min = 0;
            max = Plateau.taille - k;
        }
        for (int i = min; i < max; ++i) {
            if (this.plateau[Plateau.taille - 1 - i][i + k].estOccupee()) {
                ++nb;
            }
        }
        return nb;
    }
    
    private boolean verifieAntidiagonales() {
        boolean ok = true;
        for (int k = 2 - Plateau.taille; k < Plateau.taille - 1; ++k) {
            ok = (ok && this.compteAntidiagonale(k) < 2);
        }
        return ok;
    }
    

    public boolean verifieConfiguration() {
        return this.verifieLignes() && this.verifieColonnes() && this.verifieDiagonales() && this.verifieAntidiagonales();
    }
    private int prochaineLigne() {
        int k;
        for (k = 0; k < Plateau.taille && this.compteLigne(this.plateau[k]) != 0; ++k) {}
        return k;
    }
    
    public int getIndiceL() {
        return this.indiceL;
    }
    
    public int getIndiceC() {
        return this.indiceC;
    }
    
    public boolean verifieResolubilite() {
        if (!this.verifieConfiguration()) {
            return false;
        }
        final int l = this.prochaineLigne();
        if (l == Plateau.taille) {
            return true;
        }
        boolean solutionTrouvee = false;
        for (int c = 0; c < Plateau.taille && !solutionTrouvee; ++c) {
            this.plateau[l][c].occupe();
            solutionTrouvee = this.verifieResolubilite();
            this.plateau[l][c].libere();
            this.indiceC = c;
        }
        this.indiceL = l;
        return solutionTrouvee;
    }
}
