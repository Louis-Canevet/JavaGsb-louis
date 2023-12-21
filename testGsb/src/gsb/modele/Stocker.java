package gsb.modele;


/**
 * Classe représentant un codeStock, une qteStock, unVisiteur, unMedicament.
 * setter and getter.
 */
public class Stocker {

	protected int codeStock;
	protected int qteStock;
	protected Visiteur unVisiteur;
	protected Medicament unMedicament;

	public Stocker() {

	}

	public Stocker(int codeStock, int qteStock, Visiteur unVisiteur, Medicament unMedicament) {
		this.codeStock = codeStock;
		this.qteStock = qteStock;
		this.unVisiteur = unVisiteur;
		this.unMedicament = unMedicament;
	}
	
	public Stocker(int qteStock, Visiteur unVisiteur, Medicament unMedicament) {
		this.qteStock = qteStock;
		this.unVisiteur = unVisiteur;
		this.unMedicament = unMedicament;
	}

	
	public int getCodeStock() {
		return codeStock;
	}

	public void setCodeStock(int codeStock) {
		this.codeStock = codeStock;
	}

	public int getQteStock() {
		return qteStock;
	}

	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}

	public Visiteur getUnVisiteur() {
		return unVisiteur;
	}

	public void setUnVisiteur(Visiteur unVisiteur) {
		this.unVisiteur = unVisiteur;
	}

	public Medicament getUnMedicament() {
		return unMedicament;
	}

	public void setUnMedicament(Medicament unMedicament) {
		this.unMedicament = unMedicament;
	}

}
