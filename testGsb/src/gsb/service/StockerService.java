package gsb.service;

import java.util.ArrayList;

import gsb.modele.Stocker;
import gsb.modele.dao.StockerDao;

public class StockerService {

	public static Stocker rechercherStock(String unCodeStock) {

		Stocker unStock = null;

		try {
			if (unCodeStock == null) {

				throw new Exception("Donnée obligatoire : code");
			}
			unStock = StockerDao.rechercher(unCodeStock);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		return unStock;
	}

	public static ArrayList<Stocker> collectionDesStocks() {

		ArrayList<Stocker> collectionDesStocks = new ArrayList<Stocker>();

		try {
			collectionDesStocks= StockerDao.retournerCollectionDesStock();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		return collectionDesStocks;
	}

	public static int updateStocks(String newStock, String matricule, String medDepotLegal) {
		int result = 0;
		try {
			if(newStock == null || matricule == null || medDepotLegal == null) {
				throw new Exception("Donnée obligatoire : matricule & depotLegal");
			}
			result = StockerDao.updateStock(newStock, matricule, medDepotLegal);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}
	
	public static int creerStocks(Stocker unStock) {
		int result = 0;
		try {
			if (unStock == null) {
				throw new Exception("Donnée obligatoire : unStock");
			}
			result = StockerDao.creer(unStock);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		return result;
	}

	public static int supprimerStocks(String codeStock) {

		int result = 0;

		try {
			if (codeStock == null) {
				throw new Exception("Donnée obligatoire : unCodeStock");
			}
			result = StockerDao.supprimer(codeStock);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
}
