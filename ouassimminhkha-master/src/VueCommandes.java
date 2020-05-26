import javax.swing.*;

public class VueCommandes extends JPanel {
    private Modele modele;      // reference au modele 

    public VueCommandes(Modele modele){
        this.modele = modele;

        JButton boutonAction = new JButton("fin de tour");  //creation d'un bouton 
        this.add(boutonAction);                             // ajout au panneau de boutons
        JButton boutonHaut = new JButton("haut");
        this.add(boutonHaut);
        JButton boutonBas = new JButton("bas");
        this.add(boutonBas);
        JButton boutonGauche = new JButton("Gauche");
        this.add(boutonGauche);
        JButton boutonDroit = new JButton("droit");
        this.add(boutonDroit);

        //Enregistrement du controleur 
        Controleur controleur = new Controleur(modele);
        //Enregistrement du controleur comme auditeur du bouton
        boutonAction.addActionListener(controleur);
        boutonHaut.addActionListener(controleur);
        boutonBas.addActionListener(controleur);
        boutonGauche.addActionListener(controleur);
        boutonDroit.addActionListener(controleur);

    }



}
