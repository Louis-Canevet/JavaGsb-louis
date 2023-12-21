package gsb.vue.visiteur;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gsb.modele.Visiteur;

public class JIFVisiteur extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	protected JPanel p;
	protected JPanel pTexte;
	protected JPanel pBoutons;

	protected JLabel JLmatricule;
	protected JLabel JLnom;
	protected JLabel JLprenom;
	protected JLabel JLtelephone;
	protected JLabel JLadresse;
	protected JLabel JLdateEntree;
	protected JLabel JLprime;
	protected JLabel JLcodeUnite;
	protected JLabel JLnomUnite;

	protected JTextField JTmatricule;
	protected JTextField JTnom;
	protected JTextField JTprenom;
	protected JTextField JTtelephone;
	protected JTextField JTadresse;
	protected JTextField JTdateEntree;
	protected JTextField JTprime;
	protected JTextField JTcodeUnite;
	protected JTextField JTnomUnite;
	
	public JIFVisiteur() {
		
		p = new JPanel();
		pBoutons = new JPanel();
		pTexte = new JPanel(new GridLayout(12,2));
		
		JLmatricule = new JLabel("Matricule");
		JLnom = new JLabel("Nom");
		JLprenom = new JLabel("Prénom");
		JLadresse = new JLabel("Adresse");
		JLtelephone = new JLabel("Téléphone");
		
		JLdateEntree = new JLabel("Date entrée");
		JLprime = new JLabel("Prime");
		JLcodeUnite = new JLabel("Code Unite");
		JLnomUnite = new JLabel("Nom Unite");
		
		JTmatricule = new JTextField(20);
		JTnom = new JTextField(1);
		JTprenom = new JTextField(1);
		JTtelephone = new JTextField(1);
		JTadresse = new JTextField(1);
		JTdateEntree = new JTextField(1);
		JTprime = new JTextField(1);
		JTcodeUnite = new JTextField(1);
		JTnomUnite = new JTextField(1);
		
		pTexte.add(JLmatricule);
		pTexte.add(JTmatricule);
		
		pTexte.add(JLnom);
		pTexte.add(JTnom);
		
		pTexte.add(JLprenom);
		pTexte.add(JTprenom);
		
		pTexte.add(JLadresse);
		pTexte.add(JTadresse);
		
		pTexte.add(JLtelephone);
		pTexte.add(JTtelephone);
				
		pTexte.add(JLdateEntree);
		pTexte.add(JTdateEntree);
		
		pTexte.add(JLprime);
		pTexte.add(JTprime);
		
		pTexte.add(JLcodeUnite);
		pTexte.add(JTcodeUnite);
		
		pTexte.add(JLnomUnite);
		pTexte.add(JTnomUnite);
		
		p.add(pTexte);
		p.add(pBoutons);
		
		Container contentPane = getContentPane();
		contentPane.add(p);
	}
	
	public void remplirText(Visiteur unVisiteur) {
		
		JTmatricule.setText(unVisiteur.getMatricule());
		JTnom.setText(unVisiteur.getNom());
		JTprenom.setText(unVisiteur.getPrenom());
		JTadresse.setText(unVisiteur.getAdresse());
		JTtelephone.setText(unVisiteur.getTelephone());
		JTdateEntree.setText(unVisiteur.getDateEntree());
		JTprime.setText(Integer.toString(unVisiteur.getPrime()));
		JTcodeUnite.setText(unVisiteur.getCodeUnite());
		JTnomUnite.setText(unVisiteur.getNomUnite());
	}
	
	public void viderText() {
		
		JTmatricule.setText("");
		JTnom.setText("");
		JTprenom.setText("");
		JTtelephone.setText("");
		JTadresse.setText("");
		JTdateEntree.setText("");
		JTprime.setText("");
		JTcodeUnite.setText("");
		JTnomUnite.setText("");
	}
}
