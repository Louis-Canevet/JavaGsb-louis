package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gsb.modele.Medicament;


/**
 * Cette classe gère l'accès aux données pour l'entité Medicament dans la base de données.
 */

public class MedicamentDao {

	public static Medicament rechercher(String codeMedicament) {

		Medicament unMedicament = null;
		ResultSet reqSelection = ConnexionMySql
				.execReqSelection("select * from MEDICAMENT where MED_DEPOTLEGAL ='" + codeMedicament + "'");
		try {
			if (reqSelection.next()) {
				unMedicament = new Medicament(reqSelection.getString(1), reqSelection.getString(2),
						reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(5),
						reqSelection.getFloat(6), reqSelection.getString(7), reqSelection.getString(8));
			};
		} catch (Exception e) {
			System.out.println(
					"erreur reqSelection.next() pour la requete - select * from MEDICAMENT where MED_DEPOTLEGAL -='"
							+ codeMedicament + "'");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return unMedicament;
	}

	public static Medicament rechercherFamille(String codeFamille) {

		Medicament unMedicament = null;
		ResultSet reqSelection = ConnexionMySql
				.execReqSelection("select * from MEDICAMENT where FAM_CODE ='" + codeFamille + "'");
		try {
			if (reqSelection.next()) {
				unMedicament = new Medicament(reqSelection.getString(1), reqSelection.getString(2),
						reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(5),
						reqSelection.getFloat(6), reqSelection.getString(7), reqSelection.getString(8));
			};
		} catch (Exception e) {
			System.out.println("erreur reqSelection.next() pour la requete - select * from MEDICAMENT where FAM_CODE ='"
					+ codeFamille + "'");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return unMedicament;
	}

	public static ArrayList<Medicament> retournerCollectionDesMedicament() {

		ArrayList<Medicament> collectionDesMedicament = new ArrayList<Medicament>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select MED_DEPOTLEGAL from MEDICAMENT");
		try {
			while (reqSelection.next()) {
				String codeMedicament = reqSelection.getString(1);
				collectionDesMedicament.add(MedicamentDao.rechercher(codeMedicament));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesMedicament()");
		}
		return collectionDesMedicament;
	}

	public static int creer(Medicament unMedicament) {

		int result = 0;
		String requeteInsertion;
		String depotLegal = unMedicament.getDepotLegal();
		String nomCommercial = unMedicament.getNomCommercial();
		String composition = unMedicament.getComposition();
		String effets = unMedicament.getEffets();
		String contreIndication = unMedicament.getContreIndication();
		float prix = unMedicament.getPrixEchantillon();
		String codeFamille = unMedicament.getCodeFamille();
		String libelleFamille = unMedicament.getLibelleFamille();

		requeteInsertion = "insert into MEDICAMENT values('" + depotLegal + "', '" + nomCommercial + "', '"
				+ composition + "', '" + effets + "', '" + contreIndication + "', '" + prix + "', '" + codeFamille
				+ "', '" + libelleFamille + "')";
		try {
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		} catch (Exception e) {
			System.out.println("Erreur dans la création du Médicament.");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return result;
	}

	public static int supprimer(String codeMedicament) {
	
		int result = 0;
		String requeteSuppression = "delete from MEDICAMENT where MED_DEPOTLEGAL ='" + codeMedicament + "'";
		try {
			result = ConnexionMySql.execReqMaj(requeteSuppression);
		} catch (Exception e) {
			System.out.println("Erreur dans le suppression du Médicament.");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return result;
	}
}
