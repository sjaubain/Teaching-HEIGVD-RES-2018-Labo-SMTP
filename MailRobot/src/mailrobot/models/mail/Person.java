
package mailrobot.models.mail;

/**
 *
 * @author Lagha Oussama - Jobin Simon
 */
public class Person {
    private String nom;
    private String prenom;
    private String mail;

    public Person(String nom, String prenom, String mail) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
    }
    public Person(String mail){
        this.mail=mail;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
