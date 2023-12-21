package gsb.modele.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * La classe ConnexionMySql fournit des méthodes pour établir une connexion à une base de données MySQL,
 * exécuter des requêtes de sélection et de mise à jour, ainsi que fermer la connexion.
 * Elle utilise JDBC pour interagir avec la base de données.
 */

public class ConnexionMySql {

	private static Connection cnx;
    public static Connection getConnection() {
        if (cnx == null) {
            connecterBd();
        }
        return cnx;
    }

	public static void connecterBd() {
		String url = "jdbc:mysql://127.0.0.1:3306/gsbJava";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cnx = DriverManager.getConnection(url, "root", "");
		} catch (Exception e) {
			System.out.println("Echec lors de la connexion");
			e.printStackTrace();
		}
	}

	public static ResultSet execReqSelection(String laRequete) {
		connecterBd();
		ResultSet resultatReq = null;
		try {
			Statement requete = cnx.createStatement();
			resultatReq = requete.executeQuery(laRequete);
		} catch (Exception e) {
			System.out.println("Erreur requete : " + laRequete);
		}
		return resultatReq;
	}

	public static int execReqMaj(String laRequete) {

		connecterBd();
		int nbMaj = 0;
		try {
			Statement s = cnx.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			nbMaj = s.executeUpdate(laRequete);
			s.close();
		} catch (Exception er) {
			er.printStackTrace();
			System.out.println("echec requ�te : " + laRequete);
		}
		return nbMaj;
	}

	public static void fermerConnexionBd() {
		try {
			cnx.close();
		} catch (Exception e) {
			System.out.println("Erreur sur fermeture connexion");
		}
	}
}
