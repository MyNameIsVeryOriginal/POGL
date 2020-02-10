class Constante extends Noeud{

    private int cst;

    public Constante(int c){
        this.cst = c;
    }
    public int valeur(){
        return this.cst;
    }
}