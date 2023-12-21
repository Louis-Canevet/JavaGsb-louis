package gsb.vue.visiteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gsb.modele.Visiteur;

public class JIFVisiteurFiche extends JIFVisiteur implements ActionListener{

	private static final long serialVersionUID = 1L;
	protected JButton close;

	public JIFVisiteurFiche(Visiteur unVisiteur) {
		
		super();
		close = new JButton("Fermer");
		close.addActionListener(this);
		pBoutons.add(close);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("Fiche Visiteur");
		this.remplirText(unVisiteur);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		if(source == close) {
			dispose();
		}
	}

}
