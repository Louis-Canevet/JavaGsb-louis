package gsb.service;

import java.util.ArrayList;

import gsb.modele.Localite;
import gsb.modele.dao.LocaliteDao;


/**
 * Cette classe fournit des services liés à l'entité Localite.
 */

public class LocaliteService {

	
    /**
     * Recherche une localité en fonction du code postal.
     * @param unCodeLocalite Le code postal de la localité à rechercher.
     * @return Une instance de la classe Localite correspondant à la recherche, ou null si non trouvée.
     */
	
	public static Localite rechercherLocalite(String unCodeLocalite) {
		Localite uneLocalite = null;
		try {
			if (unCodeLocalite == null) {
				throw new Exception("Donnée obligatoire : code");
			}
			uneLocalite = LocaliteDao.rechercher(unCodeLocalite);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return uneLocalite;
	}
	
    /**
     * Retourne une liste de tous les codes postaux présents dans la table LOCALITE.
     * @return Une ArrayList<String> contenant les codes postaux.
     */
    public static ArrayList<String> retournerListeCodePostaux() {
        return LocaliteDao.retournerListeCodePostaux();
    }
}
