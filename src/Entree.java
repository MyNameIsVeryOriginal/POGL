class Entree extends Noeud{
    Circuit circuit;

    Entree(Circuit c){
        this.circuit = c;
    }

    public int valeur() {
        return this.circuit.litEntree();
    }

}