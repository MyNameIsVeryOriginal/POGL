import java.util.ArrayList;

public class Circuit {

    public static void main(String[] args) {
         Circuit c = new Circuit();
         Noeud n1 = c.creeMultiplication(c.creeConstante(2),c.creeEntree());
         c.sortie = n1;
         System.out.println("Ceci doit afficher 2 : " + c.calcule(1));
         System.out.println("Ceci doit afficher 12 : " + c.calcule(6));
         Noeud n2 = c.creeMultiplication(n1, c.creeAddition(c.creeConstante(1), n1));
         c.sortie = n2;
        System.out.println("Ceci doit afficher 6 : " + c.calcule(1));
        System.out.println("Ceci doit afficher 156 : " + c.calcule(6));
        //System.out.println("Ceci doit afficher 2 : " + c.nbNoeudsMult());
        //System.out.println("Ceci doit afficher 10 : " + c.nbOpEffectuees());
        // Circuit p20 = expRapide(20);
        // System.out.println("Ceci doit afficher 7 : " + p20.nbNoeudsMult());
        // System.out.println("Ceci doit afficher 1048576 : " + p20.calcule(2));
        // System.out.println("Ceci doit afficher 51 : " + p20.nbOpEffectuees());
        // Circuit p20m = expRapideMemoisee(20);
        // System.out.println("Ceci doit afficher 7 : " + p20m.nbNoeudsMult());
        // System.out.println("Ceci doit afficher 1048576 : " + p20m.calcule(2));
        // System.out.println("Ceci doit afficher 7 : " + p20m.nbOpEffectuees());
        // System.out.print("Ceci doit afficher ((2 * x) * (1 + (2 * x))) : ");
        // c.affiche();
    }

    /**
     * Valeur de la variable dont d�pend le calcul
     */ 
    private int entree;
    
    /**
     * Dernier noeud, calculant le r�sultat
     */
    private Noeud sortie;

    /**
     * Ensemble des noeuds
     */
    private ArrayList<Noeud> noeuds;

    /**
     * Constructeur.
     * N'initialise pas l'entr�e : la m�thode calcule s'en chargera avant
     * chaque calcul. La sortie n'est pas initialis�e non plus pour �viter
     * un probl�me de circularit�.
     */
    private Circuit() {
        this.noeuds = new ArrayList<Noeud>();
    }

    /**
     * Ajout d'un noeud � la liste
     * @param n Noeud � ajouter
     */
    private void ajouteNoeud(Noeud n) {
        noeuds.add(n);
    }


    // Cr�ation de noeuds avec ajout direct
    /**
     * Cr�ation d'un noeud de valeur constante
     * @param n Valeur calcul�e par le noeud
     */
    public Noeud creeConstante(int n) {
        Noeud c = new Constante(n);
        this.ajouteNoeud(c);
        return c;
    }

    /**
     * Donne la valeur de l'entr�e, dont auront besoin certains noeuds
     */
    public int litEntree() {
        return this.entree;
    }

    /**
     * Initialise la variable d'entr�e et calcule le r�sultat
     * @param e Valeur affect�e � la variable d'entr�e
     * @return Valeur calcul�e par le circuit
     */
    public int calcule(int e) {
        this.entree = e;
        return this.sortie.valeur();
    }

    /**
     * Construction d'un ensemble de noeuds utilisant la technique
     * d'exponentiation rapide
     * @param c Circuit auquel rattacher les noeuds cr��s
     * @param n Puissance calcul�e
     * @return Noeud principal
     */
    public static Noeud expRapide(Circuit c, int n) {
        if (n == 0) {
            // x^0 = 1
            return (c.creeConstante(1));
        } else if (n % 2 == 0) {
            // Si n pair, x^n = (x^{n/2})^2
            Noeud e = expRapide(c, n/2);
            return (c.creeMultiplication(e, e));
        } else {
            // Si n impair, x^n = x*((x^{n/2})^2)
            Noeud e = expRapide(c, n/2);
            return (c.creeMultiplication(c.creeEntree(),c.creeMultiplication(e, e)));
        }
    }
    /**
     * Construction d'un circuit utilisant la technique d'exponentiation rapide 
     * @param n Puissance calcul�e
     * @return Circuit calculant la n-�me puissance de sa variable d'entr�e
     */
    public static Circuit expRapide(int n) {
        // On cr�e d'abord un circuit vide...
        Circuit c = new Circuit();
        // puis on y ajoute des noeuds, et on connecte le dernier � la sortie.
        c.sortie = expRapide(c, n);
        return c;
    }

    Entree creeEntree(){
        return new Entree(this);
    }

    Addition creeAddition(Noeud n1, Noeud n2){
        return new Addition(n1, n2);
    }

    Multiplication creeMultiplication(Noeud n1, Noeud n2){
        return new Multiplication(n1,n2);
    }

}
