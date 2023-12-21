package gsb.modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gsb.modele.Localite;
import gsb.modele.Visiteur;


/**
 * Cette classe gère l'accès aux données pour l'entité Visiteur dans la base de données.
 */

public class VisiteurDao {

	public static Visiteur rechercher(String codeVisiteur) {

		Visiteur unVisiteur = null;
		Localite uneLocalite = null;

		ResultSet reqSelection = ConnexionMySql
				.execReqSelection("select * from VISITEUR where MATRICULE ='" + codeVisiteur + "'");
		try {

			if (reqSelection.next()) {
				
				uneLocalite = LocaliteDao.rechercher(reqSelection.getString(7));
				unVisiteur = new Visiteur(reqSelection.getString(1), reqSelection.getString(2),
						reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(5),
						reqSelection.getString(6), uneLocalite, reqSelection.getString(8), reqSelection.getString(9),
						reqSelection.getInt(10), reqSelection.getString(11), reqSelection.getString(12));
			}
			;
		} catch (Exception e) {

			System.out.println("erreur reqSelection.next() pour la requete - select * from VISITEUR where MATRICULE ='"
					+ codeVisiteur + "'");
			e.printStackTrace();
		}

		ConnexionMySql.fermerConnexionBd();
		return unVisiteur;
	}

	public static ArrayList<Visiteur> retournerCollectionDesVisiteurs() {

		ArrayList<Visiteur> collectionDesVisiteurs = new ArrayList<Visiteur>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select MATRICULE from VISITEUR");
		try {
			while (reqSelection.next()) {
				String codeVisiteur = reqSelection.getString(1);
				collectionDesVisiteurs.add(VisiteurDao.rechercher(codeVisiteur));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur lors de la récupération de la collection des visiteurs - CollectionDesVisiteur()");
		} finally {
			// fermer le ResultSet apre utilisation
			if(reqSelection != null) {
				try {
					reqSelection.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return collectionDesVisiteurs;
	}

	public static int creer(Visiteur unVisiteur) {

		int result = 0;
		String requeteInsertion;
		String matricule = unVisiteur.getMatricule();
		String nom = unVisiteur.getNom();
		String prenom = unVisiteur.getPrenom();
		String login = unVisiteur.getLogin();
		String mdp = unVisiteur.getMdp();
		String adresse = unVisiteur.getAdresse();
		String codePostal = unVisiteur.getUneLocalite().getCodePostal();
		String telephone = unVisiteur.getTelephone();
		String dateEntree = unVisiteur.getDateEntree();
		int prime = unVisiteur.getPrime();
		String codeUnite = unVisiteur.getCodeUnite();
		String nomUnite = unVisiteur.getNomUnite();

		requeteInsertion = "insert into VISITEUR values('" + matricule + "', '" + nom + "', '" + prenom + "', '" + login
				+ "', '" + mdp + "', '" + adresse + "', '" + codePostal + "', '" + telephone + "', '" + dateEntree
				+ "', '" + prime + "', '" + codeUnite + "', '" + nomUnite + "')";

		try {
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		} catch (Exception e) {
			System.out.println("Erreur dans la création du Visiteur.");
			e.printStackTrace();
		}

		ConnexionMySql.fermerConnexionBd();
		return result;
	}


	public static int supprimer(String codeVisiteur) {
		int result = 0;
		String requeteSuppression = "delete from VISITEUR where MATRICULE ='"+codeVisiteur+"'";
		try {
			result = ConnexionMySql.execReqMaj(requeteSuppression);
		}catch(Exception e) {
			System.out.println("Erreur dans la suppression du visiteur");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return result;
	}

}
