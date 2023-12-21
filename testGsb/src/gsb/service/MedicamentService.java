package gsb.service;

import java.util.ArrayList;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;


/**
 * Cette classe fournit des services liés à l'entité Medicament.
 */

public class MedicamentService {

	public static Medicament rechercherMedicament(String unCodeMedicament) {

		Medicament unMedicament = null;
		try {
			if (unCodeMedicament == null) {
				throw new Exception("Donnée obligatoire : code");
			}
			unMedicament = MedicamentDao.rechercher(unCodeMedicament);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return unMedicament;
	}

	public static Medicament rechercherFamilleMed(String codeFamille) {
		
		Medicament unMedicament = null;
		try {
			if (codeFamille == null) {
				throw new Exception("Donnée obligatoire : codeFamille");
			}
			unMedicament = MedicamentDao.rechercherFamille(codeFamille);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return unMedicament;
	}

	
    /**
     * Retourne une collection de tous les médicaments.
     * @return Une liste d'instances de la classe Medicament.
     */
	
	public static ArrayList<Medicament> collectionDesMedicaments() {

		ArrayList<Medicament> collectionDesMedicaments = new ArrayList<Medicament>();
		try {
			collectionDesMedicaments = MedicamentDao.retournerCollectionDesMedicament();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return collectionDesMedicaments;
	}

	public static int creerMedicament(Medicament unMedicament) {
		int result = 0;
		try {
			if (unMedicament == null) {
				throw new Exception("Donnée obligatoire : unMedicament");
			}
			result = MedicamentDao.creer(unMedicament);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public static int supprimer(String unCodeMedicament) {

		int result = 0;
		try {
			if (unCodeMedicament == null) {
				throw new Exception("Donnée obligatoire : unCodeMedicament");
			}
			result = MedicamentDao.supprimer(unCodeMedicament);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
}
