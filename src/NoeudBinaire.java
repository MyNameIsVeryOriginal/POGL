abstract class NoeudBinaire extends Noeud {
    protected Noeud source1;
    protected Noeud source2;
    protected String op;

    public int valeurSource1(){
        return this.source1.valeur();
    }

    public int valeurSource2(){
        return this.source2.valeur();
    }

    public void affiche(){
        System.out.println("( " + valeurSource1() + " " + valeurSource2() + " ) = ");
    }

}
