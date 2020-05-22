import javax.swing.*;

public class VueCommandes extends JPanel {
    private  Modele modele;

    public VueCommandes(Modele modele){
        this.modele = modele;

        JButton boutonAction = new JButton(">");
        this.add(boutonAction);

        Controleur controleur = new Controleur(modele);
    }


}
