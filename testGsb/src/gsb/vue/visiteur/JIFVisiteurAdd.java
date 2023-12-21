package gsb.vue.visiteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gsb.modele.Localite;
import gsb.modele.Visiteur;
import gsb.service.LocaliteService;
import gsb.service.VisiteurService;

public class JIFVisiteurAdd extends JIFVisiteur implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JButton add;
    private JLabel JLlogin;
    private JLabel JLmdp;
    private JLabel JLcodePostal;
    private JTextField JTlogin;
    private JPasswordField JPmdp;
    private JComboBox<String> comboBoxCodePostal; // Ajoutez une JComboBox pour les codes postaux

    public JIFVisiteurAdd() {

        super();

        JLlogin = new JLabel("Login");
        JLmdp = new JLabel("Mot de passe");
        JLcodePostal = new JLabel("Code postal");

        JTlogin = new JTextField(20);
        JPmdp = new JPasswordField(1);

        comboBoxCodePostal = new JComboBox<>();

        // Remplire la JComboBox avec les codes postaux existants
        ArrayList<String> codesPostaux = LocaliteService.retournerListeCodePostaux();
        for (String codePostal : codesPostaux) {
            comboBoxCodePostal.addItem(codePostal);
        }

        pTexte.add(JLcodePostal);
        pTexte.add(comboBoxCodePostal);

        pTexte.add(JLlogin);
        pTexte.add(JTlogin);

        pTexte.add(JLmdp);
        pTexte.add(JPmdp);

        add = new JButton("Ajouter");
        add.addActionListener(this);

        pBoutons.add(add);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Ajout données Visiteur");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source == add) {
            if (new String(JPmdp.getPassword()).length() >= 8) {
            	Localite loc = LocaliteService.rechercherLocalite((String) comboBoxCodePostal.getSelectedItem());
            	String codePostalSelectionne = loc.getCodePostal();
            	//String codePostalSelectionne = (String) comboBoxCodePostal.getSelectedItem();

            	Visiteur visiteur = new Visiteur(
            		    JTmatricule.getText(),
            		    JTnom.getText(),
            		    JTprenom.getText(),
            		    JTlogin.getText(),
            		    new String(JPmdp.getPassword()),
            		    JTadresse.getText(),
            		    loc, // Utilisez l'objet Localite ici
            		    JTtelephone.getText(),
            		    JTdateEntree.getText(),
            		    Integer.parseInt(JTprime.getText()),
            		    JTcodeUnite.getText(),
            		    JTnomUnite.getText()
            		);

                VisiteurService.creerVisiteur(visiteur);
                viderText();
                JTlogin.setText("");
                JPmdp.setText("");
            } else {
                System.out.println("Password not long enough");
            }

        }
    }
}
