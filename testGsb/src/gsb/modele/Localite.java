package gsb.modele;

/**
 * Classe représentant une localité avec son code postal et sa ville.
 * Setter et getter.
 */
public class Localite {

    protected String codePostal;
    protected String ville;

    public Localite(String codePostal, String ville) {
        // Vérifier que le code postal a une longueur de 5 caractères
        if (codePostal != null && codePostal.length() == 5) {
            this.codePostal = codePostal;
        } else {
            // lever une exception
            throw new IllegalArgumentException("Erreur : Le code postal doit avoir une longueur de 5 caractères.");
        }
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        // Vérifier que le code postal a une longueur de 5 caractères
        if (codePostal != null && codePostal.length() == 5) {
            this.codePostal = codePostal;
        } else {
            // Vous pouvez également lever une exception ou prendre d'autres mesures selon vos besoins.
            throw new IllegalArgumentException("Erreur : Le code postal doit avoir une longueur de 5 caractères.");
        }
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
