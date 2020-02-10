class Addition extends NoeudBinaire{
    private Noeud source1;
    private Noeud source2;
    private String s = "+";

    Addition(Noeud n1,Noeud n2,String){
        this.source1 = n1;
        this.source2 = n2;
    }

    public int valeur(){
        return this.source1.valeur()+this.source2.valeur();
    }

}