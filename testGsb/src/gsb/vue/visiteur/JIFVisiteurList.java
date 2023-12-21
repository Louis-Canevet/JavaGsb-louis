package gsb.vue.visiteur;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import gsb.modele.Visiteur;
import gsb.service.VisiteurService;
import gsb.vue.MenuPrincipal;

public class JIFVisiteurList extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Visiteur> lesVisiteurs;
	
	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JPanel pSaisie;
	protected JTextField JTcodeVisiteur;
	protected JButton JBafficherFiche;
	protected MenuPrincipal fenetreContainer;

	public JIFVisiteurList(MenuPrincipal uneFenetreContainer) {
		
		fenetreContainer = uneFenetreContainer;
		lesVisiteurs = VisiteurService.collectionDesVisiteurs();
		int nbLignes = lesVisiteurs.size();
		
		JTable table;
		
		p = new JPanel();
		
		int i = 0;
		String[][] data = new String[nbLignes][3];
		
		for (Visiteur unVisiteur : lesVisiteurs) {
			data[i][0] = unVisiteur.getMatricule();
			data[i][1] = unVisiteur.getNom();
			data[i][2] = unVisiteur.getPrenom();
			i++;
		}
		
		String[] columnNames = {"Matricule", "Nom", "Prénom"};
		
		table = new JTable(data, columnNames) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		
		table.setFocusable(false);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2 && table.getSelectedColumn() == 0) {
					JTable target = (JTable) e.getSource();
					int row = target.getSelectedRow();
					int column = target.getSelectedColumn();
					
					JTcodeVisiteur.setText((String) table.getValueAt(row, column));
				}
			}
			
		});
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400,200));
		p.add(scrollPane);
		
		pSaisie = new JPanel();
		JTcodeVisiteur = new JTextField(20);
		JTcodeVisiteur.setMaximumSize(JTcodeVisiteur.getPreferredSize());
		JBafficherFiche = new JButton("Afficher Fiche Visiteur");
		JBafficherFiche.addActionListener(this);
		pSaisie.add(JTcodeVisiteur);
		pSaisie.add(JBafficherFiche);
		p.add(pSaisie);
		setTitle("Liste Visiteur");
		
		Container contentPane = getContentPane();
		contentPane.add(p);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		if(source == JBafficherFiche) {
			Visiteur unVisiteur = VisiteurService.rechercherVisiteur(JTcodeVisiteur.getText());
			if(unVisiteur != null) {
				fenetreContainer.ouvrirFenetre(new JIFVisiteurFiche(unVisiteur));
			}
		}
		
	}

}
