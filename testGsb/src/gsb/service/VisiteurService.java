package gsb.service;

import java.util.ArrayList;

import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteurDao;


/**
 * Cette classe fournit des services liés à l'entité Visiteur.
 */

public class VisiteurService {

	public static Visiteur rechercherVisiteur(String unCodeVisiteur) {

		Visiteur unVisiteur = null;
		try {
			if (unCodeVisiteur == null) {
				throw new Exception("Donnée obligatoire : code");
			}
			unVisiteur = VisiteurDao.rechercher(unCodeVisiteur);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return unVisiteur;
	}
	
	
    /**
     * Retourne une collection de tous les visiteurs.
     * @return Une liste d'instances de la classe Visiteur.
     */
	
	public static ArrayList<Visiteur> collectionDesVisiteurs() {

		ArrayList<Visiteur> collectionDesVisiteurs = new ArrayList<Visiteur>();
		try {
			collectionDesVisiteurs = VisiteurDao.retournerCollectionDesVisiteurs();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return collectionDesVisiteurs;
	}

	public static int creerVisiteur(Visiteur unVisiteur) {
		int result = 0;
		try {
			if (unVisiteur == null) {
				throw new Exception("Donnée obligatoire : unVisiteur");
			}
			result = VisiteurDao.creer(unVisiteur);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public static int supprimerVisiteurs(String unCodeVisiteur) {

		int result = 0;
		try {
			if (unCodeVisiteur == null) {
				throw new Exception("Donnée obligatoire : unCodeVisiteur");
			}
			result = VisiteurDao.supprimer(unCodeVisiteur);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
}
