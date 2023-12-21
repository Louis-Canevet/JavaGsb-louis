package gsb.vue.visiteur;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gsb.modele.Stocker;
import gsb.modele.Visiteur;
import gsb.service.StockerService;
import gsb.service.VisiteurService;

public class JIFVisiteurStock extends JInternalFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private ArrayList<Stocker> lesStocks;
	
	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JPanel pSaisie;
	protected JLabel JLcodeVisiteur;
	protected JComboBox<String> JCBmatricule;
	protected JButton JBafficherStock;
	protected JTable table;
	
	protected String[] columnNames = {"Code stock", "Nom Med", "Stock"};
	
	public JIFVisiteurStock() {
		
		ArrayList<Visiteur> lesVisiteurs = VisiteurService.collectionDesVisiteurs();
		int nbMatricule = lesVisiteurs.size();
		
		String[] lesMatricules = new String[nbMatricule];
		int k = 0;
		
		for (@SuppressWarnings("unused")
		Visiteur unVisiteur : lesVisiteurs) {
			lesMatricules[k] = lesVisiteurs.get(k).getMatricule();
			k++;
		}
		
		lesStocks = StockerService.collectionDesStocks();
		int nbLignes = lesStocks.size();
		
		p = new JPanel();
		
		int i = 0;
		String[][] data = new String[nbLignes][3];
		
		for(@SuppressWarnings("unused") Stocker unStock : lesStocks) {
			data[i][0] = "";
			data[i][1] = "";
			data[i][2] = "";
			i++;
		}
		
		DefaultTableModel  model = new DefaultTableModel(data, columnNames);
		table = new JTable(model);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400,200));
				
		pSaisie = new JPanel();
		
		JLcodeVisiteur = new JLabel("Code Visiteur");
		JLcodeVisiteur.setMaximumSize(JLcodeVisiteur.getPreferredSize());
		
		JCBmatricule = new JComboBox<>(lesMatricules);
		
		JBafficherStock = new JButton("Afficher");
		JBafficherStock.addActionListener(this);
		
		pSaisie.add(JLcodeVisiteur);
		pSaisie.add(JCBmatricule);
		pSaisie.add(JBafficherStock);
		
		p.add(pSaisie);
		p.add(scrollPane);
		setTitle("Stock Visiteur");
		
		Container contentPane = getContentPane();
		contentPane.add(p);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		if(source == JBafficherStock) {
			
			lesStocks = StockerService.collectionDesStocks();
			
			int nbLignes = lesStocks.size();
			
			int i = 0;
			int currFormLine = 0;
			
			String[][] updateData = new String[nbLignes][3];
			
			for(Stocker unStock2 : lesStocks) {
				
				if(lesStocks.get(i).getUnVisiteur().getMatricule().equals(JCBmatricule.getItemAt(JCBmatricule.getSelectedIndex()))) {
					
					updateData[currFormLine][0] = Integer.toString(unStock2.getCodeStock());
					updateData[currFormLine][1] = unStock2.getUnMedicament().getDepotLegal();
					updateData[currFormLine][2] = Integer.toString(unStock2.getQteStock());
					
					currFormLine++;
				}
				
				i++;
			}
			
			DefaultTableModel updateModel = new DefaultTableModel(updateData, columnNames);
			table.setModel(updateModel);
		}
	}

}
