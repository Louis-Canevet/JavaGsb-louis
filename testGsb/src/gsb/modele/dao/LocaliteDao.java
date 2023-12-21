package gsb.modele.dao;

import gsb.modele.Localite;
import java.sql.ResultSet;


/**
 * Cette classe gère l'accès aux données pour l'entité Localite dans la base de données.
 */
public class LocaliteDao {

	/**
     * Recherche une localité dans la base de données en fonction du code postal.
     * @param codeLocalite Le code postal de la localité à rechercher.
     * @return Une instance de la classe Localite correspondant à la recherche, ou null si non trouvée.
     */
	public static Localite rechercher(String codeLocalite) {

		Localite uneLocalite = null;
		ResultSet reqSelection = ConnexionMySql
				.execReqSelection("select * from LOCALITE where CODEPOSTAL='" + codeLocalite + "'");
		try {
			if (reqSelection.next()) {
				uneLocalite = new Localite(reqSelection.getString(1), reqSelection.getString(2));
			};
		} catch (Exception e) {
			System.out.println("erreur reqSelection.next() pour la requ�te - select * from LOCALITE where CODEPOSTAL='"
					+ codeLocalite + "'");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return uneLocalite;
	}

    public static java.util.ArrayList<String> retournerListeCodePostaux() {
        java.util.ArrayList<String> codesPostaux = new java.util.ArrayList<>(); // ArrayList de java.util
        try {
            String requete = "select CODEPOSTAL from LOCALITE";
            ResultSet result = ConnexionMySql.execReqSelection(requete);

            while (result.next()) {
                codesPostaux.add(result.getString("CODEPOSTAL"));
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération des codes postaux");
            e.printStackTrace();
        } finally {
            ConnexionMySql.fermerConnexionBd();
        }
        return codesPostaux;
    }
}
