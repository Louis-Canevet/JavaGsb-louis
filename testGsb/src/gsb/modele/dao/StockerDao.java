package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;

public class StockerDao {

	public static Stocker rechercher(String codeStock) {

		Visiteur unVisiteur = null;
		Medicament unMedicament = null;
		Stocker unStock = null;

		ResultSet reqSelection = ConnexionMySql
				.execReqSelection("select * from STOCKER where CODESTOCK ='" + codeStock + "'");
		try {

			if (reqSelection.next()) {

				unVisiteur = VisiteurDao.rechercher(reqSelection.getString(3));
				unMedicament = MedicamentDao.rechercher(reqSelection.getString(4));
				unStock = new Stocker(reqSelection.getInt(1), reqSelection.getInt(2), unVisiteur, unMedicament);

			}
			;
		} catch (Exception e) {

			System.out.println("erreur reqSelection.next() pour la requete - select * from STOCKER where CODESTOCK ='"
					+ codeStock + "'");
			e.printStackTrace();
		}

		ConnexionMySql.fermerConnexionBd();
		return unStock;
	}

	public static ArrayList<Stocker> retournerCollectionDesStock() {

		ArrayList<Stocker> collectionDesStock = new ArrayList<Stocker>();

		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from STOCKER");
		try {

			while (reqSelection.next()) {
				String codeStock = reqSelection.getString(1);
				collectionDesStock.add(StockerDao.rechercher(codeStock));
			}
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesStock()");
		}
		ConnexionMySql.fermerConnexionBd();
		return collectionDesStock;
	}

	public static int updateStock(String newStock, String matricule, String medDepotLegal) {
		int result = 0;
		String reqSelection = "update STOCKER set QTESTOCK = QTESTOCK + '" + Integer.parseInt(newStock)
				+ "' where MATRICULE = '" + matricule + "' and MED_DEPOTLEGAL = '" + medDepotLegal + "'";

		try {
			result = ConnexionMySql.execReqMaj(reqSelection);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("erreur updateStock()");
		}

		ConnexionMySql.fermerConnexionBd();
		return result;

	}

	public static int creer(Stocker unStock) {
		int result = 0;
		String requeteInsertion;
		int qteStock = unStock.getQteStock();
		String matricule = unStock.getUnVisiteur().getMatricule();
		String depotLegal = unStock.getUnMedicament().getDepotLegal();

		requeteInsertion = "insert into STOCKER (`QTESTOCK`, `MATRICULE`, `MED_DEPOTLEGAL`) values('" + qteStock
				+ "', '" + matricule + "', '" + depotLegal + "')";

		try {
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		} catch (Exception e) {
			System.out.println("Erreur dans la création du Stock.");
			e.printStackTrace();
		}

		ConnexionMySql.fermerConnexionBd();
		return result;
	}

	public static int supprimer(String codeStock) {
		int result = 0;
		String requeteSuppression = "delete from STOCKER where CODESTOCK = '" + Integer.parseInt(codeStock) + "'";
		try {
			result = ConnexionMySql.execReqMaj(requeteSuppression);
		} catch (Exception e) {
			System.out.println("Erreur dans le suppression du Stock.");
			e.printStackTrace();
		}

		ConnexionMySql.fermerConnexionBd();
		return result;
	}

}
