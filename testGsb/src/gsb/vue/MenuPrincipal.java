package gsb.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import gsb.vue.visiteur.JIFVisiteurAdd;
import gsb.vue.visiteur.JIFVisiteurCons;
import gsb.vue.visiteur.JIFVisiteurDel;
import gsb.vue.visiteur.JIFVisiteurList;
import gsb.vue.visiteur.JIFVisiteurStock;

public class MenuPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 2591453837113855452L;

	protected JInternalFrame myJInternalFrame;
	protected JDesktopPane desktopPane;
	protected JMenuBar mbar;
	protected JMenu mVisiteur;

	public MenuPrincipal() {

		myJInternalFrame = new JInternalFrame();
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.decode("#0561b"));
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);

		setTitle("GSB");
		setSize(600, 500);

		mbar = new JMenuBar();

		JMenuItem mV1 = new JMenuItem("Consultation Visiteur");
		mV1.addActionListener(this);
		mbar.add(mV1);
		
		JMenuItem mV2 = new JMenuItem("Liste Visiteur");
		mV2.addActionListener(this);
		mbar.add(mV2);
		
		JMenuItem mV3 = new JMenuItem("Ajout Visiteur");
		mV3.addActionListener(this);
		mbar.add(mV3);
		
		JMenuItem mV4 = new JMenuItem("Suppression Visiteur");
		mV4.addActionListener(this);
		mbar.add(mV4);
		
		JMenuItem mV5 = new JMenuItem("Stock Visiteur");
		mV5.addActionListener(this);
		mbar.add(mV5);
		
		setJMenuBar(mbar);

		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {

		if (evt.getSource() instanceof JMenuItem) {
			String ChoixOption = evt.getActionCommand();

	        System.out.println("ChoixOption : " + ChoixOption);

			if (ChoixOption.equals("Consultation Visiteur")) {
	            System.out.println("Consultation Visiteur");
				ouvrirFenetre(new JIFVisiteurCons());
				}
				else if (ChoixOption.equals("Liste Visiteur")) {
		            System.out.println("Liste Visiteur");
					ouvrirFenetre(new JIFVisiteurList(this));
				} 
				else if (ChoixOption.equals("Ajout Visiteur")) {
		            System.out.println("Ajout Visiteur");
					ouvrirFenetre(new JIFVisiteurAdd());
				}
				else if (ChoixOption.equals("Suppression Visiteur")) {
		            System.out.println("Suppression Visiteur");
					ouvrirFenetre(new JIFVisiteurDel());
				}
				else if (ChoixOption.equals("Stock Visiteur")) {
					System.out.println("Stock Visiteur");
					ouvrirFenetre(new JIFVisiteurStock());
				}
			}
		}
	

	public void ouvrirFenetre(JInternalFrame uneFenetre) {
	    System.out.println("Ouverture de la fenêtre"); // Ajoutez cette ligne

		myJInternalFrame.dispose();

		myJInternalFrame = uneFenetre;
		myJInternalFrame.setVisible(true);
		myJInternalFrame.setResizable(true);
		myJInternalFrame.setMaximizable(true);
		myJInternalFrame.setClosable(true);
		myJInternalFrame.setSize(580, 480);
		desktopPane.add(myJInternalFrame);
	}
}