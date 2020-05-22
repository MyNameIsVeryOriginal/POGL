public class Cellule {

    private Modele modele;
    protected enum etat{
        normal,
        inonde,
        submerge,
    } /** 3 etats possibles : normal 0,inonde 1,submerge 2 */
    private int x,y;

    public Cellule(Modele modele, int x, int y){
        this.modele = modele;
        this.x = x;
        this.y = y;
        etat e1 = etat.normal;
        etat e2 = etat.inonde;
        etat e3 = etat.submerge;

    }

    public void assecher(){
        // attribut des joueurs courant , numero d'action courante, 2 variables centrales qui voient qui s'occupe de quoi
        // faire tout ca dans le controleur, etat ds controleur, 6 etats possibles au total

    }

}
