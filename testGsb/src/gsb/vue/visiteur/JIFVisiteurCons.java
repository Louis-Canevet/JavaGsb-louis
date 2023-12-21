package gsb.vue.visiteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import gsb.modele.Visiteur;
import gsb.service.VisiteurService;

public class JIFVisiteurCons extends JIFVisiteur implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JButton premier;
	private JButton suivant;
	private JButton precedent;
	private JButton dernier;
	
	private ArrayList<Visiteur> lesVisiteurs;
	private int indiceEnCours;
	
	public JIFVisiteurCons() {
		
		super();
		
		premier = new JButton("Premier");
		pBoutons.add(premier);
		precedent = new JButton("Précedent");
		pBoutons.add(precedent);
		suivant = new JButton("Suivant");
		pBoutons.add(suivant);
		dernier = new JButton("Dernier");
		pBoutons.add(dernier);

		premier.addActionListener(this);
		suivant.addActionListener(this);
		precedent.addActionListener(this);
		dernier.addActionListener(this);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("Consultation données Visiteur");
		
		lesVisiteurs = VisiteurService.collectionDesVisiteurs();
		indiceEnCours = 0;
		
		if (lesVisiteurs.size() !=0) {
			Visiteur unVisiteur = lesVisiteurs.get(0);
			remplirText(unVisiteur);
		}
		
		addInternalFrameListener(new InternalFrameAdapter() {
			
			public void internalFrameClosing(InternalFrameEvent e) {
				
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();

		if (source == premier) {
			indiceEnCours = 0;
			Visiteur unVisiteur = lesVisiteurs.get(indiceEnCours);
			remplirText(unVisiteur);
		} else if (source == dernier) {
			indiceEnCours = lesVisiteurs.size() - 1;
			Visiteur unVisiteur = lesVisiteurs.get(indiceEnCours);
			remplirText(unVisiteur);
		} else if (source == precedent) {
			if (indiceEnCours > 0)
				indiceEnCours = indiceEnCours - 1;
			Visiteur unVisiteur = lesVisiteurs.get(indiceEnCours);
			remplirText(unVisiteur);
		} else if (source == suivant) {
			if (indiceEnCours < (lesVisiteurs.size() - 1))
				indiceEnCours = indiceEnCours + 1;
			Visiteur unVisiteur = lesVisiteurs.get(indiceEnCours);
			remplirText(unVisiteur);
		}
	}

}
